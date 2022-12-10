package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
    public OrderHistoryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody/tr[1]/td[2][@class='text-xs-right']")
    WebElement totalPrice;

    @FindBy(xpath = "//tr[1]/th[1]/following-sibling::td[4]")
    WebElement status;


    @FindBy(css = ".logout.hidden-sm-down")
    WebElement signOutBtn;

// Nierozwiązany problem na tej stronie, dotyczących opcji dodatkowych z zadania 2;
// Jeśli parametry (gherkin) za każdym razem będą takie same, wszystko działa
// Przy zmianie parametrów zauważyłam, że czasami cenę z historii zakupu pobiera z 3 zamówienia od góry,
// dlatego przy zmianie parametrów wynik to 2x assercja łapie róznicę ceny i za 3 razem test przechodzi.
// Próbowałam zmiany selektorów, waitów, thread.sleep, niestety wciąż niestabilnie.
// Nadal szukam rozwiązania, ale niesty raczej do 14.12 nie dam rady, więc przesyłam w takiej formie.

        public String priceFromOrderHistory() {
        return totalPrice.getText();
    }
    public String orderStatus(){
        return status.getText();
    }

    public void logOut(){
        signOutBtn.click();
    }
}
