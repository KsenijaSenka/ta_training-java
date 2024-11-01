package com.epam.training.student_ksenija_beocanin.optional_task3;

import com.epam.training.student_ksenija_beocanin.optional_task2.BasicPage;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


public class CloudGoogle extends BasicPage {


    @FindBy(xpath = "//*[@id='kO001e']/div[2]/div[1]/div/div[2]/div[2]/div[1]/form/div/input")
    private WebElement searchInputField;

    public CloudGoogle(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void enterValueInInputField(String value) {
        searchInputField.sendKeys(value);
    }

    public boolean isSearchInputVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(searchInputField)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSearchInputClickable() {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(searchInputField)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void createEstimate() {

        Actions actions = new Actions(driver);
        driver.navigate().to("https://cloud.google.com/products/calculator");


        driver.findElement(By.className("UywwFc-vQzf8d")).click();

        WebElement addItemButton = driver.findElement(By.xpath("//button[@aria-label='Add item']"));
        actions.moveToElement(addItemButton).click().perform();


        WebElement numberOfInstancesButton = driver.findElement(By.id("yDmH0d"));


        driver.findElement(By.className("qdOxv-fmcmS-wGMbrd")).clear();
        driver.findElement(By.className("qdOxv-fmcmS-wGMbrd")).sendKeys(Keys.chord("4"));


        driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/span[2]")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;


        double pageHeight = (Long) js.executeScript("return document.body.scrollHeight");


        double middlePageHeight = pageHeight * 0.6;


        js.executeScript("window.scrollTo(0, arguments[0]);", middlePageHeight);

        WebElement button = driver.findElement(By.className("VKmq8b"));
        button.click();

        WebElement openEstimateSummaryLink = driver.findElement(By.xpath("//a[contains(text(), 'Open estimate summary')]"));

    }
}
