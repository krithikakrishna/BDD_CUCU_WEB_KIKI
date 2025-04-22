package stepDefinitions;

import org.json.JSONObject;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;



public class PostStepsRestAssuredApi {
   Response response;
    JSONObject requestBody;

    @Given("I set the POST endpoint for creating user")
    public void setPostEndpoint() {
        baseURI = "https://reqres.in"; // Replace with your actual base URL
        basePath = "/api/users";
    }

    @And("I prepare request body with name {string} and job {string}")
    public void prepareRequestBody(String name, String job) {
        requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("job", job);
    }

    @When("I send a POST HTTP request")
    public void sendPostRequest() {
        response = given()
            .header("Content-Type", "application/json")
            .body(requestBody.toString())
        .when()
            .post();
    }

    @Then("the response status codes should be {int}")
    public void verifyStatusCode(int expectedCode) {
        response.then().statusCode(expectedCode);
    }

    @And("the response should contain the user ID and creation timestamp")
    public void verifyResponseFields() {
        response.then().body("id", notNullValue());
        response.then().body("createdAt", notNullValue());
    }
    
}
