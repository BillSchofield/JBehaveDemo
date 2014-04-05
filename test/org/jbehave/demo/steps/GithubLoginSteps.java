package org.jbehave.demo.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.demo.pages.LandingPage;
import org.jbehave.demo.pages.LoginPage;

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

    public GithubLoginSteps(LandingPage landingPage, LoginPage loginPage) {
        this.landingPage = landingPage;
        this.loginPage = loginPage;
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
}
