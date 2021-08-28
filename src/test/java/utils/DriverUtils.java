package utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains methods related to driver instance and configuration settings of test execution
 */
public class DriverUtils {
    // Creating an instance of the class to make it singleton(No multiple instance of the same class across the project)
    private static final DriverUtils instance = new DriverUtils();
    // static Webdriver to make it instantiated at the start
    private static WebDriver driver;
    // properties object to read property files
    Properties properties;

    private final Log log = LogFactory.getLog(DriverUtils.class.getName());

    /**
     * Static constructor to return the class instance
     * Main Concept in this framework
     *
     * @return instance of DriverUtils
     */
    public static DriverUtils getInstance() {
        return instance;
    }

    /**
     * To get the driver object ref to use it in any class by calling this method
     * Instantiate the browser if not done already else return the existing driver
     *
     * @return driver reference to access it directly
     */
    public WebDriver getDriver() {
        if (driver == null) {
            driver = instantiateBrowser();
        }
        return driver;
    }

    /**
     * Instantiate the browser and get the driver reference
     * New driver is instantiated when ever this method is called
     *
     * @return driver reference to access it directly
     */
    private WebDriver instantiateBrowser() {
        driver = getWebDriver();
        return driver;
    }

    /**
     * To get the WebDriver instantiated based on the configured run type of Browser
     * Browser type and path are read from config properties
     *
     * @return driver object for further use
     */
    private WebDriver getWebDriver() {
        String browserType;
        String driverPath;

        // Read the browser details configured from properties file
        properties = readPropertiesFile("src/main/resources/testConfig.properties");
        browserType = properties.getProperty("Browser");
        driverPath = properties.getProperty("DriversLocation");

        //CHROME
        if (browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverPath);
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability("Platform", Platform.MAC.ANY);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(capabilities);
        }
        //Firefox
        else if (browserType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", driverPath );
            driver = new FirefoxDriver();
        }
        // Internet Explorer
        else if (browserType.equalsIgnoreCase("internet explorer")) {
            System.setProperty("webdriver.ie.driver", driverPath);
            /*DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
            cap.setCapability("browserName", "internet explorer");*/
            driver = new InternetExplorerDriver();
        }
        log.info("Browser:" + browserType + " is instantiated");
        return driver;
    }

    /**
     * Method to read the property file and save it in an object
     *
     * @param filePath is the path of the Property file to be read
     * @return object of the properties for further use to read the contents
     */
    private Properties readPropertiesFile(String filePath) {
        try {
            // path of configuration file with Test execution conditions
            File file = new File(filePath);
            FileInputStream fileInput = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
