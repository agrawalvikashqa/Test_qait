/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.GenericAppDock;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author chandanjyot
 */
public class TC_01_GenericAppDockAdminTest  {
    
     TestSessionInitiator test;
    String user, bookName;
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
    public void TestStep_03_LaunchAdminSnapshot(){
        test.masterPage.clickOnOrganizationTab();
        test.masterPage.enterCoursekey(CourseKey);
        test.masterPage.ClickOnOrg();
        test.masterPage.ClickOnCourse(CourseName);
        test.masterPage.LaunchSnapshotFromAdmin();
       
    }
    
    @Test
    public void TestStep_04_AppDockPresent(){
        test.GenericAppDockPage.appDockDisplay();
    }
    
    @Test
    public void TestStep_05_AppDockExpandedbyDefault(){
        test.GenericAppDockPage.appDockExpand();
    }
    
    @Test 
    public void TestStep_06_MoreLessLinkPresent(){
        test.GenericAppDockPage.moreLessLink();
        
    }
    
    @Test
    public void TestStep_07_HideAppDock(){
        test.GenericAppDockPage.appdockHide();
        test.GenericAppDockPage.verifyHideAppDock();
        
    }
    
    @Test
    public void TestStep_08_LaunchAppDock(){
        test.GenericAppDockPage.appdockHide();
    }
    
    @AfterClass(alwaysRun = true)
    public void stop_test_session() {
        test.closeTestSession();
    }

    
    
    
}

    

