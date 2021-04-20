package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.AddMealPopUp;
import com.griddynamics.pageObjects.AddUsersPopUp;
import com.griddynamics.pageObjects.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddUsersPopUpSteps extends BaseSteps{
    private String loginnameUsed;

    @When("admin types in some random value for '([^']+)' to add user")
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
                throw new IllegalArgumentException("Unsupported AddUser.feature page field name: " + fieldName);
        }
    }

    @When("admin clicks cancel adding user")
    public void toCancel(){
        page().toCancel();
    }

    @When("admin clicks save user")
    public void toSaveUser(){
        page().toSaveUser();
    }

    public AddUsersPopUp page() {
        return getPage(AddUsersPopUp.class);
    }
}
