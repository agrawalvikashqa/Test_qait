/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.ReleaseTests.Release3_36_3;

import com.qait.automation.TestInitiator.TestSessionInitiator;
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
public class NG_33318Test {
  TestSessionInitiator test;
    String user, bookName;
     String expectedsrc="http://mindtap-staging.cengage.com/static/nb/ui/images/reskin/mindtap.png";
   

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-33318", true);
        test = new TestSessionInitiator("Reader Modes: \"Mindtap Logo\" is not appearing on Upper Left hand corner");
        user = System.getProperty("user", "admin");
        bookName = getData("Books.readermaster.masterName");
        test.launchApplication(getData("base_url"));
    }

    @Test
    public void TestStep_01_LoginToMindTapApplication() {
        test.adminLoginPage.loginToMindTapApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")));
        test.masterPage.verifyuserIsOnMastersPage();
        Reporter.log(user + " successfully logs in to the application", true);
    }
   @Test
    public void TestStep_02_VerifyMindTapLogo() {
        test.masterPage.enterBookNameAndSearch(bookName);
        test.masterPage.launchMasterBook(bookName);
        ReportMsg.info("*****Verifying MindTap logo*****");
        String actualsrc= test.DashBoardPage.mindtapLogo();
        ReportMsg.info("Expected Text: "+expectedsrc);
        ReportMsg.info("Actual Text: "+actualsrc);
        Assert.assertEquals(actualsrc,expectedsrc,"Mindtap logo not found");
        Reporter.log("***********Jira ticket NG-33318 verified succesfully************",true);
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
