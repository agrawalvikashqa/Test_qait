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
public class TC02_StudentVerifyDistinctAndInlineInsiteActivity {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Insite App");
        user = System.getProperty("user", "student");
        test.launchApplication(getData("sso_url"));
    }

     @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseInsite.courseKey"),getData("Books.courseInsite.ISBN"));
        Reporter.log(user+"logging in to the application",true); 
    }
    /*This test case covers:
     *Verifying of Google Drive App 
     **/
    
    
    
    @Test
    public void TestStep_03_studentVerifyDistinctPaperAssignmentInsiteActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.launchDistinctActivity(getData("learningActivities.insite.assignment_Name"));
        test.FramesPage.switchToMainFrame();
        test.InsiteAppPage.PaperAssignmentLaunchVerify();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.closeLaunchedActivity("Paper Assignment Insite Activity");
        Reporter.log ("Completed Student launch Distinct Paper Assignment Insite Activity Test" + "\n" ,true);          
    
    }
    
    @Test
    public void TestStep_04_studentVerifyPeermarkAssignmentDistinctInsiteActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.launchDistinctActivity(getData("learningActivities.insite.Peer_Ass_Name"));
        test.FramesPage.switchToMainFrame();
        test.InsiteAppPage.PeermarkDisagreeAgreement();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.launchDistinctActivity(getData("learningActivities.insite.Peer_Ass_Name"));
        test.FramesPage.switchToMainFrame();
        test.InsiteAppPage.PeermarkAgreeAgreementandVerifyLaunch();
        
        Reporter.log ("Completed Student launch Distinct Peermark Assignment Insite Activity Test" + "\n" ,true);          
    
    }
    
    
   
    
    
    
    
}
