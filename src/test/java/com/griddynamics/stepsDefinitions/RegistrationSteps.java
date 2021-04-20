package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.RegistrationPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

/**
 * Registration.feature functionality related steps.
 */
public class RegistrationSteps extends BaseSteps {

    private String loginnameUsed;

    @When("user types in some random value for '([^']+)' to register")
    public void typeInto(String fieldName) {
        switch (fieldName.toUpperCase()) {
            case "NAME":
                this.loginnameUsed = generateRandomName();
                page().typeInLoginName(loginnameUsed);
                break;
            case "EMAIL":
                page().typeInEmail(generateRandomEmail());
                break;
            case "PASSWORD":
                page().typeInPassword(generateRandomPassword());
                break;
            case "DAILY CALORIE LIMIT":
                page().typeInCaloriesPerDay(generateRandomCaloriesPerDay());
                break;
            default:
                throw new IllegalArgumentException("Unsupported Registration.feature page field name: " + fieldName);
        }
    }

    @When("user clicks Save user")
    public void toSaveUser() {
        page().toSave();
    }

    @When("user clicks cancel registrating")
    public void toCancelRegistering() {
        page().toCancel();
    }

    @Then("name is in wrong format")
    public void toDisplayWrongName() {
        assertTrue(page().isWrongName());
    }

    @Then("email is in wrong format")
    public void toDisplayWrongEmail() {
        assertTrue(page().isWrongEmail());
    }

    @Then("password is in wrong format")
    public void toDisplayWrongPassword() {
        assertTrue(page().isWrongPassword());

    }

    @Then("daily calories is in wrong format")
    public void toDisplayWrongDailyCalories() {
        assertTrue(page().isWrongCaloriesPerDay());
    }

    private RegistrationPage page() {
        return getPage(RegistrationPage.class);
    }


}