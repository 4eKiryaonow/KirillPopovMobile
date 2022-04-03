package com.epam.tc.hw2.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    protected static Properties PROPERTIES;

    static {
        try (InputStream fileInputStream =
                 PropertiesReader
                     .class
                     .getClassLoader()
                     .getResourceAsStream("nativeweb.properties")) {

            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
