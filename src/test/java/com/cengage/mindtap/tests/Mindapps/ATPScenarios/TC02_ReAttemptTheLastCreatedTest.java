/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.ATPScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.Assert;
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
public class TC02_ReAttemptTheLastCreatedTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Re-Attempt The Last Created Test");
        user = System.getProperty("user", "student");
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+user+".username")), getData(("users."+user+".password")));
        Reporter.log(user+" successfully logs in to the application",true);
    }
    
    @Test
    public void TestStep_02_LaunchCourseViaSSO(){
        if(user.equalsIgnoreCase("instructor")){
            test.instructorResourceCenterPage.instructorLaunchCourse(getData("Books.courseATP.courseKey"), tier);            
        }else if(user.equalsIgnoreCase("student")){
            test.studentMyHomePage.studentLaunchCourse(getData("Books.courseATP.courseKey"), tier);
        }
    }
    /*Launch App From App Dock And Verify that the app is successfully opened
     */
    @Test
    public void TestStep_03_LaunchAppFromAppDock(){
        test.DashBoardPage.LaunchAppFromAppDock(getData(("Books.course.appName")));
        Reporter.log(user+" successfully Launch App From AppDock",true);
    }
        /**Steps:
         * 1: Count the Total no of correct, Incorrect and unattempted  question.
         * 2: Re-Attempt The Last Created Test
     */

    @Test
    public void TestStep_05_ReAttemptTheLastCreatedTest(){
        int QuestionCount=Integer.parseInt(getData(("Books.course.QuestionCount")));
         int AttemptQueCount=Integer.parseInt(getData(("Books.course.AttemptQueCount")));
          Assert.assertTrue((QuestionCount>=AttemptQueCount), "**QuestionCount is Less than AttemptQueCount** Change the Value in Test Data File");
            
        test.FramesPage.switchToDockIFrame();
        test.FramesPage.switchToimilacContentIFrame();
        test.ATPAppPage.ReAttemptTheLastCreatedTest(getData(("Books.course.AttemptQueCount")));
        Reporter.log(user+" Successfully Re-Attempt The Last Created Test",true);
        
             
            
        
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
