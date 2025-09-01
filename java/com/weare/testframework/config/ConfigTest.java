package com.weare.testframework.config;

public class ConfigTest {
    public static void main(String[] args) {
        System.out.println("Base URL: " + ConfigLoader.getBaseUrl());
        System.out.println("Browser Type: " + ConfigLoader.getBrowserType());
        System.out.println("Timeout: " + ConfigLoader.getTimeout());
    }
}

