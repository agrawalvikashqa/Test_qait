/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.InsiteAppSenarios;

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
public class TC02_InsiteInstructorRegressionTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user, bookName;

     @BeforeClass
     public void start_test_session() {
        test = new TestSessionInitiator("Create And Launch Master Next Book And Verify LPN");
        user = System.getProperty("user", "instructor");
        
    }
    
     String insiteActivityName = getData("learningActivities.insite.assignment_Name");
     String no_value = "0";
     String yes_value = "1";
     
     @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseInsite.courseKey"),getData("Books.courseInsite.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
       
    
   
   
     @Test
    public void TestStep_02_InstructorEditsOptionalSettings() {
        
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.launchDistinctActivity(insiteActivityName);
        test.FramesPage.switchToMainFrame();
        test.InsiteAppPage.clickOnSettingsTab();
        test.InsiteAppPage.clickOnOptionalSettingsLink();
        test.InsiteAppPage.clickOnLateSubmissionNoRadioButton();
        test.InsiteAppPage.clickOnLateSubmissionYesRadioButton();
        test.InsiteAppPage.clickOnComapreSubmitAssignmentCheckbox();
        test.InsiteAppPage.viewOriginalityReport_Checkbox(no_value);
        test.InsiteAppPage.viewOriginalityReport_Checkbox(yes_value);
        test.InsiteAppPage.peermark_Checkbox(no_value);
        test.InsiteAppPage.peermark_Checkbox(yes_value);
        test.InsiteAppPage.rubricAssignment();
      //  test.InsiteAppPage.addRubricAssignment();
        test.InsiteAppPage.clickOnSubmitButton();
        
        
    }
    
}
