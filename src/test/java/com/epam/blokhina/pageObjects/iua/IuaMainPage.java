package com.epam.blokhina.pageObjects.iua;

import com.epam.blokhina.pageObjects.abstractRealization.CreateLetterPage;
import com.epam.blokhina.pageObjects.abstractRealization.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Yevheniia_Blokhina on 5/27/2015.
 */
public class IuaMainPage extends MainPage {
    public IuaMainPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//p/a")
    private WebElement createLetterButton;

    @FindBy(css = "span.sn_menu_title")
    private WebElement mailTab;
    @Override
    public boolean isMailTabPresent() {
        if (mailTab.isDisplayed()) return true;
        return false;
    }

    @Override
    public CreateLetterPage createNewLetter() {
        createLetterButton.click();
        return new IuaCreateLetterPage(driver);
    }
}
