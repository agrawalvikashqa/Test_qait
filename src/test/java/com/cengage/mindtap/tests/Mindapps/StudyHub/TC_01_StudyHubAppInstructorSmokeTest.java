/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.StudyHub;


import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import com.qait.automation.utils.PropFileHandler;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;
import static java.lang.Math.random;

/**
 *
 * 
 * @author QAI
 */
public class TC_01_StudyHubAppInstructorSmokeTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;
    
  

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Launch Apps From App Dock Test");
        user = System.getProperty("user", "instructor");
        
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
    public void TestStep_03_verifyStudyHubLaunch() {
         test.DashBoardPage.clickOnAllApps();
         test.DashBoardPage.LaunchAppFromAppDock("mtstudycenter");test.FramesPage.switchToDockIFrame();
         test.DashBoardPage.clickOnAppByName("StudyHub");
         test.FramesPage.switchToDockIFrame();
         test.StudyHubAppPage.studyHubUIVerify();
         Reporter.log(user+" successfully Verified Study Hub Launch",true);
    }
    
    @Test 
    public void TestStep_04_instructorCreatesStudyGuide() {
        //String StudyGuide_Title = getData("learningActivities.StudyHub.instStudyGuide"); 
       // test.FramesPage.switchToDockIFrame();
        test.FramesPage.switchToDockIFrame();
        String StudyGuide_Title = getData("learningActivities.StudyHub.instStudyGuide")+test.flashcardpage.appendTimeStamp()+random(); 
        PropFileHandler.writeProperty(StudyGuide_Title, StudyGuide_Title);
        test.StudyHubAppPage.clickOnCreateStudyGuideButton();
        test.StudyHubAppPage.EnterStudyGuideName(StudyGuide_Title);
        test.StudyHubAppPage.selectDropDownValue();
        test.StudyHubAppPage.selectCheckbox();
        test.StudyHubAppPage.clickOnAddUnit();
        test.StudyHubAppPage.selectDropDownValue();
        test.StudyHubAppPage.selectCheckbox();
        test.StudyHubAppPage.clickOnAddUnit();
        test.StudyHubAppPage.clickOnCreateStudyGuide();
        test.StudyHubAppPage.InstructorCreatedGuideIsVisible();
        test.StudyHubAppPage.InstructorLaunchStudyGuide();
        test.StudyHubAppPage.clickOnBackButton();
        
        
        //test.DashBoardPage.closeWindow();
        
         }
    
}
