/*productionUser
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.UserRoleScenarios.courseCareRoleScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.apache.commons.lang3.StringUtils;
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
 * @author QAI
 */
public class inmpersonateToCourseViaInstructorTest {

    TestSessionInitiator test;
    String user, bookName;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Create And Launch Master Next Book And Verify LPN");
        user = System.getProperty("user", "courseCare");
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
    public void TestStep_02_LaunchAdminSnapshot(){
        test.masterPage.clickOnOrganizationTab();
        test.masterPage.enterCoursekey(getData("Books.course.courseKey"));
        test.masterPage.ClickOnOrg();
        test.masterPage.ClickOnCourse(getData("Books.course.courseName"));
       
    }
    @Test
    public void TestStep_03_InmpersonateToOtherInstructors() {
        test.masterPage.InmpersonateToOtherUser(getData(("users.instructor.Name")));
        Assert.assertTrue(test.DashBoardPage.verifyUserssuccessfullyLogsInToTheApplication());
        Reporter.log(user + " successfully logs in to the application", true);
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
