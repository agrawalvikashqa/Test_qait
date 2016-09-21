/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.History.Mindapps.MessageCenter;


import com.cengage.mtx.tests.Chemistry.Mindapps.MessageCenter.*;
import com.cengage.mtx.tests.AmericanGovernment.Mindapps.MessageCenter.*;
import com.cengage.mindtap.tests.Mindapps.MessageCenterScenarios.*;
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
public class MTXHistory_InstructorIsAbleToPostTheMessageTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Instructor Is Able To Post The Message Test : JIRA Story ID: https://jira.cengage.com/browse/NG-27427");
        user = System.getProperty("user", "instructor");
    }

   @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseHistory.courseKey"),getData("Books.courseHistory.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    /*Post a message form MessageCenter
    */
   @Test
    public void TestStep_02_PostTheMessage() {
       
         
         test.DashBoardPage.LaunchAppFromAppDock("messagecenter");
         test.MessageCenterPage.PostTheMessage();
         Assert.assertTrue(test.MessageCenterPage.verifyMessagePostAndDisplayInPanel());
         Reporter.log(user+" Successfully Post The Message",true);
    }
    @Test
    public void TestStep_03_PostTheUrgentMessage() {
         test.MessageCenterPage.postTheUrgentMessage();
         Assert.assertTrue(test.MessageCenterPage.verifyUrgentMessagePostAndDisplayInPanel());
         Reporter.log(user+" Successfully Post The Urgent Message",true);
    }
    
    @Test
    public void TestStep_04_PostTheUrgentMessageMaxwords() {
      
         test.MessageCenterPage.PostTheMessageSeeMore();
         Reporter.log(user+" Successfully Post The Urgent Message and display the see more button ",true);
    }
    
    
    @Test
    public void TestStep_05_verifyAddEmailAddress() {
         test.MessageCenterPage.addEmailAddress("testmailID");
         Assert.assertTrue(test.MessageCenterPage.verifyAddEmailAddress());
        // test.MessageCenterPage.deleteEmailAddress();
         test.DashBoardPage.closeOpenApp();
         Reporter.log(user+" Successfully Post The Urgent Message",true);
    }
     /*This TC is failing due to the truncation of the post message which is tacked by NG-32486
    We will cover this scenario in the automation of NG-32486
    */
 //@Test
    public void TestStep_06_verifyPostTheUrgentMessageMaxwords() {
         test.FramesPage.switchToDefaultContent();
         test.DashBoardPage.setBrowserZoom("80%");
         Assert.assertTrue(test.MessageCenterPage.verifyUrgentMessagePostAndDisplayButton());
         Reporter.log(user+" Successfully verify Post The Urgent Message and display the see more button ",true);
    }
    
   /*User Logout 
    */
   @Test
    public void TestStep_07_Logout() {
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

