package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderOptionsPage {
    public OrderOptionsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@name='confirm-addresses']")
    WebElement addressConfirm;

    @FindBy(xpath = "//*[@name='confirmDeliveryOption']")
    WebElement shippingConfirm;

    @FindBy(xpath = "//*[@id='payment-option-1']")
    WebElement paymentOption;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement agree;

    @FindBy(css = ".btn.btn-primary.center-block")
    WebElement placeOrderBtn;

    public void orderOptions() {
        addressConfirm.click();
        shippingConfirm.click();
        paymentOption.click();
        agree.click();
    }
    public void placeOrder() {
        placeOrderBtn.click();
    }


}
