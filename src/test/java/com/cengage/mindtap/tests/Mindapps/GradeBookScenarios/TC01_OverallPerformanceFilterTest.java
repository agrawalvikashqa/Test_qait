/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.GradeBookScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author QAI
 */
public class TC01_OverallPerformanceFilterTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String activityname;
    String studentname;
    String score;
    String activitytype;
    String name;
    /** The get browser. */
    //String getBrowser;


     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32928", true);
        test = new TestSessionInitiator("GradeBook App check Test");
        user = System.getProperty("user", "instructor1");
        studentname = getData("learningActivities.GradeBookApp.studentname");
        activityname = getData("learningActivities.GradeBookApp.activityname");
        activitytype = getData("learningActivities.GradeBookApp.activitytype");
        score = getData("learningActivities.GradeBookApp.score");
    }

  @Test
     public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")),getData(("users."+user+".password")),getData("Books.courseGradeBook.courseKey"),getData("Books.courseGradeBook.ISBN"));
        Reporter.log(user+" successfully logs in to the application",true); 
    }
    
    @Test
    public void TestStep_02_LaunchGradeBookFromAppDock() throws InterruptedException {
       test.DashBoardPage.clickOnAppByName("Progress");
       Assert.assertTrue(test.gradebookpage.verifyGradeBookAppOpened(),"Gradebook App failed to launch");
       Reporter.log("[ASSERT TC_02 PASS]:Completed Open Gradebook App from appdock test completed",true);
       }
    @Test
    public void TestStep_03_verifyStudentRosterByOverallPerformance(){
        test.FramesPage.switchToDefaultContent();
        test.FramesPage.switchToDockIFrame();
        test.gradebookpage.selectLevelInOverallPerformance("LOW");
        Assert.assertTrue(test.gradebookpage.verifyLevelChangesReflectedInUserViewport("Low"),"No student with Low performance found");
        Reporter.log("[ASSERT TC_03 PASS]:Completed Verify Student Roster By Overall Performance",true);
        
    }
    @Test
    public void TestStep_04_verifyGradesAppearOnExpandingAllGrades(){
        test.gradebookpage.verifyExpandedViewOfGradeBook();
        Assert.assertTrue(test.gradebookpage.verifycollapsedGradeBookButton(),"Collapse Grade button not found");
        Assert.assertTrue(test.gradebookpage.verifygradesCellsInGrid(),"GradesCellsInGrid not found");
        Reporter.log("[ASSERT TC_04 PASS]:Completed Verify Expand All Grades Functionality",true);
    }
    
    @Test
   public void TestStep_05_filterAssignmentsByCategory(){
       test.gradebookpage.selectCategoryFromFilterAssignmentsLinkInGrid();
       Reporter.log("[ASSERT TC_05 PASS]:Completed Select Category From Filter Assignments Link In Grid",true);
   }
   
    @Test
    public void TestStep_06_verifyTotalPossiblePointsDisplayedBelowActivityNameInGrid(){
        test.gradebookpage.verifyTotalPossiblePointsBelowActivityInGrid();
        Reporter.log("[ASSERT TC_06 PASS]:Completed Verify Total Possible Points Below Activity In Grid",true);
    }
   @Test
    public void TestStep_07_verifyGradedActivitiesUnderCorrespongingUnitsInGrid(){
        test.gradebookpage.verifyGradedActivitiesUnderCorrespondingUnits();
        Reporter.log("[ASSERT TC_07 PASS]:Completed Verify Graded Activities Under Corresponging Units In Grid",true);
        
    }
    @Test
    public void TestStep_08_verifyGridSortingByOverallPerformance(){
        test.gradebookpage.selectLevelInOverallPerformance("LOW");
        Assert.assertTrue(test.gradebookpage.verifyLevelChangesReflectedInUserViewport("Low"),"No student with Low performance found");
        Reporter.log("[ASSERT TC_08 PASS]:Completed Verify Grid Sorting By Overall Performance",true);
    }
    
    @Test
    public void TestStep_09_verifyGradesDisappearOnCollapsingAllGrades(){
        test.gradebookpage.verifyCollapsedViewOfGradeBook();
        Assert.assertTrue(test.gradebookpage.verifyexpandGradeBookButton(),"Expand gradebook button not found");
        Reporter.log("[ASSERT TC_09 PASS]:Completed Verify Grades Disappear On Collapsing All Grades",true);
    }
    
    @Test
    public void TestStep_10_verifyOrangGradeTextInManualGradedActivity(){
      test.gradebookpage.verifyOrangeLinkDisplayedInManualGradedActivity(studentname);
      Reporter.log("[ASSERT TC_10 PASS]:Completed Verify Orange Grade Text In Manual Graded Activity",true);
    }
    
    @Test
    public void TestStep_11_verifyPendingGradeTextInManualGradedActivity(){
      test.gradebookpage.verifyPendingGradeTextInManualGradedActivityIsDisplayed();
      Reporter.log("[ASSERT TC_11 PASS]:Completed Verify Pending Grade Text In Manual Graded Activity",true);
    }
    @Test
     public void TestStep_12_verifyStudentGradesShowInOneDecimalPlace(){
        test.gradebookpage.verifyStudentGradesShowInOneDecimalPlace();
        Assert.assertTrue(test.gradebookpage.verifyScoreRoundedOffToTenthPlace(),"Could not edit score");        
        Reporter.log("[ASSERT TC_12 PASS]:Completed verify Student Grades Show In One Decimal Place",true);
    }
    @Test
    public void TestStep_13_updateAndVerifyStudentGradesFromGradeBookGrid(){
      test.gradebookpage.verifyEditStudentGrades();
      test.gradebookpage.closeApp();
      Reporter.log("[ASSERT TC_13 PASS]:Completed Update And Verify Student Grades FromGradeBook",true);
      }
   @Test
    public void TestStep_14_verifyActivityFromGradebookApp(){
    test.DashBoardPage.clickOnAppByName("Progress");
    Assert.assertTrue(test.gradebookpage.verifyGradeBookAppOpened(),"Gradebook App failed to launch");
    test.gradebookpage.verifyActivityFromGradebook(studentname,activitytype,activityname);
    test.gradebookpage.gradeBookHome();
    Reporter.log("[ASSERT TC_14 PASS]:Completed Update And Verify Student Grades FromGradeBook",true);
    }
     
/*User Logout 
    */
   @Test
    public void TestStep_15_Logout() {
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
  
    
    
  

    
    

