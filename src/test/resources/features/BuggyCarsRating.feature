@buggyCars
Feature: Buggy Cars Rating
  As a user to Buggy cars
  I would like to Register, login and check Specifications
  So that I can provide feedback for Buggy cars

  @successfulRegistration
  Scenario: Verify Successful Registration
    Given I am on Buggy Cars Home page
    And I click on Register
    And I fill required registration fields <Username>,<Firstname>,<Lastname>,<Password>
     |loginviswa02 |viswafirst|viswalast|Login@1234|
    When I click on Register button
    Then I will see successful registration message

  @unSuccessfulRegistration
  Scenario: Verify Unsuccessful Registration
    Given I am on Buggy Cars Home page
    And I click on Register
    And I fill all registration details which matches existing <Username>,<Firstname>,<Lastname>,<Password>
      |loginviswa001|testfirst|testlast|Viswa@1234|
    When I click on Register button
    Then I will see Unsuccessful registration message

  @invalidLogin
  Scenario: Verify Invalid Login
    Given I am on Buggy Cars Home page
    When I login with invalid username and password combination
      | loginph@224 | abcd |
    Then I will see error message displayed for invalid login

  @validLogin
  Scenario: Verify Valid Login
    Given I am on Buggy Cars Home page
    When I login with valid username and password combination
      | loginviswa001 | Viswa@1234|
    Then I will see successful login and logout option available
    And I logOut

  @popularMakeSpec
  Scenario: Verify Specification Details Using Popular Make
    Given I am on Buggy Cars Home page
    When I login with valid username and password combination
      | loginviswa001 | Viswa@1234 |
    And I click on popular make
    And I select "Lamborghini Veneno" model
    Then I will see model <specification> details
    |Engine: 6.5l Max Speed: 355km/h|
    And I logOut

  @popularModelSpec
  Scenario: Verify Specification Details Using Popular Model
    Given I am on Buggy Cars Home page
    When I login with valid username and password combination
      | loginviswa001 | Viswa@1234 |
    And I click on popular model
    Then I will see model <specification> details
      |Engine: 6.0l Max Speed: 25km/h|
    And I logOut

  @overallRatingSpec
  Scenario: Verify Specification Details Using Overall Rating
    Given I am on Buggy Cars Home page
    When I login with valid username and password combination
      | loginviswa001 | Viswa@1234|
    And I click on Overall rating
    And I select "Pagani Zonda" model
    Then I will see model <specification> details
      |Engine: 6.0l Max Speed: 350km/h|
    And I logOut


