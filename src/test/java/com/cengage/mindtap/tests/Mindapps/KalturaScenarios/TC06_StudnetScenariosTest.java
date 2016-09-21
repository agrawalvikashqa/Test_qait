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
public class TC06_StudnetScenariosTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32749", true);
        test = new TestSessionInitiator("Studnet Scenarios Test");
        user = System.getProperty("user", "student");
    }
    
    @Test
    public void TestStep_02_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    @Test
    public void TestStep_03_VerifyInlineActivity() {
     
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("Books.courseKaltura.unitName"), getData("Books.courseKaltura.chapterName"));
        Assert.assertTrue(test.DashBoardPage.verifyInlineActivityByDescription("Inline Kaltura Activity"));
        Reporter.log("Successfully verify that Kaltura inline activity is present" + "\n" ,true);      
        test.DashBoardPage.Logout(); 
    }
    
    @Test
    public void TestStep_05_VerifyFilterOptionFromStudentEnd() {
    user = System.getProperty("user", "instructor");
    test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
    test.DashBoardPage.clickOnAllApps();
    test.kalturaAppPage.clickOnKalturaApp();
    Reporter.log(user+" Successfully Launch  Kaltura from My Content App in App Dock",true);
    test.kalturaAppPage.VerifyFilterOption();
    Reporter.log(user+" Successfully Verify Filter Option",true);
    
    }
    
    @Test
    public void TestStep_06VerifySortingFiles() {
        test.DashBoardPage.clickOnAllApps();
        test.kalturaAppPage.clickKalturaAppStudent();
        Assert.assertTrue(test.kalturaAppPage.VerifySortingAlpha());
        Reporter.log(user+" Successfully Verify Alpha Sorting ",true);
        Assert.assertTrue(test.kalturaAppPage.VerifySortingMostRecent());
        Reporter.log(user+" Successfully Verify Most Recent Sorting",true);
        
    }
    
    @Test
    void TestStep_06_logOut(){
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
