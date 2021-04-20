package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.MealsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class MealsSteps extends BaseSteps {

    @When("user clicks add meal")
    public void addMealForUser() {
        toAddMeal();
    }

    @When("admin clicks users")
    public void toUsersPage() {
        toUsers();
    }

    @Then("meal is in wrong format")
    public void toDisplayWrongMeal() {
        getWait().until(ExpectedConditions.visibilityOf(page().tWrongAddMeal));
        assertTrue(page().tWrongAddMeal.isDisplayed());
    }

    public void toAddMeal() {
        page().bToAddMeal.click();
    }

    public void toUsers() {
        page().bToUsers.click();
    }

    private MealsPage page() {
        return getPage(MealsPage.class);
    }
}
