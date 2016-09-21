/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.UserRoles.StudentRoleScenarios;


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
 * 
 * @author QAI
 */
public class LaunchAppsFromAppDockTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32744", true);
        test = new TestSessionInitiator("Launch Apps From App Dock Test");
        user = System.getProperty("user", "student");
    }
   @Test
     public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    /*Full Book Launch Verification
    */
   @Test
    public void TestStep_02_verifyLaunchFullBookApp() {
         test.DashBoardPage.clickOnAppByName("Full Book");
         test.DashBoardPage.closeOpenApp();
         Reporter.log(user+" successfully Verified Full Book Launch",true);
    }
    /*Merriam-Webster's Dictionary Verification
    */
   @Test
    public void TestStep_03_verifyLaunchDictionaryApp() {
        test.DashBoardPage.clickOnAppByName("Merriam-Webster's Dictionary");
        test.DashBoardPage.closeOpenApp();
        Reporter.log(user+"  successfully Verified Merriam-Webster's Dictionary Launch",true);
    }
     /*Flashcards Launch Verification
    */
      @Test
    public void TestStep_04_verifyLaunchFlashcardApp() {
         test.DashBoardPage.clickOnAppByName("Flashcards");
         test.DashBoardPage.getVerifyByAppName("Flashcards");
         test.DashBoardPage.closeOpenApp();
         Reporter.log(user+"  successfully Verified Flashcards Launch",true);
         
    }
    /*Glossary Launch Verification
    */
     @Test
    public void TestStep_05_verifyLaunchGlossaryApp() {
         test.DashBoardPage.clickOnAppByName("Glossary");
         test.DashBoardPage.getVerifyByAppName("Glossary");
         test.DashBoardPage.closeOpenApp();
         Reporter.log(user+" successfully Verified Glossary Launch",true);
    }
      /*Search Launch Verification
    */
   @Test
    public void TestStep_6_verifyLaunchSearchApp() {
         test.DashBoardPage.clickOnAppByName("Search");
         test.DashBoardPage.closeOpenApp();
         Reporter.log(user+" successfully Verified Search Launch",true);
    } 
      /*ReadSpeaker Launch Verification
    */
     @Test
    public void TestStep_7_verifyLaunchReadSpeakerApp() {
         test.DashBoardPage.clickOnAppByName("ReadSpeaker");
         test.DashBoardPage.closeOpenApp();
         Reporter.log(user+" successfully Verified ReadSpeaker Launch",true);
    } 
      /*Message Center Launch Verification
    */
     @Test
    public void TestStep_8_verifyLaunchMessageCenterApp() {
            test.DashBoardPage.clickOnAppByName("Message Center");
         test.DashBoardPage.closeOpenApp();
         Reporter.log(user+" successfully Verified Message Center Launch",true);
    } 
      /*StudyHub Launch Verification
    */
     @Test
    public void TestStep_9_verifyLaunchStudyHubApp() {
         test.DashBoardPage.clickOnAppByName("StudyHub");
         test.DashBoardPage.closeOpenApp();
         Reporter.log(user+" successfully Verified StudyHub Launch",true);
    } 
      /*ReadSpeaker Launch Verification
    */
     @Test
    public void TestStep_10_verifyLaunchProgressApp() {
         test.DashBoardPage.clickOnAppByName("Progress");
         test.DashBoardPage.closeOpenApp();
         Reporter.log(user+" successfully Verified Progress Launch",true);
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
