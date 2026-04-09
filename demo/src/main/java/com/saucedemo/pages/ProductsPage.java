package com.saucedemo.pages;

import org.openqa.selenium.By;

import com.base.BasePage;

public class ProductsPage extends BasePage {

    private By productsHeader = By.xpath("//span[text()='Products']");

    // Method to check if the products header is displayed on the ProductsPage
    public boolean isProductsHeaderDisplayed() {
        return find(productsHeader).isDisplayed();
    }
}
