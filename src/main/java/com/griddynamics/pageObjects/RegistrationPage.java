package com.griddynamics.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object of Vikta's Registration page
 */
public class RegistrationPage {
    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//a[contains(@class,\"btn-secondary\")]")
    private WebElement bToCancel;

    @FindBy(xpath = "//button[contains(@class,'btn-primary')]")
    private WebElement bToSave;

    public void typeInLoginname(String value) {
        typeIn(value, name);
    }

    public void typeInEmail(String value) {
        typeIn(value, email);
    }

    public void typeInPassword(String value) {
        typeIn(value, password);
    }

    private void typeIn(String value, WebElement targetElement) {
        targetElement.clear();
        targetElement.sendKeys(value);
    }

    public void toLCancel() {
        bToCancel.click();
    }

    public void toSave() {
        bToSave.click();
    }

}
