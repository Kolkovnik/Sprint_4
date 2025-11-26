import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.MainPage;
import page.OrderPageNavigation;

public class BaseTest {
    WebDriver driver;
    MainPage MainPage;
    OrderPageNavigation OrderPageNavigation;

    @Before
    public void startUp() {
      WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
