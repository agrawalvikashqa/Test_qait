/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.JiraCards;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import com.qait.automation.utils.ReportMsg;
import static com.qait.automation.utils.YamlReader.getData;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author QAI
 */
public class NG_32891Test {
TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String activityName = getData("Books.courseWebLink.name");
    String UnitName = getData("Books.courseKaltura.unitName");
    String chapterName = getData("Books.courseKaltura.chapterName");
    String user;

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32891", true);
        test = new TestSessionInitiator("Verify NG-32891");
        user = System.getProperty("user", "instructor");
    }
   @Test
     public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
   @Test
    public void TestStep_02_NavigateToUnit() {
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.SwitchToUnit(UnitName);
        Reporter.log(user+" successfully Navigate To Unit",true);
    }    
    @Test
    public void TestStep_03_VerifyFullGradebookLink(){
        test.DashBoardPage.viewAllScoresDisplayAnLaunch(user);
        test.DashBoardPage.closeOpenApp();
        ReportMsg.log("Successfully Verify that on clicking Open Full Gradebook link, Gradbook is launching");
    }
    @Test
    public void TestStep_04_NavigateToChapterReadingActivity() {
        test.readingPage.verifyTheReadingActivity(chapterName);
        Reporter.log(user+" successfully Navigate To Reading Activity",true);
        Assert.assertTrue(test.readingPage.verifyTheReadingActivity(chapterName));
}
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