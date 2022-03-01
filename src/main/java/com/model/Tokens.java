package com.model;

import io.qameta.allure.Step;

public class Tokens {
    private static String accessToken;
    private static String refreshToken;

    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
        Tokens.accessToken = accessToken;
    }

    public static String getRefreshToken() {
        return refreshToken;
    }

    public static void setRefreshToken(String refreshToken) {
        Tokens.refreshToken = refreshToken;
    }

    @Step("Сброс токенов")
    public static void clearTokens() {
        Tokens.accessToken = null;
        Tokens.refreshToken = null;
    }
}
