package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class LoginSteps extends BaseSteps {
    private static String SUCCESSFUL_REGISTRATION_MESSAGE_PREFIX = "You are registered. Please Sign in. ";

    @When("user types '([^']+)' as email and '([^']+)' as password and hits Submit")
    public void login(String email, String password) {
        page().login(email, password);
    }

    @When("user clicks on Registration")
    public void registration() {
        page().toRegistration();
    }

    @When("user clicks Login as User")
    public void mealsForUser() {
        page().toLoginAsUser();
    }

    @When("user clicks Login as Admin")
    public void mealsForAdmin() {
        page().toLoginAsAdmin();
    }

    @Then("login error message is displayed")
    public void verifyErrorMessage() {
        getWait().until(ExpectedConditions.visibilityOf(page().getErrorWebElement()));
        String errorMessage = page().getErrorMessage();
        assertEquals("Bad credentials", errorMessage);
    }

    @Then("Successful registration message is displayed")
    public void verifySuccessfulRegistrationMessageIsDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(page().getMessageWebElementSuccessRegister()));
        assertThat(page().getMessageSuccessRegister().trim())
                .as("Successful registration message was nor shown or had unexpected content.")
                .startsWith(SUCCESSFUL_REGISTRATION_MESSAGE_PREFIX);
    }

    public LoginPage page() {
        return getPage(LoginPage.class);
    }
}