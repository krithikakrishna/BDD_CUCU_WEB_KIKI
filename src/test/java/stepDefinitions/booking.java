package stepDefinitions;

import java.time.Duration;

import java.util.List;


//import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.bookingpage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class booking {
     WebDriver driver = new ChromeDriver();
     bookingpage bookingPage = new bookingpage();


     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    @Given("I enter the booking url of domain")
public void i_enter_the_booking_url_of_domain() {
    driver.get("https://automationintesting.online/");
    driver.getTitle();
    
}
@When("I enter customer booking dates")
public void i_enter_customer_booking_dates() {
   
    WebElement bookNowClick = wait.until(ExpectedConditions.elementToBeClickable(bookingPage.bookNowPath));
    bookNowClick.click(); 
    System.out.println("Book in now is clicked");
}

@When("I enter customer creadentials")
public void i_enter_customer_creadentials() {
    // Wait for the first and last date to be clickable
    WebElement startDate = wait.until(ExpectedConditions.elementToBeClickable(bookingPage.startDatePath));
    WebElement endDate = wait.until(ExpectedConditions.elementToBeClickable(bookingPage.endDatePath));

    Actions actions = new Actions(driver);

    // Click and hold on the first date
    actions.clickAndHold(startDate).pause(500)  // Hold for a short duration

           // Move slightly to simulate drag instead of direct jump
           .moveByOffset(20, 0)  
           .moveToElement(endDate)  

           // Release mouse to complete drag
           .release()
           .perform();

    System.out.println(" Drag and Select completed!");
}
@Then("I can book successfully")
public void i_can_book_successfully() {
    // Find cancel button by text
    List<WebElement> cancelButtons = driver.findElements(bookingPage.cancelButtonPath);
    
    if (cancelButtons.isEmpty()) {
        // WebElement cancelButton = cancelButtons.get(0);
        // cancelButton.click();
        // System.out.println("✅ Existing booking cancelled!");

        // // Wait for main page to reload after cancellation
        // wait.until(ExpectedConditions.urlContains("automationintesting.online"));
        // System.out.println("✅ Navigated back to the main page!");
    } else {
        // Wait until form fields are visible
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(bookingPage.firstNamePath));
        WebElement lastName = driver.findElement(bookingPage.lastNamePath);
        WebElement emailId = driver.findElement(bookingPage.emailIdPath);
        WebElement phoneNo = driver.findElement(bookingPage.phoneNoPath);

        // Fill booking details
        firstName.sendKeys("Krithikakrish");
        lastName.sendKeys("Krishnakrish");
        emailId.sendKeys("test12345@gmail.com");
        phoneNo.sendKeys("948776787812");

        // Click book button
        WebElement bookButton = driver.findElement(bookingPage.bookBtnPath);
        bookButton.click();
        
        //Wait for booking confirmation
        wait.until(ExpectedConditions.or(
            ExpectedConditions.urlContains("confirmation"),
            ExpectedConditions.visibilityOfElementLocated(bookingPage.bookingConfirmationPath)
        ));

        System.out.println(" Booking successful!");

        //Testing assertion
        // WebElement errorMsg = driver.findElement(By.id("error"));
        // Assert.assertTrue("Booking Successful",errorMsg.isDisplayed());
        // System.out.println("Booking successfull");
    }
}
@After
public void close(){
    if(driver != null){
        driver.close();
    }
}



}
