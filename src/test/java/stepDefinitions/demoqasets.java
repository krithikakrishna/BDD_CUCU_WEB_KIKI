package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class demoqasets {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Actions actions;

    @Given("I navigate to the website")
public void i_navigate_to_the_website() {
    driver.get("https://demoqa.com/elements");
    driver.getTitle();
}
@When("I enter {string} in the name text box")
public void i_enter_in_the_name_text_box(String name) {
    WebElement testBox = driver.findElement(By.xpath("//*[@id=\"item-0\"]"));
    testBox.click();
    WebElement fullName = driver.findElement(By.id("userName"));
    fullName.sendKeys(name); // Use parameterized value
    
}
@When("I enter {string} in the email text box")
public void i_enter_in_the_email_text_box(String email) {

    WebElement emailId = driver.findElement(By.id("userEmail"));
    emailId.sendKeys(email); // Use parameterized value

    WebElement addressText = driver.findElement(By.id("currentAddress"));
    addressText.sendKeys("bangalore");

    WebElement permanantText = driver.findElement(By.id("permanentAddress"));
    permanantText.sendKeys("chennai");


    
}
@SuppressWarnings("deprecation")
@Then("The text boxes should contain the entered values {string} and {string}")
public void the_text_boxes_should_contain_the_entered_values(String expectedName, String expectedEmail) {

    WebElement fullName = driver.findElement(By.id("userName"));
    WebElement emailId = driver.findElement(By.id("userEmail"));

    // ✅ Use dynamic expected values from the feature file
    Assert.assertEquals(expectedName, fullName.getAttribute("value"));
    Assert.assertEquals(expectedEmail, emailId.getAttribute("value"));

    WebElement submitBtn = driver.findElement(By.id("submit"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
    submitBtn.click();

    driver.quit();
}

// @After
// public void tearDown() {
//     if (driver != null) {
//         driver.quit();
//     }
// }

//checkbox



// @When("I select the {string} checkbox")
// public void i_select_the_checkbox_should_be_selected1(String checkboxName) {
//     WebElement checkBoxSection = driver.findElement(By.xpath("//*[@id='item-1']"));
//     checkBoxSection.click();

//     // Ensure the necessary parent nodes are expanded
//     expandParentNodesIfNeeded(checkboxName);

//     // Locate and click the checkbox
//     WebElement checkBox = driver.findElement(By.xpath("//span[@class='rct-title' and text()='" + checkboxName + "']/preceding-sibling::span[@class='rct-checkbox']"));
//     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBox);
//     checkBox.click();

//     // ✅ Wait and verify the checkbox is selected
//     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//     WebElement selectedIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
//             By.xpath("//span[@class='rct-title' and text()='" + checkboxName + "']/preceding-sibling::span//*[name()='svg' and contains(@class, 'rct-icon-check')]")
//     ));
//     Assert.assertTrue("Checkbox '" + checkboxName + "' is NOT selected!", selectedIcon.isDisplayed());

//     System.out.println("✅ Checkbox '" + checkboxName + "' is selected successfully.");
// }


// // /**
// //  * Expands parent nodes if needed (ensures sub-options are visible). homw and doc working expect download
// //  */
// // /**
// //  * Expands parent nodes if needed (ensures "Documents" and "Downloads" are visible).
// //  */
// // /**
// //  * Expands parent nodes if needed (ensures "Documents" and "Downloads" are visible).
// //  */
// private void expandParentNodesIfNeeded(String checkboxName) {
//     try {
//         // Ensure 'Home' is expanded first
//         expandNodeIfCollapsed("Home");

//         // If selecting 'Documents' or 'Downloads', expand their parent ('Home')
//         if (checkboxName.equals("Documents") || checkboxName.equals("Downloads")) {
//             expandNodeIfCollapsed(checkboxName);
//         }
//     } catch (Exception e) {
//         System.out.println("⚠️ Expansion failed or already expanded: " + checkboxName);
//     }
// }

// // /**
// //  * Expands the given node only if it's collapsed.
// //  */
// private void expandNodeIfCollapsed(String nodeName) {
//     try {
//         WebElement expandButton = driver.findElement(By.xpath(
//                 "//span[@class='rct-title' and text()='" + nodeName + "']/ancestor::li[contains(@class, 'rct-node-collapsed')]/span/button[@class='rct-collapse rct-collapse-btn']"
//         ));

//         if (expandButton.isDisplayed()) {
//             expandButton.click();
//             try {
//                 Thread.sleep(1000); // ✅ Handle InterruptedException properly
//             } catch (InterruptedException e) {
//                 System.out.println("⚠️ Sleep interrupted: " + e.getMessage());
//                 Thread.currentThread().interrupt(); // Restore interrupted status
//             }
//             System.out.println("✅ Expanded '" + nodeName + "' to make its checkboxes visible.");
//         }
        
//     } catch (NoSuchElementException e) {
//         System.out.println("🔹 Expansion not needed or already expanded for: " + nodeName);
//     }
// }
@When("I select the {string} checkbox")
public void i_select_the_checkbox_should_be_selected(String checkboxName) {
    WebElement checkBoxSection = driver.findElement(By.xpath("//*[@id=\"item-1\"]"));
    checkBoxSection.click();

    // Locate and click the checkbox
    WebElement checkBox = driver.findElement(By.xpath("//span[@class='rct-title' and text()='" + checkboxName + "']/preceding-sibling::span[@class='rct-checkbox']"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBox);
    checkBox.click();

    // ✅ Wait and verify the checkbox is selected
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    WebElement selectedIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[@class='rct-title' and text()='" + checkboxName + "']/preceding-sibling::span//*[name()='svg' and contains(@class, 'rct-icon-check')]")
    ));
    Assert.assertTrue("Checkbox '" + checkboxName + "' is NOT selected!", selectedIcon.isDisplayed());

    System.out.println("✅ Checkbox '" + checkboxName + "' is selected successfully.");
    
    if ("Home".equals(checkboxName)) {
        System.out.println("✅ Home is selected");
        driver.quit();
    }
}













//radio buttons


@When("I select the {string} radio button")
public void i_select_the_radio_button(String radioButtonLabel) {
    WebElement radioButtonSection = driver.findElement(By.xpath("//*[@id='item-2']"));
    radioButtonSection.click();

    // Locate the label associated with the radio button and click it instead of the input
    WebElement radioLabel = driver.findElement(By.xpath("//label[text()='" + radioButtonLabel + "']"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioLabel);
    radioLabel.click();
}

@Then("The {string} radio button should be selected")
public void the_radio_button_should_be_selected(String radioButtonLabel) {
    WebElement radioButton = driver.findElement(By.xpath("//label[text()='" + radioButtonLabel + "']/preceding-sibling::input"));
    Assert.assertTrue("Radio button '" + radioButtonLabel + "' is NOT selected!", radioButton.isSelected());
    System.out.println("✅ Radio button '" + radioButtonLabel + "' is selected successfully.");
   
}
@After
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}
}


