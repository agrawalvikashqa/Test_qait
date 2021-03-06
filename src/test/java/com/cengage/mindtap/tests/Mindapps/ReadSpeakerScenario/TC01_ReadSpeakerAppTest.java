/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.ReadSpeakerScenario;

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
 * @author QAI
 */
    public class TC01_ReadSpeakerAppTest {
        TestSessionInitiator test;
        String tier = ObjectFileReader.getTier().replaceAll("/", "");

        String user;

        @BeforeClass
        public void start_test_session() {
            Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32816", true);
            test = new TestSessionInitiator("Read Speaker App Test");
            user = System.getProperty("user", "student");
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
        /*This test case covers:
        *Verifying of ReadSpeaker App
        **/
        @Test
            public void TestStep_03_LaunchAppFromAppDock() {
            test.DashBoardPage.clickOnAppByName("ReadSpeaker");
            Reporter.log(user+" successfully Launch ReadSpeaker App From App Dock",true);
        }
        /*This test case covers:
        *Verifying the Dropdown On ReadSpeaker App
        **/
        @Test
            public void TestStep_04_verifyDropdownOnReadSpeaker() {
            test.FramesPage.switchToDockIFrame();
             Assert.assertTrue(test.ReadSpeakerPage.DropdownOnReadSpeaker());
            Reporter.log(user+"  successfully Verified Button On Read Speaker",true);
        }

        @Test
         public void TestStep_05_verifyClickOnspeaker_speed_Dropdown() {
            Assert.assertTrue(test.ReadSpeakerPage.clickOnspeaker_speed_Dropdown());
           test.ReadSpeakerPage.clickOninit_mediumSpeed_option();
           test.ReadSpeakerPage.clickOnReadSpeedSelectedValue("Medium");
           Reporter.log(user+"  successfully Verified Click On speaker_speed_Dropdown On Read Speaker",true);
       }

        @Test
        public void TestStep_06_verifyClickspeaker_voice_Dropdown() {
            test.ReadSpeakerPage.clickOnspeaker_voice_Dropdown();
            test.ReadSpeakerPage.clickOninit_maleVoice_option();
            test.ReadSpeakerPage.clickOnVoiceSelectValue("Male");
            Reporter.log(user+"  successfully Verified Click On speaker_voice_Dropdown On Read Speaker",true);
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

   
