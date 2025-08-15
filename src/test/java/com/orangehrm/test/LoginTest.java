package com.orangehrm.test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LogInPages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LogInPages loginPages;

    public LoginTest(){
        super();
    }

    @BeforeMethod
    public void init() {
        initialization();
        loginPages = new LogInPages();
    }


    @Test(priority = 0)
    public void loginShouldFail() {
        loginPages.loginFail("khushbu", "dsrfg");
        Assert.assertTrue(loginPages.hasErrorMessage());
    }
}
