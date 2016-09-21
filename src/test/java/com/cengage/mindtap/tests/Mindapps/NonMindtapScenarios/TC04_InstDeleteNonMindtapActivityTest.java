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
import org.testng.annotations.*;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author QAI
 */
public class TC04_InstDeleteNonMindtapActivityTest {
TestSessionInitiator test;
        String tier = ObjectFileReader.getTier().replaceAll("/", "");

        String user;
        String userStudent; 
        String NonMindtap_Gradednewtitle = getData("learningActivities.NonMindTap.Graded_newtitle");
        String NonMindtap_Practicenewtitle = getData("learningActivities.NonMindTap.Practice_newtitle");
        
         @BeforeClass
        public void start_test_session() {
            Reporter.log("Jira Ticket:- https://jira.cengage.com/browse/NG-33063", true);
            test = new TestSessionInitiator("Non MindTap App Test");
            user = System.getProperty("user", "instructor");
          }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAA.courseKey"),getData("Books.courseAA.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
     @Test
    @Parameters({"activityCourseBook"})
    public void TestStep_02_UserDeleteDistinctActivity(@Optional("courseGradeBook") String activityCourseBook){
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.deleteDistinctActivity(getData("learningActivities.NonMindTap.Graded_newtitle"));
        test.DashBoardPage.deleteDistinctActivity(getData("learningActivities.NonMindTap.Practice_newtitle"));
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

