/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.DashboardScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import com.qait.automation.utils.ReportMsg;
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
public class TC_05_PerformanceWidgetAsStudentTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    
     @BeforeClass
public void start_test_session() {
        Reporter.log("Jira Ticket: NG-32942 ", true);
        test = new TestSessionInitiator("Week View");
        user = System.getProperty("user", "studentDashboard");
        
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAndersen.CourseKey"),getData("Books.courseAndersen.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
        
    }
   
    /*
    /Verify that user is able to see "RECENT ACTIVITY SCORES" on Performance Widget
    */
    
    @Test
    public void TestStep_02_VerifyPerformanceWiggetTitle(){
     
        Assert.assertTrue(test.DashBoardPage.verifyPerformanceWiggetTitle(),"user is not able to see RECENT ACTIVITY SCORES on Performance Widget"); 
        ReportMsg.log("Successfully Verify Performance Widget Title ");
        
    }
    
    /*
    /Verify that on clicking "Open Full Gradebook" link, Gradbook should launch
    */
    
    @Test
    public void TestStep_03_VerifyFullGradebookLink(){
    
        test.DashBoardPage.viewAllScoresDisplayAnLaunch(user);
        ReportMsg.log("Successfully Verify that on clicking Open Full Gradebook link, Gradbook is launching");
    }
    
    /*
    /Verify that user is able to see ‘Performance scores’ dot as Green if score is 90% and above.
    */
    
    @Test
    public void TestStep_04_VerifyPerformanceScoresGreen(){
    
        Assert.assertTrue(test.DashBoardPage.verifyPerformanceScoresGreen(),"color is not green");
        ReportMsg.log("Successfully verify that user is able to see Performance scores dot as Green if score is 90% and above.");
    }
    
    /*
    /Verify that user is able to see ‘Performance scores’ dot as Yellow if score is 70-89% .
    */
    
    @Test
    public void TestStep_05_VerifyPerformanceScoresYellow(){
    
        Assert.assertTrue(test.DashBoardPage.verifyPerformanceScoresYellow(),"color is not yellow");
        ReportMsg.log("Successfully Verify that user is able to see ‘Performance scores’ dot as Yellow if score is 70-89% and above.");
    }
    
    /*
    /Verify that user is able to see ‘Performance scores’ dot as Red if score is 69% and below.
    */
    
    @Test
    public void TestStep_06_VerifyPerformanceScoresRed(){
    
        Assert.assertTrue(test.DashBoardPage.verifyPerformanceScoresRed(),"color is not red");
        ReportMsg.log("Successfully Verify that user is able to see ‘Performance scores’ dot as Red if score is 69% and below.");
    }
    
    /*
    /Verify that user should see dots for 10 latest submitted activities.
    */
    
    @Test
    public void TestStep_07_VerifyDotLength(){
    
        Assert.assertTrue(test.DashBoardPage.verifyDotLength(),"last total activity are not 10");
        ReportMsg.log("Successfully Verify that user is able to see ‘Performance scores’ dot as Red if score is 69% and below.");
    }
    
    /*
    /Verify that user is able to see Gray color Dot in Performance Graph for Manual gradable activity
    */
    
    @Test
    public void TestStep_08_VerifyGrayDotOnPerfomanceGraph(){
        test.DashBoardPage.verifyGrayDot();
        ReportMsg.log("Successfully Verify that user is able to see Gray color Dot in Performance Graph for Manual gradable activity");
    }
    
    /*
    /Verify that user is able to see a pop-up which includes below information on hovering the mouse on dot.
    /Activity Score
    /Number of Attempts
    /Time to Complete
    /Submission status(Submitted/Auto-submitted)
    */
    
    @Test
    public void TestStep_9_VerifyPopUpInformation(){
      
        test.DashBoardPage.verifyPopUpInformation();
        ReportMsg.log("Successfully Verify that user is able to see a pop-up which includes information on hovering the mouse on dot");
    }
    
    
    /*User Logout 
    */
   //@Test
    public void TestStep_10_Logout() {
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
