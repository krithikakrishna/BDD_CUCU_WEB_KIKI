package stepDefinitions;

import api.BooksApi;
import api.UserApi;
import data.BookStoreData;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static api.UserApi.generateEmailAndPassword;

public class UserSteps {
    private final BookStoreData bookStoreData = new BookStoreData();
    private final HashMap<String, Object> bookDetails = new HashMap<>();
    private final List<HashMap<String, Object>> allBooksList = new ArrayList<>();

    @Given("Sign up to the book store as the new user with email and password")
    public void signUpToBookStore() {
        bookStoreData.setValidEmailUsed(UserApi.generateEmailAndPassword(10) + "@gmail.com");
        bookStoreData.setValidPasswordUsed(UserApi.generateEmailAndPassword(8));
    }

    @When("do the sign up with valid credentials")
    public void doSignUpWithValidCredentials() {
        Response response = UserApi.signUp(
                bookStoreData.getValidEmailUsed(),
                bookStoreData.getValidPasswordUsed(),
                bookStoreData
        );
        bookStoreData.setSignUpResponse(response);
    }

    @Then("validate that the response code is {int} and response message should be {string} after sign up")
    public void validateSignUpResponse(int statusCode, String responseMsg) {
        Assert.assertEquals(bookStoreData.getSignUpResponse().getStatusCode(), statusCode);
        if (statusCode == 200) {
            Assert.assertEquals(bookStoreData.getSignUpResponse().jsonPath().get("message"), responseMsg);
        } else if (statusCode == 400) {
            Assert.assertEquals(bookStoreData.getSignUpResponse().jsonPath().get("detail"), responseMsg);
        }
    }

    @When("user tried to login with valid credentials into book store system")
    public void userLogin() {
        Response loginResp = UserApi.login(
                bookStoreData.getValidEmailUsed(),
                bookStoreData.getValidPasswordUsed()
        );
        bookStoreData.setLogInResponse(loginResp);
    }

    @Then("verify the response after login into book store should {int} and {string}")
    public void validateLoginResponse(int statusCode, String condition) {
        Assert.assertEquals(bookStoreData.getLogInResponse().getStatusCode(), statusCode);
        switch (condition) {
            case "successLogin":
                String token = bookStoreData.getLogInResponse().jsonPath().get("access_token");
                Assert.assertNotNull(token, "Access token not generated");
                Assert.assertEquals(bookStoreData.getLogInResponse().jsonPath().get("token_type"), "bearer");
                bookStoreData.setAccessToken("Bearer " + token);
                break;
        }
    }

    @Given("Adding the new book into the store after successful login of user into the system")
    public void addBookDetails() {
        long id = System.nanoTime();
        bookDetails.put("bookName", "Book Title " + id);
        bookDetails.put("author", "Author " + id);
        bookDetails.put("published_year", id);
        bookDetails.put("book_summary", "Summary " + id);
        allBooksList.add(new HashMap<>(bookDetails));
    }

    @When("add new book into book store with valid login token of user")
    public void addNewBook() {
        Response addResp = BooksApi.addNewBook(bookDetails, bookStoreData.getAccessToken(), bookStoreData);
        bookStoreData.setAddBookResponse(addResp);
    }

    @Then("verify the response after adding the new book should be {string}")
    public void validateAddBookResponse(String condition) {
        if (condition.equalsIgnoreCase("success")) {
            Assert.assertNotNull(bookStoreData.getAddBookResponse().jsonPath().get("id"));
            bookDetails.put("createdBookId", bookStoreData.getAddBookResponse().jsonPath().get("id"));
            Assert.assertEquals(bookStoreData.getAddBookResponse().jsonPath().get("name"), bookDetails.get("bookName"));
            Assert.assertEquals(bookStoreData.getAddBookResponse().jsonPath().get("author"), bookDetails.get("author"));
            Assert.assertEquals(bookStoreData.getAddBookResponse().jsonPath().get("published_year"), bookDetails.get("published_year"));
            Assert.assertEquals(bookStoreData.getAddBookResponse().jsonPath().get("book_summary"), bookDetails.get("book_summary"));
        }
    }

    @When("get the details of the particular book using book id generated while creating")
    public void getBookById() {
        Response getResp = BooksApi.getBookDetailsById(bookDetails, bookStoreData.getAccessToken());
        bookStoreData.setGetBookDetailsById(getResp);
    }

    @Then("verify the book details are fetched properly in the response by book id")
    public void verifyBookDetails() {
        Assert.assertEquals(bookStoreData.getGetBookDetailsById().jsonPath().get("name"), bookDetails.get("bookName"));
        Assert.assertEquals(bookStoreData.getGetBookDetailsById().jsonPath().get("author"), bookDetails.get("author"));
        Assert.assertEquals(bookStoreData.getGetBookDetailsById().jsonPath().get("published_year"), bookDetails.get("published_year"));
        Assert.assertEquals(bookStoreData.getGetBookDetailsById().jsonPath().get("book_summary"), bookDetails.get("book_summary"));
    }

    @And("delete the added book in the book store using book id and verify the response")
    public void deleteBookById() {
        Response deleteResp = BooksApi.deleteTheBookById(bookDetails.get("createdBookId").toString(), bookStoreData.getAccessToken());
        bookStoreData.setDeleteBookResponse(deleteResp);
    }

    @And("verify the response after deleting the book should be {string}")
    public void validateDeleteResponse(String condition) {
        if (condition.equalsIgnoreCase("Success")) {
            Assert.assertEquals(bookStoreData.getDeleteBookResponse().getStatusCode(), 200);
            Assert.assertEquals(bookStoreData.getDeleteBookResponse().jsonPath().get("message"), "Book deleted successfully");
        }
    }

    
}
