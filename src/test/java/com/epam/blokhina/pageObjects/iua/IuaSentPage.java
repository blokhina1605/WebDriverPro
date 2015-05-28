package com.epam.blokhina.pageObjects.iua;

import com.epam.blokhina.pageObjects.abstractRealization.LoginPage;
import com.epam.blokhina.pageObjects.abstractRealization.SentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Yevheniia_Blokhina on 5/27/2015.
 */
public class IuaSentPage extends SentPage {
    public IuaSentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="form[name='aform'] > div.row")
    private WebElement letterInSent;

    @FindBy(css="span.icon-ho.ho_settings")
    private WebElement dropdownMenu;

    @FindBy(xpath = "//ul[@class='ho_popup_menu']/li[7]/a")
    private WebElement logOutButton;

    @Override
    public boolean isLetterInSentPresent() {
        if (letterInSent.isDisplayed()) return true;
        return false;
    }

    @Override
    public LoginPage logOut() {
        dropdownMenu.click();
        logOutButton.click();
        return new IuaLoginPage(driver);
    }
}
