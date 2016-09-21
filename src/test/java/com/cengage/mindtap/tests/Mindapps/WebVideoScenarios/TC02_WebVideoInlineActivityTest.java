/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.WebVideoScenarios;

/**
 *
 * @author QAI
 */

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import com.qait.automation.utils.ReportMsg;
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
public class TC02_WebVideoInlineActivityTest { 
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String activityName = getData("Books.courseWebVideo.name");
    String text = getData("Books.courseWebVideo.text"); 
    String beforeText = getData("Books.courseWebVideo.text");
    String afterText = getData("Books.courseWebVideo.text");
    String desc = getData("Books.courseWebVideo.description");
    String title = getData("Books.courseWebVideo.title");
    String BeforeEditedDesc = getData("Books.courseWebVideo.BeforeEditedDesc");
    String AfterEditedDesc = getData("Books.courseWebVideo.AfterEditedDesc");
    String uname = getData("Books.courseWebVideo.unitName");
    String cname = getData("Books.courseWebVideo.chapterName");
    
    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32749", true);
        test = new TestSessionInitiator("Web Video");
        user = System.getProperty("user", "instructor");
    
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    @Test
    public void TestStep_03_clickOnAddIconAndAddActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        
    
    }
    
    @Test
    public void TestStep_04_addInlineWebVideoActivity(){
        test.readingPage.launchReadingActivityToAddInLineActivity(uname, cname);
        test.FramesPage.switchToMainFrame();
        test.readingPage.clickOnEditModeAndAddIconLiknsAndNavigateToChapterIntroductionPage();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.clickOnActivity(activityName);
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.webvideopage.searchyoutubevideo(text);
        test.webvideopage.addwebvideoactivity(text);
        ReportMsg.info("inline activity added");
      
    }
    
   @Test
    public void TestStep_05_editInlineWebVideoActivity(){
        test.FramesPage.switchToDefaultContent();
        test.FramesPage.switchToMainFrame();
        ReportMsg.info("Navigated to default activity frame");
        test.readingPage.clickOnEditMode();
        test.readingPage.clickOnEditMode();
        
//        ReportMsg.info("edit clicked");
        test.webvideopage.clickOnInlineEditAndEditActivity();
        test.FramesPage.switchToDefaultContent();
        test.FramesPage.switchToModeOptionsEditFrame();
        test.webvideopage.addTextFields(BeforeEditedDesc, AfterEditedDesc);
        test.webvideopage.clickonContinueAndSaveButton();
         ReportMsg.info("User edited the inline activity successfully");
        test.FramesPage.switchToDefaultContent();
        
       test.lpnPage.logOutFromMindTap();
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
