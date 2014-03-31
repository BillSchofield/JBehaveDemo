package org.jbehave.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Float.parseFloat;

public class LandingPage {
    private static final String url = "http://github.com/";
    private static final By loginButtonLocator = By.className("signin");
    private static final By userLinksLocator = By.id("user-links");

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void go() {
        driver.get(url);
    }

    public void login() {
        WebElement loginButton = loginButtonLocator.findElement(driver);
        loginButton.click();
    }

    public boolean canCreateRepository() {
        By createRepoButtonLocator = By.className("new-repo");
        WebElement createRepoButton = createRepoButtonLocator.findElement(driver);
        return createRepoButton != null;
    }

    public String loggedInUser() {
        WebElement userLinks = userLinksLocator.findElement(driver);
        final List<WebElement> links = userLinks.findElements(By.xpath("li"));
        return links.get(0).getText();
    }
}
