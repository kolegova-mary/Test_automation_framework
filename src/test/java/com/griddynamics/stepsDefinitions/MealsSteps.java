package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.MealsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class MealsSteps extends BaseSteps {

    @When("user clicks add meal")
    public void addMealForUser() {
        page().toAddMeal();
    }

    @When("admin clicks users")
    public void toUsersPage() {
        page().toUsers();
    }

    @Then("meal is in wrong format")
    public void toDisplayWrongMeal() {
        assertTrue(page().isWrongMeal());
    }

    private MealsPage page() {
        return getPage(MealsPage.class);
    }
}
