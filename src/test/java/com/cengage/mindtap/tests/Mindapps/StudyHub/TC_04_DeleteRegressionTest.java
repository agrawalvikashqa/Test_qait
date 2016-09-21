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
public class TC_04_DeleteRegressionTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;
    String Stud_StudyGuide_Title = getData("learningActivities.StudyHub.studStudyGuide"); 
    String Inst_StudyGuide_Title = getData("learningActivities.StudyHub.instStudyGuide"); 
    
  

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Launch Apps From App Dock Test");
        user = System.getProperty("user", "instructor");
        
    }

     @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        //test.DashBoardPage.verifyCengageLogoIsDisplayedInDashboardView();
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
   @Test
    public void TestStep_02_InstructorDeleteStudyGuide() {
        test.DashBoardPage.clickOnAppByName("StudyHub");
         test.FramesPage.switchToDockIFrame();
         Reporter.log(user+" successfully Verified Study Hub Launch",true);
         test.StudyHubAppPage.DeleteStudyGuide(Inst_StudyGuide_Title);
         test.lpnPage.logOutFromMindTap();
    }
    
    @Test    
     public void TestStep_03_LoginToSSOApplication() {
     user = System.getProperty("user", "student"); 
     test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    @Test
     public void TestStep_04_studentDeleteStudentCreatedStudyGuide() {
         test.DashBoardPage.clickOnAppByName("StudyHub");
         Reporter.log(user+" successfully Verified Study Hub Launch",true);
         test.FramesPage.switchToDockIFrame(); 
         test.StudyHubAppPage.DeleteStudyGuide(Stud_StudyGuide_Title);
        
        
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
  
