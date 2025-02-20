**Automation Testing Project**
The framework used in this automation suite comprehensively covers testcases for Web UI, API & Data validation, all integrated and executed using TestNG. It uses Selenium WebDriver & Cucumber for UI automation, RestAssured for API automation testing, and file-based validation for data validation tests. All test results are captured and displayed in Extent Reports for better readability and analysis.

**Table of Contents**
- Technologies Used
- Project Structure
- UI Automation
- API Automation
- Data Validation Tests
- Test Execution
- Reports

**Technologies Used**
- Selenium: For automating UI tests and simulating user interactions on the web.
- Cucumber: For automating UI tests with feature files & step definition. Page object model has been implemented.
- Rest Assured: For automating API tests and verifying the responses.
- TestNG: For executing and managing the tests.
- ExtentReports: For generating detailed test reports with screenshots and logs.
- Maven: For managing dependencies and build automation.

**Project Structure**
```
+---src
   +---main
      +---java
      +---resources
   +---test
       +---java
          +---com
              +---listeners
              +---tests
                  +---api
                     +---endpoints
                     +---payload
                     +---tests
                  +---db
                     +---app_in
                     +---app_out
                     +---Testcases
                  +---web
                      +---features
                      +---pages
                      +---runners
                      +---stepDefinitions
       +---resources
+---test-output
   +---SparkReport
+---test-output-thread
```
**Dependencies**

This project uses Maven for dependency management. The `pom.xml` file contains all the dependencies required to run UI, API, and data validation tests.
Here are the key dependencies that are included in the `pom.xml`:

<dependencies>
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
<groupId>org.testng</groupId>
<artifactId>testng</artifactId>
<version>7.10.2</version>
<scope>test</scope>
</dependency>

        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.20.1</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-testng -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-testng</artifactId>
            <version>7.20.1</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.cucumber/gherkin -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>gherkin</artifactId>
            <version>31.0.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.5.0</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured-common</artifactId>
            <version>5.5.0</version> <!-- Use the appropriate version -->
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>json-schema-validator</artifactId>
            <version>5.5.1</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.rest-assured/json-path -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>json-path</artifactId>
            <version>5.5.1</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.28.1</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.18.2</version>
        </dependency>

        <!-- Jackson Datatype for Java 8 Time Types -->
        <dependency>
            <groupId>com.fasterxml.jackson.datatype</groupId>
            <artifactId>jackson-datatype-jsr310</artifactId>
            <version>2.13.0</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
        <dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>5.1.2</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/tech.grasshopper/extentreports-cucumber7-adapter -->
        <dependency>
            <groupId>tech.grasshopper</groupId>
            <artifactId>extentreports-cucumber7-adapter</artifactId>
            <version>1.14.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.18.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.github.java-json-tools/json-schema-validator -->
        <dependency>
            <groupId>com.github.java-json-tools</groupId>
            <artifactId>json-schema-validator</artifactId>
            <version>2.2.14</version>
        </dependency>
    </dependencies>

**Additional plugin**

    <build>
       <plugins>
          <plugin>
             <groupId>org.apache.maven.plugins</groupId>
             <artifactId>maven-surefire-plugin</artifactId>
             <version>3.5.2</version>
             <configuration>
                <suiteXmlFiles>
                   <suiteXmlFile>
                      src/test/java/testng.xml
                   </suiteXmlFile>
                </suiteXmlFiles>
             </configuration>
          </plugin>
       </plugins>
    </build>

**UI Automation**
Overview:
UI tests are automated using Selenium WebDriver to simulate user interactions with the application and verify that the user interface behaves as expected. The tests cover various use cases such as login, check different request/response, Support/Upgrade and navigation.

Features:
- Browser testing with Chrome. 
- Page Object Model (POM) design for maintainability and reusability.
- Cucumber for readability.

Running UI Tests:
To execute UI tests, ensure that the necessary WebDriver executables are available in the system's PATH or specified in the project configuration.

**API Automation**
Overview:
API automation is performed using RestAssured to test various API endpoints and verify the responses. This ensures the backend services behave as expected, return correct status codes, and produce expected results.

Features:
• Testing of various HTTP methods (GET, POST).
• Request and response validation with JSON.
• Schema and data of response are validated.

Running API Tests:
You can execute the API tests through TestNG.

**Data Validation Tests**
Overview:
Data validation tests verify that the application processes input data correctly and generates the expected output. The tests compare the actual output with the expected output stored in text files.

Input Files:
• input_data_1.txt: First input file containing test data InstrumentDetails.
• input_data_2.txt: Second input file containing additional test data PositionDetails.
• expected_output.txt: Expected output file PositionReport.csv for comparison.
Features:
• Validates correctness, integrity, transformation and format of input/output data.

Running Data Validation Tests:
Data validation tests are executed via Java I/O & TestNG, and compare input files with the expected output file.

**Test Execution**
Prerequisites:
• Java 11 or higher.
• Maven for managing dependencies and building the project.
• WebDriver executables (ChromeDriver) for Selenium tests.
• All dependencies (Selenium, RestAssured, Apache commons, ExtentReports) are automatically downloaded by Maven.

**Running All Tests**
You can run all the tests together (UI, API, and Data validation) using Maven:
**mvn clean test**

**Running Specific Tests**
To run specific test classes, use
mvn test -Dtest=<TestClassName>

**Reports**
Extent Reports:
All test results are captured using ExtentReports, which generates detailed, user-friendly reports. These reports include test status (pass/fail), execution time, screenshots of failed tests, and logs.

**Viewing Reports**
After the tests are executed, you can view the reports generated in the following location:
• Extent Report: test-output/SparkReport/SparkReport.html
This report will contain:
• A summary of tests execution.
• Details of individual test cases.
