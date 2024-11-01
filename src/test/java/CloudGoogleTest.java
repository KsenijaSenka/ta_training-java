
import com.epam.training.student_ksenija_beocanin.optional_task3.CloudGoogle;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CloudGoogleTest extends BasicTestCloudGoogle {

    private CloudGoogle cloudGoogle;

    @Test
    public void testGoogleTitleOnChrome() {
        setUpChrome();
        runGoogleTitleTest();
    }

    @Test
    public void testGoogleTitleOnFirefox() {
        setUpFirefox();
        runGoogleTitleTest();
    }

    @Test
    public void testGoogleTitleOnEdge() {
        setUpEdge();
        runGoogleTitleTest();
    }

    @Test
    public void verifyNumberOfInstances() {

        cloudGoogle = new CloudGoogle(driver, wait);
        cloudGoogle.createEstimate();

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.Kfvdz")));

        String actualText = element.getText();

        assertEquals(actualText, "4", "The text in the span element is not equal to 4.");

    }
}
