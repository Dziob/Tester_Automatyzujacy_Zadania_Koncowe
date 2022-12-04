package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddressesPage {
    public YourAddressesPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//*[@data-link-action='add-address']")
    WebElement createBtn;

    @FindBy(css = ".alert.alert-success")
    WebElement successAddAlert;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]/span")
    WebElement deleteAddress;

    @FindBy(css = ".alert.alert-success")
    WebElement succesDeleteAlert;

    @FindBy(xpath = "//footer[@class = 'page-footer']/a[1]")
    WebElement back;

    public void toNewAddress(){
        createBtn.click();
    }

    public String createConfirm(){
        return successAddAlert.getText();
    }

    public void deleteAddress(){
        deleteAddress.click();
    }

    public String deleteConfirm(){
        return succesDeleteAlert.getText();
    }

    public void backToYourAccount(){
        back.click();
    }


}
