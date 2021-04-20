package com.griddynamics.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersForAdminPage {
    @FindBy(xpath = "//button[contains(@onclick,\"add\")]")
    public WebElement bToAddUsers;

    @FindBy(xpath = "//div[contains(@class,\"modal-content\")]")
    public AddUsersPopUp addUsersPopUp;

    @FindBy(xpath = "//div[contains(@class,\"noty_body\")]")
    public WebElement isWrongUser;
}
