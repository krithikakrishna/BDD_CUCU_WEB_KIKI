package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class bookingpage {
    
      WebDriver driver;

    public bookingpage(WebDriver driver) {
        this.driver = driver;
    }

    public By bookRoomPath = By.xpath("//*[@id='root']/body/div/div/div[4]/div/div/div[3]/button");
    public By startDatePath = By.xpath("//button[text()='11']");
    public By endDatePath = By.xpath("//button[text()='13']");
    public By firstNamePath = By.name("firstname");
    public By lastNamePath = By.name("lastname");
    public By emailPath = By.name("email");
    public By phonePath = By.name("phone");
    public By bookButtonPath = By.xpath("//*[@id='root']/body/div/div/div[4]/div/div[2]/div[3]/button[2]");
    public By cancelButtonPath = By.xpath("//button[contains(text(), 'Cancel')]");
   
}
