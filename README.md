# serenity-bdd-cucumber-gradle-mvn framework
web tests written using Serenity BDD with Cucumber JVM(can be run using both: Gradle and Maven)

Icon below is the Circle CI(Similar to Jenkins) link which is connected to this git repository project where tests get triggered whenever a commit is pushed(Tests are run against Unix machine and Chromedriver. Refer circle.yml in the project): 

[![CircleCI](https://circleci.com/gh/vivekmahajan29/web-test.svg?style=svg)](https://circleci.com/gh/vivekmahajan29/web-test)

Imp Note: Serenity uses selenium2, hence, max.supported version of firefox is 46

## Serenity BDD Cucumber JVM implementation

The project structure is shown below:
````
+ browsers
    Property files for chrome and firefox
+ helpers
    Enums and Navigation class for navigation between pages
+ pages
    Representation of Application Home page and Create/Edit page
+ features
    Define scenarios in Given/When/Then format for Create/Update 
    Computer(Delete is covered as precondition and Read is  
    covered as verification step)
+ steps
    Step definitions glued to feature scenario steps
+ steps/serenity
    Layer of abstraction between step definition(WHAT!) and pages(HOW!)
+ ApplicationTestRunner
    CucumberWithSerenity Junit Runner
+ target/site/serenity
    Test Reports(view index.html)
````

## Steps to run Serenity from Intellij/Eclipse

For running from IDE
````
1. Need to copy data from browsers folder(containing chrome and firefox properties)
   into the serenity.properties
2. Either right click on any feature file(will need to install plugin for Cucumber)
   and Run or Go to the ApplicationTestRunner and run
   Can use Cucumber options: 
   // tags= {"@create,@update"},
   @CucumberOptions(features = "src/test/resources/features")
````

## Steps to run Serenity using Gradle(Refer build.gradle for more info)
Different gradle commands for running the tests
````
1. gradle clean test aggregate
2. gradle clean test aggregate -Dwebdriver.driver=firefox
3. gradle clean test aggregate -Dserenity.properties=browsers/firefox.properties 
4. gradle clean test aggregate -Dserenity.properties=browsers/chrome.properties
   -Dcucumber.options="--tags @create,@update"
````
## Steps to run Serenity using Maven(Refer pom.xml for more info)
Different mvn commands for running the tests
````
1. mvn clean verify
2. mvn clean verify -Dwebdriver.driver=chrome
3. mvn clean verify -Dwebdriver.driver=chrome -Dproperties=browsers/chrome.properties
   -Dcucumber.options="--tags   @create,@update"
4. mvn verify -Dwebdriver.driver=chrome -Dwebdriver.chrome.driver=./drivers/chrome/mac
````
## Test Scenarios
All the scenarios are covered in src/test/resources/features(also covers manual scenarios 
as it is a spec)
````
1. Regression:
   + CreateNewComputerItem covers scenarios like create with all item types/ with only
     required types
   + UpdateComputerItem covers scenarios like update all item types/ create with only
     required types then update with all optional types
2. Smoke:
   + Covers journey: CRUD operation
3. Delete(including multiple duplicate records) and Search are part of all the scenarios   
````

