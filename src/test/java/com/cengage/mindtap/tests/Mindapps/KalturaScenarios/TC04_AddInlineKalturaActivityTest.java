/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.KalturaScenarios;


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
public class TC04_AddInlineKalturaActivityTest {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    String activityName = getData("Books.courseWebLink.name");
    
    
    @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32749", true);
        test = new TestSessionInitiator("Kaltura App check Test");
        user = System.getProperty("user", "instructor");
    }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    @Test
    public void TestStep_02_launchReadingActivuty() {
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("Books.courseKaltura.unitName"), getData("Books.courseKaltura.chapterName"));
    
    }
    
    @Test
    public void TestStep_03_addInlineActivityInChapter() {
        test.FramesPage.switchToMainFrame();
        test.readingPage.clickOnEditModeAndAddIconLiknsAndNavigateToChapterIntroductionPage();
        test.FramesPage.switchToDefaultContent();
        test.kalturaAppPage.addDistinctKalturaActivity("Distinct Kaltura Activity");
        test.FramesPage.switchToDefaultContent();
        Reporter.log("Successfully add Kaltura inline activity " + "\n" ,true);      
        
    }
    
    @Test
    public void TestStep_04_VerifyaddedInlineActivity() {
    
        Assert.assertTrue(test.DashBoardPage.verifyInlineActivityByDescription("Inline Kaltura Activity"));
        Reporter.log("Successfully verify that Kaltura inline activity is present" + "\n" ,true);      
    }
    
    //@Test
    public void TestStep_05_editInlineKalturaActivity(){
        test.kalturaAppPage.editInlineKalturaActivity(getData("learningActivities.Kaltura.inlineTitle"));
        Reporter.log("Instructor Successfully edit Kaltura Inline Activity" + "\n" ,true);      
    }
    
    @Test
    public void TestStep_06_DeleteInlineKalturaActivity(){
        test.kalturaAppPage.deleteInlineKalturaActivity();
        Reporter.log("Successfully Deleted Kaltura Inline Activity" + "\n" ,true);      
    }
     
    
    @Test
    void TestStep_07_logOut(){
        test.DashBoardPage.Logout(); 
        Reporter.log("Completed logOut",true);
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
