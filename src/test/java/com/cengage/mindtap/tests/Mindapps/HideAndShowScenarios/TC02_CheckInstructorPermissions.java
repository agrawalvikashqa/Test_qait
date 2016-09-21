
package com.cengage.mindtap.tests.Mindapps.HideAndShowScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.DateUtil.getDate;
import static com.qait.automation.utils.YamlReader.getData;
/**
 *
 * @author nikitaaggarwal
 */
public class TC02_CheckInstructorPermissions {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String titleAssessment="AA_Assessment" + getDate();
    String titleHomework="AA_Homework" + getDate();
    String ReaderUnit="Introduction to Medical Terminology";
    String VisibleUnit="The Human Body in Health and Disease";
    String HomeLocation="VJ_Ehrlich_P2S";

    
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
    public void TestStep_02_EditAAFromLpn(){
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.editDistinctActivity(titleAssessment);
        //test.FramesPage.switchToModeOptionsEditFrame();
        test.AssignableActivityPage.selectFeedBackAfterAssignment();
        test.AssignableActivityPage.clickOnSaveChanges();
        test.DashBoardPage.SaveChanges();
    }
    @Test
    public void TestStep_03_SetDueDateOfActivity(){
        test.DashBoardPage.clickOnView("Date Manager View");
        test.AssignableActivityPage.setDuedateOfAssessmentActivity(titleAssessment);
        test.DashBoardPage.clickOnView("Unit View");
        test.AssignableActivityPage.verifyDueDateOnLPN(titleAssessment);
    }
    
    @Test
    public void TestStep_04_LaunchActivityFromInstructor(){
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.launchDistinctActivity(titleAssessment);
        test.AssignableActivityPage.SubmitActivity();
        test.DashBoardPage.closeLaunchedActivity(titleAssessment);
        test.DashBoardPage.launchDistinctActivity(titleAssessment);
        test.AssignableActivityPage.VerifySubmittedActivity();
        test.DashBoardPage.closeLaunchedActivity(titleAssessment);
    }
    @Test
    public void TestStep_05_VerifyActivityLabels(){
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.VerifyGradedLabel(titleAssessment);
        test.readingPage.SwitchToUnit(ReaderUnit); 
        test.DashBoardPage.VerifyPracticeLabel(titleHomework);
        test.AssignableActivityPage.clickOnBack();
    }
    @Test
    public void TestStep_06_HideActivityFromLPN(){
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.hideUnit(titleAssessment);
        test.AssignableActivityPage.VerifyHiddenFromStudentTextInUnitView(titleAssessment);
        test.DashBoardPage.clickOnView("Date Manager View");
        test.AssignableActivityPage.VerifyHiddenFromStudentTextInDateManager(titleAssessment);
    }
    @Test
    public void TestStep_07_HideUnitFromLPN(){
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.hideUnit(ReaderUnit);
        test.readingPage.SwitchToUnit(ReaderUnit);
        test.AssignableActivityPage.VerifyHiddenFromStudentTextInUnitView(ReaderUnit);
        test.AssignableActivityPage.VerifyHiddenFromStudentTextInUnitView(titleHomework);
        test.AssignableActivityPage.clickOnBack();
        test.DashBoardPage.clickOnView("Date Manager View");
        test.AssignableActivityPage.VerifyHiddenFromStudentTextInDateManager(ReaderUnit);
        test.AssignableActivityPage.VerifyHiddenFromStudentTextInDateManager(titleHomework);
    }
    @Test
    public void TestStep_08_VerifyRemoveHiddenUnitsFunctionality(){
        test.DashBoardPage.clickOnView("Unit View");
        test.AssignableActivityPage.removeHiddenItemsFromUnitView();
        test.AssignableActivityPage.activitiesAfterHiddenItems(titleAssessment);
        test.AssignableActivityPage.removeHiddenItemsFromUnitView();
    }
    @Test
    public void TestStep_09_VerifyHiddenActivitiesInGradebook(){
        test.DashBoardPage.clickOnAppByName("Progress");
        test.FramesPage.switchToDockIFrame();
        test.AssignableActivityPage.HiddenItemsinGradebook(titleAssessment);
        test.DashBoardPage.closeOpenApp();
    }
    @Test
    public void TestStep_10_MoveHiddenActivityToVisibleUnit(){
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.editDistinctActivityLocation(titleAssessment);
        test.DashBoardPage.addToLocation(VisibleUnit);
        test.DashBoardPage.SaveChanges();
        test.readingPage.SwitchToUnit(VisibleUnit);
        test.AssignableActivityPage.VerifyHiddenFromStudentTextInUnitView(titleAssessment);
        test.DashBoardPage.editDistinctActivityLocation(titleAssessment);
        test.DashBoardPage.addToTopLocation(HomeLocation);
        test.DashBoardPage.SaveChanges();
        test.AssignableActivityPage.clickOnBack();
    }
    /*@AfterClass(alwaysRun = true)
    public void stop_test_session() {
        test.closeTestSession();
    }*/

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
    
    
}
