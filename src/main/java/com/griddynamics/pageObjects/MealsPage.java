package com.griddynamics.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MealsPage{

    @FindBy(xpath = "//button[contains(@onclick,\"add\")]")
    public WebElement bToAddMeal;

    @FindBy(xpath = "//div[contains(@class,\"modal-content\")]")
    public AddMealPopUp addMealPopUp;

    @FindBy(xpath = "//a[contains(@href,\"users\")]")
    public WebElement bToUsers;

    @FindBy(xpath = "//div[contains(@class,\"noty_body\")]")
    public WebElement tWrongAddMeal;

    @FindBy(xpath = "//table/tbody/tr/td[last()-4]")
    public WebElement txtDateMeal;

    @FindBy(xpath = "//table/tbody/tr/td[last()-3]")
    public WebElement txtDescriptionMeal;

    @FindBy(xpath = "//table/tbody/tr/td[last()-2]")
    public WebElement txtCaloriesMeal;
}
