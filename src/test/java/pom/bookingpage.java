package pom;

import org.openqa.selenium.By;

public class bookingpage {
    
    public By startDatePath=By.xpath("//button[text()='08']");
    public By bookNowPath=By.xpath("//*[@id=\"root\"]/body/div/div/div[4]/div/div/div[3]/button");
    public By endDatePath=By.xpath("//button[text()='11']");
    public By cancelButtonPath =By.xpath("//button[contains(text(), 'Cancel')]");
    public By firstNamePath = By.cssSelector(".form-control.room-firstname");
    public By lastNamePath = By.cssSelector(".form-control.room-lastname");
    public By emailIdPath = By.cssSelector(".form-control.room-email");
    public By phoneNoPath =By.cssSelector(".form-control.room-phone") ;
    public By bookBtnPath =By.cssSelector(".btn.btn-outline-primary.float-right.book-room") ;
    public By bookingConfirmationPath = By.xpath("//*[@id=\"root\"]/body/div[4]/div/div/div[2]/div/button");
   
}
