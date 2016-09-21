/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.YouSeeUScenarios;

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
public class TC02_InstAndAddDeleteRubricsInYSUTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Instructor And Add Delete Rubrics In YSU Test(NG-32688 : https://jira.cengage.com/browse/ NG-32788)");
        user = System.getProperty("user", "instructor");
       
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    /* YouSeeU (QA-A) Verification
    */
   @Test
    public void TestStep_02_verifyLaunchDictionaryApp() {
        
        System.err.println(getData("learningActivities.YouSeeU.Appname"));
        test.DashBoardPage.clickOnAppByName(getData("learningActivities.YouSeeU.Appname"));
        Reporter.log(user+"  successfully Verified YouSeeU Launch",true);
    }
    /* Verification add Distinct Rubrics In YSU
    */
   
  @Test
    void TestStep_03_addDistinctRubricsInYSU(){
        test.FramesPage.switchToDockIFrame();
        test.youSeeUPage.addDistinctRubricsInYSU(getData("learningActivities.YouSeeU.rubrics"));
        Reporter.log("Completed add Distinct Rubrics  Activity",true);
    }
  /* Verification Edit Distinct Rubrics In YSU
    */
    
   @Test
   void TestStep_04_editRubricsInYSU(){
       test.youSeeUPage.editRubricsInYSU(getData("learningActivities.YouSeeU.rubrics"));
        Reporter.log ("Completed editing Distinct Rubrics Added Test" + "\n" ,true);  
    }
    /* Verification Delete Distinct Rubrics In YSU
    */
    @Test
    void TestStep_05_deleteDistinctRubricsActivity(){
        test.youSeeUPage.deleteDistinctRubricsActivity(getData("learningActivities.YouSeeU.rubrics"));
        Reporter.log("Completed delete Distinct Rubrics Activity" + "\n" ,true);      
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
