package modules.evaluaciones;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static core.Utils.*;
import java.util.Random;

public class Climalaboral {

    public static void interactWithDashboard(WebDriver driver, WebDriverWait wait) {
        try {
            logAction("Iniciando módulo: Evaluación General con respuestas aleatorias");

            Random rand = new Random();

            // ----------IR A MIS EVALUACIONES----------
            clickButtonByXPath(driver, wait,
                    "//*[@id='root']/div/div[2]/div[2]/div/main/div[2]/div/div[8]/div/div/div/div[1]",
                    "Clic en Mis Evaluaciones");

            // ----------COMENZAR EVALUACIÓN----------
            clickButtonByXPath(driver, wait, "//*[@id=\"rc-tabs-0-panel-1\"]/div/div/div/div/div/div/table/tbody/tr[2]/td[5]/button", "Comenzar evaluacion");



            // ----------LISTADO DE PREGUNTAS (87 en total)----------
            int[][] preguntasEvaluacion = {
                {176, 18}, {177, 18}, {178, 18}, {179, 18}, {180, 18},
                {181, 18}, {182, 18}, {183, 18}, {184, 19}, {185, 19},
                {186, 19}, {187, 19}, {188, 19}, {189, 19}, {190, 19},
                {191, 19}, {192, 19}, {193, 19}, {194, 19}, {195, 19},
                {196, 19}, {197, 19}, {198, 19}, {199, 19}, {200, 19},
                {201, 19}, {202, 19}, {203, 20}, {204, 20}, {205, 20},
                {206, 20}, {207, 20}, {208, 20}, {209, 20}, {210, 20},
                {211, 20}, {212, 20}, {213, 20}, {214, 20}, {215, 20},
                {216, 20}, {217, 20}, {218, 21}, {219, 21}, {220, 21},
                {221, 21}, {222, 21}, {223, 21}, {224, 21}, {225, 21},
                {226, 21}, {227, 21}, {228, 22}, {229, 22}, {230, 22},
                {231, 22}, {232, 22}, {233, 22}, {234, 22}, {235, 22},
                {236, 22}, {237, 22}, {238, 22}, {239, 22}, {240, 22},
                {241, 22}, {242, 22}, {243, 22}, {244, 22}, {245, 22},
                {246, 22}, {247, 22}, {248, 23}, {249, 23}, {250, 23},
                {251, 23}, {252, 23}, {253, 23}, {254, 23}, {255, 23},
                {256, 24}, {257, 24}, {258, 24}, {259, 24}, {260, 24},
                {261, 24}, {262, 24}

            };

            responderPreguntas(driver, wait, rand, preguntasEvaluacion, "Evaluación General");


            // ----------FINALIZAR EVALUACIÓN----------
            clickButtonByXPath(driver, wait,
                    "//*[@id='root']/div/div[2]/div[2]/div/main/form/div[last()]/div/div/div/div/button",
                    "Finalizar evaluación");

            logAction("Evaluación General completada");

        } catch (Exception e) {
            logAction("Error durante la ejecución de la Evaluación General: " + e.getMessage());
        }
    }

    // Función para responder preguntas con opciones aleatorias
    private static void responderPreguntas(WebDriver driver, WebDriverWait wait, Random rand, int[][] preguntas, String categoria) {
        logAction("Respondiendo sección: " + categoria);

        String[] opciones = {
                "Totalmente de acuerdo",
                "De acuerdo",
                "Ni de acuerdo ni en desacuerdo",
                "En desacuerdo",
                "Totalmente en desacuerdo"
        };

        for (int i = 0; i < preguntas.length; i++) {
            int preguntaId = preguntas[i][0];
            int seccionId = preguntas[i][1];
            int opcion = rand.nextInt(5) + 1; // 1–5

            String xpath = String.format(
                    "//*[@id='answer_%d_%d']/div[%d]/label",
                    preguntaId, seccionId, opcion
            );

            String textoOpcion = opciones[opcion - 1];

            try {
                clickButtonByXPath(driver, wait, xpath,
                        "Pregunta " + (i + 1) + " (" + categoria + "): " + textoOpcion);
            } catch (Exception e) {
                logAction("No se pudo responder pregunta " + (i + 1) + ": " + e.getMessage());
            }
        }
    }
}
