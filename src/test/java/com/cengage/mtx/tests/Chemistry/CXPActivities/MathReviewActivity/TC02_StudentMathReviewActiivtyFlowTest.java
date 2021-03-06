package com.cengage.mtx.tests.Chemistry.CXPActivities.MathReviewActivity;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

public class TC02_StudentMathReviewActiivtyFlowTest {
    
    TestSessionInitiator test;
        String user;
        String MathReviewActivity = getData("Books.courseChemistry.MathReviewActivity");
        String ProgressTitle = "Progress";
        String currentScore=null;
        
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Student Math Review Test");
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
		
		System.out.println("Test Name: verifyStudentMathReviewActivity");
		test.weekwidgetPage.navigateToWeek("Week 45");
                test.MTXIntroAndQuickPrepPage.FetchClassAverageFromClassAverageWidget();
                currentScore= test.MTXIntroAndQuickPrepPage.FetchCurrentScoreFromCurrentScoreWidget();
                test.MTXActivityPage.launchActivityfromWeekView(MathReviewActivity);
		test.MTXActivityPage.getTitleOfActivity();
                test.MTXActivityPage.activityDate();
                test.MTXFramePage.switchToMainFrame();
                test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
                test.MTXMathReviewPage.verifyNextButtonisPresentforMathReview();
                test.MTXMathReviewPage.verifyBackButtonisPresentforMathReview();
                test.MTXMathReviewPage.verifyCurrentScorePresentatBottomforMathReview();
                test.MTXMathReviewPage.verifynextButtonOnLeftPanelforMathReview();
                test.MTXMathReviewPage.verifyPreparationTabPresentforMathReview();
                test.MTXMathReviewPage.clickOnQuestionTab();
                test.MTXMathReviewPage.verifySubmitButtonPresent();
         }
        
         @Test
	public void TestStep_03_VerifyInProgressStatusIconInWeekView() {
            Reporter.log("Test Name: verifyInProgressStatusIndicatorOfIntroductionActivity",true);
                test.MTXFramePage.switchToDefaultContent();
                test.MTXActivityPage.clickOnCloseActivity();
                test.MTXDashBoardPage.refreshPage();
                test.weekwidgetPage.navigateToWeek("Week 45");
		test.weekwidgetPage.verifyActivityInProgressIcon(MathReviewActivity);
	}
       
        @Test
	public void TestStep_04_StudentSubmitActivity() {
		
		System.out.println("Test Name: StudentSubmitMathReviewActivity");
               // test.weekwidgetPage.navigateToWeek("Week 45");
                test.MTXActivityPage.launchActivityfromWeekView(MathReviewActivity);
                test.MTXActivityPage.getTitleOfActivity();
                test.MTXActivityPage.activityDate();
                test.MTXFramePage.switchToMainFrame();
                test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
                test.MTXMathReviewPage.verifyNextButtonisPresentforMathReview();
                test.MTXMathReviewPage.verifyBackButtonisPresentforMathReview();
                test.MTXMathReviewPage.verifyCurrentScorePresentatBottomforMathReview();
                test.MTXMathReviewPage.verifynextButtonOnLeftPanelforMathReview();
                test.MTXMathReviewPage.verifyPreparationTabPresentforMathReview();
                test.MTXMathReviewPage.clickOnQuestionTab();
               // test.MTXMathReviewPage.userEnterBlankAnswersandSubmit();
                test.MTXMathReviewPage.userEnterAnswers();
                test.MTXMathReviewPage.clickOnSubmitAnswerButton();
                test.MTXMathReviewPage.incorrectAnswerWarning();
                test.MTXMathReviewPage.clickOnSubmitButtonPresentInNavPanel();
                test.MTXMathReviewPage.clickOnSubmitActivityForGradingButton();
                test.MTXFramePage.switchToDefaultContent();
                test.MTXDashBoardPage.refreshPage();
                
       }
        
        @Test
	public void TestStep_05_StudentReviewActivity() {
		
		System.out.println("Test Name: StudentReviewMathReviewActivity");
                test.weekwidgetPage.navigateToWeek("Week 45");
                test.MTXActivityPage.launchActivityfromWeekView(MathReviewActivity);
                test.MTXActivityPage.submittedDecorator();
                test.MTXActivityPage.clickReviewButton();
                test.MTXFramePage.switchToMainFrame();
                
                test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
                test.MTXMathReviewPage.clickOnQuestionTab();
                test.MTXActivityPage.verifySubmitANswerAvailinReviewMode();
                //test.MTXActivityPage.submittedButton();
                test.MTXFramePage.switchToDefaultContent();
                test.MTXActivityPage.activityOverviewButton();
                
                test.MTXActivityPage.closeActivity();
                
		
        }
        
       @Test
	public void TestStep_06_VerifyScoreInStudentGradebook() {
		// Score in Current Course Score
		Reporter.log("Test Name: VerifyScoreInStudentGradebook",true);
                
		test.MTXDashBoardPage.clickOnAppByName("Progress");
                test.MTXFramePage.switchToDockIFrame(ProgressTitle);
                test.studentTakeDeletePage.studentActivityScore(MathReviewActivity);
                test.MTXDashBoardPage.closeOpenApp();
	}
        
         @Test
	public void TestStep_07_VerifyScoreInCurrentCourseScore() {
		// Score in Current Course Score
		Reporter.log("Test Name: VerifyScoreInCurrentCourseScore",true);
		test.MTXIntroAndQuickPrepPage.VerifyCurrentScoreFromCurrentScoreWidget(currentScore);
	}
       @Test
	public void TestStep_08_VerifyScoreInClassAverageScore() {
		// Score in Current Course Score
		Reporter.log("Test Name: VerifyScoreInClassAverageScore",true);
		test.MTXIntroAndQuickPrepPage.VerifyClassAverageFromClassAverageWidget();
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
