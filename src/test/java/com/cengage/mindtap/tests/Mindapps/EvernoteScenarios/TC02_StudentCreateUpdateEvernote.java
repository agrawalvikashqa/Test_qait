/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.EvernoteScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import com.qait.automation.utils.ReportMsg;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * 
 * @author QAI
 */
public class TC02_StudentCreateUpdateEvernote {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

     @BeforeClass
    
    public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Insite App");
        user = System.getProperty("user", "student");
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+user+".username")), getData(("users."+user+".password")));
        Reporter.log(user+"successfully logs in to the application",true);
        //test.ssoLoginPage.enrollCourseInUser(user,getData("Books.course.courseKey")); 
    }
    
    @Test
    public void TestStep_02_LaunchCourseViaSSO(){
        if(user.equalsIgnoreCase("instructor")){
            test.instructorResourceCenterPage.instructorLaunchCourse(getData("Books.course.courseKey"), tier);
        }else if(user.equalsIgnoreCase("student")){
            test.studentMyHomePage.studentLaunchCourse(getData("Books.course.courseKey"), tier);
        }
    }
    
    @Test
    public void TestStep_03_LaunchandSignIntoEvernoteApp(){
        System.out.print("test");
        test.DashBoardPage.clickOnAppByName("Notebook");
        test.FramesPage.switchToDockIFrame();
        test.EvernoteAppPage.clickOnSignInLink();
        test.EvernoteAppPage.SignIntoApp();
        
        Reporter.log(user+" successfully signed into evernote app",true);
    }
        
     @Test
    public void TestStep_04_StudentAddNote(){
        test.FramesPage.switchToDefaultContent();
        test.FramesPage.switchToDockIFrame();
        test.EvernoteAppPage.AddNote("Student created note");
    }
    
    @Test
    public void TestStep_05_StudentEditandDeleteNote() throws AWTException{
        
        test.EvernoteAppPage.editNote();
        
   }
    
     @Test
    public void TestStep_06_StudentsortByTitle() throws AWTException{
        
      test.EvernoteAppPage.sort();
      
   }
    
    
    @Test
    public void TestStep_07_StudentDeleteNote(){
        test.EvernoteAppPage.deleteNote();
    }
    
     @Test
    public void TestStep_08_StudentSignOutEvernote(){
        test.EvernoteAppPage.signOut();
        ReportMsg.info(user+" succesfully signed out");
    }
    
    
    
    
}
