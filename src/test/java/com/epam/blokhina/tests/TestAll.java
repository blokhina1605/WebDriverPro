package com.epam.blokhina.tests;

import com.epam.blokhina.MailConstans;
import com.epam.blokhina.WebDriverFactory;
import com.epam.blokhina.pageObjects.abstractRealization.*;
import com.epam.blokhina.servFactory.ServFactory;
import com.epam.blokhina.servFactory.services.GmailFactory;
import com.epam.blokhina.servFactory.services.IuaFactory;
import com.epam.blokhina.servFactory.services.YandexFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class TestAll {
    private WebDriver driver;
    private ServFactory service;
    LoginPage loginPage;
    MainPage mainPage;
    DraftsPage draftsPage;
    CreateLetterPage createLetter;
    SentPage sentPage;

    public void addImplicitly() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        service = ServFactory.getFactory();
        driver = WebDriverFactory.init();
        //WebDriverFactory.init();
        driver.get(ServFactory.getProperties());
        synchronized (driver) {
            driver.wait(5000);
        }
        addImplicitly();
    }

    @Test(description = "sign in")
    public void login() {
        loginPage = service.getLoginPage(driver);
        mainPage = loginPage.login(MailConstans.LOGIN, MailConstans.PASSWORD);
        assertTrue(mainPage.isMailTabPresent());
    }

    @Test(description = "creating new letter and assert that letter in drafts is present", dependsOnMethods = "login")
    public void createNewLetter() throws InterruptedException {
        createLetter = mainPage.createNewLetter();
        createLetter.fillInTheLetter(MailConstans.RECIPIENT, MailConstans.EMAIL_SUBJECT, MailConstans.CONTENT_OF_EMAIL);
        draftsPage = createLetter.saveToDrafts();
        assertTrue(draftsPage.isEMailpresent(MailConstans.RECIPIENT));
    }

    @Test(description = "assert that information matches entered one`s", dependsOnMethods = "createNewLetter")
    public void verifyTheInformationEntered() throws InterruptedException {
        createLetter = draftsPage.openLetter();
        assertTrue(createLetter.isRecipient(MailConstans.RECIPIENT));
        // assertTrue(createLetter.isEmailSubject(MailConstans.EMAIL_SUBJECT));
        // assertTrue(createLetter.isContentOfEmail(MailConstans.CONTENT_OF_EMAIL));
    }

    @Test(dependsOnMethods = "verifyTheInformationEntered")
    public void sendLetter() {
        createLetter.sendLetter();
        assertTrue(createLetter.isLetterSent());
    }

    @Test(dependsOnMethods = "sendLetter")
    public void verifyTheLetterInDraftsDisappeared() {
        draftsPage = createLetter.goToDrafts();
        assertFalse(draftsPage.isEMailpresent(MailConstans.RECIPIENT));
    }

    @Test(dependsOnMethods = "verifyTheLetterInDraftsDisappeared")
    public void verifyTheLetterInSentIsPresent() {
        sentPage = draftsPage.goToSentPage();
        assertTrue(sentPage.isLetterInSentPresent());
    }

    @Test(dependsOnMethods = "verifyTheLetterInSentIsPresent")
    public void logOut() {
        loginPage = sentPage.logOut();
        assertTrue(loginPage.isLogOutMade());
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();

    }
}
