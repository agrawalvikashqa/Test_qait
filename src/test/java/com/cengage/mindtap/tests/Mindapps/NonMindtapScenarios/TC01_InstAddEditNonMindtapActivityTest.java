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
public class TC01_InstAddEditNonMindtapActivityTest {
TestSessionInitiator test;
        String tier = ObjectFileReader.getTier().replaceAll("/", "");

        String user;
        String userStudent; 
        String activityName = getData("learningActivities.NonMindTap.name");
        String NonMindtap_Gradedtitle = getData("learningActivities.NonMindTap.Gradedtitle");
        String NonMindtap_Gradeddescription = getData("learningActivities.NonMindTap.Gradeddescription");
        String NonMindtap_Practicetitle = getData("learningActivities.NonMindTap.Practicetitle");
        String NonMindtap_PracticeGradeddescription = getData("learningActivities.NonMindTap.Practicedescription");
        String NonMindtap_Gradednewtitle = getData("learningActivities.NonMindTap.Graded_newtitle");
        String NonMindtap_Gradednewdescription = getData("learningActivities.NonMindTap.Graded_newdescription");
        String NonMindtap_Practicenewtitle = getData("learningActivities.NonMindTap.Practice_newtitle");
        String NonMindtap_Practicenewdescription = getData("learningActivities.NonMindTap.Practice_newdescription");

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
    public void TestStep_03_addDistinctGradedNonMindTapActivity() {
        test.DashBoardPage.clickOnActivity(activityName);
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.NonMindtapPage.EnterActivityTitleAndDescription(NonMindtap_Gradedtitle , NonMindtap_Gradeddescription);
        test.NonMindtapPage.SelectGradedTypeActivity();
        test.NonMindtapPage.ClickOnSaveButton();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.clickOnSaveButtonInTitlePage();
    }
    /*This test case covers:
        *Edit Distinct Graded NonMindTap Activity
        **/ 
    
    @Test
    public void TestStep_04_instructorEditDistinctGradedNonMindTapActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.editDistinctActivityNoEdit(NonMindtap_Gradedtitle);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addActivityDiscriptionAndTitle(NonMindtap_Gradednewtitle , NonMindtap_Gradednewdescription);    
}
     @Test
    public void TestStep_05_clickOnAddIconAndAddActivity() {
        test.DashBoardPage.clickOnView("Week View");
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    }
    /*This test case covers:
        *Add Distinct Practice NonMindTap Activity
        **/ 
    @Test
    public void TestStep_06_addDistinctPracticeNonMindTapActivity() {
        test.DashBoardPage.clickOnActivity(activityName);
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.NonMindtapPage.EnterActivityTitleAndDescription(NonMindtap_Practicetitle , NonMindtap_PracticeGradeddescription);
        test.NonMindtapPage.SelectPracticeTypeActivity();
        test.NonMindtapPage.ClickOnSaveButton();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.clickOnSaveButtonInTitlePage();
    }
    /*This test case covers:
        *Edit Distinct Practice NonMindTap Activity
        **/ 
    @Test
    public void TestStep_07_instructorEditDistinctPracticeNonMindTapActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.editDistinctActivityNoEdit(NonMindtap_Practicetitle);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addActivityDiscriptionAndTitle(NonMindtap_Practicenewtitle , NonMindtap_Practicenewdescription);   
}
    /*This test case covers:
        *Launch Distinct Graded NonMindTap Activity
        **/ 
    @Test
    public void TestStep_08_instructorLaunchDistinctGradedNonMindtapActivity() {
        test.DashBoardPage.launchDistinctActivity(getData("learningActivities.NonMindTap.Graded_newtitle"));
        test.DashBoardPage.closeLaunchedActivity(NonMindtap_Gradednewtitle);
        Reporter.log ("Completed Instructor launch Distinct Graded Non Mindtap Activity Test" + "\n" ,true);  
}
    /*This test case covers:
        *Launch Distinct Practice NonMindTap Activity
        **/ 
    @Test
    public void TestStep_09_instructorLaunchDistinctPracticeNonMindtapActivity() {
        test.DashBoardPage.launchDistinctActivity(getData("learningActivities.NonMindTap.Practice_newtitle"));
        test.DashBoardPage.Logout();
        Reporter.log ("Completed Instructor launch Distinct Practice Non Mindtap Activity Test" + "\n" ,true);  
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



