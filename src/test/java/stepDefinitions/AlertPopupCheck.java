package stepDefinitions;

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

public class AlertPopupCheck {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait;  // Declare wait

    @Given("I enter the URL of the practice page for confirmation")
    public void i_enter_the_url_of_the_practice_page_for_confirmation() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10)); // Initialize wait
    }

    @When("I enter {string} in the textbox")
    public void i_enter_in_the_textbox(String name) {
        WebElement nameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name='enter-name']")));
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    @When("I click on the alert button")
    public void i_click_on_the_alert_button() {
        WebElement alertButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("alertbtn")));
        alertButton.click();
    }

    @Then("I handle the alert popup")
    public void i_handle_the_alert_popup() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert Message: " + alert.getText());
        alert.accept();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

