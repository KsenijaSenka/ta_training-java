
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


//@ExtendWith(ScreenshotOnFailureExtension.class)
public abstract class BasicTestPasteBin {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected String baseUrl = "https://pastebin.com/";




    @BeforeEach
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.navigate().to(baseUrl);
   }



    @AfterAll
    public static void afterAll() {
        driver.quit();
       // driver.manage().deleteAllCookies();
    }
}
