package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class ProductPage {
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".discount.discount-percentage")
    WebElement discount;

    @FindBy(id = "group_1")
    WebElement sizeList;

    @FindBy(css = ".material-icons.touchspin-up")
    WebElement quantityUp;

    @FindBy(xpath = "//*[@data-button-action='add-to-cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/div/a")
    WebElement procedToCheckoutBtn;

    public String discountCheck() {
        return discount.getText();
    }

    public void sizeChoose(String rozmiar) {
        Select sizeChoice = new Select(sizeList);
        sizeChoice.selectByVisibleText(rozmiar);

    }

    public void quantityChoose(WebDriver driver, int ilosc, String rozmiar) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(sizeList, rozmiar));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 1; i < ilosc; i++) {
            quantityUp.click();
        }
       //próbowałam zastosować wait, niestety niezaleźnie od warunku, czy branych pod uwagę elementów, pętla sypała się przy 2-3 kliknięciach

    }
    public void addToCart(){

        addToCartBtn.click();
    }

    public void checkOut(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(procedToCheckoutBtn));
        procedToCheckoutBtn.click();
    }



}


