package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConfirmationAlertCheck {
    WebDriver driver;
    WebDriverWait wait;

    // ✅ Constructor to initialize WebDriver & WebDriverWait
    public ConfirmationAlertCheck() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I enter the URL of the practice page for alert")
    public void i_enter_the_URL_of_the_practice_page_for_alert() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
    }

//     @When("I enter {string} in the text box")
// public void i_enter_in_the_text_box(String name) {
//     WebElement nameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name='enter-name']")));

//     nameInput.clear();
//     nameInput.sendKeys(name);
// }


//     @When("I click on the alert button")
//     public void i_click_on_the_alert_button() {
//         WebElement alertButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("alertbtn")));
//         alertButton.click();
//     }

    @When("I enter {string} in the text")
    public void i_enter_in_the_text(String name) {
        WebElement nameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name='enter-name']")));

        nameInput.clear();
        nameInput.sendKeys(name);
    }

    // @Then("I handle the alert popup")
    // public void i_handle_the_alert_popup() {
    //     Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    //     System.out.println("Alert Message: " + alert.getText());
    //     alert.accept();
    // }

    @When("I click on the confirm button")
    public void i_click_on_the_confirm_button() {
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmbtn")));
        confirmButton.click();
    }

    @Then("I handle the confirmation popup")
    public void i_handle_the_confirmation_popup() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Confirmation Message: " + alert.getText());
        alert.accept();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
