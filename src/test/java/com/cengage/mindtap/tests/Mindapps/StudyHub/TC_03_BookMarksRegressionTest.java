/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.StudyHub;


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
public class TC_03_BookMarksRegressionTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;
    String unitName = getData("learningActivities.QuestiaApp.unitName");
    String chapterName = getData("learningActivities.QuestiaApp.chapterName");
    String bmuname = getData("learningActivities.StudyHub.bmarkuname");
    

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Launch Apps From App Dock Test");
        user = System.getProperty("user", "instructor");
        
    }

     @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        //test.DashBoardPage.verifyCengageLogoIsDisplayedInDashboardView();
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
 /*   @Test
    public void TestStep_03_InstructorVerifyNoBookmarksMessage(){
         test.DashBoardPage.clickOnAllApps();
         test.DashBoardPage.LaunchAppFromAppDock("mtstudycenter");

         Reporter.log(user+" successfully Verified Study Hub Launch",true);
         test.FramesPage.switchToDockIFrame();
         test.StudyHubAppPage.clickOnBookmarkTab();
         test.StudyHubAppPage.NoBookmarkMessage();
         test.DashBoardPage.closeOpenApp();
         
    }*/
    
    @Test
    public void TestStep_02_InstructorCreateBookmarks(){
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("learningActivities.QuestiaApp.unitName"), getData("learningActivities.QuestiaApp.chapterName"));
        test.FramesPage.switchToMainFrame();
        test.StudyHubAppPage.ClickBookmarkLink();
        test.readingPage.clickOnActivityNextButton();
        test.StudyHubAppPage.ClickBookmarkLink();
        test.readingPage.clickOnActivityNextButton();
        test.StudyHubAppPage.ClickBookmarkLink();
        test.FramesPage.switchToDefaultContent();
        test.readingPage.closeOpenActivity();
        test.DashBoardPage.clickOnAppByName("StudyHub");
        Reporter.log(user+" successfully Verified Study Hub Launch",true);
        test.FramesPage.switchToDockIFrame();
        test.StudyHubAppPage.clickOnBookmarkTab();
        test.StudyHubAppPage.BookmarkStudyHubVerify(bmuname);
    }
   @Test
    public void TestStep_03_InstructorDeleteBookmarks(){
        test.StudyHubAppPage.InstructorDeleteBookmarks();
        
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
