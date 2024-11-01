package com.epam.training.student_ksenija_beocanin.optional_task1;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PasteBin {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://pastebin.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("postform-text")).sendKeys("Hello from WebDriver");

        driver.findElement(By.xpath("//*[@id=\"postform-name\"]")).sendKeys("helloweb");

        driver.findElement(By.id("select2-postform-expiration-container")).click();
        WebElement basicLink = driver.findElement(By.id("select2-postform-expiration-container"));
        new Actions(driver)
                .click(basicLink)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .click()
                .perform();

        wait.withMessage("Action is not yet complete!");

        driver.findElement(By.xpath("//button[text()='Create New Paste']")).click();

        driver.quit();
    }
}
