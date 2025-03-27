package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class automationbooks {

     WebDriver driver = new ChromeDriver();
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    @Given("I enter the url of bookstore")
public void i_enter_the_url_of_bookstore() {
    driver.get("https://automationbookstore.dev/");
    driver.getTitle(); 
}
@SuppressWarnings("deprecation")
@When("I search books")
public void i_search_books() {
      WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBar")));
        searchBar.sendKeys("Agile");

        // Wait for filtered results
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Agile Testing')]")));
        //get the book list
        List<WebElement> bookResults = driver.findElements(By.xpath("//ul[@id='productList']/li[not(contains(@style, 'display: none'))]"));
         // Assert that at least one book is visible
         Assert.assertTrue("No books found after filtering!",bookResults.size() > 0 );
       
}
@Then("I can retrive books successfully")
public void i_can_retrive_books_successfully() {
    System.out.println("Search functionality works correctly!");
    driver.quit();
}
}