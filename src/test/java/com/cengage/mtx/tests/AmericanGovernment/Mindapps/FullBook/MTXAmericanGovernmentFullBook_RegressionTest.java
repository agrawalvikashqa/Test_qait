/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.AmericanGovernment.Mindapps.FullBook;


import com.cengage.mtx.tests.History.Mindapps.FullBook.*;
import com.cengage.mtx.tests.Chemistry.Mindapps.FullBook.*;
import com.cengage.mindtap.tests.Mindapps.FullBookScenarios.*;
import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * 
 * @author QAI
 */
public class MTXAmericanGovernmentFullBook_RegressionTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32743", true);
        test = new TestSessionInitiator("Full Book App check Test");
        user = System.getProperty("user", "student");
        //test.launchApplication(getData("sso_url"));
    }

      @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAmGovt.CourseKey"),getData("Books.courseAmGovt.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    
    /*This test case covers:
     *Verifying of Full Book App
     **/
    @Test
    public void TestStep_02_LaunchAppFromAppDock() {
       // test.DashBoardPage.clickOnAllApps();
        test.DashBoardPage.clickOnAppByName("Full Book");
        Reporter.log(user+"  successfully Launched Full Book App From App Dock",true);
        
    }
   @Test
   public void TestStep_03_verifyFullBookTitle(){
       test.fullBookPage.verifyFullBookTitle();
       Reporter.log("Book title verified successfully",true);
         
   }
   @Test
   public void TestStep_04_verifyStaticFullBookBar(){
       test.fullBookPage.verifyFullBookUI();
       test.fullBookPage.verifyButtonsPresentOnStaticFullBookBar();
       Reporter.log("Chapters link, Font size buttons, Print and help overlay icon verified successfully",true);
   }
   
   @Test
   public void TestStep_05_verifyFontSizeSelection(){
       test.fullBookPage.clickOnFontSelection();
       Reporter.log("User is able to switch between different Font Sizes",true);
   }
   
   @Test
   public void TestStep_06_verifyNextPreviousButtonFunctionality(){
       test.fullBookPage.clickOnNextButton();
       test.fullBookPage.clickOnBackButton();
       Reporter.log("Next and Previous Navigation buttons are working fine",true);
   }
   
    @Test
   public void TestStep_07_verifySkimmerNavigation(){
        test.fullBookPage.verifySkimmerDisplay();
        Reporter.log("User is able to see and navigate through skimmer",true);
    }
   
   @Test
   public void TestStep_08_verifyAllChapterLinksAreAvilable(){
       test.fullBookPage.clickOnChaptersButton();
       Reporter.log("Chapter Links are verified successfully",true);
   }
   @Test
   public void TestStep_09_verifyChapterSelectionAndLaunch(){
       test.fullBookPage.verifyChapterOpened();
       Reporter.log("Selected chapter opened successfully",true);
   }
   @Test
   public void TestStep_10_verifyPrintFullBook(){
       test.fullBookPage.clickOnPrintSelection();
       test.FramesPage.switchToDefaultContent();
       Assert.assertTrue(test.fullBookPage.verifyPrintPreview());
       Reporter.log("Successfully Verified Print functionality for fullbook",true);
   }
   
   @Test
   public void TestStep_11_verifyCloseFullBookButton(){
       test.DashBoardPage.closeOpenApp();
       Reporter.log("Successfully Closed FullBook App",true);
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