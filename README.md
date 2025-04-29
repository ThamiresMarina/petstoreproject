# 🐶 Pet Store API Testing Project

This project demonstrates automated testing for the [Swagger Pet Store API](https://petstore.swagger.io/), with a focus on RESTful API testing using Java and Data-Driven Testing (DDT) techniques.

## ✅ Objectives

- Test the API endpoints of the Swagger Pet Store using automated methods.
- Implement Data-Driven Testing to validate different test scenarios.
- Ensure that HTTP status codes and response bodies match expectations.

## 🔧 Technologies Used

- **Java 17** - Programming language
- **Maven** - Build and dependency management
- **JUnit 5** - Testing framework
  - JUnit Jupiter API (5.13.0)
  - JUnit Jupiter Params (5.13.0-M2)
  - JUnit Jupiter Engine (5.13.0-M2)
- **REST Assured 5.3.0** - Library for API testing
- **Hamcrest 3.0** - Library for assertions and matchers
- **Gson 2.12.1** - JSON serialization/deserialization
- **CSV-based DDT** - For parameterized testing

## ✨ Key Features

- Automated testing for the Swagger Pet Store API endpoints
- Data-Driven Testing with parameterized test methods
- Separation of test data (CSV) and test logic (Java)
- Verification of HTTP responses including status code and body fields
- Clean and structured test organization

## 📂 Project Structure

```
src/
 └── test/
      ├── java/
      │    └── TestUserDDT.java        # Data-driven test for user creation
      └── resources/
           └── csv/
                └── userMassa.csv      # CSV test data for user DDT
```

## 🚀 How to Execute the Project

### 🔧 Prerequisites

- Java JDK 17
- Maven installed and configured

### ▶️ Running All Tests

```bash
mvn test
```

### ▶️ Running Specific DDT Tests for Users

```bash
mvn -Dtest=TestUserDDT test
```

> 💡 Tip: Use `mvn clean test` for a clean build and test execution.

---

Happy Testing! 🎯