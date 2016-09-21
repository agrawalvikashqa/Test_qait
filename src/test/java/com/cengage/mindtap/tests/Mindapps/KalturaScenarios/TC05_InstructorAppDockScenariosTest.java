/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.KalturaScenarios;


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
public class TC05_InstructorAppDockScenariosTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32749", true);
        test = new TestSessionInitiator("Kaltura App Dock Scenarios Test");
        user = System.getProperty("user", "student");
    }

    
    //@Test
    public void TestStep_01_CheckUnSharedFileFromStudentEnd() {
    
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        test.DashBoardPage.clickOnAllApps();
        test.kalturaAppPage.clickKalturaAppVerifyUnSharedFile();
        Reporter.log(user + " Successfully check that files not has been shared with students ",true);
        test.DashBoardPage.Logout();
        
    }
    
    //@Test
    public void TestStep_02_LoginToSSOApplication() {
        user = System.getProperty("user", "instructor");
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
   //Check the checkbox to share with student.
    
    //@Test
    public void TestStep_03_VerifySharingKalturaFile() {
    
        test.DashBoardPage.clickOnAllApps();
        test.kalturaAppPage.clickOnKalturaApp();
        Reporter.log(user+" Successfully Launch  Kaltura from My Content App in App Dock",true);
        test.kalturaAppPage.ShareMediaFileWithStudent();      
        Reporter.log(user+" Successfully share files with students ",true);
        test.DashBoardPage.Logout();
    }
    
    
    //Checked Kaltura file is shared successfully to Student
    
    //@Test
    public void TestStep_04_VerifyCheckSharedFileFromStudentEnd() {
    
        user = System.getProperty("user", "student");
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        test.DashBoardPage.clickOnAllApps();
        test.kalturaAppPage.clickKalturaAppVerifySharedFile();
        Reporter.log(user + " Successfully Launch  Kaltura App from App Dock and verified that media is shared with student",true);
        test.DashBoardPage.Logout();
    }
    
    //@Test
    public void TestStep_05_VerifyShowOnlyContent() {
        user = System.getProperty("user", "instructor");
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        test.DashBoardPage.clickOnAllApps();
        test.kalturaAppPage.clickOnKalturaApp();
        Reporter.log(user+" Successfully Launch  Kaltura from My Content App in App Dock",true);
        test.kalturaAppPage.ClickOnShowOnlyContent();
        test.DashBoardPage.Logout();
        
    }
    
    /**
     
     * Bug in this test Case for vedio filter : Vedio not uploading after unshared with student
     
     */
    
    //@Test
    public void TestStep_06_VerifyFilterOption() {
        user = System.getProperty("user", "instructor");
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        test.DashBoardPage.clickOnAllApps();
        test.kalturaAppPage.clickOnKalturaApp();
        Reporter.log(user+" Successfully Launch  Kaltura from My Content App in App Dock",true);
        test.kalturaAppPage.VerifyFilterOption();
        
    }
    
    /**
     
     * Verify that Instructor is able to save the changes corresponding to the Kaltura file.
       **after image file shared  
     */
    
    //@Test
    public void TestStep_07_VerifyEditOption() {
        
        test.kalturaAppPage.clickOnEdit();
        Reporter.log(user+"Successfully Verify that Instructor is able to save the changes corresponding to the Kaltura file.",true);
        
    }
    
    /**
    *Verify that Instructor is able to remove the Kaltura file.
    */
    //@Test
    public void TestStep_08_VerifyDeleteFile() {

        test.kalturaAppPage.VerifyDeleteFile();
        Reporter.log(user+"Successfully Verify that Instructor is able to remove the Kaltura file.",true);
        
    }
    
     @Test
    void TestStep_09_logOut(){
        test.DashBoardPage.Logout(); 
        Reporter.log("Completed logOut",true);
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
