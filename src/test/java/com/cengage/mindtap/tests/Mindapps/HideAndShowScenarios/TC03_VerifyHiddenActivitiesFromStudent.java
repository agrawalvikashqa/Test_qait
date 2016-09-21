/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.HideAndShowScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.DateUtil.getDate;
import static com.qait.automation.utils.YamlReader.getData;

public class TC03_VerifyHiddenActivitiesFromStudent {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String titleAssessment="AA_Assessment" + getDate();
    String titleHomework="AA_Homework" + getDate();
    String ReaderUnit="Introduction to Medical Terminology";

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("AA and Hide activity");
        user = System.getProperty("user", "student");
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAA.courseKey"),getData("Books.courseAA.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    
    @Test
    public void TestStep_02_VerifyHiddeneUnitFromLPN(){
        test.DashBoardPage.clickOnView("Unit View");
        test.AssignableActivityPage.activitiesAfterHiddenItems(titleAssessment);
        test.AssignableActivityPage.activitiesAfterHiddenItems(ReaderUnit);
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
