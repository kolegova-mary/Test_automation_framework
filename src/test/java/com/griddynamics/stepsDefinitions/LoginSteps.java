package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Login functionality related steps.
 */
public class LoginSteps extends BaseSteps {

    @Given("user opens Login page")
    public void openLoginPage() throws Throwable {
        getDriver().get(getData().loginPageUrl());
    }

    @When("user types '([^']+)' as loginname and '([^']+)' as password and hits Submit")
    public void login(String username, String password) {
        page().login(username, password);
    }

    @When("user clicks on Registration")
    public void registration() {
        page().toRegistration();
    }

    @Then("user goes to Restration page")
    public void userOnRegistrationPage() {
        assertCurrentPageUrl(getData().registrationPageUrl(), "No registration");
    }

    @When("User clicks Login as User")
    public void mealsForUser() {
        page().toLoginAsUser();
    }

    @Then("user goes to Meals page")
    public void userOnMealsPage() {
        assertCurrentPageUrl(getData().mealsPageUrl(), "No meals for user");
    }

    @When("User clicks Login as Admin")
    public void mealsForAdmin() {
        page().toLoginAsAdmin();
    }

    @Then("admin goes to Meals page")
    public void adminOnMealsPage() {
        assertCurrentPageUrl(getData().mealsPageUrl(), "No meals for admin");
    }

    public LoginPage page() {
        return getPage(LoginPage.class);
    }
}