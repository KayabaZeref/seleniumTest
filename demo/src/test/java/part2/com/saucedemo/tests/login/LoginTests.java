package part2.com.saucedemo.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import part2.com.saucedemo.base.BaseTest;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginErrorMessage() {
        // Attempt to log in with an incorrect password
        loginPage.setUsername("standard_user");
        loginPage.setPassword("wrong_password");
        loginPage.clickLogin();
        // The var productsPage is not used in this test, but it is necessary when we
        // click the login button to transition to the ProductsPage. We can ignore it in
        // this test since we are only interested in the error message displayed on the
        // LoginPage after a failed login attempt.
        // var productsPage = loginPage.clickLogin();

        // Get the actual error message displayed on the page and assert that it
        // contains the expected text "Epic sadface"
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualErrorMessage.contains("Epic sadface"));
    }
}
