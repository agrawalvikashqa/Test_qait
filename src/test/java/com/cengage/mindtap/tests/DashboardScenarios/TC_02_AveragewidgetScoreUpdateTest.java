/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.DashboardScenarios;

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
public class TC_02_AveragewidgetScoreUpdateTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: 32937", true);
        test = new TestSessionInitiator("Average Widget ");
        user = System.getProperty("user", "instructor");
        
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseGradeBook.courseKey"),getData("Books.courseGradeBook.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    @Test
    public void TestStep_02_VerifyUpdatedAveragescore()
    {
        test.DashBoardPage.verifyUpdateScore();
        
    }
    
       /*User Logout 
    */
   @Test
    public void TestStep_03_Logout() {
         test.DashBoardPage.Logout();
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
