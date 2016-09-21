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
public class CSMRegressionTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user , userCI , userTA ;

    @BeforeClass
    public void start_test_session() {
       Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-33008", true);
        test = new TestSessionInitiator("CSM Feature Regression Test");
        user = System.getProperty("user", "instructor");
        userCI = System.getProperty("user", "coInstructor");
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
        test.CSMPage.clickOnEditCSMCourse();
        Reporter.log(user+" clicked on Edit Link snd successfully navigated to Edit Course Page",true);
    }
    @Test
    public void TestStep_03_verifyInstructorAddsCoInstructorToCourse(){
        test.CSMPage.clickOnAddCoInstuctorOrTALink();
        test.CSMPage.addCoInstructorToCourse();
        Reporter.log(user+" Successfully added Co-instructor To Course",true);
    }
    
    @Test
    public void TestStep_04_verifyInstructorAddsTAtoCourse(){
        test.CSMPage.clickOnAddCoInstuctorOrTALink();
        test.CSMPage.addTAtoCourse();
        Reporter.log(user+" Successfully added TA To Course",true);
    }
    
    @Test
    public void TestStep_05_verifyInstructorSavesChangesAfterAddingCoInstructorAndTA(){
        test.CSMPage.clickSaveChangesButtonOnEditCoursePage();
        Reporter.log(user+" hits Save Changes button on Edit Course Page after adding Co-intructor and TA",true);
        test.CSMPage.verifyChangesAreSavedFromEditCoursePage();
        Reporter.log(user+" has successfully saved changes after adding Co-intructor and TA",true);
    }
    
    @Test
    public void TestStep_06_verifyEnrolledCoInstructorAbletoLaunchCourse(){
        test.ssoLoginPage.logOutFromSSO();
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+userCI+".username")), getData(("users."+userCI+".password")));
        test.CSMPage.coinstructorLaunchCourse(getData("Books.courseCSM.CourseKey"), tier);
        Reporter.log(userCI+" successfully logs in to the application",true);
    }
    
    @Test
    public void TestStep_07_verifyCourseSettingsLinkDisplaysForCoInstructor(){
        test.CSMPage.verifyCourseSettingsLink();
        Reporter.log("Course Settings link successfully verified for "+userCI,true);
    }
    
    @Test
    public void TestStep_08_verifyCoInstructorLaunchesCourseSettingsWindow(){
        test.CSMPage.courseSettingsWindowlaunch();
        Reporter.log(userCI+" successfully launches Course Settings Window  ",true);
    }
    
    @Test
    public void TestStep_09_verifyTAandPrimaryInstructorDisplaysInInstructorAndTAPermissionSection(){
        test.CSMPage.clickOnInstructorAndTAPermissions();
        Reporter.log(userCI+" clicked on Instructor and TA Permissions to expand it  ",true);
        test.CSMPage.verifyPrimaryInstructorAndTAareDisplayed();
        Reporter.log("Successfully verified Primary Instructor and Enrolled TA displays for "+userCI,true);   
    }
    
    @Test
    public void TestStep_10_verifyCoInstructorHasAllCapabilitiesByDefault(){
       test.CSMPage.CoInstructorCapabilitiesByDefault();
       test.CSMPage.verifyAllCoInstructorCapabilitiesChecked();
        Reporter.log(userCI+" has all the Capabilities checked by Default ",true);
    }
    
    @Test
    public void TestStep_11_verifyNoCapabilitiesForTAByDefault(){
        test.CSMPage.TACapabilitiesByDefault();
        Reporter.log(" Verified Successfully TA has No Capabilities by Default ",true);
    }
    
    @Test
    public void TestStep_12_verifyCoInstructorAbleToEditTACapabilities(){
        test.CSMPage.CoIntructorEditTACapabilities();
        Reporter.log(" CoInstructor Successfully Edited TA's capabilities ",true);
        test.CSMPage.saveCSMSettings();
        Reporter.log(" CoInstructor Successfully Saves the Settings ",true);
    }
    
    @Test
    public void TestStep_13_verifyCoInstructorLogOut(){
        test.CSMPage.CoInstructorLogout();
        Reporter.log(userCI+" Successfully Logged Out from Mindtap ",true);
    } 
    
    @Test
    public void TestStep_14_verifyEnrolledTALaunchesCourse(){
        test.launchApplication(getData("sso_url"));
        test.ssoLoginPage.loginToSSOApplication(getData(("users." + userTA + ".username")), getData(("users." + userTA + ".password")));
        Reporter.log(userTA + " successfully logs in to the application", true);
        test.studentMyHomePage.studentLaunchCourse(getData("Books.courseCSM.CourseKey"), tier);
        Reporter.log(userTA + " has successfully launched the course", true);
    }
    
    @Test
    public void TestStep_15_verifyCourseSettingsLinkIsPresentForTA(){
        test.CSMPage.CourseSettingLinkPresentForTA();
        Reporter.log(" Verified successfully that Course Setting Link is Displaying for TA when permission is given", true);
    }
    
    @Test
    public void TestStep_16_verifyTAisAbleToManageGradeBook(){
       // test.DashBoardPage.clickOnAllApps();
        test.DashBoardPage.clickOnAppByName("Progress");
        test.DashBoardPage.closeOpenApp();
        Reporter.log(userTA+"  successfully Launched and closed Gradebook App From App Dock",true);
    }
    
    @Test
    public void TestStep_17_verifyTAableToSetAndClearDatesFromDateManager(){
        test.CSMPage.setAndClearDueDateTA();
        Reporter.log(userTA+" successfully sets and clears date from Date manager",true);
     }
    
    @Test
    public void TestStep_18_verifyTAisAbleToLogOutFromMindtap(){
        test.CSMPage.logOutTAFromMindtap();
        Reporter.log(userTA+" has been able to Successfully Logout from Mindtap",true);
    }
       
    @Test
    public void TestStep_19_verifyCourseSettingLinkDisplaysForPrimaryInstructor(){
        test.launchApplication(getData("sso_url"));
        test.ssoLoginPage.loginToSSOApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")));
        Reporter.log(user + " successfully logs in to the application", true);
        test.instructorResourceCenterPage.instructorManageCsmCourse();
        Reporter.log(user+" Successfully navigated to Manage Courses",true);
        test.CSMPage.instructorLaunchCSMCourse(getData("Books.courseCSM.CourseKey"), tier);
        Reporter.log(user + " has successfully launched the course", true);
        test.CSMPage.verifyCourseSettingsLink();
        Reporter.log("Course Settings link successfully verified for "+user,true);
    } 
    
    @Test
    public void TestStep_20_verifyCoInstructorAndTADisplaysAtPrimaryInstructor(){
        test.CSMPage.courseSettingsWindowlaunch();
        Reporter.log(user+" has successfully launched Course Settings Window  ",true);
        test.CSMPage.clickOnInstructorAndTAPermissions();
        test.CSMPage.verifyCoInstructorAndTAareDisplayed();
        Reporter.log("CoInstructor and TA are displayed in Course Settings of Primary Instructor",true);       
    }
    
    @Test
    public void TestStep_21_verifyInstructorEditsCapabilitiesOfTA(){
        test.CSMPage.instructorEditsCapabilitiesOfTA();
        Reporter.log("Instructor is able to Edit Capabilities of TA",true);
    }
    
    @Test
    public void TestStep_22_verifySavePermissionButtonAndDoneButtonOnCSMWindow(){
        test.CSMPage.savePermissionButtonAndDoneButtonOnCSMWindow();
        Reporter.log("Successfully verified Save Permission and Done button on CSM Window",true);
        
    }
    
    @Test
    public void TestStep_23_verifyPrimaryInstructorSaveCSMSettings(){
        test.CSMPage.saveCSMSettings();
        Reporter.log("Instructor has been able to successfully save settings in CSM Window ",true);
    }
    
    @Test
    public void TestStep_24_verifyPrimaryInstructorLogoutAfterSavingCSMSettings(){
        test.CSMPage.primaryInstructorLogoutAfterSavingCSMSettings();
        Reporter.log("Primary Instructor has  successfully logged out after saving CSM Settings ",true); 
    } 
    
    @Test
    public void TestStep_25_verifyInstructorAbleToRemoveCoInstructorAndTAfromCourse(){
        test.launchApplication(getData("sso_url"));
        test.ssoLoginPage.loginToSSOApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")));
        Reporter.log(user + " successfully logs in to the application", true);
        test.instructorResourceCenterPage.instructorManageCsmCourse();
        Reporter.log(user+" Successfully navigated to Manage Courses",true);
        test.CSMPage.clickOnEditCSMCourse();
        Reporter.log(user+" clicked on Edit Link snd successfully navigated to Edit Course Page",true);
        test.CSMPage.removeCoInstructorAndTA();
        Reporter.log(user+" successfully removed CoInstructor And TA From the Course",true);
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
