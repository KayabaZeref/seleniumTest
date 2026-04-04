package myTest.mylogintest;

import org.testng.annotations.Test;

public class MyLoginTest extends MyBaseTest {
    @Test
    public void testLogin() {
        myLoginPage.setUsername("Admin");
        myLoginPage.setPassword("admin123");
        myLoginPage.clickLogin();

        myDashboard.isDashboardHeaderDisplayed();
    }
}
