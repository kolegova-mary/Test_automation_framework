package com.griddynamics.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUsersPopUp {

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[contains(@class,\"btn-secondary\")]")
    public WebElement bToCancel;

    @FindBy(xpath = "//button[contains(@onclick,'save')]")
    public WebElement bToSaveUser;
}
