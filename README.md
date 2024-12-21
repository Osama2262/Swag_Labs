
# Swag_Labs
<img align="right"  width="250" height="155" src="https://logowik.com/content/uploads/images/saucelabs-new-20239027.logowik.com.webp" >A
comprehensive test automation project built with Selenium WebDriver, implementing the Page Object Model (POM) design pattern for better maintainability and scalability of test cases. The project automates testing on the [Swag Labs](https://saucedemo.com) website, an online store for performance testing and training purposes.

## Introduction

Swag_Labs is a robust test automation project developed to demonstrate the power and flexibility of Selenium WebDriver and the Page Object Model (POM) design pattern. This repository automates tests for the Swag Labs website, a mock e-commerce platform used primarily for testing purposes.

By using the POM design pattern, this project ensures that the test scripts remain clean, reusable, and easy to maintain, especially as the project grows. The POM approach makes it simple to modify page elements without affecting the test scripts, promoting separation of concerns and enhancing test scalability.

This project serves as a foundation for automating functional tests for login, product searches, and shopping cart operations, with the added flexibility to extend the tests for more complex scenarios.

## Prerequisites

Before you can run this project, ensure you have the following installed:

- **Java**: Version 11 or higher
- **Maven**: For dependency management and project building
- **Selenium WebDriver**: For automating web browser interactions
- **TestNG**: For executing and managing tests
- **IDE (Optional)**: IntelliJ IDEA, Eclipse, or any Java-compatible IDE

## Project Structure

```
Swag_Labs/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/
│   │           └── [Page Object Model classes]
│   └── test/
│       └── java/
│           └── tests/
│               └── [Test scripts]
├── pom.xml
└── README.md
```

### **Detailed File Breakdown:**

1. **src/main/java/pages/**:
   - Contains the **Page Object Model (POM)** classes that represent different pages of the Swag Labs website (such as login, products, and cart pages). These classes are responsible for handling the web elements and interactions on each page. Each page object class encapsulates the web elements and actions that can be performed on those elements, ensuring test scripts remain clean and reusable.

   - **Example**: `LoginPage.java`, `ProductsPage.java`, `CartPage.java`.

2. **src/test/java/tests/**:
   - Contains the **TestNG test scripts** that execute the actual test scenarios using the Page Object Model classes. These test scripts are organized into logical groups, such as login tests, product selection tests, and cart validation tests.
   
   - **Example**: `TC001_LoginTest.java`, `TC002_ProductListTest.java`, `TC003_CartTest.java`.

3. **pom.xml**:
   - The **Maven configuration file** that defines the dependencies required for the project, such as Selenium, TestNG, and other libraries. It also includes plugins for building and running the tests, managing versions, and packaging the project.

4. **README.md**:
   - This document provides instructions and information about the project, dependencies, and how to set up and run the tests.

---

## 🌟Main Test Cases

+ The user can log in with a valid email and password<br>
+ The user can't log in with a locked Account<br>
+ The user can log out from his account successfully<br>
+ The user can add all products to the cart<br>
+ The user can add one product to the cart<br>
+ The user can remove one product from the cart<br>
+ Verify the functionality of adding all products to the cart and clearing the cart entirely<br>
+ Ensure the sorting option triggers a change in product arrangement<br>
+ Verify that the sorting option displays products in the correct order<br>
+ The user can go back to the product list page and continue adding products to the cart by clicking on the 'continue shopping' button<br>
+ The user can finish his order successfully<br>
+ The user can cancel his order from CheckoutPage<br>
+ The website displays the correct total price for all products<br>



## Setup and Execution

To set up and execute the tests, follow these steps:

1. **Clone the repository**:

   ```bash
   git clone https://github.com/Osama2262/Swag_Labs.git
   ```

2. **Navigate to the project directory**:

   ```bash
   cd Swag_Labs
   ```

3. **Install dependencies**:

   Run the following command to install the project dependencies:

   ```bash
   mvn install
   ```

4. **Run the tests**:

   To execute the automated tests, run:

   ```bash
   mvn test
   ```

   Maven will automatically download any missing dependencies and execute the tests based on the configuration in `pom.xml`.

---

## Contribution

We welcome contributions to this project! If you'd like to contribute:

1. Open an issue describing the enhancement or bug.
2. Create a new branch from `main`:

   ```bash
   git checkout -b feature/your-feature-name
   ```

3. Commit your changes and push to the new branch.

4. Create a pull request with a clear description of your changes.

---

## References

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Maven Documentation](https://maven.apache.org/guides/index.html)

