package part1;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstSeleniumTest {
    static WebDriver driver;

    // This method will be executed before any test method in the class
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        // Create an instance of the ChromeDriver to launch the Chrome browser
        // driver = new ChromeDriver();
        // // Maximize the browser window
        // driver.manage().window().maximize();

        // Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // Add the argument to run Chrome in headless mode
        options.addArguments("--headless=new"); // Run Chrome in headless mode
        // Optional: Bypass OS security model and improve stability in headless
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    // This method will be executed after all test methods in the class
    @AfterClass
    public static void tearDown() {
        // Quit the driver and close the browser
        // driver.quit();
        // // Alternatively, you can use driver.close() to close the current browser
        // window
        // driver.close();
    }

    @Test
    public void testLoggingIntoApplication() throws InterruptedException {
        // Thread.sleep(5000); // Wait for 5 seconds to ensure the page is fully loaded

        // Use WebDriverWait to wait for the presence of the username field, which is
        // more reliable than Thread.sleep()
        // Create an instance of WebDriverWait with a timeout of 10 seconds, and wait
        // until the username field is present in the DOM
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        // WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(5000); // Wait for 5 seconds to observe the result

        // Get the text of the h6 element and store it in a variable
        String actualString = driver.findElement(By.tagName("h6")).getText();
        // Assert that the actual string matches the expected string
        String expectedString = "Dashboard";
        // Assert that the actual string matches the expected string
        Assert.assertEquals(actualString, expectedString);
    }
}