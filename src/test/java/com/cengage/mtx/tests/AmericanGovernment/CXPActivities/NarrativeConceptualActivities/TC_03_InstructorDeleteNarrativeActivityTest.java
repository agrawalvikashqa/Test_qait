/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.AmericanGovernment.CXPActivities.NarrativeConceptualActivities;

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
public class TC_03_InstructorDeleteNarrativeActivityTest {
    
     TestSessionInitiator test;
        String user;
        String activityName = getData("Books.courseAmGovt.activityNarrative");
        
	/**
	 * Sets the up class.
	 */
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("InstructorDeleteNarrativeActivityTest");
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
    public void TestStep_02_InstructorDeleteTakeofActivity(){
        test.MTXNarrativePage.launchGradebook();
        test.MTXFramePage.switchToDockIFrame();
        
        test.MTXNarrativePage.clickOnStudentLink();
        test.MTXNarrativePage.clickOnActivityLinkInGradebook(activityName);
        test.MTXNarrativePage.clickOnDeleteTakeLink();
         test.MTXNarrativePage.clickOnConfirmButtoninGB();
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
