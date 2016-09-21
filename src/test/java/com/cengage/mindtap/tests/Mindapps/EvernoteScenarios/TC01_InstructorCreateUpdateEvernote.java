/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.EvernoteScenarios;


import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import com.qait.automation.utils.ReportMsg;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * 
 * @author QAI
 */
public class TC01_InstructorCreateUpdateEvernote {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: 32937", true);
        test = new TestSessionInitiator("Average Widget ");
        user = System.getProperty("user", "instructor");
    
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        test.DashBoardPage.verifyCengageLogoIsDisplayedInDashboardView();
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    @Test
    public void TestStep_02_LaunchandSignIntoEvernoteApp(){
        System.out.print("test");
        test.DashBoardPage.clickOnAppByName("Notebook");
        test.FramesPage.switchToDockIFrame();
        test.EvernoteAppPage.clickOnSignInLink();
        test.EvernoteAppPage.SignIntoApp();
        
        Reporter.log(user+" successfully signed into evernote app",true);
    }
        
     @Test
    public void TestStep_03_InstructorAddNote(){
        test.FramesPage.switchToDefaultContent();
        test.FramesPage.switchToDockIFrame();
        test.EvernoteAppPage.AddNote("Aphabet A Sort note");
        test.EvernoteAppPage.AddNote("B second sort note");
        test.EvernoteAppPage.AddNote("Instructor created note");
       
   }
    
   @Test
    public void TestStep_04_InstructorEditandDeleteNote() throws AWTException{
        
      test.EvernoteAppPage.editNote();
      
   }
    
    @Test
    public void TestStep_06_InstructorsortByTitle() throws AWTException{
        
      test.EvernoteAppPage.sort();
      
   }
    
    
    @Test
    public void TestStep_07_InstructorDeleteNote(){
        test.EvernoteAppPage.deleteNote();
    }
    
    @Test
    public void TestStep_08_InstructorSignOutEvernote(){
        test.EvernoteAppPage.signOut();
        ReportMsg.info(user+" succesfully signed out");
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
