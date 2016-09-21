/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.ReleaseTests.Release3_36_3;

import com.qait.automation.TestInitiator.TestSessionInitiator;
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
public class NG_33340Test {
 TestSessionInitiator test;
    String user, bookName, WCName;
    int count;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Create And Launch Master Next Book And Verify LPN");
        user = System.getProperty("user", "admin");
        count= Integer.parseInt(System.getProperty("count", "50"));
        bookName = getData("Books.master.masterSSO");
        WCName = getData("Books.master.WCname");
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
        //Assert.assertTrue(test.masterPage.naviagteToMasterPage(getData("environment")), "User is not on Master Page");
        test.masterPage.enterBookNameAndSearch(bookName);
        //test.masterPage.clickOnWorkingCopyButton();
        test.masterPage.clickOnShowCopyButton();
        test.masterPage.launchMasterBook(WCName);
        Reporter.log("Working Copy launched successfully", true);
    }
    @Test (invocationCount = 1)
    public void TestStep_03_clickOnAddActivityIconAndAddActivity() {
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
        test.FramesPage.switchToDefaultContent();
        Reporter.log("[ASSERT PASS]:Add Activity icon clicked successfully from LPN ",true);
        test.GoogleDriveAppPage.addDistinctGoogleDocActivity(getData("learningActivities.GoogleDoc.distinctTitle"),getData("learningActivities.GoogleDoc.gmailID"),getData("learningActivities.GoogleDoc.paswrd"));
        Reporter.log ("Completed Instructor Add Distinct Google Doc Activity Test" + "\n" ,true);
    }
     /*This test case covers:
     *This Test is failing due to https://jira.cengage.com/browse/NG-33142
     **/
    @Test
    public void TestStep_04_SearchCreatedMaster() {
        test.launchApplication(getData("masterPage_url"));
        test.adminLoginPage.loginToMindTapApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")));
        test.masterPage.verifyuserIsOnMastersPage();
        test.masterPage.enterBookNameAndSearch(bookName);
        test.masterPage.clickOnShowCopyButton();
        test.masterPage.clickOnSaveToMasterButton();
        test.masterPage.clickOnWorkingCopyButton();
        test.masterPage.launchMasterBook(WCName);
        Reporter.log("Working Copy launched successfully", true);
    }
    @Test (invocationCount = 1)
    public void TestStep_05_deleteDistinctGoogleDocActivity(){
        test.DashBoardPage.deleteDistinctActivity(getData("learningActivities.GoogleDoc.distinctTitle"));
        Reporter.log("Completed Instructor delete Distinct Google Doc Activity Test" + "\n" ,true);
        
       }
    @Test
    public void TestStep_06_verifyP2SDeleteActivityOption(){ 
        test.DashBoardPage.refreshPage();
        test.launchApplication(getData("masterPage_url"));
        test.adminLoginPage.loginToMindTapApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")));
        test.masterPage.verifyuserIsOnMastersPage();
        test.masterPage.enterBookNameAndSearch(bookName);
        test.masterPage.clickOnShowCopyButton();
        test.masterPage.clickOnSaveToMasterButton();
        test.masterPage.enterBookNameAndSearch(bookName);
        test.masterPage.clickOnPushToSnapshotButton();
        test.masterPage.verifyP2SWindow();
        Reporter.log("P2S Window is displayed successfully", true);
    }   
    
    @Test
    public void TestStep_07_LogOutFromMindTapApplication() {
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

