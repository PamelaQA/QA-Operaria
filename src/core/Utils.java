package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.logging.*;

public class Utils {

    public static void logAction(String message) {
        try {
            File logDir = new File("logs");
            if (!logDir.exists()) logDir.mkdirs();
            String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            BufferedWriter writer = new BufferedWriter(new FileWriter("logs/execution_log_" + today + ".txt", true));
            String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
            writer.write("[" + timestamp + "] " + message);
            writer.newLine();
            writer.close();
            System.out.println("[" + timestamp + "] " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void typeWithDelay(WebElement element, String text, double delayInSeconds) {
        double adjustedDelay = Math.min(delayInSeconds, 0.05);
        for (char c : text.toCharArray()) {
            element.sendKeys(Character.toString(c));
            sleep(adjustedDelay);
        }
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        try {
            ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            sleep(2);
        } catch (Exception ignored) {}
    }

    public static void clickButtonByXPath(WebDriver driver, WebDriverWait wait, String xpath, String actionDescription) {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            scrollToElement(driver, button);
            sleep(1);
            button.click();
            sleep(0.5);
            logAction("Acción: " + actionDescription);
        } catch (Exception e) {
            logAction("Error en acción: " + actionDescription + " -> " + e.getMessage());
        }
    }

    public static void writeInTextBox(WebDriver driver, WebDriverWait wait, String xpath, String text, String actionDescription) {
        try {
            WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            scrollToElement(driver, textBox);
            try { textBox.clear(); } catch (Exception ignored) {}
            textBox.sendKeys(Keys.CONTROL + "a");
            textBox.sendKeys(Keys.DELETE);
            if (!textBox.getAttribute("value").isEmpty()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", textBox);
            }
            typeWithDelay(textBox, text, 0.2);
            sleep(0.5);
            logAction("Acción: " + actionDescription + " - Texto: " + text);
        } catch (Exception e) {
            logAction("Error escribiendo en: " + actionDescription + " -> " + e.getMessage());
        }
    }

    public static void pressEscape(WebDriver driver) {
        new org.openqa.selenium.interactions.Actions(driver)
            .sendKeys(Keys.ESCAPE).perform();
        sleep(0.5);
    }

    public static void scheduleBrowserClose(WebDriver driver, long delayInSeconds) {
        new Thread(() -> {
            sleep(delayInSeconds);
            logAction("Cerrando navegador tras " + delayInSeconds + " segundos");
            driver.quit();
        }).start();
    }

    public static void extractAndSaveBrowserLogs(WebDriver driver) {
        try {
            LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
            String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            BufferedWriter writer = new BufferedWriter(new FileWriter("logs/browser_logs_" + today + ".txt"));
            for (LogEntry entry : logs) {
                writer.write(String.format("[%s] [%s] %s",
                        new Date(entry.getTimestamp()), entry.getLevel(), entry.getMessage()));
                writer.newLine();
            }
            writer.close();
            logAction("Guardados logs del navegador en browser_logs_" + today + ".txt");
        } catch (IOException e) {
            logAction("Error guardando browser logs: " + e.getMessage());
        }
    }
}
