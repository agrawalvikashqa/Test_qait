package com.cengage.mtx.tests.Chemistry.CXPActivities.SurveyActivity;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

public class TC02_StudentSurveyActivityFlowTest {
    
    TestSessionInitiator test;
        String user;
        String preCourseSurveyActivity = getData("Books.courseChemistry.preCourseSurveyActivity");
        String ProgressTitle = "Progress";
        String StudentName = "qad, student";
        String currentScore=null;
        
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Student Survey Test");
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
	public void TestStep_02_StudentLaunchSurveyActivityandVerifyUI() {
		
            System.out.println("Test Name: verifyStudentSystemSetUpActivity");
            test.weekwidgetPage.navigateToWeek("Week 45");
            test.MTXActivityPage.launchActivityfromWeekView(preCourseSurveyActivity);
            test.MTXActivityPage.getTitleOfActivity();
            test.MTXActivityPage.activityDate();
            test.MTXFramePage.switchToMainFrame();
            test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
            test.MTXIntroAndQuickPrepPage.VerifyBackButton("This is a survey activity.");
            test.MTXIntroAndQuickPrepPage.verifyCurrentScorePresentForIntroAndQuickPrep();
            test.MTXIntroAndQuickPrepPage.VerifyNextButton();
        }
        @Test
    public void TestStep_03_VerifySystemSetupActivityInProgressStatusIconInWeekView() {
            Reporter.log("Test Name: verifyInProgressStatusIndicatorOfSurveyActivity",true);
                test.MTXActivityPage.clickOnCloseActivity();
		test.weekwidgetPage.verifyActivityInProgressIcon(preCourseSurveyActivity);
	}
        
       
      @Test
	public void TestStep_04_StudentSubmitActivity() {
		
            System.out.println("Test Name: InstructorSubmitSystemSetUpActivity");
            test.weekwidgetPage.navigateToWeek("Week 45");
            test.MTXActivityPage.launchActivityfromWeekView(preCourseSurveyActivity);
            test.MTXFramePage.switchToMainFrame();
            test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
            test.MTXIntroductionActivityPage.clickOnQuestionTab();
            test.MTXChemSurveyPage.clickOnSurveyLink();
            test.MTXChemSurveyPage.verifySurveyPageAppears();
            test.MTXFramePage.switchToMainFrame();
            test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
            test.MTXChemSurveyPage.enterSurveyCode();
            test.MTXMathReviewPage.clickOnSubmitAnswerButton();
            test.MTXMathReviewPage.clickOnSubmitButtonPresentInNavPanel();
            test.MTXMathReviewPage.clickOnSubmitActivityForGradingButton();
                
		
	}
        
     @Test
        public void TestStep_05_VerifyCompletedStatusIconForSurveyActivityInWeekView() {
            test.MTXFramePage.switchToDefaultContent();
            test.weekwidgetPage.verifyStausDisplayAsCompleted(preCourseSurveyActivity);
	}
        
        @Test
	public void TestStep_06_StudentReviewActivity() {
            test.weekwidgetPage.navigateToWeek("Week 45");
            test.MTXActivityPage.launchActivityfromWeekView(preCourseSurveyActivity);
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
            test.studentTakeDeletePage.studentActivityScore(preCourseSurveyActivity);
            test.MTXDashBoardPage.closeOpenApp();
	}
        
      //  @Test
         public void TestStep_08_VerifyScoreInCurrentCourseScore() {
		// Score in Current Course Score
            Reporter.log("Test Name: VerifyScoreInCurrentCourseScore",true);
            test.MTXIntroAndQuickPrepPage.VerifyCurrentScoreFromCurrentScoreWidget(currentScore);
	}
    
         @Test
	public void TestStep_09_VerifyPerformanceDotInPerformanceWidget() {
		// Performance Dot In Performance Widget
		Reporter.log("Test Name: PerformanceDotInPerformanceWidget",true);
		test.MTXActivityPage.verifyPerformanceDots();
	}
    
      //  @Test
        public void TestStep_10_VerifyScoreInClassAverageScore() {
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
