package modules.usuarios;

import core.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static core.Utils.*;

import java.io.File;


public class Importaciones {
    public static void interactWithDashboard(WebDriver driver, WebDriverWait wait) {
        try {
            Utils.logAction("Ejecutando módulo: Importaciones");

             // ----------GESTIÓN DE USUARIOS----------
  clickButtonByXPath(driver, wait,
                "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[2]/div/div[1]/div/div/div/div[2]/div/div",
                "Clic en Gestion de usuarios");

    // ----------IMPORTACIONES Y EXPORTACIONES----------
        clickButtonByXPath(driver, wait,
                "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[2]/div/div[6]/div/div/div/div/div/p",
                "Clic en Importaciones y exportaciones");

    //----------DEPARTAMENTOS----------

        // Ruta completa del archivo
        String filePath1 = "C:\\Users\\USER\\Desktop\\Usuarios\\Department_template.xlsx";
        File file1 = new File(filePath1);

        // Verifica si el archivo existe
        if (!file1.exists()) {
            logAction("El archivo no existe: " + filePath1);
            return;
        }

        // Localiza el input file y envía la ruta directamente (sin abrir explorador)
        WebElement fileInput1 = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@type='file']")));
        fileInput1.sendKeys(filePath1);
        logAction("Departamentos enviado correctamente: " + filePath1);


        //----------POSICIONES----------

        // Clic en posiciones
        clickButtonByXPath(driver, wait, 
        "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div/div[1]/div[2]/div/div[3]/div", 
        "Clic en posiciones");

        // Ruta completa del archivo
        String filePath2 = "C:\\Users\\USER\\Desktop\\Usuarios\\Positions_template.xlsx";

        // Localiza el input file y envía la ruta directamente (sin abrir explorador)
        WebElement fileInput2 = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("//input[@type='file' and @name='file']")));
        fileInput2.sendKeys(filePath2);

        logAction("Posiciones enviado correctamente: " + filePath2);


        //----------CATEGORIAS----------

        // Clic en categorías
        clickButtonByXPath(driver, wait, 
        "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div/div[1]/div[3]/div/div[3]/div", 
        "Clic en categorías");

        // Ruta completa del archivo
        String filePath3 = "C:\\Users\\USER\\Desktop\\Usuarios\\Categories_template.xlsx";

        // Localiza el input file y envía la ruta directamente (sin abrir explorador)
        WebElement fileInput3 = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("//input[@type='file' and @name='file']")));
        fileInput3.sendKeys(filePath3);

        logAction("Categorías enviado correctamente: " + filePath3);
        
        clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div/div[2]/div[3]/div/div/div/div/div/table/tbody/tr[2]/td[1]/label", "Seleccionar categoría 1");
        clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div/div[2]/div[3]/div/div/div/div/div/table/tbody/tr[3]/td[1]/label", "Seleccionar categoría 2");
        clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div/div[2]/div[3]/div/div/div/div/div/table/tbody/tr[4]/td[1]/label", "Seleccionar categoría 3");
    
        clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div/div[2]/div[2]/button[1]/span[2]", "Enlazando posiciones y categorías");
        writeInTextBox(driver, wait, "//*[@id=\"order_51\"]", "1", "Categoría 1");
        writeInTextBox(driver, wait, "//*[@id=\"order_52\"]", "2", "Categoría 2");
        writeInTextBox(driver, wait, "//*[@id=\"order_53\"]", "3", "Categoría 3");

        clickButtonByXPath(driver, wait, "//*[@id=\"position\"]", "Desplegando posición a relacionar");
        clickButtonByXPath(driver, wait, "/html/body/div[3]/div/div/div[2]/div[1]/div/div/div[1]", "Seleccionando posición");
        clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/button/span", "Guardando posiciones");

        // Clic en colaboradores
        clickButtonByXPath(driver, wait, 
        "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div/div[1]/div[4]/div/div[3]/div", 
        "Clic en colaboradores");

        // Ruta completa del archivo
        String filePath4 = "C:\\Users\\USER\\Desktop\\Usuarios\\Usuarios_template.xlsx";

        // Localiza el input file y envía la ruta directamente (sin abrir explorador)
        WebElement fileInput4 = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("//input[@type='file' and @name='file']")));
        fileInput4.sendKeys(filePath4);

        logAction("Colaboradores enviado correctamente: " + filePath4);

        //ENLAZAR DEPARTAMENTOS
        
        clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/table/thead/tr/th[1]/div/label", "Seleccionando usuarios");
        clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div/div[2]/div[2]/button[1]/span[2]", "Enlazando a departamentos");
        clickButtonByXPath(driver, wait, "//*[@id=\"department\"]", "Desplegando despartamento a relacionar");
        clickButtonByXPath(driver, wait, "/html/body/div[3]/div/div/div[2]/div[1]/div/div/div[1]/div", "Seleccionando deprtamento");

        clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/button/span", "Guardar");

        //ENLAZAR POSICIONES
        clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div/div[2]/div[1]/div[2]/div/div[3]/div", "Enlazamiento de posiciones");
        clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/table/thead/tr/th[1]/div/label/span", "Seleccionando usuarios");
        clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div/div[2]/div[2]/div[1]/button/span[2]", "Enlazar posiciones");
        clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[1]/div/div[2]/div/div/div/div/span", "Desplegando enlazamiento a posiciones");
        clickButtonByXPath(driver, wait, "/html/body/div[3]/div/div/div[2]/div[1]/div/div/div[1]", "Seleccionado Posicion Montacarguista");
        clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[2]/div/div[2]/div/div/div/div/span", "Desplegando categorías a relacionar");
        clickButtonByXPath(driver, wait, "/html/body/div[4]/div/div/div[2]/div/div/div/div", "Seleccionando categoría");
        clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/button", "Guardar");

        //ENLAZAR JEFE
        clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div/div[2]/div[1]/div[3]/div/div[3]/div", "Enlazamiento de jefe");
        clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/table/thead/tr/th[1]/div/label", "Seleccionando usuarios");
        clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div/div[2]/div[2]/div[1]/button/span[2]", "Enlazar jefe");
        
        clickButtonByXPath(driver, wait, "/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/form/div[1]/div/div[2]/div/div/div/div/span", "Desplegando listado de jefe");
        clickButtonByXPath(driver, wait, "/html/body/div[4]/div/div/div[2]/div[1]/div/div/div[4]/div", "Seleccionando jefe");
        clickButtonByXPath(driver, wait, "/html/body/div[5]/div/div[2]/div/div[1]/div/div[2]/form/button/span", "Guardar");

            Utils.logAction("Flujo de Importaciones completado.");
        } catch (Exception e) {
            Utils.logAction("Error en Importaciones: " + e.getMessage());
        }
    }
}
