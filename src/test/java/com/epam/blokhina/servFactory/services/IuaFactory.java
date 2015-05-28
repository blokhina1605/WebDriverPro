package com.epam.blokhina.servFactory.services;

import org.openqa.selenium.WebDriver;

import com.epam.blokhina.pageObjects.abstractRealization.LoginPage;
import com.epam.blokhina.pageObjects.iua.IuaLoginPage;
import com.epam.blokhina.servFactory.ServFactory;

/**
 * Created by yevheniia on 24.05.2015.
 */
public class IuaFactory extends ServFactory{
    public LoginPage getLoginPage(WebDriver driver) {
        return new IuaLoginPage(driver);
    }
}
