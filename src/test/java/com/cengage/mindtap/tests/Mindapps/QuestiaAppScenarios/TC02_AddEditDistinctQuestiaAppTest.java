/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.QuestiaAppScenarios;

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
public class TC02_AddEditDistinctQuestiaAppTest {
 TestSessionInitiator test;
String tier = ObjectFileReader.getTier().replaceAll("/", "");
String description = getData("learningActivities.QuestiaApp.description");
String QuestiaApp_title = getData("learningActivities.QuestiaApp.title");
String newDescription = getData("learningActivities.QuestiaApp.newDescription");
String newTitle = getData("learningActivities.QuestiaApp.newTitle");

String user;

@BeforeClass
        public void start_test_session() {
           Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32839", true);
           test = new TestSessionInitiator("Questia App Test");
           user = System.getProperty("user", "instructor");
          }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
}
  @Test
    public void TestStep_02_clickOnAddActivityIcon() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    Reporter.log("verify AddActivity window successfully",true);
    }
   @Test
public void TestStep_03_AddQuestiaActivityToLPN(){
        test.DashBoardPage.clickOnActivity("Questia");
        test.FramesPage.switchToDistinctActivityCreateFrame();  
        test.QuestiaPage.verifySearchbox();
        test.QuestiaPage.selectSearchByTerm("History");
        test.QuestiaPage.clickonSearchButton();
        test.QuestiaPage.clickonAddToMindtapButton();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addActivityDiscriptionAndTitle(QuestiaApp_title, description);
        Reporter.log(" verify activity added to LPN",true);
      }

   @Test
    public void TestStep_04_instructorLaunchQuestiaActivity() {
         test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.launchDistinctActivity(QuestiaApp_title);
        test.FramesPage.switchToMainFrame();
        test.QuestiaPage.verifyQuestiaActivityLauched(QuestiaApp_title);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.closeLaunchedActivity(QuestiaApp_title);
        Reporter.log(" activity launch successfully",true);

 }
   @Test
    public void TestStep_05_instructorEditQuestiaActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.editDistinctActivityNoEdit(QuestiaApp_title);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addActivityDiscriptionAndTitle(newTitle, newDescription);
        Reporter.log(" activity edited successfully",true);
        
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
 
