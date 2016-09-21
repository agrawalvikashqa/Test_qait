/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.NonMindtapScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author QAI
 */
public class TC03_StudentLaunchNonMindtapActivityTest {
    TestSessionInitiator test;
        String tier = ObjectFileReader.getTier().replaceAll("/", "");

        String user;
        String userStudent; 
        String NonMindtap_Gradednewtitle = getData("learningActivities.NonMindTap.Graded_newtitle");
        String NonMindtap_Gradednewdescription = getData("learningActivities.NonMindTap.Graded_newdescription");
        String NonMindtap_Practicenewtitle = getData("learningActivities.NonMindTap.Practice_newtitle");
        String NonMindtap_Practicenewdescription = getData("learningActivities.NonMindTap.Practice_newdescription");
  
    @BeforeClass
        public void start_test_session() {
            Reporter.log("Jira Ticket:- https://jira.cengage.com/browse/NG-33063", true);
            test = new TestSessionInitiator("Non MindTap App Test");
            user = System.getProperty("user", "student");
          }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAA.courseKey"),getData("Books.courseAA.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
     /*This test case covers:
        *Launch Distinct Graded NonMindTap Activity
        **/ 
    @Test
    public void TestStep_08_instructorLaunchDistinctGradedNonMindtapActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.launchDistinctActivity(getData("learningActivities.NonMindTap.Graded_newtitle"));
        test.DashBoardPage.closeLaunchedActivity(NonMindtap_Gradednewtitle);
        Reporter.log ("Completed Instructor launch Distinct Graded Non Mindtap Activity Test" + "\n" ,true);  
}
    /*This test case covers:
        *Launch Distinct Practice NonMindTap Activity
        **/ 
    @Test
    public void TestStep_09_instructorLaunchDistinctPracticeNonMindtapActivity() {
        test.DashBoardPage.launchDistinctActivity(getData("learningActivities.NonMindTap.Practice_newtitle"));
        test.DashBoardPage.Logout();
        Reporter.log ("Completed Instructor launch Distinct Practice Non Mindtap Activity Test" + "\n" ,true);  
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
