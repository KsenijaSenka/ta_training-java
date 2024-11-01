import com.epam.training.student_ksenija_beocanin.optional_task2.PasteBinWithJunit;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.*;

public class PasteBinTest extends BasicTestPasteBin {

    protected PasteBinWithJunit pasteBinWithJunit;

    @Test
    @Order(1)
    public void testPageTitleMatchesPasteNameTitle() throws InterruptedException {
        pasteBinWithJunit = new PasteBinWithJunit(driver, wait);
        pasteBinWithJunit.getPastebinPage();
        pasteBinWithJunit.createPaste();


        wait.until(ExpectedConditions.titleContains("how to gain dominance among developers"));
        wait.withMessage("Page has not re-directed");
        String actualTitle = driver.getTitle();


        String expectedTitle = "how to gain dominance among developers - Pastebin.com";
        assertEquals(expectedTitle, actualTitle, "Title doesn't match");
    }

    @Test
    @Order(2)
    public void isBashSyntaxSuspended() {
        pasteBinWithJunit = new PasteBinWithJunit(driver, wait);
        String actualText = pasteBinWithJunit.getActualText();


        assertTrue(actualText.contains("$") && actualText.contains("\""),
                "The expected Bash command is incorrectly formatted on the page.");

    }

    @Test
    @Order(3)
    public void verifyCodeMatchesParagraph2() {
        pasteBinWithJunit = new PasteBinWithJunit(driver, wait);
        String expectedText = "git config --global user.name \"New Sheriff in Town\"\n"
                + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
                + "git push origin master --force";


        String actualText = pasteBinWithJunit.getActualText();


        String[] expectedLines = expectedText.split("\n");
        String[] actualLines = actualText.split("\n");

        //assertEquals(expectedLines.length, actualLines.length, "Number of lines should match");

        for (int i = 0; i < expectedLines.length; i++) {
            assertEquals(expectedLines[i], actualLines[i], "Line " + (i + 1) + " should match");
        }
    }
}

