/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.Chemistry.CXPActivities.ConceptualTutored;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;
import org.testng.annotations.AfterClass;

public class TC03_StudentConceptualTutoredFlowTest {
    
    TestSessionInitiator test;
        String user;
        String scoreFromActivity =null;
        String currentScore=null;
        
    @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Smoke Test");
        user = System.getProperty("user", "student");
        
    }

	/**
	 * TC001_login to the sso front door.
	 */
    @Test
        public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseChemistry.courseKey"),getData("Books.courseChemistry.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
        @Test
	public void TestStep_02_VerifyTutoredActivityStatusIconAsNotStartedInWeekView() {
            Reporter.log("Test Name: verifyNotStartedStatusIndicatorOfTutoredActivity",true);
		test.weekwidgetPage.navigateToWeek("Week 44");
		test.weekwidgetPage.verifyNotStartedStatusIconForActivity(getData("Books.courseChemistry.activityTutoredRegression"));
        }
         @Test
	public void TestStep_03_LaunchInstructorConceptualTutoredActivity() {
		// introduction and quick prep activity
		Reporter.log("Test Name: LaunchInstructorConceptualTutoredActivity", true);
		test.weekwidgetPage.navigateToWeek(getData("Books.courseChemistry.weeknumber"));
		test.MTXActivityPage.clickOnTutoredActivity(getData("Books.courseChemistry.activityTutoredRegression"));
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.verifySubmitLinkIsPresent();
	}
        @Test
	public void TestStep_04_VerifyDueDatAndTime() {
		// Due Date and Time
		Reporter.log("Test Name: VerifyDueDatAndTime", true);
		test.MTXActivityPage.activityDate();
	}
        @Test
	public void TestStep_05_verifyCurrentScoreInConceptualTutored() {
		// Due Date and Time
		Reporter.log("Test Name: verifyCurrentScoreInConceptualTutored", true);
		test.MTXConceptualTutoredPage.verifyCurrentScoreInConceptualTutored();
	}
        @Test
	public void TestStep_06_StartActivity() {
		// Due Date and Time
		Reporter.log("Test Name: clickOnStartActivityForTutored", true);
		test.MTXActivityPage.clickOnStartActivityForTutored();
                test.MTXActivityPage.clickOnCloseActivity();
	}
        @Test
        public void TestStep_07_VerifyTutoredActivityInProgressStatusIconInWeekView() {
            Reporter.log("Test Name: verifyInProgressStatusIndicatorOfTutoredActivity",true);
                test.weekwidgetPage.verifyActivityInProgressIcon(getData("Books.courseChemistry.activityTutoredRegression"));
	}
        @Test
	public void TestStep_08_SubmitActivityWithUnAttemptedQuestions() {
		// Due Date and Time
		Reporter.log("Test Name: AttemptQuestions", true);
                test.MTXActivityPage.clickOnTutoredActivity(getData("Books.courseChemistry.activityTutoredRegression"));
		test.MTXConceptualTutoredPage.verifyUnAttemptedQuestionWarning();
	}
        @Test
	public void TestStep_09_ClickOnSubmitAnswer() {
		// Current Score
		Reporter.log("Test Name: ClickOnSubmitAnswer",true);
                test.MTXConceptualTutoredPage.verifyOpenCloseButtons();
		test.MTXConceptualTutoredPage.AttemptTutoredActivity();
                test.MTXConceptualTutoredPage.submitAnswer();
                test.MTXConceptualTutoredPage.getTitleOfFeedback();
                test.MTXConceptualTutoredPage.checkRejoindersOfQuestions();
                test.MTXConceptualTutoredPage.verifyTutorMeButton();
	}
        @Test
	public void TestStep_10_VerifyScoreInActivityPane() {
		// Current Score
		Reporter.log("Test Name: VerifyScoreInActivityPane",true);
                scoreFromActivity = test.MTXConceptualTutoredPage.verifyScore();
                test.MTXConceptualTutoredPage.submitActivity();
        }
        @Test
	public void TestStep_11_VerifyCompletedStatusIconForConceptualTutoredActivityInWeekView() {
            Reporter.log("Test Name: verifySubmittedStatusIndicatorOfTutoredActivity",true);
		test.weekwidgetPage.verifyStausDisplayAsCompleted(getData("Books.courseChemistry.activityTutoredRegression"));
	}
        @Test
	public void TestStep_12_VerifyScoreInStudentGradebook() {
		// Score in Current Course Score
		Reporter.log("Test Name: VerifyScoreInStudentGradebook",true);
		test.MTXDashBoardPage.clickOnAppByName("Progress");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.ProgressTitle"));
                test.studentTakeDeletePage.studentScores(getData("Books.courseChemistry.activityTutoredRegression"), scoreFromActivity, getData("Books.courseChemistry.studentName"));
                test.MTXDashBoardPage.closeOpenApp();
	}
        @Test
	public void TestStep_13_VerifyActivityInReviewMode() {
		// Review Mode
		Reporter.log("Test Name: VerifyActivityInReviewMode",true);
                test.MTXActivityPage.clickOnTutoredActivity(getData("Books.courseChemistry.activityTutoredRegression"));
                test.MTXActivityPage.verifyActivityLaunchInReviewMode();
                test.MTXActivityPage.clickReviewButton();
                test.MTXFramePage.switchToMainFrame();
                test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
                test.MTXActivityPage.CheckforSUbmitAnswerNotAppearInReviewModeTutored();
                test.MTXFramePage.switchToDefaultContent();
                test.MTXActivityPage.closeActivity();
	}
    @BeforeMethod
	public void init() {
		System.out.println("\n\n__________________________________________________________________________");
	}

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
    @AfterClass
	public void tearDownClass() throws Exception {
		test.closeBrowserSession();
		System.out.println("###########################################################################################");
		System.out.println("########################################################################################### \n\n");
	}
        
    
}
