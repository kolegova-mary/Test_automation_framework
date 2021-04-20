package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.UsersForAdminPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;


public class UsersFromAdminSteps extends BaseSteps {
    @When("admin clicks add user")
    public void toAddUser() {
        page().toAddUser();
    }

    @Then("user is in wrong format")
    public void toDisplayWrongUser() {
        assertTrue(page().isWrongUser());
    }

    public UsersForAdminPage page() {
        return getPage(UsersForAdminPage.class);
    }
}
