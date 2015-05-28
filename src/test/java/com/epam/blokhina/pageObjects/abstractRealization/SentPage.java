package com.epam.blokhina.pageObjects.abstractRealization;

import org.openqa.selenium.WebDriver;

import com.epam.blokhina.pageObjects.AbstractPage;

/**
 * Created by yevheniia on 24.05.2015.
 */
public abstract class SentPage extends AbstractPage {
    public SentPage(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLetterInSentPresent();

    public abstract LoginPage logOut();
}
