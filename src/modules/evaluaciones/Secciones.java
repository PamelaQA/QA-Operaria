package modules.evaluaciones;

import core.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static core.Utils.*;

public class Secciones {
    public static void interactWithDashboard(WebDriver driver, WebDriverWait wait) {
        try {
            Utils.logAction("Ejecutando módulo: Secciones");

            // ----------BIBLIOTECA DE SECCIONES----------
            clickButtonByXPath(driver, wait,
                    "//*[@id='root']/div/div[2]/div[2]/div/main/div[2]/div/div[4]/div/div/div/div[1]/img",
                    "Clic en Gestión de evaluaciones");

            clickButtonByXPath(driver, wait,
                    "//*[@id='rc-tabs-0-panel-1']/div[1]/div/div[2]",
                    "Ir a Biblioteca de secciones");

            // ----------CREAR NUEVA SECCIÓN----------
            clickButtonByXPath(driver, wait,
                    "//*[@id='rc-tabs-0-panel-1']/div[2]/div[1]/button/span[2]",
                    "Crear nueva sección");

            writeInTextBox(driver, wait, "//*[@id='id_nameSection']",
                    "Sección de prueba", "Nombre de la sección");

            writeInTextBox(driver, wait, "//*[@id='id_nameId']",
                    "Primera sección de test", "Nombre identificativo");

            writeInTextBox(driver, wait, "//*[@id='id_instructions']",
                    "Instrucciones automáticas", "Instrucciones");

            // ----------SELECCIONAR PREGUNTAS DE FORMA CONTINUA----------
            seleccionarPreguntasContinuas(driver, wait, 4, 6);

            // ----------AGREGAR Y CONFIRMAR SECCIÓN----------
            clickButtonByXPath(driver, wait,
                    "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[5]/div[1]/div/div[1]/div/div/div[2]/button[1]",
                    "Agregando sección");

            clickButtonByXPath(driver, wait,
                    "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[6]/div/div/div/div/button/span",
                    "Confirmar sección");

            clickButtonByXPath(driver, wait,
                    "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/div[8]/div/div/div/div/button/span",
                    "Confirmar x2");

            Utils.logAction("Flujo de Secciones completado con selección continua de preguntas.");
        } catch (Exception e) {
            Utils.logAction("Error en Secciones: " + e.getMessage());
        }
    }

    // ----------FUNCIÓN AUXILIAR: SELECCIONA PREGUNTAS CONTINUAS----------
    private static void seleccionarPreguntasContinuas(WebDriver driver, WebDriverWait wait, int inicio, int fin) {
        try {
            for (int i = inicio; i <= fin; i++) {
                String xpath = String.format(
                        "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[5]/div[1]/div/div[1]/div/div/div[1]/div[2]/ul/li[%d]",
                        i);
                clickButtonByXPath(driver, wait, xpath, "Seleccionando pregunta #" + i);
                sleep(0.4);
            }

            Utils.logAction("Preguntas seleccionadas de forma continua: " + inicio + " a " + fin);
        } catch (Exception e) {
            Utils.logAction("Error al seleccionar preguntas continuas: " + e.getMessage());
        }
    }
}
