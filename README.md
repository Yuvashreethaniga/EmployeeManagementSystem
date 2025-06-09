### Employee Management API Automation Project
 
This project automates REST API testing for the Employee Management System using Java, RestAssured, TestNG, Cucumber, and Extent Reports for reporting.



| Component     | Version                      | Purpose                                   |
| ------------- | ---------------------------- | ----------------------------------------- |
| Java          | 21 / 17                      | Core programming language                 |
| Maven         | Compatible with Java 21 / 17 | Project build lifecycle & dependency mgmt |
| TestNG        | Latest                       | Test execution and suite configuration    |
| Cucumber      | 7.x                          | BDD (Behavior-Driven Development)         |
| RestAssured   | 5.4.0                        | Simplified API testing in Java            |
| Extent Report | 5.x                          | Interactive HTML reports for test results |


### Why Extent Reports?

Interactive HTML report with color-coded test logs
Scenario-wise breakdown with detailed logging
Supports screenshots, logs, and custom entries
Easily integrated into TestNG + Cucumber
CI/CD friendly — compatible with Jenkins
Generates time-stamped reports for historical comparisons

### Why TestNG + Cucumber?

BDD-style readability (Cucumber) + robust test management (TestNG)
Better support for parallel execution, dependencies, configurations, and retry logic
Extent Reports integrates seamlessly with TestNG + Cucumber frameworks

Prerequisites

Java 21 (or Java 17) installed and added to PATH
Maven installed and added to PATH
Jenkins installed with necessary plugins (Git, Maven, Pipeline, HTML Publisher)

### 📂 Endpoints Covered

| Method | Endpoint           | Purpose                  |
|--------|--------------------|--------------------------|
| POST   | `/signup`          | Create a new employee    |
| POST   | `/login`           | Login and generate token |
| POST   | `/employees`       | Add a new employee       |
| PUT    | `/employees/{id}`  | Update employee details  |
| GET    | `/employees/{id}`  | Fetch employee by ID     |
| GET    | `/employees`       | Fetch all employees      |
| DELETE | `/employees/{id}`  | Delete an employee       |

### 📂 Endpoints Covered

POST `/signup` – Create a new employee<br>
POST `/login` – Login and generate a token<br>
POST `/employees` – Add a new employee<br>
PUT `/employees/{id}` – Update employee details<br>
GET `/employees/{id}` – Fetch employee by ID<br>
GET `/employees` – Fetch all employees<br>
DELETE `/employees/{id}` – Delete an employee<br>


### How to Run Tests
Clone the repository.
Build and run the tests using:
mvn clean test

After test execution, Extent Report will be available at:
test-output/ExtentReports/ExtentReport_<timestamp>.html

You can configure your runner class to generate timestamped reports.

@RunWith(Cucumber.class)

@CucumberOptions(

    features = "src/test/resources/features",
    glue = "com.yourpackage.stepdefs",
    plugin = {
        "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    tags = "@SmokeTest or @RegressionTest",
    monochrome = true
)public class TestRunner {
}


### CI/CD Pipeline Integration with Jenkins

**Prerequisites:**

Jenkins installed and running locally

Plugins installed:

Git, Maven, Pipeline, HTML Publisher


pipeline {

    agent any
    stages {
        stage('Build Dev') {
            steps {
                echo 'Building Dev Code...'
            }
        }
        stage('Trigger QA Automation') {
            steps {
                build job: 'QA-Repo'
            }
        }
    }
}

Jenkinsfile – QA Repo

pipeline {

    agent any
    tools {
        maven 'Maven 3.6.3'
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Yuvashreethaniga/EmployeeManagement.git', branch: 'master'
            }
        }
        stage('Build and Test') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Publish Extent Report') {
            steps {
                publishHTML([
                  reportDir: 'test-output/ExtentReports',
                    reportFiles: 'ExtentReport_*.html',
                    reportName: 'Extent Report',
                    keepAll: true
                ])
            }
        }
    }
}




