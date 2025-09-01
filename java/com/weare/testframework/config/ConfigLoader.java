package com.weare.testframework.config;

import com.weare.testframework.enums.BrowserType;
import com.weare.testframework.enums.BrowserMode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties properties = new Properties();

    static {
        try {
            // Load base configuration
            properties.load(new FileInputStream(System.getProperty("config.path", "src/test/resources/config.properties")));

            // Load environment-specific configuration (if available)
            properties.putAll(EnvironmentConfig.loadEnvironmentProperties());
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration properties.", e);
        }
    }

    public static String get(String key, String defaultValue) {
        return System.getProperty(key, properties.getProperty(key, defaultValue));
    }

    public static int getInt(String key, int defaultValue) {
        return Integer.parseInt(get(key, String.valueOf(defaultValue)));
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return Boolean.parseBoolean(get(key, String.valueOf(defaultValue)));
    }

    public static String getBaseUrl() {
        return get("WEAreBaseUrl", "http://localhost:8081");
    }

    public static BrowserType getBrowserType() {
        return BrowserType.valueOf(get("browserType", "CHROME").toUpperCase());
    }

    public static BrowserMode getBrowserMode() {
        return BrowserMode.valueOf(get("browserMode", "NORMAL").toUpperCase());
    }

    public static int getTimeout() {
        return Integer.parseInt(get("defaultTimeoutSeconds", "10"));
    }

}
