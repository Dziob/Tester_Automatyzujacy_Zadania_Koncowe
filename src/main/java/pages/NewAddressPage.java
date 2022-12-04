package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage {
    public NewAddressPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-alias")
    WebElement aliasInput;

    @FindBy(id = "field-address1")
    WebElement addressInput;

    @FindBy(id = "field-city")
    WebElement cityInput;

    @FindBy(id = "field-postcode")
    WebElement zipInput;

    @FindBy(id = "field-id_country")
    WebElement countryInput;

    @FindBy(id = "field-phone")
    WebElement phoneInput;

    @FindBy(xpath = "//*[@name = 'submitAddress']")
    WebElement saveBtn;

    public void addressForm(String alias,String address, String city, String zip, String country, String phone){
        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        zipInput.sendKeys(zip);
        Select countryInput = new Select(this.countryInput);
        countryInput.selectByVisibleText(country);
        phoneInput.sendKeys(phone);
        saveBtn.submit();

    }
}
