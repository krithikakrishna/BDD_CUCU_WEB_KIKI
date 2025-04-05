package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StatusCodeNavigationSteps {
    WebDriver driver;

    @Given("I am on the Status Codes page")
    public void i_am_on_the_status_codes_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/status_codes"); 
    }

    @When("I click on status code {string}")
    public void i_click_on_status_code(String code) {
        driver.findElement(By.xpath("//a[contains(@href, 'status_codes/" + code + "')]")).click();
    }

    @Then("I should be navigated to the status code {string} page")
    public void i_should_be_navigated_to_the_status_code_page(String code) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("URL does not contain the status code", currentUrl.contains("status_codes/" + code));
    }

    @And("I click the back link")
    public void i_click_the_back_link() {
        driver.findElement(By.xpath("//a[contains(@href, '/status_codes')]")).click();
    }

    @Then("I should be navigated back to the Status Codes page")
    public void i_should_be_navigated_back_to_the_status_codes_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Not navigated back", currentUrl.endsWith("/status_codes"));
        driver.quit();
    }
}
