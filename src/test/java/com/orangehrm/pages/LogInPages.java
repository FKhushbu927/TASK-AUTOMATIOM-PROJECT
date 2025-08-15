package com.orangehrm.pages;

import com.orangehrm.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class LogInPages extends BaseTest {

    //with addidn pageFactory

    //userNmae field

   // @FindBy(xpath = "//input[@placeholder='Username']")
    @FindBy(name = "username")
    @CacheLookup
    WebElement userNameField;

    @FindBy(name = "password")
    @CacheLookup
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    @CacheLookup
    WebElement loginBtn;


    @FindBy(xpath= "//div/p[contains(text(),'Invalid credentials')]")
    WebElement errorMessageEl;

    public LogInPages() {
        PageFactory.initElements(driver, this);
    }

    public DashBoardPage login(String username, String password) {
        userNameField.clear();
        userNameField.sendKeys(username);

        passwordField.clear();
        passwordField.sendKeys(password);
        scrollToElementAndClick(loginBtn);

        return new DashBoardPage();
    }

    public void loginFail(String username, String password) {
        userNameField.clear();
        userNameField.sendKeys(username);

        passwordField.clear();
        passwordField.sendKeys(password);
        scrollToElementAndClick(loginBtn);

    }

    public void loginFail(String username) {
        userNameField.isDisplayed();
        userNameField.clear();
        userNameField.sendKeys(username);
        scrollToElementAndClick(loginBtn);
    }


    public void loginFail() {
        loginBtn.isDisplayed();
        scrollToElementAndClick(loginBtn);
    }

    public boolean hasErrorMessage() {
        return errorMessageEl.isDisplayed();
    }

}
