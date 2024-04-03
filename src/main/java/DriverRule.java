import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverRule extends ExternalResource {
    private WebDriver driver;

    @Override
    protected void before() throws Throwable {
        initDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.xpath(".//button[@id='rcc-confirm-button']")).click();
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public void initDriver() {
        if ("firefox".equals(System.getProperty("browser"))) {
            initFirefox();
        }
        else {
            initChrome();
        }
    }
    private void initFirefox() {
        WebDriverManager.firefoxdriver().setup();
        var opts = new FirefoxOptions()
                .configureFromEnv();
        driver = new FirefoxDriver(opts);
    }

    private void initChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
