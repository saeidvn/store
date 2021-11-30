package com.solvd.store.persistence;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public final class Config {

    public static final String JDBC_DRIVER;
    public static final String URL;
    public static final String USER;
    public static final String PASSWORD;

    static {
        JDBC_DRIVER = getValueFromConfig("JDBC_DRIVER");
        URL = getValueFromConfig("URL");
        USER = getValueFromConfig("USER");
        PASSWORD = getValueFromConfig("PASSWORD");
    }

    private static String getValueFromConfig(String forVariable) {
        File fromFile = new File("./config.properties");
        String value = null;
        try {
            InputStream inputStream = Files.newInputStream(Paths.get("./config.properties"));
            Properties property = new Properties();
            property.load(inputStream);
            value = property.getProperty(forVariable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

}
