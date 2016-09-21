/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.History.CXPActivities.HistoryLensActivity;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author chandanjyot
 */
public class TC_01_InstructorLensActivityFlowTest {
    
     TestSessionInitiator test;
        String user;
        String activityName = getData("Books.courseHistory.activityLens");
        
	/**
	 * Sets the up class.
	 */
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("History Instructor Lens Activity Test");
        user = System.getProperty("user", "instructor");
    }

	/**
	 * TC001_login to the SSO front door.
	 */
	@Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseHistory.courseKey"),getData("Books.courseHistory.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    @Test
    public void TestStep_02_verifyLaunchEconomicActivity_VerifyTitle_DueDateHeader_CloseButton() {
        test.weekwidgetPage.navigateToWeek("Week 44");
        test.MTXActivityPage.launchActivityfromWeekView(activityName);
        test.MTXActivityPage.activityTitle(activityName);
        test.MTXActivityPage.activityDate();
    }
    
    @Test
    public void TestStep_03_InstructorSelectLensandVerifyLesChange(){
        
        test.MTXFramePage.switchToMainFrame();
        test.MTXFramePage.switchToActivityOverviewFrame();
        test.MTXLensPage.verifyContinueButtonDisabledOnLensSelectionPage();
        test.MTXLensPage.selectFirstLensOnLensSelectionPage();
        test.MTXLensPage.clickContinueButtonOnLensSelectionPage();
        test.MTXLensPage.verifyLensNameOnActivityHeader();
        test.MTXLensPage.clickOnLensChangeButton();
        test.MTXLensPage.changeLens();
        test.MTXLensPage.clickContinueButtonOnLensSelectionPage();
        test.MTXLensPage.verifyChangedLensNameOnActivityHeader();
        
    }
    
    @Test
    public void TestStep_04_InstructorSubmitActivity(){
      
        test.MTXFramePage.switchToActivityServiceFrame();
        test.MTXActivityPage.overviewStartActivityButton();
        //test.MTXFramePage.switchToMainFrame();
        test.MTXActivityPage.breadcrumbs("Source 1");
        test.MTXActivityPage.sourceContentLoad();
        test.MTXActivityPage.breadcrumbs("Final Assessment");
        test.MTXNarrativePage.collapsedView();
        test.MTXNarrativePage.expandedView();
        test.MTXNarrativePage.selectRadioButton();
        test.MTXNarrativePage.clickOnCheckAnswerButton();
        test.MTXNarrativePage.clickOnCloseAndSubmitButton();
        test.MTXActivityPage.clickOnReturntoActivityButton();
        test.MTXActivityPage.verifyTryAgainButton();
        test.MTXNarrativePage.selectRadioButton();
        test.MTXNarrativePage.clickOnCheckAnswerButton();
        test.MTXNarrativePage.clickOnCloseAndSubmitButton();
        test.MTXActivityPage.clickOnCLoseAndSubmitButtonOnLenspopUp();
        
    }
    
    @Test
    public void TestStep_05_InstructorResubmitSameActivity(){
        System.out.println("Instructor re-attempting same activity)");
        test.MTXFramePage.switchToDefaultContent();
        test.MTXActivityPage.launchActivityfromWeekView(activityName);
        test.MTXFramePage.switchToMainFrame();
        test.MTXFramePage.switchToActivityOverviewFrame();
        test.MTXActivityPage.activityOverviewHeaderVerify("This is an APPLY activity");
        test.MTXLensPage.verifyContinueButtonDisabledOnLensSelectionPage();
        test.MTXLensPage.selectFirstLensOnLensSelectionPage();
        test.MTXLensPage.clickContinueButtonOnLensSelectionPage();
        test.MTXLensPage.verifyLensNameOnActivityHeader();
        test.MTXFramePage.switchToActivityServiceFrame();
        test.MTXActivityPage.overviewStartActivityButton();
        test.MTXActivityPage.breadcrumbs("Final Assessment");
        test.MTXNarrativePage.collapsedView();
        test.MTXNarrativePage.expandedView();
        test.MTXNarrativePage.selectRadioButton();
        test.MTXNarrativePage.clickOnCheckAnswerButton();
        test.MTXNarrativePage.clickOnCloseAndSubmitButton();
        test.MTXActivityPage.clickOnCLoseAndSubmitButtonOnLenspopUp();
        test.MTXFramePage.switchToDefaultContent();
        test.MTXNarrativePage.verifyDashboardAppear();
       
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
