package modules.evaluaciones;

import core.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;
import static core.Utils.*;

public class Retroalimentacion {

    public static void interactWithDashboard(WebDriver driver, WebDriverWait wait) {
        try {
            Utils.logAction("Ejecutando módulo: Retroalimentación");

            // ----------BIBLIOTECA DE CAMPOS DE RETROALIMENTACION----------
            clickButtonByXPath(driver, wait,
                    "//*[@id='root']/div/div[2]/div[2]/div/main/div[2]/div/div[4]/div/div/div/div[1]/img",
                    "Clic en Gestión de evaluaciones");

            clickButtonByXPath(driver, wait,
                    "//*[@id='rc-tabs-0-panel-1']/div[1]/div/div[3]/div/div/div/div/div/p[1]",
                    "Ir a Biblioteca de campos de retroalimentación");

            // ----------CREAR NUEVO CAMPO DE RETROALIMENTACIÓN----------
            clickButtonByXPath(driver, wait,
                    "//*[@id='rc-tabs-0-panel-1']/div[2]/div[1]/button",
                    "Nuevo campo de retroalimentación");

            // Generar nombre aleatorio
            String[] nombres = {
                "Retroalimentación Operativa", "Feedback Semestral", "Revisión de Desempeño",
                "Comentarios Internos", "Evaluación General RH", "Reporte de Área"
            };
            String nombreSeleccionado = nombres[new Random().nextInt(nombres.length)];

            writeInTextBox(driver, wait, "//*[@id='identifying_name']",
                    nombreSeleccionado, "Nombre del campo de retroalimentación");

            // ----------TIPO DE RETROALIMENTACIÓN ALEATORIA----------
            Random rand = new Random();
            int tipo = rand.nextInt(3) + 1; // 1: Comentarios, 2: Firmas, 3: RH

            switch (tipo) {
                case 1 -> configurarComentarios(driver, wait);
                case 2 -> configurarFirmas(driver, wait);
                case 3 -> configurarRH(driver, wait);
            }

            // ----------GUARDAR Y CONFIRMAR CAMBIOS----------
            guardarYConfirmar(driver, wait);

            Utils.logAction("Flujo de Retroalimentación completado aleatoriamente: " + tipo);
        } catch (Exception e) {
            Utils.logAction("Error en Retroalimentación: " + e.getMessage());
        }
    }

    // ----------TIPO 1: COMENTARIOS----------
    private static void configurarComentarios(WebDriver driver, WebDriverWait wait) {
        clickButtonByXPath(driver, wait, "//*[@id='feedback_type']/label[1]/span[1]", "Seleccionando campo de comentarios");

        Random rand = new Random();
        if (rand.nextBoolean()) {
            clickButtonByXPath(driver, wait, "//*[@id='comments_type']/label[1]/span[2]", "Seleccionando Reporte Digital");
        } else {
            clickButtonByXPath(driver, wait, "//*[@id='comments_type']/label[2]/span[1]", "Seleccionando Reporte PDF");
        }

        Utils.logAction("Campo de comentarios configurado correctamente.");
    }

    // ----------TIPO 2: FIRMAS----------
    private static void configurarFirmas(WebDriver driver, WebDriverWait wait) {
        clickButtonByXPath(driver, wait, "//*[@id='feedback_type']/label[2]/span[1]", "Seleccionando campo de firmas");

        writeInTextBox(driver, wait, "//*[@id='id_typeSignatureInput0']",
                "Recursos Humanos", "Primer responsable");

        clickButtonByXPath(driver, wait,
                "//*[@id='rc-tabs-0-panel-1']/div[2]/div[3]/div[2]/div/div[1]/div/div[2]/form/div[5]/div/div/div/div/button",
                "Añadir responsable");

        writeInTextBox(driver, wait, "//*[@id='id_typeSignatureInput1']",
                "Contabilidad", "Segundo responsable");

        Utils.logAction("Campo de firmas configurado con dos responsables.");
    }

    // ----------TIPO 3: ÁREA RH----------
    private static void configurarRH(WebDriver driver, WebDriverWait wait) {
        clickButtonByXPath(driver, wait, "//*[@id='feedback_type']/label[3]/span[1]", "Seleccionando área exclusiva de RH");

        String[] areas = {
            "Departamento de Calidad", "Seguridad e Higiene",
            "Control Interno", "Capacitación", "Desarrollo Organizacional"
        };
        String areaSeleccionada = areas[new Random().nextInt(areas.length)];

        writeInTextBox(driver, wait, "//*[@id='id_typeHRInput0']",
                areaSeleccionada, "Acción a aplicar");

        Utils.logAction("Campo de RH configurado para: " + areaSeleccionada);
    }

    // ----------FUNCIÓN GLOBAL DE GUARDADO----------
    private static void guardarYConfirmar(WebDriver driver, WebDriverWait wait) {
        try {
            // Guardar dentro del formulario actual
            clickButtonByXPath(driver, wait,
                    "//*[@id='rc-tabs-0-panel-1']/div[2]/div[3]/div[2]/div/div[1]/div/div[2]/form/div[6]/div/div/div/div/button/span",
                    "Guardando cambios");

            // Confirmar segundo modal si aparece
            sleep(1.2);
            clickButtonByXPath(driver, wait,
                    "//*[@id='rc-tabs-0-panel-1']/div[2]/div[4]/div[2]/div/div[1]/div/div[2]/form/div[5]/div/div/div",
                    "Confirmar guardado");

            Utils.logAction("Cambios guardados y confirmados correctamente.");
        } catch (Exception e) {
            Utils.logAction("Error al guardar: " + e.getMessage());
        }
    }
}
