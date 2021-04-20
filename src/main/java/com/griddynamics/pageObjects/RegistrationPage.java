package com.griddynamics.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage {
    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//input[contains(@name,\"caloriesPerDay\")]")
    private WebElement caloriesPerDay;

    @FindBy(xpath = "//a[contains(@class,\"btn-secondary\")]")
    private WebElement bToCancel;

    @FindBy(xpath = "//button[contains(@class,'btn-primary')]")
    private WebElement bToSave;

    @FindBy(xpath = "//div[contains(text(),\"User with this email\")]")
    private WebElement tExistsEmail;

    @FindBy(xpath = "//div[contains(text(),\"Invalid format of [Email]\")]")
    private WebElement tWrongEmail;

    @FindBy(xpath = "//div[contains(text(),\"[Name]\")]")
    private WebElement tWrongName;

    @FindBy(xpath = "//div[contains(text(),\"[Password]\")]")
    private WebElement tWrongPassword;

    @FindBy(xpath = "//div[contains(text(),\"[Daily calorie limit]\")]")
    private WebElement tWrongDailyCalories;

    public void typeInLoginName(String value) {
        typeIn(value, name);
    }

    public void typeInEmail(String value) {
        typeIn(value, email);
    }

    public void typeInPassword(String value) {
        typeIn(value, password);
    }

    public void typeInCaloriesPerDay(String value) {
        typeIn(value, caloriesPerDay);
    }

    private void typeIn(String value, WebElement targetElement) {
        targetElement.clear();
        targetElement.sendKeys(value);
    }

    public boolean isWrongEmail(){
        return tWrongEmail.isDisplayed();
    }

    public boolean isWrongName(){
        return tWrongName.isDisplayed();
    }

    public boolean isWrongPassword(){
        return tWrongPassword.isDisplayed();
    }

    public boolean isWrongCaloriesPerDay(){
        return tWrongDailyCalories.isDisplayed();
    }

    public void toCancel() {
        bToCancel.click();
    }

    public void toSave() {
        bToSave.click();
    }

}
