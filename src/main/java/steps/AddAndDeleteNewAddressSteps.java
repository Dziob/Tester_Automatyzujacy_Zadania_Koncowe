package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.*;

public class AddAndDeleteNewAddressSteps {
    public static WebDriver driver;

    public String url = "https://mystore-testlab.coderslab.pl.";

    @Given("Użytkownik znajduje się na stronie głównej sklepu")
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("Wybiera opcję 'Sing in'")
    public void signIn(){
        HomePage homePage = new HomePage(driver);
        homePage.signIn();
    }

    @And("Loguje się za pomocą poprawnego loginu i hasła")
    public void logIn(){
        LogInPage logInPage = new LogInPage(driver);
        logInPage.logInTo();
    }

    @And("Przechodzi do swojego konta, wybiera kafelek 'Addresses' a następnie opcję '+Create new address'")
    public void toCreateNew() {
        YourAccount yourAccount = new YourAccount(driver);
        yourAccount.toAdressess();
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
        yourAddressesPage.toNewAddress();
    }
    @And("^Wypełni pola \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\" i zatwierdzi$")
    public void fillAddressForm(String alias,String address, String city, String zip, String country, String phone){
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.addressForm(alias,address,city, zip, country, phone);
    }
    @Then("Użytkownik zostanie przekierowany do 'Your Adresses' i wyświetlony zostanie komunikat potwierdzający dodanie adresu")
    public void confirm(){
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
        Assert.assertEquals(yourAddressesPage.createConfirm(),"Address successfully added!");
    }
    @And("Użytkownik usuwa nowo utworzony adres")
    public void deleteAddress(){
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
        yourAddressesPage.deleteAddress();
    }

    @And("Wyświetlony zostaje komunikat o prawidłowym usunięciu")
    public void deleteConfirm(){
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
        Assert.assertEquals(yourAddressesPage.deleteConfirm(), "Address successfully deleted!");
    }

    @And("Użytkownik wylogowuje się i zamyka przeglądarkę")
    public void tearDown(){
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
        yourAddressesPage.backToYourAccount();
        YourAccount yourAccount = new YourAccount(driver);
        yourAccount.logOut();
        LogInPage logInPage = new LogInPage(driver);
        logInPage.quit(driver);
    }
}
