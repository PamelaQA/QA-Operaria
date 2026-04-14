package common;

import core.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardActions {
    public static void openEvaluaciones(WebDriver driver, WebDriverWait wait) {
        Utils.logAction("Abriendo módulo de Evaluaciones...");
    }

    public static void openUsuarios(WebDriver driver, WebDriverWait wait) {
        Utils.logAction("Abriendo módulo de Usuarios...");
    }
}
