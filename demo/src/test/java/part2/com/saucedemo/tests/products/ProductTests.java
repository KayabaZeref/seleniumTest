package part2.com.saucedemo.tests.products;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.ProductsPage;

import part2.com.saucedemo.base.BaseTest;

public class ProductTests extends BaseTest {

    @Test
    public void testProductHeaderIsDisplayed() {
        // Test implementation
        // Log in with valid credentials to transition to the ProductsPage
        ProductsPage productsPage = loginPage.logInProductsPage("standard_user", "secret_sauce");
        // Assert that the products header is displayed on the ProductsPage
        // If false, the assertion will fail and the message "Products header is not
        // displayed" will be shown in the test results to indicate that the expected
        // header was not found on the page.
        Assert.assertTrue(productsPage.isProductsHeaderDisplayed(), "Products header is not displayed");
    }
}
