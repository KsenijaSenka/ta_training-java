import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicTestCloudGoogle {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    protected void setUpChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    protected void setUpFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    protected void setUpEdge() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
    protected void runGoogleTitleTest() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Assertions.assertTrue(title.contains("Google"), "Title should contain 'Google'");
    }
}
