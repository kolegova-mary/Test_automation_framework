package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.RegistrationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Registration.feature functionality related steps.
 */
public class RegistrationSteps extends BaseSteps {
    private static String SUCCESSFUL_REGISTRATION_MESSAGE_PREFIX = "User has been registered successfully: ";

    private String loginnameUsed;

    @Given("user opens Registration page")
    public void openLoginPage() {
        getDriver().get(getData().registrationPageUrl());
    }

    @When("user types in some random value for '([^']+)'")
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
            default:
                throw new IllegalArgumentException("Unsupported Registration.feature page field name: " + fieldName);
        }
    }

    @Then("Successful registration message is displayed")
    public void verifySuccessfulRegistrationMessageIsDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(page().getMessageWebElement()));
        assertThat(page().getMessageText().trim())
                .as("Successful registration message was nor shown or had unexpected content.")
                .startsWith(SUCCESSFUL_REGISTRATION_MESSAGE_PREFIX);
    }

    private RegistrationPage page() {
        return getPage(RegistrationPage.class);
    }
}