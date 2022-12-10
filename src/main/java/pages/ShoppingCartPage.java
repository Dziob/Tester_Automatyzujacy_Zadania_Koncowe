package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    public ShoppingCartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".checkout.cart-detailed-actions.js-cart-detailed-actions.card-block")
    WebElement checkoutBtn;


    public void checkOut(){
        checkoutBtn.click();
    }

}
