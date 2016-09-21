package com.cengage.mtx.tests.Chemistry.SmokeTest;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import static com.qait.automation.utils.YamlReader.getData;

public class TC01_InstructorFlowSmokeTestChemistry { 

	/** The test. */
	TestSessionInitiator test;
        String user;

	/**
	 * Sets the up class.
	 */
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Smoke Test");
        user = System.getProperty("user", "instructor");
        
    }

	/**
	 * TC001_login to the sso front door.
	 */
	@Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseChemistry.courseKey"),getData("Books.courseChemistry.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }


	/**
	 * TC003_verify user redirect to student dashboard display.
	 */
	@Test
	public void TestStep_02_verfiyDashboardView() {
		Reporter.log("Test Name: verfiyDashboardView",true);
		test.weekwidgetPage.verifyDashboardView();
	}

	@Test
	public void TestStep_03_verfiyWeekWidgetView() {
		Reporter.log("Test Name: verfiyWeekWidgetView",true);
		test.weekwidgetPage.elementsAvailableforWeekViewWidgetPage();
		test.weekwidgetPage.navigateToWeek("Week 44");
		test.weekwidgetPage.piIconWithAllActivities();
	}

	@Test
	public void TestStep_04_verifyNotificationWidgetView() {
		Reporter.log("Test Name: verifyNotificationWidgetView",true);
		test.weekwidgetPage.verifyNotificationWidgetView();
	}
        

	@Test
	public void TestStep_05_verifyCurrentCourseWidgetView() {
		Reporter.log("Test Name: verifyCurrentCourseWidgetView",true);
		test.weekwidgetPage.verifyCurrentCourseScoreWidgetView();
	}

	@Test
	public void TestStep_06_verifyUiOfMessageCenterApp() {
		Reporter.log("Test Name:verifyUiOfMessageCenterApp",true);
		//test.weekwidgetPage.clickOnAllApps();
		test.MTXDashBoardPage.clickOnAppByName("Message Center");
		test.NotificationCenterPage.getTitleOfApp();
		test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.MessageTitle"));
		test.NotificationCenterPage.textBoxToTypeMessageIsPresent();
		test.NotificationCenterPage.viewMoreLinkIsPresent();
		test.NotificationCenterPage.sendMessageToIndividualStudentIsPresent();
		test.NotificationCenterPage.getListOfMessagesWithDateAndTime();
		test.NotificationCenterPage.refreshButtonIsPresent();
		test.NotificationCenterPage.settingButtonIsPresent();
		test.NotificationCenterPage.urgentButtonIsPresent();
		//test.NotificationCenterPage.clickOnSettingIconAndVerifyUI(getData("users.instructor.username"));
                test.MTXDashBoardPage.closeOpenApp();
	}

	/**
	 * TC007_verify presence of submit link for tutored activity.
	 */
	@Test
	public void TestStep_07_verifyInstructorTutoredActivity() {
		// Tutored Activity
		Reporter.log("Test Name: verifyInstructorTutoredActivity",true);
		test.weekwidgetPage.navigateToWeek("Week 44");
		test.MTXActivityPage.clickOnTutoredActivity(getData("Books.courseChemistry.activityTutored"));
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.verifySubmitLinkIsPresent();
		}
	
	@Test
	public void TestStep_08_CloseTutoredActivity() {
		// introduction and quick prep activity
		test.MTXActivityPage.clickOnCloseActivity();
	}

	/**
	 * TC009_verify presence of submit link for intro and quick prep activity.
	 */
	@Test
	public void TestStep_09_verifyInstructoropenIntroQuickPrepActivity() {
		// introduction and quick prep activity
		Reporter.log("Test Name: verifyInstructorIntroAndQuickPrepActivity",true);
		test.weekwidgetPage.navigateToWeek("Week 44");
		test.MTXActivityPage.clickOnIntroQuickPrep();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.verifySubmitLinkIsPresentForIntroAndMastery();
	}

	@Test
	public void TestStep_10_verifyCloseIntroAndQuickPrepActivity() {
		// introduction and quick prep activity
		test.MTXActivityPage.clickOnCloseActivity();
	}
	
	/**
	 * TC011_verify presence of submit link for mastery activity.
	 */
	@Test
	public void TestStep_11_verifyInstructorMasteryActivity() {
		// Mastery Activity
		Reporter.log("Test Name: verifyInstructorMasteryActivity",true);
		test.MTXActivityPage.clickOnMasteryActivity();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.verifySubmitLinkIsPresentForIntroAndMastery();
	}

	@Test
	public void TestStep_12_verifyCloseMasteryActivity() {
		// introduction and quick prep activity
		test.MTXActivityPage.clickOnCloseActivity();
        }
	
	/**
	 * TC013_verify presence of submit link for review activity.
	 */
	@Test
	public void TestStep_13_verifyInstructorReviewActivity() {
		// Review and Challenge Activity
		Reporter.log("Test Name: verifyInstructorReviewpActivity",true);
		test.MTXActivityPage.clickOnReview();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.verifySubmitLinkIsPresentForIntroAndMastery();
	}

	@Test
	public void TestStep_14_verifyCloseReviewActivity() {
		// introduction and quick prep activity
		test.MTXActivityPage.clickOnCloseActivity();
	}
        /**
	 * TC015_verify presence of submit link for review activity.
	 */
	@Test
	public void TestStep_15_verifyInstructorChallengeActivity() {
		// Review and Challenge Activity
		Reporter.log("Test Name: verifyInstructorChallengepActivity",true);
		test.MTXActivityPage.clickOnChallenge();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.verifySubmitLinkIsPresentForIntroAndMastery();
	}

	@Test
	public void TestStep_16_verifyCloseChallengeActivity() {
		// introduction and quick prep activity
		test.MTXActivityPage.clickOnCloseActivity();
	}
	/**
	 * TC017_verify open and close for study guide.
	 */
	@Test
	public void TestStep_17_verifyInstructorOpenStudyGuide() {
		// Study Guide
		Reporter.log("Test Name: verifyInstructorStudyGuideActivity",true);
                test.weekwidgetPage.navigateToWeek("Week 44");
		test.MTXActivityPage.clickOnStudyGuide();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.verifyKeyConceptsTextPresent();
	}

	@Test
	public void TestStep_18_verifyCloseStudyActivity() {
		// introduction and quick prep activity
			test.MTXActivityPage.clickOnCloseActivity();
	}
	
	@Test
	public void TestStep_19_verifyLPNViewGetsOpenOnClickingswitchMode() {
            Reporter.log("Test Name: verifyInstructorUnitView",true);
		test.MTXDashBoardPage.switchModeDisplayOnWeekWidgetPage();
		test.MTXDashBoardPage.userNavigatetoLPNByClickOnSwitchModeLink();
		test.MTXDashBoardPage.userNavigateBackToDashboardPage();
                test.weekwidgetPage.verifyNotificationWidgetView();
                test.weekwidgetPage.verifyWeekWidget();
	}

        @Test
	public void TestStep_21_verifySearchApp() {
            Reporter.log("Test Name: verifyInstructorSearchApp",true);
		test.MTXDashBoardPage.clickOnAppByName("Search");
                test.MTXDashBoardPage.verifySearchApp();
                test.MTXDashBoardPage.closeOpenApp();
	}
        @Test
	public void TestStep_22_verifyStudyCenterApp() {
            Reporter.log("Test Name: verifyInstructorStudyCenter",true);
		test.MTXDashBoardPage.clickOnAppByName("Study Center");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.StudycenterTitle"));
                test.MTXDashBoardPage.verifyStudyCenterApp();
                test.MTXDashBoardPage.closeOpenApp();
	}
	@Test
	public void TestStep_23_verifyRSSFeedApp() {
            Reporter.log("Test Name: verifyInstructorRSSFeedApp",true);
		test.MTXDashBoardPage.clickOnAppByName("RSS Feed");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.RssTitle"));
                test.MTXDashBoardPage.verifyRssFeedApp();
                test.MTXDashBoardPage.closeOpenApp();
	}
        @Test
	public void TestStep_24_verifyFlashcardsApp() {
            Reporter.log("Test Name: verifyInstructorFlashCardApp",true);
		test.MTXDashBoardPage.clickOnAppByName("Flashcards");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.FlashcardTitle"));
                test.MTXDashBoardPage.verifyFlashcardApp();
                test.MTXDashBoardPage.closeOpenApp();
	}
       @Test
	public void TestStep_25_verifyChemistryReferenceApp() {
            Reporter.log("Test Name: verifyInstructorChemistryReferenceApp",true);
		test.MTXDashBoardPage.clickOnAppByName("Chemistry Reference");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.ChemRefTitle"));
                test.MTXDashBoardPage.verifyChemistryReferenceApp();
                test.MTXDashBoardPage.closeOpenApp();
	}
        @Test
	public void TestStep_26_verifyFullBookApp() {
            Reporter.log("Test Name: verifyFullBookApp",true);
		test.MTXDashBoardPage.clickOnAppByName("Full Book");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.FullbookTitle"));
                test.MTXDashBoardPage.verifyFullBookApp();
                test.MTXDashBoardPage.closeOpenApp();
	}
       @Test
	public void TestStep_27_verifyGlossaryApp() {
            Reporter.log("Test Name: verifyInstructorGlossaryApp",true);
		test.MTXDashBoardPage.clickOnAppByName("Glossary");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.GlossaryTitle"));
                test.MTXDashBoardPage.verifyGlossaryApp();
                test.MTXDashBoardPage.closeOpenApp();
	}
        @Test
	public void TestStep_28_verifyProgressApp() {
            Reporter.log("Test Name: verifyInstructorProgressApp",true);
		test.MTXDashBoardPage.clickOnAppByName("Progress");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.ProgressTitle"));
                test.MTXDashBoardPage.verifyProgressApp();
                test.studentTakeDeletePage.DeleteActivityTakes(getData("Books.courseChemistry.studentName"));
                test.MTXDashBoardPage.closeOpenApp();
	}
        @Test
	public void TestStep_29_verifyDictionaryApp() {
            Reporter.log("Test Name: verifyInstructorDictionaryApp",true);
		test.MTXDashBoardPage.clickOnAppByName("Merriam-Webster's Dictionary");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.DictionaryTitle"));
                test.MTXDashBoardPage.verifyDictionaryApp();
                test.MTXDashBoardPage.closeOpenApp();
	}

	@BeforeMethod
	public void init() {
		System.out.println("\n\n__________________________________________________________________________");
	}

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
    @AfterClass
	public void tearDownClass() throws Exception {
		test.closeBrowserSession();
		System.out.println("###########################################################################################");
		System.out.println("########################################################################################### \n\n");
	}
}

        
