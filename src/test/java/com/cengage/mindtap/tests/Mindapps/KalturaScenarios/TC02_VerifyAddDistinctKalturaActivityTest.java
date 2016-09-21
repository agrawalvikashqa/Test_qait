/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.KalturaScenarios;


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
public class TC02_VerifyAddDistinctKalturaActivityTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32749", true);
        test = new TestSessionInitiator("Full Kaltura App check Test");
        user = System.getProperty("user", "student");
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
     @Test
    public void TestStep_03_clickOnAddIconAndAddActivity() {
        test.DashBoardPage.clickOnView("Unit View");
    }
    
    @Test 
    void TestStep_04_EnterNextbookAsStudentAndVerifyDistinctKalturaActivity(){
        Assert.assertTrue(test.kalturaAppPage.viewDistinctKalturaActivity(getData("learningActivities.Kaltura.title")));
        Reporter.log ("Completed Enter NextBook As Student And Verify Distinct Kaltura Activity",true);
        test.DashBoardPage.Logout();
    }
    
    
     @Test
    void TestStep_05_logOut(){
        test.DashBoardPage.Logout(); 
        Reporter.log("Completed logOut",true);
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
