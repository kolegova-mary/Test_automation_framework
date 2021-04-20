package com.griddynamics.stepsDefinitions;

import com.griddynamics.tests.Hooks;
import com.griddynamics.config.DataProvider;
import com.griddynamics.config.TestDataAndProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Base class to contain common auxiliary methods for step definitions.
 */
abstract class BaseSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;

    protected WebDriver getDriver() {
        return Hooks.driver;
    }

    protected WebDriverWait getWait() {
        if (Objects.isNull(this.wait)) {
            this.wait = new WebDriverWait(driver, getData().waitTimeout());
        }

        return wait;
    }

    protected TestDataAndProperties getData() {
        return DataProvider.get();
    }

    protected <P> P getPage(Class<P> pageClass) {
        return PageFactory.initElements(driver, pageClass);
    }

    protected void assertCurrentPageUrl(String expectedUrl, String messageOnFail) {
        assertThat(getDriver().getCurrentUrl())
                .as(messageOnFail)
                .contains(expectedUrl);
    }


    protected String generateRandomString(int max, int min) {
        String candidate = UUID.randomUUID().toString().replaceAll("\\d", "A");
        if (candidate.length() < min) {
            throw new IllegalArgumentException("Size must be bigger");
        } else {
            if (candidate.length() > max) {
                return candidate.substring(0, max);
            } else {
                return candidate;
            }
        }
    }

    protected String generateDateString() {
        long rangebegin = Timestamp.valueOf("2013-02-08 00:00").getTime();
        long rangeend = Timestamp.valueOf("2013-02-08 00:58").getTime();
        long diff = rangeend - rangebegin + 1;
        Timestamp rand = new Timestamp(rangebegin + (long) (Math.random() * diff));
        return rand.toString();
    }

    protected String generateRandomDescription() {
        String candidate = UUID.randomUUID().toString();
        return generateRandomString(120, 2);
    }

    protected String generateRandomCalories() {
        Integer cur = (int) (Math.random() * 4991) + 10;
        return cur.toString();
    }

    protected String generateRandomCaloriesPerDay() {
        Integer cur = (int) (Math.random() * 9991) + 10;
        return cur.toString();
    }

    protected String generateRandomEmail() {
        String candidate = UUID.randomUUID().toString();
        if (candidate.matches("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$"))
            return candidate;
        else {
            throw new IllegalArgumentException("Wrong email format.");
        }
    }

    protected String generateRandomName() {
        return generateRandomString(100, 2);
    }

    protected String generateRandomPassword() {
        return generateRandomString(32, 5);
    }
}
