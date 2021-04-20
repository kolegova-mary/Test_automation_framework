package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.RegistrationPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

/**
 * Registration.feature functionality related steps.
 */
public class RegistrationSteps extends BaseSteps {
    @When("user types '([^']+)' as name" +
            " and '([^']+)' as email " +
            " and '([^']+)' as password " +
            " and '([^']+)' as daily calorie limit" +
            " and hits Save")
    public void register(String name, String email, String password, String calories) {
        tryRegister(name, email, password, calories);
    }

    @When("user types in some random value for '([^']+)' to register")
    public void typeInto(String fieldName) {
        switch (fieldName.toUpperCase()) {
            case "NAME":
                typeInLoginName(generateRandomName());
                break;
            case "EMAIL":
                typeInEmail(generateRandomEmail());
                break;
            case "PASSWORD":
                typeInPassword(generateRandomPassword());
                break;
            case "DAILY CALORIE LIMIT":
                typeInCaloriesPerDay(generateRandomCaloriesPerDay());
                break;
            default:
                throw new IllegalArgumentException("Unsupported Registration.feature page field name: " + fieldName);
        }
    }

    @When("user clicks Save user")
    public void toSaveUser() {
        page().bToSave.click();
    }

    @When("user clicks cancel registrating")
    public void toCancelRegistering() {
        page().bToCancel.click();
    }

    @Then("name is in wrong format")
    public void toDisplayWrongName() {
        assertTrue(page().tWrongName.isDisplayed());
    }

    @Then("email is in wrong format")
    public void toDisplayWrongEmail() {
        assertTrue(page().tWrongEmail.isDisplayed());
    }

    @Then("password is in wrong format")
    public void toDisplayWrongPassword() {
        assertTrue(page().tWrongPassword.isDisplayed());

    }

    @Then("daily calories is in wrong format")
    public void toDisplayWrongDailyCalories() {
        assertTrue(page().tWrongDailyCalories.isDisplayed());
    }

    public void tryRegister(String name, String email, String password, String calories) {
        page().name.clear();
        page().name.sendKeys(name);

        page().email.clear();
        page().email.sendKeys(email);

        page().password.clear();
        page().password.sendKeys(password);

        page().caloriesPerDay.clear();
        page().caloriesPerDay.sendKeys(calories);

        page().bToSave.click();
    }

    public void typeInLoginName(String value) {
        typeIn(value, page().name);
    }

    public void typeInEmail(String value) {
        typeIn(value, page().email);
    }

    public void typeInPassword(String value) {
        typeIn(value, page().password);
    }

    public void typeInCaloriesPerDay(String value) {
        typeIn(value, page().caloriesPerDay);
    }

    private void typeIn(String value, WebElement targetElement) {
        targetElement.clear();
        targetElement.sendKeys(value);
    }

    private RegistrationPage page() {
        return getPage(RegistrationPage.class);
    }
}