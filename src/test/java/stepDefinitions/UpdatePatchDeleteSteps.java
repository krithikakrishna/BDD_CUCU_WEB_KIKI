package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class UpdatePatchDeleteSteps {

    private String response;

    @Given("the API is up and running")
    public void theApiIsUpAndRunning() {
        // You can add any setup logic here if needed
    }

    @When("I send a PUT request to update the user with ID 2")
    public void iSendAPutRequestToUpdateTheUserWithId() {
        response = given()
            .body("{ \"name\": \"Updated Name\" }")
            .contentType("application/json")
            .when()
            .put("https://reqres.in/api/users/2")
            .then()
            .statusCode(200)
            .extract().asString();
    }

    @When("I send a PATCH request to update the user with ID 2")
    public void iSendAPatchRequestToUpdateTheUserWithId() {
        response = given()
            .body("{ \"name\": \"Patched Name\" }")
            .contentType("application/json")
            .when()
            .patch("https://reqres.in/api/users/2")
            .then()
            .statusCode(200)
            .extract().asString();
    }

    @When("I send a DELETE request to remove the user with ID 2")
    public void iSendADeleteRequestToRemoveTheUserWithId() {
        response = given()
            .when()
            .delete("https://reqres.in/api/users/2")
            .then()
            .statusCode(204)
            .extract().asString();
    }

    @Then("I should receive a success response")
public void iShouldReceiveASuccessResponse() {
    if (response == null || response.isEmpty()) {
        // For DELETE request, check the status code 204 (No Content)
        assertEquals(204, given()
            .when()
            .delete("https://reqres.in/api/users/2")
            .then()
            .extract().statusCode());
    } else {
        // For PUT and PATCH requests, check that the response is not empty
        assertEquals(true, response != null && !response.isEmpty());
    }
}

}
