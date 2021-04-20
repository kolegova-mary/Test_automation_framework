package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.AddUsersPopUp;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

public class AddUsersPopUpSteps extends BaseSteps {
    @When("admin types '([^']+)' as name" +
            " and '([^']+)' as email " +
            " and '([^']+)' as password" +
            " and hits Save")
    public void addUser(String name, String email, String password) {
        tryAddUser(name, email, password);
    }

    @When("admin types in some random value for '([^']+)' to add user")
    public void typeInto(String fieldName) {
        switch (fieldName.toUpperCase()) {
            case "NAME":
                typeInLoginname(generateRandomName());
                break;
            case "EMAIL":
                typeInEmail(generateRandomEmail());
                break;
            case "PASSWORD":
                typeInPassword(generateRandomPassword());
                break;
            default:
                throw new IllegalArgumentException("Unsupported AddUser.feature page field name: " + fieldName);
        }
    }

    @When("admin clicks cancel adding user")
    public void toCancel() {
        page().bToCancel.click();
    }

    @When("admin clicks save user")
    public void toSaveUser() {
        page().bToSaveUser.click();
    }

    public void tryAddUser(String name, String email, String password) {
        page().name.clear();
        page().name.sendKeys(name);

        page().email.clear();
        page().email.sendKeys(email);

        page().password.clear();
        page().password.sendKeys(password);

        page().bToSaveUser.click();
    }

    public void typeInLoginname(String value) {
        typeIn(value, page().name);
    }

    public void typeInEmail(String value) {
        typeIn(value, page().email);
    }

    public void typeInPassword(String value) {
        typeIn(value, page().password);
    }

    private void typeIn(String value, WebElement targetElement) {
        targetElement.clear();
        targetElement.sendKeys(value);
    }

    public AddUsersPopUp page() {
        return getPage(AddUsersPopUp.class);
    }
}
