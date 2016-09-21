/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.speechvideolibraryapptestcases;

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
 * @author QAIT
 */
public class TC02_InstAndAddDistinctSVRActivityTest {
 
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("SVR");
        user = System.getProperty("user", "instructor");
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseATP.courseKey"),getData("Books.courseATP.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true);   
    } 
    @Test
    public void TestStep_02_addDistinctSVRActivityInLPN(){ 
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.clickOnActivity(getData("learningActivities.SVR.name"));
        test.SVR.addDistinctSVRActivity(getData("learningActivities.SVR.searchKey1"),getData("learningActivities.SVR.searchKey2"),getData("learningActivities.SVR.title"),getData("learningActivities.SVR.description"));
        Reporter.log("Completed Add Distinct SVR Activity in LPN",true);
    }
    
    
    @Test
    public void TestStep_03_editDistinctSVRActivityInLPN(){
    test.DashBoardPage.refreshPage();
    test.DashBoardPage.clickOnView("Unit View");
    test.SVR.editDistinctActivity(getData("learningActivities.SVR.title"));
    test.SVR.editActivityDetails(getData("learningActivities.SVR.newTitle"),getData("learningActivities.SVR.description"));
    Reporter.log("Completed edit Distinct SVR Activity in LPN",true);
    }


    
    /*User Logout 
    */
   @Test
    public void TestStep_04_Logout() {
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
