package com.saucedemo.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void clickInButton(WebElement webElement){
        getWait().until(ExpectedConditions.visibilityOf(webElement));
        getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();

    }

    public void addTextToInput(WebElement webElement, String keysToSend){
        getWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
        webElement.sendKeys(keysToSend);

    }

    public String getTextFromWebElement(WebElement webElement){
        getWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }
}
