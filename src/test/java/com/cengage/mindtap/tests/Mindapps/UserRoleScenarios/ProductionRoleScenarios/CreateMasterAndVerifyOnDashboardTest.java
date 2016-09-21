 /*productionUser
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.UserRoleScenarios.ProductionRoleScenarios;

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
        user = System.getProperty("user", "productionUser");
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
    @Parameters({"bookType"})
    public void TestStep_02_CreateMasterBook(@Optional("course") String bookType) {
        test.masterPage.clickOnCreateMasterButton();
        test.masterPage.enterMasterBookDetailsAndSubmit(bookName, getData("Books.master.description"), getData("Books.master.coreTextISBN"), bookType);
        Assert.assertTrue(test.masterPage.verifyMasterBookCreated(bookName), "Master Book not created successfully");
        Reporter.log("Master Book Created successfully in " + bookType + " mode", true);
    }

    @Test
    @Parameters({"mode"})
    public void TestStep_03_LaunchCreatedMasterAndVerifyLPN(@Optional("Course") String mode) {
        Assert.assertTrue(test.masterPage.naviagteToMasterPage(getData("environment")), "User is not on Master Page");
        test.masterPage.enterBookNameAndUnpublishedButtonToSearch(bookName);
        test.masterPage.clickOnModeValueIcon(mode);
        test.masterPage.launchMasterBook(bookName);
        test.lpnPage.verifyLPNWorkspace();
        Reporter.log("Master Book Launched successfully and verified LPN", true);
    }
     @Test
    public void TestStep_03_VerifyAddActivityButtonNotPresent(@Optional("Course") String mode){
        Assert.assertTrue(test.DashBoardPage.VerifyAddActivityButtonNotPresent(), "Create Add Activity Button Present on LPN Page");
        Reporter.log("Verify Add Activity Button Not Present on LPN", true);
    }
    @Test
    public void TestStep_04_EditMasterBookTitle(){
        test.lpnPage.editMasterLearningPathName(bookName);
        Reporter.log("Master Book Title edited successfully", true);
    }
      /*This test case covers:
     *Add inline google drive activity in chapter
     **/
      @Test
    public void TestStep_05_launchReadingActivuty() {
        test.readingPage.refreshPage();
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("Books.master.unitName"), getData("Books.master.unitName"));
    }
    @Test
    public void TestStep_06_addInlineActivityInChapter() {
        test.FramesPage.switchToMainFrame();
        test.readingPage.navigateToChapterIntroductionPage();
        test.readingPage.clickOnEditModeAndAddIconLiknsAndNavigateToChapterIntroductionPage();
        test.FramesPage.switchToDefaultContent();
        test.GoogleDriveAppPage.addDistinctGoogleInlineDriveActivity(getData("learningActivities.GoogleDoc.distinctTitle"),getData("learningActivities.GoogleDoc.gmailID"),getData("learningActivities.GoogleDoc.paswrd"));
        test.FramesPage.switchToDefaultContent();
        
    }
    
   @Test    
    public void TestStep_07_deleteInlineGoogleDocActivity(){
        test.FramesPage.switchToMainFrame();
        test.readingPage.clickOnEditMode();
        test.readingPage.clickOnEditMode();
        test.readingPage.selectFrameAndDeleteInlineActivity();
        Reporter.log("Completed Student delete Inline Google Doc Activity" + "\n" ,true);
    }
    
    @Test
    @Parameters({"mode"})
    public void TestStep_08_AddProvisionApp(@Optional("Course") String mode){
        Assert.assertTrue(test.masterPage.naviagteToMasterPage(getData("environment")), "User is not on Master Page");
        test.masterPage.enterBookNameAndUnpublishedButtonToSearch(bookName);
        test.masterPage.clickOnModeValueIcon(mode);
        test.masterPage.clickBookModifyOption(bookName, "Provision Apps",user);
        test.masterPage.editProvisionAppsButton(bookName, getData("Books.master.ProvisionAppsRegistry.algAppProvision"));
    }
    @Test
    public void TestStep_09_DeleteMaster() {
    test.masterPage.clickonMasterTab();
    test.masterPage.verifyDeleteButtonInMastersTab(bookName ,"Delete",user);
    Reporter.log("Master Book Title deleted successfully", true);
    }

    @Test
    public void TestStep_10_LogOutFromMindTapApplication() {
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
