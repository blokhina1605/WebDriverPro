package com.epam.blokhina.pageObjects.yandex;

import com.epam.blokhina.pageObjects.abstractRealization.CreateLetterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.blokhina.pageObjects.abstractRealization.MainPage;

/**
 * Created by yevheniia on 24.05.2015.
 */
public class YandexMainPage extends MainPage {

    @FindBy(xpath = "//a[contains(text(),'Почта')]")
    private WebElement mailTabOnMenu;


    @FindBy(xpath = "//div[2]/div/div/div/div[2]/a[2]")
    private WebElement writeButton;


    public YandexMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isMailTabPresent() {
        return mailTabOnMenu.isDisplayed();
    }

    @Override
    public CreateLetterPage createNewLetter() {
        writeButton.click();
        return new YandexCreateLetterPage(driver);
    }
}
