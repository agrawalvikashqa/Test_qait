/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.YouSeeUScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import junit.framework.Assert;
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
public class TC01_InstAndAddDistinctYSUActivityTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Instructor Add Distinct YSU Activity Test(NG-32688 : https://jira.cengage.com/browse/ NG-32788)");
        user = System.getProperty("user", "instructor");
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
 
    @Test
    public void TestStep_02_verifyLaunchYouSeeUApp() {
        test.DashBoardPage.clickOnAllApps();
        test.DashBoardPage.clickOnAppByName("YouSeeU (QA-A)");
        Reporter.log(user+"  successfully Verified Merriam-Webster's Dictionary Launch",true);
    }
    /**
     * YouSeeU (QA-A) Verification
    */
     @Test
    void TestStep_03_addDistinctYouSeeUAppActivity(){
        test.youSeeUPage.addYouSeeUAppActivityInApp(getData("learningActivities.YouSeeU.activity"),getData("learningActivities.YouSeeU.name"),getData("learningActivities.YouSeeU.type"),getData("learningActivities.YouSeeU.instruction"),getData("learningActivities.YouSeeU.gradingType"));
        test.DashBoardPage.closeOpenApp();
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
        test.DashBoardPage.selectActivityToAdd(getData("learningActivities.YouSeeU.activity"));
        test.youSeeUPage.addDistinctYouSeeUActivityInDashboard(getData("learningActivities.YouSeeU.activity"),getData("learningActivities.YouSeeU.name"),getData("learningActivities.YouSeeU.type"),getData("learningActivities.YouSeeU.instruction"),getData("learningActivities.YouSeeU.gradingType"));
        Reporter.log ("Completed add Distinct YouSeeU App Activity",true);
    }
    
    /*This test case covers:
     *Verify the activity was added
     **/
    @Test
    void TestStep_04_verifyDistinctYouSeeUActivityAdded(){
        Assert.assertTrue(test.youSeeUPage.verifyPresenceOfDistinctYouSeeUActivityOnLPN(getData("learningActivities.YouSeeU.activity")));
        Reporter.log ("Completed verify Distinct You See U Activity Added Test" + "\n" ,true);  
    }
    
    /*This test case covers:
     * Refreshing the page and
     * Launching Distinct Web Link Activity
     * Logging Out
     **/
    @Test
    void TestStep_05_launchDistinctYouSeeUActivity(){
        test.youSeeUPage.launchDistinctYouSeeUActivity(getData("learningActivities.YouSeeU.activity"));
        Reporter.log ("Completed launch Distinct YouSeeU Activity" + "\n" ,true);
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
