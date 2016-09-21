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
 * @author QAII
 */
public class TC06_InstructorDeleteWebVideoActivityTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String activityName = getData("Books.courseWebVideo.name");
    String text = getData("Books.courseWebVideo.text");
    String newText = getData("Books.courseWebVideo.newtext");
    String webVideoActivity_title = getData("Books.courseWebVideo.title");
    String anotherTitle = getData("Books.courseWebVideo.anothertitle");
    String user;
    String uname = getData("Books.courseWebVideo.unitName");
    String cname = getData("Books.courseWebVideo.chapterName");

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Launch Webvideo App Test(NG-32747 : https://jira.cengage.com/browse/NG-32747)");
        user = System.getProperty("user", "instructor");
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+user+".username")), getData(("users."+user+".password")));
        Reporter.log(user+" successfully logs in to the application",true);
    }
    
    @Test
    public void TestStep_02_LaunchCourseViaSSO(){
        if(user.equalsIgnoreCase("instructor")){
            test.instructorResourceCenterPage.instructorLaunchCourse(getData("Books.course.courseKey"), tier);
        }else if(user.equalsIgnoreCase("student")){
            test.studentMyHomePage.studentLaunchCourse(getData("Books.course.courseKey"), tier);
        }
    }
    /*WebVideo App Delete Verification
    */

    @Test
    public void TestStep_03_UserDeleteDistinctActivity(){
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.deleteDistinctActivity(webVideoActivity_title);
    }
    
    @Test
    public void TestStep_03_UserDeleteInlineActivity(){
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(uname, cname);
        test.readingPage.clickOnEditModeAndDeleteInlineActivity();
       
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
