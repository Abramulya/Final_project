package utils;

import io.restassured.RestAssured;

public class ApiClient {
    private static final String BASE_URL = "https://qa-desk.stand.praktikum-services.ru";

    public static void init() {
        RestAssured.baseURI = BASE_URL;
    }
}