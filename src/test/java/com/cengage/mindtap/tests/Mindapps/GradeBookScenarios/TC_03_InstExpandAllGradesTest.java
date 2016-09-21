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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;
import org.testng.annotations.AfterClass;

/**
 *
 * @author QAI
 */
public class TC_03_InstExpandAllGradesTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String activitytitle;
   String studentname;
    String score;
    /** The get browser. */
    //String getBrowser;


     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32931", true);
        test = new TestSessionInitiator("GradeBook App check Test");
        user = System.getProperty("user", "instructor1");
        studentname = getData("learningActivities.GradeBookApp.studentname");
         activitytitle="practice assignment cnow";
       // activitytitle = getData("learningActivities.GradeBookApp.activitytitle");
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
       Reporter.log("[ASSERT TC PASS]:Completed Open Gradebook App from appdock",true);
       }
    @Test
   public void TestStep_03_extendDueDateForStudent(){
        test.gradebookpage.verifyExpandedViewOfGradeBook();
        test.gradebookpage.verifyCollapsedViewOfGradeBook();
        test.gradebookpage.clickStudentName(studentname);
        test.gradebookpage.extendDueDateForStudent();
        Reporter.log("Completed extend Due Date For Student",true);
    }
  @Test
   public void TestStep_04_verifySystemGeneratedCommentsNotEditable(){
         Assert.assertFalse(test.gradebookpage.verifySystemGeneratedCommentsNotEditable());
        Reporter.log("Completed verify System Generated Comments When activity due date is changed",true);
    } 
   @Test
   public void TestStep_05_closeGradeBookAppFromAppDock(){     
        test.gradebookpage.closeGradeBookApp();
        Reporter.log("Completed close Grade Book App",true);
    }
   @Test 
  public void TestStep_06_openGradebook(){
        test.DashBoardPage.clickOnAppByName("Progress");
        test.gradebookpage.verifyActivitiesInOverviewTab();
        Reporter.log ("Completed Navigation to Progress App ",true);
    }
  @Test
  public void TestStep_07_instructorLaunchesActivityFromOverviewTabAndEditScore(){
        test.gradebookpage.launchActivityFromOverviewTab(activitytitle);
        System.out.println("launchActivityFromOverviewTab");
        test.gradebookpage.editScoreForActivity();
        System.out.println("editScoreForActivity(");
        Reporter.log("Instructor changed the score for manually graded activity", true);
        Reporter.log( "Completed  graded attempt score is displayed on the grid.", true);
        test.gradebookpage.closeGradeBookApp();
    }
  @Test
 public void TestStep_08_instructorVerifyAssignmentScoreShouldBeIncludedInCategoryAverage(){
           test.DashBoardPage.clickOnAppByName("Progress");
        test.gradebookpage.ClickAndVerifyExpandViewOfGradeBook();
     Assert.assertTrue(test.gradebookpage.verifyGradesAfterCategoryCollapse(),"Score After Category Collapse does not match");
}
 
 /*User Logout 
    */
   @Test
    public void TestStep_09_Logout() {
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
