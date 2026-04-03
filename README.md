# Selenium Test Automation Framework

A comprehensive test automation framework built with **Selenium**, **Java**, and **TestNG** for testing web applications. This project demonstrates modern automation testing best practices using the **Page Object Model (POM)** design pattern.

## 📋 Project Overview

This project is designed to automate testing of the [Sauce Demo](https://www.saucedemo.com/) e-commerce website. It provides a scalable and maintainable framework for writing and executing automated test cases.

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
├── README.md                                  # Project documentation
└── src/
    ├── main/
    │   └── java/
    │       └── com/saucedemo/
    │           └── pages/
    │               ├── BasePage.java          # Base class for all page objects
    │               ├── LoginPage.java         # Login page object model
    │               └── ProductsPage.java      # Products page object model
    │
    └── test/
        └── java/
            ├── com/example/seleniumtest/
            │   └── AppTest.java               # Sample test
            ├── part1/
            │   └── FirstSeleniumTest.java     # Basic Selenium tests
            └── part2/
                └── com/saucedemo/
                    ├── base/
                    │   └── BaseTest.java      # Base test configuration
                    └── tests/
                        └── login/
                            └── LoginTests.java # Login test cases
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
- [Page Object Model - Best Practices](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)

## 📄 License

This project is provided as-is for learning and educational purposes.

## ✉️ Contact & Support

For questions or issues, please refer to the repository issues section or contact the project maintainer.

---

**Happy Testing! 🚀**
