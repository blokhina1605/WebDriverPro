package com.epam.blokhina.tests;

import com.epam.blokhina.servFactory.ServFactory;
import com.epam.blokhina.servFactory.services.GmailFactory;
import com.epam.blokhina.servFactory.services.IuaFactory;
import com.epam.blokhina.servFactory.services.YandexFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestSuite {

    @DataProvider(name = "provider1")
    public Object[][] createData1() {
        return new Object[][]{
                {"", new GmailFactory()},
                {"", new IuaFactory()},
                {"", new YandexFactory()}
        };
    }


    @Test(dataProvider = "provider1")
    public void verifyData1(String a, ServFactory n1) {
        System.out.println(n1 + " ");
    }


}
