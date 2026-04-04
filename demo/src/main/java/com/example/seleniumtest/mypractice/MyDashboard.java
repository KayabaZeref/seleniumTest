package com.example.seleniumtest.mypractice;

import org.openqa.selenium.By;

public class MyDashboard extends MyBasePage {

    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    public boolean isDashboardHeaderDisplayed() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return find(dashboardHeader).isDisplayed();
    }
}
