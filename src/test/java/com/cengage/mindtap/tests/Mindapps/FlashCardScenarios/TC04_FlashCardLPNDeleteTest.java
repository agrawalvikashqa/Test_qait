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
 * @author mohammadparvez
 */
public class TC04_FlashCardLPNDeleteTest {
    
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
        //test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
         test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseFlashCard.courseKey"),getData("Books.courseFlashCard.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
@Test
public void TestStep_03_VerifyFlashCardActivityOnLPN(){
    test.DashBoardPage.clickOnView("Unit View");
     Assert.assertTrue(test.DashBoardPage.verifyActivityByDescription(description),"Add FlashCard to LPN Failed");
    Reporter.log("[ASSERT PASS]:Newly added Flash Card Activity verified successfully on LPN",true);
}
       
@Test
public void TestStep_04_DeleteFlashCardActivityOnLPN(){
  test.DashBoardPage.deleteDistinctActivity(title);
  Reporter.log("[ASSERT PASS]:Flash Card deleted successfully from LPN",true);
}
@Test
public void TestStep_05_close_test_session(){
        test.closeTestSession();
}

 @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        
        test.takescreenshot.takeScreenShotOnException(result);
    }   
    
    
}
