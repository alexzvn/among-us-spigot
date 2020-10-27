package dev.alexzvn.among.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Json {

    public static JsonObject parse(String json) {
        return new JsonParser().parse(json).getAsJsonObject();
    }

    public static JsonObject from(String file, String provider) {

        File filePath = getDefaultFile(file, provider);
        List<String> jsonContents;
        String json = new String();

        try {
            jsonContents = Files.readAllLines(filePath.toPath());

            for (String line : jsonContents) {
                json = json.concat(line);
            }

            return parse(json);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void save(String file, String provider, JsonObject json) {
        File saveFile = getDefaultFile(file, provider);

        try {
            FileWriter writer = new FileWriter(saveFile);

            writer.write(beautify(json));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String beautify(JsonElement uglyJson) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(uglyJson);
    }

    private static File getDefaultFile(String file, String folder) {
        String pluginFolder = Plugin.getPlugin().getClass().getName().concat("//").concat(folder);

        File path = new File(pluginFolder);

        if (!path.exists()) {
            path.mkdir();
        }

        File filePath = new File(pluginFolder, file.concat(".json"));

        if (!filePath.exists()) {
            try {
                filePath.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return filePath;
    }
}
