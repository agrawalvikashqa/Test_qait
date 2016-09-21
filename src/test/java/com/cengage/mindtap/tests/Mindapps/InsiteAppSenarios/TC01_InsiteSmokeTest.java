/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.InsiteAppSenarios;

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
    public class TC01_InsiteSmokeTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user, bookName;

     @BeforeClass
     public void start_test_session() {
        test = new TestSessionInitiator("Create And Launch Master Next Book And Verify LPN");
        user = System.getProperty("user", "instructor");
        
    }
    
     String insiteActivityName = getData("learningActivities.insite.assignment_Name");
     String insiteDesc = getData("learningActivities.insite.assignment_Desc");
     String gradedRadio = getData("learningActivities.insite.gradedRadio");
     String practiceRadio = getData("learningActivities.insite.practiceRadio");
     String possibleScore = getData("learningActivities.insite.possibleScore");
     String submission_Text = getData("learningActivities.insite.submissionText");
     String inst_grades = getData("learningActivities.insite.instGrades");
     String validationFail_assName = getData("learningActivities.insite.validationFail_assName");
     String validationFail_possibleScore = getData("learningActivities.insite.validationFail_possibleScore");
     
    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseInsite.courseKey"),getData("Books.courseInsite.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
       
     @Test
    public void TestStep_02_InstructorAddDistinctInsiteActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
        test.DashBoardPage.clickOnActivity("InSite2 Writing Activity");
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.InsiteAppPage.enterAssignmentName(validationFail_assName);
        test.InsiteAppPage.enterAssignmentDesc(insiteDesc);
        test.InsiteAppPage.validateError();
        test.InsiteAppPage.enterAssignmentName(insiteActivityName);
        test.InsiteAppPage.enterAssignmentDesc(insiteDesc);
        test.InsiteAppPage.selectGradingType(practiceRadio);
        test.InsiteAppPage.enterPossibleScore(validationFail_possibleScore);
        test.InsiteAppPage.invalidPossibleScore();
        test.InsiteAppPage.enterPossibleScore(possibleScore);
        test.InsiteAppPage.clickOnSubmitButton();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.selectOrder("1");
        test.InsiteAppPage.clickOnActivitySaveButton();
        Reporter.log(user+"successfully Instructor Add Distinct Insite Activity",true);        
    }
    
    @Test
    public void TestStep_04_StudentLaunchDistinctInsiteActivityPerformCopyPaste() {
    user = System.getProperty("user", "student");
    test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseInsite.courseKey"),getData("Books.courseInsite.ISBN"));
    Reporter.log(user+"successfully logs in to the application",true); 
    test.DashBoardPage.clickOnView("Unit View");
    test.DashBoardPage.launchDistinctActivity(insiteActivityName);
    test.FramesPage.switchToMainFrame();
    test.InsiteAppPage.clickOnUploadIcon();
    test.InsiteAppPage.clickOnCopyPasteButton();
    test.InsiteAppPage.enterSubmissionTitle();
    test.InsiteAppPage.enterSubmissionText();
    test.InsiteAppPage.clickSubmissionContinueButton();
    test.InsiteAppPage.clickOnAcceptSubmissionButton();
    test.DashBoardPage.Logout();
    Reporter.log(user+"successfully Student Launch Distinct Insite Activity Perform Copy Paste",true);  
    }
    
    //@Test
    public void TestStep_05_StudentLaunchDistinctInsiteActivityPerformGoogleDrive() {
    user = System.getProperty("user", "student");
    test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseInsite.courseKey"),getData("Books.courseInsite.ISBN"));
    test.DashBoardPage.clickOnView("Unit View");
    test.DashBoardPage.launchDistinctActivity(insiteActivityName);
    test.FramesPage.switchToMainFrame();
    test.InsiteAppPage.clickOnUploadIcon();
    test.InsiteAppPage.clickOnGoogleDrive();
    test.GoogleDriveAppPage.signInGoogleDrive(getData("learningActivities.GoogleDoc.gmailID"),getData("learningActivities.GoogleDoc.paswrd"));
    test.DashBoardPage.Logout();
    }
    

    //@Test


    public void TestStep_06_LoginToSSOApplication() {
       // test = new TestSessionInitiator("Create And Launch Master Next Book And Verify LPN");
        user = System.getProperty("user", "instructor");
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseInsite.courseKey"),getData("Books.courseInsite.ISBN"));
            Reporter.log(user+"successfully logs in to the application",true); 
}
    
    //@Test
    public void TestStep_07_InstructorGradeInsiteActivity() {
    test.DashBoardPage.clickOnView("Unit View");
    // test.InsiteAppPage.launchAddedActivity(insiteActivityName);
    test.DashBoardPage.launchDistinctActivity(insiteActivityName);
    test.FramesPage.switchToMainFrame();
    test.InsiteAppPage.instructorClickOnGradeIcon();
    test.FramesPage.switchToDefaultContent();
    test.InsiteAppPage.instructorEnterGrades(inst_grades);
   // test.InsiteAppPage.uploadFile();
}

  //  @Test
    public void TestStep_08_AddPeerMarkAssignmentDistinctActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
        test.InsiteAppPage.clickOnInsiteApp();
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.InsiteAppPage.PeermarkAssignmentRadioButton();
        test.InsiteAppPage.createDistinctPeerAssignment();
        test.FramesPage.switchToDefaultContent();
        test.InsiteAppPage.clickOnSaveButton();
        
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
