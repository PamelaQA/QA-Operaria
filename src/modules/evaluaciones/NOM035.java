package modules.evaluaciones;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static core.Utils.*;

public class NOM035 {

    private static final Random random = new Random();

    public static void interactWithDashboard(WebDriver driver, WebDriverWait wait) {

        try {
            logAction("Ejecutando módulo: NOM 035");

            // Ir a Mis Evaluaciones
            clickButtonByXPath(driver, wait,
                    "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[2]/div/div[8]/div/div/div/div[1]/img",
                    "Clic en Mis Evaluaciones");

            clickButtonByXPath(driver, wait,
                    "//*[@id=\"rc-tabs-0-panel-1\"]/div/div/div/div/div/div/table/tbody/tr[2]/td[5]/button",
                    "Comenzar evaluación");

            // Política de prevención
            clickButtonByXPath(driver, wait,
                    "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div/label/span[2]",
                    "Aceptar la política");

            clickButtonByXPath(driver, wait,
                    "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/button/span",
                    "Confirmar política");

            // Detectar caso
            boolean caso1 = elementoExiste(driver, "//*[@id=\"answer_264_25\"]");
            boolean caso2 = elementoExiste(driver, "//*[@id=\"answer_793_111\"]");

            if (caso1) {
                logAction("Evaluación NOM035 mayor a 50 colaboradores");
                ejecutarCaso1(driver, wait);
            } else if (caso2) {
                logAction("Evaluación NOM035 menor a 50 colaboradores");
                ejecutarCaso2(driver, wait);
            } else {
                logAction("No se detectó caso correcto de NOM035");
                return;
            }

            // Finalizar
            microSleep();
            clickButtonByXPath(driver, wait,
                    "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/form/div[last()]/div/div/div/div/button",
                    "Finalizar evaluación");

            logAction("Evaluación NOM 035 completada correctamente.");

        } catch (Exception e) {
            logAction("Error general NOM035: " + e.getMessage());
        }
    }

    // CASO 1 — Mayor a 50 colaboradores

    private static void ejecutarCaso1(WebDriver driver, WebDriverWait wait) {

        logAction("Iniciando Caso 1");

        // Pregunta 264
        boolean p264 = responderSiNo(driver, wait, 264, 25);

        if (p264) {
            for (int q = 265; q <= 278; q++) {
                responderSiNo(driver, wait, q, 25);
            }
        } else {
            logAction("264 = No → se omiten 265–278");
        }

        // Escalas 327–390
        for (int q = 327; q <= 390; q++) {
            responderEscala(driver, wait, q, 27);
        }

        // Pregunta 391 (si → 392–395)
        boolean p391 = responderSiNo(driver, wait, 391, 27);

        if (p391) {
            for (int q = 392; q <= 395; q++) {
                responderEscala(driver, wait, q, 27);
            }
        }

        // Pregunta 396 (si → 397–399)
        boolean p396 = responderSiNo(driver, wait, 396, 27);

        if (p396) {
            for (int q = 397; q <= 399; q++) {
                responderEscala(driver, wait, q, 27);
            }
        }

        logAction("Caso 1 completado.");
    }

    // CASO 2 — Menor a 50 colaboradores

    private static void ejecutarCaso2(WebDriver driver, WebDriverWait wait) {

        logAction("Iniciando Caso 2");

        // Pregunta 793
        boolean p793 = responderSiNo(driver, wait, 793, 111);

        if (p793) {

            logAction("793 = Sí → respondiendo subpreguntas 794–806");

            // Preguntas 794–806 (todas son Sí/No)
            for (int q = 794; q <= 806; q++) {

                if (elementoExiste(driver,
                        "//*[@id=\"answer_" + q + "_111\"]")) {

                    responderSiNo(driver, wait, q, 111);
                }
            }

            // Responder la 807
            responderSiNo(driver, wait, 807, 111);

        } else {

            logAction("793 = No → se omiten 794–807");
        }

        // Escalas 808–847
        for (int q = 808; q <= 847; q++) {
            responderEscala(driver, wait, q, 112);
        }

        // Pregunta 848
        boolean p848 = responderSiNo(driver, wait, 848, 112);

        if (p848) {
            for (int q = 849; q <= 851; q++) {
                responderEscala(driver, wait, q, 112);
            }
        }

        // Pregunta 852
        boolean p852 = responderSiNo(driver, wait, 852, 112);

        if (p852) {
            for (int q = 853; q <= 855; q++) {
                responderEscala(driver, wait, q, 112);
            }
        }

        logAction("Caso 2 completado.");
    }

    // Respuesta SÍ / NO

    private static boolean responderSiNo(WebDriver driver, WebDriverWait wait, int id, int section) {

        boolean si = random.nextBoolean();
        int option = si ? 1 : 2;
        String texto = si ? "Sí" : "No";

        try {
            clickButtonByXPath(driver, wait,
                    "//*[@id=\"answer_" + id + "_" + section + "\"]/label[" + option + "]/span[1]",
                    texto);
        } catch (Exception e) {
            logAction("Error al responder Si/No (" + id + "): " + e.getMessage());
        }

        microSleep();
        return si;
    }

    // Respuesta de Escala 1–5

    private static void responderEscala(WebDriver driver, WebDriverWait wait, int id, int section) {

        int option = random.nextInt(5) + 1;

        try {
            clickButtonByXPath(driver, wait,
                    "//*[@id=\"answer_" + id + "_" + section + "\"]/label[" + option + "]/span[1]",
                    "Escala opción " + option);
        } catch (Exception e) {
            logAction("Error en escala (" + id + "): " + e.getMessage());
        }

        microSleep();
    }

    // Pequeña pausa entre preguntas

    private static void microSleep() {
        try {
            Thread.sleep(350 + random.nextInt(250));  // 350–600 ms
        } catch (Exception ignored) {
        }
    }

    // Verificar si un elemento existe

    private static boolean elementoExiste(WebDriver driver, String xpath) {
        try {
            driver.findElement(org.openqa.selenium.By.xpath(xpath));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
