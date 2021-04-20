package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.AddMealPopUp;
import cucumber.api.java.en.When;


public class AddMealPopUpSteps extends BaseSteps{

    @When("user types in some random value for '([^']+)' to add meal")
    public void typeInto(String fieldName) {
        switch (fieldName.toUpperCase()){
            case "DATE/TIME":
                page().typeInDate(generateDateString());
            case "DESCRIPTION":
                page().typeInDescription(generateRandomDescription());
                break;
            case "CALORIES":
                page().typeInCalories(generateRandomCalories());
                break;
            default:
                throw new IllegalArgumentException("Unsupported AddMeal.feature page field name: " + fieldName);
        }
    }

    @When("user clicks cancel adding meal")
    public void toCancel(){
        page().toCancel();
    }

    @When("user clicks save meal")
    public void toSaveMeal(){
        page().toSaveMeal();
    }

    public AddMealPopUp page() {
        return getPage(AddMealPopUp.class);
    }

}
