/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.DashboardScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import com.qait.automation.utils.ReportMsg;
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
public class TC_03_WeekviewAsInstructorTest {
    
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
        Reporter.log("Jira Ticket: NG-32942 ", true);
        test = new TestSessionInitiator("Week View");
        user = System.getProperty("user", "instructor");
        
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseATP.courseKey"),getData("Books.courseATP.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    /*
   Verify that on launching the course, user is able to see Week view
    */
    
    @Test
    public void TestStep_02_VerifyWeekViewbyDefault(){

        test.DashBoardPage.verifyWeekviewbyDefault();
        ReportMsg.log("Succesfully Verify that on launching the course, user is able to see Week view");
    }
    
    /*
    Skimmer is present on top and user is able to navigate between weeks using this
    */
    
    @Test
    public void TestStep_03_VerifySkimmer(){

        test.DashBoardPage.verifySkimmerFunctionality();
        ReportMsg.log("Succesfully Verify that Skimmer is present on top and user is able to navigate between weeks using this");
     }
    
    /*
    Back and forward week controllers are present to navigate between weeks
    */
    
    @Test
    public void TestStep_04_VerifyNavigateButton(){

        test.DashBoardPage.verifyNavigateButton();
        ReportMsg.log("Succesfully Verify Back and forward week controllers are present to navigate between weeks");
    }

    /* 
     Verify when Due/Available date is not set 
    
    /There are no activities with due dates in this Course.
    /To add due dates, use the Date Manager or Unit View.
    /If your course does not use due dates, you can disable this Week View from the Course Settings.
    
    */
    
    @Test
    public void TestStep_05_VerifyDueAvailableDateNotSet (){

        test.DashBoardPage.verifyDueAvailableDateNotSet();
        test.DashBoardPage.selectOptionFromUserMenu("Course Settings");
        test.DashBoardPage.disableWeekView();
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.clickOnActivity(activityName);
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.webLinkPage.addWebLinkActivity(webURL, text);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addActivityDiscriptionAndTitle(webLinkActivity_title, text);
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.editDistinctActivityNoEdit(webLinkActivity_title);
        test.DashBoardPage.setDueDate();
        test.DashBoardPage.clickOnView("Week View");
        test.DashBoardPage.checkActivityDueAdded();
        ReportMsg.log("Succenfully verify  that are no activities with due dates, add due dates and disable week view");
    }
    
    /*
    /Verify that instructor is able to edit the path name.
    */
    
    @Test
    public void TestStep_06_VerifyPathNameEditable(){

        test.DashBoardPage.editThePathName();
        ReportMsg.log("Succesfully Verify that instructor is able to edit the path name");
        
    }
    
    /*
    /Verify that user is able to see Bar Graph for activity
    */
    
    @Test
    public void TestStep_07_VerifyBarGraph(){
    
        test.DashBoardPage.verifyBarGraph();
        ReportMsg.log("Successfully Verify Bar Graph");
        
    }
    
    /*
    /Verify that instructor is able to see progress of activity.
    */
    @Test
    public void TestStep_08_verifyProgress()
    {
    
        test.DashBoardPage.verifyProgress();
        ReportMsg.log("Successfully Verify Progress of student");
    
    }
    
    /*
    /Verify that user is able to see G and M against Graded and manual graded activity.
    */
    @Test
    public void TestStep_09_VerifyIconGP(){
         
        test.DashBoardPage.verifyIconGP();
        ReportMsg.log("Successfully Verify that user is able to see G and M against Graded and manual graded activity");
                
    }
            
        /*User Logout 
    */
    @Test
    public void TestStep_10_Logout() {
         test.DashBoardPage.Logout();
         Reporter.log(user+" Successfully User Logout",true);
    }
    
    
    /*
    /Login as Student
    /Verify that student is able to see status of activity.
    */
    @Test
    public void TestStep_11_VerifyStudentSeeStatus(){
        
        test.launchApplication(getData("sso_url"));
        String userStudent = System.getProperty("user", "student");
        test.ssoLoginPage.loginToSSOApplication(getData(("users."+userStudent+".username")), getData(("users."+userStudent+".password")));
        Reporter.log(userStudent+"successfully logs in to the application",true);
        test.studentMyHomePage.studentLaunchCourse(getData("Books.courseATP.courseKey"), tier);
        test.DashBoardPage.verifyStudentAbleToSeeStatus();
        ReportMsg.log("Successfully Verify that student is able to see status of activity");
                
    }
          /*User Logout 
    */
    @Test
    public void TestStep_12_Logout() {
         test.DashBoardPage.Logout();
         Reporter.log(user+" Successfully User Logout",true);
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
