package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    // Declare a static WebDriver variable to be shared across all instances of
    // BasePage and its subclasses
    public static WebDriver driver;

    // This method allows setting the WebDriver instance from outside the class,
    // enabling it to be shared across different page classes and test classes
    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    // This method finds a web element using the provided locator and returns it.
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    // This method sets the value of a web element located by the provided locator.
    protected void set(By locator, String value) {
        // First, it finds the web element using the find method, then clears any
        // existing text in the element, and finally sends the new value to the element.
        find(locator).clear();
        find(locator).sendKeys(value);
    }

    // This method clicks on a web element located by the provided locator.
    protected void click(By locator) {
        find(locator).click();
    }
}
