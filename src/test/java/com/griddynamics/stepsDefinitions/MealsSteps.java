package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.MealsPage;
import com.griddynamics.pageObjects.RegistrationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.FindBy;

public class MealsSteps extends BaseSteps {

    @When("user clicks add meal")
    public void addMealForUser() {
        page().toAddMeal();
    }

    @When("admin clicks users")
    public void toUsersPage() {
        page().toUsers();
    }

    @Then("user goes to Users page")
    public void adminOnUsersPage() {
        assertCurrentPageUrl(getData().usersFromAdminPageUrl(), "No users for admin");
    }

    private MealsPage page() {
        return getPage(MealsPage.class);
    }
}
