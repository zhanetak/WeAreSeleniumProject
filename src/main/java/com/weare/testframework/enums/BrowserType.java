package com.weare.testframework.enums;

public enum BrowserType {
    CHROME,
    FIREFOX,
    EDGE;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

    public static BrowserType fromString(String type) {
        return BrowserType.valueOf(type.toUpperCase());
    }
}

