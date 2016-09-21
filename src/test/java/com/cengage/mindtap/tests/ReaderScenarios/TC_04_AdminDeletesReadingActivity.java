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
public class TC_04_AdminDeletesReadingActivity {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user, bookName;
    String activity_title = getData("learningActivities.ReadingActivity.title");
    
     String CourseKey = getData("Books.course.courseKey");
    String CourseName = getData("Books.course.courseName");

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
    public void TestStep_03_AdminDeleteReadingActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.deleteDistinctActivity(activity_title);
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
