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
import org.testng.annotations.*;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author kratijain
 */
public class TC06_InstructorDeleteQuestiaActivityTest {
TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String newTitle = getData("learningActivities.QuestiaApp.newTitle");
    String QuestiaApp_inlineActivityTitle = getData("learningActivities.QuestiaApp.inlineActivityTitle");

    @BeforeClass
        public void start_test_session() {
           Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32839", true);
           test = new TestSessionInitiator("Questia App Test");
           user = System.getProperty("user", "instructor");
          }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    @Test
    @Parameters({"activityCourseBook"})
    public void TestStep_03_UserDeleteDistinctActivity(@Optional("course") String activityCourseBook){
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.deleteDistinctActivity(getData("learningActivities.QuestiaApp.newTitle"));
        test.DashBoardPage.deleteDistinctActivity(getData("learningActivities.QuestiaApp.inlineActivityTitle"));
    }
    @Test
    @Parameters({"activityCourseBook"})
    public void TestStep_03_UserDeleteInlineActivity(@Optional("course") String activityCourseBook){
        test.DashBoardPage.refreshPage();
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("learningActivities.QuestiaApp.unitName"), getData("learningActivities.QuestiaApp.chapterName"));
        test.FramesPage.switchToMainFrame();
        test.readingPage.navigateToChapterIntroductionPage();
        test.readingPage.clickOnEditModeAndDeleteInlineActivity();
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
    