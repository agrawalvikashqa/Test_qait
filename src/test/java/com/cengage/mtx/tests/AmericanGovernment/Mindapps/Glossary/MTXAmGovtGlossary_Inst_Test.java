/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.AmericanGovernment.Mindapps.Glossary;


import com.cengage.mindtap.tests.Mindapps.GlossaryScenarios.*;
import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
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
public class MTXAmGovtGlossary_Inst_Test {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

    @BeforeClass
    public void start_test_session() {
       // Reporter.log("Wiki LInk:-  http://wiki.cengage.com/display/NG/Glossary+app+Regression+Master ",true);
        test = new TestSessionInitiator("glossary Apps Check Test");
        user = System.getProperty("user", "instructor");

    }

     @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAmGovt.CourseKey"),getData("Books.courseAmGovt.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    /*This test case covers:
     *Verifying of Glossary App
     **/
    @Test
    public void TestStep_02_LaunchAppFromAppDock() {
        //test.DashBoardPage.clickOnAllApps();
        test.DashBoardPage.clickOnAppByName("Glossary");
        Reporter.log(user+"  successfully Launch Glossary App From App Dock",true);
    }
    
    @Test
    public void TestStep_03_lettersAToZDisplayedAtTopForSelection() {
        test.FramesPage.switchToDockIFrame();
         Assert.assertTrue(test.glossaryPage.verifylettersAToZDisplayedAtTopForSelection());
        Reporter.log(user+"  successfully Verify letters A To Z Displayed At Top For Selection ",true);
    }
    
    @Test
    public void TestStep_04_AllGlossarytTermsDisplayedInAlphabeticOrder() {
         Assert.assertTrue(test.glossaryPage.verifyAllGlossaryTermsDisplayedInAlphabeticOrder());
        Reporter.log(user+"  successfully Verify All Glossary Terms Displayed In Alphabetic Order",true);
    }
    @Test
    public void TestStep_05_topOfPageDisplaysCorrectKeyTermcounter() {
         Assert.assertTrue(test.glossaryPage.verifytopOfPageDisplaysCorrectKeyTermcounter());
        Reporter.log(user+"  successfully top Of Page Displays Correct Key Term counter",true);
    }
    
    @Test
    public void TestStep_06_allTermsDisplayedAsPerAlphabetSelection() {

        Assert.assertTrue(test.glossaryPage.allTermsDisplayedAsPerAlphabetSelection());
        Reporter.log(user+"successfully Verify that all terms are displayed as per Alphabet selection made",true);
    }            
    
    @Test
    public void TestStep_07_AlphabetWithNoTermsAreNonClickable() {

        Assert.assertTrue(test.glossaryPage.alphabetWithNoTermsAreNonClickable());
        Reporter.log(user+"successfully Verify that Alphabet With No Terms Are Non Clickable",true);
    }
    
    @Test
    public void TestStep_08_AlphabetWithNoTermsAppearsGrayedOut() {
    
        Assert.assertTrue(test.glossaryPage.AlphabetWithNoTermsAppearsGrayedOut());
        Reporter.log(user+"successfully Verify that Alphabet With No Terms Are Appears Grayed Out",true);
    }
    
    @Test
    public void TestStep_09_ClickAnyAlphabetRememberingLastSelectionCheck() {
        test.glossaryPage.ClickAnyAlphabet("C");
        test.DashBoardPage.closeOpenApp();
        test.DashBoardPage.LaunchAppFromAppDock("Search");
        test.DashBoardPage.closeOpenApp();
        test.DashBoardPage.clickOnAppByName("Glossary");
        test.FramesPage.switchToDockIFrame();
        Assert.assertTrue(test.glossaryPage.verifyClickAnyAlphabetRememberingLastSelectionCheck("C"));
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
