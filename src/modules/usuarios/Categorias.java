package modules.usuarios;

import core.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static core.Utils.*;


public class Categorias {
    public static void interactWithDashboard(WebDriver driver, WebDriverWait wait) {
        try {
            Utils.logAction("Ejecutando módulo: Categorías");

            // ----------GESTIÓN DE USUARIOS----------

            clickButtonByXPath(driver, wait,
                    "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[2]/div/div[1]/div/div/div/div[2]/div/div",
                    "Clic en Gestion de usuarios");

    // ---------- CATEGORÍAS ----------

            clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[2]/div/div[5]/div/div", "Clic en Categorías");
            clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[1]/button/span", "Nueva categoría");
                writeInTextBox(driver, wait, "//*[@id=\"id_category_name\"]", "Consultor de marketing 2", "Nombre de la categoría");
                    clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[3]/div/div[2]/div/div/div/div/span/span[1]", "Desplegar posiciones");
                        clickButtonByXPath(driver, wait, "/html/body/div[3]/div/div/div[2]/div[1]/div/div/div[7]", "Seleccionando categoria");
                            writeInTextBox(driver, wait, "//*[@id=\"id_category_code\"]", "MKT10", "Código de la categoría");
                            writeInTextBox(driver, wait, "//*[@id=\"id_category_sing\"]", "8", "Clasificación");
                            writeInTextBox(driver, wait, "//*[@id=\"id_category_days\"]", "15", "Días para la siguiente categoría");
                                clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[7]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando nivel de ILUO");
                                    clickButtonByXPath(driver, wait, "/html/body/div[4]/div/div/div[2]/div/div/div/div[1]/div", "Nivel Inical");
                                        clickButtonByXPath(driver, wait, "//*[@id=\"category_init\"]/div", "Es categoría inicial");
                                            clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[9]/div/div/div/div/button/span", "Confirmar");
                                                clickButtonByXPath(driver, wait, "/html/body/div[5]/div/div[2]/div/div[1]/div/div[2]/form/div[7]/div/div/div/div/button/span", "Confirmar x2");


 clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[2]/div/div[4]/div/div/div/div/div/p[1]", "Clic en Categorías");
            clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[1]/button/span", "Nueva categoría");
                writeInTextBox(driver, wait, "//*[@id=\"id_category_name\"]", "Consultor de marketing 2", "Nombre de la categoría");
                    clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[3]/div/div[2]/div/div/div/div/span/span[1]", "Desplegar posiciones");
                        clickButtonByXPath(driver, wait, "/html/body/div[3]/div/div/div[2]/div[1]/div/div/div[7]", "Seleccionando categoria");
                            writeInTextBox(driver, wait, "//*[@id=\"id_category_code\"]", "MKT12", "Código de la categoría");
                            writeInTextBox(driver, wait, "//*[@id=\"id_category_sing\"]", "8", "Clasificación");
                            writeInTextBox(driver, wait, "//*[@id=\"id_category_days\"]", "15", "Días para la siguiente categoría");
                                clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[7]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando nivel de ILUO");
                                    clickButtonByXPath(driver, wait, "/html/body/div[4]/div/div/div[2]/div/div/div/div[2]/div", "Nivel aprendiz");
                                        clickButtonByXPath(driver, wait, "//*[@id=\"clasification_select\"]", "Despleando clasificación anterior");
                                                clickButtonByXPath(driver, wait, "/html/body/div[5]/div/div/div[2]/div/div/div/div/div", "Seleccionando clasificación");
                                            clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[9]/div/div/div/div/button/span", "Confirmar");
                                                clickButtonByXPath(driver, wait, "/html/body/div[5]/div/div[2]/div/div[1]/div/div[2]/form/div[7]/div/div/div/div/button/span", "Confirmar x2");

    // ----------EDITAR CATEGORÍAS----------

//             clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[5]/div/div[1]/button/span", "Editar departamento");
//                 writeInTextBox(driver, wait, "//*[@id=\"id_category_name\"]", "Almacén y carga", "Cambiar nombre del departamento");
//                     clickButtonByXPath(driver, wait, "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/div[3]/div/div[2]/div/div/div/div/span/span[2]", "Desplegando listado");
//                            clickButtonByXPath(driver, wait, "/html/body/div[5]/div/div/div[2]/div[1]/div/div/div[6]/div", "Seleccionando");
//                     writeInTextBox(driver, wait, "//*[@id=\"id_category_sing\"]", "Almacén y carga", "Cambiar nombre del departamento");
//                                         writeInTextBox(driver, wait, "//*[@id=\"id_category_days\"]", "200", "Cambiar dias ");
//                                             clickButtonByXPath(driver, wait, "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/form/div[7]/div/div[2]/div/div/div/div/span/span[2]", "Desplegando listado");
// clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[9]/div/div/div/div/button/span", "Confirmar");
//                                                 clickButtonByXPath(driver, wait, "/html/body/div[5]/div/div[2]/div/div[1]/div/div[2]/form/div[7]/div/div/div/div/button/span", "Confirmar x2");



//     // ----------ELIMINAR CATEGORÍAS----------
//             clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[4]/div/div[3]", "Eliminar categoria");
//                    clickButtonByXPath(driver, wait, "//*[@id=\":r1j:\"]/div/div/div[2]/button[2]/span", "Confirmar");             

//     // ----------DESACTIVAR CATEGORÍAS----------
//             clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[4]/div/div[2]/button/span", "Desactivar categoria");
//                     clickButtonByXPath(driver, wait, "//*[@id=\":r1f:\"]/div/div/div[2]/button[2]/span", "Confirmar");

//     // ----------EXPORTAR CATEGORÍAS----------
//             clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[1]/div/button/span[2]", "Exportar categorias");


            Utils.logAction("Flujo de Categorías completado.");
        } catch (Exception e) {
            Utils.logAction("Error en Categorías: " + e.getMessage());
        }
    }
}
