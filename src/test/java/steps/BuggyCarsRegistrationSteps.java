package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BuggyCarsRegistrationPage;
import utils.CommonUtils;

import java.util.List;

/**
 * This class includes all the method implementation of Buggy cars Registration steps.
 */
public class BuggyCarsRegistrationSteps {

    BuggyCarsRegistrationPage buggyCarsRegistrationPage;
    CommonUtils commonUtils;

    public BuggyCarsRegistrationSteps(BuggyCarsRegistrationPage buggyCarsRegistrationPage) {
        this.buggyCarsRegistrationPage = buggyCarsRegistrationPage;
        commonUtils = new CommonUtils();
    }

    @Given("I click on Register")
    public void iClickOnRegister() {
        buggyCarsRegistrationPage.clickOnRegisterLink();
    }

    @When("I click on Register button")
    public void iClickOnRegisterButton() {
        buggyCarsRegistrationPage.clickOnRegisterButton();
    }

    @Then("I will see successful registration message")
    public void iWillSeeSuccessfulRegistrationMessage() {
        Assert.assertEquals("Registration is successful",
                buggyCarsRegistrationPage.getSuccessfulRegistrationMessage());
    }

    @Then("I will see Unsuccessful registration message")
    public void iWillSeeUnsuccessfulRegistrationMessage() {
        Assert.assertEquals("UsernameExistsException: User already exists",
                buggyCarsRegistrationPage.getUnSuccessfulRegistrationMessage());
    }


    @And("I fill required registration fields <Username>,<Firstname>,<Lastname>,<Password>")
    public void iFillRequiredRegistrationFieldsUsernameFirstnameLastnamePassword(DataTable userCredentials) {
        List<String> data = userCredentials.asList();
        // to get unique identification for username
        commonUtils.setEpochSecond();
        buggyCarsRegistrationPage.enterLoginName(data.get(0)+commonUtils.getEpochSecond())
                .enterFirstName(data.get(1))
                .enterLastName(data.get(2))
                .enterPasswordAndConfirm(data.get(3));
    }

    @And("I fill all registration details which matches existing <Username>,<Firstname>,<Lastname>,<Password>")
    public void iFillAllRegistrationDetailsWhichMatchesExistingUsernameFirstnameLastnamePassword(DataTable userCredentials) {
        List<String> data = userCredentials.asList();
        buggyCarsRegistrationPage.enterLoginName(data.get(0))
                .enterFirstName(data.get(1))
                .enterLastName(data.get(2))
                .enterPasswordAndConfirm(data.get(3));
    }
}
