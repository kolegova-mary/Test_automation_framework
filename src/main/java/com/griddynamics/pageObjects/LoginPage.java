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

    public MealsPage login(String username, String password) {
        tryLogin(username, password);
        return new MealsPage();
    }

    public void tryLogin(String username, String password) {
        txtLoginname.clear();
        txtLoginname.sendKeys(username);

        txtPassword.clear();
        txtPassword.sendKeys(password);

        btoSubmitLogin.click();
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
