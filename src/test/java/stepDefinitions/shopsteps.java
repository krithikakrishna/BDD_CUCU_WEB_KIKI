package stepDefinitions;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pom.shoppingpage;
import java.time.Duration;




public class shopsteps {

    WebDriver driver = new ChromeDriver();
    shoppingpage shop = new shoppingpage();
@Given("I navigate to the shopping page")
public void i_navigate_to_the_shopping_page() {
   
  
   // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
     driver.get("https://magento.softwaretestingboard.com/");
    driver.getTitle();
   System.out.println("Enter the product successfully ");
}
@When("I select a product")
public void i_select_a_product() {

    WebElement productLink = driver.findElement(shop.productBy);
    productLink.click();
    System.out.println("Product Clicked");
   
    
}
/**
 * 
 */
@When("I choose the size, color, and quantity")
public void i_choose_the_size_color_and_quantity() {
    // //choose firts size
         List<WebElement> sizeOptions = driver.findElements(shop.sizeOption);
         if (!sizeOptions.isEmpty()) {
            sizeOptions.get(0).click();
            System.out.println("First size selected: " + sizeOptions.get(0).getText());
        } else {
            System.out.println("No size options available!");
        }

        List<WebElement> colorOptions = driver.findElements(shop.coloBy);

        // Click on the first color option (index 0)
        if (!colorOptions.isEmpty()) {
            colorOptions.get(0).click();
            System.out.println("First color selected: " + colorOptions.get(0).getDomAttribute("aria-label"));
        } else {
            System.out.println("No color options available!");
        }
    WebElement addCart = driver.findElement(shop.addToCartBy);
    addCart.click();
  
   
    
}
@SuppressWarnings("deprecation")
@When("I add the product to the cart")
public void i_add_the_product_to_the_cart() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 

    WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
       shop.errorMessageBy ));
    String expectedMessage = "You added Radiant Tee to your shopping cart.";
    String actualMessage = successMessage.getText();

    Assert.assertTrue("Success message is incorrect!", actualMessage.contains(expectedMessage));

    System.out.println(" Success message verified: " + actualMessage);
    
}
@Then("I should be redirected to the shopping cart page")
public void i_should_be_redirected_to_the_shopping_cart_page() {
   
    WebElement cartPage = driver.findElement(shop.cartPageBy);
    cartPage.click();
    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    // Wait for checkout button to be visible
    WebElement checkOut = wait.until(ExpectedConditions.visibilityOfElementLocated(shop.checkOutBy));
    System.out.println("Redirected to Shopping Page");
    
    checkOut.click();
    wait.until(ExpectedConditions.urlContains("checkout/#shipping"));
    
    System.out.println("Navigate to shipping");

    System.out.println("Ordered successfully");

    driver.quit();
    
    
}
// @Then("I should be able to proceed to checkout")
// public void i_should_be_able_to_proceed_to_checkout() {

    

//     WebElement customerEmail = driver.findElement(By.id("customer-email"));
//     customerEmail.sendKeys("test@gamsil.com");
//     WebElement customerFName = driver.findElement(By.id("uid"));
//     customerFName.sendKeys("Krithika");
//     WebElement customerLName = driver.findElement(shop.cutomerLNBy);
//     customerLName.sendKeys("Krishna");
//     WebElement customerStreet = driver.findElement(shop.cutomerAddBy);
//     customerStreet.sendKeys("cuddalore");
//     WebElement customerCity = driver.findElement(shop.cityBy);
//     customerCity.sendKeys("cuddalore");
    

//     WebElement customerState = driver.findElement(shop.stateBy);
//     Select stateDropdown = new Select(customerState);
//     stateDropdown.selectByVisibleText("Tamil Nadu");

//     WebElement customerZip = driver.findElement(shop.zipBy);
//     customerZip.sendKeys("607006");

//     WebElement customerCountry = driver.findElement(shop.countryBy);
//     Select countryDropdown = new Select(customerCountry);
//     countryDropdown.selectByVisibleText("India");

//     WebElement customerPhone = driver.findElement(shop.cutomerPhnBy);
//     customerPhone.sendKeys("9486990647");

    
    
    
   
   
    
   
//     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//     WebElement nextStep = wait.until(ExpectedConditions.elementToBeClickable(shop.nextStep));
//     nextStep.click();

//     System.out.println("Ordered successfully");
    
    


// }
    
}
