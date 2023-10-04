package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessageContainer;

    @FindBy(xpath = "//button[@class='error-button']")
    private WebElement errorMessageContainerCloseButton;

    public void clickInLoginButton(){
        clickInButton(loginButton);
    }

    public String getTextFromErrorContainer(){
        return getTextFromWebElement(errorMessageContainer);
    }

    public void setPasswordInput(String password){
        addTextToInput(passwordInput, password);
    }

    public void setUsernameInput(String username){
        addTextToInput(usernameInput, username);
    }
}
