package com.griddynamics.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {

    @FindBy(xpath = "//input[contains(@type,\"text\")]")
    private WebElement txtLoginname;

    @FindBy(xpath = "//input[contains(@type,\"password\")]")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[contains(@class,\"btn\")]")
    private WebElement btoSubmitLogin;

    @FindBy(xpath = "//a[contains(@href,\"profile\")]")
    private WebElement bToRegistration;

    @FindBy(xpath = "//button[contains(text(),\"Login as User\")]")
    private WebElement bToLoginAsUser;

    @FindBy(xpath = "//button[contains(text(),\"Login as Admin\")]")
    private WebElement bToLoginAsAdmin;

    @FindBy(xpath = "//div[contains(@class,\"error\")]")
    private WebElement lblError;

    @FindBy(xpath = "//div[contains(@class,\"message\")]")
    private WebElement tSuccessMessageRegistering;

    public MealsPage login(String email, String password) {
        tryLogin(email, password);
        return new MealsPage();
    }

    public void tryLogin(String username, String password) {
        txtLoginname.clear();
        txtLoginname.sendKeys(username);

        txtPassword.clear();
        txtPassword.sendKeys(password);

        btoSubmitLogin.click();
    }

    public String getMessageSuccessRegister() {
        return tSuccessMessageRegistering.getText();
    }

    public WebElement getMessageWebElementSuccessRegister() {
        return tSuccessMessageRegistering;
    }

    public String getErrorMessage() {
        return lblError.getText();
    }

    public WebElement getErrorWebElement() {
        return lblError;
    }

    public void toRegistration() {
        bToRegistration.click();
    }

    public void toLoginAsUser() {
        bToLoginAsUser.click();
    }

    public void toLoginAsAdmin() {
        bToLoginAsAdmin.click();
    }

}
