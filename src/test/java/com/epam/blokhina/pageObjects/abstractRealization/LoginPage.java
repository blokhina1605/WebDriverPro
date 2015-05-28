package com.epam.blokhina.pageObjects.abstractRealization;

import com.epam.blokhina.pageObjects.AbstractPage;
import org.openqa.selenium.WebDriver;



/**
 * Created by yevheniia on 24.05.2015.
 */
public abstract class LoginPage extends AbstractPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public abstract MainPage login(String login, String password);

    public abstract boolean isLogOutMade();
}
