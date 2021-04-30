package com.griddynamics.tests;

import com.griddynamics.config.DataProvider;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

;


/**
 * com.griddynamics.tests.Hooks are blocks of code that can run at various points in the Cucumber execution cycle.
 * They are typically used for setup and teardown of the environment before and after each scenario.
 */
public class Hooks {
    public static final String USERNAME = "Kolegova_Mary";
    public static final String ACCESS_KEY = "072db102-ac52-401d-acc9-9f9896bcd9cb";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    public static WebDriver driver;

    @Before
    public void doBefore() throws MalformedURLException {
        driver = createSauceLabsDriver();
        driver.manage().timeouts().implicitlyWait(DataProvider.get().implicitlyWait(), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(DataProvider.get().pageLoadTimeout(), TimeUnit.SECONDS);
    }

    @After
    public void doAfter() {
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && Objects.nonNull(driver)) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        if (Objects.nonNull(driver)) {
            driver.quit();
        }
    }

    private WebDriver createSauceLabsDriver() throws MalformedURLException {
        // SOme details:  https://github.com/bonigarcia/webdrivermanager/
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "latest");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

        driver.get("http://topjava.herokuapp.com/login");
        System.out.println("title of page is: " + driver.getTitle());

        return driver;
    }
}