package com.epam.blokhina.pageObjects.yandex;

import com.epam.blokhina.pageObjects.abstractRealization.CreateLetterPage;
import com.epam.blokhina.pageObjects.abstractRealization.DraftsPage;
import com.epam.blokhina.pageObjects.abstractRealization.SentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Yevheniia_Blokhina on 5/25/2015.
 */
public class YandexDraftsPage extends DraftsPage {
    public YandexDraftsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[2]/div/div[2]/div[2]/div")
    private WebElement letterInDrafts;

    @FindBy(xpath = "//*[@id='js-page']/div/div[5]/div/div[3]/div/div[3]/div/div/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/span[2]/span/a/span[2]/span")
    private WebElement letterInDraftsForClick;

    @FindBy(xpath = "//div[2]/span[2]/a")
    private WebElement sentTab;


    @Override
    public boolean isEMailpresent(String s) {
        if (letterInDrafts.getText().contains(s)) {
            if (letterInDrafts != null && letterInDrafts.isEnabled()) return true;
        }
        return false;
    }

    @Override
    public CreateLetterPage openLetter() throws InterruptedException {
        synchronized (driver) {
            driver.wait(2000);
        }
        letterInDraftsForClick.click();
        return new YandexCreateLetterPage(driver);
    }

    @Override
    public SentPage goToSentPage() {
        sentTab.click();
        return new YandexSentPage(driver);
    }

}
