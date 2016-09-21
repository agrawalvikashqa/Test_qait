/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.DashboardScenarios;


import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
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
 * 
 * @author QAI
 */
public class TC_07_LPNInstructorUnitTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String unitName = getData("Books.course.customUnit");
    String newName = getData("Books.course.customUnitEdit");
    String newDescription = getData("Books.course.customUnitEdit");
    
    String user;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("VerifyDashboardView");
        user = System.getProperty("user", "instructor");
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+user+".username")), getData(("users."+user+".password")));
        Reporter.log(user+" successfully logs in to the application",true);
    }
    
    @Test
    public void TestStep_02_LaunchCourseViaSSO(){
        if(user.equalsIgnoreCase("instructor")){
            test.instructorResourceCenterPage.instructorLaunchCourse(getData("Books.course.courseKey"), tier);
        }else if(user.equalsIgnoreCase("student")){
            test.studentMyHomePage.studentLaunchCourse(getData("Books.course.courseKey"), tier);
        }
    }
  
    /*LPN Unit Verification
    */
   
    @Test
    public void TestStep_03_AddTestUnit() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.AddUnit(getData("Books.course.customUnit"),getData("Books.course.customUnitDescription"));
        Assert.assertTrue(test.DashBoardPage.verifyUsersAddUnit(getData("Books.course.customUnitDescription")));
    }
    
    @Test
    public void TestStep_04_EditAndReorderTestUnit() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.editUnit(unitName);
        test.DashBoardPage.inputEditDescriptionAndDateOfCustomUnit(newDescription);      
    }
    
    @Test
    public void TestStep_05_HideTestUnit() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.hideUnit(unitName);
        test.DashBoardPage.unhideUnit(unitName);
    }
    
    @Test
    public void TestStep_06_DeleteTestUnit() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.deleteDistinctActivity(unitName);
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
