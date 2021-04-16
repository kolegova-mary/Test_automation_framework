package com.griddynamics.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddMealPopUp {
    @FindBy(xpath = "//input[contains(@name,\"dateTime\")]")
    private WebElement txtDate;

    @FindBy(xpath = "//input[contains(@name,\"description\")]")
    private WebElement txtDescription;

    @FindBy(xpath = "//input[contains(@id,\"calories\")]")
    private WebElement txtCalories;

    @FindBy(xpath = "//button[contains(@onclick,\"save\")]")
    private WebElement bToSaveMeal;

    @FindBy(xpath = "//button[contains(@class,\"btn-secondary\")]")
    private WebElement bToCancel;

    public void typeInDate(String value) {
        typeIn(value, txtDate);
    }
    public void typeInDescription(String value) {
        typeIn(value, txtDescription);
    }

    public void typeInCalories(String value) {
        typeIn(value, txtCalories);
    }

    private void typeIn(String value, WebElement targetElement) {
        targetElement.clear();
        targetElement.sendKeys(value);
    }

    public void toLCancel() {
        bToCancel.click();
    }

    public void toSaveMeal() {
        bToSaveMeal.click();
    }
}
