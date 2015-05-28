package com.epam.blokhina.servFactory.services;

import com.epam.blokhina.pageObjects.abstractRealization.MainPage;
import org.openqa.selenium.WebDriver;

import com.epam.blokhina.pageObjects.abstractRealization.LoginPage;
import com.epam.blokhina.pageObjects.gmail.GmailLoginPage;
import com.epam.blokhina.servFactory.ServFactory;

/**
 * Created by yevheniia on 24.05.2015.
 */
public class GmailFactory extends ServFactory{
    public LoginPage getLoginPage(WebDriver driver) {
        return new GmailLoginPage(driver);
    }
}
