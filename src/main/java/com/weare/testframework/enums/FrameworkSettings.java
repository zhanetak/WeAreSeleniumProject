package com.weare.testframework.enums;

public enum FrameworkSettings {
    BROWSER_TYPE("browserType"),
    BROWSER_MODE("browserMode"),
    DEFAULT_TIMEOUT_SECONDS("defaultTimeoutSeconds"),
    BASE_URL("WEAreBaseUrl"),
    LOGGING_LEVEL("loggingLevel"),      // TODO New
    ENVIRONMENT("environment");        // TODO New

    private final String key;

    FrameworkSettings(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return key;
    }
}

