package com.cengage.mtx.tests.AmericanGovernment.Mindapps.PollingApp;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

public class MTXAmGovtPollingApp_Inst_Test {

    TestSessionInitiator test;
    String user;
    String StudycenterTitle = "StudyCenter";
    String FlashcardTitle = "FlashCard";
    String FullbookTitle = "Reader";
    String GlossaryTitle = "Glossary";
    String DictionaryTitle = "Merriam-Webster";
    String ProgressTitle = "Progress";
    String MessageTitle = "MessageCenter";
    String PollingTitle = "Polling";

    @BeforeClass
    public void start_test_session() {
        Reporter.log("**************************************************** ", true);
        Reporter.log("**** MTX American Government Smoke Test Started***  ", true);
        Reporter.log("**************************************************** ", true);
        test = new TestSessionInitiator("AmGovt Smoke Test");
        user = System.getProperty("user", "instructor");
    }

    /**
     * TC001_login to Mindtap by fetching token from SSO
     */
    @Test
    public void TestStep_01_LoginToSSOApplication() {
        Reporter.log("TC_01 : Verify Instructor Logs into Mindtap Application", true);
        test.launchApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")), getData("Books.courseAmGovt.CourseKey"), getData("Books.courseAmGovt.ISBN"));
        Reporter.log(user + "successfully logs in to the application", true);
    }
    @Test
    public void TestStep_02_CreatePollAndVerifyDeleteButton() {
        Reporter.log("Test_02 : Create Poll And Verify Delete Button Should Be Functional  ", true);
        test.DashBoardPage.clickOnAppByName("Polling");
        test.MTXFramePage.switchToDockIFrame(PollingTitle);
        test.MTXGovPolling.clickOnUnitPlusButton();
        test.MTXGovPolling.clickOnCreateNewPoll();
        test.MTXGovPolling.fillEntriesForCreatingPoll();
        test.MTXGovPolling.clickOnSaveAndCloseButton();
        test.MTXGovPolling.verifyAndClickDeleteButton();
        Reporter.log(user + "successfully created and Deleted Poll", true);
    }
    @Test
    public void TestStep_03_CreatePoll() {
        Reporter.log("Test_03 : Create Poll  ", true);
        test.MTXFramePage.switchToDockIFrame(PollingTitle);
        test.MTXGovPolling.clickOnCreateNewPoll();
        test.MTXGovPolling.fillEntriesForCreatingPoll();
        test.MTXGovPolling.clickOnSaveAndCloseButton();
        Reporter.log(user + "successfully created Poll", true);
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
