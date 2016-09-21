/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.QuestiaAppScenarios;

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
public class TC01_VerifyQuestiaAppTest {
  TestSessionInitiator test;
String tier = ObjectFileReader.getTier().replaceAll("/", "");

String user;

@BeforeClass
public void start_test_session() {
Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32839", true);
test = new TestSessionInitiator("Questia App Test");
user = System.getProperty("user", "instructor");
}

@Test
public void TestStep_01_LoginToSSOApplication() {
test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
Reporter.log(user+" successfully logs in to the application",true);
}
/*This test case covers:
*Verifying of Questia App
**/
@Test
public void TestStep_02_LaunchAppFromAppDock() {
test.DashBoardPage.clickOnAppByName("Questia");
Reporter.log("[ASSERT PASS]:Questia is launched ",true);
}

@Test
public void TestStep_03_instSearchContentWithinQuestiaApp(){
test.FramesPage.switchToDockIFrame();  
test.QuestiaPage.verifySearchbox();
test.QuestiaPage.selectSearchByTerm("History");
test.QuestiaPage.clickonSearchButton();

    }

@Test
public void TestStep_04_verifySearchContentIsDisplayed(){
test.QuestiaPage.verifySearchFilterValues("History");
test.QuestiaPage.verifySearchContentCount("10");
}
@Test
public void TestStep_05_TabsOnQuestia() {
test.QuestiaPage.TabsOnQuestia();
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


