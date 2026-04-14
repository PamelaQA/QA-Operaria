package modules.evaluaciones;

import core.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Scanner;

import static core.Utils.*;

public class Preguntas {

    public static void interactWithDashboard(WebDriver driver, WebDriverWait wait) {
        try {
            Utils.logAction("Ejecutando módulo: Preguntas");

            Scanner scanner = new Scanner(System.in);

            // ----------------- MENÚ EN CONSOLA -----------------
            System.out.println("\nSeleccione el tipo de pregunta a crear:");
            System.out.println("1. Pregunta múltiple");
            System.out.println("2. Pregunta abierta numérica");
            System.out.println("3. Pregunta abierta");
            System.out.println("4. Todas");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            System.out.print("¿Cuántas preguntas desea generar?: ");
            int cantidad = scanner.nextInt();


            // ---------- IR A GESTIÓN DE EVALUACIONES ----------

            clickButtonByXPath(driver, wait,
                    "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[2]/div/div[4]/div/div/div/div[1]/img",
                    "Clic en Gestión de evaluaciones");


            // ---------- GENERADOR DE PREGUNTAS ----------
            for (int i = 1; i <= cantidad; i++) {

                switch (opcion) {

                    case 1:
                        crearPreguntaMultiple(driver, wait, i);
                        break;

                    case 2:
                        crearPreguntaAbiertaNumerica(driver, wait, i);
                        break;

                    case 3:
                        crearPreguntaAbierta(driver, wait, i);
                        break;

                    case 4:
                        crearPreguntaMultiple(driver, wait, i);
                        crearPreguntaAbiertaNumerica(driver, wait, i);
                        crearPreguntaAbierta(driver, wait, i);
                        break;
                }
            }

            Utils.logAction("Flujo de Preguntas completado.");

        } catch (Exception e) {
            Utils.logAction("Error en Preguntas: " + e.getMessage());
        }
    }

    // ============================================================================
    //                        MÉTODO 1: PREGUNTA MÚLTIPLE
    // ============================================================================

    private static void crearPreguntaMultiple(WebDriver driver, WebDriverWait wait, int index) {

        String titulo = "Pregunta automatizada múltiple " + String.format("%02d", index);
        String filePath = "C:\\Users\\USER\\Desktop\\Usuarios\\17.jpg";

        Utils.logAction("Creando " + titulo);

        // ABRIR CREAR PREGUNTA
        clickButtonByXPath(driver, wait, "//*[@id=\"rc-tabs-0-panel-1\"]/div[2]/div[1]/button", "Agregar nueva pregunta");
        clickButtonByXPath(driver, wait, "//*[@id=\"createQuestion\"]/div[2]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando listado");
        clickButtonByXPath(driver, wait, "/html/body/div[3]/div/div/div[2]/div/div/div/div[1]", "Pregunta Múltiple");

        // TITULO
        writeInTextBox(driver, wait, "//*[@id=\"id_questName\"]", titulo, "Título");
        writeInTextBox(driver, wait, "//*[@id=\"id_questInfo\"]", titulo, "Información");

        // IMAGEN PRINCIPAL
        subirImagen(driver, wait, filePath);

        // CALIFICACIÓN
        writeInTextBox(driver, wait, "//*[@id=\"control-hooks_qualification\"]", "10", "Calificación");

        // OPCIÓN 1
        writeInTextBox(driver, wait, "//*[@id=\"id_evOption0\"]", "Opción 1", "Opción 1");
        writeInTextBox(driver, wait, "//*[@id=\"id_weighingOption0\"]", "10", "Peso 1");

        // OPCIÓN 2
        writeInTextBox(driver, wait, "//*[@id=\"id_evOption1\"]", "Opción 2", "Opción 2");
        writeInTextBox(driver, wait, "//*[@id=\"id_weighingOption1\"]", "5", "Peso 2");

        // AGREGAR OPCIÓN
        clickButtonByXPath(driver, wait, "//*[@id=\"createQuestion\"]/div[8]/div/div/div/div/button", "Agregar opción");

        // OPCIÓN 3
        writeInTextBox(driver, wait, "//*[@id=\"id_evOption2\"]", "Opción 3", "Opción 3");
        writeInTextBox(driver, wait, "//*[@id=\"id_weighingOption2\"]", "5", "Peso 3");

        // AJUSTES
        clickButtonByXPath(driver, wait, "//*[@id=\"control-hooks_typeSort\"]/label[1]/span[2]", "Orden por creación");
        clickButtonByXPath(driver, wait, "//*[@id=\"control-hooks_addComments\"]/label[2]/span[2]", "No comentarios");
        clickButtonByXPath(driver, wait, "//*[@id=\"control-hooks_needsEvidences\"]/label[1]/span[1]", "Sí evidencias");

        // GUARDAR
        clickButtonByXPath(driver, wait, "//*[@id=\"createQuestion\"]/div[11]/div/div/div/div/button/span", "Guardar");
        clickButtonByXPath(driver, wait, "/html/body/div[4]/div/div[2]/div/div[1]/div/div[2]/form/div[11]/div/div/div/div/button", "Confirmar");
    }


    // ============================================================================
    //                MÉTODO 2: PREGUNTA ABIERTA NUMÉRICA
    // ============================================================================

    private static void crearPreguntaAbiertaNumerica(WebDriver driver, WebDriverWait wait, int index) {

        String titulo = "Pregunta automatizada abierta numérica " + String.format("%02d", index);
        String filePath = "C:\\Users\\USER\\Desktop\\Usuarios\\17.jpg";

        Utils.logAction("Creando " + titulo);

        // ABRIR CREAR PREGUNTA
        clickButtonByXPath(driver, wait, "//*[@id=\"rc-tabs-0-panel-1\"]/div[2]/div[1]/button", "Agregar nueva pregunta");
        clickButtonByXPath(driver, wait, "//*[@id=\"createQuestion\"]/div[2]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando listado");
        clickButtonByXPath(driver, wait, "/html/body/div[3]/div/div/div[2]/div/div/div/div[2]", "Pregunta Abierta numérica");

        // TITULO
        writeInTextBox(driver, wait, "//*[@id=\"id_questName\"]", titulo, "Título");
        writeInTextBox(driver, wait, "//*[@id=\"id_questInfo\"]", titulo, "Información");

        // IMAGEN
        subirImagen(driver, wait, filePath);

        // OPERADOR
        clickButtonByXPath(driver, wait, "//*[@id=\"createQuestion\"]/div[6]/div/div[2]/div/div/div/div[1]/div/span/span[1]", "Operador");
        clickButtonByXPath(driver, wait, "/html/body/div[4]/div/div/div[2]/div/div/div/div[3]/div", "<=");

        // VALOR
        writeInTextBox(driver, wait, "//*[@id=\"id_openValue\"]", "15", "Valor");

        // UNIDAD
        clickButtonByXPath(driver, wait, "//*[@id=\"createQuestion\"]/div[6]/div/div[2]/div/div/div/div[2]/div/span/span[1]", "Unidad");
        clickButtonByXPath(driver, wait, "/html/body/div[5]/div/div/div[2]/div/div/div/div[1]/div", "-");

        writeInTextBox(driver, wait, "//*[@id=\"id_openUnits\"]", "20", "Unidad de medida");

        // CALIFICACIÓN
        writeInTextBox(driver, wait, "//*[@id=\"control-hooks_qualification\"]", "10", "Calificación");

        clickButtonByXPath(driver, wait, "//*[@id=\"control-hooks_addComments\"]/label[1]/span[1]", "Sí comentarios");
        clickButtonByXPath(driver, wait, "//*[@id=\"control-hooks_needsEvidences\"]/label[2]/span[2]", "Sí evidencias");

        // GUARDAR
        clickButtonByXPath(driver, wait, "//*[@id=\"createQuestion\"]/div[10]/div/div/div/div/button/span", "Guardar");
        clickButtonByXPath(driver, wait, "//*[@id=\"rc-tabs-0-panel-1\"]/div[2]/div[4]/div[2]/div/div[1]/div/div[2]/form/div[9]/div/div/div/div/button/span", "Confirmar");
    }


    // ============================================================================
    //                MÉTODO 3: PREGUNTA ABIERTA
    // ============================================================================

    private static void crearPreguntaAbierta(WebDriver driver, WebDriverWait wait, int index) {

        String titulo = "Pregunta automatizada abierta " + String.format("%02d", index);
        String filePath = "C:\\Users\\USER\\Desktop\\Usuarios\\17.jpg";

        Utils.logAction("Creando " + titulo);

        // ABRIR CREAR PREGUNTA
        clickButtonByXPath(driver, wait, "//*[@id=\"rc-tabs-0-panel-1\"]/div[2]/div[1]/button", "Agregar nueva pregunta");
        clickButtonByXPath(driver, wait, "//*[@id=\"createQuestion\"]/div[2]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando listado");
        clickButtonByXPath(driver, wait, "/html/body/div[3]/div/div/div[2]/div/div/div/div[3]", "Pregunta abierta");

        // TITULO
        writeInTextBox(driver, wait, "//*[@id=\"id_questName\"]", titulo, "Título");
        writeInTextBox(driver, wait, "//*[@id=\"id_questInfo\"]", titulo, "Información");

        // IMAGEN
        subirImagen(driver, wait, filePath);

        // CALIFICACIÓN
        writeInTextBox(driver, wait, "//*[@id=\"control-hooks_qualification\"]", "10", "Calificación");

        // EVIDENCIAS
        clickButtonByXPath(driver, wait, "//*[@id=\"control-hooks_needsEvidences\"]/label[1]/span[1]", "Sí evidencias");

        // GUARDAR
        clickButtonByXPath(driver, wait, "//*[@id=\"createQuestion\"]/div[8]/div/div/div/div/button/span", "Guardar");
        clickButtonByXPath(driver, wait, "/html/body/div[4]/div/div[2]/div/div[1]/div/div[2]/form/div[7]/div/div/div/div/button/span", "Confirmar");
    }



    // ============================================================================
    //                          FUNCIÓN EXTRA: SUBIR IMAGEN
    // ============================================================================
    private static void subirImagen(WebDriver driver, WebDriverWait wait, String filePath) {
        File f = new File(filePath);
        if (!f.exists()) {
            Utils.logAction("❌ Archivo no encontrado: " + filePath);
            return;
        }

        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@type='file']")));
        fileInput.sendKeys(filePath);
        Utils.logAction("Imagen subida correctamente: " + filePath);
    }

}
