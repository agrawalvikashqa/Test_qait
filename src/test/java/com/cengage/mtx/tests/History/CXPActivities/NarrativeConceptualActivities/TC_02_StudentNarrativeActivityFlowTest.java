/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.History.CXPActivities.NarrativeConceptualActivities;

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
public class TC_02_StudentNarrativeActivityFlowTest {
    
     TestSessionInitiator test;
        String user;
        String activityName = getData("Books.courseHistory.activityTutored");
        
	/**
	 * Sets the up class.
	 */
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("History Smoke Test");
        user = System.getProperty("user", "student");
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
    public void TestStep_02_StudentVerifyOverviewPage(){
        test.weekwidgetPage.navigateToWeek("Week 44");
        test.MTXActivityPage.launchActivityfromWeekView(activityName);
        test.MTXFramePage.switchToMainFrame();
        test.MTXFramePage.switchToActivityOverviewFrame();
        test.MTXActivityPage.activityOverviewHeaderVerify("This is a LEARN activity");
        test.MTXActivityPage.overviewUI();
        test.MTXActivityPage.overviewCancelButton();
    }
    
    @Test
    public void TestStep_03_StudentVerifyInProgressActivity(){
        test.MTXFramePage.switchToDefaultContent();
        test.MTXActivityPage.launchActivityfromWeekView(activityName);
        test.MTXActivityPage.activityTitle(activityName);
        test.MTXActivityPage.activityDate();
        
        test.MTXFramePage.switchToMainFrame();
        test.MTXFramePage.switchToActivityOverviewFrame();
        test.MTXActivityPage.overviewStartActivityButton();
        test.MTXFramePage.switchToDefaultContent();
        test.MTXActivityPage.closeActivity();
        //test.MTXNarrativePage.inProgressSIVerify();
    }
   
    @Test
    public void TestStep_04_STudentVerifyInProgressOverviewPage(){
        test.MTXActivityPage.launchActivityfromWeekView(activityName);
        test.MTXFramePage.switchToMainFrame();
        test.MTXFramePage.switchToActivityOverviewFrame();
        test.MTXActivityPage.clickOnInfoIcon();
       // test.MTXFramePage.switchToActivityOverviewFrame();
        test.MTXActivityPage.activityOverviewHeaderVerify("This is a LEARN activity");
        test.MTXActivityPage.overviewUI();
        test.MTXActivityPage.overviewContinueButton();
        
    }
    
    @Test
    public void TestStep_05_StudentSubmitActivity(){
        
        test.MTXActivityPage.activityScore();
        test.MTXActivityPage.breadcrumbs("Reading");
        test.MTXNarrativePage.collapsedView();
        test.MTXNarrativePage.expandedView();
        test.MTXNarrativePage.selectRadioButton();
        test.MTXNarrativePage.clickOnCheckAnswerButton();
        test.MTXActivityPage.verifyTryAgainButton();
        test.MTXNarrativePage.selectRadioButton();
        test.MTXNarrativePage.clickOnCheckAnswerButton();
        test.MTXNarrativePage.clickOnCloseAndSubmitButton();
        test.MTXFramePage.switchToDefaultContent();
        test.MTXNarrativePage.verifyDashboardAppear();
    }
    
    @Test
    public void TestStep_06_StudentLaunchSubmittedActivity(){
        test.MTXFramePage.switchToDefaultContent();
        test.weekwidgetPage.navigateToWeek("Week 44"); 
        test.MTXActivityPage.launchActivityfromWeekView(activityName);
        test.MTXActivityPage.activityTitle(activityName);
        test.MTXActivityPage.activityDate();
        test.MTXActivityPage.submittedDecorator();
        test.MTXActivityPage.clickReviewButton();
        test.MTXFramePage.switchToMainFrame();
        test.MTXFramePage.switchToActivityOverviewFrame();
        test.MTXActivityPage.submittedButton("");
        test.MTXFramePage.switchToDefaultContent();
        test.MTXActivityPage.activityOverviewButton();
        test.MTXActivityPage.closeActivity();
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
