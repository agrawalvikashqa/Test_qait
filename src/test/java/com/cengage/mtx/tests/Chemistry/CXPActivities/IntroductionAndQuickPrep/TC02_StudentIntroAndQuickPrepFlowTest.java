package com.cengage.mtx.tests.Chemistry.CXPActivities.IntroductionAndQuickPrep;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import static com.qait.automation.utils.YamlReader.getData;

public class TC02_StudentIntroAndQuickPrepFlowTest {
  
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
	public void TestStep_02_VerifyIntroAndQuickPrepActivityStatusIconAsNotStartedInWeekView() {
		// Not Started Status Indicator of introduction and quick prep activity
		Reporter.log("Test Name: verifyNotStartedStatusIndicatorOfTutoredActivity",true);
                test.weekwidgetPage.navigateToWeek(getData("Books.courseChemistry.weeknumber"));
                test.MTXIntroAndQuickPrepPage.FetchClassAverageFromClassAverageWidget();
                currentScore= test.MTXIntroAndQuickPrepPage.FetchCurrentScoreFromCurrentScoreWidget();
		test.weekwidgetPage.verifyNotStartedStatusIconForActivity("Introduction and Quick Prep");
	}
    @Test
	public void TestStep_03_LaunchInstructoropenIntroQuickPrepActivity() {
		// introduction and quick prep activity
		Reporter.log("Test Name: verifyInstructorIntroAndQuickPrepActivity",true);
		test.weekwidgetPage.navigateToWeek(getData("Books.courseChemistry.weeknumber"));
		test.MTXActivityPage.clickOnIntroQuickPrep();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXIntroAndQuickPrepPage.verifyPreparationTabIsPresentForIntroAndQuickPrep();
	}
    @Test
	public void TestStep_04_VerifyBackButton() {
		// Back Button
		Reporter.log("Test Name: VerifyBackButton",true);
		test.MTXIntroAndQuickPrepPage.VerifyBackButton("This unit introduces atoms and molecules");
	}
    @Test
	public void TestStep_05_VerifyDueDatAndTime() {
		// Due Date and Time
		Reporter.log("Test Name: verifyactivityDateInIntroAndQuickPrepActivity",true);
		test.MTXActivityPage.activityDate();
	}
    @Test
	public void TestStep_06_VerifyCurrentScore() {
		// Current Score
		Reporter.log("Test Name: verifyCurrentScorePresentForIntroAndQuickPrep",true);
		test.MTXIntroAndQuickPrepPage.verifyCurrentScorePresentForIntroAndQuickPrep();
	}
    @Test
	public void TestStep_07_ClickOnSubmitAnswer() {
		// Current Score
		Reporter.log("Test Name: ClickOnSubmitAnswer",true);
		test.MTXIntroAndQuickPrepPage.verifyAttemptQuestions();
                test.MTXIntroAndQuickPrepPage.submitAnswerButton();
                test.MTXIntroAndQuickPrepPage.getTitleOfFeedback();
                test.MTXIntroAndQuickPrepPage.VerifyAttemptsAndTryAnotherVersion();
	}
    @Test
	public void TestStep_08_VerifyNextButton() {
		// Next Button
		Reporter.log("Test Name: VerifyNextButton",true);
		test.MTXIntroAndQuickPrepPage.VerifyNextButton();
	}
       
    @Test
	public void TestStep_09_VerifyIntroAndQuickPrepActivityInProgressStatusIconInWeekView() {
            Reporter.log("Test Name: verifyInProgressStatusIndicatorOfIntroductionActivity",true);
                test.MTXActivityPage.clickOnCloseActivity();
		test.weekwidgetPage.verifyActivityInProgressIcon("Introduction and Quick Prep");
	}
    @Test
	public void TestStep_10_VerifySubmitForGrading() {
		// Submit for Grading
		Reporter.log("Test Name: VerifySubmitForGrading",true);
                test.MTXActivityPage.clickOnIntroQuickPrep();
                scoreFromActivity = test.MTXIntroAndQuickPrepPage.VerifySubmitForGrading();
                test.MTXIntroAndQuickPrepPage.VerifyActivitySubmission();
	}
    @Test
        // Submit for Grading
	public void TestStep_11_VerifyCompletedStatusIconForIntroductionandQuickPrepActivityInWeekView() {
            Reporter.log("Test Name: verifySubmittedStatusIndicatorOfIntroductionActivity",true);
		test.weekwidgetPage.verifyStausDisplayAsCompleted("Introduction and Quick Prep");
	}
    @Test
	public void TestStep_12_VerifyScoreInCurrentCourseScore() {
		// Score in Current Course Score
		Reporter.log("Test Name: VerifyScoreInCurrentCourseScore",true);
		test.MTXIntroAndQuickPrepPage.VerifyCurrentScoreFromCurrentScoreWidget(currentScore);
	}
    @Test
	public void TestStep_13_VerifyScoreInClassAverageScore() {
		// Score in Current Course Score
		Reporter.log("Test Name: VerifyScoreInClassAverageScore",true);
		test.MTXIntroAndQuickPrepPage.VerifyClassAverageFromClassAverageWidget();
	}
    //@Test
	public void TestStep_14_VerifyPerformanceDotInPerformanceWidget() {
		// Performance Dot In Performance Widget
		Reporter.log("Test Name: PerformanceDotInPerformanceWidget",true);
		test.MTXActivityPage.verifyPerformanceDots();
	}
    @Test
	public void TestStep_15_VerifyScoreInStudentGradebook() {
		// Score in Current Course Score
		Reporter.log("Test Name: VerifyScoreInStudentGradebook",true);
		test.MTXDashBoardPage.clickOnAppByName("Progress");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.ProgressTitle"));
                test.studentTakeDeletePage.studentScores("1 Introduction and Quick Prep", scoreFromActivity, getData("Books.courseChemistry.studentName"));
                test.MTXDashBoardPage.closeOpenApp();
	}
        @Test
	public void TestStep_16_VerifyActivityInReviewMode() {
		// Review Mode
		Reporter.log("Test Name: VerifyActivityInReviewMode",true);
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
