/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.UserRoles.InstructorRoleScenarios;


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
 * 
 * @author QAI
 */
public class UserMenuTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32744", true);
        test = new TestSessionInitiator("Verify User Menu");
        user = System.getProperty("user", "instructor");
    }
   @Test
     public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    /*Course Settings Verification
    */
   //TODO:enable checkbox assertion
    @Test
   public void TestStep_02_CourseSettings() {
         test.DashBoardPage.selectOptionFromUserMenu("Course Settings");
         Assert.assertTrue(test.DashBoardPage.verifyCourseSettings());
         Reporter.log(user+" successfully Verified Course Settings",true);
    }
   /*TODO: Send Us Feedback Verification
    */
   
    //@Test
    public void TestStep_03_LaunchAppFromAppDock() {
        test.DashBoardPage.LaunchAppFromAppDock("ConnectYard"); 
        test.DashBoardPage.closeOpenApp();
        Reporter.log(user+"successfully Verified and Launch ConnectYard App From App Dock",true);
    }   


    //@Test
    public void TestStep_04_SendUsFeedback() {
         test.DashBoardPage.selectOptionFromUserMenu("Send Us Feedback");
         Assert.assertTrue(test.DashBoardPage.verifySendUsFeedback());
         Reporter.log(user+" successfully Verified Send Us Feedback",true);
    }
   /*TODO: FAQ Verification
    */
    //@Test
    public void TestStep_05_FAQ() {
         test.DashBoardPage.selectOptionFromUserMenu("FAQ");
         Assert.assertTrue(test.DashBoardPage.verifyFAQ());
         Reporter.log(user+" successfully Verified FAQ",true);
    }
   /*TODO: System Check Verification
    */
    //@Test
    public void TestStep_06_SystemCheck() {
         test.DashBoardPage.selectOptionFromUserMenu("System Check");
          Assert.assertTrue(test.DashBoardPage.verifySystemCheck());
          Reporter.log(user+" successfully Verified System Check",true);
          
    }
    
    
    //@Test
    public void TestStep_07_CustomerSupport() {
          test.DashBoardPage.selectCustomerSupport();
          Assert.assertTrue(test.DashBoardPage.verifyCustomerSupport());
          Reporter.log(user+" successfully Verified Customer Support",true);
     
    }
    
   /*User Logout 
    */
   //@Test
    public void TestStep_08_Logout() {
         test.DashBoardPage.Logout();
         //test.DashBoardPage.logOutMsg();
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

