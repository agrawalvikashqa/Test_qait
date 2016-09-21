/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.SpeechOutlineToolScenarios;

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
public class TC04_InstDelSpeechOutlineToolActivityTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Google Drive App");
        user = System.getProperty("user", "instructor");
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+user+".username")), getData(("users."+user+".password")));
        Reporter.log(user+"successfully logs in to the application",true);
        //test.ssoLoginPage.enrollCourseInUser(user,getData("Books.course.courseKey")); 
    }
    
    
    @Test
    public void TestStep_02_LaunchCourseViaSSO(){
        if(user.equalsIgnoreCase("instructor")){
            test.instructorResourceCenterPage.instructorLaunchCourse(getData("Books.course.courseKey"), tier);
        }else if(user.equalsIgnoreCase("student")){
            test.studentMyHomePage.studentLaunchCourse(getData("Books.course.courseKey"), tier);
        }
    }
    
   /*This test case covers:
     *Delete Distinct Activity 
     **/
    //@Test
    public void TestStep_03_deleteDistinctGoogleDocActivity(){
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.deleteDistinctActivity(getData("learningActivities.GoogleDoc.distinctTitle"));
        Reporter.log("Completed Instructor delete Distinct Google Doc Activity Test" + "\n" ,true);
    }      
    
    /*This test case covers:
     *Delete Distinct inline Activity 
     **/
            
    //@Test
    public void TestStep_04_launchReadingActivuty() {
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("Books.courseKaltura.unitName"), getData("Books.courseKaltura.chapterName"));
    }
    
    //@Test    
    public void TestStep_05_deleteInlineGoogleDocActivity(){
        test.FramesPage.switchToMainFrame();
        test.readingPage.clickOnEditMode();
        test.readingPage.selectFrameAndDeleteInlineActivity();
        Reporter.log("Completed Student delete Inline Google Doc Activity" + "\n" ,true);
    }
    
    @Test
    public void TestStep_06_deleteGoogleDriveAccountFromAppDock(){
        test.GoogleDriveAppPage.DeleteGoogleDriveAccount(getData("learningActivities.GoogleDoc.gmailID"),getData("learningActivities.GoogleDoc.paswrd"));
        //Assert.assertTrue(test.GoogleDriveAppPage.verifyAccountIsDeleted(),"Google doc account not deleted");
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
