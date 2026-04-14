package modules.mantenimiento;

import core.DataProvider;
import core.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static core.Utils.*;

public class CrudManager {

    // 🔹 Función base que lleva al módulo correspondiente
    private static void navegarAModulo(WebDriver driver, WebDriverWait wait, String modulo) {
        try {
            Utils.logAction("🔍 Navegando al módulo: " + modulo);

            // Ir al dashboard principal
            clickButtonByXPath(driver, wait,
                    "//*[@id='root']/div/div[2]/div[2]/div/main/div[2]/div/div[4]/div/div/div/div[1]/img",
                    "Clic en Gestión de Evaluaciones");

            // Ir a la sección correcta según el módulo
            switch (modulo.toLowerCase()) {
                case "evaluaciones" ->
                        clickButtonByXPath(driver, wait,
                                "//*[@id='rc-tabs-0-panel-1']/div[1]/div/div[4]/div/div/div/div/div/p[1]",
                                "Ir a Biblioteca de Evaluaciones");
                case "secciones" ->
                        clickButtonByXPath(driver, wait,
                                "//*[@id='rc-tabs-0-panel-1']/div[1]/div/div[2]",
                                "Ir a Biblioteca de Secciones");
                case "retroalimentacion" ->
                        clickButtonByXPath(driver, wait,
                                "//*[@id='rc-tabs-0-panel-1']/div[1]/div/div[3]/div/div/div/div/div/p[1]",
                                "Ir a Biblioteca de Retroalimentación");
                case "preguntas" ->
                        clickButtonByXPath(driver, wait,
                                "//*[@id='rc-tabs-0-panel-1']/div[1]/div/div[1]/div/div/div/div/div/p[1]",
                                "Ir a Biblioteca de Preguntas");
                default -> Utils.logAction("⚠️ Módulo no reconocido para navegación: " + modulo);
            }
        } catch (Exception e) {
            Utils.logAction("❌ Error al navegar al módulo " + modulo + ": " + e.getMessage());
        }
    }

    // 🟩 CREAR NUEVO ELEMENTO
    public static void crearElemento(WebDriver driver, WebDriverWait wait, String modulo) {
        try {
            navegarAModulo(driver, wait, modulo);
            Utils.logAction("🟢 Creando nuevo registro en módulo: " + modulo);

            // Abrir formulario de creación
            clickButtonByXPath(driver, wait,
                    "//*[@id='rc-tabs-0-panel-1']/div[2]/div[1]/button",
                    "Abrir creación de nuevo registro");

            // Obtener datos desde JSON
            String nombre = DataProvider.getField(modulo, "nombre");
            String descripcion = DataProvider.getField(modulo, "descripcion");
            String identificador = DataProvider.getField(modulo, "identificador");
            String instrucciones = DataProvider.getField(modulo, "instrucciones");

            // Completar campos según existan
            if (!nombre.isEmpty())
                writeInTextBox(driver, wait, "//*[@id='name_id' or @id='id_nameSection']", nombre, "Nombre del registro");

            if (!descripcion.isEmpty())
                writeInTextBox(driver, wait, "//*[@id='description']", descripcion, "Descripción");

            if (!identificador.isEmpty())
                writeInTextBox(driver, wait, "//*[@id='id_nameId']", identificador, "Identificador");

            if (!instrucciones.isEmpty())
                writeInTextBox(driver, wait, "//*[@id='id_instructions']", instrucciones, "Instrucciones");

            // Guardar el registro
            clickButtonByXPath(driver, wait,
                    "//form//button[contains(@type,'submit') or contains(.,'Guardar')]",
                    "Guardar nuevo registro");

            Utils.logAction("✅ Registro creado correctamente en " + modulo);
        } catch (Exception e) {
            Utils.logAction("❌ Error al crear registro en " + modulo + ": " + e.getMessage());
        }
    }

    // ✏️ EDITAR ELEMENTO
    public static void editarElemento(WebDriver driver, WebDriverWait wait, String modulo) {
        try {
            navegarAModulo(driver, wait, modulo);
            Utils.logAction("✏️ Editando registro en módulo: " + modulo);

            // Abrir edición
            clickButtonByXPath(driver, wait,
                    "//*[@id='rc-tabs-0-panel-1']//table/tbody/tr[1]/td[last()]/button[1]",
                    "Abrir modo de edición");

            // Leer datos desde JSON
            String nombre = DataProvider.getField(modulo, "nombre");
            String descripcion = DataProvider.getField(modulo, "descripcion");
            String instrucciones = DataProvider.getField(modulo, "instrucciones");

            if (!nombre.isEmpty())
                writeInTextBox(driver, wait, "//*[@id='name_id' or @id='id_nameSection']", nombre, "Editando nombre");

            if (!descripcion.isEmpty())
                writeInTextBox(driver, wait, "//*[@id='description']", descripcion, "Editando descripción");

            if (!instrucciones.isEmpty())
                writeInTextBox(driver, wait, "//*[@id='id_instructions']", instrucciones, "Editando instrucciones");

            // Guardar
            clickButtonByXPath(driver, wait,
                    "//form//button[contains(@type,'submit') or contains(.,'Guardar')]",
                    "Guardar cambios");

            Utils.logAction("✅ Edición completada correctamente en " + modulo);
        } catch (Exception e) {
            Utils.logAction("❌ Error al editar módulo " + modulo + ": " + e.getMessage());
        }
    }

    // 🗑️ ELIMINAR ELEMENTO
    public static void eliminarElemento(WebDriver driver, WebDriverWait wait, String modulo) {
        try {
            navegarAModulo(driver, wait, modulo);
            Utils.logAction("🗑️ Eliminando registro en módulo: " + modulo);

            clickButtonByXPath(driver, wait,
                    "//*[@id='rc-tabs-0-panel-1']//table/tbody/tr[1]/td[last()]/button[2]",
                    "Clic en eliminar");
            clickButtonByXPath(driver, wait,
                    "//button[contains(.,'Confirmar') or contains(.,'Sí')]",
                    "Confirmar eliminación");

            Utils.logAction("✅ Registro eliminado correctamente en " + modulo);
        } catch (Exception e) {
            Utils.logAction("❌ Error al eliminar registro en " + modulo + ": " + e.getMessage());
        }
    }

    // 🚫 DESACTIVAR ELEMENTO
    public static void desactivarElemento(WebDriver driver, WebDriverWait wait, String modulo) {
        try {
            navegarAModulo(driver, wait, modulo);
            Utils.logAction("🚫 Desactivando registro en módulo: " + modulo);

            clickButtonByXPath(driver, wait,
                    "//*[@id=\"rc-tabs-0-panel-1\"]/div[2]/div[2]/div/div/div/div/div/table/tbody/tr[2]/td[5]/div/button[2]",
                    "Clic en desactivar");
            clickButtonByXPath(driver, wait,
                    "//*[@id=\":rt:\"]/div/div/div[2]/button[2]/span",
                    "Confirmar desactivación");

            Utils.logAction("✅ Registro desactivado correctamente en " + modulo);
        } catch (Exception e) {
            Utils.logAction("❌ Error al desactivar registro en " + modulo + ": " + e.getMessage());
        }
    }
}
