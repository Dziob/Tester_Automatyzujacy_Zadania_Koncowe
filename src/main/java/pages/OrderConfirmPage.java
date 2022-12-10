package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class OrderConfirmPage {
    public OrderConfirmPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*/tbody/tr[3]/td[2]")
    WebElement totalPrice;

    @FindBy(xpath = "//*[@title='View my customer account']")
    WebElement myAccount;

    public void screenshot(WebDriver driver) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(totalPrice));
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(),"PNG",new File("C://Users//mtoma//TestPrtSc//FullPageScreenshot.png"));
    }


    public String priceFromOrderConfirm(){
        return totalPrice.getText();
    }

    public void toMyAccount(){
        myAccount.click();
    }
}
