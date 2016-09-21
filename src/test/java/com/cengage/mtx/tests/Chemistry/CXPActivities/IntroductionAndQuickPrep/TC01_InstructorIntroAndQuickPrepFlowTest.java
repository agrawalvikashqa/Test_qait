package com.cengage.mtx.tests.Chemistry.CXPActivities.IntroductionAndQuickPrep;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import static com.qait.automation.utils.YamlReader.getData;

public class TC01_InstructorIntroAndQuickPrepFlowTest {
    
    TestSessionInitiator test;
        String user;
        static String scoreFromActivity =null;
        
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Smoke Test");
        user = System.getProperty("user", "instructor");
        
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
	public void TestStep_02_LaunchInstructoropenIntroQuickPrepActivity() {
		// introduction and quick prep activity
		System.out.println("Test Name: verifyInstructorIntroAndQuickPrepActivity");
		test.weekwidgetPage.navigateToWeek(getData("Books.courseChemistry.weeknumber"));
		test.MTXActivityPage.clickOnIntroQuickPrep();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXIntroAndQuickPrepPage.verifyPreparationTabIsPresentForIntroAndQuickPrep();
	}
        @Test
	public void TestStep_03_VerifyBackButton() {
		// Back Button
		System.out.println("Test Name: VerifyBackButton");
		test.MTXIntroAndQuickPrepPage.VerifyBackButton("This unit introduces atoms and molecules");
	}
        @Test
	public void TestStep_04_VerifyDueDatAndTime() {
		// Due Date and Time
		System.out.println("Test Name: verifyactivityDateInIntroAndQuickPrepActivity");
		test.MTXActivityPage.activityDate();
	}
        @Test
	public void TestStep_05_VerifyCurrentScore() {
		// Current Score
		System.out.println("Test Name: verifyCurrentScorePresentForIntroAndQuickPrep");
		test.MTXIntroAndQuickPrepPage.verifyCurrentScorePresentForIntroAndQuickPrep();
	}
        @Test
	public void TestStep_06_ClickOnSubmitAnswer() {
		// Current Score
		System.out.println("Test Name: ClickOnSubmitAnswer");
		test.MTXIntroAndQuickPrepPage.verifyAttemptQuestions();
                test.MTXIntroAndQuickPrepPage.submitAnswerButton();
                test.MTXIntroAndQuickPrepPage.getTitleOfFeedback();
                test.MTXIntroAndQuickPrepPage.VerifyAttemptsAndTryAnotherVersion();
	}
        @Test
	public void TestStep_07_VerifyNextButton() {
		// Next Button
		System.out.println("Test Name: VerifyNextButton");
		test.MTXIntroAndQuickPrepPage.VerifyNextButton();
	}
        
        @Test
	public void TestStep_08_VerifySubmitForGrading() {
		// Submit for Grading
		System.out.println("Test Name: VerifySubmitForGrading");
		scoreFromActivity = test.MTXIntroAndQuickPrepPage.VerifySubmitForGrading();
                test.MTXIntroAndQuickPrepPage.VerifyActivitySubmission();
	}
        @Test
	public void TestStep_09_VerifyMultipleTakesForInstructor() {
		// Verify Multiple Takes For Instructor
		System.out.println("Test Name: VerifyMultipleTakesForInstructor");
                test.DashBoardPage.refreshPage();
		test.weekwidgetPage.navigateToWeek(getData("Books.courseChemistry.weeknumber"));
		test.MTXActivityPage.clickOnIntroQuickPrep();
		test.MTXActivityPage.getTitleOfActivity();
                test.MTXIntroAndQuickPrepPage.verifyMultipleTakes();
                test.MTXFramePage.switchToDefaultContent();
                test.MTXActivityPage.closeActivity();
	}
        @Test
	public void TestStep_09_VerifyScoreInInstructorGradebook() {
		// Score in Current Course Score
		Reporter.log("Test Name: VerifyScoreInStudentGradebook",true);
		test.MTXDashBoardPage.clickOnAppByName("Progress");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.ProgressTitle"));
                test.studentTakeDeletePage.studentScores("1 Introduction and Quick Prep", scoreFromActivity, getData("Books.courseChemistry.studentName"));
                test.MTXDashBoardPage.closeOpenApp();
	}
        @Test
	public void TestStep_10_DeletePreviousTake() {
		// Delete Previous Take
		System.out.println("Test Name: DeletePreviousTake");
		test.MTXDashBoardPage.clickOnAppByName("Progress");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.ProgressTitle"));
                test.studentTakeDeletePage.DeleteActivityTakes(getData("Books.courseChemistry.studentName"));
                test.MTXDashBoardPage.closeOpenApp();
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
