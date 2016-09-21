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
public class DashboardViewTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32744", true);
        test = new TestSessionInitiator("Verify Dashboard View");
        user = System.getProperty("user", "instructor");
    }
   @Test
     public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
   //@Test
    public void TestStep_02_verifyUserNavigateToSplashPageAfterAccept() {
        test.DashBoardPage.verifyUserNavigateToSplashPage();
        Reporter.log(user+" successfully verify User Navigate To Splash Page After Accept",true);
    }

 //   @Test
    public void TestStep_03_verifyEulaPageUIVerification() {
        test.DashBoardPage.verifyEulaPage();
        Reporter.log(user+" successfully verify Eula Page UI Verification",true);
    }

    @Test
    public void TestStep_04_verifyAllSplashViewLinksAreClickable() {
        test.DashBoardPage.verifyAllSplashViewLinksAreClickable();
        Reporter.log(user+" successfully verify All Splash View Links Are Clickable",true);
    }

    @Test
    public void TestStep_05_verifyHelpOverlayDisplay() {
        test.DashBoardPage.helpOverlayDisplay();
        Reporter.log(user+" successfully verify Help Overlay Display",true);
       
    }

    @Test
    public void TestStep_06_verifyWeekWidgetView() {
         Assert.assertTrue(test.DashBoardPage.verifyWeekWidget());
        Reporter.log(user+" successfully verify Dashboard View",true);
        }

    @Test
    public void TestStep_07_verifySwitchModeLinkIsVisibleOnDashboard() {
        test.DashBoardPage.switchModeDisplayOnWeekWidgetPage();
        Reporter.log(user+" successfully verify Switch Mode Link Is Visible On Dashboard",true);
        
    }

    @Test
    public void TestStep_08_verifyCengageLogoIsDisplayedInDashboardView() {
        test.DashBoardPage.verifyCengageLogoIsDisplayedInDashboardView();
        Reporter.log(user+" successfully verify Cengage Logo Is Displayed In Dashboard View",true);
       
    }

    @Test
    public void TestStep_9_ViewAllScoresDisplayAnLaunch() {
        test.DashBoardPage.viewAllScoresDisplayAnLaunch(user);
        Reporter.log(user+" successfully View All Scores Display An Launch",true);
      
    }

    @Test
    public void TestStep_10_ViewAllNotificationsDisplayAnLaunch() {
        
        test.DashBoardPage.ViewAllNotificationsDisplayAnLaunch(user);
        Reporter.log(user+" successfully View All Notifications Display An Launch",true);
        
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
