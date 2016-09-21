/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.JiraCards;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
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
public class NG_33224Test {
 TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;
    String title;
    String description;

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-33224", true);
        test = new TestSessionInitiator("More and less Button Error Test");
        user = System.getProperty("user", "instructor");
      }
     @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAA.courseKey"),getData("Books.courseAA.ISBN"));
        Reporter.log(user+" successfully logs in to the application",true); 
    }
 
      @Test
    public void TestStep_02_VerifyMoreAndLessButtonsAreOverlappingWithApp() {
        Assert.assertTrue(test.GenericAppDockPage.verifyMoreAndLessButtonsAreOverlappingWithApp());
        Reporter.log(user+" verify More And Less Buttons Are Overlapping With App",true); 
        Reporter.log(user+" verified https://jira.cengage.com/browse/NG-33224 is not Reproducible ",true); 
    }
    
    @Test
    public void TestStep_04_Logout() {
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
