package api;

import data.BookStoreData;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

public class BooksApi {
    public static Response addNewBook(HashMap<String, Object> bookDetails, String token, BookStoreData data) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .body(bookDetails)
                .post("/books");
    }

    public static Response editTheBook(HashMap<String, Object> bookDetails, String token) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .body(bookDetails)
                .put("/books");
    }

    public static Response getBookDetailsById(HashMap<String, Object> bookDetails, String token) {
        return RestAssured.given()
                .header("Authorization", token)
                .get("/books/" + bookDetails.get("createdBookId"));
    }

    public static Response getAllBooks(String token) {
        return RestAssured.given()
                .header("Authorization", token)
                .get("/books");
    }

    public static Response deleteTheBookById(String bookId, String token) {
        return RestAssured.given()
                .header("Authorization", token)
                .delete("/books/" + bookId);
    }
}
