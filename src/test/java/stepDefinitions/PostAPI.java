package stepDefinitions;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostAPI {
    String endpoint;
    Response response;
    Map<String, String> requestPayload = new HashMap<>();
    @Given("the API endpoint for creating user is {string}")
public void the_api_endpoint_for_creating_user_is(String string) {
    endpoint = string;
}
@Given("the request contains name {string} and job {string}")
public void the_request_contains_name_and_job(String name, String job) {
    requestPayload.put("name", name);
        requestPayload.put("job", job);
}
@When("I send a POST request")
public void i_send_a_post_request() {
    response = given()
    .contentType(ContentType.JSON)
    .body(requestPayload)
    .when()
    .post(endpoint);
}

@Then("the response should contain {string}")
public void the_response_should_contain(String string) {
  
}
}
