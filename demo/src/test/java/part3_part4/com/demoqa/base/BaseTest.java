package part3_part4.com.demoqa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static utilities.Utility.setUtilityDriver;

import com.base.BasePage;
import com.demoqa.pages.HomePage;

public class BaseTest {

    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private String baseUrl = "https://demoqa.com/";

    @BeforeClass
    public void setUp() {
        // Implementation for setting up the test
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(baseUrl);
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();
        homePage = new HomePage();
    }

    @AfterClass
    public void tearDown() {
        // Implementation for tearing down the test
        driver.quit();
    }
}
