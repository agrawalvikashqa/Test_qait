package com.cengage.mtx.tests.Chemistry.CXPActivities.QuizActivity;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

public class TC02_StudentQuizActiivtyFlowTest {
    
    TestSessionInitiator test;
        String user;
        String QuizActivity = getData("Books.courseChemistry.QuizActivity");
        String currentScore=null;
        
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Instructor Math Review Test");
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
    public void TestStep_02_StudentLaunchMathReviewActivityandVerifyUI() {
		
        System.out.println("Test Name: verifyStudentQuizActivity");
        test.weekwidgetPage.navigateToWeek("Week 45");
        test.MTXIntroAndQuickPrepPage.FetchClassAverageFromClassAverageWidget();
        currentScore= test.MTXIntroAndQuickPrepPage.FetchCurrentScoreFromCurrentScoreWidget();
            test.MTXActivityPage.launchActivityfromWeekView(QuizActivity);
            test.MTXActivityPage.getTitleOfActivity();
            test.MTXActivityPage.activityDate();
            test.MTXFramePage.switchToMainFrame();
            test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
            test.MTXMathReviewPage.verifyNextButtonisPresentforMathReview();
            test.MTXMathReviewPage.verifyBackButtonisPresentforMathReview();
            test.MTXMathReviewPage.verifyCurrentScorePresentatBottomforMathReview();
        }
    
    @Test
    public void TestStep_03_VerifyQuizActivityInProgressStatusIconInWeekView() {
            Reporter.log("Test Name: verifyInProgressStatusIndicatorOfQuizActivity",true);
                test.MTXActivityPage.clickOnCloseActivity();
		test.weekwidgetPage.verifyActivityInProgressIcon(QuizActivity);
	}
       
    @Test
	public void TestStep_04_StudentSubmitActivity() {
		
            System.out.println("Test Name: StudentSubmitQuizActivity");
            test.MTXActivityPage.launchActivityfromWeekView(QuizActivity);
            test.MTXFramePage.switchToMainFrame();
            test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
            test.MTXQuizActivityPage.enterAnswers();
            test.MTXMathReviewPage.clickOnSubmitAnswerButton();
            test.MTXMathReviewPage.incorrectAnswerWarning();
            test.MTXMathReviewPage.clickOnNextButtonPresentatBottom();
            test.MTXQuizActivityPage.enterAnswers();
            test.MTXQuizActivityPage.verifyattemptsRemainingBeforeSubmit();
            test.MTXIntroAndQuickPrepPage.submitAnswerButton();
            test.MTXMathReviewPage.incorrectAnswerWarning();
            test.MTXQuizActivityPage.verifyattemptsRemainingAfterSubmit();
            test.MTXMathReviewPage.clickOnSubmitButtonPresentInNavPanel();
            test.MTXMathReviewPage.clickOnSubmitActivityForGradingButton();
                
		
	}
        
   
        
    @Test
        public void TestStep_05_VerifyCompletedStatusIconForQuizActivityInWeekView() {
            test.MTXFramePage.switchToDefaultContent();
            test.weekwidgetPage.verifyStausDisplayAsCompleted(QuizActivity);
	}
        
        
        
        
    @Test
	public void TestStep_06_StudentReviewActivity() {
		
		
            test.weekwidgetPage.navigateToWeek("Week 45");
            test.MTXActivityPage.launchActivityfromWeekView(QuizActivity);
            test.MTXActivityPage.submittedDecorator();
            test.MTXActivityPage.clickReviewButton();
            test.MTXFramePage.switchToMainFrame();
            test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
            test.MTXActivityPage.verifySubmitANswerAvailinReviewMode();
            test.MTXFramePage.switchToDefaultContent();
            test.MTXActivityPage.activityOverviewButton();
            test.MTXActivityPage.closeActivity();
                
		
        }
        
    @Test
    public void TestStep_07_VerifyScoreInStudentGradebook() {
		// Score in Current Course Score
            Reporter.log("Test Name: VerifyScoreInStudentGradebook",true);
            test.MTXDashBoardPage.clickOnAppByName("Progress");
            test.MTXFramePage.switchToDockIFrame(QuizActivity);
            test.studentTakeDeletePage.studentActivityScore(QuizActivity);
            test.MTXDashBoardPage.closeOpenApp();
	}
        
    @Test
    public void TestStep_08_VerifyScoreInCurrentCourseScore() {
		// Score in Current Course Score
            Reporter.log("Test Name: VerifyScoreInCurrentCourseScore",true);
            test.MTXIntroAndQuickPrepPage.VerifyCurrentScoreFromCurrentScoreWidget(currentScore);
	}
    
    
    @Test
    public void TestStep_09_VerifyScoreInClassAverageScore() {
		// Score in Current Course Score
            Reporter.log("Test Name: VerifyScoreInClassAverageScore",true);
            test.MTXIntroAndQuickPrepPage.VerifyClassAverageFromClassAverageWidget();
	}
        
  //  @AfterClass(alwaysRun = true)
        public void stop_test_session() {
            test.closeTestSession();
    }

    @AfterMethod
        public void takeScreenshotonFailure(ITestResult result) {
            test.takescreenshot.takeScreenShotOnException(result);
    }
        
    
}
