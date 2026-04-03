package com.saucedemo.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Locators for the username field, password field, login button, and error
    // message
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("#login_button_container h3");

    // Method to set the username in the username field
    public void setUsername(String username) {
        set(usernameField, username);
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    // Method to click the login button and return a new instance of the
    // ProductsPage
    // This is called transitioning to the ProductsPage after a successful login
    public ProductsPage clickLogin() {
        click(loginButton);
        return new ProductsPage();
    }

    // Method to perform the login action by setting the username and password, and
    // then clicking the login button. It returns an instance of the ProductsPage if
    // the login is successful.
    public ProductsPage logInProductsPage(String username, String password) {
        setUsername(username);
        setPassword(password);
        return clickLogin();
    }

    // Method to get the error message text when a login attempt fails
    public String getErrorMessage() {
        return find(errorMessage).getText();
    }
}
