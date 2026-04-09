package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility extends Utility {

    public static void scrollToElementJS(By locator) {
        WebElement element = driver.findElement(locator);
        // Scroll to the element using JavaScript
        String jsScript = "arguments[0].scrollIntoView();";
        // Execute the JavaScript to scroll to the element
        ((JavascriptExecutor) driver).executeScript(jsScript, element);
    }
}
