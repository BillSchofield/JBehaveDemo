package org.jbehave.demo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Float.parseFloat;

public class VacationBalancePage {
    private static final String url = "http://localhost:8080/";
    private static final By startDateLocator = By.id("startdate_field");
    private static final By submitButtonLocator = By.id("submit_button");
    private static final By balanceLocator = By.id("vacationDays");

    WebDriver driver;

    public VacationBalancePage(WebDriver driver) {
        this.driver = driver;
    }

    public void go() {
        driver.get(url);
    }

    public void startDate(String date) {
        WebElement startDate = startDateLocator.findElement(driver);
        startDate.sendKeys(date);
    }

    public void submit() {
        WebElement submitButton = submitButtonLocator.findElement(driver);
        submitButton.click();
    }

    public float balance() {
        // Wow this is ugly!
        WebElement balanceElement = balanceLocator.findElement(driver);
        String text = balanceElement.getText();
        String[] tokens = text.split(" ");
        String balanceString = tokens[4];
        return parseFloat(balanceString);
    }
}
