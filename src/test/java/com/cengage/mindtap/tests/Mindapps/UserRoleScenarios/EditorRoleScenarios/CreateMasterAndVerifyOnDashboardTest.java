/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.UserRoleScenarios.EditorRoleScenarios;

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
public class CreateMasterAndVerifyOnDashboardTest {

    TestSessionInitiator test;
    String user, bookName;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Create And Launch Master Next Book And Verify LPN");
        user = System.getProperty("user", "editor");
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
        test.masterPage.clickOnModeValueIcon(mode);
        test.masterPage.launchMasterBook(bookName);
        test.lpnPage.verifyLPNWorkspace();
        Reporter.log("Master Book Launched successfully and verified LPN", true);
    }
   //@Test
    public void TestStep_03_VerifyAddActivityButtonNotPresent(@Optional("Course") String mode){
        Assert.assertTrue(test.DashBoardPage.VerifyAddActivityButtonNotPresent(), "Create Add Activity Button Present on LPN Page");
        Reporter.log("Verify Add Activity Button Not Present on LPN", true);
    }
     //@Test
    public void TestStep_04_VerifyEditActivityButtonNotPresent(@Optional("Course") String mode){
        Assert.assertTrue(test.DashBoardPage.VerifyEditActivityButtonNotPresent(getData("Books.master.unitName")), "Create Add Activity Button Present on LPN Page");
       Reporter.log("Verify Edit Activity Button Not Present on LPN", true);
    }
    
    @Test
    public void TestStep_05_launchReadingActivuty() {
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("Books.master.unitName"), getData("Books.master.unitName"));
        test.readingPage.closeOpenActivity();
    }
      
    @Test
    @Parameters({"mode"})
    public void TestStep_06_VerifyCreateMasterBookNotPresent(@Optional("Course") String mode){
        Assert.assertTrue(test.masterPage.naviagteToMasterPage(getData("environment")), "User is not on Master Page");
        Assert.assertTrue(test.masterPage.VerifyCreateMasterBookNotPresent(), "Create Master Master Button Present on Master Page");
       
    }
  
    @Test
    public void TestStep_07_LogOutFromMindTapApplication() {
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
