package com.griddynamics.stepsDefinitions;

import cucumber.api.java.en.Given;

public class OpenPagesSteps extends BaseSteps {
    @Given("open Login page")
    public void openLoginPage() {
        getDriver().get(getData().loginPageUrl());
    }
}
