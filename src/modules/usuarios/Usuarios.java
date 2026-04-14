package modules.usuarios;

import core.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static core.Utils.*;

public class Usuarios {
    public static void interactWithDashboard(WebDriver driver, WebDriverWait wait) {
        try {
                 // ----------GESTIÓN DE USUARIOS----------

            clickButtonByXPath(driver, wait,
                    "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[2]/div/div[1]/div/div/div/div[2]/div/div",
                    "Clic en Gestion de usuarios");

    // ----------CREAR NUEVO COLABORADOR----------

             clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[1]/button[1]/span", "Crear nuevo empleado");

    // ----------DATOS PERSONALES ----------

            writeInTextBox(driver, wait, "//*[@id=\"id_payroll\"]", "800", "No Nomina");
            writeInTextBox(driver, wait, "//*[@id=\"id_name\"]", "JOSE", "Nombre del colaborador");
            writeInTextBox(driver, wait, "//*[@id=\"lastName1\"]", "PEREZ", "Apellido Paterno");
            writeInTextBox(driver, wait, "//*[@id=\"lastName2\"]", "LOPEZ", "Apellido Materno");

    // ----------FECHA DE NACIMIENTO ----------

            writeInTextBox(driver, wait, "//*[@id=\"createOrUpdateUser_birthDay\"]", "1996-06-04", "Fecha de nacimiento");

            writeInTextBox(driver, wait, "//*[@id=\"em_email\"]", "qa@tecnolika.com", "Escribiendo correo");

    // ----------GENERO, ESCOLARIDAD Y ESTADO CIVIL ----------

            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser\"]/div[11]/div/div[2]/div/div/div/div/span/span[1]", "Desplegar género");        
            clickButtonByXPath(driver, wait, "/html/body/div[4]/div/div/div[2]/div/div/div/div[1]/div", "Masculino");    

            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser\"]/div[12]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando escolaridad");        
            clickButtonByXPath(driver, wait, "/html/body/div[5]/div/div/div[2]/div/div/div/div[4]/div", "Licenciatura");   

            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser\"]/div[13]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando estado civil");        
            clickButtonByXPath(driver, wait, "/html/body/div[6]/div/div/div[2]/div/div/div/div[2]/div", "Soltero");        

    // ----------DATOS DE TRABAJO ----------

            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser\"]/div[15]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando listado departamentos");        
            clickButtonByXPath(driver, wait, "/html/body/div[7]/div/div/div[2]/div[1]/div/div/div[4]/div", "Calidad");        

            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser\"]/div[16]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando listado de posiciones");        
            clickButtonByXPath(driver, wait, "/html/body/div[8]/div/div/div[2]/div[1]/div/div/div[4]/div", "Analista de calidad");        

            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser\"]/div[17]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando listado de categorías");        
            clickButtonByXPath(driver, wait, "/html/body/div[9]/div/div/div[2]/div/div/div/div/div", "AC");        

            writeInTextBox(driver, wait, "//*[@id=\"createOrUpdateUser_dateHiring\"]", "2025-06-16", "Escribiendo fecha de contratación");
            writeInTextBox(driver, wait, "//*[@id=\"createOrUpdateUser_periodCategoryStart\"]", "2025-07-20", "Escribiendo fecha de promoción");

            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser\"]/div[26]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando listado del supervisor");
            clickButtonByXPath(driver, wait, "/html/body/div[12]/div/div/div[2]/div[1]/div/div/div[4]/div", "Sleccionando supervisor");

            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser\"]/div[20]/div/div[2]/div/div", "Desplegando listado de idiomas");
            clickButtonByXPath(driver, wait, "/html/body/div[13]/div/div/div[2]/div/div/div/div/div", "es");

            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser\"]/div[21]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando listado tipo de empleado");
            clickButtonByXPath(driver, wait, "/html/body/div[14]/div/div/div[2]/div/div/div/div/div", "Seleccionando tipo de empleado medio tiempo");

            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser\"]/div[22]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando lisado modalidad de trabajo");
            clickButtonByXPath(driver, wait, "/html/body/div[15]/div/div/div[2]/div/div/div/div/div", "Seleccionando modalidad de trabajo remoto");

            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser_typeUnion\"]/label[1]/span[2]", "Asignando al usuario tipo de sindicato, sindicalizado");

            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser_isAdmin\"]/span", "Asignando al usuario como administrador");
            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser_isSupervisor\"]/span", "Asgnando al usuario como supervisor");

    // ----------PERMISOS PARA APLICACIÓN DE INCIDENCIAS ----------

            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser_incident_application\"]/div/div[1]/li/label", "Aplicando permiso nominal");
            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser_incident_application\"]/div/div[2]/li/label", "Aplicando permiso de licenciamiento");

    // ----------GUARDAR NUEVO USUARIO ----------

            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser\"]/button/span", "Confirmar usuario");


    //----------CREAR NUEVO CLIENTE----------
            clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[1]/button[1]/span", "Crear nuevo empleado");
                clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser_isCustomer\"]/label[2]/span[1]", "Crear nuevo cliente");



    //----------DATOS PERSONALES ----------

            writeInTextBox(driver, wait, "//*[@id=\"id_payroll\"]", "147", "No identificativo");
                writeInTextBox(driver, wait, "//*[@id=\"id_name\"]", "Samantha", "Nombre");
                    writeInTextBox(driver, wait, "//*[@id=\"lastName1\"]", "Diaz", "Apellido Materno");
                        writeInTextBox(driver, wait, "//*[@id=\"lastName2\"]", "Camacho", "Apellido Paterno");

    //----------DATOS DE TRABAJO ----------

            writeInTextBox(driver, wait, "//*[@id=\"em_email\"]", "qa@operaria.co", "Correo");
                clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser\"]/div[8]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando listado de Compañia");
                    clickButtonByXPath(driver, wait, "/html/body/div[3]/div/div/div[2]/div/div/div/div", "Seleccionando Compañia");
                        clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser\"]/div[9]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando listado de Posición");
                            clickButtonByXPath(driver, wait, "/html/body/div[4]/div/div/div[2]/div[1]/div/div/div[4]/div", "Seleccionando Posición");
                                clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser\"]/div[10]/div/div[2]/div/div/div/div/span/span[1]", "Desplegando listado de idioma");
                                    clickButtonByXPath(driver, wait, "/html/body/div[5]/div/div/div[2]/div/div/div/div[1]/div", "Seleccionando idioma");

    //----------GUARDAR NUEVO CLIENTE ----------

            clickButtonByXPath(driver, wait, "//*[@id=\"createOrUpdateUser\"]/button/span", "Confirmar cliente");

    // ----------EDITAR COLABORADOR ----------

            // clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[8]/button", "Desplegando acciones");

            //     clickButtonByXPath(driver, wait, "/html/body/div[3]/div/ul/li[2]/span[2]", "Mostrando reportes");
            //         clickButtonByXPath(driver, wait, "/html/body/div[4]/div/div[2]/div/div[1]/div/button/span", "Cerrando reportes");

            // clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[8]/button", "Desplegando acciones");

            //     clickButtonByXPath(driver, wait, "/html/body/div[3]/div/ul/li[3]/span[2]", "Mostrando Kardex");
            //         clickButtonByXPath(driver, wait, "/html/body/div[5]/div/div[2]/div/div[1]/div/button/span/span", "Cerrando Kardex");

            // clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[8]/button", "Desplegando acciones");

            //     clickButtonByXPath(driver, wait, "/html/body/div[3]/div/ul/li[4]/span[2]", "Ver asistencia");
            //         clickButtonByXPath(driver, wait, "/html/body/div[7]/div/div[2]/div/div[1]/div/button/span/span/svg", "Cerrando asistencia");

            // clickButtonByXPath(driver, wait, "//*[@id=\"root\"]/div/div[2]/div[2]/div/main/div[3]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[8]/button", "Desplegando acciones");
                                
                // clickButtonByXPath(driver, wait, "/html/body/div[3]/div/ul/li[5]/span[2]", "Mostrar QR");
                //     clickButtonByXPath(driver, wait, "/html/body/div[7]/div/div[2]/div/div[1]/div/div[3]/button[1]", "Descargar PNG");
                //         clickButtonByXPath(driver, wait, "/html/body/div[7]/div/div[2]/div/div[1]/div/div[3]/button[2]", "Cerrar QR");

            Utils.logAction("Flujo de Usuarios completado.");
        } catch (Exception e) {
            Utils.logAction("Error en Usuarios: " + e.getMessage());
        }
    }
}
