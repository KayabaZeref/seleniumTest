package myTest.mylogintest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.example.seleniumtest.mypractice.MyBasePage;
import com.example.seleniumtest.mypractice.MyDashboard;
import com.example.seleniumtest.mypractice.MyLoginPage;

public class MyBaseTest {

    protected WebDriver driver;
    protected MyBasePage myBasePage;
    protected MyLoginPage myLoginPage;
    protected MyDashboard myDashboard;
    private String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        myBasePage = new MyBasePage();
        myBasePage.setDriver(driver);
        myLoginPage = new MyLoginPage();
        myDashboard = new MyDashboard();
    }

    @AfterClass
    public void tearDown() {
        // if (driver != null) {
        // driver.quit();
        // }
    }
}
