package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.UsersForAdminPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;


public class UsersFromAdminSteps extends BaseSteps {
    @When("admin clicks add user")
    public void toAddUser() {
        page().bToAddUsers.click();
    }

    @Then("user is in wrong format")
    public void toDisplayWrongUser() {
        getWait().until(ExpectedConditions.visibilityOf(page().isWrongUser));
        assertTrue(page().isWrongUser.isDisplayed());
    }

    public UsersForAdminPage page() {
        return getPage(UsersForAdminPage.class);
    }
}
