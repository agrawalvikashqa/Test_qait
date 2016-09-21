/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.InsiteScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * 
 * @author QAI
 */
public class TC01_AdminAddDistinctAndInlineActivity {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user, bookName;

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
        
    String CourseKey = getData("learningActivities.insite.courseKey");
    String CourseName = getData("learningActivities.insite.courseName");
    

    
    
    @Test
    public void TestStep_02_LaunchAdminSnapshot(){
        test.masterPage.clickOnOrganizationTab();
        test.masterPage.enterCoursekey(CourseKey);
        test.masterPage.ClickOnOrg();
        test.masterPage.ClickOnCourse(CourseName);
       
    }
    /*This test case covers:
     *Verifying of Google Drive App 
     **/
    
    /*@Test
    public void TestStep_03_LaunchAppFromAppDock() {
        test.DashBoardPage.clickOnAppByName("View InSite");
        
        Reporter.log(user+"successfully Launch My Content App From App Dock",true);
    }*/
    
    /*This test case covers:
     *Add Distinct Insite Activity 
     **/
   
     @Test
    public void TestStep_03_AddPaperAssignmentDistinctActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
        test.InsiteAppPage.clickOnInsiteApp();
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.InsiteAppPage.PaperAssignmentRadioButton();
        test.InsiteAppPage.createDistinctPaperAssignment();
        test.FramesPage.switchToDefaultContent();
        test.InsiteAppPage.clickOnSaveButton();
        
    }
    
    @Test
    public void TestStep_04_AddPeerMarkAssignmentDistinctActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
        test.InsiteAppPage.clickOnInsiteApp();
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.InsiteAppPage.PeermarkAssignmentRadioButton();
        test.InsiteAppPage.createDistinctPeerAssignment();
        test.FramesPage.switchToDefaultContent();
        test.InsiteAppPage.clickOnSaveButton();
        
        
    }
    
}
