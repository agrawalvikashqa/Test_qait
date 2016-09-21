/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.WeblinkScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;
import org.testng.annotations.AfterClass;

/**
 *
 * @author QAI
 */
public class TC01_UserAddLaunchAndEditDistinctWebLinkActivityTest {

    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String userIstructor;
    String userStudent;
    String activityName = getData("Books.courseWebLink.name");
    String webURL = getData("Books.courseWebLink.url");
    String text = getData("Books.courseWebLink.text");
    String webLinkActivity_title = getData("Books.courseWebLink.title");
    String anotherWebURL = getData("Books.courseWebLink.anotherURL");
    String user; 
    
    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Search App Test");
        user = System.getProperty("user", "instructor");
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    @Test
    public void TestStep_02_clickOnAddIconAndAddActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    }

    @Test
    public void TestStep_03_addDistinctWebLinkActivity() {
        test.DashBoardPage.clickOnActivity(activityName);
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.webLinkPage.addWebLinkActivity(webURL, text);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addActivityDiscriptionAndTitle(webLinkActivity_title, text);
    }

    @Test
    public void TestStep_04_instructorLaunchWebLinkActivity() {
        test.DashBoardPage.launchDistinctActivity(webLinkActivity_title);
        test.FramesPage.switchToMainFrame();
        test.webLinkPage.verifyWeblinkActivityLauched(webLinkActivity_title);
        
    }

    
    @Test
    public void TestStep_05_LaunchWebLinkURL() {
    
        test.webLinkPage.verifyWeblinkURL(webLinkActivity_title);
        test.webLinkPage.verifyWebLinkURL();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.closeLaunchedActivity(webLinkActivity_title);
    }
    
    /*
    ERROR : 
    Not able to edit activity after Creating usning automation script commented test cases are dependent on it 
    */
    
    //@Test
    public void TestStep_06_instructorEditWebLinkActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.editDistinctActivity(webLinkActivity_title);
        test.FramesPage.switchToModeOptionsEditFrame();
        test.webLinkPage.fillEntryInField(anotherWebURL, text);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addActivityDiscriptionAndTitle(webLinkActivity_title, text);
        test.lpnPage.logOutFromMindTap();
    }

    //@Test
    public void TestStep_07_studentLogInAndLaunchCourse() {
        user = System.getProperty("user", "student");
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(userStudent + " successfully logs in to the application", true);
        Reporter.log(userStudent + " successfully launch the course", true);
    }

    //@Test
    public void TestStep_08_studentLaunchWebLinkActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.launchDistinctActivity(webLinkActivity_title);
        test.FramesPage.switchToMainFrame();
        test.webLinkPage.verifyWeblinkActivityLauched(webLinkActivity_title);
        
        test.webLinkPage.verifyWeblinkURL(webLinkActivity_title);
        test.webLinkPage.verifyWebLinkURL();
        
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.closeLaunchedActivity(webLinkActivity_title);
       // test.lpnPage.logOutFromMindTap();
    }

     /*User Logout 
    */
   @Test
    public void TestStep_08_Logout() {
        test.DashBoardPage.Logout();
         Reporter.log(user+" successfully Logout",true);
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
