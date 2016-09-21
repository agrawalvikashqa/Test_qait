/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.NonMindtapScenarios;

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
public class TC02_VerifyInstErrorMessagesTest {
 TestSessionInitiator test;
        String tier = ObjectFileReader.getTier().replaceAll("/", "");

        String user;
        String userStudent; 
        String activityName = getData("learningActivities.NonMindTap.name");
        String Error_title = getData("learningActivities.NonMindTap.Error_title"); 
        int MaxWordMessage = 2000;
        int MaxWordMessage1 = 100;
        String WordMessage = getData("learningActivities.NonMindTap.WordMessage");
                
       @BeforeClass
        public void start_test_session() {
            Reporter.log("Jira Ticket:- https://jira.cengage.com/browse/NG-33063", true);
            test = new TestSessionInitiator("Non MindTap App Test");
            user = System.getProperty("user", "instructor");
          }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAA.courseKey"),getData("Books.courseAA.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    @Test
    public void TestStep_02_clickOnAddIconAndAddActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    }
      /*This test case covers:
        *Add Distinct Graded NonMindTap Activity
        **/ 
    @Test
    public void TestStep_03_VerifyErrorMessageOnAddingNonMindtapActivity() {
        test.DashBoardPage.clickOnActivity(activityName);
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.NonMindtapPage.EnterMaxWordForActivityTitle(WordMessage, MaxWordMessage1);
        test.NonMindtapPage.ErrorMessageIsDisplayed();
        test.NonMindtapPage.EnterMaxWordForActivityDescription(WordMessage, MaxWordMessage);
        test.NonMindtapPage.DescriptionMaxLengthIsDisplayed();
        test.NonMindtapPage.SaveButtonDisabled();
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



