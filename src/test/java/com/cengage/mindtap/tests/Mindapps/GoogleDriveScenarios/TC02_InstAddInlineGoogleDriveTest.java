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
public class TC02_InstAddInlineGoogleDriveTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String activityName = getData("Books.courseWebLink.name");

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
    
    @Test
    public void TestStep_02_launchReadingActivuty() {
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("Books.courseKaltura.unitName"), getData("Books.courseKaltura.chapterName"));
    }
    
    /*This test case covers:
     *Add inline google drive activity in chapter
     **/
    
    @Test
    public void TestStep_03_addInlineActivityInChapter() {
        test.FramesPage.switchToMainFrame();
        test.readingPage.clickOnEditModeAndAddIconLiknsAndNavigateToChapterIntroductionPage();
        test.FramesPage.switchToDefaultContent();
        test.GoogleDriveAppPage.addDistinctGoogleInlineDriveActivity(getData("learningActivities.GoogleDoc.distinctTitle"),getData("learningActivities.GoogleDoc.gmailID"),getData("learningActivities.GoogleDoc.paswrd"));
        test.FramesPage.switchToDefaultContent();
        
    }
    
    /*This test case covers:
     *verify Inline Google Drive Activity
     **/
   @Test
    public void TestStep_04_verifyInlineGoogleDriveActivity(){
        test.FramesPage.switchToDefaultContent();
        test.GoogleDriveAppPage.verifyInlineGoogleDriveActivity();
        Reporter.log("Completed Instructor verify Inline Google Doc Activity" + "\n" ,true);      
    }
    
    /*This test case covers:
     *Edit Inline Google Doc Activity
     *LogOut
     **/
    @Test
    public void TestStep_05_editInlineGoogleDriveActivity(){
        test.FramesPage.switchToMainFrame();
        test.GoogleDriveAppPage.editInlineGoogleDocActivity(getData("learningActivities.GoogleDoc.inlineTitle"));
        test.DashBoardPage.Logout();
        Reporter.log("Completed Instructor edit Inline Google Doc Activity" + "\n" ,true);      
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
