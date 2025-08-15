package com.orangehrm.base;

import com.orangehrm.util.GeneralUtil;
import com.orangehrm.util.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    protected static WebDriver driver;
    protected Properties properties;

    protected EventFiringWebDriver e_driver;
    protected WebEventListener eventListener;


    public BaseTest() {
        try {
            String filePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Error loading config.properties file", e);
        }
    }
    public void initialization() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GeneralUtil.IMPLICIT_WAIT));

        driver.get(properties.getProperty("baseUrl"));
    }

    public String getUsername() {
        return properties.getProperty("username").trim();
    }

    public String getPassword() {
        return properties.getProperty("password").trim();
    }


    public void scrollToElementAndClick(WebElement webElement) {
        webElement.isDisplayed();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", webElement);
        GeneralUtil.waitForDomStable();
        webElement.click();

    }
}
