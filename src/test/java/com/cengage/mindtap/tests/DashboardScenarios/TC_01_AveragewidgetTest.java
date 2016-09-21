/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.DashboardScenarios;


import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import com.qait.automation.utils.ReportMsg;
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
public class TC_01_AveragewidgetTest {
    
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
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseATP.courseKey"),getData("Books.courseATP.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    
    @Test
    public void TestStep_03_VerifyAverageWidgetDisplay(){
        
        test.DashBoardPage.verifyAverageWidget();
        ReportMsg.log("Succesfully Verify that instructor is able to see Class Average widget just above to performance widget."); 
    }
    
    @Test
    public void TestStep_04_VerifyDefaultClassAverage(){
        
        test.DashBoardPage.verifyDefaultClassAverageBar();
        ReportMsg.log("Succesfully Verify that Default Class Average is showing %");
    }
    
    /*User Logout 
    */
   @Test
    public void TestStep_05_Logout() {
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
