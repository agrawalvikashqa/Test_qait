/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.DateManagerScenarios;

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
 * @author QAI
 */
public class DateManagerRegressionTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32927", true);
        test = new TestSessionInitiator("Date Manager Regression Test");
        user = System.getProperty("user", "instructor");
        //test.launchApplication(getData("sso_url"));
    }

   @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    @Test
    public void TestStep_02_verifyInstructorNavigatesDateManagerView(){
       test.DateManagerPage.clickOnDateManagerView();
       Reporter.log(user+"  successfully Navigated to Date Manager View ",true);
    }
    
    @Test
    public void TestStep_03_verifyAvailableDateAndDueDateColumns(){
        test.DateManagerPage.availableDateDueDateColumns();
        Reporter.log("Successfully verified the Available and Due date Columns in Header",true);
    }
    
    @Test
    public void TestStep_04_verifyCalenderIconsForBothAvailableAndDueDate(){
        test.DateManagerPage.calenderIconsForAvailableAndDueDate();
        Reporter.log("Calender icons Successfully verified for both Available and Due Date",true);
    }
    
    @Test
    public void TestStep_05_verifyInstructorSetAvailableDateOfSingleActivity(){
        test.DateManagerPage.setAvailableDateForSingleActivity();
        Reporter.log("User has successfully set Available date for Single Activity",true);
    }
    
    @Test
    public void TestStep_06_verifyInstructorClearsAvailableDateOfSingleActivity(){
        test.DateManagerPage.clearAvailableDateForSingleActivity();
        Reporter.log("User has successfully Cleared Available date for Single Activity",true);
    }
    
    @Test
    public void TestStep_07_verifyInstructorSetsDueDateOfSingleActivity(){
        test.DateManagerPage.setDueDateOfSingleActivity();
        Reporter.log("User has successfully set Due date for Single Activity",true);
    }
    
    @Test
    public void TestStep_08_verifyInstructorClearsDueDateOfSingleActivity(){
        test.DateManagerPage.clearDueDateForSingleActivity();
        Reporter.log("User has successfully Cleared Due date for Single Activity",true);
    }
    
    @Test
    public void TestStep_09_verifyInstructorSetsDueDateInBulk(){
        test.DateManagerPage.setDueDateInBulk();
        Reporter.log("User has successfully Set Due date For Multiple activities",true);
    }
    
    @Test
    public void TestStep_10_verifyInstructorClearsDueDateInBulk(){
        test.DateManagerPage.clearDueDateInBulk();
        Reporter.log("User has successfully Cleared Due date For Multiple activities",true);
    }
    
    @Test
    public void TestStep_11_verifyInstructorSetsAvailableDateInBulk(){
        test.DateManagerPage.setAvailableDateInBulk();
       Reporter.log("User has successfully set Available date For Multiple activities",true); 
    }
    
    @Test
    public void TestStep_12_verifyInstructorClearsAvailableDateInBulk(){
        test.DateManagerPage.clearAvailableDateInBulk();
        Reporter.log("User has successfully Cleared Available date For Multiple activities",true); 
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
