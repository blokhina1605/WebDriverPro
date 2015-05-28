package com.epam.blokhina.pageObjects.gmail;

import com.epam.blokhina.MailConstans;
import com.epam.blokhina.pageObjects.abstractRealization.LoginPage;
import com.epam.blokhina.pageObjects.abstractRealization.SentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Yevheniia_Blokhina on 5/27/2015.
 */
public class GmailSentPage extends SentPage {
    public GmailSentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[3]/div/a")
    private WebElement preLogOutButton;
    @FindBy(xpath = "//a[contains(@href, 'logout')]")
    private WebElement logOutButton;

    @FindBy(xpath = "//tr//span[text()='" + MailConstans.EMAIL_SUBJECT + "']")
    private WebElement letterInSent;

    //    @FindBy()
//    private WebElement letterInSen;
    @Override
    public boolean isLetterInSentPresent() {

        if (letterInSent.isDisplayed()) return true;
        return false;
    }

    @Override
    public LoginPage logOut() {
        preLogOutButton.click();
        logOutButton.click();
        return new GmailLoginPage(driver);
    }
}
