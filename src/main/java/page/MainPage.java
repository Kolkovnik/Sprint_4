package page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    public static WebDriver driver;

    //Тестовый ресурс
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    //Верхняя кнопка "Заказать"
    public By upOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Нижняя кнопка "Заказать"
    public By downOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    //Главная страница
    public static By homePage = By.cssSelector("div.Home_Header__iJKdX");
    //Все вопросы в блоке "Вопросы о важном"
    public By accordion = By.cssSelector("[class='accordion']");


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
        driver.findElement(homePage);
    }

    public void scrollIntoFirstQuestion() {
        WebElement firstQuestion = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", firstQuestion);
    }
}

