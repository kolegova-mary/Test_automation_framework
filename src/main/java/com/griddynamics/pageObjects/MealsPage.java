package com.griddynamics.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class MealsPage {

    @FindBy(xpath = "//button[contains(@onclick,\"add\")]")
    private WebElement bToAddMeal;

    @FindBy(xpath = "//div[contains(@class,\"modal-content\")]")
    private AddMealPopUp addMealPopUp;

    @FindBy(xpath = "//a[contains(@href,\"users\")]")
    private WebElement bToUsers;

    @FindBy(xpath = "//div[contains(@class,\"noty_body\")]")
    private WebElement tWrongAddMeal;

    @FindBy(xpath = "//table/tbody/tr/td[last()-4]")
    private WebElement txtDateMeal;

    @FindBy(xpath = "//table/tbody/tr/td[last()-3]")
    private WebElement txtDescriptionMeal;

    @FindBy(xpath = "//table/tbody/tr/td[last()-2]")
    private WebElement txtCaloriesMeal;

    public boolean isWrongMeal(){
        return tWrongAddMeal.isDisplayed();
    }

    public void toAddMeal(){
        bToAddMeal.click();
    }

    public void toUsers() {
        bToUsers.click();
    }
}
