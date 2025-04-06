package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContextMenuSteps {
    WebDriver driver = new ChromeDriver();
    Alert alert;

    @Given("I open the context menu webpage")
    public void i_open_the_context_menu_webpage() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/context_menu");  
    }

    @When("I right-click on the context menu box")
    public void i_right_click_on_the_context_menu_box() {
        WebElement contextMenuBox = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(contextMenuBox).perform(); // Right-click action
    }
    
    @Then("I should see an alert with text {string}")
    public void i_should_see_an_alert_with_text(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        alert = wait.until(ExpectedConditions.alertIsPresent()); // Wait for alert

        String actualAlertText = alert.getText();
        System.out.println("Actual Alert Text: " + actualAlertText); // Debugging purpose

        Assert.assertEquals("Alert text does not match!", expectedText, actualAlertText);
    }

    @And("I accept the alert")
    public void i_accept_the_alert() {
        if (alert != null) {
            alert.accept(); // Clicks OK on the alert
        }
    }

    @And("I close the browser")
    public void i_close_the_browser() {
        driver.quit();
    }
}
