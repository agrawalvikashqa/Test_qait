/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.History.Apps.SearchApp;


import com.cengage.mtx.tests.Chemistry.Apps.SearchApp.*;
import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

import static com.qait.automation.utils.YamlReader.getData;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

/**
 *
 * 
 * @author QAI
 */
public class TC01_HistoryInstructorSearchAppTest {
    
    TestSessionInitiator test;
    
    
    String user;
    String historySearchTerm = getData("Books.HistorySearchApp.historySearchKeyterm");
    String googleDocSearch = getData("Books.chemSearchApp.GoogleDoc");
    String KalturaSearch = getData("Books.chemSearchApp.Kaltura");
    String RSSFeed = getData("Books.chemSearchApp.RSSFeed");
    String WebLink = getData("Books.chemSearchApp.WebLink");
    String WebVideo = getData("Books.chemSearchApp.WebVideo");

    @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("History Search App Test");
        user = System.getProperty("user", "instructor");
        
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseHistory.courseKey"),getData("Books.courseHistory.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    @Test
    void TestStep_02_searchForBodyText(){
        test.MTXSearchPage.verifySearchApp();
        test.MTXSearchPage.selectSearchByTerm(historySearchTerm);
        test.DashBoardPage.closeOpenApp();
        Reporter.log ("Completed search For Body Text",true);
    } 
   
    @Test
    void TestStep_03_searchForGoogleDoc(){
        test.MTXSearchPage.launchSearchApp();
        test.MTXSearchPage.selectSearchByTerm(googleDocSearch);
        test.DashBoardPage.closeOpenApp();
        Reporter.log ("Completed search For GoogleDoc",true);
    } 
    
    @Test
    void TestStep_04_searchForKaltura(){
        test.MTXSearchPage.verifySearchApp();
        test.MTXSearchPage.selectSearchByTerm(KalturaSearch);
        test.DashBoardPage.closeOpenApp();
        Reporter.log ("Completed search For Kaltura",true);
    } 
    
    @Test
    void TestStep_05_searchForRSSFeed(){
        test.MTXSearchPage.verifySearchApp();
        test.MTXSearchPage.selectSearchByTerm(RSSFeed);
        test.DashBoardPage.closeOpenApp();
        Reporter.log ("Completed search For RSS Feed",true);
    } 
    
    @Test
    void TestStep_06_searchForWebLink(){
        test.MTXSearchPage.verifySearchApp();
        test.MTXSearchPage.selectSearchByTerm(WebLink);
        test.DashBoardPage.closeOpenApp();
        Reporter.log ("Completed search For Web Link",true);
    } 
    
    @Test
    void TestStep_07_searchForWebVideo(){
        test.MTXSearchPage.verifySearchApp();
        test.MTXSearchPage.selectSearchByTerm(WebVideo);
        test.DashBoardPage.closeOpenApp();
        Reporter.log ("Completed search For Web Link",true);
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
