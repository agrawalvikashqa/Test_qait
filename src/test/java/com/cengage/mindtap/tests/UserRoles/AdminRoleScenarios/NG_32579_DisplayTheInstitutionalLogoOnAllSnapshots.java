/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.UserRoles.AdminRoleScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author QAI
 */
public class NG_32579_DisplayTheInstitutionalLogoOnAllSnapshots {

    TestSessionInitiator test;
    String user, bookName;
String CourseKey = getData("Books.organization2.courseKey");
    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Replacement of an existing image Test");
        user = System.getProperty("user", "admin");
        bookName = StringUtils.upperCase(user) + "-" + getData("Books.master.masterName");
        test.launchApplication(getData("base_url"));
    }
/**
 * Login into mindtap Via SSo
 
 */
    @Test
    public void TestStep_01_ClickOnEditSettingsButtonOfOrganigation() {
        test.adminLoginPage.loginToMindTapApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")));
        test.masterPage.verifyuserIsOnMastersPage();
        Reporter.log(user + " successfully logs in to the application", true);
        
    }

    @Test 
    
    public void TestStep_04_SearchCourse() {
        test.masterPage.clickOnOrganizationTab();
        test.masterPage.enterCoursekey(CourseKey);  
    }
    @Test
    public void TestStep_05_LaunchCourse() {
        test.masterPage.ClickOnOrg();
        test.masterPage.ClickOnCourseFromAdmin();
        test.masterPage.LaunchSnapshotFromAdmin();
    }
     @Test
    public void TestStep_06_verifyNewUpLoadFile() {
       Assert.assertTrue(test.masterPage.verifyNewupLoadFileOnLPN());
       Reporter.log(user + "Successfully  verify New upLoad Institute Logo is not Apperring in other Organization Snapshot", true);
    }
    @Test
    public void TestStep_07_LogOutFromMindTapApplication() {
        test.DashBoardPage.Logout();
        Reporter.log(user + " successfully log out from application");
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
