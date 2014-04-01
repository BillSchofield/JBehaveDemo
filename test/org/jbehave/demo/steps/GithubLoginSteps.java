package org.jbehave.demo.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.demo.pages.LandingPage;
import org.jbehave.demo.pages.LoginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GithubLoginSteps {
    public static final String defaultUsername = "jbehavetest";
    public static final String defaultPassword = "jbehavetest1";
    private LandingPage landingPage;
    private LoginPage loginPage;
    private String username="";
    private String password="";
    private final List<Integer> actualResults;
    private Integer startingApples=0;
    private Integer moreApples=0;

    public GithubLoginSteps(LandingPage landingPage, LoginPage loginPage) {
        this.landingPage = landingPage;
        this.loginPage = loginPage;
        actualResults = new ArrayList<Integer>();
    }

    @Given("I have created an account")
    public void setUsernameAndPassword(){
        username = defaultUsername;
        password = defaultPassword;

    }

    @When("I login to GitHub")
    public void login() {
        landingPage.go();
        landingPage.login();
        loginPage.login(username, password);
    }

    @Then("I am logged in")
    public void verifyCorrectUserIsLoggedIn() {
        final String loggedInUser = landingPage.loggedInUser();
        assertThat(loggedInUser, is(username));
    }

    @Then("I can create new repositories")
    public void verifyUserCanCreateRepo() {
        assertTrue(landingPage.canCreateRepository());
    }

    @When("I add these numbers:$numbers")
    public void addNumbers(ExamplesTable numbers){
        for (Map<String, String> row : numbers.getRows()) {
            final int x = Integer.parseInt(row.get("x"));
            final int y = Integer.parseInt(row.get("y"));
            actualResults.add(x + y);
        }
    }

    @Then("I get these numbers:$numbers")
    public void verifyResultsOfAddition(ExamplesTable numbers){
        List<Integer> expectedResults = new ArrayList<Integer>();
        for (Map<String, String> row : numbers.getRows()) {
            expectedResults.add(Integer.parseInt(row.get("result")));
        }
        assertThat(actualResults, is(expectedResults));
    }

    @Given("<startingApples> apples")
    public void startingApples(@Named("startingApples") Integer startingApples){
        this.startingApples = startingApples;
    }

    @When("I buy <moreApples> more apples")
    public void buyApples(@Named("moreApples") Integer moreApples){
        this.moreApples = moreApples;
    }

    @Then("I have <totalApples> apples")
    public void verifyAppleTotal(@Named("totalApples") Integer totalApples){
        assertThat(startingApples + moreApples, is(totalApples));
    }
}
