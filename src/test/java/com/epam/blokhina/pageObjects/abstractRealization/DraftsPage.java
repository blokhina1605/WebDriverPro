package com.epam.blokhina.pageObjects.abstractRealization;

import org.openqa.selenium.WebDriver;

import com.epam.blokhina.pageObjects.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yevheniia on 24.05.2015.
 */
public abstract class DraftsPage extends AbstractPage {
    public DraftsPage(WebDriver driver) {
        super(driver);
    }



    public abstract boolean isEMailpresent(String s);

    public abstract CreateLetterPage openLetter() throws InterruptedException;

    public abstract SentPage goToSentPage();
}
