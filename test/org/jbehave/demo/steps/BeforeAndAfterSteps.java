package org.jbehave.demo.steps;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.demo.pages.LandingPage;
import org.openqa.selenium.WebDriver;

public class BeforeAndAfterSteps {

    private WebDriver driver;
    private LandingPage landingPage;

    public BeforeAndAfterSteps(WebDriver driver, LandingPage landingPage) {
        this.driver = driver;
        this.landingPage = landingPage;
    }

    @AfterStories
    public void quitBrowser() {
        driver.quit();
    }
}
