package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class logintest {
    WebDriver driver = new ChromeDriver();
    @Given("I enter the url of domain")
public void i_enter_the_url_of_domain() {
    driver.get("https://demowebshop.tricentis.com/");
    driver.getTitle();
}
@When("I enter customer credentials")
public void i_enter_customer_credentials() {
    Actions actions = new Actions(driver);

    WebElement computersMenu = driver.findElement(By.xpath("//a[@href='/computers']"));
    actions.moveToElement(computersMenu).perform();
    System.out.println(" Hovered over 'Computers'");

    WebElement desktopsSubmenu = driver.findElement(By.xpath("//a[@href='/desktops']"));
    desktopsSubmenu.click();
    System.out.println(" Clicked on 'Desktops'");

    WebElement cartLink = driver.findElement(By.xpath("//a[@href='/build-your-own-computer']"));
    cartLink.click();
    System.out.println(" Clicked on purchase ");

    WebElement optionList = driver.findElement(By.className("option-list"));
    List<WebElement> radioButtons = optionList.findElements(By.tagName("input"));
    boolean isSelected = false;
    if (!isSelected && !radioButtons.isEmpty()) {
        radioButtons.get(0).click();
        System.out.println("Selected the first option automatically: " + radioButtons.get(0).getDomAttribute("value"));
    } else if (radioButtons.isEmpty()) {
        System.out.println(" No options found in 'option-list'");
    }

 
    WebElement addToCart = driver.findElement(By.id("add-to-cart-button-16"));
    addToCart.click();
    System.out.println("Clicked on cart ");

   

    try {
        WebElement notification = driver.findElement(By.id("bar-notification"));
        
        // Wait for notification to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(notification));

        if (notification.isDisplayed()) {
            System.out.println(" Notification is displayed: " + notification.getText());
        } else {
            System.out.println(" Notification is NOT displayed");
        }
        
        // Optionally, close the notification
        WebElement closeButton = notification.findElement(By.className("close"));
        closeButton.click();
        System.out.println("Closed notification");
    } catch (NoSuchElementException e) {
        System.out.println("Notification not found!");
    }

    WebElement goToCart = driver.findElement(By.id("topcartlink"));
    goToCart.click();
    System.out.println("open shopping cart ");
    
    


    // driver.navigate().back();

    // actions.moveToElement(computersMenu).perform();
    // WebElement npSubmenu = driver.findElement(By.xpath("//a[@href='/notebooks']"));
    // npSubmenu.click();
    // System.out.println("✅ Clicked on 'Notebooks'");

    // driver.navigate().back();

    // actions.moveToElement(computersMenu).perform();
    // WebElement accSubmenu = driver.findElement(By.xpath("//a[@href='/accessories']"));
    // accSubmenu.click();
    // System.out.println("✅ Clicked on 'Accessories'"); 
}
@Then("I can login domain successfully")
public void i_can_login_domain_successfully() {

    driver.quit();
}
}
