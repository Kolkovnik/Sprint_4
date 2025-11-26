package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    public static WebDriver driver;

    //Верхняя кнопка "Заказать"
    public By upOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    public By downOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    //Кнопка "Статут заказа"
//    public By statusOrderButton = By.className("Header_Link__1TAG7");
//    //Нижняя кнопка "Заказать"
    //Кнопка "Go!" внутри "Статуса заказа"
//    public By statusButton = By.cssSelector("button.Button_Button__ra12g Header_Button__28dPO");

// URL страницы заказа самоката
    public MainPage(WebDriver driver) {
        MainPage.driver = driver;
    }

    public void clickUpOrderButton() {
        driver.findElement(upOrderButton).click();
    }

    public void clickDownOrderButton() {
        driver.findElement(downOrderButton).click();
    }

    public static void openPage() {
        driver.get(URL);
        new WebDriverWait(driver, Duration.ofSeconds(3));
    }

//    public void clickStatusOrderButton() {
//        driver.findElement(statusOrderButton).click();
//    }

//    public void clickStatusButton() {
//        driver.findElement(statusButton).click();
//    }
}

