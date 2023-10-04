package com.saucedemo.tests;

import com.saucedemo.constantValues.ConstantUrls;
import com.saucedemo.constantValues.Credentials;
import com.saucedemo.constantValues.ErrorMessages;
import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedLoginTest extends BaseTest{

    @Test
    public void shouldCheckIfItIsPossibleToLoginWithoutCredentials() {
        // given
        driver.get(ConstantUrls.SAUCEDEMO_LOGIN_PAGE);
        LoginPage loginPage = new LoginPage(driver);

        // when

        loginPage.clickInLoginButton();

        // then

        Assert.assertEquals(driver.getCurrentUrl(), ConstantUrls.SAUCEDEMO_LOGIN_PAGE);
        Assert.assertEquals(loginPage.getTextFromErrorContainer(), ErrorMessages.REQUIRED_USERNAME);
    }

    @Test
    public void shouldCheckIfItIsPossibleToLoginWithoutUsername() {
        // given
        driver.get(ConstantUrls.SAUCEDEMO_LOGIN_PAGE);
        LoginPage loginPage = new LoginPage(driver);

        // when

        loginPage.setPasswordInput(Credentials.PASSWORD_ALL_USERS);
        loginPage.clickInLoginButton();

        // then

        Assert.assertEquals(driver.getCurrentUrl(), ConstantUrls.SAUCEDEMO_LOGIN_PAGE);
        Assert.assertEquals(loginPage.getTextFromErrorContainer(), ErrorMessages.REQUIRED_USERNAME);
    }

    @Test
    public void shouldCheckIfItIsPossibleToLoginWithoutPassword() {
        // given
        driver.get(ConstantUrls.SAUCEDEMO_LOGIN_PAGE);
        LoginPage loginPage = new LoginPage(driver);

        // when

        loginPage.setUsernameInput(Credentials.USERNAME_STANDARD);
        loginPage.clickInLoginButton();

        // then

        Assert.assertEquals(driver.getCurrentUrl(), ConstantUrls.SAUCEDEMO_LOGIN_PAGE);
        Assert.assertEquals(loginPage.getTextFromErrorContainer(), ErrorMessages.REQUIRED_PASSWORD);
    }

    @Test
    public void shouldCheckIfItIsPossibleToLoginWithWrongPassword() {
        // given
        driver.get(ConstantUrls.SAUCEDEMO_LOGIN_PAGE);
        LoginPage loginPage = new LoginPage(driver);

        // when

        loginPage.setUsernameInput(Credentials.USERNAME_STANDARD);
        loginPage.setPasswordInput("wrongPassword");
        loginPage.clickInLoginButton();

        // then

        Assert.assertEquals(driver.getCurrentUrl(), ConstantUrls.SAUCEDEMO_LOGIN_PAGE);
        Assert.assertEquals(loginPage.getTextFromErrorContainer(), ErrorMessages.WRONG_CREDENTIALS);
    }

    @Test
    public void shouldCheckIfItIsPossibleToLoginWithWrongUsername() {
        // given
        driver.get(ConstantUrls.SAUCEDEMO_LOGIN_PAGE);
        LoginPage loginPage = new LoginPage(driver);

        // when

        loginPage.setUsernameInput("wrongUsername");
        loginPage.setPasswordInput(Credentials.PASSWORD_ALL_USERS);
        loginPage.clickInLoginButton();

        // then

        Assert.assertEquals(driver.getCurrentUrl(), ConstantUrls.SAUCEDEMO_LOGIN_PAGE);
        Assert.assertEquals(loginPage.getTextFromErrorContainer(), ErrorMessages.WRONG_CREDENTIALS);
    }

    @Test
    public void shouldCheckIfItIsPossibleToLoginWithLockedOutUser() {
        // given
        driver.get(ConstantUrls.SAUCEDEMO_LOGIN_PAGE);
        LoginPage loginPage = new LoginPage(driver);

        // when

        loginPage.setUsernameInput(Credentials.USERNAME_LOCKED_OUT);
        loginPage.setPasswordInput(Credentials.PASSWORD_ALL_USERS);
        loginPage.clickInLoginButton();

        // then

        Assert.assertEquals(driver.getCurrentUrl(), ConstantUrls.SAUCEDEMO_LOGIN_PAGE);
        Assert.assertEquals(loginPage.getTextFromErrorContainer(), ErrorMessages.USER_LOCKED_OUT);
    }
}
