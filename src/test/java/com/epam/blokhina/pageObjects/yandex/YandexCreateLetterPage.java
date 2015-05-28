package com.epam.blokhina.pageObjects.yandex;

import com.epam.blokhina.pageObjects.abstractRealization.CreateLetterPage;
import com.epam.blokhina.pageObjects.abstractRealization.DraftsPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Yevheniia_Blokhina on 5/25/2015.
 */
public class YandexCreateLetterPage extends CreateLetterPage {

    @FindBy(xpath = "//*[@class='b-yabble b-yabble_focused']/descendant-or-self::input")
    private WebElement recipientField;

    @FindBy(id = "compose-subj")
    private WebElement emailSubjectField;

    @FindBy(xpath = "//textarea[@id='compose-send']")
    private WebElement contentOfMailField;

    @FindBy(xpath = "//a[contains(@href, '#draft')]")
    private WebElement draftsTab;

    @FindBy(xpath = "//div[6]/div/button")
    private WebElement prevButton;
    //td/div[4]/button

    @FindBy(xpath = "//td/div[4]/button")
    private WebElement saveInDraftButton;

    @FindBy(xpath = "//*[@id='js-page']/div/div[5]/div/div[3]/div/div[3]/div/div/div/div[2]/div/div/form/table/tbody/tr[3]/td[2]/div[2]/div/div[1]/span[1]/span[2]")
    private WebElement recipientFieldForSent;

    @FindBy(xpath = "//textarea[@id='compose-send']")
    private WebElement getContentOfMailFieldForSent;

    @FindBy(xpath = ".//*[@id='compose-submit']")
    private WebElement sendButton;

    @FindBy(xpath = ".//*[@id='js-page']/div/div[5]/div/div[3]/div/div[3]/div/div/div/div[3]/div/div/div[1]")
    private WebElement sentMessage;

    public YandexCreateLetterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void fillInTheLetter(String recipient, String emailSubject, String contentOfEmail) throws InterruptedException {
        recipientField.sendKeys(recipient);
        emailSubjectField.sendKeys(emailSubject + Keys.TAB + contentOfEmail);
    }

    @Override
    public DraftsPage saveToDrafts() throws InterruptedException {
        prevButton.click();
        synchronized (driver) {
            driver.wait(2000);
        }
        saveInDraftButton.click();
        synchronized (driver) {
            driver.wait(2000);
        }
        draftsTab.click();
        return new YandexDraftsPage(driver);
    }


    //    @Override
//    public boolean verifyTheInformation(String recipient, String emailSubject, String contentOfEmail) {
//        if (isRecipient(recipient) && isEmailSubject(emailSubject) && isContentOfEmail(contentOfEmail)) return true;
//        return false;
//    }
    @Override
    public boolean isContentOfEmail(String contentOfEmail) {
        System.out.println(getContentOfMailFieldForSent.getText());
        if (getContentOfMailFieldForSent.getText().equals(contentOfEmail)) return true;
        return false;
    }

    @Override
    public boolean isEmailSubject(String emailSubject) {
        System.out.println(emailSubjectField.getText());
        if (emailSubjectField.getText().trim().equals(emailSubject)) return true;
        return false;
    }

    @Override
    public boolean isRecipient(String recipient) {
        if (recipientFieldForSent.getText().trim().equals(recipient.trim())) return true;
        return false;
    }

    @Override
    public void sendLetter() {
        sendButton.click();
    }

    @Override
    public boolean isLetterSent() {
        if (sentMessage.isDisplayed()) return true;
        return false;
    }

    @Override
    public DraftsPage goToDrafts() {
        draftsTab.click();
        return new YandexDraftsPage(driver);
    }

    private void getModalWindow() {

    }
}
