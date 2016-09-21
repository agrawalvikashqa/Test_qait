package com.cengage.mtx.tests.Chemistry.CXPActivities.IntroductionActiivty;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

public class TC02_StudentIntroductionSystemSetUpActiivtyFlowTest {
    
    TestSessionInitiator test;
        String user;
        String systemSetupActivity = getData("Books.courseChemistry.activitySystemSetUp");
        String currentScore=null;
        
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Student SystemSetUp Test");
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
	public void TestStep_02_StudentLaunchSystemSetUpActivityandVerifyUI() {
		
            System.out.println("Test Name: verifyStudentSystemSetUpActivity");
            test.weekwidgetPage.navigateToWeek("Week 45");
            test.MTXActivityPage.launchActivityfromWeekView(systemSetupActivity);
            test.MTXActivityPage.getTitleOfActivity();
            test.MTXActivityPage.activityDate();
            test.MTXFramePage.switchToMainFrame();
            test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
           // test.MTXIntroductionActivityPage.verifyPreparationTabIsSelected();
            test.MTXIntroAndQuickPrepPage.VerifyBackButton("Welcome to");
            test.MTXIntroAndQuickPrepPage.verifyCurrentScorePresentForIntroAndQuickPrep();
            test.MTXIntroAndQuickPrepPage.VerifyNextButton();
            test.MTXIntroductionActivityPage.clickOnPrepTab();
        }
        
        @Test
    public void TestStep_03_VerifySystemSetupActivityInProgressStatusIconInWeekView() {
            Reporter.log("Test Name: verifyInProgressStatusIndicatorOfSystemSetupActivity",true);
                test.MTXActivityPage.clickOnCloseActivity();
		test.weekwidgetPage.verifyActivityInProgressIcon(systemSetupActivity);
	}
       
       @Test
	public void TestStep_04_StudentSubmitActivity() {
		
            System.out.println("Test Name: StudentSubmitSystemSetUpActivity");
            test.weekwidgetPage.navigateToWeek("Week 45");
            test.MTXActivityPage.launchActivityfromWeekView(systemSetupActivity);
            test.MTXFramePage.switchToMainFrame();
            test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
            test.MTXIntroductionActivityPage.clickOnQuestionTab();
            test.MTXActivityPage.verifyChemattemptsRemainingBeforeSubmit();
            test.MTXQuizActivityPage.enterAnswers();
            test.MTXMathReviewPage.clickOnSubmitAnswerButton();
            test.MTXMathReviewPage.incorrectAnswerWarning();
            test.MTXActivityPage.verifyChemattemptsRemainingAfterSubmit();
            test.MTXMathReviewPage.clickOnNextButtonPresentatBottom();
            
            test.MTXMathReviewPage.clickOnSubmitButtonPresentInNavPanel();
            test.MTXMathReviewPage.clickOnSubmitActivityForGradingButton();
                
		
	}
        
        @Test
        public void TestStep_05_VerifyCompletedStatusIconForSystemSetUpActivityInWeekView() {
            test.MTXFramePage.switchToDefaultContent();
            test.weekwidgetPage.verifyStausDisplayAsCompleted(systemSetupActivity);
	}
        
        @Test
	public void TestStep_06_StudentReviewActivity() {
		
		
            test.weekwidgetPage.navigateToWeek("Week 45");
            test.MTXActivityPage.launchActivityfromWeekView(systemSetupActivity);
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
            test.MTXFramePage.switchToDockIFrame();
            test.studentTakeDeletePage.studentActivityScore(systemSetupActivity);
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
        
     
        
    @AfterClass(alwaysRun = true)
        public void stop_test_session() {
            test.closeTestSession();
    }

    @AfterMethod
        public void takeScreenshotonFailure(ITestResult result) {
            test.takescreenshot.takeScreenShotOnException(result);
    }
        
    
}
