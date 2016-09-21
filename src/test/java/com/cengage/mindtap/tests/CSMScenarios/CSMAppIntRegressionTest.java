/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.CSMScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
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
public class CSMAppIntRegressionTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user , userTA ;

    @BeforeClass
    public void start_test_session() {
       Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-33130", true);
        test = new TestSessionInitiator("CSM App Integration Feature Regression Test");
        user = System.getProperty("user", "instructor");
        userTA = System.getProperty("user", "teachingAssistant");
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+user+".username")), getData(("users."+user+".password")));
        Reporter.log(user+" successfully logs in to the application",true);
    }
    
    @Test
    public void TestStep_02_NavigateToManageAndEditCourseThroughSSO(){
       test.instructorResourceCenterPage.instructorManageCsmCourse();
        Reporter.log(user+" Successfully navigated to Manage Courses",true);
        test.CSMAppIntPage.clickOnEditCSMAppIntCourse();
        Reporter.log(user+" clicked on Edit Link snd successfully navigated to Edit Course Page",true);
    }
    
    
    @Test
    public void TestStep_03_verifyInstructorAddsTAtoCourse(){
        test.CSMPage.clickOnAddCoInstuctorOrTALink();
        test.CSMPage.addTAtoCourse();
        Reporter.log(user+" Successfully added TA To Course",true);
    }
    
    @Test
    public void TestStep_04_verifyInstructorSavesChangesAfterAddingTA(){
        test.CSMPage.clickSaveChangesButtonOnEditCoursePage();
        Reporter.log(user+" hits Save Changes button on Edit Course Page after adding  TA",true);
        test.CSMPage.verifyChangesAreSavedFromEditCoursePage();
        Reporter.log(user+" has successfully saved changes after adding  and TA",true);
    }
    
    @Test
    public void TestStep_05_verifyInstructorLaunchCourseAfterEnrollingTA(){
        test.ssoLoginPage.logOutFromSSO();
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+user+".username")), getData(("users."+user+".password")));
        test.instructorResourceCenterPage.instructorLaunchCourse(getData("Books.courseCSMAppInt.CourseKey"), tier);
        Reporter.log(user+" successfully logs in to the application",true);
    }
    
    @Test
    public void TestStep_06_verifyInstructorLaunchesCourseSettingsWindow(){
        test.CSMAppIntPage.clickUserMenuLink();
        test.CSMAppIntPage.clickCourseSettings();
        Reporter.log(user+" successfully launches Course Settings Window  ",true);
    }
    
    @Test
    public void TestStep_07_verifyTADisplaysInInstructorAndTAPermissionSection(){
        test.CSMPage.clickOnInstructorAndTAPermissions();
        Reporter.log(user+" clicked on Instructor and TA Permissions to expand it  ",true);
        test.CSMAppIntPage.verifyTAIsDisplayed();
        Reporter.log("Successfully verified Enrolled TA displays for "+user,true);   
    }
    
    @Test
    public void TestStep_08_verifyNoCapabilitiesForTAByDefault(){
        test.CSMPage.TACapabilitiesByDefault();
        Reporter.log(" Verified Successfully TA has No Capabilities by Default ",true);
    }
    
    @Test
    public void TestStep_09_verifyInstructorAbleToEditTACapabilities(){
        test.CSMAppIntPage.instructorEditTACapabilities();
        Reporter.log(" Instructor Successfully Edited TA's capabilities ",true);
        test.CSMPage.saveCSMSettings();
        Reporter.log(" Instructor Successfully Saves the Settings ",true);
        test.CSMPage.primaryInstructorLogoutAfterSavingCSMSettings();
        Reporter.log(" Instructor Successfully Logout after Saving Settings ",true);
       
    }
    
    @Test
    public void TestStep_10_verifyEnrolledTALaunchesCourse(){
        test.launchApplication(getData("sso_url"));
        test.ssoLoginPage.loginToSSOApplication(getData(("users." + userTA + ".username")), getData(("users." + userTA + ".password")));
        Reporter.log(userTA + " successfully logs in to the application", true);
        test.studentMyHomePage.studentLaunchCourse(getData("Books.courseCSMAppInt.CourseKey"), tier);
        Reporter.log(userTA + " has successfully launched the course", true);
    }
    
    @Test
    public void TestStep_11_verifyTAisAbleToLaunchApliaAppFromAppDock(){
        //test.DashBoardPage.clickOnAllApps();
        test.DashBoardPage.clickOnAppByName("Aplia");
        test.CSMAppIntPage.apliaAppUI();
        test.CSMAppIntPage.verifyApliaLoadsCompletely();
        test.DashBoardPage.closeOpenApp();
        Reporter.log(userTA+"  successfully Launched and closed Aplia App From App Dock",true);
    }
    
    @Test
    public void TestStep_12_verifyTAisAbleToLaunchCnowHomeWorkAppFromAppDock(){
        //test.DashBoardPage.clickOnAllApps();
        test.CSMAppIntPage.clickOnCnowHomeWorkApp();
        test.CSMAppIntPage.CNowHWAppUI();
        test.CSMAppIntPage.verifyCNowHWAppLoadsCompletely();
        test.DashBoardPage.closeOpenApp();
        Reporter.log(userTA+"  successfully Launched and closed CNow Homework App From App Dock",true);       
    }
  
    @Test
    public void TestStep_13_verifyTANavigatesToAddActivityPanel(){
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.CSMAppIntPage.verifyAddActivityWindowLaunch();
        Reporter.log(userTA+"  successfully navigated to Add Activity Panel",true);
    }
    
    @Test
    public void TestStep_14_verifyWebVideoLaunchesForTAFromAddActivityPanel(){
        test.CSMAppIntPage.addActivityPanelWebVideoLaunch();
        Reporter.log(userTA+"  successfully loads WebVideo App from Add Activity Window",true);
        test.CSMAppIntPage.navigateBackToAddActivityPanel();
        Reporter.log(userTA+"  successfully navigated to  Add Activity Window",true);
         }
    
   @Test
    public void TestStep_15_verifyWebLinkLaunchesForTAFromAddActivityPanel(){
        test.CSMAppIntPage.addActivityPanelWebLinkLaunch();
        Reporter.log(userTA+"  successfully loads WebLink App from Add Activity Window",true);
        test.CSMAppIntPage.navigateBackToAddActivityPanel();
        Reporter.log(userTA+"  successfully navigated to  Add Activity Window",true);
    }
    
    @Test
    public void TestStep_16_verifyRSSAppLaunchesForTAFromAddActivityPanel(){
        test.CSMAppIntPage.addActivityPanelRSSAppLaunch();
        Reporter.log(userTA+"  successfully loads RSS App from Add Activity Window",true);
        test.CSMAppIntPage.navigateBackToAddActivityPanel();
        Reporter.log(userTA+"  successfully navigated to  Add Activity Window",true);
    }
    
    @Test
    public void TestStep_17_verifyYSUAppLaunchesForTAFromAddActivityPanel(){
        test.CSMAppIntPage.addActivityPanelYSUAppLaunch();
        Reporter.log(userTA+"  successfully loads YSU App from Add Activity Window",true);
        test.CSMAppIntPage.navigateBackToAddActivityPanel();
        Reporter.log(userTA+"  successfully navigated to  Add Activity Window",true);   
    }
      
    @Test
    public void TestStep_18_verifySVRAppLaunchesForTAFromAddActivityPanel(){
        test.CSMAppIntPage.addActivityPanelSVRAppLaunch();
        Reporter.log(userTA+"  successfully loads SVR App from Add Activity Window",true);
        test.CSMAppIntPage.navigateBackToAddActivityPanel();
        Reporter.log(userTA+"  successfully navigated to  Add Activity Window",true);
    }
    
    @Test
    public void TestStep_19_verifyQuestiaAppLaunchesForTAFromAddActivityPanel(){
        test.CSMAppIntPage.addActivityPanelQuestiaAppLaunch();
        Reporter.log(userTA+"  successfully loads Questia App from Add Activity Window",true);
        test.CSMAppIntPage.navigateBackToAddActivityPanel();
        Reporter.log(userTA+"  successfully navigated to  Add Activity Window",true);
    }
    
    @Test
    public void TestStep_20_verifyTAAddDeleteActivity(){
        test.CSMAppIntPage.addDeleteActivityThroughTA();
        test.flashcardpage.selectChapterForFlashCardActivity();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addActivityDescriptionAndTitle("AnyTitle", "AnyDescription");
        Reporter.log("[ASSERT PASS]:New Flashcard added to LPN successfully ",true);
        test.DashBoardPage.deleteDistinctActivity("AnyTitle");
        Reporter.log("[ASSERT PASS]:Flash Card deleted successfully from LPN",true);
    }
    
    @Test
    public void TestStep_21_verifyTAisAbleToLogOutFromMindtap(){
        test.CSMPage.logOutTAFromMindtap();
        Reporter.log(userTA+" has been able to Successfully Logout from Mindtap",true);
    }
    
    @Test
    public void TestStep_22_verifyInstructorLaunchCourseAndRemoveAllTAPermissions(){
        test.launchApplication(getData("sso_url"));
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+user+".username")), getData(("users."+user+".password")));
        test.instructorResourceCenterPage.instructorLaunchCourse(getData("Books.courseCSMAppInt.CourseKey"), tier);
        Reporter.log(user+" successfully logs in to the application",true);
        test.CSMPage.verifyCourseSettingsLink();
        test.CSMPage.courseSettingsWindowlaunch();
        Reporter.log(user+" has successfully launched Course Settings Window  ",true);
        test.CSMPage.clickOnInstructorAndTAPermissions();
        test.CSMPage.instructorEditsCapabilitiesOfTA();
        test.CSMPage.saveCSMSettings();
        test.CSMPage.primaryInstructorLogoutAfterSavingCSMSettings();
        Reporter.log("Primary Instructor has  successfully logged out after saving CSM Settings ",true); 
    }
    
    @Test
    public void TestStep_23_verifyInstructorAbleToRemoveTAfromCourse(){
        test.launchApplication(getData("sso_url"));
        test.ssoLoginPage.loginToSSOApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")));
        Reporter.log(user + " successfully logs in to the application", true);
        test.instructorResourceCenterPage.instructorManageCsmCourse();
        Reporter.log(user+" Successfully navigated to Manage Courses",true);
        test.CSMAppIntPage.clickOnEditCSMAppIntCourse();
        Reporter.log(user+" clicked on Edit Link snd successfully navigated to Edit Course Page",true);
        test.CSMPage.removeCoInstructorAndTA();
        Reporter.log(user+" successfully removed TA From the Course",true);
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
