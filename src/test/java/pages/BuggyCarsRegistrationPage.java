package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Page;

/**
 * This class has methods related to interact with Buggy cars Registration page
 */
public class BuggyCarsRegistrationPage extends Page {

    public BuggyCarsRegistrationPage() {
        PageFactory.initElements(driverUtils.getDriver(), this);
    }

    @FindBy(className = "btn-success-outline")
    private WebElement linkRegister;
    @FindBy(id = "username")
    private WebElement txtLogin;
    @FindBy(id = "firstName")
    private WebElement txtFirstName;
    @FindBy(id = "lastName")
    private WebElement txtLastName;
    @FindBy(id = "password")
    private WebElement txtPassword;
    @FindBy(id = "confirmPassword")
    private WebElement txtConfirmPassword;
    @FindBy(className = "btn-default")
    private WebElement btnRegister;
    @FindBy(css = ".result.alert-success")
    private WebElement txtSuccessMessage;
    @FindBy(css = ".result.alert-danger")
    private WebElement txtUnSuccessfulMessage;

    public void clickOnRegisterLink() {
        pageUtils.clickElement(linkRegister);
    }

    public BuggyCarsRegistrationPage enterLoginName(String loginName) {
        pageUtils.waitForElementToBeVisible(txtLogin).sendKeys(loginName);
        return this;
    }

    public BuggyCarsRegistrationPage enterFirstName(String firstName) {
        pageUtils.waitForElementToBeVisible(txtFirstName).sendKeys(firstName);
        return this;
    }

    public BuggyCarsRegistrationPage enterLastName(String lastName) {
        pageUtils.waitForElementToBeVisible(txtLastName).sendKeys(lastName);
        return this;
    }

    public BuggyCarsRegistrationPage enterPasswordAndConfirm(String password) {
        pageUtils.waitForElementToBeVisible(txtPassword).sendKeys(password);
        pageUtils.waitForElementToBeVisible(txtConfirmPassword).sendKeys(password);
        return this;
    }

    public void clickOnRegisterButton() {
        pageUtils.clickElement(btnRegister);
    }

    public String getSuccessfulRegistrationMessage() {
        return pageUtils.waitForElementToBeVisible(txtSuccessMessage).getText();
    }

    public String getUnSuccessfulRegistrationMessage() {
        return pageUtils.waitForElementToBeVisible(txtUnSuccessfulMessage).getText();
    }
}
