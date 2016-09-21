/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.ALGAppScenarios;

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
public class TC03_StudentVerifyDistinctInlineALGActivityTest {
TestSessionInitiator test;
        String tier = ObjectFileReader.getTier().replaceAll("/", "");

        String user;
        String userStudent; 
        String newDescription = getData("learningActivities.ALG.newDescription");
        String newTitle = getData("learningActivities.ALG.newTitle");
        String inlinenewTitle = getData("learningActivities.ALG.inlinenewTitle");
        
        @BeforeClass
        public void start_test_session() {
            Reporter.log("Jira Ticket:- https://jira.cengage.com/browse/NG-33125", true);
            test = new TestSessionInitiator("ALG App Test");
            user = System.getProperty("user", "student");
          }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAA.courseKey"),getData("Books.courseAA.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    /*This test case covers:
     *Verifying of launch ALG Activity 
     **/  

    @Test
    public void TestStep_02_studentLaunchDistinctQuestiaActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.launchDistinctActivity(newTitle);
        test.FramesPage.switchToMainFrame();
//        test.ALGAppPage.VerifyIconsOnALGApp();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.closeLaunchedActivity(newTitle);
        Reporter.log(" Student activity launch successfully",true);
       
    }
    @Test
    public void TestStep_03_launchReadingActivuty() {
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("learningActivities.ALG.unitName"), getData("learningActivities.ALG.chapterName"));
    } 
    @Test
    public void TestStep_04_studentLaunchInlineQuestiaActivity() {
        test.FramesPage.switchToMainFrame();
        test.readingPage.navigateToChapterIntroductionPage();
      //  test.ALGAppPage.LaunchInlineALGActivity();
        test.FramesPage.switchToDockIFrame();
       // test.ALGAppPage.VerifyIconsOnALGApp();
        test.DashBoardPage.closeOpenApp();
        test.lpnPage.logOutFromMindTap();
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