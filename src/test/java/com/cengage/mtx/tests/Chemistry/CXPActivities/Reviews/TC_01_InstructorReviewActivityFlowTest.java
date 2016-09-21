/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.Chemistry.CXPActivities.Reviews;

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

public class TC_01_InstructorReviewActivityFlowTest {
    
    TestSessionInitiator test;
        String user;
        String ProgressTitle = "Progress";
        String StudentName = "qad, student";
        
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Smoke Test");
        user = System.getProperty("user", "instructor");
        
    }

	@Test
    public void TestStep_01_LoginToSSOApplication() {
        Reporter.log( "Test_01 : Login to SSO Application", true);
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseChemistry.courseKey"),getData("Books.courseChemistry.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    @Test
	public void TestStep_02_LaunchInstructorReviewActivityFlowTest() {
		// Instructor Review Activity FlowTest
                Reporter.log( "Test_02 : Launch Instructor Review Activity Flow Test", true);
		System.out.println("Test Name: verifyInstructorReviewActivityFlowTest");
		test.weekwidgetPage.navigateToWeek("Week 44");
		test.MTXActivityPage.clickOnReview();
		test.MTXActivityPage.getTitleOfActivity();
		//test.MTXIntroAndQuickPrepPage.verifyPreparationTabIsPresentForIntroAndQuickPrep();
                Reporter.log(user + "successfully launches Instructor Review Activity", true);
	}
        
        @Test
	public void TestStep_03_SelectDropDownAnswers() {
		// Select Drop Down Answers
                Reporter.log( "Test_03 : Select Answers from dropdown", true);
		System.out.println("Test Name: Verify DropDown Answers");
		test.MTXActivityPage.selectDropDownAnswers();
                Reporter.log(user + "successfully selects drop down answers", true);
        
        }
        
        @Test
	public void TestStep_04_VerifyBackButton(){
		// Back Button
                Reporter.log( "Test_04 : Verify back button", true);
		System.out.println("Test Name: VerifyBackButton");
		test.MTXIntroAndQuickPrepPage.VerifyBackButton();
                Reporter.log(user + "successfully verified the back button", true);
	}
        
       
        
               
        @Test
	public void TestStep_05_ClickOnSubmitAnswer() {
		// Current Score
                Reporter.log( "Test_05 : click on submit answer", true);
		System.out.println("Test Name: ClickOnSubmitAnswer");
		test.MTXIntroAndQuickPrepPage.submitAnswerButton();
                Reporter.log(user + "successfully clicks on submit answers", true);
                
	}
        
        @Test
	public void TestStep_06_VerifyNextButton() {
		// Next Button
                Reporter.log( "Test_06 : Verify the next button", true);
		System.out.println("Test Name: VerifyNextButton");
		test.MTXIntroAndQuickPrepPage.VerifyNextButton();
                Reporter.log(user + "successfully verified the next button", true);
                
	}
        
        @Test
	public void TestStep_07_VerifyAndSubmitForGrading() {
		// Submit for Grading
                Reporter.log( "Test_07 : Verify and submit for grading", true);
		System.out.println("Test Name: VerifySubmitAndForGrading");
		test.MTXIntroAndQuickPrepPage.VerifySubmitForGrading();
                Reporter.log(user + "successfully verified and submitted for grading", true);
	}
        
         
        
        //@Test
	public void TestStep_08_DeletePreviousTake() {
		// Delete Previous Take
                Reporter.log( "Test_08 : Verify Instructor is able to delete the previous take ", true);
		System.out.println("Test Name: DeletePreviousTake");
		test.MTXDashBoardPage.clickOnAppByName("Progress");
                test.MTXFramePage.switchToDockIFrame(ProgressTitle);
                test.studentTakeDeletePage.DeleteActivityTakes(StudentName);
                test.MTXDashBoardPage.closeOpenApp();
                Reporter.log(user + "successfully able to delete the previous take", true);
	}
        
        @Test
	public void TestStep_10_ClickCrossButton() {
		// Close the Review Page
                Reporter.log( "Test_09 : click on cross button", true);
		System.out.println("Test Name: VerifyClickCrossButtonToCancel");
		test.MTXActivityPage.VerifyClickCrossButton();
                Reporter.log(user + "successfully clicked the cross button", true);
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

    
