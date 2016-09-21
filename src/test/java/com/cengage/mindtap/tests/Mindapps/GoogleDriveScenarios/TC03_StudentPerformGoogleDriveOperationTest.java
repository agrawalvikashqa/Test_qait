/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.GoogleDriveScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
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
public class TC03_StudentPerformGoogleDriveOperationTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Google Drive App");
        user = System.getProperty("user", "student");
        test.launchApplication(getData("sso_url"));
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
    public void TestStep_02_studentVerifyGoogleDriveApp() {
        test.GoogleDriveAppPage.studentVerifyGoogleDriveApp();
        test.DashBoardPage.closeOpenApp();
        Reporter.log ("Completed verify Google Doc App",true); 
    }
    
    @Test
    public void TestStep_03_studentVerifyDistinctGoogleDriveActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.launchDistinctActivity(getData("learningActivities.GoogleDoc.distinctTitle"));
        Reporter.log ("Completed Student launch Distinct Google Doc Activity Test" + "\n" ,true);          
        test.DashBoardPage.closeLaunchedActivity(getData("learningActivities.GoogleDoc.distinctTitle"));
    
    }
    
    /*This test case covers:
     *Student verify Inline Google Drive Activity
     **/
    @Test
    public void TestStep_04_studentVerifyInlineGoogleDriveActivity(){
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("Books.courseKaltura.unitName"), getData("Books.courseKaltura.chapterName"));
        test.GoogleDriveAppPage.verifyInlineGoogleDriveActivity();
        Reporter.log("Completed Instructor verify Inline Google Doc Activity" + "\n" ,true);      
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
