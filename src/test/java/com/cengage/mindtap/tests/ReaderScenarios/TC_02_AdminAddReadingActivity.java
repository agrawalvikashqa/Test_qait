/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.ReaderScenarios;


import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.apache.commons.lang3.StringUtils;
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
public class TC_02_AdminAddReadingActivity {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user, bookName, uname;
    
    String CourseKey = getData("Books.course.courseKey");
    String CourseName = getData("Books.course.courseName");
    String activityName = getData("learningActivities.ReadingActivity.activityName");
    String title = getData("learningActivities.ReadingActivity.title");
    String desc = getData("learningActivities.ReadingActivity.description");
    String activity_title = getData("learningActivities.ReadingActivity.title");
    String textBox_activityTitle = getData("learningActivities.ReadingActivity.textbox_activityTitle");
    String heading = getData("learningActivities.ReadingActivity.textboxHead");
    String textbox_desc = getData("learningActivities.ReadingActivity.textboxDesc");
    String edit_heading = getData("learningActivities.ReadingActivity.textboxEditHead");
    String editedtextbox_desc = getData("learningActivities.ReadingActivity.textboxEditDesc");
    
    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Create And Launch Master Next Book And Verify LPN");
        user = System.getProperty("user", "admin");
        bookName = StringUtils.upperCase(user) + "-" + getData("Books.master.masterName");
        test.launchApplication(getData("base_url"));
    }

    @Test
    public void TestStep_01_LoginToMindTapApplication() {
        test.adminLoginPage.loginToMindTapApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")));
        test.masterPage.verifyuserIsOnMastersPage();
        Reporter.log(user + " successfully logs in to the application", true);
        
    }
    
    @Test
    public void TestStep_02_LaunchAdminSnapshot(){
        test.masterPage.clickOnOrganizationTab();
        test.masterPage.enterCoursekey(CourseKey);
        test.masterPage.ClickOnOrg();
        test.masterPage.ClickOnCourse(CourseName);
        test.masterPage.LaunchSnapshotFromAdmin();
       
    }
     @Test
    public void TestStep_03_clickOnAddIconAndAddActivity(){
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
        test.DashBoardPage.clickOnActivity(activityName);
        
   }
     @Test
    public void TestStep_04_AdminAddReadingActivity() {
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.readingPage.selectActivitytoAdd();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addActivityDiscriptionAndTitle(title, desc);
    }
    
     @Test
    public void TestStep_05_AdminAddTextBox() {
        test.DashBoardPage.launchDistinctActivity(activity_title);
        test.FramesPage.switchToMainFrame();
        test.readingPage.navigateToChapterIntroductionPage();
        test.readingPage.clickOnEditModeAndAddIconLiknsAndNavigateToChapterIntroductionPage();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.clickOnActivity(textBox_activityTitle);
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.readingPage.addTextBoxHeading(heading);
        test.readingPage.addTextboxDescription(textbox_desc);
        test.FramesPage.switchToDefaultContent();
        
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.readingPage.saveTextBox();
        
    }
    
    @Test
    public void TestStep_06_AdminEditTextBox() {
        test.FramesPage.switchToDefaultContent();
        test.FramesPage.switchToMainFrame();
        //test.FramesPage.switchToMainFrame();
        //test.readingPage.clickOnEditMode();
        test.readingPage.clickOnInlineEditAndEditActivity();
        test.FramesPage.switchToDefaultContent();
        test.FramesPage.switchToModeOptionsEditFrame();
        test.readingPage.addTextBoxHeading(edit_heading);
        test.readingPage.addTextboxDescription(editedtextbox_desc);
        test.readingPage.addLinkToTextBox();
        test.FramesPage.switchToDefaultContent();
        test.FramesPage.switchToModeOptionsEditFrame();
        test.readingPage.saveTextBox();
       
        
    }
    
    

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
    
     @AfterClass(alwaysRun = true)
    public void stop_test_session() {
        test.closeTestSession();
    }
    
}
