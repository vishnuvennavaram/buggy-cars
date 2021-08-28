import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/*
 * This class is Runner file using Junit
 */
@RunWith(Cucumber.class)
@CucumberOptions(
         plugin = {"pretty", "html:target/cucumber-report.html"},
        // strict is defaulted to false
        // default value of monochrome is false
        monochrome = true,
        tags = "@unSuccessfulRegistration",
        // features is the path of features under the project folder
        features = "src/test/resources/features/",
        // glue is the path or hook to find the folder of step classes
        glue = {"steps"}
)
public class RunTest {
}

/* JUnit Runner Documentation
 * Install Generate tests plugin in IntelliJ for reports
 * @RunWith(Cucumber.class) annotation is to execute all features found on the classpath in the same package as this class
 * Name of the class could be anything like RunTes^ts.java
 * @CucumberOptions annotation provides the same options as the cucumber jvm command line.
 * for example: we can specify the path to feature files, path to step definitions.
 * @Plugin: specify different formatting options for the output reports.
 * Various options that can be used as for-matters are-
 * Pretty - @CucumberOptions(plugin = {"pretty"}, strict = false)
 * HTML - @CucumberOptions(plugin ={"pretty" , "html:Folder_Name"})
 * Json - @CucumberOptions(plugin = {"pretty" ,"json:Folder_Name/cucumber.json"})
 * Junit - @CucumberOptions(plugin = {"pretty" ,"junit:Folder_Name/cucumber.xml"})
 * @DryRun: if it is set as true, it means that Cucumber will only checks that every Step mentioned in the Feature File
 * have corresponding code written in Step Definition file or not. So in case any of the function is missed in the Step Definition for any Step in Feature File, it will give us the message. So If you writing scenarios first and then implementing step definitions then add dryRun = true.
 * -@CucumberOptions(plugin = {"pretty"}, dryRun = true)
 * @Strict: if strict option is set to false then at execution time if cucumber encounters any undefined/pending steps
 * then cucumber does not fail the execution and undefined steps are skipped and BUILD is SUCCESSFUL.
 * --@CucumberOptions(plugin = {"pretty"}, strict = false
 * @Monochrome: This option can either set as true or false (default value is false). If it is set as true, it means that the console output for the Cucumber test are much more readable.
 * And if it is set as false, then the console output is not as readable as it should be.
 * --@CucumberOptions(plugin = {"pretty"}, strict = true, monochrome = true)
 * @Features: Features Options helps Cucumber to locate the Feature file in the project folder structure.
 * All we need to do is to specify the folder path and Cucumber will automatically find all the ‘.features‘ extension files in the folder.
 * -- @CucumberOptions(features = “Feature“)
 * --Or if the feature file is in the deep folder structure-@CucumberOptions( features = “src/test/features“)
 * @Glue: It is almost the same think as Features Option but the only difference is that it helps Cucumber to locate theStep Definition file. Whenever Cucumber encounters a Step,
 * it looks for a Step Definition inside all the files present in the folder mentioned in Glue Option.
 * -@CucumberOptions(features = “Feature“ glue = “stepDefinition“)
 * -@CucumberOptions(features = “src/test/features“ glue = “src/test/stepDeinition“ )
 * @Tag -Running Scenarios with a Tag
 * --@CucumberOptions(features = “src/test/features“,tags ={“@Webdriver“,"test"})
 * --Running Scenarios without Tag.Cucumber can exclude scenarios with a particular tag
 * --@CucumberOptions(features = “src/test/features“, tags ={“~@ignore“,"test"})
 *
 * @REFERENCE --https://testingneeds.wordpress.com/2015/09/15/junit-runner-with-cucumberoptions/
 */

