/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.SearchScenarios;


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
public class TC01_SearchAppTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    
    String user;

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Search App Test");
        user = System.getProperty("user", "instructor");
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    /*This test case covers:
     *Verifying of Search App
     *Selecting The Search Term
     *Verifying Highlighted Text.
     **/
    @Test
    void TestStep_02_searchForBodyText(){
        test.searchPage.verifySearchApp();
        test.searchPage.selectSearchByTerm("Principles");
        test.DashBoardPage.closeOpenApp();
        Assert.assertTrue(test.searchPage.verifyTextHighlighted("Principles"),"Search term not highlighted");
        Reporter.log ("Completed search For Body Text",true);
    } 
    /** Blocked NG-32647 - (QAD and Staging specific) Search |
     *  Unable to search 'User created Highlights/Quicknotes' via search app
     *  Code Will be Written ones the BUG is fixes
     */
   
    //@Test
    public void TestStep_03_verifyReaderSearchResultsareClickable() {
        test.searchPage.verifyReaderSearchResultsareClickable();
        Reporter.log(user+" successfully verify Reader Search Results are Clickable",true);
    }
    @Test
    public void TestStep_04_verifySearchByPageNumber() {
        test.DashBoardPage.refreshPage();
        test.searchPage.verifySearchApp();
        test.searchPage.searchByPageNo("497");
        Assert.assertTrue(test.searchPage.verifySearchByPageNumber());
        Reporter.log(user+" successfully verify Search By Page Number",true);
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
