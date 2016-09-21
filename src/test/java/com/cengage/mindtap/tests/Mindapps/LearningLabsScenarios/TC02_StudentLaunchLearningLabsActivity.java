/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.LearningLabsScenarios;

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
public class TC02_StudentLaunchLearningLabsActivity {
TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String LearningLabs_newtitle = getData("learningActivities.LearningLabs.newTitle");

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket:- https://jira.cengage.com/browse/NG-33007", true);
        test = new TestSessionInitiator("Learning Labs App");
        user = System.getProperty("user", "student");
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAA.courseKey"),getData("Books.courseAA.ISBN"));
        Reporter.log(user+" successfully logs in to the application",true);
    }
    /*This test case covers:
     *Verifying of launch Learning Labs Activity 
     **/    
@Test
public void TestStep_02_studentLaunchDistinctLearningLabsActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.launchDistinctActivity(getData("learningActivities.LearningLabs.newTitle"));
        Reporter.log ("Completed Student launch Distinct Learning Labs Activity Test" + "\n" ,true);
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

