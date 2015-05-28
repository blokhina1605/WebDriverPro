package com.epam.blokhina.servFactory;

import org.openqa.selenium.WebDriver;

import com.epam.blokhina.pageObjects.abstractRealization.LoginPage;
import com.epam.blokhina.pageObjects.gmail.GmailLoginPage;
import com.epam.blokhina.pageObjects.iua.IuaLoginPage;
import com.epam.blokhina.pageObjects.yandex.YandexLoginPage;
import com.epam.blokhina.servFactory.services.GmailFactory;
import com.epam.blokhina.servFactory.services.IuaFactory;
import com.epam.blokhina.servFactory.services.YandexFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by yevheniia on 24.05.2015.
 */
public abstract class ServFactory {

//    static ResourceBundle resourceBundle = ResourceBundle.getBundle("D:\\IdeaProjects\\WebDriverBl\\src\\test\\resources\\configur.properties");
//    static String type = resourceBundle.getString("webService");


    public static String getProperties() {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("D:\\IdeaProjects\\WebDriverBl\\src\\test\\resources\\configur.properties");
            property.load(fis);
            String type = property.getProperty("webService");
            return type;

        } catch (IOException e) {
            return "http://www.yandex.ua/";
        }

    }



    public static ServFactory getFactory() {
        switch (getProperties()) {
            case "http://www.i.ua/":
                return new IuaFactory();
            case "http://www.yandex.ua/":
                return new YandexFactory();
            case "https://www.gmail.com/":
                return new GmailFactory();
            default:
                return null;
        }
    }

    public String getService() {
        return getProperties();
    }

    public abstract LoginPage getLoginPage(WebDriver driver);
}

