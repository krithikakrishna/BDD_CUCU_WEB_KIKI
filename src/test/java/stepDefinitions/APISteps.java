package stepDefinitions;
import static io.restassured.RestAssured.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class APISteps {
    private Response response;
    @Given("the API is available")
public void the_api_is_available() {
      baseURI = "https://reqres.in";
}
@When("I send a GET request to {string}")
public void i_send_a_get_request_to(String endpoint) {
    response = given().when().get(endpoint); 

}
@Then("the response status code should be {int}")
public void the_response_status_code_should_be(Integer int1) {
    response.then().statusCode(int1);
}
@Then("the response should contain user detail")
public void the_response_should_contain_user_detail() {
    response.prettyPrint();
}
}
