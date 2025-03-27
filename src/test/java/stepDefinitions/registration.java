package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class registration {
      WebDriver driver = new ChromeDriver();
    
    @Given("I enter the registration url of domain")
public void i_enter_the_registration_url_of_domain() {
    driver.get("https://demowebshop.tricentis.com/register");
    driver.getTitle();
}
@When("I enter new customer credentials")
public void i_enter_new_customer_credentials() {
   
     WebElement firstName = driver.findElement(By.id("FirstName"));
    WebElement lastName = driver.findElement(By.id("LastName"));
    WebElement emailAddress = driver.findElement(By.id("Email"));
    WebElement password = driver.findElement(By.id("Password"));
    WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
    WebElement registerButton = driver.findElement(By.id("register-button"));
    registerButton.click();

    checkError(driver,"First name is required");
    checkError(driver, "Last name is required");
    checkError(driver, "Email is required");
    checkError(driver, "Password is required");
    checkError(driver, "ActualPassword is required");

    firstName.sendKeys("Krithika");
    lastName.sendKeys("Krishna");
    emailAddress.sendKeys("test@gamsil.com");
    password.sendKeys("test123");
    confirmPassword.sendKeys("test123");
    
    String passwordValue = password.getAttribute("value");
    String confirmPasswordValue = confirmPassword.getAttribute("value");
    if (passwordValue.length() <= 6) {
        System.out.println("  Password must be more than 6 characters!");
    } else if (!passwordValue.isEmpty() && passwordValue.equals(confirmPasswordValue)) {
        System.out.println("Registered successfully ");
    }
    else if (passwordValue.isEmpty() || confirmPasswordValue.isEmpty()) {
        System.out.println(" Password fields cannot be empty!");
    } else {
        System.out.println(" Password incorrect");
    }
     driver.quit();   
   }

    private static void checkError(WebDriver driver, String errorId) {
        try {
            WebElement error = driver.findElement(By.id(errorId));
            if (error.isDisplayed()) {
                System.out.println("Error displayed: " + error.getText());
            } else {
                System.out.println(" Error not displayed: " + errorId);
            }
        } catch (Exception e) {
            System.out.println(" Error message not found: " + errorId);
        }
    }

@Then("I can register domain successfully")
public void i_can_register_domain_successfully() {
  
    System.out.println("Customer Registered Succesfully");
    driver.quit();

}
}
