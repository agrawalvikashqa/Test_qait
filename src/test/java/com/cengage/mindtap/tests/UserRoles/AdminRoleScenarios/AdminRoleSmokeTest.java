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
public class AdminRoleSmokeTest {

    TestSessionInitiator test;
    String user, bookName;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Admin Role Smoke Test");
        user = System.getProperty("user", "admin");
        bookName = StringUtils.upperCase(user) + "-" + getData("Books.master.masterName");
        test.launchApplication(getData("base_url"));
    }
/**
 * Login into mindtap Via SSo
 
 */
    @Test
    public void TestStep_01_LoginToMindTapApplication() {
        test.adminLoginPage.loginToMindTapApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")));
        test.masterPage.verifyuserIsOnMastersPage();
        Reporter.log(user + " successfully logs in to the application", true);
    }

    @Test
    public void TestStep_02_ClickMasterTabAndVerifyButton() {
      Assert.assertTrue(test.masterPage.verifyuserMastersTab(bookName,"All",user));
      Reporter.log(user + " successfully verified clicked on master Tab and UI of application", true);
    }
     @Test
    public void TestStep_03_ClickOrganisationTabAndVerifyButton() {
      Assert.assertTrue(test.masterPage.verifyuserOrganisationTab());
      Reporter.log(user + " successfully verified clicked on Organisation Tab and UI of application", true);
    }
     @Test
    public void TestStep_04_ClickAppLibraryTabAndVerifyButton() {
      Assert.assertTrue(test.masterPage.verifyuserAppLibraryTab());
      Reporter.log(user + " successfully verified clicked on AppLibrary Tab and UI of application", true);
    }
    
    @Test
    public void TestStep_05_ClickSettingTabAndVerifyButton() {
      Assert.assertTrue(test.masterPage.verifySettingTab());
    Reporter.log(user + " successfully verified clicked on Setting Taband UI of application", true);
    }
    
    @Test
    public void TestStep_06_LogOutFromMindTapApplication() {
        test.masterPage.logOutFromMasterPage();
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
