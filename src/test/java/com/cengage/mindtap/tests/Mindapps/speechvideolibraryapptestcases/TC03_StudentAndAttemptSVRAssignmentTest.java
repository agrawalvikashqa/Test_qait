/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.speechvideolibraryapptestcases;

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
 * @author QAIT
 */
public class TC03_StudentAndAttemptSVRAssignmentTest {


TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("SVR");
       user = System.getProperty("user", "student1");
    }

  @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseATP.courseKey"),getData("Books.courseATP.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true);
    }
    
    @Test
    public void TestStep_02_StudentLaunchesSVRActivityTest(){
        test.DashBoardPage.clickOnView("Unit View");
        test.SVR.launchDistinctActivity(getData("learningActivities.SVR.newTitle"));
        test.SVR.studentSubmitsAnswersToActivity(getData("learningActivities.SVR.description"));
        Reporter.log("Completed Student submit answers to SVR Activity",true);
        test.lpnPage.logOutFromMindTap();
    }
    
    @Test
     public void TestStep_03_instructorGradesStudentAttemptInSVRActivity(){
        user = System.getProperty("user", "instructor");
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseATP.courseKey"),getData("Books.courseATP.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true);
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAppByName("Progress");
        test.FramesPage.switchToDockIFrame();
        test.SVR.editScoreAndAddCommentToActivity(getData("learningActivities.SVR.newTitle"),getData("users.student1.name"));  //Faulty JS code in application
        Reporter.log("Completed Instructor  successfully grades student attempt test");
    }
    

    /*User Logout 
    */
    @Test
    public void TestStep_04_Logout() {
         test.DashBoardPage.Logout();
         Reporter.log(user+" successfully User Logout",true);
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
