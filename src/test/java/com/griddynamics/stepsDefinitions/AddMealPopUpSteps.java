package com.griddynamics.stepsDefinitions;

import cucumber.api.java.en.When;


public class AddMealPopUpSteps extends BaseSteps{
    @When("user types in some random value for '([^']+)'")
    public void typeInto(String fieldName) {
        switch (fieldName.toUpperCase()){
            case "DATE/TIME":
                page().typeInData();
            case "DESCRIPTION":
                page().typeInDescription(generateRandomDescription());
                break;
            case "CALORIES":
                page().typeInCalories(generateRandomCalories());
                break;
            default:
                throw new IllegalArgumentException("Unsupported Registration.feature page field name: " + fieldName);
        }
    }
}
