package com.cengage.mtx.tests.Chemistry.CXPActivities.QuizActivity;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

public class TC01_InstructorQuizActiivtyFlowTest {
    
    TestSessionInitiator test;
        String user;
        String QuizActivity = getData("Books.courseChemistry.QuizActivity");
        String ProgressTitle = "Progress";
        String StudentName = "qad, student";
        
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Instructor Math Review Test");
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
    
  // @Test
	public void TestStep_02_InstructorLaunchQuizActivityandVerifyUI() {
		
            System.out.println("Test Name: verifyInstructorQuizActivity");
            test.weekwidgetPage.navigateToWeek("Week 45");
            test.MTXActivityPage.launchActivityfromWeekView(QuizActivity);
            test.MTXActivityPage.getTitleOfActivity();
            test.MTXActivityPage.activityDate();
            test.MTXFramePage.switchToMainFrame();
            test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
            test.MTXMathReviewPage.verifyNextButtonisPresentforMathReview();
            test.MTXMathReviewPage.verifyBackButtonisPresentforMathReview();
            test.MTXMathReviewPage.verifyCurrentScorePresentatBottomforMathReview();
        }
       
     //  @Test
	public void TestStep_03_InstructorSubmitActivity() {
		
            System.out.println("Test Name: InstructorSubmitQuizActivity");
            test.MTXQuizActivityPage.enterAnswers();
            test.MTXMathReviewPage.clickOnSubmitAnswerButton();
            test.MTXMathReviewPage.incorrectAnswerWarning();
            test.MTXMathReviewPage.clickOnNextButtonPresentatBottom();
            test.MTXQuizActivityPage.enterAnswers();
            test.MTXIntroAndQuickPrepPage.submitAnswerButton();
            test.MTXMathReviewPage.incorrectAnswerWarning();
            test.MTXMathReviewPage.clickOnSubmitButtonPresentInNavPanel();
            test.MTXMathReviewPage.clickOnSubmitActivityForGradingButton();
                
		
	}
        
    // @Test
	public void TestStep_04_InstructorReSubmitActivity() {
		
            System.out.println("Test Name: InstructorReSubmitQuizActivity");
            test.MTXFramePage.switchToDefaultContent();
            test.MTXDashBoardPage.refreshPage();
            test.weekwidgetPage.navigateToWeek("Week 45");
            test.MTXActivityPage.launchActivityfromWeekView(QuizActivity);
            test.MTXFramePage.switchToMainFrame();
            test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
            test.MTXQuizActivityPage.enterAnswers();
            test.MTXIntroAndQuickPrepPage.submitAnswerButton();
            test.MTXMathReviewPage.incorrectAnswerWarning();
            test.MTXMathReviewPage.clickOnSubmitButtonPresentInNavPanel();
            test.MTXMathReviewPage.clickOnSubmitActivityForGradingButton();
                
		
        }
        
        @Test
	public void TestStep_05_DeletePreviousTake() {
		// Delete Previous Take
		System.out.println("Test Name: DeletePreviousTake");
                test.MTXFramePage.switchToDefaultContent();
		test.MTXDashBoardPage.clickOnAppByName("Progress");
                test.MTXFramePage.switchToDockIFrame(ProgressTitle);
                test.studentTakeDeletePage.DeleteActivityTakes(StudentName);
                test.MTXDashBoardPage.closeOpenApp();
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
