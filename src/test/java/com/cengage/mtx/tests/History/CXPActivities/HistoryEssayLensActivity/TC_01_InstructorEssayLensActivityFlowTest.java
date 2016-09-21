/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.History.CXPActivities.HistoryEssayLensActivity;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author chandanjyot
 */
public class TC_01_InstructorEssayLensActivityFlowTest {
    
        TestSessionInitiator test;
        String user;
        String CXPDistinct = getData("Books.courseHistory.CXPDistinct");
        String activityTypeIndex = getData("Books.courseHistory.EssayactivityTypeIndex");
        String activityEssay = getData("Books.courseHistory.HistoryactivityEssay");
        String essayActivityTitle = getData("Books.courseHistory.essayActivityTitle");
        String essayActivityDesc = getData("Books.courseHistory.essayActivityDesc");
        String HistoryLensActivity = getData("Books.courseHistory.HistoryLensActivity");
        String lensActivityDesc = getData("Books.courseHistory.lensActivityDesc");
        String lensActivityTitle = getData("Books.courseHistory.lensActivityTitle");
        
        
        
	/**
	 * Sets the up class.
	 */
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("History Instructor Essay Lens Activity Test");
        user = System.getProperty("user", "instructor");
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
    public void TestStep_02_instructorAddEssayActivityAndLaunchFromWeekView() {
        test.MTXDashBoardPage.clickOnView("Unit View");
        test.MTXDashBoardPage.clickOnAddIconAndAddActivity();
        test.MTXDashBoardPage.verifyAddedActivityHeading();
        test.MTXDashBoardPage.clickOnActivity(CXPDistinct);
        test.MTXFramePage.switchToDistinctActivityCreateFrame();
        test.MTXDashBoardPage.selectActivityType(activityTypeIndex);
        test.MTXDashBoardPage.selectActivityPath(activityEssay);
        test.MTXDashBoardPage.clickOnContinueButton();
        test.MTXFramePage.switchToDefaultContent();
        test.MTXDashBoardPage.addActivityDiscriptionAndTitle(essayActivityTitle, essayActivityDesc);
        test.MTXDashBoardPage.setCurrentDateAsDueDate();
        test.MTXDashBoardPage.saveActivityButton();
        test.MTXDashBoardPage.clickOnAddIconAndAddActivity();
        test.MTXDashBoardPage.verifyAddedActivityHeading();
        test.MTXDashBoardPage.clickOnActivity(CXPDistinct);
        test.MTXFramePage.switchToDistinctActivityCreateFrame();
        test.MTXDashBoardPage.selectActivityType(activityTypeIndex);
        test.MTXDashBoardPage.selectActivityPath(HistoryLensActivity);
        test.MTXDashBoardPage.clickOnContinueButton();
        test.MTXFramePage.switchToDefaultContent();
        test.MTXDashBoardPage.addActivityDiscriptionAndTitle(lensActivityTitle, lensActivityDesc);
        test.MTXDashBoardPage.setCurrentDateAsDueDate();
        test.MTXDashBoardPage.saveActivityButton();
        test.MTXDashBoardPage.clickOnView("Week View");
        test.MTXActivityPage.launchActivityfromWeekView(essayActivityTitle);
         
         
         
         
//        test.weekwidgetPage.navigateToWeek("Week 44");
//        test.MTXActivityPage.launchActivityfromWeekView(activityName);
//        test.MTXActivityPage.activityTitle(activityName);
//        test.MTXActivityPage.activityDate();
    }
    
   @Test
    public void TestStep_03_verifyLaunchEssayActivity_VerifyTitle_DueDateHeader_CloseButton() {
        //test.weekwidgetPage.navigateToWeek("Week 44");
       test.MTXActivityPage.launchActivityfromWeekView(essayActivityTitle);
       test.MTXActivityPage.activityTitle(essayActivityTitle);
        test.MTXActivityPage.activityDate();
    }
    
    @Test
    public void TestStep_04_InstructorSelectLensandVerifyLesChange(){
        
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
    public void TestStep_05_InstructorSubmitActivity(){
      
        test.MTXFramePage.switchToActivityServiceFrame();
        test.MTXActivityPage.overviewStartActivityButton();
        //test.MTXFramePage.switchToMainFrame();
        test.MTXActivityPage.breadcrumbs("Source");
       // test.MTXActivityPage.sourceContentLoad();
        //test.MTXEssayPage.enterEssayTextInEditor();
        test.MTXNarrativePage.clickOnCloseAndSubmitButton();
        
    }
    
 @Test
    public void TestStep_06_InstructorResubmitSameActivity(){
        System.out.println("Instructor re-attempting same activity)");
        test.MTXFramePage.switchToDefaultContent();
        test.MTXActivityPage.launchActivityfromWeekView(essayActivityTitle);
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
    
   
    //@AfterClass(alwaysRun = true)
    public void stop_test_session() {
        test.closeTestSession();
    }

   // @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        
        test.takescreenshot.takeScreenShotOnException(result);
    }
    
}
