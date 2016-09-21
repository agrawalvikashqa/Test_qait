/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.WebVideoScenarios;

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
 * 
 */
public class TC03_StudentIsAbleToViewWebVideoActivityTest {
    
     TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;
    
    String uname = getData("Books.courseWebVideo.unitName");
    String cname = getData("Books.courseWebVideo.chapterName");
    String webLinkActivity_title = getData("Books.courseWebVideo.title");
    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Student Is Able To View Post Messages Test");
        user = System.getProperty("user", "student");
    }
    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    @Test
    public void TestStep_03_LaunchInlineWebVideo(){
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(uname, cname);
        test.readingPage.navigateToChapterIntroductionPage();
        test.FramesPage.switchToMainFrame();
        test.webvideopage.viewInlineWebVideoActivity();
        
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