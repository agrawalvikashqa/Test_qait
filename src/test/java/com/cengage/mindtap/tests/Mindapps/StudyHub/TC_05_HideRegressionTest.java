/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.StudyHub;


import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * 
 * @author QAI
 */
public class TC_05_HideRegressionTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;
    
    
    String Stud_StudyGuide_Title = getData("learningActivities.StudyHub.studStudyGuide"); 
    String Inst_StudyGuide_Title = getData("learningActivities.StudyHub.instStudyGuide"); 
    
  

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Launch Apps From App Dock Test");
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
    
   @Test
    public void TestStep_03_InstructorHideStudyGuide() {
         test.DashBoardPage.clickOnAllApps();
         test.DashBoardPage.LaunchAppFromAppDock("mtstudycenter");
         Reporter.log(user+" successfully Verified Study Hub Launch",true);
         test.FramesPage.switchToDockIFrame();
         test.StudyHubAppPage.HideStudyGuide();
    }

    @Test
    public void TestStep_04_LoginToSSOApplication() {
        
        user = System.getProperty("user2", "student");
        test.launchApplication(getData("sso_url"));
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+user+".username")), getData(("users."+user+".password")));
        Reporter.log(user+" successfully logs in to the application",true);
    }
    
    @Test
    public void TestStep_05_LaunchCourseViaSSO(){
        if(user.equalsIgnoreCase("instructor")){
            test.instructorResourceCenterPage.instructorLaunchCourse(getData("Books.course.courseKey"), tier);
        }else if(user.equalsIgnoreCase("student")){
            test.studentMyHomePage.studentLaunchCourse(getData("Books.course.courseKey"), tier);
        }
    }
    
    @Test
     public void TestStep_06_studentverfiyHiddenStudyGuide() {
          test.DashBoardPage.clickOnAllApps();
         test.DashBoardPage.LaunchAppFromAppDock("mtstudycenter");

         Reporter.log(user+" successfully Verified Study Hub Launch",true);
         test.FramesPage.switchToDockIFrame();
         test.StudyHubAppPage.studentNotSeeingHiddenGuide(Inst_StudyGuide_Title);
     
   }
}
