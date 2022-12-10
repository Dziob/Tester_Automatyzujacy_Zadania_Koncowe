package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccount {
    public YourAccount(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "addresses-link")
    WebElement addresses;

    @FindBy(xpath = "//footer/div/a")
    WebElement signOut;

    @FindBy(id = "category-3")
    WebElement clothesBtn;

    @FindBy(xpath = "//*[@id='history-link']")
    WebElement orderHistory;

    public void toAdressess(){
        addresses.click();
    }

    public void logOut(){
        signOut.click();
    }

    public void toClothes(){
        clothesBtn.click();
    }
    public void toOrderHistory(){
        orderHistory.click();
    }
}
