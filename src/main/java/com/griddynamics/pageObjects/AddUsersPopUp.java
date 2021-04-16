package com.griddynamics.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUsersPopUp {

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id="email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[contains(@class,\"btn-secondary\")]")
    private WebElement bToCancel;

    @FindBy(xpath = "//button[contains(@onclick,'save')]")
    private WebElement bToSaveUser;

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
        bToSaveUser.click();
    }
}
