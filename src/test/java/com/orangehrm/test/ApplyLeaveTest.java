package com.orangehrm.test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.ApplyLeavePage;
import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LogInPages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplyLeaveTest extends BaseTest {
    ApplyLeavePage applyLeavePage;
    DashBoardPage dashBoardPage;

    public ApplyLeaveTest(){
        super();
    }

    @BeforeMethod
    public void init() {
        initialization();
        applyLeavePage = new ApplyLeavePage();
    }

    @Test(priority = 0)
    public void applyLeaveShouldVisible() {
        applyLeavePage.applyLeaveShouldVisible();
        Assert.assertTrue(applyLeavePage.hasApplyLeaveText());
    }

}
