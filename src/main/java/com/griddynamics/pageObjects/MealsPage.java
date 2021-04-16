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

    public void toAddMeal(){
        bToAddMeal.click();
    }

    public void toUsers() {
        bToUsers.click();
    }
}
