/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.JiraCards;


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
public class NG_33413Test {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String activityName = getData("Books.courseWebLink.name");
    String logMsg="Uncaught SyntaxError: Unexpected token c in JSON at position 2";
    String user;

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-33413", true);
        test = new TestSessionInitiator("BUG: NG-33413");
        user = System.getProperty("user", "instructor2");
    }
   @Test
     public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course2.courseKey"),getData("Books.course2.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
   @Test
    public void TestStep_02_NavigateToChapterReadingActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("Books.courseMedicalTerminology.unitName"), getData("Books.courseMedicalTerminology.chapterName"));
        Reporter.log(user+" successfully Navigate To Chapter Reading Activity",true);
    }
   @Test
    public void TestStep_03_analyzeLog() {
        
        Reporter.log(" ********************* Console Logs **********************",true);
        test.DashBoardPage.analyzeBrowserLog();
        test.DashBoardPage.analyzeCLIENTLog();
        test.DashBoardPage.analyzeDRIVERLog();
//        test.DashBoardPage.analyzePERFORMANCELog();
//        test.DashBoardPage.analyzePROFILERLog();
//        test.DashBoardPage.analyzeSERVERLog();
       Reporter.log(" ********************** Console Logs *****************************",true);
       Assert.assertFalse(test.DashBoardPage.cheakconsoleLogs(logMsg));
       Reporter.log(" Succsfully Verified LOG Messeage :"+ logMsg +": is not present",true);
    }
    
      /*User Logout 
    */
   @Test
    public void TestStep_08_Logout() {
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
