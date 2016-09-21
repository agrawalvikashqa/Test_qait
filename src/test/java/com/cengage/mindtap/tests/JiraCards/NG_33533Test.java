/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.JiraCards;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import static com.qait.automation.utils.YamlReader.getData;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author QAI
 */
public class NG_33533Test {     
    TestSessionInitiator test;
        String user;
        String activityName = getData("Books.courseAmGovt.activityConnectingWithPolitics");
        
	/**
	 * Sets the up class.
	 */
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket:https://jira.cengage.com/browse/NG-33533 ", true);
        test = new TestSessionInitiator("Image shows with a button to enlarge image Test");
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
    
    @Test
    public void TestStep_02_InstructorVerifyOverviewPage(){
        test.weekwidgetPage.navigateToWeek("Week 44");
        test.MTXActivityPage.launchActivityfromWeekView(activityName);
       test.MTXFramePage.switchToMainFrame();
        test.MTXFramePage.switchToActivityOverviewFrame();
       test.MTXActivityPage.overviewStartActivityButton();
       test.MTXActivityPage.verifyEnlargeImageButton();
    
    }
    
    @BeforeMethod
        public void beforeEachTest() {
        Reporter.log("\n\n *********************************************************************** ", true);
        
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
