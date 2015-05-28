package com.epam.blokhina.pageObjects.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.epam.blokhina.pageObjects.abstractRealization.LoginPage;
import com.epam.blokhina.pageObjects.abstractRealization.MainPage;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by yevheniia on 24.05.2015.
 */
public class YandexLoginPage extends LoginPage {
    public YandexLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "login")
    private WebElement loginInput;

    @FindBy(name = "passwd")
    private WebElement passwordInput;

    @FindBy(xpath = "//div/button")
    private WebElement loginButton;


    @Override
    public MainPage login(String login, String password) {
        loginInput.clear();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);

        loginButton.click();
        return new YandexMainPage(driver);
    }

    @Override
    public boolean isLogOutMade() {
        if (loginButton.isDisplayed()) return true;
        return false;

    }
}
