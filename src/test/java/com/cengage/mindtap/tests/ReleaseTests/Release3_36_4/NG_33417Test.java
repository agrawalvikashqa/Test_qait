/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.ReleaseTests.Release3_36_4;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author QAI
 */
public class NG_33417Test {
TestSessionInitiator test;
    String user, bookName;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Create And Launch Master Next Book And Verify LPN");
        user = System.getProperty("user", "admin");
        bookName = getData("Books.master.masterSSO");
        test.launchApplication(getData("base_url"));
    }

    @Test
    public void TestStep_01_LoginToMindTapApplication() {
        test.adminLoginPage.loginToMindTapApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")));
        test.masterPage.verifyuserIsOnMastersPage();
        Reporter.log(user + " successfully logs in to the application", true);
    }
    @Test
    public void TestStep_02_SearchCreatedMaster() {
    test.masterPage.enterBookNameAndSearch(bookName);
    test.masterPage.clickOnPushToSnapshotButton();
    Assert.assertTrue(test.masterPage.verifyP2SWindow());
    Reporter.log("P2S Window is displayed successfully", true);
    Reporter.log("Update Content is displayed successfully", true);
    Reporter.log("Update Content and Annotations is displayed successfully", true);
    test.masterPage.closePushToSnapshotWindow();
    Reporter.log("P2S Button is working as expected", true);
    
    }
     @Test
    public void TestStep_03_LogOutFromMindTapApplication() {
        test.masterPage.logOutFromMasterPage();
        Reporter.log(user + " successfully log out from application");
    }

    @AfterClass(alwaysRun = true)
    public void stop_test_session() {
        test.closeTestSession();
    }

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
}    
