package com.griddynamics.stepsDefinitions;

import cucumber.api.java.en.Then;

public class AssertRightPageSteps extends BaseSteps {

    @Then("user goes to Registration page")
    public void userOnRegistrationPage() {
        assertCurrentPageUrl(getData().registrationPageUrl(), "No registration");
    }

    @Then("user goes to Meals page")
    public void userOnMealsPage() {
        assertCurrentPageUrl(getData().mealsPageUrl(), "No meals for user");
    }

    @Then("admin goes to Meals page")
    public void adminOnMealsPage() {
        assertCurrentPageUrl(getData().mealsPageUrl(), "No meals for admin");
    }

    @Then("admin goes to Users page")
    public void adminOnUsersPage() {
        assertCurrentPageUrl(getData().usersFromAdminPageUrl(), "No users for admin");
    }

    @Then("user goes to login page")
    public void userOnLoginPage() {
        assertCurrentPageUrl(getData().loginPageUrl(), "No login page for user");
    }

}
