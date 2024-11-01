import com.epam.training.student_ksenija_beocanin.Helper;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;


public class ScreenshotOnFailureExtension implements TestWatcher {


    private final WebDriver driver;
    public ScreenshotOnFailureExtension(WebDriver driver) {
        this.driver = driver;
    }


    public void testFailed (ExtensionContext context) {
        String testName = context.getDisplayName();
        Helper.captureScreenshot(driver, "screenshots/" + testName + ".jpg");
    }
}
