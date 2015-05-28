package com.epam.blokhina.pageObjects.gmail;

import com.epam.blokhina.MailConstans;
import com.epam.blokhina.pageObjects.abstractRealization.CreateLetterPage;
import com.epam.blokhina.pageObjects.abstractRealization.DraftsPage;
import com.epam.blokhina.pageObjects.abstractRealization.SentPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Yevheniia_Blokhina on 5/27/2015.
 */
public class GmailDraftsPage extends DraftsPage {
    public GmailDraftsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='" + MailConstans.EMAIL_SUBJECT + "']")
    private WebElement letterInDrafts;

@FindBy(xpath = "//div[@class='block-app']//a[contains(@href, 'sent')] | //div[3]/div/div/div/span/a")
private WebElement goToSentPageButton;

    @Override
    public boolean isEMailpresent(String s) {
        try {

            if (letterInDrafts.isDisplayed()) return true;
        }
        catch (NoSuchElementException ex){
        }
        return false;
    }

    @Override
    public CreateLetterPage openLetter() throws InterruptedException {
        letterInDrafts.click();
        return new GmailCreateLetterPage(driver);
    }

    @Override
    public SentPage goToSentPage() {
        goToSentPageButton.click();
        return new GmailSentPage(driver);
    }
}
