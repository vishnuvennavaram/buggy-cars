package utils;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

/**
 * This class contains methods related to browser level methods
 */
public class BrowserUtils {
    private WebDriver driver;
    private DriverUtils driverUtils;

    // constructor
    public BrowserUtils() {
        driverUtils = DriverUtils.getInstance();
        driver = driverUtils.getDriver();
    }

    /**
     *  Open the browser and navigate to the URL
     *  @param url is the the page to be navigated
     *  @return the object of Browser utils to allow method cascading
     */
    public BrowserUtils navigateToUrl(String url) {
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return this;
    }

    /**
     *  maximize the browser window
     *  @return the object of Browser utils to allow method cascading
     */
    public BrowserUtils maximizeWindow() {
        //driver.manage().window().maximize();
        return this;
    }

    /**
     * Close the browser when the Thread closes
     */
    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            WebDriver driver = DriverUtils.getInstance().getDriver();
            if (driver != null) {
                driver.quit();
            }

        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }
}
