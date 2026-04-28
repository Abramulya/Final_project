package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.User;

import java.util.HashMap;
import java.util.Map;

public class ApiClient {
    private static final String BASE_URL = "https://qa-desk.education-services.ru";

    public static void init() {
        RestAssured.baseURI = BASE_URL;
    }

    public static void registerUser(User user) {
        Map<String, String> body = new HashMap<>();
        body.put("email", user.getEmail());
        body.put("password", user.getPassword());
        body.put("submitPassword", user.getPassword());

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .post("/api/signup");

        int statusCode = response.statusCode();

        if (statusCode != 200 && statusCode != 201) {
            System.out.println("❌ Ошибка регистрации: " + statusCode);
            System.out.println("   Body: " + response.getBody().asString());
            throw new RuntimeException("Не удалось зарегистрировать пользователя: " + statusCode);
        }

        String token = response.jsonPath().getString("access_token.access_token");
        String userId = response.jsonPath().getString("user.id");
        user.setToken(token);
        user.setId(userId);

        System.out.println("✅ Пользователь зарегистрирован: " + user.getEmail() + " (id=" + userId + ")");
    }
}