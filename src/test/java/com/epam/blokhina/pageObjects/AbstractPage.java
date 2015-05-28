package com.epam.blokhina.pageObjects;

import com.epam.blokhina.*;
import com.epam.blokhina.pageObjects.abstractRealization.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by yevheniia on 24.05.2015.
 */
public abstract class AbstractPage {
    protected WebDriver driver;
    protected PropertiesManager propertiesManager = new PropertiesManager();


    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public LoginPage navigateToWebApp() {
        driver.get(propertiesManager.getPropertyByName("siteBaseUrl"));
        return null;
        //return new com.epam.blokhina.pageObjects.abstractRealization.LoginPage(driver);
    }

    public String getCurentPageTitle() {
        return driver.getTitle();
    }

    public String getCurentPageUrl() {
        return driver.getCurrentUrl();
    }
}
