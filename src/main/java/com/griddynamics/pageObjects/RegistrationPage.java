package com.griddynamics.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage {
    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//input[contains(@name,\"caloriesPerDay\")]")
    public WebElement caloriesPerDay;

    @FindBy(xpath = "//a[contains(@class,\"btn-secondary\")]")
    public WebElement bToCancel;

    @FindBy(xpath = "//button[contains(@class,'btn-primary')]")
    public WebElement bToSave;

    @FindBy(xpath = "//div[contains(text(),\"[Email]\")]")
    public WebElement tWrongEmail;

    @FindBy(xpath = "//div[contains(text(),\"[Name]\")]")
    public WebElement tWrongName;

    @FindBy(xpath = "//div[contains(text(),\"[Password]\")]")
    public WebElement tWrongPassword;

    @FindBy(xpath = "//div[contains(text(),\"[Daily calorie limit]\")]")
    public WebElement tWrongDailyCalories;
}
