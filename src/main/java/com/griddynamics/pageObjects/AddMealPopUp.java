package com.griddynamics.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddMealPopUp {
    @FindBy(xpath = "//input[contains(@name,\"dateTime\")]")
    public WebElement txtDate;

    @FindBy(xpath = "//input[contains(@name,\"description\")]")
    public WebElement txtDescription;

    @FindBy(xpath = "//input[contains(@id,\"calories\")]")
    public WebElement txtCalories;

    @FindBy(xpath = "//button[contains(@onclick,\"save\")]")
    public WebElement bToSaveMeal;

    @FindBy(xpath = "//button[contains(@class,\"btn-secondary\")]")
    public WebElement bToCancel;
}
