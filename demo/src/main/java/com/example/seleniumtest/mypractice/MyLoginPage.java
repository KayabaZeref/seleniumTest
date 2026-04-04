package com.example.seleniumtest.mypractice;

import org.openqa.selenium.By;

public class MyLoginPage extends MyBasePage {

    private By usernameField = By.xpath("//input[@name='username']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit']");

    public void setUsername(String username) {
        waitForElement(loginButton, 5000);
        set(usernameField, username);
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    public MyDashboard clickLogin() {
        click(loginButton);
        return new MyDashboard();
    }

    public MyDashboard logInToDashboard(String username, String password) {
        setUsername(username);
        setPassword(password);
        return clickLogin();
    }
}
