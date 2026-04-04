package com.example.seleniumtest.mypractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyBasePage {

    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        MyBasePage.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void set(By locator, String value) {
        find(locator).clear();
        find(locator).sendKeys(value);
    }

    protected void click(By locator) {
        find(locator).click();
    }
}
