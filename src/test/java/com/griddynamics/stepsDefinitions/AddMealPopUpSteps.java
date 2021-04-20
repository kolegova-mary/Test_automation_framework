package com.griddynamics.stepsDefinitions;

import com.griddynamics.pageObjects.AddMealPopUp;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;


public class AddMealPopUpSteps extends BaseSteps {
    @When("user types '([^']+)' as Date/Time" +
            " and '([^']+)' as description " +
            " and '([^']+)' as calories" +
            " and hits Save")
    public void addMeal(String date, String description, String calories) {
        tryAddMeal(date, description, calories);
    }

    @When("user types in some random value for '([^']+)' to add meal")
    public void typeInto(String fieldName) {
        switch (fieldName.toUpperCase()) {
            case "DATE/TIME":
                typeInDate(generateDateString());
            case "DESCRIPTION":
                typeInDescription(generateRandomDescription());
                break;
            case "CALORIES":
                typeInCalories(generateRandomCalories());
                break;
            default:
                throw new IllegalArgumentException("Unsupported AddMeal.feature page field name: " + fieldName);
        }
    }

    @When("user clicks cancel adding meal")
    public void toCancel() {
        page().bToCancel.click();
    }

    @When("user clicks save meal")
    public void toSaveMeal() {
        page().bToSaveMeal.click();
    }

    public void tryAddMeal(String date, String description, String calories) {
        page().txtDate.clear();
        page().txtDate.sendKeys(date);

        page().txtDescription.clear();
        page().txtDescription.sendKeys(description);

        page().txtCalories.clear();
        page().txtCalories.sendKeys(calories);

        page().bToSaveMeal.click();
    }

    public void typeInDate(String value) {
        typeIn(value, page().txtDate);
    }

    public void typeInDescription(String value) {
        typeIn(value, page().txtDescription);
    }

    public void typeInCalories(String value) {
        typeIn(value, page().txtCalories);
    }

    private void typeIn(String value, WebElement targetElement) {
        targetElement.clear();
        targetElement.sendKeys(value);
    }

    public AddMealPopUp page() {
        return getPage(AddMealPopUp.class);
    }

}
