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
public class TC01_AddDistinctKalturaActivityTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32749", true);
        test = new TestSessionInitiator("Kaltura App check Test");
        user = System.getProperty("user", "instructor");
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
     @Test
    public void TestStep_02_clickOnAddIconAndAddActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    
    }
    
     @Test
    public void TestStep_03_addDistinctKalturaActivity() {
     
    test.kalturaAppPage.addDistinctKalturaActivity("Distinct Kaltura Activity");
    test.FramesPage.switchToDefaultContent();
    test.DashBoardPage.addActivityDiscriptionAndTitle("Distinct Kaltura Activity", "Created by Automation Script");
    Assert.assertTrue(test.DashBoardPage.verifyActivityByDescription("Created by Automation Script"));
    }
    
    @Test
    public void TestStep_04_editDistinctKalturaActivity(){  
    test.kalturaAppPage.editDistinctKalturaActivity(getData("learningActivities.Kaltura.title"));
    Reporter.log ("Completed edit Distinct Kaltura Activity Test" + "\n" ,true);      
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
