/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.Chemistry.Mindapps.RssFeed;


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
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseChemistry.courseKey"),getData("Books.courseChemistry.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    /*This test case covers:
     *Verifying of Rss Feed App
     **/
   @Test
    public void TestStep_03_LaunchAppFromAppDock() {
        test.DashBoardPage.clickOnAppByName("RSS Feed");
        Reporter.log(user + "  successfully Launch RssFeed App From App Dock", true);
    }

    @Test
    public void TestStep_04_addRssFeed() {
        test.FramesPage.switchToDockIFrame();
        test.RSSFeedPage.addRssFeedAppDock();
        test.RSSFeedPage.addRssFeedLPN(url, filename);
        Reporter.log(user + "  successfully Verify Add RSS Feed ", true);
        test.RSSFeedPage.VerifyRssFeedAppDock(filename);
        test.RSSFeedPage.deleteRssFeedAppDock(filename);
        test.DashBoardPage.closeOpenApp();
        
    }

    @Test
    public void TestStep_05_clickOnAddActivityIcon() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    }
    

   @Test
    public void TestStep_06_AddRSSActivityToLPN() {
        test.DashBoardPage.clickOnActivity("RSS Feed");
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.RSSFeedPage.addRssFeedLPN(url, filename);
        test.RSSFeedPage.AddDistinctRssActivity();

    }

    @Test
    public void TestStep_07_VerifyAddedRssActivityToLPN() {
        test.DashBoardPage.clickOnView("Unit View");
        test.RSSFeedPage.AddedRssActivity(filename);
       }

    @Test
    public void TestStep_08_DeleteAddedRssActivityToLPN() {
       test.RSSFeedPage.DeleteAddedRssActivity(filename);
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
