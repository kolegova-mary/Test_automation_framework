package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class LoginSteps extends BaseSteps {
    @When("user types '([^']+)' as email and '([^']+)' as password and hits Submit")
    public void login(String email, String password) {
        tryLogin(email, password);
    }

    @When("user clicks on Registration")
    public void registration() {
        toRegistration();
    }

    @When("user clicks Login as User")
    public void mealsForUser() {
        toLoginAsUser();
    }

    @When("user clicks Login as Admin")
    public void mealsForAdmin() {
        toLoginAsAdmin();
    }

    @Then("login error message is displayed")
    public void verifyErrorMessage() {
        getWait().until(ExpectedConditions.visibilityOf(page().lblError));
        assertEquals("Bad credentials", page().lblError.getText());
    }

    @Then("Successful registration message is displayed")
    public void verifySuccessfulRegistrationMessageIsDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(page().tSuccessMessageRegistering));
        assertEquals("You are registered. Please Sign in.", page().tSuccessMessageRegistering.getText());
    }

    public void tryLogin(String username, String password) {
        page().txtLoginname.clear();
        page().txtLoginname.sendKeys(username);

        page().txtPassword.clear();
        page().txtPassword.sendKeys(password);

        page().btoSubmitLogin.click();
    }

    public void toRegistration() {
        page().bToRegistration.click();
    }

    public void toLoginAsUser() {
        page().bToLoginAsUser.click();
    }

    public void toLoginAsAdmin() {
        page().bToLoginAsAdmin.click();
    }

    public LoginPage page() {
        return getPage(LoginPage.class);
    }
}