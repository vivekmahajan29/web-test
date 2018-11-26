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
````

## Steps to run Serenity from Intellij/Eclipse

For running from IDE
````
1. Need to copy date from browsers folder(containing chrome and firefox properties)
   into the serenity.properties
2. Either right click on any feature file(will need to install plugin for Cucumber)
   and Run or Go to the ApplicationTestRunner and run
   Can use Cucumber options: 
   // tags= {"@create,@update"},
   @CucumberOptions(features = "src/test/resources/features")
   
````


