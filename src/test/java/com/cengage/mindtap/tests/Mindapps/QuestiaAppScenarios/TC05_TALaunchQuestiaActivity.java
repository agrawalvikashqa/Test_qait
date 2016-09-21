/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.QuestiaAppScenarios;

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
 * @author kratijain
 */
public class TC05_TALaunchQuestiaActivity {
TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String newDescription = getData("learningActivities.QuestiaApp.newDescription");
    String newTitle = getData("learningActivities.QuestiaApp.newTitle");
    String newInlineActivityTitle = getData("learningActivities.QuestiaApp.newInlineActivityTitle");
    String QuestiaApp_inlineActivityTitle = getData("learningActivities.QuestiaApp.inlineActivityTitle");

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket:- https://jira.cengage.com/browse/NG-33007", true);
        test = new TestSessionInitiator("Questia App");
        user = System.getProperty("user", "TA1");
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+" successfully logs in to the application",true);
    }
    /*This test case covers:
     *Verifying of launch Questia Activity 
     **/  
    @Test
       public void TestStep_02_LaunchAppFromAppDock() {
       test.DashBoardPage.clickOnAppByName("Questia");
       test.DashBoardPage.closeOpenApp();
       Reporter.log("[ASSERT PASS]:Questia is launched ",true);
    }

    @Test
    public void TestStep_03_TALaunchQuestiaActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.launchDistinctActivity(newTitle);
        test.FramesPage.switchToMainFrame();
        test.QuestiaPage.verifyQuestiaActivityLauched(newTitle);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.closeLaunchedActivity(newTitle);
        Reporter.log(" Student activity launch successfully",true);
       
    }
    @Test
    public void TestStep_04_launchReadingActivuty() {
        test.DashBoardPage.refreshPage();
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("learningActivities.QuestiaApp.unitName"), getData("learningActivities.QuestiaApp.chapterName"));
    }

    @Test
    public void TestStep_05_navigateToChapterIntroductionPageAndVerifyAddedInLineWebLinkActivity() {
        test.FramesPage.switchToMainFrame();
        test.readingPage.navigateToChapterIntroductionPage();
        test.QuestiaPage.verifyInlineQuestiaActivityLauched(QuestiaApp_inlineActivityTitle);
        test.FramesPage.switchToDefaultContent();
        test.lpnPage.logOutFromMindTap();
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

