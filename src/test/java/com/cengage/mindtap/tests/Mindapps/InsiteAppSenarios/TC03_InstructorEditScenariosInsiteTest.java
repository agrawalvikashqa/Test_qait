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
    public class TC03_InstructorEditScenariosInsiteTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user, bookName;
    String text = getData("Books.courseInsite.text");
    String AssignmentName = getData("Books.courseInsite.AssignmentName");
    String AssignmentDescription = getData("Books.courseInsite.AssignmentDescription");
    String PossibleScore = getData("Books.courseInsite.PossibleScore");
    
    
     @BeforeClass
     public void start_test_session() {
        test = new TestSessionInitiator("Create And Launch Master Next Book And Verify LPN");
        user = System.getProperty("user", "instructor");
        
        
    }
    
     String insiteActivityName = getData("learningActivities.insite.assignment_Name");

     @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseInsite.courseKey"),getData("Books.courseInsite.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    
    //@Test
    public void TestStep_02_InstructorEditPaperAssignmentFromLPN() {
    test.DashBoardPage.clickOnView("Unit View");
    test.DashBoardPage.editDistinctActivity(insiteActivityName);
    test.InsiteAppPage.EditPaperAssignmentFromLPN(AssignmentName,AssignmentDescription,PossibleScore);
    
    }
    
    //@Test
    public void TestStep_03_InstructorDeleteInsiteActivity() {
    //test.DashBoardPage.clickOnView("Unit View");
    test.DashBoardPage.deleteDistinctActivity(insiteActivityName);
    }
    
    
    
    
    //@Test
    public void TestStep_03_() {
    
    
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
