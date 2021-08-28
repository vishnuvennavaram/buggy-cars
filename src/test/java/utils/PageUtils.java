package utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * This class contains methods to interact with pages
 * Will contain methods for validations and to get the object state
 * Will contain wait methods
 */

public class PageUtils {
    private WebDriver driver;
    private DriverUtils driverUtils;
    private JavascriptExecutor js;
    private WebDriverWait wait;

    // Used for logging
    private Log log = LogFactory.getLog(PageUtils.class.getName());

    public PageUtils() {
        driverUtils = DriverUtils.getInstance();
        driver = driverUtils.getDriver();
    }

    private static final long TIMEOUT_IN_SEC = 10;

    /**
     * To wait till the element is visible on UI otherwise do not throw exception
     *
     * @param webElement     is element to be Visible
     * @param timeoutSeconds is the maximum time to wait to check the condition
     * @return element to support method cascading
     */
    public WebElement waitForElementToBeVisible(WebElement webElement, long timeoutSeconds) {
        // Web driver wait will by default ignore the No such element exception
        wait = new WebDriverWait(driver, timeoutSeconds);
        try {
            return wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (NullPointerException e) {
            return webElement;
        }
    }

    /**
     * To wait till the element is visible on UI otherwise do not throw exception
     *
     * @param webElement is element to be Visible
     * @return element to support method cascading
     */
    public WebElement waitForElementToBeVisible(WebElement webElement) {
        return waitForElementToBeVisible(webElement, TIMEOUT_IN_SEC);
    }

    /**
     * To wait till the element is visible and enabled so that it can be clickable
     *
     * @param webElement     is element to be clicked
     * @param timeoutSeconds is the maximum time to wait to check the condition
     * @return element to support method cascading
     */
    public WebElement waitForElementToBeClickable(WebElement webElement, long timeoutSeconds) {
        wait = new WebDriverWait(driver, timeoutSeconds);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (NullPointerException e) {
            return webElement;
        }
    }

    /**
     * To wait till the element is visible and enabled so that it can be clickable
     *
     * @param webElement is element to be clicked
     * @return element to support method cascading
     */
    public WebElement waitForElementToBeClickable(WebElement webElement) {
        return waitForElementToBeClickable(webElement, TIMEOUT_IN_SEC);
    }

    /**
     * To click on an element
     *
     * @param webElement is element to be clicked once its clickable
     */
    public void clickElement(WebElement webElement) {
        waitForElementToBeClickable(webElement).click();
    }
}
