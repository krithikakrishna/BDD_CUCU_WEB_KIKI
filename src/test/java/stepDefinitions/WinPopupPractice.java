package stepDefinitions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;

public class WinPopupPractice {
    WebDriver driver = new ChromeDriver();
    private String mainWindowHandle;
    @Given("I enter the url of practice page")
public void i_enter_the_url_of_practice_page() {
    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    mainWindowHandle = driver.getWindowHandle(); // Assign here after page load
    driver.getTitle();
}
@When("I click  open window button popup")
public void i_click_open_window_button_popup() {
   WebElement openWindowBtn = driver.findElement(By.id("openwindow"));
        openWindowBtn.click();
}
// @Then("I can see open window page successfully")
// public void i_can_see_open_window_page_successfully() {
//     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//     // Wait until there are more than 1 window handles (ensuring popup is fully opened)
//     wait.until(ExpectedConditions.numberOfWindowsToBe(2));

//     Set<String> windowHandles = driver.getWindowHandles();
//     for (String handle : windowHandles) {
//         if (!handle.equals(mainWindowHandle)) {
//             driver.switchTo().window(handle);  // Switch to the new window

//             // Wait for the page title to load (or any element specific to the new window)
//             wait.until(ExpectedConditions.titleIs("Expected Popup Title"));

//             System.out.println("New Window Title: " + driver.getTitle());

//             driver.close();  // Close the new window
//             driver.switchTo().window(mainWindowHandle); // Switch back to main window
//             break;
//         }
//     }
 //   }

 @Then("I can see open window page successfully")
public void i_can_see_open_window_page_successfully() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Wait until there are more than 1 window handles
    wait.until(ExpectedConditions.numberOfWindowsToBe(2));

    Set<String> windowHandles = driver.getWindowHandles();
    for (String handle : windowHandles) {
        if (!handle.equals(mainWindowHandle)) {
            driver.switchTo().window(handle);  // Switch to the new window
            System.out.println("Switched to new window: " + handle);
            driver.close();  // Close the new window
            driver.switchTo().window(mainWindowHandle); // Switch back to main window
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

