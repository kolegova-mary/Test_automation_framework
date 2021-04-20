package com.griddynamics.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersForAdminPage {
    @FindBy(xpath = "//button[contains(@onclick,\"add\")]")
    private WebElement bToAddUsers;

    @FindBy(xpath = "//div[contains(@class,\"modal-content\")]")
    private AddUsersPopUp addUsersPopUp;

    @FindBy(xpath = "//div[contains(@class,\"noty_body\")]")
    private WebElement isWrongUser;

    public boolean isWrongUser(){
        return isWrongUser.isDisplayed();
    }

    public void toAddUser(){
        bToAddUsers.click();
    }

}
