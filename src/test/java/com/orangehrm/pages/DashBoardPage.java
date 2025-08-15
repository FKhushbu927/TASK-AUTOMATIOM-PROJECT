package com.orangehrm.pages;

import com.orangehrm.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends BaseTest {
    //div//span//h6[text()='Dashboard']

    @FindBy(xpath = "//div//span//h6[text()='Dashboard']")
    WebElement WellComeEle;

    //apply leave
    //div//h6[text()='Apply Leave']
    @FindBy(linkText = "Leave")
    WebElement LeaveLinkEl;

    @FindBy(xpath = "//div//h6[text()='Apply Leave']")
    WebElement applyLeaveEl;



    public DashBoardPage() {
        PageFactory.initElements(driver, this);
    }
  // check dashboard breadCm is visible or not
    public boolean hasWelcome() {
        return WellComeEle.getText().trim().contains("Dashboard");
    }


    // check applyLeave breadCm is visible or not
    public boolean hasLeaveBredCumb() {
        return applyLeaveEl.getText().trim().contains("Leave");
    }


    public ApplyLeavePage clickApplyLeavePage() {
        scrollToElementAndClick(LeaveLinkEl);
        return new ApplyLeavePage();
    }


}
