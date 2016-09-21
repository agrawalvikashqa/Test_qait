/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.SpeechOutlineToolScenarios;

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
public class TC01_InstAddDistinctSpeechOutlineToolTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String name1 = getData("Books.SOT.name1");
    String desc1 = getData("Books.SOT.description1");
    String ques1 = getData("Books.SOT.mulcques");
    String ans1 = getData("Books.SOT.mulcans");
    String name2 = getData("Books.SOT.name2");
    String desc2 = getData("Books.SOT.description2");
    String ques2 = getData("Books.SOT.mulsques");
    String ans2 = getData("Books.SOT.mulsans");
    String name_edit = getData("Books.SOT.namedit");
    String ques_edit = getData("Books.SOT.namedit");
    String ans_edit = getData("Books.SOT.namedit");
    String activityName = getData("Books.SOT.name");
    String LPNactivityName = getData("Books.SOT.namedit");
    String desc_edit = getData("Books.SOT.namedit");

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: ");
        test = new TestSessionInitiator("Google Drive App");
        user = System.getProperty("user", "instructor");
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+user+".username")), getData(("users."+user+".password")));
        Reporter.log(user+"successfully logs in to the application");
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
    
    //@Test
    public void TestStep_03_addDistinctSOTGradedActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
        test.DashBoardPage.clickOnActivity(activityName);
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.SpeechOutlineToolPage.addDistinctGradedActivity(desc1);
    }
    
    //@Test
    public void TestStep_04_addDistinctSOTPracticeActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
        test.DashBoardPage.clickOnActivity(activityName);
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.SpeechOutlineToolPage.addDistinctGradedActivity(desc2);
    }
    
    @Test
    public void TestStep_05_editDistinctSOTGradedActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.editDistinctActivity(LPNactivityName);
        test.FramesPage.switchToModeOptionsEditFrame();
        test.SpeechOutlineToolPage.editDistinctGradedActivity(desc_edit);
        test.FramesPage.switchToDefaultContent();
        
        
    }
    
    @AfterClass()
    public void stop_test_session() {
        test.closeTestSession();
    }

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
    
}
