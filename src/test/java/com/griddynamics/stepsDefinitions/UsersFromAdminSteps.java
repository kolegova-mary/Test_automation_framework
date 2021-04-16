package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.AddUsersPopUp;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersFromAdminSteps extends BaseSteps{
    private String loginnameUsed;

    @Given("admin clicks Login as Admin")
    public void openMealsPage(){getDriver().get(getData().mealsPageUrl());}

    @Given("admin clicks Users button")
    public void openUsersFromAdminPage(){getDriver().get(getData().usersFromAdminPageUrl());}

//    @Given("admin clicks Add")


    @When("admin types in some random value for '([^']+)'")
    public void typeInto(String fieldName) {
        switch (fieldName.toUpperCase()){
            case "NAME":
                this.loginnameUsed = generateRandomName();
                page().typeInLoginname(loginnameUsed);
                break;
            case "EMAIL":
                page().typeInEmail(generateRandomEmail());
                break;
            case "PASSWORD":
                page().typeInPassword(generateRandomPassword());
                break;
            //TODO: Add the rest... .
            default:
                throw new IllegalArgumentException("Unsupported Registration.feature page field name: " + fieldName);
        }
    }

    //TODO: Add rest of the steps needed.

    @Then("UsersFromAdmin page the current one")
    public void verifyCurrentPageIsUsers() {
        assertCurrentPageUrl(getData().usersFromAdminPageUrl(), "users page was expected to be the current one.");
    }

    //TODO: Think about generics etc instead of this.
    private AddUsersPopUp page() {
        return getPage(AddUsersPopUp.class);
    }
}
