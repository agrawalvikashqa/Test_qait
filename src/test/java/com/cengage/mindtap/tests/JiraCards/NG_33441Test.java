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
public class NG_33441Test {
 TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;
    String title;
    String description;

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-33441", true);
        test = new TestSessionInitiator("Dashboard Error Test");
        user = System.getProperty("user", "instructor");
        title= "FlashCardTitle"+test.flashcardpage.appendTimeStamp();
       description= "FlashCardDescription"+test.flashcardpage.appendTimeStamp();
    }
     @Test
     public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseNG-33441.coursekey"),getData("Books.courseNG-33441.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }   
     @Test
    public void TestStep_02_clickOnAddActivityIcon() {
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
        test.FramesPage.switchToDefaultContent();
        Reporter.log("[ASSERT PASS]:Add Activity icon clicked successfully from LPN ",true);
        
    }
    @Test
   public void TestStep_03_AddFlashCardActivityToLPN(){
        test.DashBoardPage.clickOnActivity("Flashcards");
        test.FramesPage.switchToDefaultContent();
        test.flashcardpage.selectChapterForFlashCardActivity();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addActivityDescriptionAndTitle(title, description);
        Reporter.log("[ASSERT PASS]:New Flashcard added to LPN successfully ",true);
        
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
