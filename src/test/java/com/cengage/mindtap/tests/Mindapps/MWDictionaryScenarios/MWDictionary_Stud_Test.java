/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.MWDictionaryScenarios;

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
public class MWDictionary_Stud_Test {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Launch MerriamWebster's Dictionary App Dock Test(NG-32688 : https://jira.cengage.com/browse/NG-32688)");
        user = System.getProperty("user", "student");
    }

      @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    /*Merriam-Webster's Dictionary Verification
    */
   @Test
    public void TestStep_02_verifyLaunchDictionaryApp() {
        //test.DashBoardPage.clickOnAllApps();
        test.DashBoardPage.clickOnAppByName("Merriam-Webster's Dictionary");
        Reporter.log(user+"  successfully Verified Merriam-Webster's Dictionary Launch",true);
    }
    /* Verification of Word Present In Dictionary
    */
   @Test
    public void TestStep_03_verifyWordPresentInDictionary() {
        test.FramesPage.switchToDockIFrame();
        test.merriamWebsterDictionaryPage.searchInDictionary("Testing");
        Assert.assertTrue(test.merriamWebsterDictionaryPage.verifyWordPresentInDictionary("Testing"));
        Reporter.log(user+"  successfully verified Word is Present In the Dictionary",true);
    }
    /* Verification of Word Not Present In Dictionary
    */
   @Test
    public void TestStep_04_verifyWordNotPresentInDictionary() {
        test.merriamWebsterDictionaryPage.searchInDictionary("Mindtap");
        Assert.assertTrue(test.merriamWebsterDictionaryPage.verifyWordNotPresentInDictionary("Mindtap"));
        test.DashBoardPage.closeOpenApp();
        Reporter.log(user+"  successfully verified Word is Present In the Dictionary",true);
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
