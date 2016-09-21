/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.AmericanGovernment.Mindapps.RssFeed;



import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;
import static java.lang.Math.random;

public class TC01_RssFeedAppTest {

    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String url = "http://rss.cnn.com/rss/edition_africa.rss";
    String filename ;
    String Reader = "Chapter 7: Consumers, Producers, and the Efficiency of Markets";
    String user;

    @BeforeClass
    public void start_test_session() {
        // Reporter.log("Wiki LInk:-  http://wiki.cengage.com/display/NG/RSS+Feed+Regression+Master ",true);
        test = new TestSessionInitiator("RssFeed Apps Check Test");
         filename = "RSSFeed_" + test.flashcardpage.appendTimeStamp()+random();
         System.err.println(filename);
        user = System.getProperty("user", "instructor");
        }
 
    
    
    
    @Test
    public void TestStep_01_LoginToSSOApplication() {
        Reporter.log("Test_01 : Verify Instructor logs into Mindtap Application",true);
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAmGovt.searchCourseKey"),getData("Books.courseAmGovt.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    /*This test case covers:
     *Verifying of Rss Feed App
     **/
   @Test
    public void TestStep_02_LaunchAppFromAppDock() {
        Reporter.log("Test_02 : Verify Instructor Launch App From AppDock",true);
        test.DashBoardPage.clickOnAppByName("RSS Feed");
        Reporter.log(user + "  successfully Launch App From AppDock", true);
    }

    @Test
    public void TestStep_03_addRssFeed() {
        Reporter.log("Test_03 : Verify Instructor add Rss Feed",true);
        test.FramesPage.switchToDockIFrame();
        test.RSSFeedPage.addRssFeedAppDock();
        test.RSSFeedPage.addRssFeedLPN(url, filename);
        Reporter.log(user + "  successfully Verify Add RSS Feed ", true);
        test.RSSFeedPage.VerifyRssFeedAppDock(filename);
        test.RSSFeedPage.deleteRssFeedAppDock(filename);
        test.DashBoardPage.closeOpenApp();
        
    }

    @Test
    public void TestStep_04_clickOnAddActivityIcon() {
        Reporter.log("Test_04 : Verify Instructor click On Add Activity Icon",true);
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
        Reporter.log(user+"successfully click On Add Activity Icon",true); 
    }
    

   @Test
    public void TestStep_05_AddRSSActivityToLPN() {
        Reporter.log("Test_01 : Verify Instructor Add RSS Activity To LPN",true);
        test.DashBoardPage.clickOnActivity("RSS Feed");
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.RSSFeedPage.addRssFeedLPN(url, filename);
        test.RSSFeedPage.AddDistinctRssActivity();
        Reporter.log(user+"successfully Add RSS Activity To LPN",true); 
    }

    @Test
    public void TestStep_06_VerifyAddedRssActivityToLPN() {
        Reporter.log("Test_06 : Verify Instructor Added Rss Activity To LPN",true);
        test.DashBoardPage.clickOnView("Unit View");
        test.RSSFeedPage.AddedRssActivity(filename);
        Reporter.log(user+"successfully logs in to the application",true); 
       }

    @Test
    public void TestStep_07_DeleteAddedRssActivityToLPN() {
        Reporter.log("Test_01 : Verify Instructor Delete Added Rss Activity To LPN",true);
       test.RSSFeedPage.DeleteAddedRssActivity(filename);
       Reporter.log(user+"successfully Delete Added Rss Activity To LPN",true); 
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
