package modules.usuarios;

import core.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static core.Utils.*;


public class Posiciones {
    public static void interactWithDashboard(WebDriver driver, WebDriverWait wait) {
        try {
            Utils.logAction("Ejecutando módulo: Posiciones");

             // ----------GESTIÓN DE USUARIOS----------

            clickButtonByXPath(driver, wait,
                    "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[2]/div/div[1]/div/div/div/div[2]/div/div",
                    "Clic en Gestion de usuarios");


    // ---------- POSICIONES ----------

 clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[2]/div/div[4]/div/div", "Clic en Posiciones");
                clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[1]/button/span", "Nueva Posición");
                    writeInTextBox(driver, wait, "//*[@id=\"id_position_code\"]", "50", "Código");
                writeInTextBox(driver, wait, "//*[@id=\"id_position_name\"]", "Director de comercio", "Nombre de la posición");
                    writeInTextBox(driver, wait, "//*[@id=\"id_position_sing\"]", "DC", "Símbolo de la posición");
                                clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[5]/div/div/div/div/button/span", "Confirmar");
                                    clickButtonByXPath(driver, wait, "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/div[6]/div/div/div/div/button/span", "Confirmar x2");
    //  // ----------EDITAR POSICIONES----------

    //         clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[4]/div/div[1]/button/span", "Editar posición");
    //             writeInTextBox(driver, wait, "//*[@id=\"id_position_name\"]", "Subdirector de comercio", "Cambiar nombre de la posición");
    //                 writeInTextBox(driver, wait, "//*[@id=\"id_position_sing\"]", "SBC", "Cambiando  símbolo de la posición");
    //                        clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[5]/div/div/div/div/button/span", "Confirmar");
    //                                 clickButtonByXPath(driver, wait, "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/div[6]/div/div/div/div/button/span", "Confirmar x2");
    
    // // ----------ELIMINAR POSICIONES----------
    //         clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[4]/div/div[3]", "Eliminar posición");
    //                clickButtonByXPath(driver, wait, "//*[@id=\":r1j:\"]/div/div/div[2]/button[2]/span", "Confirmar");             

    // // ----------DESACTIVAR DEPARTAMENTOS----------
    //         clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[4]/div/div[2]/button/span", "Desactivar posición");
    //                 clickButtonByXPath(driver, wait, "//*[@id=\":r1f:\"]/div/div/div[2]/button[2]/span", "Confirmar");

    // ----------EXPORTAR POSICIONES----------
            clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[1]/div/button/span[2]", "Exportar posiciones");

    

            Utils.logAction("Flujo de Posiciones completado.");
        } catch (Exception e) {
            Utils.logAction("Error en Posiciones: " + e.getMessage());
        }
    }
}
