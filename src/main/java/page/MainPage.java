package page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    public static WebDriver driver;
    WebDriverWait wait;

    //Тестовый ресурс
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    //Верхняя кнопка "Заказать"
    public By upOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Нижняя кнопка "Заказать"
    public By downOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    //Главная страница
    public static By homePage = By.cssSelector("div.Home_Header__iJKdX");
    //Блок вопросов "Вопросы о важном"
    public By accordion = By.cssSelector("[class='accordion']");
    //Первый вопрос в блоке "Вопросы о важном"
    public By firstQuestion = By.id("accordion__heading-0");
    //Кнопки вопросов в блоке "Вопросы о важном"
    public By accordionQuestion = By.cssSelector("[class='accordion__button']");
    //Ответы в блоке "Вопросы о важном"
    public By accordionAnswer = By.xpath(".//div[@class='accordion__panel']");

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

    public void scrollIntoFirstQuestionAndWait() {
        WebElement elementFirstQuestion = driver.findElement(firstQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementFirstQuestion);
    }

    public void waitForAccordionVisible() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(accordion));
    }

    public void scrollIntoDownOrderButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(downOrderButton));
    }
}