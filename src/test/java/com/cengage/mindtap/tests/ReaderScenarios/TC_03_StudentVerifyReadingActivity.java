/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.ReaderScenarios;


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
public class TC_03_StudentVerifyReadingActivity {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user, bookName, uname;
    
    String activity1 = getData("learningActivities.ReadingActivity.title");
    String activity_title = getData("learningActivities.ReadingActivity.title");
    
    
    
   @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Reader Activity Test");
        user = System.getProperty("user", "student");
    }

   @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseReader.courseKey"),getData("Books.courseReader.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
     @Test
    public void TestStep_02_studentVerifyTextbox(){
        test.DashBoardPage.refreshPage();
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.launchDistinctActivity(activity_title);
        test.FramesPage.switchToMainFrame();
        test.readingPage.navigateToChapterIntroductionPage();
        test.readingPage.studentVerifyTextboxAppear();
    }
    
    @Test
    public void TestStep_03_studentVerifyReaderLocation(){
      test.readingPage.clickOnActivityNextButton();
      test.readingPage.verifyChapterTitleBeforeClosingActivity();
      test.FramesPage.switchToDefaultContent();
      test.readingPage.closeOpenActivity();
      test.DashBoardPage.launchDistinctActivity(activity_title);
      test.FramesPage.switchToMainFrame();
      test.readingPage.verifyChapterTitleAfterLaunchingSameActivity();
      test.readingPage.clickOnChapterContentLink();
      ReportMsg.info(user + " successfully verified " +user + " scenarios" );
     // test.DashBoardPage.Logout();
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
