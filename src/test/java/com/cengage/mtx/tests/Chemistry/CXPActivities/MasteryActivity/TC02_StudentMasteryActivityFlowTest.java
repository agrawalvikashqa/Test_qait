/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.Chemistry.CXPActivities.MasteryActivity;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;
/**
 *
 * @author Kashyap
 */
public class TC02_StudentMasteryActivityFlowTest {
    
    TestSessionInitiator test;
        String user;
        String MasteryActivity = getData("Books.courseChemistry.MasteryActivity");
        
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Student Mastery Activity Test");
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
	public void TestStep_02_InstructorLaunchMasteryActivityandVerifyUI() {
		
            System.out.println("Test Name: Verify Instructor Matery Activity");
            test.weekwidgetPage.navigateToWeek("Week 45");
            test.MTXActivityPage.launchActivityfromWeekView(MasteryActivity);
            test.MTXActivityPage.getTitleOfActivity();
            test.MTXActivityPage.activityDate();
            test.MTXFramePage.switchToMainFrame();
            test.MTXFramePage.switchToFrame("easyXDM_activityService_cxp_Target_provider");
            test.MTXMasteryActivityPage.verifyNextButtonisPresentforMastery();
            test.MTXMasteryActivityPage.verifyBackButtonisPresentforMastery();
            test.MTXMasteryActivityPage.verifyCurrentScorePresentatBottomforMastery();
        }
    
    @Test
	public void TestStep_03_VerifyInProgressStatusIconInWeekView() {
            Reporter.log("Test Name: verifyInProgressStatusIndicatorOfIntroductionActivity",true);
                test.MTXFramePage.switchToDefaultContent();
                test.MTXActivityPage.clickOnCloseActivity();
                test.MTXDashBoardPage.refreshPage();
                test.weekwidgetPage.navigateToWeek("Week 45");
		test.weekwidgetPage.verifyActivityInProgressIcon(MasteryActivity);
	}
    
    
    
    
    
    
    
    
}
