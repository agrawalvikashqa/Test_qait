/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.HideAndShowScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.DateUtil.getDate;
import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author nikitaaggarwal
 */
public class TC01_AdminAADistinctActivityTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String titleAssessment="AA_Assessment" + getDate();
    String titleHomework="AA_Homework" + getDate();
    String text="Test";
    String ReaderUnit="Introduction to Medical Terminology";
    String CourseKey = getData("Books.courseAA.courseKey");
    //String Chapter = "Primary Medical Terms";

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Assignable Activity");
        user = System.getProperty("user", "admin");
        test.launchApplication(getData("base_url"));
    }
    @Test
    public void TestStep_01_LoginToMindTapApplication() {
        test.adminLoginPage.loginToMindTapApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")));
        test.masterPage.verifyuserIsOnMastersPage();
        Reporter.log(user + " successfully logs in to the application", true);
    }
    @Test 
    public void TestStep_02_SearchCourse() {
       test.masterPage.clickOnOrganizationTab();
        test.masterPage.enterCoursekey(CourseKey);  
    }
    @Test
    public void TestStep_03_LaunchCourse() {
        test.masterPage.ClickOnOrg();
        test.masterPage.ClickOnCourseFromAdmin();
        test.masterPage.LaunchSnapshotFromAdmin();
    }
   @Test
    public void TestStep_04_clickOnAddActivityIcon() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    }
    @Test
    public void TestStep_05_AddAssessmentAAToLPN() {
        test.DashBoardPage.clickOnActivity("Assignable Activity");
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.AssignableActivityPage.AddAssessmentAA();
        test.DashBoardPage.addActivityDiscriptionAndTitle(titleAssessment, text);
    }
    @Test
    public void TestStep_06_clickOnAddActivityIcon() {
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.SwitchToUnit(ReaderUnit);
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    }
    @Test
    public void TestStep_07_AddHomeworkAAToLPN() {
        test.DashBoardPage.clickOnActivity("Assignable Activity");
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.AssignableActivityPage.AddHomeworkAA();
        test.DashBoardPage.addActivityDiscriptionAndTitle(titleHomework, text);
        test.AssignableActivityPage.clickOnBack();
    }
    @Test
    public void TestStep_09_AddedInlineAssessmentAA(){
    test.DashBoardPage.clickOnView("Unit View");
    test.readingPage.launchReadingActivityToAddInLineActivity(ReaderUnit, ReaderUnit);
    test.FramesPage.switchToMainFrame();
    test.readingPage.clickOnEditModeAndAddIconLiknsAndNavigateToChapterIntroductionPage();
    test.FramesPage.switchToDefaultContent();
    test.DashBoardPage.clickOnActivity("Inline Assignment");
    test.FramesPage.switchToDistinctActivityCreateFrame();
    test.AssignableActivityPage.AddAssessmentAA();
    test.DashBoardPage.addActivityDiscriptionAndTitleForInline(titleAssessment, text);
    }
    @Test
    public void TestStep_09_AddedInlineHomeworkAA(){
    test.FramesPage.switchToMainFrame();
    test.readingPage.clickOnAddIconLikns();
    test.FramesPage.switchToDefaultContent();
    //test.readingPage.clickOnEditModeAndAddIconLiknsAndNavigateToChapterIntroductionPage();
    test.DashBoardPage.clickOnActivity("Inline Assignment");
    test.FramesPage.switchToDistinctActivityCreateFrame();
    test.AssignableActivityPage.AddHomeworkAA();
    test.DashBoardPage.addActivityDiscriptionAndTitleForInline(titleHomework, text);
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
