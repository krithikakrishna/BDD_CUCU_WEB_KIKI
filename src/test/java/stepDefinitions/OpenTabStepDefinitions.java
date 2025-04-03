package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenTabStepDefinitions {
    WebDriver driver = new ChromeDriver();
    private String mainWindowHandle;

    @Given("I enter the URL of the practice page")
    public void i_enter_the_url_of_practice_page() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        mainWindowHandle = driver.getWindowHandle(); // Save the main window handle
    }

    @When("I click the open tab button")
    public void i_click_the_open_tab_button() {
        WebElement openTabBtn = driver.findElement(By.id("opentab"));
        openTabBtn.click();
    }

    @Then("I should see the new tab opened successfully")
    public void i_should_see_the_new_tab_opened_successfully() {
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!childWindow.equals(mainWindowHandle)) {
                driver.switchTo().window(childWindow);  // Switch to the new tab
                
                // ✅ Use Duration.ofSeconds instead of int
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.titleContains("QAClick Academy"));


                System.out.println("New Tab Title: " + driver.getTitle());

                driver.close();  // Close the new tab
                driver.switchTo().window(mainWindowHandle); // Switch back to main tab
                break;
            }
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
