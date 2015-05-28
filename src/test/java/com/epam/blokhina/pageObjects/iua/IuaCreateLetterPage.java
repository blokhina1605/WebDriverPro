package com.epam.blokhina.pageObjects.iua;

import com.epam.blokhina.pageObjects.abstractRealization.CreateLetterPage;
import com.epam.blokhina.pageObjects.abstractRealization.DraftsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Yevheniia_Blokhina on 5/27/2015.
 */
public class IuaCreateLetterPage extends CreateLetterPage {
    public IuaCreateLetterPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "to")
    private WebElement recipientField;

    @FindBy(name = "subject")
    private WebElement subjectField;

    @FindBy(id = "text")
    private WebElement textField;

    @FindBy(xpath = "//ul[@class='list_underlined']//li[3]//a")
    private WebElement goToDrafts;

    @FindBy(xpath = "(//input[@name='save_in_drafts'])[3]")
    private WebElement saveToDraftsButton;

    @FindBy(css = "div.content.clear")
    private WebElement successMessage;

    @FindBy(xpath = "(//input[@name='send'])[3]")
    private WebElement sendLetterButton;

    @Override
    public void fillInTheLetter(String recipient, String emailSubject, String contentOfEmail) throws InterruptedException {
        recipientField.sendKeys(recipient);
        subjectField.sendKeys(emailSubject);
        textField.sendKeys(contentOfEmail);
    }

    @Override
    public DraftsPage saveToDrafts() throws InterruptedException {
        saveToDraftsButton.click();
        goToDrafts.click();
        return new IuaDraftsPage(driver);
    }

    @Override
    public void sendLetter() {
        sendLetterButton.click();
    }

    @Override
    public boolean isLetterSent() {
        if (successMessage.isDisplayed()) return true;
        return false;
    }

    @Override
    public DraftsPage goToDrafts() {
        goToDrafts.click();
        return new IuaDraftsPage(driver);
    }

    @Override
    public boolean isRecipient(String recipient) {
        if (recipientField.getText().equals(recipient)) return true;
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
