package com.example.seleniumtest.mypractice;

import org.openqa.selenium.By;

public class MyDashboard extends MyBasePage {

    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    public boolean isDashboardHeaderDisplayed() {
        waitForElement(dashboardHeader, 5000);
        return find(dashboardHeader).isDisplayed();
    }
}
