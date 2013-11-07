package org.jbehave.demo.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VacationBalanceSteps {
    private VacationBalancePage vacationBalancePage;

    public VacationBalanceSteps(VacationBalancePage vacationBalancePage) {
        this.vacationBalancePage = vacationBalancePage;
    }

    @Given("I have a start date of '$date'")
    public void enterStartDate(String date) {
        vacationBalancePage.startDate(date);
    }

    @When("I ask for my vacation balance")
    public void submitForm() {
        vacationBalancePage.submit();
    }

    @Then("I learn that my balance is '$balance'")
    public void verifyTermResults(float expectedBalance) {
        float actualBalance = vacationBalancePage.balance();
        assertThat(actualBalance, is(equalTo(expectedBalance)));
    }
}
