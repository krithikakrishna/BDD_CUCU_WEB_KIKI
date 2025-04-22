package stepDefinitions;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import io.cucumber.java.en.*;
import static org.hamcrest.Matchers.*;

public class GetStepsRestAssured {
    Response response;

    @Given("I set the GET endpoint for user with ID {string}")
    public void setGetEndpoint(String id) {
        baseURI = "https://reqres.in"; // your base URL
        basePath = "/api/users/" + id;
    }

    @When("I send the GET HTTP request")
    public void sendGetRequest() {
        response = given().when().get();
    }

    @Then("I should receive a {int} status codes")
    public void verifyStatusCode(int statusCodes) {
        response.then().statusCode(statusCodes);
    }

    @Then("I should see user details in the response")
    public void verifyUserDetails() {
        response.then().body("data.id", equalTo(2));
    }
}
