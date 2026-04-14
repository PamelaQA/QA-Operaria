package core;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataProvider {
    private static JSONObject data;

    static {
        try {
            String content = Files.readString(Paths.get("data/ediciones.json"));
            data = new JSONObject(content);
        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo de datos: " + e.getMessage());
            data = new JSONObject();
        }
    }

    public static JSONObject getModuleData(String moduleName) {
        return data.optJSONObject(moduleName.toLowerCase());
    }

    public static String getField(String moduleName, String field) {
        JSONObject moduleData = getModuleData(moduleName);
        if (moduleData != null) {
            return moduleData.optString(field, "");
        }
        return "";
    }
}
