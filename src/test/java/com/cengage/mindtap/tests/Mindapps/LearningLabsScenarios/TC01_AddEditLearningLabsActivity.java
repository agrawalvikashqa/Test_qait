/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.LearningLabsScenarios;

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
public class TC01_AddEditLearningLabsActivity {
 TestSessionInitiator test;
        String tier = ObjectFileReader.getTier().replaceAll("/", "");

        String user;
        String userStudent;
        String activityName = getData("learningActivities.LearningLabs.name");
        String LearningLabs_title = getData("learningActivities.LearningLabs.title");
        String description = getData("learningActivities.LearningLabs.description");
        String LearningLabs_newtitle = getData("learningActivities.LearningLabs.newTitle");
        String newdescription = getData("learningActivities.LearningLabs.newDescription");

        @BeforeClass
        public void start_test_session() {
            Reporter.log("Jira Ticket:- https://jira.cengage.com/browse/NG-33007", true);
            test = new TestSessionInitiator("LearningLabs App Test");
            user = System.getProperty("user", "instructor");
          }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAA.courseKey"),getData("Books.courseAA.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
        /*This test case covers:
        *verify the click on add activity button
        **/
        
    @Test
        public void TestStep_02_clickOnAddIconAndAddActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
        
          /*This test case covers:
        *Add Distinct Learning Labs Activity
        **/ 
        
        }
    @Test
    public void TestStep_03_addDistinctLearningLabsActivity() {
        test.DashBoardPage.clickOnActivity(activityName);
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.LearningLabsPage.ClickOnSelectButton();
        test.LearningLabsPage.EnterActivityTitleAndDescription(LearningLabs_title , description);
        test.LearningLabsPage.ClickOnCreateButton();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.clickOnSaveButtonInTitlePage();
        
        /*This test case covers:
        *Edit Distinct Learning Labs Activity
        **/ 
    }
    @Test
    public void TestStep_04_instructorEditLearningLabsActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.editDistinctActivity(LearningLabs_title);
        test.FramesPage.switchToDefaultContent();
        test.FramesPage.switchToModeOptionsEditFrame();
        test.LearningLabsPage.EditActivityTitleAndDescription(LearningLabs_newtitle , newdescription);
        test.FramesPage.switchToDefaultContent();
        test.FramesPage.switchToModeOptionsEditFrame();
        test.LearningLabsPage.ClickOnUpdateButton();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.clickOnSaveButtonInTitlePage();
        
        /*This test case covers:
        *Launch Distinct Learning Labs Activity
        **/ 
    }
    @Test
    public void TestStep_05_instructorLaunchLearningLabsActivity() {
        test.DashBoardPage.launchDistinctActivity(getData("learningActivities.LearningLabs.newTitle"));
        test.DashBoardPage.Logout();
        Reporter.log ("Completed Instructor launch Distinct Learning Labs Activity Test" + "\n" ,true);  
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
