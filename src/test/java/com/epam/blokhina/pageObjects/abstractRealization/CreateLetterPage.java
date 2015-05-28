package com.epam.blokhina.pageObjects.abstractRealization;

import org.openqa.selenium.WebDriver;

import com.epam.blokhina.pageObjects.AbstractPage;

/**
 * Created by yevheniia on 24.05.2015.
 */
public abstract class CreateLetterPage extends AbstractPage {
    public CreateLetterPage(WebDriver driver) {
        super(driver);
    }

    public abstract void fillInTheLetter(String recipient, String emailSubject, String contentOfEmail) throws InterruptedException;

    public abstract DraftsPage saveToDrafts() throws InterruptedException;

    //public abstract boolean verifyTheInformation(String recipient, String emailSubject, String contentOfEmail);

    public abstract void sendLetter();

    public abstract boolean isLetterSent();

    public abstract DraftsPage goToDrafts();
    public abstract boolean isRecipient(String recipient);

    public abstract boolean isEmailSubject(String emailSubject);

    public abstract boolean isContentOfEmail(String contentOfEmail);
}
