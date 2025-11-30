import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.MainPage;
import page.OrderPageNavigation;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPageTest extends BaseTest {
    private final String name;
    private final String secondName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String orderButton;

    public OrderPageTest(String name, String secondName, String address, String metroStation, String phoneNumber, String orderButton) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.orderButton = orderButton;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] Order () {
        return new Object[][]{
                {"Алексей", "Фирсов", "г. Москва, ул. Планерная, д. 7, к. 3", "Планерная", "84959998877", "Верхняя кнопка"},
                {"Василий", "Петров", "г. Москва, ул. Набережная, д. 10", "Крылатское", "84957271800", "Нижняя кнопка"},
        };
    }

    @Test
    public void orderPageTest() {
        MainPage = new MainPage(driver);
        OrderPageNavigation = new OrderPageNavigation(driver);
        page.MainPage.openPage();

        if (orderButton.equals("Верхняя кнопка")) {
            MainPage.clickUpOrderButton();
        } else {
            MainPage.scrollIntoDownOrderButton();
            MainPage.clickDownOrderButton();
        }

        OrderPageNavigation.login(name, secondName, address, metroStation, phoneNumber);
        OrderPageNavigation.rentScooter("30.12.2025");
        assertTrue("Заказ не создан, кнопка проверки статуса заказа не отображается", OrderPageNavigation.CheckVisibilityOfOrderStatusButton());
    }
}