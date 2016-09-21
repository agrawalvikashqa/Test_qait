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
public class TC03_VerifyInlineVideosFeedbackAndTexteReaderInLastCreatedTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Verify Inline Videos Feedback And Text e-Reader In Last Created Test");
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
        /*TODO:
     */

    @Test
    public void TestStep_04_VerifyInlineVideos(){
        test.FramesPage.switchToDockIFrame();
        test.FramesPage.switchToimilacContentIFrame();
        Assert.assertTrue(test.ATPAppPage.VerifyInlineVideos());
        Reporter.log(user+" Successfully Verify Inline Videos Inside Unattempted Questions",true);
        
             
            
        
    }
   @Test
    public void TestStep_05_VerifyFeedback(){
       
        Assert.assertTrue(test.ATPAppPage.VerifyFeedbackOfCorrectAnsweredQuestion());
        Reporter.log(user+" Successfully Verify Feedback Of Correct Answered Question",true);
        
        Assert.assertTrue(test.ATPAppPage.VerifyFeedbackOfInCorrectAnsweredQuestion());
        Reporter.log(user+" Successfully Verify Feedback Of InCorrect Answered Question",true);
             
            
        
    }
    @Test
    public void TestStep_06_VerifyTexteReader(){
        test.ATPAppPage.clickOnTexteReader();
        Assert.assertTrue(test.ATPAppPage.VerifyTexteReader());
        test.ATPAppPage.clickOnCloseBtn("2");
        Reporter.log(user+" Successfully Verify Text eReader",true);
        
             
            
        
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
