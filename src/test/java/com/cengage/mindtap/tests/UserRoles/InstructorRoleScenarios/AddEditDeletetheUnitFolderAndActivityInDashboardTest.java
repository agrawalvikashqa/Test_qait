/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.UserRoles.InstructorRoleScenarios;


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
public class AddEditDeletetheUnitFolderAndActivityInDashboardTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32744", true);
        test = new TestSessionInitiator("Add Edit Delete the Unit Folder And Activity");
        user = System.getProperty("user", "instructor");
    }
   @Test
     public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    /*Add Folder to Dashboard Verification
    */
   @Test
    public void TestStep_02_AddFolder() {
         test.DashBoardPage.clickOnView("Unit View");
         Assert.assertTrue(test.DashBoardPage.addFolder("Test Folder"));
         test.DashBoardPage.deleteDistinctFolder("Test Folder");
         Reporter.log(user+" successfully Verified Add Folder on Dashboard",true);
    }
  /*Add Unit to Dashboard Verification
    */
   @Test
    public void TestStep_03_AddUnit() {
        test.DashBoardPage.AddUnit(getData("Books.course.customUnit"),getData("Books.course.customUnitDescription"));
        Assert.assertTrue(test.DashBoardPage.verifyUsersAddUnit(getData("Books.course.customUnitDescription")));
        test.DashBoardPage.deleteDistinctActivity(getData("Books.course.customUnit"));
         Reporter.log(user+" successfully Verified Add Unit on Dashboard",true);
    }
  /*Add Activity Dialog Box Appears Verification
    */
   @Test
    public void TestStep_04_verifyAddActivityDialogAppears() {
         test.DashBoardPage.clickOnAddIconAndAddActivity();
         Assert.assertTrue(test.DashBoardPage.verifyAddActivityDialogAppears());
         Reporter.log(user+" successfully Verified Add Activity Dialog Appears",true);
    }
  
   /*User Logout 
    */
   @Test
    public void TestStep_05_Logout() {
         test.DashBoardPage.Logout();
         Reporter.log(user+" successfully User Logout",true);
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

