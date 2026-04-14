package modules.evaluaciones;

import core.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.Utils.*;

public class Evaluaciones {

    public static void interactWithDashboard(WebDriver driver, WebDriverWait wait) {
        try {
            Utils.logAction("Ejecutando módulo: Evaluaciones");

            abrirModulo(driver, wait);
            informacionBasica(driver, wait);
            configurarSecciones(driver, wait);
            configurarVisualizacion(driver, wait);
            configurarPersonal(driver, wait);
            configurarPonderaciones(driver, wait);
            configurarConsideraciones(driver, wait);
            configurarRetroalimentacion(driver, wait);
            configurarEnlazamiento(driver, wait);
            guardarEvaluacion(driver, wait);

            Utils.logAction("Flujo de Evaluaciones completado.");
        } catch (Exception e) {
            Utils.logAction("Error en Evaluaciones: " + e.getMessage());
        }
    }

    private static void abrirModulo(WebDriver driver, WebDriverWait wait) {
        step(driver, wait,
                "//*[@id=\"root\"]/div/div/div[2]/div/main/div[2]/div/div[4]/div/div/div/div[1]",
                "Clic en Gestión de evaluaciones");

        step(driver, wait,
                "//*[@id=\"rc-tabs-0-panel-1\"]/div[1]/div/div[4]/div/div/div/div/div/p[1]",
                "Ir a Biblioteca de evaluaciones");

        step(driver, wait,
                "//*[contains(text(),'Crear nueva evaluación') or contains(text(),'Crear nueva evaluacion')]",
                "Crear nueva evaluación");
    }

    private static void informacionBasica(WebDriver driver, WebDriverWait wait) {
        step(driver, wait,
                "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div[1]/div/div[2]/button/span",
                "Configurando información básica");

        type(driver, wait, "//*[@id='name_id']",
                "Evaluación sindicalizada automatizada",
                "Nombre de la evaluación");

        step(driver, wait,
                "//*[@id='idTypeCategory']",
                "Desplegando categoría");

        step(driver, wait,
                "/html/body/div[4]/div/div/div[2]/div/div/div/div[1]/div",
                "Seleccionando categoría");

        type(driver, wait, "//*[@id='description']",
                "Responda la evaluación según los criterios que indicó su supervisor",
                "Instrucciones para la evaluación");

        step(driver, wait,
                "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/button",
                "Guardando información básica");

        step(driver, wait,
                "/html/body/div[5]/div/div[2]/div/div[1]/div/div[2]/form/button",
                "Confirmando información básica");
    }

    private static void configurarSecciones(WebDriver driver, WebDriverWait wait) {
        step(driver, wait,
                "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[2]/button/span",
                "Configurar secciones");

        step(driver, wait,
                "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/div/div/div[2]/div/div/div/div[1]/div[2]/ul/li[2]/label/span",
                "Seleccionando sección");

        step(driver, wait,
                "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/div/div/div[2]/div/div/div/div[2]/button[1]/span/span",
                "Seleccionar sección");

        step(driver, wait,
                "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/button",
                "Guardar sección");
    }

    private static void configurarVisualizacion(WebDriver driver, WebDriverWait wait) {
        step(driver, wait,
                "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div[3]/div/div[2]/button/span",
                "Configurar visualización");

        step(driver, wait,
                "//*[@id='view_type']/label[2]",
                "Evaluación tipo paginada");

        step(driver, wait,
                "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/button/span",
                "Confirmar visualización");
    }

    private static void configurarPersonal(WebDriver driver, WebDriverWait wait) {
        step(driver, wait,
                "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div[4]/div/div[2]/button/span",
                "Configurar personal a evaluar");

        step(driver, wait, "//*[@id='idCriteriaConsider']/label[3]/span[1]", "Evaluación 360");
        step(driver, wait, "//*[@id='idTargetGroups']/label[1]/span[1]", "Todos los subordinados");
        step(driver, wait, "//*[@id='idTargetGroups']/label[2]/span[1]", "Todos los pares");
        step(driver, wait, "//*[@id='idTargetGroups']/label[3]/span[1]", "Todos los clientes");

        step(driver, wait,
                "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/button/span",
                "Confirmar personal a evaluar");
    }

    private static void configurarPonderaciones(WebDriver driver, WebDriverWait wait) {
        step(driver, wait,
                "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div[5]/div/div[2]/button/span",
                "Configurar ponderaciones");

        step(driver, wait,
                "//*[@id='cuantitativeType']/label[2]/span[1]",
                "Seleccionando evaluación cualitativa");

        step(driver, wait,
                "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/button/span",
                "Guardar ponderaciones");
    }

    private static void configurarConsideraciones(WebDriver driver, WebDriverWait wait) {
        step(driver, wait,
                "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div[6]/div/div[2]/button",
                "Configurar consideración de categoría");

        step(driver, wait,
                "//*[@id='radioTimeCriteria']/label[2]/span[1]",
                "Fechas determinadas");

        step(driver, wait,
                "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/div[2]/div/div/div/div/div/div/span/span[1]",
                "Desplegando periodo");

        step(driver, wait,
                "/html/body/div[4]/div/div/div[2]/div/div/div/div[1]",
                "Periodo Anual");

        step(driver, wait,
                "//*[@id='date_consideration']/label[2]/span[1]",
                "Consideración de tiempo (Periodo anterior)");

        step(driver, wait,
                "//*[@id='applyCategoryChange']/span",
                "Aplica cambio de categoría");

        step(driver, wait,
                "//*[@id='needsVoBo']/div",
                "Aplica VoBo");

        step(driver, wait,
                "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/button/span",
                "Confirmar consideraciones");
    }

    private static void configurarRetroalimentacion(WebDriver driver, WebDriverWait wait) {
        step(driver, wait,
                "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div[7]/div/div[2]/button/span",
                "Configurar retroalimentación");

        step(driver, wait,
                "//*[@id='idFeedbacks']/label[6]",
                "Seleccionando comentarios del jefe directo");

        step(driver, wait,
                "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/button/span",
                "Confirmar retroalimentación");
    }

    private static void configurarEnlazamiento(WebDriver driver, WebDriverWait wait) {
        step(driver, wait,
                "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div[8]/div/div[2]/button/span",
                "Configurar enlazamiento de evaluación");

        step(driver, wait,
                "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/div[1]/div/div[2]/div/div/div/div/span",
                "Desplegar listado de evaluaciones");

        step(driver, wait,
                "/html/body/div[5]/div/div/div[2]/div/div/div",
                "Seleccionando evaluación");

        step(driver, wait,
                "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/button",
                "Confirmar enlazamiento");
    }

    private static void guardarEvaluacion(WebDriver driver, WebDriverWait wait) {
        step(driver, wait,
                "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/button/span",
                "Generando evaluación");
    }

    private static void step(WebDriver driver, WebDriverWait wait, String xpath, String descripcion) {
        clickButtonByXPath(driver, wait, xpath, descripcion);
    }

    private static void type(WebDriver driver, WebDriverWait wait, String xpath, String text, String descripcion) {
        try {
            WebElement element = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(text);
            Utils.logAction(descripcion);
        } catch (Exception e) {
            Utils.logAction("Error escribiendo " + descripcion + ": " + e.getMessage());
        }
    }
}