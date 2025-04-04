package stepDefinitions;

import java.time.Duration;



import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM.bookingpage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class booking {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    bookingpage bookingPage = new bookingpage(driver); // Pass driver to POM class

    @Given("Open the booking application")
    public void open_the_booking_application() {
        driver.get("https://automationintesting.online/");
        driver.manage().window().maximize();
        System.out.println("✅ User landed on homepage");
    }

    @When("select the room")
    public void select_the_room() {
        WebElement bookRoomButton = wait.until(ExpectedConditions.elementToBeClickable(bookingPage.bookRoomPath));
        bookRoomButton.click();
        System.out.println("✅ Room selection successful");
    }

    @When("select the date")
    public void select_the_date() {
        WebElement startDate = wait.until(ExpectedConditions.elementToBeClickable(bookingPage.startDatePath));
        WebElement endDate = wait.until(ExpectedConditions.elementToBeClickable(bookingPage.endDatePath));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", startDate);
        js.executeScript("arguments[0].click();", endDate);

        System.out.println("✅ Selected start date and end date successfully");
    }


    @When("Enter the details")
    public void enter_the_details() {
        driver.findElement(bookingPage.firstNamePath).sendKeys("Krithika");
        driver.findElement(bookingPage.lastNamePath).sendKeys("Krishna");
        driver.findElement(bookingPage.emailPath).sendKeys("krithikakrishna@gmail.com");
        driver.findElement(bookingPage.phonePath).sendKeys("927262728283");
        System.out.println("✅ Entered booking details");
    }

    @Then("Book the ticket")
    public void book_the_ticket() {
        WebElement bookTicBut = wait.until(ExpectedConditions.elementToBeClickable(bookingPage.bookButtonPath));
        bookTicBut.click();
        System.out.println("✅ Booking request submitted");
    }

    @Then("Confirm the booking")
    public void confirm_the_booking() {
        boolean isBookingConfirmed = !driver.findElements(bookingPage.cancelButtonPath).isEmpty();

        if (isBookingConfirmed) {
            System.out.println("✅ Booking confirmed!");
        } else {
            System.out.println("❌ Booking failed, no cancel button found.");
        }
      

    }

    @After
public void close(){
    if(driver != null){
        driver.close();
    }
}


}
