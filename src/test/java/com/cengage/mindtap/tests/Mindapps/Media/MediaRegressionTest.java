package com.cengage.mindtap.tests.Mindapps.Media;

/**
 *
 * @author nikitaaggarwal
 */

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.apache.commons.lang3.StringUtils;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.DateUtil.getDate;
import static com.qait.automation.utils.YamlReader.getData;

public class MediaRegressionTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user, bookName;
    String userIstructor;
    String userStudent;
    String titleImage = "Media_Image_" + getDate();
    String titleVideo = "Media_Video" + getDate();
    String titleFlash = "Media_Flash_" + getDate();
    String ReaderFolder = "Part II: How Markets Work";
    String ReaderUnit = "Chapter 7: Consumers, Producers, and the Efficiency of Markets";
    String Reader = "What Is a Market?";
String CourseKey = getData("Books.course.courseKey");
    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("CreateAndLaunchMasterNextBookAndVerifyLPN");
        user = System.getProperty("user", "admin");
        userIstructor = System.getProperty("user", "instructor");
        userStudent = System.getProperty("user", "student");
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
    
    public void TestStep_02_SearchCourse() {
       test.masterPage.clickOnOrganizationTab();
        test.masterPage.enterCoursekey(CourseKey);  
    }
    @Test
    public void TestStep_03_LaunchCourse() {
        test.masterPage.ClickOnOrg();
        test.masterPage.ClickOnCourseFromAdmin();
        test.masterPage.LaunchSnapshotFromAdmin();
    }
   @Test
    public void TestStep_04_clickOnAddActivityIcon() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    }
    @Test
    public void TestStep_05_AddMediaActivityToLPN() {
        test.DashBoardPage.clickOnActivity("Media Activity");
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.MediaPage.AddImageMedia(titleImage);
        
    }
    @Test
    public void TestStep_06_EditActivityToLPN() {
        test.DashBoardPage.editDistinctActivity(titleImage);
         test.FramesPage.switchToModeOptionsEditFrame();
        test.MediaPage.EditImageMedia(titleImage);
    }
    @Test
    public void TestStep_07_HideActivityToLPN() {
        test.DashBoardPage.hideUnit(titleImage);
    }
    @Test
    public void TestStep_08_DeleteActivityToLPN() {
        test.DashBoardPage.deleteDistinctActivity(titleImage);
        test.MediaPage.DeletePermission();
    }
   @Test
    public void TestStep_09_clickOnAddActivityIcon() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    }
    @Test
    public void TestStep_10_AddMediaActivityToLPN() {
        test.DashBoardPage.clickOnActivity("Media Activity");
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.MediaPage.AddImageMedia(titleImage);
        
    }
    
    @Test
    public void TestStep_11_clickOnAddActivityIcon() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    }
    @Test
    public void TestStep_12_AddVideoMediaActivityToLPN() {
        test.DashBoardPage.clickOnActivity("Media Activity");
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.MediaPage.AddVideoMedia(titleVideo);
        
    }
    @Test

    public void TestStep_13_clickOnAddActivityIcon() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    }
    @Test
    public void TestStep_14_AddFlashMediaActivityToLPN() {
        test.DashBoardPage.clickOnActivity("Media Activity");
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.MediaPage.AddFlashMedia(titleFlash);
        
    }
   @Test
    public void TestStep_15_AddedInlineMedia(){
    test.DashBoardPage.clickOnView("Unit View");
    test.RSSFeedPage.switchToReader(ReaderUnit);
    test.FramesPage.switchToMainFrame();
    test.RSSFeedPage.addInline();
    test.DashBoardPage.clickOnActivity("Inline Media");
    test.FramesPage.switchToDistinctActivityCreateFrame();
    test.MediaPage.AddImageMediaInline(titleImage);
    /*test.MediaPage.addInline();
    test.DashBoardPage.clickOnActivity("Inline Media");
    test.FramesPage.switchToDistinctActivityCreateFrame();
    test.MediaPage.AddVideoMediaInline(titleVideo);*/
    test.lpnPage.logOutFromMindTap();
    }
    @Test
    public void TestStep_16_LoginFromStudent(){
         test.launchApplication(getData("sso_url"));
        test.ssoLoginPage.loginToSSOApplication(getData(("users." + userStudent + ".username")), getData(("users." + userStudent + ".password")));
        Reporter.log(userStudent + " successfully logs in to the application", true);
        test.studentMyHomePage.studentLaunchCourse(getData("Books.course.courseKey"), tier);
        Reporter.log(userStudent + " successfully launch the course", true);
    }
    @Test
    public void TestStep_17_VerifyActivityFromStudent(){
    test.DashBoardPage.clickOnView("Unit View");
    test.DashBoardPage.launchDistinctActivity(titleImage);
    test.DashBoardPage.closeLaunchedActivity(titleImage);
    test.DashBoardPage.launchDistinctActivity(titleVideo);
    test.DashBoardPage.closeLaunchedActivity(titleVideo);
    test.DashBoardPage.launchDistinctActivity(titleFlash);
    test.DashBoardPage.closeLaunchedActivity(titleFlash);
    test.DashBoardPage.clickOnView("Unit View");
    test.RSSFeedPage.switchToReader(ReaderUnit);
    test.FramesPage.switchToMainFrame();
    test.MediaPage.VerifyInlineFromStudent();
    test.lpnPage.logOutFromMindTap();
    }
    @Test
    public void TestStep_18_LoginFromInstructor(){
         test.launchApplication(getData("sso_url"));
        test.ssoLoginPage.loginToSSOApplication(getData(("users." + userIstructor + ".username")), getData(("users." + userIstructor + ".password")));
        Reporter.log(userIstructor + " successfully logs in to the application", true);
        test.instructorResourceCenterPage.instructorManageCourse();
        test.instructorResourceCenterPage.instructorLaunchCourse(getData("Books.course.courseKey"), tier);
        Reporter.log(userIstructor + " successfully launch the course", true);
    }
    @Test
    public void TestStep_19_InstructorPermissions(){
         test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.editDistinctActivity(titleImage);
         test.FramesPage.switchToModeOptionsEditFrame();
        test.MediaPage.EditImageMedia(titleImage);
        test.DashBoardPage.hideUnit(titleImage);
        test.DashBoardPage.deleteDistinctActivity(titleImage);
        test.DashBoardPage.deleteDistinctActivity(titleVideo);
        test.DashBoardPage.deleteDistinctActivity(titleFlash);
        test.DashBoardPage.clickOnView("Unit View");
        test.RSSFeedPage.switchToReader(ReaderUnit);
        test.FramesPage.switchToMainFrame();
        test.MediaPage.DeleteInlineActivity();
        test.MediaPage.DeletePermission();
    }
    //@AfterClass(alwaysRun = true)
    public void stop_test_session() {
        test.closeTestSession();
    }

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
}