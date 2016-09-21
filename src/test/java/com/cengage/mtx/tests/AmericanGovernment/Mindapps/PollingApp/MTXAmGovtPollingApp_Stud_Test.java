package com.cengage.mtx.tests.AmericanGovernment.Mindapps.PollingApp;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import static com.qait.automation.utils.YamlReader.getData;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MTXAmGovtPollingApp_Stud_Test {

    TestSessionInitiator test;
    String user;
    String RssTitle = "Rssfeed";
    String StudycenterTitle = "StudyCenter";
    String FlashcardTitle = "FlashCard";
    String FullbookTitle = "Reader";
    String GlossaryTitle = "Glossary";
    String DictionaryTitle = "Merriam-Webster";
    String ProgressTitle = "Progress";
    String MessageTitle = "MessageCenter";
    String PollingTitle = "Polling";

    /**
     * Sets the up class.
     */
    @BeforeClass
    public void start_test_session() {
        System.out.println("\n###########################################################################################");
        System.out.println("################ MTX American Government Student WorkFlow #############");
        System.out.println("###########################################################################################\n\n");
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("AmGovt Smoke Test");
        user = System.getProperty("user", "student");
    }

    /**
     * TC001_login to mindtap by fetching token from sso
     */
    @Test
    public void TestStep_01_LoginToSSOApplication() {
        Reporter.log("TC_01 : Verify Student logs in to the application", true);
        test.launchApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")), getData("Books.courseAmGovt.CourseKey"), getData("Books.courseAmGovt.ISBN"));
        Reporter.log(user + "successfully logs in to the application", true);
    }

    @Test
    public void TestStep_02_VerifyAndVotePolling() {
        Reporter.log("Test_02 : Verify And Vote Polling", true);
        test.DashBoardPage.clickOnAppByName("Polling");
        test.MTXFramePage.switchToDockIFrame(PollingTitle);
        test.MTXGovPolling.verifyAndClickPollFromStudent();
        test.MTXGovPolling.verifyQuestionOfPollFromStudent();
        test.MTXGovPolling.verifyAllResponses();
        test.MTXGovPolling.clickOnVoteButton();
    }

    @AfterClass(alwaysRun = true)
    public void stop_test_session() {
        test.closeTestSession();
    }

    @BeforeMethod
    public void beforeEachTest() {
        Reporter.log("\n\n *********************************************************************** ", true);

    }

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
}
