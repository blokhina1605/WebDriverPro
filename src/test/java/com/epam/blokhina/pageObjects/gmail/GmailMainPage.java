package com.epam.blokhina.pageObjects.gmail;

import com.epam.blokhina.pageObjects.abstractRealization.CreateLetterPage;
import com.epam.blokhina.pageObjects.abstractRealization.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Yevheniia_Blokhina on 5/27/2015.
 */
public class GmailMainPage extends MainPage {
    public GmailMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[3]/div/a")
    private WebElement mailTab;

    @FindBy(xpath = "//div[@class='z0']/div")
    private WebElement createLetterButton;

    @Override
    public boolean isMailTabPresent() {
        if (mailTab.isDisplayed()) return true;
        return false;
    }

    @Override
    public CreateLetterPage createNewLetter() {
        createLetterButton.click();
        return new GmailCreateLetterPage(driver);
    }
}
