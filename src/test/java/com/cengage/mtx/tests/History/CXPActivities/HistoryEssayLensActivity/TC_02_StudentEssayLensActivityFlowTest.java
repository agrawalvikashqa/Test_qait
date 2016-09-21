/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.History.CXPActivities.HistoryEssayLensActivity;

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
public class TC_02_StudentEssayLensActivityFlowTest {
    
        TestSessionInitiator test;
        String user;
        String CXPDistinct = getData("Books.courseHistory.CXPDistinct");
        String activityTypeIndex = getData("Books.courseHistory.EssayactivityTypeIndex");
        String activityEssay = getData("Books.courseHistory.HistoryactivityEssay");
        String essayActivityTitle = getData("Books.courseHistory.essayActivityTitle");
        String essayActivityDesc = getData("Books.courseHistory.essayActivityDesc");
        String lensActivityTitle = getData("Books.courseHistory.lensActivityTitle");
        
        
        
	/**
	 * Sets the up class.
	 */
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("History Instructor Essay Lens Activity Test");
        user = System.getProperty("user", "student");
        //System.out.println("test started");
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
    public void TestStep_02_verifyLaunchEssayActivity_VerifyTitle_DueDateHeader_CloseButton() {
        //test.weekwidgetPage.navigateToWeek("Week 44");
       test.MTXActivityPage.launchActivityfromWeekView(essayActivityTitle);
       test.MTXActivityPage.activityTitle(essayActivityTitle);
        test.MTXActivityPage.activityDate();
    }
    
    @Test
    public void TestStep_03_StudentSelectLensandVerifyLesChange(){
        
        test.MTXFramePage.switchToMainFrame();
        test.MTXFramePage.switchToActivityOverviewFrame();
        test.MTXLensPage.verifyContinueButtonDisabledOnLensSelectionPage();
        test.MTXLensPage.selectFirstLensOnLensSelectionPage();
        test.MTXLensPage.clickContinueButtonOnLensSelectionPage();
        test.MTXLensPage.verifyLensNameOnActivityHeader();
       // test.MTXLensPage.clickOnLensChangeButton();
        //test.MTXLensPage.changeLens();
        //test.MTXLensPage.clickContinueButtonOnLensSelectionPage();
        //test.MTXLensPage.verifyChangedLensNameOnActivityHeader();
        
    }
    @Test
    public void TestStep_04_STudentVerifyInProgressOverviewPage(){
        
//        test.MTXActivityPage.launchActivityfromWeekView(activityName);
//        test.MTXFramePage.switchToMainFrame();
//       test.MTXFramePage.switchToActivityOverviewFrame();
        
        test.MTXFramePage.switchToActivityServiceFrame();
        test.MTXActivityPage.overviewStartActivityButton();
        test.MTXFramePage.switchToDefaultContent();
        test.MTXActivityPage.closeActivity();
        test.MTXActivityPage.launchActivityfromWeekView(essayActivityTitle);
        test.MTXFramePage.switchToMainFrame();
        test.MTXFramePage.switchToActivityOverviewFrame();
        test.MTXFramePage.switchToActivityServiceFrame();
        test.MTXActivityPage.clickOnInfoIcon();
       // test.MTXFramePage.switchToActivityOverviewFrame();
        test.MTXActivityPage.activityOverviewHeaderVerify("This is an APPLY activity");
        test.MTXActivityPage.overviewUI();
        test.MTXActivityPage.overviewContinueButton();
        
    }
    
    
    @Test
    public void TestStep_05_StudentSubmitActivity(){
      
       // test.MTXFramePage.switchToActivityServiceFrame();
      //  test.MTXActivityPage.overviewStartActivityButton();
        //test.MTXFramePage.switchToMainFrame();
        test.MTXActivityPage.breadcrumbs("Source");
       // test.MTXActivityPage.sourceContentLoad();
        //test.MTXEssayPage.enterEssayTextInEditor();
        test.MTXNarrativePage.clickOnCloseAndSubmitButton();
        test.MTXActivityPage.clickOnCLoseAndSubmitButtonOnLenspopUp();
        
        
    }
    
    
    
    @Test 
    public void TestStep_06_StudentLaunchSubmittedActivity(){
        test.MTXFramePage.switchToDefaultContent();
       // test.weekwidgetPage.navigateToWeek("Week 44"); 
        test.MTXActivityPage.launchActivityfromWeekView(essayActivityTitle);
        test.MTXActivityPage.activityTitle(essayActivityTitle);
        test.MTXActivityPage.activityDate();
        test.MTXActivityPage.submittedDecorator();
        
        //(holding off for the confirmation of review mode UI)
//        test.MTXActivityPage.clickReviewButton();
//        test.MTXFramePage.switchToMainFrame();
//        test.MTXFramePage.switchToActivityOverviewFrame();
//        test.MTXLensPage.clickOnLensChangeButton();
//        test.MTXLensPage.acceptWarningPopUp();
//        test.MTXActivityPage.submittedButton(" ");
//        test.MTXFramePage.switchToDefaultContent();
//        test.MTXActivityPage.activityOverviewButton();
        test.MTXActivityPage.closeActivity();
        test.MTXNarrativePage.verifyDashboardAppear();     
    }
    
     @Test
    public void TestStep_07_StudentVerifyWarningPopUpsForLensChange(){
        
        test.MTXActivityPage.launchActivityfromWeekView(lensActivityTitle);
        test.MTXFramePage.switchToMainFrame();
        test.MTXFramePage.switchToActivityOverviewFrame();
       // test.MTXLensPage.verifyLensNameOnActivityHeader();
        test.MTXLensPage.clickOnLensChangeButton();
        test.MTXLensPage.acceptWarningPopUp();
        test.MTXActivityPage.closeActivity();
        
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
