package com.epam.training.student_ksenija_beocanin.optional_task2;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PasteBinWithJunit extends BasicPage {
    public PasteBinWithJunit(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void getPastebinPage() {
        driver.navigate().to("https://pastebin.com/");
    }

    public void createPaste()  {
        driver.findElement(By.id("postform-text")).sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "            git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "            git push origin master --force\n");

        WebElement basicLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-postform-format-container")));

        new Actions(driver)
                .click(basicLink)
                .sendKeys(Keys.ARROW_DOWN)
                .pause(Duration.ofMillis(500))
                .sendKeys(Keys.ENTER)
                .perform();


        WebElement pasteExpiration = driver.findElement(By.id("select2-postform-expiration-container"));

        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top + window.scrollY - 100);", pasteExpiration);

        new Actions(driver)
                .click(pasteExpiration)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .pause(Duration.ofMillis(500))
                .sendKeys(Keys.ENTER)
                .perform();


        driver.findElement(By.xpath("//*[@id=\"postform-name\"]"))
                .sendKeys("how to gain dominance among developers");
        driver.findElement(By.xpath("//button[text()='Create New Paste']")).click();

    }
    public String getActualText() {

        return "git config --global user.name \"New Sheriff in Town\"\n"
                + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
                + "git push origin master --force";
    }
}






