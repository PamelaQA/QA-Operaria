package modules.evaluaciones;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static core.Utils.*;

public class NineBox {

    private static int modoUsuario = 1;

    private static final By TAB_MIS_EVALUACIONES =
            By.xpath("//*[normalize-space()='Mis evaluaciones']");

    private static final By TAB_OTRAS_EVALUACIONES =
            By.xpath("//div[@role='tab' and normalize-space()='Otras evaluaciones']");

    private static final By FILAS_CON_COMENZAR =
            By.xpath("//table//tbody//tr[.//button[.//span[contains(normalize-space(),'Comenzar')]]]");

    private static final By BTN_FINALIZAR =
            By.xpath("//button[.//span[contains(normalize-space(),'Finalizar')]]");

    public static void interactWithDashboard(WebDriver driver, WebDriverWait wait, Scanner scanner) {

        try {

            modoUsuario = seleccionarModo(scanner);

            logAction("Modo seleccionado: " + modoUsuario);
            logAction("Iniciando módulo: Evaluación NineBox");

            Random rand = new Random();

            irAMisEvaluaciones(driver, wait);
            irAOtrasEvaluaciones(driver, wait);

            while (true) {

                List<WebElement> filas = driver.findElements(FILAS_CON_COMENZAR);

                if (filas.isEmpty()) {
                    logAction("No hay más evaluaciones por iniciar.");
                    break;
                }

                WebElement fila = filas.get(0);

                String evaluado = obtenerTextoSeguro(fila, By.xpath("./td[1]"));

                logAction("Evaluando a: " + evaluado);

                WebElement botonComenzar = fila.findElement(
                        By.xpath(".//button[.//span[contains(normalize-space(),'Comenzar')]]")
                );

                clickElement(driver, wait, botonComenzar, "Clic en Comenzar evaluación");

                sleep(1200);

                responderPreguntasPorSeccion(driver, wait, rand);

                clickElement(driver, wait, BTN_FINALIZAR, "Finalizar evaluación");

                logAction("Evaluación finalizada para: " + evaluado);

                sleep(1200);

                irAOtrasEvaluaciones(driver, wait);

                wait.until(ExpectedConditions.invisibilityOfElementLocated(
                        By.xpath("//table//tbody//tr[td[normalize-space()=" + escapeXPath(evaluado) + "]]")
                ));

                logAction("Fila eliminada en Otras evaluaciones");

                sleep(1000);

            }

            logAction("Todas las evaluaciones NineBox respondidas correctamente");

        } catch (Exception e) {

            logAction("Error en NineBox: " + e.getMessage());

        }

    }

    private static int seleccionarModo(Scanner scanner) {

        System.out.println("SELECCIONA EL TIPO DE RESPUESTA PARA NINEBOX");
        System.out.println("1. RESPUESTAS ALEATORIAS");
        System.out.println("2. SIEMPRE / FRECUENTEMENTE");
        System.out.println("3. FRECUENTEMENTE / A VECES");
        System.out.println("4. A VECES / RARA VEZ");
        System.out.println("5. RARA VEZ / NUNCA");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();

        if (opcion < 1 || opcion > 5) {

            System.out.println("Opción inválida. Usando modo aleatorio");

            return 1;

        }

        return opcion;

    }

    public static int obtenerRespuestaSegunModo(int modo, Random rand) {

        return switch (modo) {

            case 1 -> rand.nextInt(5) + 1;

            case 2 -> rand.nextInt(2) + 1;

            case 3 -> rand.nextInt(2) + 2;

            case 4 -> rand.nextInt(2) + 3;

            case 5 -> rand.nextInt(2) + 4;

            default -> rand.nextInt(5) + 1;

        };

    }

    private static void irAMisEvaluaciones(WebDriver driver, WebDriverWait wait) {

        clickElement(driver, wait, TAB_MIS_EVALUACIONES, "Clic en Mis evaluaciones");

    }

    private static void irAOtrasEvaluaciones(WebDriver driver, WebDriverWait wait) {

        clickElement(driver, wait, TAB_OTRAS_EVALUACIONES, "Cambiado a Otras evaluaciones");

        sleep(1000);

    }

    private static void responderPreguntasPorSeccion(WebDriver driver, WebDriverWait wait, Random rand) {

    logAction("Respondiendo preguntas del formulario NineBox");

    try {

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[starts-with(@id,'answer_')]")
        ));

        List<WebElement> preguntas = driver.findElements(
                By.xpath("//div[starts-with(@id,'answer_')]")
        );

        int totalPreguntas = Math.min(16, preguntas.size());

        String[] opcionesTexto = {
                "SIEMPRE",
                "FRECUENTEMENTE",
                "A VECES",
                "RARA VEZ",
                "NUNCA"
        };

        for (int i = 0; i < totalPreguntas; i++) {

            try {

                WebElement pregunta = preguntas.get(i);

                List<WebElement> opciones = pregunta.findElements(By.xpath(".//label"));

                if (opciones.isEmpty()) {
                    continue;
                }

                int opcion = obtenerRespuestaSegunModo(modoUsuario, rand);
                int indice = Math.min(opcion - 1, opciones.size() - 1);

                WebElement opcionElegida = opciones.get(indice);

                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        opcionElegida
                );

                sleep(300);

                try {
                    opcionElegida.click();
                } catch (Exception ex) {
                    ((JavascriptExecutor) driver).executeScript(
                            "arguments[0].click();",
                            opcionElegida
                    );
                }

                logAction("Pregunta " + (i + 1) + ": " + opcionesTexto[indice]);

                sleep(700);

            } catch (Exception e) {

                logAction("No se pudo responder pregunta " + (i + 1));

            }

        }

    } catch (Exception e) {

        logAction("Error respondiendo formulario: " + e.getMessage());

    }
}

    private static WebElement obtenerContenedorSeccion(WebDriver driver, WebDriverWait wait, String categoria) {

        WebElement titulo = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[normalize-space()='" + categoria + "']")
                )
        );

        List<WebElement> contenedores = driver.findElements(
                By.xpath(
                        "//*[normalize-space()='" + categoria + "']/ancestor::div[" +
                                "contains(@class,'ant-card') or " +
                                "contains(@class,'section') or " +
                                "contains(@class,'card') or " +
                                ".//div[starts-with(@id,'answer_')]" +
                                "][1]"
                )
        );

        if (!contenedores.isEmpty()) {

            return contenedores.get(0);

        }

        return titulo.findElement(By.xpath("./ancestor::div[3]"));

    }

    private static void clickElement(WebDriver driver, WebDriverWait wait, By locator, String descripcion) {

        try {

            WebElement element = wait.until(
                    ExpectedConditions.presenceOfElementLocated(locator)
            );

            clickElement(driver, wait, element, descripcion);

        } catch (Exception e) {

            logAction("Error en acción: " + descripcion);

        }

    }

    private static void clickElement(WebDriver driver, WebDriverWait wait, WebElement element, String descripcion) {

        try {

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center'});",
                    element
            );

            sleep(300);

            wait.until(ExpectedConditions.elementToBeClickable(element)).click();

            logAction(descripcion);

        } catch (Exception ex) {

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    element
            );

        }

    }

    private static String obtenerTextoSeguro(WebElement parent, By locator) {

        try {

            return parent.findElement(locator).getText().trim();

        } catch (Exception e) {

            return "";

        }

    }

    private static String escapeXPath(String text) {

        if (!text.contains("'")) {

            return "'" + text + "'";

        }

        if (!text.contains("\"")) {

            return "\"" + text + "\"";

        }

        String[] parts = text.split("'");

        StringBuilder result = new StringBuilder("concat(");

        for (int i = 0; i < parts.length; i++) {

            if (i > 0) {

                result.append(", \"'\", ");

            }

            result.append("'").append(parts[i]).append("'");

        }

        result.append(")");

        return result.toString();

    }

    private static void sleep(long millis) {

        try {

            Thread.sleep(millis);

        } catch (InterruptedException ignored) {

            Thread.currentThread().interrupt();

        }

    }

}