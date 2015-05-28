package com.epam.blokhina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/**
 * Created by yevheniia on 24.05.2015.
 */
public class WebDriverFactory {
    private static WebDriver driver;



    public static String getProperties() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("D:\\IdeaProjects\\WebDriverBl\\src\\test\\resources\\configur.properties");
            property.load(fis);
            String type = property.getProperty("browser");
            return type;

        } catch (IOException e) {
            return "firefox";
        }
    }

    public static WebDriver init() throws IOException {
        switch (getProperties()) {
            case "chrome":
                // DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                System.setProperty("webdriver.chrome.driver", "E:\\IdeaProject\\WebDriverBl\\src\\test\\resources\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                //System.setProperty("webdriver.chrome.driver", "E:\\IdeaProject\\WebDriverBl\\src\\test\\resources\\drivers\\chromedriver.exe");
                driver = new FirefoxDriver();
                break;
            case "opera":
                System.setProperty("webdriver.opera.driver", "E:\\IdeaProject\\WebDriverBl\\src\\test\\resources\\drivers\\operadriver64.exe");
                driver = new OperaDriver();
                break;
            case "ie":
                System.setProperty("webdriver.opera.driver", "E:\\IdeaProject\\WebDriverBl\\src\\test\\resources\\drivers\\IEDriverServer64.exe");
                driver = new InternetExplorerDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
