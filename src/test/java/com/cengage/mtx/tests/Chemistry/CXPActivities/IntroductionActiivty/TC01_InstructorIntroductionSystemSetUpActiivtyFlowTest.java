package com.cengage.mtx.tests.Chemistry.CXPActivities.IntroductionActiivty;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

public class TC01_InstructorIntroductionSystemSetUpActiivtyFlowTest {
    
    TestSessionInitiator test;
        String user;
        String systemSetupActivity = getData("Books.courseChemistry.activitySystemSetUp");
        String ProgressTitle = "Progress";
        String StudentName = "qad, student";
        
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Instructor SystemSetUp Test");
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
	public void TestStep_02_InstructorLaunchSystemSetUpActivityandVerifyUI() {
		
            System.out.println("Test Name: verifyInstructorSystemSetUpActivity");
            test.weekwidgetPage.navigateToWeek("Week 45");
            test.MTXActivityPage.launchActivityfromWeekView(systemSetupActivity);
            test.MTXActivityPage.getTitleOfActivity();
            test.MTXActivityPage.activityDate();
            test.MTXFramePage.switchToMainFrame();
            test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
            test.MTXIntroAndQuickPrepPage.VerifyBackButton("Welcome to");
            test.MTXIntroAndQuickPrepPage.verifyCurrentScorePresentForIntroAndQuickPrep();
            test.MTXIntroAndQuickPrepPage.VerifyNextButton();
        }
       
      // @Test
	public void TestStep_03_InstructorSubmitActivity() {
		
            System.out.println("Test Name: InstructorSubmitSystemSetUpActivity");
            test.MTXIntroductionActivityPage.clickOnQuestionTab();
            test.MTXQuizActivityPage.enterAnswers();
            test.MTXMathReviewPage.clickOnSubmitAnswerButton();
            test.MTXMathReviewPage.incorrectAnswerWarning();
            test.MTXMathReviewPage.clickOnSubmitButtonPresentInNavPanel();
            test.MTXMathReviewPage.clickOnSubmitActivityForGradingButton();
                
		
	}
        
     @Test
	public void TestStep_04_InstructorReSubmitActivity() {
		
            System.out.println("Test Name: InstructorReSubmitSystemSetUpActivity");
            test.MTXFramePage.switchToDefaultContent();
            test.MTXDashBoardPage.refreshPage();
            test.weekwidgetPage.navigateToWeek("Week 45");
            test.MTXActivityPage.launchActivityfromWeekView(systemSetupActivity);
            test.MTXFramePage.switchToMainFrame();
            test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
            test.MTXIntroductionActivityPage.clickOnQuestionTab();
            test.MTXQuizActivityPage.enterAnswers();
            test.MTXMathReviewPage.clickOnSubmitAnswerButton();
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
        
  //  @AfterClass(alwaysRun = true)
        public void stop_test_session() {
            test.closeTestSession();
    }

    @AfterMethod
        public void takeScreenshotonFailure(ITestResult result) {
            test.takescreenshot.takeScreenShotOnException(result);
    }
        
    
}
