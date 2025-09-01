package com.weare.testframework.enums;

public enum BrowserMode {
    NORMAL,
    HEADLESS;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

    public static BrowserMode fromString(String mode) {
        return BrowserMode.valueOf(mode.toUpperCase());
    }
}

