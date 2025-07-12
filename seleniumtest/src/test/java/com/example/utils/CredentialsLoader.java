package com.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CredentialsLoader {

    private static final Properties properties = new Properties();

    static { 
        try(InputStream input = CredentialsLoader.class.getClassLoader().getResourceAsStream("credentials.properties")) {
            if(input != null) {
                properties.load(input);
            } else {
                System.err.println("Properties file not found in classpath.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    
}
