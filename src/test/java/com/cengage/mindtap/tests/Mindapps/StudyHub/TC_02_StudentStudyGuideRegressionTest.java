/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.StudyHub;


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
public class TC_02_StudentStudyGuideRegressionTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;
    String Stud_StudyGuide_Title = getData("learningActivities.StudyHub.studStudyGuide"); 
    String Inst_StudyGuide_Title = getData("learningActivities.StudyHub.instStudyGuide"); 
    
    
  

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Launch Apps From App Dock Test");
        user = System.getProperty("user", "student"); 
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+user+".username")), getData(("users."+user+".password")));
        Reporter.log(user+" successfully logs in to the application",true);
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
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
         test.DashBoardPage.clickOnAppByName("StudyHub");
         test.FramesPage.switchToDockIFrame();
         test.StudyHubAppPage.studyHubUIVerify();
         Reporter.log(user+" successfully Verified Study Hub Launch",true);      
    }
    
    @Test 
    public void TestStep_04_studentLaunchInstCreatedSG() {
     test.StudyHubAppPage.StudentStudyGuideLaunch(Inst_StudyGuide_Title);
   }
    
    @Test
     public void TestStep_05_studCreateStudyGuide() {
        test.StudyHubAppPage.clickOnBackButton();
        test.StudyHubAppPage.clickOnCreateStudyGuideButton();
        test.StudyHubAppPage.EnterStudyGuideName(Stud_StudyGuide_Title);
        test.StudyHubAppPage.selectDropDownValue();
        test.StudyHubAppPage.selectCheckbox();
        test.StudyHubAppPage.clickOnAddUnit();
        test.StudyHubAppPage.clickOnCreateStudyGuide();
        
    }
     
     @Test
     public void TestStep_06_studentLaunchStudentCreatedStudyGuide() {
        test.StudyHubAppPage.StudentStudyGuideLaunch(Stud_StudyGuide_Title);
        test.StudyHubAppPage.clickOnBackButton();
        
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
    
    

