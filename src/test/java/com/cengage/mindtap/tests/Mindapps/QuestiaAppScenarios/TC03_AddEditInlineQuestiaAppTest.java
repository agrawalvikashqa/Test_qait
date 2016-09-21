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
public class TC03_AddEditInlineQuestiaAppTest {
TestSessionInitiator test;
String tier = ObjectFileReader.getTier().replaceAll("/", "");
String unitName = getData("learningActivities.QuestiaApp.unitName");
String chapterName = getData("learningActivities.QuestiaApp.chapterName");
String QuestiaApp_inlineActivityTitle = getData("learningActivities.QuestiaApp.inlineActivityTitle");
String description = getData("learningActivities.QuestiaApp.description");
String newDescription = getData("learningActivities.QuestiaApp.newDescription");
String newInlineActivityTitle = getData("learningActivities.QuestiaApp.newInlineActivityTitle");

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
    public void TestStep_03_launchReadingActivuty() {
     test.DashBoardPage.clickOnView("Unit View");
     test.readingPage.launchReadingActivityToAddInLineActivity(getData("learningActivities.QuestiaApp.unitName"), getData("learningActivities.QuestiaApp.chapterName"));
    }

    @Test
    public void TestStep_04_addInlineActivityInChapter() {
        test.FramesPage.switchToMainFrame();
        test.readingPage.clickOnEditModeAndAddIconLiknsAndNavigateToChapterIntroductionPage();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.clickOnActivity("Questia");
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.QuestiaPage.verifySearchbox();
        test.QuestiaPage.selectSearchByTerm("History");
        test.QuestiaPage.clickonSearchButton();
        test.QuestiaPage.clickonAddToMindtapButton();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addInlineActivityDiscriptionAndTitle(QuestiaApp_inlineActivityTitle, description);
        Reporter.log("verify activity added to Reader",true);
    }
    /**
 * TODO : Edit changes are not reflecting for inline questia activity.
 *
 */
    
   // @Test
    public void TestStep_05_editInlineQuestiaActivity() {
        test.FramesPage.switchToDefaultContent();
        test.FramesPage.switchToMainFrame();
        test.readingPage.clickOnEditMode();
        test.QuestiaPage.clickOnInlineEditIconAndEditActivity();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addInlineActivityDiscriptionAndTitle(newInlineActivityTitle , newDescription);
        Reporter.log(" inline activity edited successfully",true);
      
   
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

