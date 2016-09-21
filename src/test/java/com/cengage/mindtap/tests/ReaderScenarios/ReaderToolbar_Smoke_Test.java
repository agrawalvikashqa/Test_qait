/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.ReaderScenarios;


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
public class ReaderToolbar_Smoke_Test {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String activityName = getData("Books.courseWebLink.name");
    String user;

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32744", true);
        test = new TestSessionInitiator("Apps check Test");
        user = System.getProperty("user", "instructor");
    }
   @Test
     public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
   @Test
    public void TestStep_02_NavigateToChapterReadingActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("Books.courseKaltura.unitName"), getData("Books.courseKaltura.chapterName"));
        Reporter.log(user+" successfully Navigate To Chapter Reading Activity",true);
    }
   @Test
    public void TestStep_03_verifyInLineActivity() {
        //test.FramesPage.switchToDefaultContent();
        test.FramesPage.switchToMainFrame();
        test.readingPage.clickOnEditModeAndAddIconLiknsAndNavigateToChapterIntroductionPage();
        test.FramesPage.switchToDefaultContent();
        Assert.assertTrue(test.DashBoardPage.verifyAddActivityDialogAppears());
        Reporter.log(user+" successfully verify InLine Activity Frame",true);
    } 
    
   @Test
    public void TestStep_04_verifyReadSpeakerClickable() {
        test.FramesPage.switchToMainFrame();
        test.readingPage.clickOnReadSpeaker();
        test.FramesPage.switchToDefaultContent();
        Reporter.log(user+" successfully verify Read Speaker Clickable",true);
    } 
    @Test
    public void TestStep_05_verifyFontSizer() {
        test.FramesPage.switchToMainFrame();
        Assert.assertTrue(test.readingPage.verifyFontSizer());
        test.FramesPage.switchToDefaultContent();
        Reporter.log(user+" successfully verify Font Sizer",true);
    } 
    
    @Test
    public void TestStep_06_verifyPrintIconWorkingFine(){
        test.FramesPage.switchToMainFrame();
        Assert.assertTrue(test.readingPage.verifyPrintIconWorkingFine(),"Print Icon is not working fine");
        test.FramesPage.switchToDefaultContent();
        Reporter.log("Print Icon  is working fine",true);
    }
    @Test
    public void TestStep_07_verifyHelpOverlayDisplay() {
        test.DashBoardPage.helpOverlayDisplay();
        Reporter.log(user+" successfully verify Help Overlay Display",true);
       
    }
      /*User Logout 
    */
   @Test
    public void TestStep_08_Logout() {
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
