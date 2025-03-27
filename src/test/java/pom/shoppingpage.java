package pom;

import org.openqa.selenium.By;

public class shoppingpage {
     public By productBy = By.xpath("//*[@id='maincontent']/div[3]/div/div[2]/div[5]/div/div/ol/li[1]/div/div/strong/a");
    public By sizeOption = By.className("swatch-option");
    public By coloBy = By.cssSelector(".swatch-option.color");  // Fixed: Using CSS Selector
    public By addToCartBy = By.id("product-addtocart-button");
    public By errorMessageBy = By.xpath("//div[@class='message-success success message']");
    public By cartPageBy = By.xpath("//*[@id='maincontent']/div[1]/div[2]/div/div/div/a");
    public By checkOutBy = By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button"); // Fixed: Using CSS Selector
   // public By cutomerMailBy = By.xpath("//*[@id=\"customer-email\"]");
    //public By cutomerFNBy = By.xpath("//*[@id='PRXBHAG']");
    public By cutomerLNBy = By.xpath("//*[@id='S8D0MHD']");
    public By cutomerAddBy = By.xpath("//*[@id='E0AR3VY']");
    public By cityBy = By.xpath("//*[@id='JHVOA9R']");
    public By stateBy = By.xpath("//*[@id='shipping-new-address-form']/div[5]/div");
    public By zipBy = By.xpath("//*[@id=\"NT3QK16\"]");
    public By countryBy = By.xpath("//*[@id='shipping-new-address-form']/div[8]/div");  // Fixed
    public By cutomerPhnBy = By.xpath("//*[@id=\"O8LCYUE\"]");
    public By nextStep = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button");
}
