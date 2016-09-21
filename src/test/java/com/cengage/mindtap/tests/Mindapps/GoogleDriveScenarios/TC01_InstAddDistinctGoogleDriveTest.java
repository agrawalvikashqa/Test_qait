/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.GoogleDriveScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
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
 * 
 * @author QAI
 */
public class TC01_InstAddDistinctGoogleDriveTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Google Drive App");
        user = System.getProperty("user", "instructor");
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    /*This test case covers:
     *Verifying of Google Drive App 
     **/
    
    @Test
    public void TestStep_02_LaunchAppFromAppDock() {
        test.DashBoardPage.clickOnAllApps();
        test.GoogleDriveAppPage.clickOnGoogleDriveApp();
        Reporter.log(user+"successfully Launch My Content App From App Dock",true);
    }
    
    /*This test case covers:
     *Add Google Drive App in My Content AppDock
     **/
   @Test
    public void TestStep_03_AddGoogleDriveAccountFromAppDock(){
        Assert.assertTrue(test.GoogleDriveAppPage.addGoogleDocApp(getData("learningActivities.GoogleDoc.gmailID"),getData("learningActivities.GoogleDoc.paswrd")),"Google Drive account not added");
        Reporter.log("Completed Instructor add Google Doc Account From App Dock Test" + "\n" ,true);
    }
    
    
    /*This test case covers:
     *Verifying filtering and Sorting in Google Doc App
     **/
   @Test
    public void TestStep_04_verifyFilteringSortingInGoogleDriveApp(){
        Assert.assertTrue(test.GoogleDriveAppPage.verifyFilteringSortingInGoogleDriveApp());
        Reporter.log ("Completed Instructor verify Filtering Sorting In Google Doc App Test" + "\n" ,true);
        test.DashBoardPage.closeOpenApp();
    
    }
    
   @Test
    public void TestStep_05_clickOnAddIconAndAddActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    }
    
        /*This test case covers:
     *Add Distinct Google Doc Activity
     *and verifying the same is added
     **/
   @Test
    public void TestStep_06_addDistinctGoogleDriveActivity(){
        test.GoogleDriveAppPage.addDistinctGoogleDocActivity(getData("learningActivities.GoogleDoc.distinctTitle"),getData("learningActivities.GoogleDoc.gmailID"),getData("learningActivities.GoogleDoc.paswrd"));
        Reporter.log ("Completed Instructor Add Distinct Google Doc Activity Test" + "\n" ,true);
    }
    
    
    @Test
    public void TestStep_08_editDistinctGoogleDocActivity(){
     test.GoogleDriveAppPage.editDistinctGoogleDriveActivity(getData("learningActivities.GoogleDoc.distinctTitle"));
        test.GoogleDriveAppPage.editDistinctGoogleDriveActivity(getData("learningActivities.GoogleDoc.distinctTitle"));
        Reporter.log ("Completed Instructor Edit Distinct Google Doc Activity Test" + "\n" ,true);      
    }
    
    /*This test case covers:
     *Launching Distinct Google Doc Activity
     *Logging Out
     **/
    @Test
    public void TestStep_08_launchDistinctGoogleDocActivityAndLogout(){
        test.DashBoardPage.launchDistinctActivity(getData("learningActivities.GoogleDoc.distinctTitle"));
        test.DashBoardPage.Logout();
        Reporter.log ("Completed Instructor launch Distinct Google Doc Activity Test" + "\n" ,true);      
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
