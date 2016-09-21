
package com.cengage.mtx.tests.Chemistry.CXPActivities.ConceptualTutored;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TC02_InstructorConceptualTutoredFlowTest {
    
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
		test.MTXActivityPage.clickOnTutoredActivity(getData("Books.courseChemistry.activityTutored"));
        }
        
	public void TestStep_02_LaunchInstructorConceptualTutoredActivity() {
		// introduction and quick prep activity
		Reporter.log("Test Name: LaunchInstructorConceptualTutoredActivity", true);
		test.weekwidgetPage.navigateToWeek(getData("Books.courseChemistry.weeknumber"));
		test.MTXActivityPage.clickOnTutoredActivity(getData("Books.courseChemistry.activityTutoredRegression"));

		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.verifySubmitLinkIsPresent();
	}
        
        @Test
	public void TestStep_03_VerifyDueDatAndTime() {
		// Due Date and Time

		System.out.println("Test Name: verifyactivityDateInIntroAndQuickPrepActivity");
		test.MTXActivityPage.activityDate();
	}


        @Test
	public void TestStep_04_verifyCurrentScoreInConceptualTutored() {
		// Due Date and Time
		Reporter.log("Test Name: verifyCurrentScoreInConceptualTutored", true);
		test.MTXConceptualTutoredPage.verifyCurrentScoreInConceptualTutored();
	}
        @Test
	public void TestStep_05_StartActivity() {
		// Due Date and Time
		Reporter.log("Test Name: clickOnStartActivityForTutored", true);
		test.MTXActivityPage.clickOnStartActivityForTutored();
	}
        @Test
	public void TestStep_06_SubmitActivityWithUnAttemptedQuestions() {
		// Due Date and Time
		Reporter.log("Test Name: SubmitActivityWithUnAttemptedQuestions", true);
		test.MTXConceptualTutoredPage.verifyUnAttemptedQuestionWarning();
	}
        @Test
	public void TestStep_07_ClickOnSubmitAnswer() {
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
	public void TestStep_08_VerifyScoreInActivityPane() {
		// Current Score
		Reporter.log("Test Name: VerifyScoreInActivityPane",true);
                scoreFromActivity= test.MTXConceptualTutoredPage.verifyScore();
                test.MTXConceptualTutoredPage.submitActivity();
        }
        @Test
	public void TestStep_09_VerifyMultipleTakesForInstructor() {
		// Verify Multiple Takes For Instructor
		System.out.println("Test Name: VerifyMultipleTakesForInstructor");
                test.DashBoardPage.refreshPage();
		test.weekwidgetPage.navigateToWeek(getData("Books.courseChemistry.weeknumber"));
		test.MTXActivityPage.clickOnTutoredActivity(getData("Books.courseChemistry.activityTutoredRegression"));
                test.MTXActivityPage.getTitleOfActivity();
                test.MTXActivityPage.verifySubmitLinkIsPresent();
                test.MTXFramePage.switchToDefaultContent();
                test.MTXActivityPage.closeActivity();
	}
        @Test
	public void TestStep_10_VerifyScoreInInstructorGradebook() {
		// Verify Score In Instructor Gradebook
		Reporter.log("Test Name: VerifyScoreInInstructorGradebook",true);
		test.MTXDashBoardPage.clickOnAppByName("Progress");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.ProgressTitle"));
                test.studentTakeDeletePage.studentScores(getData("Books.courseChemistry.activityTutoredRegression"), scoreFromActivity, getData("Books.courseChemistry.studentName"));
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
