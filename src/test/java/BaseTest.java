import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MainPage;
import page.OrderPageNavigation;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    MainPage MainPage;
    OrderPageNavigation OrderPageNavigation;
    WebDriverWait wait;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
