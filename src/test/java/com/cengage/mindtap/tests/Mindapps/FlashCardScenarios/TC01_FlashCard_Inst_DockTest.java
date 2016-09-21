/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.FlashCardScenarios;

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
 * @author QAI
 */
public class TC01_FlashCard_Inst_DockTest {

    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String title;
    String description;
    

  @BeforeClass
    public void start_test_session() {
        //Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32744", true);
        test = new TestSessionInitiator("FlashCard App check Test");
        user = System.getProperty("user", "instructor");
       title= "FlashCardTitle"+test.flashcardpage.appendTimeStamp();
       description= "FlashCardDescription"+test.flashcardpage.appendTimeStamp();
    }

   @Test
     public void TestStep_01_LoginToSSOApplication() {
       test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
@Test
    public void TestStep_02_LaunchFlashCardFromAppDock() throws InterruptedException {
        test.DashBoardPage.clickOnAppByName("Flashcards");
       Reporter.log("[ASSERT PASS]:Flashcard App launched successfully from Appdock",true);
       }
@Test
public void TestStep_03_CreateNewFlashCardFromAppDock(){
    test.flashcardpage.createFlashCard(title,description);
    Reporter.log("[ASSERT PASS]:Flashcard created successfully from Appdock",true);
}

@Test
public void TestStep_04_DeleteAddedCard(){
    int initCount= test.flashcardpage.cardDeckCount();
    test.flashcardpage.removeAddedFlashCard(title);
    Reporter.log("[ASSERT PASS]:Flash Card deleted successfully from Appdock",true);
     test.DashBoardPage.closeOpenApp();
    test.DashBoardPage.clickOnAppByName("Flashcards");
    int afterCount =test.flashcardpage.cardDeckCount();
    Assert.assertEquals(initCount, afterCount+1,"FlashCardDeck number is updated correctly after Card deletion");
    Reporter.log("[ASSERT PASS]:CardDeck count updated from "+initCount+" to "+afterCount+" after successfull deletion",true);
}
@Test
public void TestStep_05_VerifyRestoreFlipFlashCard(){
    test.flashcardpage.clickOnHideCardOption();
    test.flashcardpage.verifyCardIsHiden();
    test.flashcardpage.clickOnRestoreCardOption();
    test.flashcardpage.verifyCardRestored();
      Reporter.log("[ASSERT PASS]:Hidden FlashCard restored successfully",true);
    

}
@Test
public void TestStep_06_VerifyPrintFlipFlashCard(){
    test.flashcardpage.clickOnPrintOption();
    Assert.assertTrue(test.flashcardpage.verifyPrintDialogBoxOpened(),"Print Dialog Box is not opened");
    test.flashcardpage.closePrintDialogBox();
    Reporter.log("[ASSERT PASS]:Flashcard Print action performed successfully ",true);
    }

 @Test  
public void TestStep_07_FlipFlashCard(){
    test.flashcardpage.clickOnCardToFlip();
    test.DashBoardPage.closeOpenApp();
    Reporter.log("[ASSERT PASS]:Flashcard flip action performed successfully ",true);
    }



@Test
public void TestStep_08_close_test_session(){
        test.closeTestSession();
}

 @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        
        test.takescreenshot.takeScreenShotOnException(result);
    }   
}
