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

    protected void waitForElement(By locator, int timeoutInSeconds) {
        // endTime is current time + timeout duration
        long endTime = System.currentTimeMillis() + timeoutInSeconds * 1000;
        // System.currentTimeMillis() returns the current time in milliseconds smaller
        // than endTime, keep checking for the element until the timeout is reached
        while (System.currentTimeMillis() < endTime) {
            try {
                if (find(locator).isDisplayed()) {
                    return;
                }
            } catch (Exception e) {
                // Ignore exceptions and continue waiting
            }
        }
        throw new RuntimeException("Element not found: " + locator);
    }
}
