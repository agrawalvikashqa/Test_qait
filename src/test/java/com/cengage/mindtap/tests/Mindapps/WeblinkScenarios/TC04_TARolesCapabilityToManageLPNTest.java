/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.WeblinkScenarios;

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
public class TC04_TARolesCapabilityToManageLPNTest {

    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String activityName = getData("Books.courseWebLink.name");
    String webURL = getData("Books.courseWebLink.url");
    String text = getData("Books.courseWebLink.text");
    String webLinkActivity_title = getData("Books.courseWebLink.title");
    String anotherWebURL = getData("Books.courseWebLink.anotherURL");

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("TA Roles Manage LPN Test");
        user = System.getProperty("user", "TA1");
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }

    @Test
    public void TestStep_02_ManageLPNAddActivity() {
        
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
        test.DashBoardPage.clickOnActivity(activityName);
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.webLinkPage.addWebLinkActivity(webURL, text);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addActivityDiscriptionAndTitle(webLinkActivity_title, text);
        Reporter.log("Succefully add the activity");
    }
    
    @Test
    public void TestStep_03_ManageLPNEditActivity(){
    
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.editDistinctActivity(webLinkActivity_title);
        test.FramesPage.switchToModeOptionsEditFrame();
        test.webLinkPage.fillEntryInField(anotherWebURL, text);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addActivityDiscriptionAndTitle(webLinkActivity_title, text);
        Reporter.log("Succefully verify that activity can be edit");
        
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
