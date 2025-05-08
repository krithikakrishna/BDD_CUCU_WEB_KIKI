package api;

import data.BookStoreData;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Random;

public class UserApi {
    public static Response signUp(String email, String password, BookStoreData data) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\"email\":\"" + email + "\", \"password\":\"" + password + "\"}")
                .post("/signup");
    }

    public static Response login(String email, String password) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\"username\":\"" + email + "\", \"password\":\"" + password + "\"}")
                .post("/login");
    }

    public static String generateEmailAndPassword(int len) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < len; i++) {
            sb.append(chars.charAt(r.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
