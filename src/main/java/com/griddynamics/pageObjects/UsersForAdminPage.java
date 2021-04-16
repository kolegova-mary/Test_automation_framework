package com.griddynamics.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersForAdminPage {
    @FindBy(xpath = "//button[contains(@onclick,\"add\")]")
    private WebElement bToAddUsers;

    @FindBy(xpath = "//div[contains(@class,\"modal-content\")]")
    private AddUsersPopUp addUsersPopUp;

    public void toAddUser(){
        bToAddUsers.click();
    }
}
