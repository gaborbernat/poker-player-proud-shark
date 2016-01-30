package org.leanpoker;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileInputStream;

public class JsonTestHelper {
    public String getRequestAsString(String name) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(name + ".json").getFile());
        FileInputStream fis;

        try {
            byte[] data = new byte[(int) file.length()];
            fis = new FileInputStream(file);
            fis.read(data);
            fis.close();

            return new String(data, "UTF-8");

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public JsonElement getRequest(String name) {
        return new JsonParser().parse(getRequestAsString(name));
    }
}
