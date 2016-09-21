/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.WeblinkScenarios;

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
 * @author alokkumar
 */
public class TC02_UserAddLaunchAndEditInlineWebLinkActivityTest {

    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String userIstructor;
    String userStudent;
    String activityName = getData("Books.courseWebLink.name");
    String webURL = getData("Books.courseWebLink.url");
    String text = getData("Books.courseWebLink.text");
    String webLinkActivity_title = getData("Books.courseWebLink.title");
    String anotherWebURL = getData("Books.courseWebLink.anotherURL");
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
    public void TestStep_02_launchReadingActivuty() {
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("Books.courseKaltura.unitName"), getData("Books.courseKaltura.chapterName"));
    }

    @Test
    public void TestStep_03_addInlineActivityInChapter() {
        test.FramesPage.switchToMainFrame();
        test.readingPage.clickOnEditModeAndAddIconLiknsAndNavigateToChapterIntroductionPage();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.clickOnActivity(activityName);
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.webLinkPage.addWebLinkActivity(webURL, text);
        test.FramesPage.switchToDefaultContent();
        test.FramesPage.switchToMainFrame();
        test.readingPage.verifyAddedInLineWeblinkActivity(webURL);
        
    }
    
    @Test
    public void TestStep_04_LaunchInlineWeblinkUrl() {
    
        test.readingPage.verifyAddedInLineWeblinkURL(webURL);
        test.FramesPage.switchToDefaultContent();
    
    }

    @Test
    public void TestStep_05_editInlineWeblinkActivity() {
        test.FramesPage.switchToMainFrame();
        test.webLinkPage.clickOnInlineEditAndEditActivity();
        test.FramesPage.switchToDefaultContent();
        test.FramesPage.switchToModeOptionsEditFrame();
        test.webLinkPage.fillEntryInField(anotherWebURL, text);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.closeLaunchedActivity(activityName);
     
    }
    
    @Test
    public void TestStep_06_PopulateFieldAndValidURLTest() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.clickOnActivity(activityName);
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.webLinkPage.searchPopulatedField();
        
    }
    
   
   
    @Test
    public void TestStep_06_studentLogInAndLaunchCourse() {
        user = System.getProperty("user", "student");
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(userStudent + " successfully logs in to the application", true);
        Reporter.log(userStudent + " successfully launch the course", true);
    }

    @Test
    public void TestStep_07_launchReadingActivuty() {
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("Books.courseWebLink.unitName"), getData("Books.courseWebLink.chapterName"));
    }

    @Test
    public void TestStep_08_navigateToChapterIntroductionPageAndVerifyAddedInLineWebLinkActivity() {
        test.FramesPage.switchToMainFrame();
        test.readingPage.navigateToChapterIntroductionPage();
        test.readingPage.verifyAddedInLineWeblinkActivity(webURL);
        test.readingPage.verifyAddedInLineWeblinkURL(webURL);
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
