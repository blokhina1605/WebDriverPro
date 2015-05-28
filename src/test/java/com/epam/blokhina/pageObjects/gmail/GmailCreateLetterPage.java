package com.epam.blokhina.pageObjects.gmail;

import com.epam.blokhina.MailConstans;
import com.epam.blokhina.pageObjects.abstractRealization.CreateLetterPage;
import com.epam.blokhina.pageObjects.abstractRealization.DraftsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Yevheniia_Blokhina on 5/27/2015.
 */
public class GmailCreateLetterPage extends CreateLetterPage {
    public GmailCreateLetterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement recipientField;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement contentField;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement subjectField;

    @FindBy(xpath = "//tr/td/img[3]")
    private WebElement saveToDrafts;

    @FindBy(xpath = "//tbody//div[count(div) = 2]/div[@role='button' and @data-tooltip]")
    private WebElement sendButton;

    @FindBy(xpath = "//span[@id='link_vsm'] | //div[2]/div[3]/div/div/div[2]")
    private WebElement sentMessage;

    @FindBy(xpath = "//a[contains(@href, 'https://mail.google.com/mail/#drafts')] | //div[4]/div/div/div/span/a | //a[contains(text(),'Черновики')]")
    private WebElement goToDraftsButton;

@FindBy(xpath = "//div[2]/div[6] | //div/div/table/tbody/tr/td[2]/div[2]/div")
private WebElement contentInDrafts;

    @FindBy(xpath = "//td[2]//span/div")
    private WebElement recipientInDrafts;


    @Override
    public void fillInTheLetter(String recipient, String emailSubject, String contentOfEmail) throws InterruptedException {
        recipientField.sendKeys(recipient);
        subjectField.sendKeys(emailSubject);
        contentField.sendKeys(contentOfEmail);
    }

    @Override
    public DraftsPage saveToDrafts() throws InterruptedException {
        saveToDrafts.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(goToDraftsButton));

        goToDraftsButton.click();
        return new GmailDraftsPage(driver);
    }

    @Override
    public void sendLetter() {
        sendButton.click();
    }

    @Override
    public boolean isLetterSent() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(sentMessage));
        if (sentMessage.isDisplayed()) return true;
        return false;
    }

    @Override
    public DraftsPage goToDrafts() {
        goToDraftsButton.click();
        return new GmailDraftsPage(driver);
    }

    @Override
    public boolean isRecipient(String recipient) {
        System.out.println(contentInDrafts.getText());
        if (contentInDrafts.getText().contains(MailConstans.CONTENT_OF_EMAIL)) return true;
        return false;
    }

    @Override
    public boolean isEmailSubject(String emailSubject) {
        return false;
    }

    @Override
    public boolean isContentOfEmail(String contentOfEmail) {
        return false;
    }
}
