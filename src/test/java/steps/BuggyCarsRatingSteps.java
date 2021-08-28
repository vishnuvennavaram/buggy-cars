package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BuggyCarsRatingPage;

import java.util.List;

/**
 * This class includes all the method implementation of the Buggy cars rating steps and uses its page methods.
 */
public class BuggyCarsRatingSteps {
    BuggyCarsRatingPage buggyCarsRatingPage;

    public BuggyCarsRatingSteps(BuggyCarsRatingPage buggyCarsRatingPage) {
        this.buggyCarsRatingPage = buggyCarsRatingPage;
    }

    @Given("I am on Buggy Cars Home page")
    public void iAmOnBuggyCarsHomePage() {
        buggyCarsRatingPage.navigateToBuggyCars();
    }

    @When("I login with valid username and password combination")
    public void iLoginWithValidUsernameAndPasswordCombination(DataTable userCredentials) {
        List<String> data = userCredentials.asList();
        buggyCarsRatingPage.enterUserNameAndPassword(data.get(0),data.get(1)).clickOnLogin();
    }

    @When("I login with invalid username and password combination")
    public void iLoginWithInvalidUsernameAndPasswordCombination(DataTable userCredentials) {
        List<String> data = userCredentials.asList();
        buggyCarsRatingPage.enterUserNameAndPassword(data.get(0), data.get(1)).clickOnLogin();
    }

    @Then("I will see error message displayed for invalid login")
    public void iWillSeeErrorMessageDisplayedForInvalidLogin() {
        Assert.assertEquals("Invalid username/password", buggyCarsRatingPage.getInvalidLoginMessage());
    }

    @Then("I will see successful login and logout option available")
    public void iWillSeeSuccessfulLoginAndLogoutOptionAvailable() {
        Assert.assertTrue(buggyCarsRatingPage.isLogoutLinkDisplayed());
    }

    @And("I click on popular make")
    public void iClickOnPopularMake() {
        buggyCarsRatingPage.clickOnPopularMake();
    }

    @And("I select {string} model")
    public void iSelectModel(String model) {
        buggyCarsRatingPage.selectModel(model);
    }

    @And("I click on popular model")
    public void iClickOnPopularModel() {
        buggyCarsRatingPage.clickOnPopularModel();
    }

    @And("I click on Overall rating")
    public void iClickOnOverallRating() {
        buggyCarsRatingPage.clickOnOverallRating();
    }


    @And("I logOut")
    public void iLogOut() {
        buggyCarsRatingPage.clickOnLogout();
    }

    @Then("I will see model <specification> details")
    public void iWillSeeModelSpecificationDetails(DataTable userCredentials) {
        List<String> data = userCredentials.asList();
        Assert.assertEquals(data.get(0), buggyCarsRatingPage.getSpecificationDetails());
    }
}
