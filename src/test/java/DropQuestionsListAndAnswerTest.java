import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MainPage;
import java.time.Duration;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class DropQuestionsListAndAnswerTest extends BaseTest {
    private final int numberOfQuestion;
    private final String expectedAnswer;

    public DropQuestionsListAndAnswerTest(int numberOfQuestion, String expectedAnswer) {
        this.numberOfQuestion = numberOfQuestion;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] QuestionsListAndAnswer() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void dropQuestionsListAndAnswerTest() {
        MainPage = new MainPage(driver);
        page.MainPage.openPage();
        driver.findElement(By.cssSelector("div.Home_Header__iJKdX"));

        WebElement firstQuestion = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", firstQuestion);

        List<WebElement> accordions = driver.findElements(By.cssSelector("[class='accordion__button']"));
        WebElement accordion = accordions.get(numberOfQuestion);
        accordion.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='accordion']")));

        List<WebElement> answers = driver.findElements(By.xpath(".//div[@class='accordion__panel']"));
        if (numberOfQuestion < answers.size()) {
            WebElement element = answers.get(numberOfQuestion);
            String actualAnswer = element.getText();
            assertEquals("Ответ на вопрос № " + numberOfQuestion + " не совпадает", expectedAnswer, actualAnswer);
        } else {
            System.out.println("Номер вопроса больше общего количества вопросов.");
        }
    }
}