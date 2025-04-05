package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressSteps {
    WebDriver driver;

    @Given("I am on the Key Press page")
    public void i_am_on_the_key_press_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/key_presses"); // Replace with actual URL
    }

@When("I press the {string} key")
public void i_press_the_key(String key) {
    WebElement inputField = driver.findElement(By.id("target")); // Ensure correct input field ID
    Actions actions = new Actions(driver);

    switch (key.toUpperCase()) {
        case "TAB":
            inputField.sendKeys(Keys.TAB);
            break;
        case "ENTER":
            actions.sendKeys(Keys.ENTER).perform(); // Use Actions class to send ENTER
            break;
        case "ESCAPE":
            inputField.sendKeys(Keys.ESCAPE);
            break;
        case "ALT":
            inputField.sendKeys(Keys.ALT);
            break;
        case "SHIFT":
            inputField.sendKeys(Keys.SHIFT);
            break;
        default:
            throw new IllegalArgumentException("Invalid key: " + key);
    }
}

@Then("I should see the message {string}")
public void i_should_see_the_message(String expectedMessage) {
    WebElement resultMessage = driver.findElement(By.id("result"));
    String actualMessage = resultMessage.getText().trim();

    // Debugging
    System.out.println("Actual message: '" + actualMessage + "'");
    System.out.println("Expected message: '" + expectedMessage + "'");

    // Case insensitive + trim extra spaces
    Assert.assertEquals("Key press message does not match!", expectedMessage.trim().toLowerCase(), actualMessage.trim().toLowerCase());

    driver.quit();
}
}