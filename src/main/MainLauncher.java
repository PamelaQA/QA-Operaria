package main;

import core.Config;
import core.WebDriverFactory;
import common.LoginActions;
import modules.usuarios.*;
import modules.evaluaciones.*;
import modules.mantenimiento.CrudManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Scanner;
import static core.Utils.*;

public class MainLauncher {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("1. Ejecutar Módulo de Colaboradores");
            System.out.println("2. Ejecutar Módulo de Evaluaciones");
            System.out.println("3. Ejecutar Usuarios");
            System.out.println("4. Ejecutar Departamentos");
            System.out.println("5. Ejecutar Posiciones");
            System.out.println("6. Ejecutar Categorías");
            System.out.println("7. Ejecutar Importaciones");
            System.out.println("8. Ejecutar Preguntas");
            System.out.println("9. Ejecutar Secciones");
            System.out.println("10. Ejecutar Retroalimentación");
            System.out.println("11. Ejecutar Evaluaciones");
            System.out.println("12. Ejecutar NOM0");
            System.out.println("13. Ejecutar NineBox");
            System.out.println("14. Ejecutar Climalaboral");
            System.out.println("──────────── CRUD (Ediciones) ────────────");
            System.out.println("15. Crear nuevo registro (JSON)");
            System.out.println("16. Editar registro (JSON)");
            System.out.println("17. Eliminar registro");
            System.out.println("18. Desactivar registro");
            System.out.print("Opción: ");
            int choice = scanner.nextInt();

            WebDriver driver = WebDriverFactory.createDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Config.DEFAULT_TIMEOUT));

            try {
                driver.get(Config.BASE_URL);
                LoginActions.login(driver, wait);
                logAction("Inicio de sesión completado correctamente.");

                switch (choice) {

                    // ======== MÓDULO COMPLETO DE COLABORADORES ========
                    case 1 -> {
                        logAction("Ejecutando Módulo de Colaboradores");
                        Usuarios.interactWithDashboard(driver, wait);
                        Departamentos.interactWithDashboard(driver, wait);
                        Posiciones.interactWithDashboard(driver, wait);
                        Categorias.interactWithDashboard(driver, wait);
                        Importaciones.interactWithDashboard(driver, wait);
                    }

                    // ======== MÓDULO COMPLETO DE EVALUACIONES ========
                    case 2 -> {
                        logAction("Ejecutando Módulo de Evaluaciones");
                        Preguntas.interactWithDashboard(driver, wait);
                        Secciones.interactWithDashboard(driver, wait);
                        Retroalimentacion.interactWithDashboard(driver, wait);
                        Evaluaciones.interactWithDashboard(driver, wait);
                        NOM035.interactWithDashboard(driver, wait);
                        NineBox.interactWithDashboard(driver, wait, scanner);
                    }

                    // ======== MÓDULOS INDIVIDUALES ========
                    case 3 -> Usuarios.interactWithDashboard(driver, wait);
                    case 4 -> Departamentos.interactWithDashboard(driver, wait);
                    case 5 -> Posiciones.interactWithDashboard(driver, wait);
                    case 6 -> Categorias.interactWithDashboard(driver, wait);
                    case 7 -> Importaciones.interactWithDashboard(driver, wait);
                    case 8 -> Preguntas.interactWithDashboard(driver, wait);
                    case 9 -> Secciones.interactWithDashboard(driver, wait);
                    case 10 -> Retroalimentacion.interactWithDashboard(driver, wait);
                    case 11 -> Evaluaciones.interactWithDashboard(driver, wait);
                    case 12 -> NOM035.interactWithDashboard(driver, wait);
                    case 13 -> NineBox.interactWithDashboard(driver, wait, scanner);
                    case 14 -> Climalaboral.interactWithDashboard(driver, wait);


                    // ======== CRUD MANAGEMENT ========
                   
                    case 15 -> {
                        System.out.println("Selecciona el módulo para EDITAR:");
                        String moduloEditar = getModulo(scanner);
                        CrudManager.editarElemento(driver, wait, moduloEditar);
                    }

                    case 16 -> {
                        System.out.println("Selecciona el módulo para ELIMINAR:");
                        String moduloEliminar = getModulo(scanner);
                        CrudManager.eliminarElemento(driver, wait, moduloEliminar);
                    }

                    case 17 -> {
                        System.out.println("Selecciona el módulo para DESACTIVAR:");
                        String moduloDesactivar = getModulo(scanner);
                        CrudManager.desactivarElemento(driver, wait, moduloDesactivar);
                    }

                    // ======== DEFAULT ========
                    default -> System.out.println("Opción no inválida");
                }

                extractAndSaveBrowserLogs(driver);
                logAction("Ejecución finalizada correctamente");

            } catch (Exception e) {
                logAction("Error general: " + e.getMessage());
            } finally {
                WebDriverFactory.safeQuit(driver);
            }
        }
    }

    // Método auxiliar para seleccionar módulo en CRUD
    private static String getModulo(Scanner scanner) {
        System.out.println("1. Evaluaciones");
        System.out.println("2. Secciones");
        System.out.println("3. Retroalimentación");
        System.out.println("4. Preguntas");
        System.out.print("Módulo: ");
        int modChoice = scanner.nextInt();

        return switch (modChoice) {
            case 1 -> "evaluaciones";
            case 2 -> "secciones";
            case 3 -> "retroalimentacion";
            case 4 -> "preguntas";
            default -> "evaluaciones";
        };
    }
}
