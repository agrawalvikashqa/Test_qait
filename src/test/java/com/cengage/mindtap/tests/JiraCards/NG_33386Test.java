/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.JiraCards;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import static com.qait.automation.utils.YamlReader.getData;
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
public class NG_33386Test {
 TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-33386", true);
        test = new TestSessionInitiator("Assignment Submit Test");
        user = System.getProperty("user", "student");
        }
     @Test
     public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseNG-33441.coursekey"),getData("Books.courseNG-33441.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }   
     @Test
    public void TestStep_02_clickOnAddActivityIcon() {
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.clickOnView("Unit View");
        test.AssignableActivityPage.clickOnAssignment();
        Reporter.log(user+"successfully launched the assignment",true);
        test.AssignableActivityPage.SubmitActivity();    
        Reporter.log(user+"successfully submitted the assignment",true);
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


