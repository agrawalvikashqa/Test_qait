/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.InsiteScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * 
 * @author QAI
 */
public class TC03_InstructorDeleteDistinctAndInlineInsiteActivity {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

     @BeforeClass
    
    public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Insite App");
        user = System.getProperty("user", "instructor");
        test.launchApplication(getData("sso_url"));
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+user+".username")), getData(("users."+user+".password")));
        Reporter.log(user+"successfully logs in to the application",true);
        //test.ssoLoginPage.enrollCourseInUser(user,getData("Books.course.courseKey")); 
    }
    
    @Test
    public void TestStep_02_LaunchCourseViaSSO(){
        if(user.equalsIgnoreCase("instructor")){
            test.instructorResourceCenterPage.instructorLaunchCourse(getData("Books.courseInsite.courseKey"), tier);
        }else if(user.equalsIgnoreCase("student")){
            test.studentMyHomePage.studentLaunchCourse(getData("Books.course.courseKey"), tier);
        }
    }
    /*This test case covers:
     *Verifying of Google Drive App 
     **/
    
    @Test
    public void TestStep_03_InstructorDeleteInsiteAssignments(){
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.deleteDistinctActivity(getData("learningActivities.insite.Paper_Ass_Name"));
    }
    
    
   
    
   
    
    
    
    
}
