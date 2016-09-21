/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.UserRoleScenarios.AdminRoleScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author QAI
 */
public class TC02_VerifyMasterTest {

    TestSessionInitiator test;
    String user, bookName;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Verify Master");
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
    @Parameters({"mode"})
    public void TestStep_02_LaunchCreatedMasterAndVerifyLPN(@Optional("Course") String mode) {
        Assert.assertTrue(test.masterPage.naviagteToMasterPage(getData("environment")), "User is not on Master Page");
        test.masterPage.enterBookNameAndUnpublishedButtonToSearch(bookName);
        //test.masterPage.clickOnModeValueIcon(mode);
        Reporter.log("Master Book Launched successfully and verified LPN", true);
    }
    
    @Test
    public void TestStep_03_LaunchMaster() {
        
        test.masterPage.searchMasterBook(bookName);
        Reporter.log("Successfully verified Row count is equal to the selected rows in dropsown feild ");
        
    }
    
    @Test
    public void TestStep_04_VerifyStatusofMaster() {
        
        test.masterPage.verifyStatus(bookName);
        Reporter.log("Successfully verified Status messages ");
    }
    
    @Test
    @Parameters({"mode"})
    public void TestStep_05_AddProvisionApp(@Optional("Course") String mode){
        Assert.assertTrue(test.masterPage.naviagteToMasterPage(getData("environment")), "User is not on Master Page");
        test.masterPage.enterBookNameAndUnpublishedButtonToSearch(bookName);
        test.masterPage.clickOnModeValueIcon(mode);
        test.masterPage.clickBookModifyOption(bookName, "Provision Apps",user);
        test.masterPage.ProvisionAppsButton(bookName, getData("Books.master.ProvisionAppsRegistry.algAppProvision"));
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
