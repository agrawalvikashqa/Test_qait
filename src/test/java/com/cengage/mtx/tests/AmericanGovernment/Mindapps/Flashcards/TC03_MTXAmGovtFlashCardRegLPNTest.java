/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.AmericanGovernment.Mindapps.Flashcards;

import com.cengage.mindtap.tests.Mindapps.FlashCardScenarios.*;
import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author mohammadparvez
 */
public class TC03_MTXAmGovtFlashCardRegLPNTest {
    
     TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String title;
    String description;
    

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32744", true);
        test = new TestSessionInitiator("FlashCard App check Test");
        user = System.getProperty("user", "instructor");
       title= "FlashCardTitle"+test.flashcardpage.appendTimeStamp();
       description= "FlashCardDescription"+test.flashcardpage.appendTimeStamp();
    }
    
  @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAmGovt.CourseKey"),getData("Books.courseAmGovt.ISBN"));
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
public void TestStep_04_VerifyFlashCardActivityOnLPN(){
    test.DashBoardPage.clickOnView("Unit View");
    Assert.assertTrue(test.DashBoardPage.verifyActivityByDescription(description),"Add FlashCard to LPN Failed");
    Reporter.log("[ASSERT PASS]:Newly added Flash Card Activity verified successfully on LPN",true);
}
@Test
public void TestStep_05_LaunchFlashCardActivityOnLPN(){
     test.DashBoardPage.launchDistinctActivity(title);
     Reporter.log("[ASSERT PASS]:Flash Card launched successfully from LPN",true);
     test.flashcardpage.closeFlashCard();
     Reporter.log("[ASSERT PASS]:Flash Card closed successfully from LPN",true);
     }
@Test
public void TestStep_06_EditFlashCardActivityOnLPN(){
    test.DashBoardPage.clickOnDistinctActivityEditButton("Flashcards");
    test.DashBoardPage.addActivityDescriptionAndTitle(title,description);
    Reporter.log("[ASSERT PASS]:Flash Card edited successfully from LPN",true);
}



@Test
public void TestStep_07_close_test_session(){
        test.closeTestSession();
}

 @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        
        test.takescreenshot.takeScreenShotOnException(result);
    }   
    
}
