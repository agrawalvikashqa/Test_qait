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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author QAI
 */
public class NG_30683Test {
    
     TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String userIstructor;
    String userStudent;
    String activityName = getData("Books.courseWebLink.name");
    String webURL = getData("Books.courseWebLink.testurl");
    String text = getData("Books.courseWebLink.text");
    String webLinkActivity_title = getData("Books.courseWebLink.title");
    String defaultWebURLthumbnail = getData("Books.courseWebLink.defaultthumbnail");
    String expectthumbnailsrc = getData("Books.courseWebLink.defaultthumbnail");
    String user; 
    
    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Search App Test");
        user = System.getProperty("user", "instructor");
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    @Test
    public void TestStep_02_clickOnAddIconAndAddActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    }

    @Test
    public void TestStep_03_addDistinctWebLinkActivity() {
        test.DashBoardPage.clickOnActivity(activityName);
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.webLinkPage.addWebLinkActivity(webURL, text);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addActivityDiscriptionAndTitle(webLinkActivity_title, text);
    }

    @Test
    public void TestStep_04_instructorLaunchWebLinkActivity() {
        test.DashBoardPage.launchDistinctActivity(webLinkActivity_title);
        test.FramesPage.switchToMainFrame();
        test.webLinkPage.verifyWeblinkActivityLauched(webLinkActivity_title);
        
    }
    @Test
    public void TestStep_05_LaunchWebLinkURL() {
    Assert.assertEquals(test.webLinkPage.verifyWebLinkURLThumbnail(),expectthumbnailsrc,"thumbnail image source does not match");
    Reporter.log("[ASSERT PASS]: Jira Ticket https://jira.cengage.com/browse/NG-30683 verified successfully",true);

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
