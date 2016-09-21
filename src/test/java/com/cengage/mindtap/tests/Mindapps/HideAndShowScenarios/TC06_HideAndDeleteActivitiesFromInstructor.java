/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.HideAndShowScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.DateUtil.getDate;
import static com.qait.automation.utils.YamlReader.getData;

public class TC06_HideAndDeleteActivitiesFromInstructor {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String titleAssessment="AA_Assessment" + getDate();
    String titleHomework="AA_Homework" + getDate();
    String ReaderUnit="Introduction to Medical Terminology";

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("AA and Hide activity");
        user = System.getProperty("user", "instructor");
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAA.courseKey"),getData("Books.courseAA.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
  @Test
    public void TestStep_03_HideAttemptedActivities(){
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.hideUnitHavingAttemptedActivities(titleAssessment);
        test.AssignableActivityPage.VerifyHiddenFromStudentTextInUnitView(titleAssessment);
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.hideUnitHavingAttemptedActivities(ReaderUnit);
        test.readingPage.SwitchToUnit(ReaderUnit);
        test.AssignableActivityPage.VerifyHiddenFromStudentTextInUnitView(ReaderUnit);
        test.AssignableActivityPage.VerifyHiddenFromStudentTextInUnitView(titleHomework);
    }
    @Test
    public void TestStep_04_DeleteActivities(){
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.deleteDistinctActivity(titleAssessment);
        test.readingPage.SwitchToUnit(ReaderUnit);
        test.DashBoardPage.deleteDistinctActivity(titleHomework);
       /* test.readingPage.SwitchToUnit(ReaderUnit);
        test.FramesPage.switchToMainFrame();
        test.readingPage.clickOnEditMode();
        test.DashBoardPage.removeInLineArgs(titleAssessment);
        test.DashBoardPage.removeInLineArgs(titleHomework);
        test.DashBoardPage.closeLaunchedActivity(ReaderUnit);
        test.AssignableActivityPage.clickOnBack();
        test.DashBoardPage.showUnit(ReaderUnit); */
    }
}

