# Selenium Test Automation Framework

A comprehensive Java-based test automation framework using Selenium WebDriver, TestNG, and the Page Object Model (POM) design pattern. This project demonstrates best practices for automating web application testing across multiple demo sites, including SauceDemo and DemoQA.

## 🚀 Overview

This framework provides a scalable, maintainable structure for writing automated tests. It covers basic Selenium interactions, advanced techniques like JavaScript execution, and real-world scenarios across different web applications.

### ✨ Key Features

- **Page Object Model (POM)**: Clean separation of test logic and UI elements
- **Cross-Browser Testing**: Support for multiple browsers via WebDriverManager
- **TestNG Integration**: Robust test execution with annotations and reporting
- **Utility Classes**: Reusable components for JavaScript interactions and common operations
- **Maven Build**: Dependency management and automated builds
- **Modular Architecture**: Organized into parts for progressive learning

## 🛠️ Technology Stack

| Component | Version | Description |
|-----------|---------|-------------|
| Java | 17+ | Core programming language |
| Selenium WebDriver | 4.20.0 | Web automation framework |
| TestNG | 7.10.2 | Testing framework |
| WebDriverManager | 5.6.2 | Automatic browser driver management |
| Maven | 3.6+ | Build tool and dependency management |

## 📁 Project Structure

```
demo/
├── pom.xml
└── src/
    ├── main/java/
    │   ├── com/
    │   │   ├── base/
    │   │   │   └── BasePage.java              # Base class for page objects
    │   │   ├── demoqa/
    │   │   │   └── pages/
    │   │   │       ├── HomePage.java          # DemoQA home page object
    │   │   │       └── forms/
    │   │   │           └── FormsPage.java     # DemoQA forms page object
    │   │   └── example/
    │   │       └── seleniumtest/
    │   │           ├── App.java                # Sample application class
    │   │           └── mypractice/
    │   │               ├── MyBasePage.java     # Custom base page for practice
    │   │               ├── MyDashboard.java    # Dashboard page object
    │   │               └── MyLoginPage.java    # Login page object
    │   └── utilities/
    │       ├── JavaScriptUtility.java         # JavaScript execution utilities
    │       └── Utility.java                   # General utility methods
    └── test/java/
        ├── com/example/seleniumtest/
        │   └── AppTest.java                    # Basic test example
        ├── myTest/mylogintest/
        │   ├── MyBaseTest.java                 # Base test class for practice tests
        │   └── MyLoginTest.java                # Login test cases
        ├── part1/
        │   └── FirstSeleniumTest.java          # Introductory Selenium tests
        ├── part2/
        │   └── com/saucedemo/
        │       ├── base/
        │       │   └── BaseTest.java           # Base test for SauceDemo
        │       └── tests/
        │           ├── login/
        │           │   └── LoginTests.java     # SauceDemo login tests
        │           └── products/
        │               └── ProductTests.java   # SauceDemo product tests
        └── part3_part4/
            └── com/demoqa/
                ├── base/
                │   └── BaseTest.java           # Base test for DemoQA
                └── tests/
                    ├── part3/
                    │   └── javascript/
                    │       └── JavaScriptTest.java  # JavaScript interaction tests
                    └── part4/                   # Advanced DemoQA tests
```

## 📋 Prerequisites

- **Java JDK 17+**: [Download from Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)
- **Maven 3.6+**: [Download](https://maven.apache.org/download.cgi) or install via package manager
- **Git** (optional, for cloning)

## 🏁 Getting Started

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd demo
   ```

2. **Verify installations**:
   ```bash
   java -version  # Should show Java 17+
   mvn -version   # Should show Maven 3.6+
   ```

3. **Build the project**:
   ```bash
   mvn clean compile
   ```

## 🧪 Running Tests

### All Tests
```bash
mvn test
```

### Specific Test Class
```bash
mvn test -Dtest=LoginTests
```

### Specific Test Method
```bash
mvn test -Dtest=LoginTests#testValidLogin
```

### Run by Part
```bash
# Part 1: Basic Selenium
mvn test -Dtest=FirstSeleniumTest

# Part 2: SauceDemo tests
mvn test -Dtest="**/saucedemo/**/*Test"

# Part 3-4: DemoQA tests
mvn test -Dtest="**/demoqa/**/*Test"
```

## 🏗️ Architecture

### Page Object Model
Each page has a corresponding class that encapsulates:
- Element locators
- Page-specific actions
- Validation methods

### Base Classes
- **BasePage**: Common WebDriver operations (find, click, set text)
- **BaseTest**: Test setup/teardown, driver initialization

### Utilities
- **JavaScriptUtility**: Advanced interactions using JavaScriptExecutor
- **Utility**: Shared helper methods

## 📝 Example Test

```java
@Test
public void testValidLogin() {
    loginPage.setUsername("standard_user");
    loginPage.setPassword("secret_sauce");
    loginPage.clickLogin();

    // Verify successful login
    Assert.assertTrue(productsPage.isProductsPageDisplayed());
}
```

## 🔧 Troubleshooting

### Common Issues

**WebDriver not found**: WebDriverManager handles this automatically. Ensure internet connection for driver downloads.

**Elements not found**: Check locators match current UI. Add explicit waits:
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
```

**Port conflicts**: Close other browser instances or use different ports.

## 🚀 Extending the Framework

### Add New Page Object
```java
public class NewPage extends BasePage {
    private By newElement = By.id("newElement");

    public void interactWithNewElement() {
        click(newElement);
    }
}
```

### Add New Test
```java
public class NewTest extends BaseTest {
    @Test
    public void newTestCase() {
        // Test implementation
    }
}
```

## 📚 Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)
- [SauceDemo](https://www.saucedemo.com/)
- [DemoQA](https://demoqa.com/)

## 📄 License

This project is for educational purposes. Feel free to use and modify.

---

**Happy Testing! 🎯**# Selenium Test Automation Framework

A comprehensive test automation framework built with **Selenium**, **Java**, and **TestNG** for testing web applications. This project demonstrates modern automation testing best practices using the **Page Object Model (POM)** design pattern.

## 📋 Project Overview

This project demonstrates modern automation testing best practices on multiple web applications, including the [Sauce Demo](https://www.saucedemo.com/) e-commerce website and the [OrangeHRM Demo](https://opensource-demo.orangehrmlive.com/) site. It provides a scalable and maintainable framework for writing and executing automated test cases using different approaches.

### Key Features

- ✅ Page Object Model (POM) Architecture
- ✅ WebDriver Management with automatic driver setup
- ✅ TestNG Test Framework integration
- ✅ Reusable base classes for test and page components
- ✅ Clear separation of concerns
- ✅ Maven-based build management
- ✅ Cross-browser testing support

## 🛠️ Technology Stack

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Selenium** | 4.20.0 | Web automation framework |
| **Java** | 17 | Programming language |
| **TestNG** | 7.10.2 | Test framework |
| **WebDriverManager** | 5.6.2 | Automatic driver management |
| **Maven** | 3.x+ | Build and dependency management |

## 📁 Project Structure

```
demo/
├── pom.xml                                    # Maven configuration file
└── src/
    ├── main/
    │   └── java/
    │       ├── com/example/seleniumtest/
    │       │   ├── App.java                    # Main application class
    │       │   └── mypractice/
    │       │       ├── MyBasePage.java         # Base page for OrangeHRM POM
    │       │       ├── MyDashboard.java        # Dashboard page for OrangeHRM
    │       │       └── MyLoginPage.java        # Login page for OrangeHRM
    │       └── com/saucedemo/
    │           └── pages/
    │               ├── BasePage.java           # Base class for SauceDemo page objects
    │               ├── LoginPage.java          # Login page object model for SauceDemo
    │               └── ProductsPage.java       # Products page object model for SauceDemo
    │
    └── test/
        └── java/
            ├── com/example/seleniumtest/
            │   └── AppTest.java                # Sample test
            ├── myTest/
            │   └── mylogintest/
            │       ├── MyBaseTest.java         # Base test for OrangeHRM tests
            │       └── MyLoginTest.java        # Login tests for OrangeHRM
            ├── part1/
            │   └── FirstSeleniumTest.java      # Basic Selenium tests for OrangeHRM
            └── part2/
                └── com/saucedemo/
                    ├── base/
                    │   └── BaseTest.java       # Base test configuration for SauceDemo
                    └── tests/
                        └── login/
                            └── LoginTests.java # Login test cases for SauceDemo
```

## 🚀 Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Version 17 or higher
  - Download from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or use [OpenJDK](https://openjdk.org/)
  
- **Maven**: Version 3.6.0 or higher
  - Download from [Apache Maven](https://maven.apache.org/download.cgi)
  - Or install via package manager:
    ```bash
    # Windows (using Chocolatey)
    choco install maven
    
    # macOS (using Homebrew)
    brew install maven
    ```

- **Git** (optional, for version control)

### Installation

1. **Clone or download the project**
   ```bash
   git clone <repository-url>
   cd demo
   ```

2. **Verify Java installation**
   ```bash
   java -version
   ```
   Expected output: Java 17 or higher

3. **Verify Maven installation**
   ```bash
   mvn -version
   ```

4. **Build the project**
   ```bash
   mvn clean install
   ```
   This command will:
   - Clean previous build artifacts
   - Download all dependencies
   - Compile the source code
   - Run the tests

## 🧪 Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -Dtest=LoginTests
```

### Run Specific Test Method
```bash
mvn test -Dtest=LoginTests#testLoginErrorMessage
```

### Run Tests from Part 1
```bash
mvn test -Dtest=FirstSeleniumTest
```

### Run OrangeHRM Practice Tests
```bash
mvn test -Dtest=myTest.mylogintest.MyLoginTest
```

### Run Tests with Maven Surefire Plugin
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

## 📝 Test Examples

### Login Test with Error Validation
Located in [LoginTests.java](src/test/java/part2/com/saucedemo/tests/login/LoginTests.java):

```java
@Test
public void testLoginErrorMessage() {
    // Set login credentials
    loginPage.setUsername("standard_user");
    loginPage.setPassword("wrong_password");
    
    // Click login button
    loginPage.clickLogin();
    
    // Verify error message
    String actualErrorMessage = loginPage.getErrorMessage();
    Assert.assertTrue(actualErrorMessage.contains("Epic sadface"));
}
```

### Basic Login Test
Located in [FirstSeleniumTest.java](src/test/java/part1/FirstSeleniumTest.java):

```java
@Test
public void testLoggingIntoApplication() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
    username.sendKeys("Admin");

    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys("admin123");

    driver.findElement(By.tagName("button")).click();

    Thread.sleep(5000);

    String actualString = driver.findElement(By.tagName("h6")).getText();
    String expectedString = "Dashboard";
    Assert.assertEquals(actualString, expectedString);
}
```

## 🏗️ Architecture & Design Patterns

### Page Object Model (POM)

This framework implements the Page Object Model pattern to improve test maintainability and reduce code duplication.

**Benefits:**
- Centralized element locators
- Easier to maintain UI changes
- Improved code reusability
- Better test readability

### Base Page Pattern

All page objects inherit from [BasePage.java](src/main/java/com/saucedemo/pages/BasePage.java), which provides:

```java
// Find elements
protected WebElement find(By locator)

// Set input values
protected void set(By locator, String value)

// Click elements
protected void click(By locator)
```

### Base Test Pattern

All test classes inherit from [BaseTest.java](src/test/java/part2/com/saucedemo/base/BaseTest.java) for:
- WebDriver initialization and teardown
- Common test setup and configuration
- Reusable test utilities

## 🔧 Main Components

### BasePage.java
Parent class for all page objects providing common methods for:
- Element location and interaction
- WebDriver management
- Element manipulation (click, set text, etc.)

### LoginPage.java
Page Object for the login page including methods:
- `setUsername(String username)` - Enter username
- `setPassword(String password)` - Enter password
- `clickLogin()` - Click login button
- `getErrorMessage()` - Retrieve error messages

### ProductsPage.java
Page Object for the products page with methods for product interactions and navigation.

### BaseTest.java
Test base class that handles:
- WebDriver initialization
- Browser setup
- Test teardown and cleanup
- Common assertion methods

## 📚 Key Concepts Used

1. **Page Object Model**: Separates test logic from UI elements
2. **WebDriverManager**: Automatically manages browser drivers
3. **TestNG Annotations**: `@Test`, `@BeforeMethod`, `@AfterMethod` for test lifecycle
4. **Assertion Methods**: TestNG `Assert` class for validations

## 🐛 Troubleshooting

### Issue: Test fails with "WebDriver not found"
**Solution**: WebDriverManager should handle this automatically, but ensure you have:
- Valid internet connection (for driver download)
- Sufficient disk space
- Proper user permissions

### Issue: Port already in use
**Solution**: Make sure no other instances of the browser are running

### Issue: Tests run but elements are not found
**Solution**: 
- Check if locators match the current UI
- Add explicit waits in your page objects
- Verify the website is accessible

## 📈 Extending the Framework

### Adding a New Test

1. Create a new test class extending `BaseTest`
```java
public class MyNewTest extends BaseTest {
    @Test
    public void myTestCase() {
        // Test implementation
    }
}
```

2. Use existing page objects or create new ones
3. Run the test with Maven

### Adding a New Page Object

1. Create a new class extending `BasePage`
```java
public class NewPage extends BasePage {
    // Define locators
    private By element = By.id("elementId");
    
    // Define methods
    public void interactWithElement() {
        click(element);
    }
}
```

2. Use in test classes

## 💡 Best Practices

- ✅ Keep locators in page objects, not in test files
- ✅ Use meaningful method names that describe actions
- ✅ Implement explicit waits for dynamic elements
- ✅ Follow Java naming conventions
- ✅ Use constants for frequently used values
- ✅ Add meaningful comments for complex logic
- ✅ Keep test data separate from test logic
- ✅ Run tests in parallel when possible for faster execution

## 🔗 Useful Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [WebDriverManager GitHub](https://github.com/bonigarcia/webdrivermanager)
- [Sauce Demo Website](https://www.saucedemo.com/)
- [OrangeHRM Demo Website](https://opensource-demo.orangehrmlive.com/)
- [Page Object Model - Best Practices](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)

## 📄 License

This project is provided as-is for learning and educational purposes.

## ✉️ Contact & Support

For questions or issues, please refer to the repository issues section or contact the project maintainer.

---

**Happy Testing! 🚀**
