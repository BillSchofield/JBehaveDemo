package org.jbehave.demo.steps;

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

    @BeforeScenario
    public void goToVacationBalancePage(){
        landingPage.go();
    }

//    @AfterStories
//    @AfterScenario(uponOutcome = AfterScenario.Outcome.FAILURE)
//    public void quitBrowser() {
//        driver.quit();
//    }
}
