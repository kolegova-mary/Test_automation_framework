package com.griddynamics.stepsDefinitions;

import com.griddynamics.tests.Hooks;
import com.griddynamics.config.DataProvider;
import com.griddynamics.config.TestDataAndProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
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

    protected String generateRandomEmail() {
        String[] domens = new String[]{".ru", ".com"};
        return generateRandomString(64, 1) + "@" +
                generateRandomString(5, 1) + domens[(int) (Math.random() * domens.length)];

    }


    protected String generateDateString() {
        LocalDateTime rangeEnd = LocalDateTime.now().minusMinutes(1);
        LocalDateTime rangeStart = rangeEnd.minusYears(71);

        long diffInMillis = rangeEnd.toEpochSecond(ZoneOffset.UTC) - rangeStart.toEpochSecond(ZoneOffset.UTC);
        long resultInMillis = (long) (rangeStart.toEpochSecond(ZoneOffset.UTC) + Math.random() * diffInMillis);

        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(resultInMillis, 0, ZoneOffset.UTC);
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(localDateTime);
    }

    protected String generateRandomDescription() {
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

    protected String generateRandomName() {
        return generateRandomString(100, 2);
    }

    protected String generateRandomPassword() {
        return generateRandomString(32, 5);
    }
}
