package com.orangehrm.pages;

import com.orangehrm.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyLeavePage extends BaseTest {

    @FindBy(linkText = "Leave")
    WebElement LeaveLinkEl;


    @FindBy(xpath = "//div//h6[text()='Apply Leave']")
    WebElement applyLeaveEl;

//    public ApplyLeavePage(){
//        Object PageFactory = null;
//        PageFactory.initElements(driver.this);
//    }


    public ApplyLeavePage() {
        PageFactory.initElements(driver, this);
    }

    public void applyLeaveShouldVisible() {
        LeaveLinkEl.isDisplayed();
        scrollToElementAndClick(LeaveLinkEl);
    }

    public boolean hasApplyLeaveText() {
        return applyLeaveEl.isDisplayed();
    }
}
