package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Лого Яндекс
    private By logoYandex = By.xpath(".//a[@class='Header_LogoYandex__3TSOI']");
    //Лого Самокат
    private By logoScooter = By.className("Header_LogoScooter__3lsAR");
    //Кнопка "Заказать" вверху
    private By buttonOrderHeader = By.className("Button_Button__ra12g");
    //Кнопка "Статус заказа
    private By buttonOrderStatus = By.className("Header_Link__1TAG7");
    //Поле для ввода номера заказа
    private By fieldNumberOrder = By.cssSelector(".Header_Input__xIoUq");
    //Кнопка GO
    private By buttonGo = By.cssSelector(".Header_Button__28dPO");
    //Кнопка "Заказать" внизу
    private By buttonOrderBody = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public void clickFaqString (int id) {
        driver.findElement(By.id("accordion__heading-" + id)).click();
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("accordion__panel-" + id)));
    }
    public String getFaqAnswerText(int id) {
        return driver.findElement(By.id("accordion__panel-" + id)).getText();
    }

    public void clickOrderButton (String button) {
        if (button == "Up") {
            driver.findElement(buttonOrderHeader).click();
        }
        else if (button == "Down") {
            driver.findElement(buttonOrderBody).click();
        }
        else {
            System.out.println("Выбере кнопку Заказать Up или Down");
        }
    }

}
