import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import pages.OrderPage;

@RunWith(Parameterized.class)
public class OrderTestPositive {

    private final String buttonOrder;
    private final String name;
    private final String surname;
    private final String adress;
    private final int metro;
    private final String phoneNumber;
    private final String date;
    private final String term;
    private final String color;

    public OrderTestPositive (String buttonOrder, String name, String surname, String adress, int metro, String phoneNumber, String date, String term, String color) {
        this.buttonOrder = buttonOrder;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.term = term;
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] orderData() {
        return new Object[][] {
                {"Up","Тест", "Тестов", "ул.Пушкина д.Колотушкина", 2, "88005553535", "20", "сутки", "black"},
                {"Down","Иван", "Иванов", "ул.Пушкина д.12", 3, "88005553838", "20", "двое суток", "grey"},
        };
    }

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void orderTest () {
        MainPage objMainPage = new MainPage(driverRule.getDriver());
        OrderPage objOrderPage = new OrderPage(driverRule.getDriver());
        objMainPage.clickOrderButton(buttonOrder);
        objOrderPage.makeOrder(name, surname, adress, metro, phoneNumber, date, term, color);
    }
}
