/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.Chemistry.CXPActivities.Reviews;

/**
 *
 * @author nadeemahmed
 */

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.openqa.selenium.support.ui.Select;


import static com.qait.automation.utils.YamlReader.getData;
import java.lang.reflect.Method;
import org.testng.annotations.AfterClass;

public class TC_02_StudentReviewActivityFlowTest {
    
    TestSessionInitiator test;
        String user;
        String ProgressTitle = "Progress";
        String StudentName = "qad, student";
        String ChemistryReviewActivity = getData("Books.courseChemistry.ChemistryReviewActivity");
        
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Smoke Test");
        user = System.getProperty("user", "student");
        
    }

	@Test
    public void TestStep_01_LoginToSSOApplication() {
        Reporter.log( "Test_01 : Login to SSO application", true);
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseChemistry.courseKey"),getData("Books.courseChemistry.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    @Test
	public void TestStep_02_LaunchStudentReviewActivityFlowTest() {
            Reporter.log( "Test_02 : Launch Student Review Activity Flow Test", true);
		// Instructor Review Activity FlowTest
		System.out.println("Test Name: verifyStudentReviewActivityFlowTest");
		test.weekwidgetPage.navigateToWeek("Week 44");
		test.MTXActivityPage.clickOnReview();
		test.MTXActivityPage.getTitleOfActivity();
		//test.MTXIntroAndQuickPrepPage.verifyPreparationTabIsPresentForIntroAndQuickPrep();
                Reporter.log(user + "successfully launches Student Review Activity", true);
	}
        
        //@Test
	public void TestStep_03_ClickOnSubmitAnswer() {
            Reporter.log( "Test_03 : Clicks on submit answers", true);
		// Current Score
		Reporter.log("Test Name: ClickOnSubmitAnswer",true);
		test.MTXIntroAndQuickPrepPage.verifyAttemptQuestions();
                test.MTXIntroAndQuickPrepPage.submitAnswerButton();
                test.MTXIntroAndQuickPrepPage.getTitleOfFeedback();
                test.MTXIntroAndQuickPrepPage.VerifyAttemptsAndTryAnotherVersion();
                Reporter.log(user + "successfully clicks on submit answer", true);
	}
        
        @Test
	public void TestStep_04_SelectDropDownAnswers() {
            Reporter.log( "Test_04 : Select drop down answers", true);
		// Select Drop Down Answers
		System.out.println("Test Name: Verify DropDown Answers");
		test.MTXActivityPage.selectDropDownAnswers();
                Reporter.log(user + "successfully select drop down answers", true);
        
        }
        
        @Test
	public void TestStep_05_VerifyBackButton(){
            Reporter.log( "Test_05 : Launch verify back button", true);
		// Back Button
		System.out.println("Test Name: VerifyBackButton");
		test.MTXIntroAndQuickPrepPage.VerifyBackButton();
                Reporter.log(user + "successfully verified the back button", true);
	}
        
       
        
               
        @Test
	public void TestStep_06_ClickOnSubmitAnswer() {
            Reporter.log( "Test_06 : Verify click on submit answer", true);
		// Current Score
		System.out.println("Test Name: ClickOnSubmitAnswer");
		test.MTXIntroAndQuickPrepPage.submitAnswerButton();
                Reporter.log(user + "successfully clicked on submit answers", true);
                
	}
        
        @Test
	public void TestStep_07_VerifyNextButton() {
            Reporter.log( "Test_07 : Verify the next button", true);
		// Next Button
		System.out.println("Test Name: VerifyNextButton");
		test.MTXIntroAndQuickPrepPage.VerifyNextButton();
                Reporter.log(user + "successfully verified the next button", true);
	}
        
        @Test
	public void TestStep_08_VerifyAndSubmitForGrading() {
            Reporter.log( "Test_08 :Verify And Submit For Grading ", true);
		// Submit for Grading
		System.out.println("Test Name: VerifySubmitAndForGrading");
		test.MTXIntroAndQuickPrepPage.VerifySubmitForGrading();
                Reporter.log(user + "successfully verified and submitted for grading", true);
	}
        
         
        
        //@Test
	public void TestStep_9_DeletePreviousTake() {
		// Delete Previous Take
                Reporter.log( "Test_09 : Delete previous take", true);
		System.out.println("Test Name: DeletePreviousTake");
		test.MTXDashBoardPage.clickOnAppByName("Progress");
                test.MTXFramePage.switchToDockIFrame(ProgressTitle);
                test.studentTakeDeletePage.DeleteActivityTakes(StudentName);
                test.MTXDashBoardPage.closeOpenApp();
                Reporter.log(user + "successfully deletes the previous take", true);
	}
        
        @Test
	public void TestStep_10_ClickCrossButton() {
		// Close the Review Page
                Reporter.log( "Test_10 : click the cross button", true);
		System.out.println("Test Name: VerifyClickCrossButtonToCancel");
		test.MTXActivityPage.VerifyClickCrossButton();
                Reporter.log(user + "successfully clicked the cross button", true);
	}
        
        
        @Test
	public void TestStep_11_VerifyScoreInStudentGradebook() {
		// Score in Current Course Score
		Reporter.log("Test_11: Verify Score In Student Gradebook",true);
		test.MTXDashBoardPage.clickOnAppByName("Progress");
                test.MTXFramePage.switchToDockIFrame(ProgressTitle);
                test.studentTakeDeletePage.studentScores("1 Introduction and Quick Prep", ChemistryReviewActivity, StudentName);
                test.MTXDashBoardPage.closeOpenApp();
                Reporter.log(user + "successfully verified score In Student Gradebook ", true);
	}
        
        @Test
	public void TestStep_12_VerifyActivityInReviewMode() {
		// Review Mode
		Reporter.log("Test_12: Verify Activity In Review Mode",true);
                test.MTXActivityPage.clickOnIntroQuickPrep();
                test.MTXActivityPage.verifyActivityLaunchInReviewMode();
                test.MTXActivityPage.clickReviewButton();
                test.MTXFramePage.switchToMainFrame();
                test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
                test.MTXActivityPage.verifySubmitANswerAvailinReviewMode();
                test.MTXIntroAndQuickPrepPage.VerifyActivityInReviewMode();
                test.MTXFramePage.switchToDefaultContent();
                test.MTXActivityPage.activityOverviewButton();
                test.MTXActivityPage.closeActivity();
                Reporter.log(user + "successfully verified activity In review mode", true);
	}
       

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
    
    @AfterClass(alwaysRun = true)
        public void stop_test_session() {
        test.closeTestSession();
    }
    
    @BeforeMethod
 public void init() {
  System.out.println("\n\n__________________________________________________________________________");
 }
    
}
