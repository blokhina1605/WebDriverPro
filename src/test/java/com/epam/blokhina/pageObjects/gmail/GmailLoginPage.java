package com.epam.blokhina.pageObjects.gmail;

import com.epam.blokhina.pageObjects.abstractRealization.MainPage;
import org.openqa.selenium.WebDriver;

import com.epam.blokhina.pageObjects.abstractRealization.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yevheniia on 24.05.2015.
 */
public class GmailLoginPage extends LoginPage {
    public GmailLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id='Passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signIn']")
    private WebElement loginButton;

    @FindBy(name = "signIn")
    private WebElement nextButton;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement hiMessage;

    @Override
    public MainPage login(String login, String password) {
        loginField.sendKeys(login);
        nextButton.click();
        passwordField.sendKeys(password);
        loginButton.click();
        return new GmailMainPage(driver);
    }

    @Override
    public boolean isLogOutMade() {

        if (hiMessage.isDisplayed()) return true;
        return false;
    }
}
