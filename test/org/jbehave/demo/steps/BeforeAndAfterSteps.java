package org.jbehave.demo.steps;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeScenario;
import org.openqa.selenium.WebDriver;

public class BeforeAndAfterSteps {

    private WebDriver driver;
    private VacationBalancePage vacationBalancePage;

    public BeforeAndAfterSteps(WebDriver driver, VacationBalancePage vacationBalancePage) {
        this.driver = driver;
        this.vacationBalancePage = vacationBalancePage;
    }

    @BeforeScenario
    public void goToVacationBalancePage(){
        vacationBalancePage.go();
    }

    @AfterStories
    @AfterScenario(uponOutcome = AfterScenario.Outcome.FAILURE)
    public void quitBrowser() {
        driver.quit();
    }
}
