/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.KalturaScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author ramanrayat
 */
public class Kaltura_Inst_SmokeTest {
   
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/", true);
        test = new TestSessionInitiator("kaltura App Smoke Test");
        user = System.getProperty("user", "instructor");
    }

      @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    /*This test case covers:
     *Verifying of Kaltura App
     **/
    
    @Test
    public void TestStep_02_LaunchAppFromAppDock() {
        //test.DashBoardPage.clickOnAllApps();
        test.kalturaAppPage.clickOnKalturaApp();
        Reporter.log(user+"successfully Launch My Content App From App Dock",true);
    }
    
    @Test
	public void TestStep_03_verifyKalturaUI() {
            test.FramesPage.switchToDockIFrame();
            test.FramesPage.switchToCategoryIFrame();
                Assert.assertTrue(test.kalturaAppPage.verifyIconSelectorClickable());
            System.out.println("TestStep_04_verifyKalturaUI");
	Reporter.log(user+"  successfully Verified Full Book UI",true);
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
