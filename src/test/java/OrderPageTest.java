import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MainPage;
import page.OrderPageNavigation;
import java.time.Duration;
import static page.OrderPageNavigation.*;

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

    @Parameterized.Parameters
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        if (orderButton.equals("Верхняя кнопка")) {
            MainPage.clickUpOrderButton();
        } else {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button")));
            MainPage.clickDownOrderButton();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        OrderPageNavigation.firstNameFieldClick();
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(name);

        OrderPageNavigation.secondNameFieldClick();
        driver.findElement(secondNameField).clear();
        driver.findElement(secondNameField).sendKeys(secondName);

        OrderPageNavigation.addressFieldClick();
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);

        OrderPageNavigation.selectMetroFieldClick();
        driver.findElement(selectMetroField).sendKeys(metroStation);
        OrderPageNavigation.getSubwayStationClick();

        OrderPageNavigation.phoneFieldClick();
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phoneNumber);

        OrderPageNavigation.nextButtonClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastOrderButton));
        OrderPageNavigation.orderDateFieldClick();

        driver.findElement(By.xpath(".//div[@class='react-datepicker__input-container']/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN react-datepicker-ignore-onclickoutside']")).sendKeys("28.12.2025");
        OrderPageNavigation.rentalDurationClick();
        driver.findElement(By.xpath(".//div[contains(text(), 'двое суток')]")).click();
        driver.findElement(By.xpath(".//input[@id='grey']")).click();
        driver.findElement(By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']")).sendKeys("И чтобы был новый!");

        OrderPageNavigation.lastOrderButtonClick();
        OrderPageNavigation.yesButtonClick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderStatusButton));
    }
}

