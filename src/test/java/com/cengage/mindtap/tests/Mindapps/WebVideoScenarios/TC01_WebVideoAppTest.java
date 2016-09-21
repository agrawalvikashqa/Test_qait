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
 * 
 * @author QAI
 */
public class TC01_WebVideoAppTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String activityName = getData("Books.courseWebVideo.name");
    String text = getData("Books.courseWebVideo.text");
    String newText = getData("Books.courseWebVideo.newtext");
    String webVideoActivity_title = getData("Books.courseWebVideo.title");
    String anotherTitle = getData("Books.courseWebVideo.anothertitle");
    
    String user;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Launch Webvideo App Test(NG-32747 : https://jira.cengage.com/browse/NG-32747)");
        user = System.getProperty("user", "instructor");
     }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    
    /*WebVideo App Verification
    */

    @Test
    public void TestStep_03_clickOnAddIconAndAddActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    }
    
    @Test
    public void TestStep_04_Youtube_Video_Search_and_ShowHide_Options() {
        test.DashBoardPage.clickOnActivity(activityName);
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.webvideopage.searchyoutubevideo(text);
        test.webvideopage.showhideoptions();
        test.webvideopage.helpbutton();
    }
    
    @Test
    public void TestStep_05_Add_WebVideo_Activity() {
        test.webvideopage.addwebvideoactivity(text);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addActivityDiscriptionAndTitle(webVideoActivity_title, text);       
    }
    
    @Test
    public void TestStep_06_instructorLaunchWebVideoActivity() {
        test.DashBoardPage.launchDistinctActivity(webVideoActivity_title);
        test.FramesPage.switchToMainFrame();
        test.webvideopage.verifyWebVideoActivityLauched(webVideoActivity_title);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.closeLaunchedActivity(webVideoActivity_title);
    }
    
    @Test
    public void TestStep_07_instructorEditWebVideoActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.editDistinctActivity(webVideoActivity_title);
        test.FramesPage.switchToModeOptionsEditFrame();
        test.webvideopage.fillEntryInField(anotherTitle, newText);
        test.webvideopage.fillDueAvaialableDate();
        test.DashBoardPage.clickOnView("Unit View");
        test.webvideopage.lpnDateDisplay();
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
