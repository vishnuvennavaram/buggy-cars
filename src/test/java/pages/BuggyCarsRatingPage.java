package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Page;

/**
 * This class has methods related to interact with Buggy cars rating page
 */
public class BuggyCarsRatingPage extends Page {

    public BuggyCarsRatingPage() {
        PageFactory.initElements(driverUtils.getDriver(), this);
    }

    @FindBy(css = "[name='login']")
    private WebElement txtUserName;
    @FindBy(css = "[name='password']")
    private WebElement txtPassword;
    @FindBy(css = "button.btn-success")
    private WebElement btnLogin;
    @FindBy(className = "label-warning")
    private WebElement invalidLoginMessage;
    @FindBy(linkText = "Logout")
    private WebElement btnLogout;
    @FindBy(xpath = "//div[h2[text()='Popular Make']]/a")
    private WebElement btnPopularMake;
    @FindBy(xpath = "//div[h2[text()='Popular Model']]/a")
    private WebElement btnPopularModel;
    @FindBy(xpath = "//div[h2[text()='Overall Rating']]/a")
    private WebElement btnOverallRating;
    @FindBy(id = "comment")
    private WebElement txtComment;
    @FindBy(xpath = "//div[@class='card-block']/ul")
    private WebElement specDetails;
    @FindBy(css = ".card .card-block h4 strong")
    private WebElement numberOfVotes;
    @FindBy(className = "btn-success")
    private WebElement btnVote;
    @FindBy(className = "card-text")
    private WebElement successfulVote;

    public void navigateToBuggyCars() {
        browserUtils.navigateToUrl("http://buggy.justtestit.org/");
        browserUtils.maximizeWindow();
    }

    public BuggyCarsRatingPage enterUserNameAndPassword(String userName, String password) {
        pageUtils.waitForElementToBeVisible(txtUserName).sendKeys(userName);
        pageUtils.waitForElementToBeVisible(txtPassword).sendKeys(password);
        return this;
    }

    public BuggyCarsRatingPage clickOnLogin() {
        pageUtils.clickElement(btnLogin);
        return this;
    }

    public String getInvalidLoginMessage() {
        return pageUtils.waitForElementToBeVisible(invalidLoginMessage).getText();
    }

    public boolean isLogoutLinkDisplayed() {
        return pageUtils.waitForElementToBeVisible(btnLogout).isDisplayed();
    }

    public void clickOnLogout(){
        pageUtils.clickElement(btnLogout);
    }

    public void clickOnPopularMake() {
        pageUtils.clickElement(btnPopularMake);
    }

    public void clickOnPopularModel() {
        pageUtils.clickElement(btnPopularModel);
    }

    public void clickOnOverallRating() {
        pageUtils.clickElement(btnOverallRating);
    }

    public void selectModel(String model) {
        driverUtils.getDriver().findElement(By.cssSelector("[title='"+model+"']")).click();
    }

    public String getCurrentVoteCount() {
        return pageUtils.waitForElementToBeVisible(numberOfVotes).getText();
    }

    public void enterComment(String comment) {
        pageUtils.waitForElementToBeVisible(txtComment).sendKeys(comment);
    }

    public String getSpecificationDetails(){
        return pageUtils.waitForElementToBeVisible(specDetails).getText().replaceAll("\\r\\n|\\r|\\n", " ");
    }
    public void clickOnVoteButton() {
        pageUtils.clickElement(btnVote);
    }

    public String getSuccessfulVoteMessage() {
        return pageUtils.waitForElementToBeVisible(successfulVote).getText();
    }
}
