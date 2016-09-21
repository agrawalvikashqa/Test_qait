/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.GradeBookScenarios;

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
 * @author QAI
 */
public class TC_02_InstEditActivityScoreTest {
    
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String studentname;
    
    String user;

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32929", true);
        test = new TestSessionInitiator("Gradebook Apps Check Test");
       user = System.getProperty("user", "instructor1");
       studentname = getData("learningActivities.GradeBookApp.studentname");
       
    }

   @Test
     public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")),getData(("users."+user+".password")),getData("Books.courseGradeBook.courseKey"),getData("Books.courseGradeBook.ISBN"));
        Reporter.log(user+" successfully logs in to the application",true); 
    }
    
    /*This test case covers:
     *Verifying of Gradebook App
     **/
    
    @Test
    public void TestStep_03_LaunchAppFromAppDock() {
        test.DashBoardPage.clickOnAppByName("Progress");
        test.FramesPage.switchToDockIFrame();
        test.gradebookpage.gradebookLaunch();   
        Reporter.log(user+"  successfully Launch Gradebook App From App Dock");
    }
    
    @Test
    public void TestStep_04_VerifyActivityButtonAndMessage() {
        test.gradebookpage.clickStudentName(studentname);
        test.gradebookpage.verifyManualGradedNoAttemptActivityButtonDisabledAndMessage();
        test.gradebookpage.verifySubmittedManualGradedActivityButtonDisabledAndMessage();
        test.gradebookpage.verifyGradedNoAttemptActivityButtonDisabledAndMessage();
        test.gradebookpage.verifySubmittedGradedActivityButtonDisabledAndMessage();
        Reporter.log("Completed Test 04 Verify Activit Button And Message",true);
    }
    
    @Test
    public void TestStep_05_VerifyInstructorAbleToEditScore() {
        test.gradebookpage.verifyInstructorAbleToEditScoreManualNonAttemptActivity();
        test.gradebookpage.verifyInstructorAbleToEditScoreManualAttemptedActivity();
        test.gradebookpage.verifyInstructorAbleToEditScoreGradedAttemptedActivity();
        test.gradebookpage.verifyInstructorAbleToEditScoreGradedNoAttemptedActivity();
        Reporter.log("Completed Test 05 Verify Instructor Able To Edit Score",true);
    }
    
    @Test
    public void TestStep_06_VerifyStudentScoreDisplay() {
        test.gradebookpage.verifyStudentScore(studentname);
        Reporter.log("Completed Test 06 Verify Student Score Display",true);
    }
    
   /*User Logout 
    */
   @Test
    public void TestStep_07_Logout() {
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

    

