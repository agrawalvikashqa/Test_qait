/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.SpeechOutlineToolScenarios;

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
 * 
 * @author QAI
 */
public class TC01_InstSpeechOutlineToolAppTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String name1 = getData("Books.SOT.name1");
    String desc1 = getData("Books.SOT.description1");
    String ques1 = getData("Books.SOT.mulcques");
    String ans1 = getData("Books.SOT.mulcans");
    String name2 = getData("Books.SOT.name2");
    String desc2 = getData("Books.SOT.description2");
    String ques2 = getData("Books.SOT.mulsques");
    String ans2 = getData("Books.SOT.mulsans");
    String name_edit = getData("Books.SOT.namedit");
    String ques_edit = getData("Books.SOT.namedit");
    String ans_edit = getData("Books.SOT.namedit");

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: ");
        test = new TestSessionInitiator("Google Drive App");
        user = System.getProperty("user", "instructor");
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+user+".username")), getData(("users."+user+".password")));
        Reporter.log(user+"successfully logs in to the application");
        //test.ssoLoginPage.enrollCourseInUser(user,getData("Books.course.courseKey")); 
    }
    
    @Test
    public void TestStep_02_LaunchCourseViaSSO(){
        if(user.equalsIgnoreCase("instructor")){
            test.instructorResourceCenterPage.instructorLaunchCourse(getData("Books.course.courseKey"), tier);
        }else if(user.equalsIgnoreCase("student")){
            test.studentMyHomePage.studentLaunchCourse(getData("Books.course.courseKey"), tier);
        }
    }
    
    @Test
    public void TestStep_03_LaunchAppFromAppDock() {
        test.SpeechOutlineToolPage.clickOnSpeechOutlineApp();
        Reporter.log(user+"successfully Launch Speech Outline App From App Dock");
    }
    
    @Test
    public void TestStep_04_CreateAssignmetPageValidation() {
        test.SpeechOutlineToolPage.assignmentPageValidation();
        Reporter.log("Error message is appearing fine for 3 input fields");
    }
    
    @Test
    public void TestStep_05_CreateGradedAssignmetVerification() {
        test.SpeechOutlineToolPage.createGradedAssignment(name1, desc1, ques1, ans1);
        Reporter.log("Graded Assignment Created Successfully");
    }
    
    @Test
    public void TestStep_06_CreatePracticeAssignmetVerification() {
        test.SpeechOutlineToolPage.createPracticeAssignment(name2, desc2, ques2, ans2);
        Reporter.log("Practice  Assignment Created Successfully");
    }
    
    @Test
    public void TestStep_07_PrevieGradedAssignmetVerification() {
        test.SpeechOutlineToolPage.previewGradedAssignment(desc1, ques1);
        Reporter.log("Graded Assignment Previewed Successfully and Question Text matched");
    }
    
    @Test
    public void TestStep_08_PreviewPracticeAssignmetVerification() {
        test.SpeechOutlineToolPage.previewPracticeAssignment(desc2, ques2);
        Reporter.log("Graded Assignment Previewed Successfully");
    }
    
    @Test
    public void TestStep_09_EditGradedAssignmetVerification() {
        test.SpeechOutlineToolPage.editGradedAssignment(desc1, name_edit, ques_edit, ans_edit);
        Reporter.log("Graded Assignment Edited Successfully");
    }
    
    @Test
    public void TestStep_10_CloseSOTAppVerification() {
        test.DashBoardPage.closeOpenApp();
        Reporter.log("SOT App Closed Successfully");
    }
    
    @AfterClass()
    public void stop_test_session() {
        //test.closeTestSession();
    }

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
    
}
