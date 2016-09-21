/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.WebVideoScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author QAI
 * 
 */
public class TC05_TAIsAbleToViewWebVideoActivityTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;
    
    String uname = getData("Books.courseWebVideo.unitName");
    String cname = getData("Books.courseWebVideo.chapterName");
    String webVideoActivity_title = getData("Books.courseWebVideo.title");
    String newText = getData("Books.courseWebVideo.newtext");
    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Student Is Able To View Post Messages Test");
        user = System.getProperty("user", "TA");
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+user+".username")), getData(("users."+user+".password")));
        Reporter.log(user+" successfully logs in to the application");
    }
    
    @Test
    public void TestStep_02_LaunchCourseViaSSO(){
        if(user.equalsIgnoreCase("instructor")){
            test.instructorResourceCenterPage.instructorLaunchCourse(getData("Books.course.courseKey"), tier);
        }else if(user.equalsIgnoreCase("student")){
            test.studentMyHomePage.studentLaunchCourse(getData("Books.course.courseKey"), tier);
        }else if(user.equalsIgnoreCase("TA")){
            test.studentMyHomePage.studentLaunchCourse(getData("Books.course.courseKey"), tier);
        }
    }
    
    @Test
    public void TestStep_03_LaunchDistinctWebVideo(){
      test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.launchDistinctActivity(webVideoActivity_title);
        test.FramesPage.switchToMainFrame();
        test.webvideopage.verifyWebVideoActivityLauched(webVideoActivity_title);
        test.webvideopage.editedTextVerification(newText);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.closeLaunchedActivity(webVideoActivity_title);
    }
        
}