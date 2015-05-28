package com.epam.blokhina.pageObjects.iua;

import com.epam.blokhina.pageObjects.abstractRealization.CreateLetterPage;
import com.epam.blokhina.pageObjects.abstractRealization.DraftsPage;
import com.epam.blokhina.pageObjects.abstractRealization.SentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Yevheniia_Blokhina on 5/27/2015.
 */
public class IuaDraftsPage extends DraftsPage {
    public IuaDraftsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a/span[2]")
    private WebElement goToLetterInDrafts;

    @FindBy(xpath = "//ul[@class='list_underlined']//li[2]//a")
    private WebElement goToSentPage;

    @Override
    public boolean isEMailpresent(String s) {
        boolean flag = false;
        try {
            if(driver.findElement(By.xpath("//form/div")).getText().contains(s))
                flag = true;
        } catch (NoSuchElementException ex) {

        }
        return flag;
    }

    @Override
    public CreateLetterPage openLetter() throws InterruptedException {
        goToLetterInDrafts.click();
        return new IuaCreateLetterPage(driver);
    }

    @Override
    public SentPage goToSentPage() {
        goToSentPage.click();
        return new IuaSentPage(driver);
    }
}
