/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.UserRoles.EditorRoleScenarios;

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
public class editorRoleSmokeTest {

    TestSessionInitiator test;
    String user, bookName;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Editor Role Smoke Test");
        user = System.getProperty("user", "editor");
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
    public void TestStep_02_ClickMasterTabAndVerifyRefreshButton() {
      System.out.println(bookName);
      test.masterPage.clickonMasterTab();
      Assert.assertTrue(test.masterPage.verifyRefreshButtonInMastersTab(bookName,"Refresh",user));
      Reporter.log(user + " successfully Click Master Tab And Verify Refresh Button", true);
    }
    
    
    @Test
    public void TestStep_03_ClickMasterTabAndVerifyEditButton() {
      System.out.println(bookName);
      test.masterPage.clickonMasterTab();
      Assert.assertTrue(test.masterPage.verifyEditButtonInMastersTab(bookName,"Edit", user));
      Reporter.log(user + " successfully Click Master Tab And Verify Refresh Button", true);
    }
    @Test
    public void TestStep_05_LogOutFromMindTapApplication() {
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
