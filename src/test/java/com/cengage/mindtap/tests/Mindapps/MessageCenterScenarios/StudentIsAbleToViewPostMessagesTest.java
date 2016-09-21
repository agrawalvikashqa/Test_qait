/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.MessageCenterScenarios;


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
public class StudentIsAbleToViewPostMessagesTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: NG-32939", true);
        test = new TestSessionInitiator("Student Is Able To View Post Messages Test : JIRA Story ID: https://jira.cengage.com/browse/NG-32595");
        user = System.getProperty("user", "student");
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    
    /*View Posted Message form MessageCenter
    */
   @Test
    public void TestStep_03_viewPostedMessages() {
         test.DashBoardPage.LaunchAppFromAppDock("messagecenter");
         Assert.assertTrue(test.MessageCenterPage.verifyMessageDisplayInPanelAtStudent());
         Reporter.log(user+" Successfully Receive The Message",true);
    }
     /*View Urgent Posted Message form MessageCenter
    */
   @Test
    public void TestStep_04_viewUrgentPostedMessages() {
         Assert.assertTrue(test.MessageCenterPage.verifyUrgnetMessageDisplayInPanelAtStudent());
         test.DashBoardPage.closeOpenApp();
         Reporter.log(user+" Successfully Receive The Urgent Message",true);
    }
  
   /*User Logout 
    */
   @Test
    public void TestStep_05_Logout() {
         test.DashBoardPage.Logout();
         Reporter.log(user+" successfully Logout",true);
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

