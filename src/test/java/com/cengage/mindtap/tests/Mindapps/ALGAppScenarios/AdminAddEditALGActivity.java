/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.ALGAppScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author QAI
 */
public class AdminAddEditALGActivity {
TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user, bookName;
    String userIstructor;
    String userStudent;
    String activityName = getData("learningActivities.LearningLabs.name");
    String coursekey = getData("Books.courseGradeBook.courseKey");
        
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
        test.masterPage.enterCoursekey(coursekey);
    }
    @Test
    public void TestStep_03_LaunchCourse() {
        test.masterPage.ClickOnOrg();
        test.masterPage.ClickOnCourseFromAdmin();
        test.masterPage.LaunchSnapshotFromAdmin();
    }
   /*This test case covers:
        *verify the click on add activity button
        **/
        
    @Test
        public void TestStep_02_clickOnAddIconAndAddActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
        
          /*This test case covers:
        *Add Distinct ALG Activity
        **/ 
        
        }
    @Test
    public void TestStep_03_addDistinctLearningLabsActivity() {
        test.DashBoardPage.clickOnActivity(activityName);
        test.FramesPage.switchToDistinctActivityCreateFrame();
}
}