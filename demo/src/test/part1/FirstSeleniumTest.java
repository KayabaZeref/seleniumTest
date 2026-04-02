// This Test using Junit framework, but you can also use TestNG as well. 
// Just make sure to update the dependencies in pom.xml 
// and the annotations in the test class accordingly

package part1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSeleniumTest {
    WebDriver driver;

    // This method will be executed before any test method in the class
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    // This method will be executed after all test methods in the class
    @AfterClass
    public void tearDown() {
        // Quit the driver and close the browser
        driver.quit();
        // // Alternatively, you can use driver.close() to close the current browser
        // window
        // driver.close();
    }

    @Test
    public void testLoggingIntoApplication() throws InterruptedException {
        Thread.sleep(2000); // Wait for 2 seconds to ensure the page is fully loaded
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        driver.findElement(By.tagName("button")).click();
    }
}
