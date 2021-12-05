package com.solvd.store.persistence;

import com.solvd.store.domain.exeption.ProcessingException;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

public class PropertiesHolder {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream inputStream = PropertiesHolder.class.getClassLoader().getResourceAsStream("config.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new ProcessingException("Unable to find properties file. " + e.getMessage(), e);
        }
    }

    public enum Name {
        DRIVER("DRIVER"),
        URL("URL"),
        USERNAME("USERNAME"),
        PASSWORD("PASSWORD"),
        CONNECTION_POOL_SIZE("CONNECTION_POOL_SIZE");

        private final String name;

        Name(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static String getProperty(Name name) {
        return PROPERTIES.getProperty(name.getName());
    }
}
