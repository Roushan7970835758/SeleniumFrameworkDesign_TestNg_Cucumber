
## Selenium + TestNG + Cucumber UI Automation Framework

![Alt text](Screenshot4.png)
![Alt text](Screenshot3.png)

Hybrid UI test automation framework using Java, Selenium WebDriver, TestNG, and Cucumber. Includes data-driven tests, page object model, rich reports, and TestNG suite profiles.

### Requirements
- Java 17+
- Maven 3.8+
- Chrome/Firefox/Edge (locally installed)

### Tech Stack
- Selenium 4, TestNG 7, Cucumber 7, ExtentReports 5
- WebDriverManager for driver binaries
- Jackson for JSON test data

### Project Structure
```plaintext
src/main/java
├── Selenium.AbstractComponents
│   ├── AbstractComponents.java
├── Selenium.pageObject
│   ├── cartPage.java
│   ├── CheckOutPage.java
│   ├── conformationPage.java
│   ├── landingPage.java
│   ├── orderPage.java
│   ├── productCatalog.java
├── Selenium.resources
    ├── ExtentReporterNG.java
    ├── GlobalData.properties

src/test/java
├── cucumber
│   ├── TestNGTestRunner.java
│   ├── errorValidation.feature
│   ├── SubmitOrder.feature
├── Selenium.Data
│   ├── dataReader.java
│   ├── PurchaseData.json
├── Selenium.stepDefinition
│   ├── stepDefinitionImpl.java
├── Selenium.test
│   ├── AppTest.java
│   ├── errorValidationTest.java
│   ├── standAlone.java
│   ├── submitOrderTest.java
├── Selenium.TestComponents
    ├── BaseTest.java
    ├── Listeners.java
    ├── Retry.java
    ├── testing.java

TestSuite
├── ErrorValidation.xml
├── purchase.xml
├── testng.xml
├── testng2.xml

reports
├── reports1

pom.xml
```

### Configuration
- Browser: set in `src/main/java/Selenium/resources/GlobalData.properties`
  - `browser=chrome` (default). Override with Maven: `-Dbrowser=firefox` or `-Dbrowser=edge`.
- Base URL is also in `GlobalData.properties` as `url`.
- Test data: `src/test/java/Selenium/Data/PerchaseData.json`.

### Quick Start
1) Install dependencies
```bash
mvn clean install
```

2) Run the default regression suite (TestNG)
```bash
mvn test -PRegression
```

3) Run purchase suite
```bash
mvn test -Ppurchase
```

4) Run error validation suite
```bash
mvn test -PErrorValidation
```

5) Run Cucumber tests (via TestNG runner)
```bash
mvn test -PCucumberTests
```
Tags are configured in `cucumber/TestNGTestRunner.java` (`@CucumberOptions`). Adjust tags there if needed.

6) Run with a specific browser
```bash
mvn test -PRegression -Dbrowser=firefox
```

7) Run a specific TestNG XML without a profile (alternative)
```bash
mvn -Dsurefire.suiteXmlFiles=TestSuite/purchase.xml test
```

### Reports
- Extent report: `reports/index.html`
- Cucumber report: `target/cucumber.html`
- TestNG report: `test-output/index.html`
- Screenshots on failure: `reports1/<TestName>_<timestamp>.png`

### IDE Usage
- Open the project as a Maven project.
- Run `TestSuite/*.xml` from the IDE or run individual tests/classes.
- For Cucumber, run `cucumber.TestNGTestRunner`.

### Troubleshooting
- WebDriver version issues: WebDriverManager auto-resolves drivers; ensure browsers are up to date.
- Java version: Ensure JAVA_HOME points to Java 17+ (`mvn -v` should show Java 17).
- Clean target if suites behave unexpectedly: `mvn clean`.

### Example Reports
![Alt text](Screenshot1.png)
![Alt text](Screenshot2.png)

### Contributing
PRs and issues are welcome.
