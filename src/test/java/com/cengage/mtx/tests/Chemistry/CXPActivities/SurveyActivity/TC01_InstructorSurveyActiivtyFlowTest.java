package com.cengage.mtx.tests.Chemistry.CXPActivities.SurveyActivity;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

public class TC01_InstructorSurveyActiivtyFlowTest {
    
    TestSessionInitiator test;
        String user;
        String preCourseSurveyActivity = getData("Books.courseChemistry.preCourseSurveyActivity");
        String ProgressTitle = "Progress";
        String StudentName = "qad, student";
        
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Instructor Survey Test");
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
	public void TestStep_02_InstructorLaunchSurveyActivityandVerifyUI() {
		
            System.out.println("Test Name: verifyInstructorSystemSetUpActivity");
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
	public void TestStep_03_InstructorSubmitActivity() {
		
            System.out.println("Test Name: InstructorSubmitSystemSetUpActivity");
            test.MTXIntroductionActivityPage.clickOnQuestionTab();
            test.MTXChemSurveyPage.clickOnSurveyLink();
            test.MTXChemSurveyPage.verifySurveyPageAppears();
            //test.MTXChemSurveyPage.clickOnNextButtonOnSurveyPage();
            //test.MTXChemSurveyPage.alertAcceptOnSurveyPage();
            test.MTXFramePage.switchToMainFrame();
            test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
            test.MTXChemSurveyPage.enterSurveyCode();
            test.MTXMathReviewPage.clickOnSubmitAnswerButton();
            test.MTXMathReviewPage.clickOnSubmitButtonPresentInNavPanel();
            test.MTXMathReviewPage.clickOnSubmitActivityForGradingButton();
                
		
	}
        
     @Test
	public void TestStep_04_InstructorReSubmitActivity() {
		
            System.out.println("Test Name: InstructorReSubmitSystemSetUpActivity");
            test.MTXFramePage.switchToDefaultContent();
            test.MTXDashBoardPage.refreshPage();
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
