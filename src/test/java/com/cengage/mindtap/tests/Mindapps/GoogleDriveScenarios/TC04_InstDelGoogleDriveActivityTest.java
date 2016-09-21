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
public class TC04_InstDelGoogleDriveActivityTest {
    
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
     *Delete Distinct Activity 
     **/
    //@Test
    public void TestStep_02_deleteDistinctGoogleDocActivity(){
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.deleteDistinctActivity(getData("learningActivities.GoogleDoc.distinctTitle"));
        Reporter.log("Completed Instructor delete Distinct Google Doc Activity Test" + "\n" ,true);
    }      
    
    /*This test case covers:
     *Delete Distinct inline Activity 
     **/
            
    //@Test
    public void TestStep_03_launchReadingActivuty() {
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("Books.courseKaltura.unitName"), getData("Books.courseKaltura.chapterName"));
    }
    
    //@Test    
    public void TestStep_04_deleteInlineGoogleDocActivity(){
        test.FramesPage.switchToMainFrame();
        test.readingPage.clickOnEditMode();
        test.readingPage.selectFrameAndDeleteInlineActivity();
        Reporter.log("Completed Student delete Inline Google Doc Activity" + "\n" ,true);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.closeActivity();
        
    }
    
    @Test
    public void TestStep_05_deleteGoogleDriveAccountFromAppDock(){
        test.GoogleDriveAppPage.DeleteGoogleDriveAccount(getData("learningActivities.GoogleDoc.gmailID"),getData("learningActivities.GoogleDoc.paswrd"));
        test.DashBoardPage.closeOpenApp();
        test.DashBoardPage.verifyAccountIsDeleted();
        Reporter.log("Completed Instructor delete Google Doc Account From App Dock Test" + "\n" ,true);
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
