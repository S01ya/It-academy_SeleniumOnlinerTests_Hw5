package com.it_academy.onliner.pageobject;

import com.it_academy.onliner.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import static com.it_academy.onliner.framework.DriverManager.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class BasePage {

    public BasePage() {
        DriverManager.setDriver();
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver>wait = new WebDriverWait(getDriver(), 60);
        return wait.until(visibilityOfElementLocated(by));
    }

    public WebElement waitForElementToBeClickable(By by) {
        Wait<WebDriver>wait = new WebDriverWait(getDriver(), 60);
        return wait.until(elementToBeClickable(by));
    }

    public List<WebElement> waitForElementsVisible(By by) {
        Wait<WebDriver>wait = new WebDriverWait(getDriver(), 60);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
}
