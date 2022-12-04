package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    public LogInPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "field-email")
    WebElement emailInput;

    @FindBy(id = "field-password")
    WebElement passwordInput;

    @FindBy(id = "submit-login")
    WebElement signInBtn;

    public void logInTo(){
        emailInput.sendKeys("tppwxblyffchslpvqe@tmmbt.com");
        passwordInput.sendKeys("haslo");
        signInBtn.click();
    }

    public void quit(WebDriver driver){
        driver.quit();
    }
}
