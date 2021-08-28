# Buggy-Cars-Rating

# Pre-requisites / Setup: 
- Install JAVA (JDK 1.8) and configure it
- JAVA IDE (Eclipse, IntelliJ, etc.,)
- Install maven latest version and configure it
- Install git tool
- git clone https://bitbucket.org/viswanadhs/buggycarswestpac.git
- Download Google Chrome Driver (https://chromedriver.chromium.org/downloads) based on your local browser configuration 
- update the Driver parameters in testConfig.properties file located in /src/main/resources
	
  (eg: 
	     Browser=Chrome, 
             DriversLocation=C:\\BuggyCars\\chromedriver.exe
         )


# How to run tests and view test results:

1. Run from IntelliJ
- Execute the RunTest.java locate at "\src\test\java\RunTest.java"
- User can view the tests are executing
-  execution summary report will be generated to cucumber-report.html located at "\target\cucumber-report.html"
- Open cucumber-report.html in browser 

2. Run from cmd line
- cd BuggyCars
- mvn test
