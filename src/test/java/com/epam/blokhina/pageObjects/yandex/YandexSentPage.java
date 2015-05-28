package com.epam.blokhina.pageObjects.yandex;

import com.epam.blokhina.pageObjects.abstractRealization.LoginPage;
import com.epam.blokhina.pageObjects.abstractRealization.SentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Yevheniia_Blokhina on 5/25/2015.
 */
public class YandexSentPage extends SentPage {
    public YandexSentPage(WebDriver driver) {
        super(driver);
    }


//div[2]/div[2]/div/div/span[2]/span/a/span[2]
    @FindBy(xpath = "//div[@class='b-messages']/div[@class='b-messages__message']")
    private WebElement letterInSent;

    @FindBy(id = "nb-1")
    private WebElement profileButton;

    @FindBy(xpath = "//div[@id='user-dropdown-popup']/div/div/div[9]/a")
    private WebElement exitButton;

    @Override
    public boolean isLetterInSentPresent() {
        if (letterInSent != null && letterInSent.isDisplayed()) return true;
        return false;
    }

    @Override
    public LoginPage logOut() {
        profileButton.click();
        exitButton.click();
        return new YandexLoginPage(driver);
    }
}
