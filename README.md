# LabCorp Test Automation Framework
This project automates a careers page  on https://jobs.labcorp.com

## Table of Contents

## Tech Stack used
* Java 8  coding
* Maven  project builder
* JUnit  runner
* Cucumber  BDD framework
* Cucumber html reporter plugin  test outcome reporter
* Log4j  logger
  
## Getting Started  
Software to be preinstalled : 
* JDK 8  http://www.oracle.com/technetwork/java/javase/downloads/jdk8downloads2133151.html
* Maven  latest version here https://maven.apache.org/download.cgi
```
note that both tools should be set to environment variables      
```
## Running autotests from IntelliJ IDEA IDE
1. Clone repository
```
git clone https://github.com/gowthamui/LBCRP-TestAutomation.git
```
2. Open File > New > Project from Existing Source > Select `../interview/pom.xml` > Click 'Next' every prompt
3. Go to `interview/src/test/java/test_runners/LabCorpJobSearchTest.java` > click rmb > click 'Run...' in context menu to execute all existing tests.

## Running autotests from command line or terminal
1. Clone repository
```
git clone https://github.com/gowthamui/LBCRP-TestAutomation.git
```
2. Open directory: `interview/` 
3. In command line execute:
*  ```mvn test```    exetutes all tests inside `interview/src/test/java/test_runners/` with default browser set in config file
*  ```mvn -Dbrowser=chrome test```  executes test in chrome browser
*  ```mvn test -Dcucumber.options="tags @labcorp_search"```  to run specific tags

## BDD
Tests are developed using BDD approach, thanks to extremely powerfull Cucumber framework, which brings benefits of using DSL specification stories called 'Features', so basically it's aimed to write humanreadable scenarios to involve nontechnical people in process of automation

## Framework Structure
* Programming language – Java 8
* Type of framework – BDD
* Page Object – Separate class for every webpage, that hold all functionality and members of that webpage using PageFactory pattern
* Test base class: Deals with all the common functions used by all the pages, responsible for test launch, for reports,precond postcond, webdriver init, loading configs etc. 
* Packages: I have separate packages for Pages, Test steps and any other framework layer
* Utility Functions: The code which is repetitive in nature such as waits, scroll actions, property loader, logging etc.
* Property File: This file (config.properties) stores the information that remains static throughout the framework such as browser specific information, application URL, user data etc.
* Test Data: Is stored in resources and passed through feature file scenarios
* VCS: Git

## Test Layers
* Pages(webpages and elements & reusable methods)
* Test steps(logic implementation)
* Test launch(runners)
* Test data(feature files)

## Tests support crossplatform browser testing
 * Windows: 
      * Chrome
      * FireFox
 * MacOS:
      * Chrome
      * FireFox

Default browser is FireFox. To change browser, go to config.properties file and set 'browser_name = chrome'. Or override this property from cmd/terminal using:
```
mvn Dbrowser=browser_name test
```
P.S. Didn't have a chance to configure and test Safari browser, however Chrome and Firefox are supported on both platforms

## Results Reporting
* Every step is logged by log4j. It prints all actions perfomed by scripts to console output and stores all logs in:
```
//target/logs      
```
* Cucumber genarates simple html reports using htmlreportplugin. To browse cucumber reports, go to: interview/target/cucumberreports/LabCorpJobSearchTest     
```
* Open a file with extension ```*****.html``` in any preferrable browser

P.S. There are many opportunities to add more reusability and better reporting for the project

## Code Design
Project follows [Google Java](https://google.github.io/styleguide/javaguide.html) code style guide

For more detailed information about code design, please refer to incode documentation

## License
Project is licensed under [MIT](https://github.com/gowthamui/LBCRP-TestAutomation/master/LICENSE.md)