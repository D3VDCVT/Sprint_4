package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Окно заказа

    //Поле Имя
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Поле Фамилия
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");;
    //Поле Адрес
    private By adressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле Станция метро
    private By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Поле Телефон
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");
    //Поле когда привезти самокат
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле срок аренды
    private By termField = By.xpath(".//div[@class='Dropdown-placeholder']");

    //Кнопка Заказать
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка Назад
    private By backButton = By.cssSelector(".Button_Inverted__3IF-i");

    //Окно подтверждения заказа
    //Кнопка Нет
    private By noButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Нет']");
    //Кнопка Да
    private By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    //Окно заказ оформлен
    private By orderStatusSuccess = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");
    //Посмотреть статус
    private By checkOrderStatus = By.cssSelector(".Button_Middle__1CSJM");

    public void setName(String name) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).clear();
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAdress(String adress) {
        driver.findElement(adressField).clear();
        driver.findElement(adressField).sendKeys(adress);
    }

    public void setMetro(int metroPoint) {
        driver.findElement(metroField).click();
        driver.findElement(By.xpath(".//li[@data-index='" + metroPoint + "']")).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

    private void clickNextButton () {
        driver.findElement(nextButton).click();
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dateField));
    }

    public void setDatе(String datе) {

        String dataXpath = ".//div[@class='react-datepicker__day react-datepicker__day--0" + datе + " react-datepicker__day--weekend' or @class='react-datepicker__day react-datepicker__day--0" + datе + "']";
        driver.findElement(dateField).click();
        driver.findElement(By.xpath(dataXpath)).click();
    }

    public void setTerm (String term) {
        driver.findElement(termField).click();
        driver.findElement(By.xpath(".//div[text()='"+ term + "']")).click();
    }

    public void setColor (String color) {
        driver.findElement(By.id(color)).click();
    }

    public void clickOrderButton () {
        driver.findElement(orderButton).click();
    }

    public void clickBackButton () {
        driver.findElement(backButton).click();
    }

    public void clickNoButton () {
        driver.findElement(noButton).click();
    }

    public void clickYesButton () {
        driver.findElement(yesButton).click();
    }

    public void checkOrderSuccess () {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(orderStatusSuccess));
    }

    public void makeOrder (String name, String surname, String adress, int metro, String phoneNumber, String date, String term, String color) {
        setName(name);
        setSurname(surname);
        setAdress(adress);
        setMetro(metro);
        setPhoneNumber(phoneNumber);
        clickNextButton();
        setDatе(date);
        setTerm(term);
        setColor(color);
        clickOrderButton();
        clickYesButton();
        checkOrderSuccess();
    }















}
