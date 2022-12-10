package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.*;

import java.io.IOException;

public class FullPurchaseSteps {
    public static WebDriver driver;

    public String url = "https://mystore-testlab.coderslab.pl.";

    @Given("Użytkownik znajduje się na stronie głownej my 'store'")
    public void setUo() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("Wybiera opcję 'sing in' i loguje się porawnymi danymi")
    public void signIn() {
        HomePage homePage = new HomePage(driver);
        homePage.signIn();
        LogInPage logInPage = new LogInPage(driver);
        logInPage.logInTo();
    }

    @And("Użytkownik przechodzi do zakładki clothes")
    public void toClothes() {
        YourAccount yourAccount = new YourAccount(driver);
        yourAccount.toClothes();
    }

    @And("Wybiera 'Hummingbird Printed Sweater'")
    public void toProduct() {
        ClothesPage clothesPage = new ClothesPage(driver);
        clothesPage.toProduct();
    }

    @And("Sprawdza czy rabat na produkt wynosi 20%")
    public void discountCheck() {
        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.discountCheck(), "SAVE 20%");
    }

    @And("^Wybiera \"(.*)\" i \"(.*)\" produktu i dodaje go do koszyka$")
    public void addingToCart(String rozmiar, int iloscSztuk) {
        ProductPage productPage = new ProductPage(driver);
        productPage.sizeChoose(rozmiar);
        productPage.quantityChoose(driver, iloscSztuk, rozmiar);
        productPage.addToCart();
    }

    @And("Przechodzi do koszyka poprzez opcję 'Proced to checkout' i potwierdza koszyk")
    public void checkOut() {
        ProductPage productPage = new ProductPage(driver);
        productPage.checkOut(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.checkOut();
    }

    @And("Użytkownik potwierdza adres, wybiera metodę odbioru - PrestaShop 'pick up in store', wybiera opcję płatności - Pay by Check")
    public void orderOptions() {
        OrderOptionsPage orderOptionsPage = new OrderOptionsPage(driver);
        orderOptionsPage.orderOptions();
    }

    @And("Uzytkownik zatwierdza regulamin i wybiera 'Place order'")
    public void placeOrder() {
        OrderOptionsPage orderOptionsPage = new OrderOptionsPage(driver);
        orderOptionsPage.placeOrder();
    }

    @Then("Użytkownik wykonuje zrzut ekranu potwierdzający złożenie zamówienia")
    public void orderConfirm() throws IOException {
        OrderConfirmPage orderConfirmPage = new OrderConfirmPage(driver);
        orderConfirmPage.screenshot(driver);
        orderConfirmPage.priceFromOrderConfirm();
    }

    @And("Użytkownik przechodzi do swojego konta a następnie wybiera historię zamówień")
    public void toOrderHistory() {
        OrderConfirmPage orderConfirmPage = new OrderConfirmPage(driver);
        orderConfirmPage.toMyAccount();
        YourAccount yourAccount = new YourAccount(driver);
        yourAccount.toOrderHistory();
    }

    @And("Użytkownik potwierdza,że zamówienie ma status 'Awaiting check payment' oraz, że podana tu kwota jest taka sama jak przy składaniu zamówienia")
    public void confirmInHistory() {
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        OrderConfirmPage orderConfirmPage = new OrderConfirmPage(driver);
        Assert.assertEquals(orderHistoryPage.orderStatus(), "Awaiting check payment");
        Assert.assertEquals(orderConfirmPage.priceFromOrderConfirm(), orderHistoryPage.priceFromOrderHistory());
    }

    @And("Użytkownik wyloguje się i wyłączy przeglądarkę")
    public void tearDown() {
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        orderHistoryPage.logOut();
        LogInPage logInPage = new LogInPage(driver);
        logInPage.quit(driver);
    }
}
