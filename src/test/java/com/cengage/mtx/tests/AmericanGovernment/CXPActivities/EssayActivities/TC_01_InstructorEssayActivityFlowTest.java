/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.AmericanGovernment.CXPActivities.EssayActivities;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author archittayal
 */
public class TC_01_InstructorEssayActivityFlowTest {
    
     TestSessionInitiator test;
        String user;
        String activityName = getData("Books.courseAmGovt.activityEssay");
        
	/**
	 * Sets the up class.
	 */
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("American Government Essay Activity Test");
        user = System.getProperty("user", "instructor");
    }

	/**
	 * TC001_login to the SSO front door.
	 */
    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAmGovt.CourseKey"),getData("Books.courseAmGovt.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    //@Test
    public void TestStep_02_InstructorVerifyOverviewPage(){
        test.weekwidgetPage.navigateToWeek("Week 44");
        test.MTXActivityPage.launchActivityfromWeekView(activityName);
        test.MTXFramePage.switchToMainFrame();
        test.MTXFramePage.switchToActivityOverviewFrame();
        test.MTXLensPage.verifyContinueButtonDisabledOnLensSelectionPage();
        test.MTXLensPage.selectFirstLensOnLensSelectionPage();
        test.MTXLensPage.clickContinueButtonOnLensSelectionPage();
        test.MTXActivityPage.activityOverviewHeaderVerify("This is an APPLY activity");
        test.MTXActivityPage.overviewUI();
        test.MTXActivityPage.overviewCancelButton();
    }
    
    @Test
    public void TestStep_03_InstructorChangeLensAndSubmitActivity(){
        test.MTXFramePage.switchToDefaultContent();
        test.weekwidgetPage.navigateToWeek("Week 44"); 
        test.MTXActivityPage.launchActivityfromWeekView(activityName);
        test.MTXActivityPage.activityTitle(activityName);
        test.MTXActivityPage.activityDate();
        test.MTXFramePage.switchToMainFrame();
        test.MTXFramePage.switchToActivityOverviewFrame();
        test.MTXLensPage.verifyContinueButtonDisabledOnLensSelectionPage();
        test.MTXLensPage.selectFirstLensOnLensSelectionPage();
        test.MTXLensPage.clickContinueButtonOnLensSelectionPage();
        test.MTXLensPage.verifyLensNameOnActivityHeader();
        test.MTXLensPage.clickOnLensChangeButton();
        test.MTXFramePage.switchToMainFrame();
        test.MTXFramePage.switchToActivityOverviewFrame();
        test.MTXLensPage.changeLens();
        test.MTXLensPage.clickContinueButtonOnLensSelectionPage();
        test.MTXFramePage.switchToActivityServiceFrame();
        test.MTXActivityPage.overviewStartActivityButton();
        test.MTXActivityPage.breadcrumbs("Why Politics Matters");
        test.MTXActivityPage.activityManual();
        test.MTXNarrativePage.clickOnCloseAndSubmitButton();
        test.MTXFramePage.switchToDefaultContent();
        test.MTXNarrativePage.verifyDashboardAppear();     
    }
    
    @Test
    public void TestStep_04_InstructorReSubmitsActivity(){
        test.MTXFramePage.switchToDefaultContent();
        test.weekwidgetPage.navigateToWeek("Week 44"); //baad mein remove
        test.MTXActivityPage.launchActivityfromWeekView(activityName);
        test.MTXActivityPage.activityTitle(activityName);
        test.MTXActivityPage.activityDate();
        test.MTXFramePage.switchToMainFrame();
        test.MTXFramePage.switchToActivityOverviewFrame();
        test.MTXLensPage.verifyContinueButtonDisabledOnLensSelectionPage();
        test.MTXLensPage.selectFirstLensOnLensSelectionPage();
        test.MTXLensPage.clickContinueButtonOnLensSelectionPage();
        test.MTXFramePage.switchToActivityServiceFrame();
        test.MTXActivityPage.overviewStartActivityButton();
        test.MTXActivityPage.breadcrumbs("Why Politics Matters");
        test.MTXActivityPage.activityManual();
        test.MTXNarrativePage.clickOnCloseAndSubmitButton();
        test.MTXFramePage.switchToDefaultContent();
        test.MTXNarrativePage.verifyDashboardAppear();          
    }
}