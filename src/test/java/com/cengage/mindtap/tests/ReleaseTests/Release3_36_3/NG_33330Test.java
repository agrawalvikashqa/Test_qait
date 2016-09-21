/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.ReleaseTests.Release3_36_3;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import com.qait.automation.utils.ReportMsg;
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
public class NG_33330Test {
    
      TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-33330", true);
        test = new TestSessionInitiator("Help Overlay:Move the Print IT Section to the right corner");
        user = System.getProperty("user", "instructor");
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseReader.courseKey"),getData("Books.courseReader.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
   @Test
    public void TestStep_02_LaunchReadingActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("learningActivities.ReadingActivity.unitName"), getData("learningActivities.ReadingActivity.chapterName"));
        Reporter.log(user+" successfully Navigate To Chapter Reading Activity",true);
    }
  
    @Test
    public void TestStep_03_ClickOverlayAndVerifyPrintText(){
        test.FramesPage.switchToMainFrame();
        test.DashBoardPage.clickHelpOverlay();
        ReportMsg.info("User Clicked on Help Overaly");
        String actualtext= test.readingPage.verifyHelpText();
        String expectedtext= getData("Books.courseReader.helpOverlayPrint");
        ReportMsg.info("Expected Text: "+expectedtext);
        ReportMsg.info("Actual Text: "+actualtext);
        Assert.assertEquals(actualtext,expectedtext,"Print Help Overlay text verification failed");
        Reporter.log("***********Jira ticket NG-33330 verified succesfully************",true);
        
 }
            

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
    
    @AfterClass(alwaysRun = true)
    public void stop_test_session() {
        test.closeTestSession();
    }
    
}
