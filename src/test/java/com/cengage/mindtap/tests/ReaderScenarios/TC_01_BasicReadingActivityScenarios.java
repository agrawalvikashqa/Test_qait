/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.ReaderScenarios;


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
public class TC_01_BasicReadingActivityScenarios {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Reader Toolbar In Readers Test");
        user = System.getProperty("user", "instructor");
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseReader.courseKey"),getData("Books.courseReader.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
   @Test
    public void TestStep_02_LaunchReadingActivityAndVerifyTOCpage() {
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("learningActivities.ReadingActivity.unitName"), getData("learningActivities.ReadingActivity.chapterName"));
        Reporter.log(user+" successfully Navigate To Chapter Reading Activity",true);
    }
  
    @Test
    public void TestStep_03_VerifyTOCPage(){
        test.FramesPage.switchToMainFrame();
       test.readingPage.verifyTOCButtonIsPresent();
        test.readingPage.verifyTOC();
        test.readingPage.verifyNavgationViaSkimmerAndArrow();
     //   test.readingPage.verifyUIandNavigations();
    }

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
    
    @AfterClass(alwaysRun = true)
    public void stop_test_session() {
        test.closeTestSession();
    }
    
}
