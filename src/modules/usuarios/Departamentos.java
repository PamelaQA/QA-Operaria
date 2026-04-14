package modules.usuarios;

import core.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static core.Utils.*;


public class Departamentos {
    public static void interactWithDashboard(WebDriver driver, WebDriverWait wait) {
        try {
            Utils.logAction("Ejecutando módulo: Departamentos");

             // ----------GESTIÓN DE USUARIOS----------

            clickButtonByXPath(driver, wait,
                    "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[2]/div/div[1]/div/div/div/div[2]/div/div",
                    "Clic en Gestion de usuarios");

    // ---------- DEPARTAMENTOS ----------

            clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[2]/div/div[3]/div/div/div/div/div/p[1]", "Clic en Departamentos");
            clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[1]/button/span", "Nuevo departamento");
                writeInTextBox(driver, wait, "//*[@id=\"id_department_name\"]", "Departamento de área comercial", "Nombre del departamento");
                    writeInTextBox(driver, wait, "//*[@id=\"id_department_code\"]", "ACOM", "Símbolo del departamento");
                        writeInTextBox(driver, wait, "//*[@id=\"id_universal_code\"]", "20", "Código");
                            clickButtonByXPath(driver, wait, "//*[@id=\"isCompany\"]/span", "Si es compañía");
                                clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[6]/div/div/div/div/button/span", "Confirmar");
                                    clickButtonByXPath(driver, wait, "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/div[6]/div/div/div/div/button/span", "Confirmar x2");
    

    // // ----------EDITAR DEPARTAMENTOS----------

    //        clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[4]/div/div[1]/button/span", "Editar departamento");
    //             writeInTextBox(driver, wait, "//*[@id=\"id_department_name\"]", "Departamento de comercial", "Cambiar nombre del departamento");
    //                 writeInTextBox(driver, wait, "//*[@id=\"id_department_code\"]", "DC", "Cambiando  símbolo del departamento");
    //                       clickButtonByXPath(driver, wait, "//*[@id=\"isCompany\"]/span", "No es compañía");
    //                        clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[6]/div/div/div/div/button/span", "Confirmar");
    //                             clickButtonByXPath(driver, wait, "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/div[6]/div/div/div/div/button/span", "Confirmar x2");
    
    // // ----------ELIMINAR DEPARTAMENTOS----------
    //         clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[4]/div/div[3]", "Eliminar departamento");
    //                clickButtonByXPath(driver, wait, "//*[@id=\":r1j:\"]/div/div/div[2]/button[2]/span", "Confirmar"); //Revisar           

    // // ----------DESACTIVAR DEPARTAMENTOS----------
    //         clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[4]/div/div[2]/button/span", "Desactivar departamento");
    //                 clickButtonByXPath(driver, wait, "//*[@id=\":r1f:\"]/div/div/div[2]/button[2]/span", "Confirmar");//Revisar

    // ----------EXPORTAR DEPARTAMENTOS----------
            clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[1]/div/button/span[2]", "Exportar departamentos");

 
            Utils.logAction("Flujo de Departamentos completado.");
        } catch (Exception e) {
            Utils.logAction("Error en Departamentos: " + e.getMessage());
        }
    }
}
