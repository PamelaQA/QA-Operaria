package common;

import core.Config;
import core.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginActions {

    public static void login(WebDriver driver, WebDriverWait wait) {
        try {
            // --- Campo de usuario ---
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"payrollNumber\"]")));
            Utils.typeWithDelay(emailField, Config.USER, 0.2);
            Utils.sleep(0.5);

            // --- Campo de contraseña ---
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"password\"]")));
            Utils.typeWithDelay(passwordField, Config.PASSWORD, 0.25);
            Utils.sleep(0.5);

            // --- Botón de iniciar sesión ---
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div/form/button/span")));
            signInButton.click();
            Utils.sleep(0.5);

            // --- Esperar redirección ---
            wait.until(ExpectedConditions.urlContains("dashboard"));
            Utils.logAction("Inicio de sesión exitoso con usuario: " + Config.USER);

        } catch (Exception e) {
            Utils.logAction("Error durante el login: " + e.getMessage());
        }
    }
}
