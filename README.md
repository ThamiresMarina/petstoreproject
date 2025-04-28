Pet Store API Testing Project
This project demonstrates automated testing for the Pet Store Swagger API, with a focus on RESTful API testing using Java-based technologies and data-driven testing (DDT) approaches.
Technologies Used

Java 17 - Programming language
Maven - Build and dependency management
JUnit 5 - Testing framework

JUnit Jupiter API (5.13.0)
JUnit Jupiter Params (5.13.0-M2)
JUnit Jupiter Engine (5.13.0-M2)


REST Assured 5.3.0 - API testing library
Hamcrest 3.0 - Assertion library
Gson 2.12.1 - JSON handling
Data-Driven Testing (DDT) - Testing methodology using CSV data files

Key Features

API endpoint testing for the Swagger Pet Store
Data-driven test cases using CSV files
Parameterized tests for efficient test coverage
RESTful API validation including status codes and response body verification
Structured project organization with separation of test data and code

How to Execute the Project
Prerequisites

Java JDK 17
Maven

Running All Tests
To run all the tests in the project:
bashmvn test
Running Specific Tests
To run only the data-driven tests for users:
bashmvn -Dtest=TestUserDDT test