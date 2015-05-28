package com.epam.blokhina.pageObjects.iua;

import org.openqa.selenium.WebDriver;

import com.epam.blokhina.pageObjects.abstractRealization.LoginPage;
import com.epam.blokhina.pageObjects.abstractRealization.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by yevheniia on 24.05.2015.
 */
public class IuaLoginPage extends LoginPage {
    public IuaLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "pass")
    private WebElement passwordField;

    @FindBy(xpath = "//form/p/input")
    private WebElement loginButton;


    @Override
    public MainPage login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
        return new IuaMainPage(driver);
    }

    @Override
    public boolean isLogOutMade() {
        new WebDriverWait(driver, 10, 10000).until(ExpectedConditions.visibilityOf(loginButton));
        if (loginButton.isDisplayed()) return true;
        return false;
    }
}
