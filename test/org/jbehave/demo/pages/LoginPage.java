package org.jbehave.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private static final String url = "http://github.com/login";
    private static final By usernameFieldLocator = By.id("login_field");
    private static final By commitButtonLocator = By.name("commit");

    private static final By passwordFieldLocator = By.id("password");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void go() {
        driver.get(url);
    }

    public void login(String username, String password) {
        WebElement usernameField = usernameFieldLocator.findElement(driver);
        usernameField.sendKeys(username);

        WebElement passwordField = passwordFieldLocator.findElement(driver);
        passwordField.sendKeys(password);

        WebElement commitButton = commitButtonLocator.findElement(driver);
        commitButton.click();
    }
}
