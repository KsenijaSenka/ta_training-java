package com.epam.training.student_ksenija_beocanin.optional_task2;

import org.openqa.selenium.*;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasicPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasicPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
}
