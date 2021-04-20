package com.griddynamics.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {

    @FindBy(xpath = "//input[contains(@type,\"text\")]")
    public WebElement txtLoginname;

    @FindBy(xpath = "//input[contains(@type,\"password\")]")
    public WebElement txtPassword;

    @FindBy(xpath = "//button[contains(@class,\"btn\")]")
    public WebElement btoSubmitLogin;

    @FindBy(xpath = "//a[contains(@href,\"profile\")]")
    public WebElement bToRegistration;

    @FindBy(xpath = "//button[contains(text(),\"Login as User\")]")
    public WebElement bToLoginAsUser;

    @FindBy(xpath = "//button[contains(text(),\"Login as Admin\")]")
    public WebElement bToLoginAsAdmin;

    @FindBy(xpath = "//div[contains(@class,\"error\")]")
    public WebElement lblError;

    @FindBy(xpath = "//div[contains(@class,\"message\")]")
    public WebElement tSuccessMessageRegistering;


}
