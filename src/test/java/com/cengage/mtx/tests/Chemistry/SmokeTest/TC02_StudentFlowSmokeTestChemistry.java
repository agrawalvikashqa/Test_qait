package com.cengage.mtx.tests.Chemistry.SmokeTest;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import static com.qait.automation.utils.YamlReader.getData;

public class TC02_StudentFlowSmokeTestChemistry {
    
    TestSessionInitiator test;
        String user;
        
        /**
	 * Sets the up class.
	 */
        @BeforeClass
        public void start_test_session() {
            Reporter.log("\n###########################################################################################",true);
		Reporter.log("################ MTX Chemistry Student WorkFlow #############",true);
		Reporter.log("###########################################################################################\n\n",true);
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Smoke Test");
        user = System.getProperty("user", "student");
    }

	/**
	 * TC001_login to the sso front door.
	 */
	@Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseChemistry.courseKey"),getData("Books.courseChemistry.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
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
                test.weekwidgetPage.verifyStatusIconAsStartedOrInProgressForAllTheActivities();
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
		test.MTXDashBoardPage.clickOnAppByName("Message Center");
		test.NotificationCenterPage.getTitleOfApp();
		test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.MessageTitle"));
		test.NotificationCenterPage.viewMoreLinkIsPresent();
		test.NotificationCenterPage.getListOfMessagesWithDateAndTime();
		test.NotificationCenterPage.refreshButtonIsPresent();
		test.NotificationCenterPage.settingButtonIsPresent();
		test.NotificationCenterPage.urgentMessageIsPresent();
		//test.NotificationCenterPage.clickOnSettingIconAndVerifyUI(getData("users.student.username"));
                test.MTXDashBoardPage.closeOpenApp();
	}
    @Test
	public void TestStep_07_VerifyTutoredActivityStatusIconAsNotStartedInWeekView() {
            Reporter.log("Test Name: verifyNotStartedStatusIndicatorOfTutoredActivity",true);
		test.weekwidgetPage.navigateToWeek("Week 44");
		test.weekwidgetPage.verifyNotStartedStatusIconForActivity(getData("Books.courseChemistry.activityTutored"));
        }
    @Test
	public void TestStep_08_VerifyStudentAttemptAndSubmitConceptualTutoredActivity() {
            Reporter.log("Test Name: AttemptStudentTutoredActivity",true);
            test.weekwidgetPage.navigateToWeek("Week 44");
		test.MTXActivityPage.clickOnTutoredActivity(getData("Books.courseChemistry.activityTutored"));
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.clickOnStartActivityForTutored();
                test.MTXActivityPage.clickOnSubmitLinkForTutored();
                test.MTXActivityPage.clickOnCloseActivity();
	}
    //@Test               Failing due to NG-32227
	public void TestStep_09_VerifyTutoredActivityInProgressStatusIconInWeekView() {
            Reporter.log("Test Name: verifyInProgressStatusIndicatorOfTutoredActivity",true);
                test.weekwidgetPage.verifyActivityInProgressIcon(getData("Books.courseChemistry.activityTutored"));
	}
    @Test
	public void TestStep_10_VerifyStudentSubmitTutoredActivityForGrading() {
            Reporter.log("Test Name: StudentSubmitsTutoredActivity",true);
		test.MTXActivityPage.clickOnTutoredActivity(getData("Books.courseChemistry.activityTutored"));
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.clickOnSubmitLinkForTutored();
		test.MTXActivityPage.clickOnSubmitButton();
                test.MTXActivityPage.handleConfirmationPopup();
	}
    //@Test      Failing due to NG-32227
	public void TestStep_11_VerifyCompletedStatusIconForConceptualTutoredActivityInWeekView() {
            Reporter.log("Test Name: verifySubmittedStatusIndicatorOfTutoredActivity",true);
		test.weekwidgetPage.verifyStausDisplayAsCompleted(getData("Books.courseChemistry.activityTutored"));
	}
    @Test
	public void TestStep_12_VerifyTutoredActivityInReviewMode() {
            Reporter.log("Test Name: verifyTutoredActivityInReviewMode",true);
            test.weekwidgetPage.navigateToWeek("Week 44");
		test.MTXActivityPage.clickOnTutoredActivity(getData("Books.courseChemistry.activityTutored"));
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.verifyActivityLaunchInReviewMode();
                test.MTXActivityPage.clickOnCloseActivity();
	}
    @Test
	public void TestStep_13_VerifyIntroAndQuickPrepActivityStatusIconAsNotStartedInWeekView() {
                Reporter.log("Test Name: verifyNotStartedStatusIndicatorOfIntroductionActivity",true); 
		test.weekwidgetPage.verifyNotStartedStatusIconForActivity("Introduction and Quick");
	}
    @Test
	public void TestStep_14_VerifyStudentAttemptIntroductionandQuickPrepActivity() {
                Reporter.log("Test Name: StudentAttemptsIntroductionActivity",true);
                test.DashBoardPage.refreshPage();
                test.weekwidgetPage.navigateToWeek("Week 44");
		test.MTXActivityPage.clickOnIntroQuickPrep();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.clickOnSubmitLink();
                test.MTXActivityPage.clickOnCloseActivity();
	}

    //@Test      Failing due to NG-32227
	public void TestStep_15_VerifyIntroAndQuickPrepActivityInProgressStatusIconInWeekView() {
            Reporter.log("Test Name: verifyInProgressStatusIndicatorOfIntroductionActivity",true);
            test.weekwidgetPage.verifyActivityInProgressIcon("Introduction and Quick Prep");
	}
    @Test
	public void TestStep_16_VerifyStudentSubmitIntroAndQuickPrepActivityForGrading() {
            Reporter.log("Test Name: StudentSubmitsIntroductionActivity",true);
		test.MTXActivityPage.clickOnIntroQuickPrep();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.clickOnSubmitLink();
		test.MTXActivityPage.clickOnSubmitButton();
	}
    //@Test               Failing due to NG-32227
	public void TestStep_17_VerifyCompletedStatusIconForIntroductionandQuickPrepActivityInWeekView() {
            Reporter.log("Test Name: verifySubmittedStatusIndicatorOfIntroductionActivity",true);
		test.weekwidgetPage.verifyStausDisplayAsCompleted("Introduction and Quick Prep");
	}
    @Test
	public void TestStep_18_VerifyIntroAndQuickPrepActivityInReviewMode() {
            Reporter.log("Test Name: verifyIntroductionActivityInReviewMode",true);
		test.MTXActivityPage.clickOnIntroQuickPrep();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.verifyActivityLaunchInReviewMode();
                test.MTXActivityPage.clickOnCloseActivity();
	}
    @Test
	public void TestStep_19_VerifyMasteryActivityStatusIconAsNotStartedInWeekView() {
            Reporter.log("Test Name: verifyNotStartedStatusIndicatorOfMasteryActivity",true); 
		test.weekwidgetPage.navigateToWeek("Week 44");
		test.weekwidgetPage.verifyNotStartedStatusIconForActivity("Mastery");
	}

    @Test
	public void TestStep_20_VerifyStudentAttemptMasteryActivity() {
                Reporter.log("Test Name: StudentAttemptsMasteryActivity",true);
                test.DashBoardPage.refreshPage();
                test.weekwidgetPage.navigateToWeek("Week 44");
                test.MTXActivityPage.clickOnMasteryActivity();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.clickOnSubmitMasterLink();
                test.MTXActivityPage.clickOnCloseActivity();
	}

    //@Test                Failing due to NG-32227
	public void TestStep_21_VerifyMasteryActivityInProgressStatusIconInWeekView() {
            Reporter.log("Test Name: verifyStatusIndicatorOfMasteryActivity",true);
		test.weekwidgetPage.verifyActivityInProgressIcon("Mastery");
	}
    @Test
	public void TestStep_22_VerifyStudentSubmitMasteryActivityForGrading() {
            Reporter.log("Test Name: StudentSubmitsMasteryActivity",true);
		test.MTXActivityPage.clickOnMasteryActivity();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.clickOnSubmitMasterLink();
		test.MTXActivityPage.clickOnSubmitButton();
                test.MTXActivityPage.handleAlertPopup();
	}
    //@Test             Failing due to NG-32227
	public void TestStep_23_VerifyCompletedStatusIconForMasteryActivityInWeekView() {
           Reporter.log("Test Name: verifySubmittedStatusIndicatorOfMasteryActivity",true);
		test.weekwidgetPage.verifyStausDisplayAsCompleted("Mastery");
	}
    @Test
	public void TestStep_24_VerifyMasteryActivityInReviewMode() {
            Reporter.log("Test Name: verifyMasteryActivityInReviewMode",true);
		test.MTXActivityPage.clickOnMasteryActivity();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.verifyActivityLaunchInReviewMode();
                test.MTXActivityPage.clickOnCloseActivity();
	}
    @Test
	public void TestStep_25_VerifyReviewActivityStatusIconAsNotStartedInWeekView() {
            Reporter.log("Test Name: verifyNotStartedStatusIndicatorOfReviewActivity",true); 
            test.weekwidgetPage.navigateToWeek("Week 44");
		test.weekwidgetPage.verifyNotStartedStatusIconForActivity("Review");
	}

    @Test
	public void TestStep_26_VerifyStudentAttemptReviewActivity() {
            Reporter.log("Test Name: StudentAttemptsReviewActivity",true);
            test.DashBoardPage.refreshPage();
                test.weekwidgetPage.navigateToWeek("Week 44");
		test.MTXActivityPage.clickOnReview();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.clickOnSubmitLink();
                test.MTXActivityPage.clickOnCloseActivity();
	}

    //@Test                  Failing due to NG-32227
	public void TestStep_27_VerifyReviewActivityInProgressStatusIconInWeekView() {
            Reporter.log("Test Name: verifyInProgressStatusIndicatorOfReviewActivity",true); 
		test.weekwidgetPage.verifyActivityInProgressIcon("Review");
	}

    @Test
	public void TestStep_28_VerifyStudentSubmitReviewActivityForGrading() {
            Reporter.log("Test Name: StudentSubmitsReviewActivity",true);
		test.MTXActivityPage.clickOnReview();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.clickOnSubmitLink();
		test.MTXActivityPage.clickOnSubmitButton();
	}

   // @Test                 Failing due to NG-32227
	public void TestStep_29_VerifyCompletedStatusIconForReviewActivityInWeekView() {
            Reporter.log("Test Name: verifySubmittedStatusIndicatorOfReviewActivity",true);
		test.weekwidgetPage.verifyStausDisplayAsCompleted("Review");
	}

    @Test
	public void TestStep_30_VerifyReviewActivitynReviewMode() {
            Reporter.log("Test Name: verifyReviewActivityInReviewMode",true);
		test.MTXActivityPage.clickOnReview();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.verifyActivityLaunchInReviewMode();
                test.MTXActivityPage.clickOnCloseActivity();
	}
    @Test
	public void TestStep_31_VerifyChallengeActivityStatusIconAsNotStartedInWeekView() {
            Reporter.log("Test Name: verifyNotStartedStatusIndicatorOfChallengeActivity",true); 
            test.weekwidgetPage.navigateToWeek("Week 44");
		test.weekwidgetPage.verifyNotStartedStatusIconForActivity("Challenge");
	}

    @Test
	public void TestStep_32_VerifyStudentAttemptChallengeActivity() {
            Reporter.log("Test Name: StudentAttemptsChallengeActivity",true);
            test.DashBoardPage.refreshPage();
                test.weekwidgetPage.navigateToWeek("Week 44");
		test.MTXActivityPage.clickOnChallenge();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.clickOnSubmitLink();
                test.MTXActivityPage.clickOnCloseActivity();
	}

    //@Test                   Failing due to NG-32227
	public void TestStep_33_VerifyChallengeActivityInProgressStatusIconInWeekView() {
            Reporter.log("Test Name: verifyInProgressStatusIndicatorOfChallengeActivity",true); 
		test.weekwidgetPage.verifyActivityInProgressIcon("Challenge");
	}

    @Test
	public void TestStep_34_VerifyStudentSubmitChallengeActivityForGrading() {
            Reporter.log("Test Name: StudentSubmitsChallengeActivity",true);
		test.MTXActivityPage.clickOnChallenge();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.clickOnSubmitLink();
		test.MTXActivityPage.clickOnSubmitButton();
	}

    //@Test                     Failing due to NG-32227
	public void TestStep_35_VerifyCompletedStatusIconForChallengeActivityInWeekView() {
            Reporter.log("Test Name: verifySubmittedStatusIndicatorOfChallengeActivity",true);
		test.weekwidgetPage.verifyStausDisplayAsCompleted("Challenge");
	}

    @Test
	public void TestStep_36_VerifyChallengeActivitynReviewMode() {
            Reporter.log("Test Name: verifyChallengeActivityInReviewMode",true);
		test.MTXActivityPage.clickOnChallenge();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.verifyActivityLaunchInReviewMode();
                test.MTXActivityPage.clickOnCloseActivity();
	}
   @Test
	public void TestStep_37_verifyInstructorOpenStudyGuide() {
		// Study Guide
		Reporter.log("Test Name: verifyStudentStudyGuideActivity",true);
                test.weekwidgetPage.navigateToWeek("Week 44");
		test.MTXActivityPage.clickOnStudyGuide();
		test.MTXActivityPage.getTitleOfActivity();
		test.MTXActivityPage.verifyKeyConceptsTextPresent();
                test.MTXActivityPage.clickOnCloseActivity();
	}
    @Test
	public void TestStep_38_verifyLPNViewGetsOpenOnClickingswitchMode() {
            Reporter.log("Test Name: verifyStudentUnitView",true);
		test.MTXDashBoardPage.switchModeDisplayOnWeekWidgetPageForStudent();
		test.MTXDashBoardPage.userNavigatetoLPNByClickOnSwitchModeLink();
		test.MTXDashBoardPage.userNavigateBackToDashboardPage();
                test.weekwidgetPage.verifyNotificationWidgetView();
                test.weekwidgetPage.verifyWeekWidget();
	}
    @Test
	public void TestStep_39_verifySearchApp() {
            Reporter.log("Test Name: verifyInstructorSearchApp",true);
		test.MTXDashBoardPage.clickOnAppByName("Search");
                test.MTXDashBoardPage.verifySearchApp();
                test.MTXDashBoardPage.closeOpenApp();
	}
   @Test
	public void TestStep_40_verifyStudyCenterApp() {
            Reporter.log("Test Name: verifyInstructorStudyCenter",true);
		test.MTXDashBoardPage.clickOnAppByName("Study Center");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.StudycenterTitle"));
                test.MTXDashBoardPage.verifyStudyCenterApp();
                test.MTXDashBoardPage.closeOpenApp();
	}
   @Test
	public void TestStep_41_verifyRSSFeedApp() {
            Reporter.log("Test Name: verifyInstructorRSSFeedApp",true);
		test.MTXDashBoardPage.clickOnAppByName("RSS Feed");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.RssTitle"));
                test.MTXDashBoardPage.verifyRssFeedApp();
                test.MTXDashBoardPage.closeOpenApp();
	}
   @Test
	public void TestStep_42_verifyFlashcardsApp() {
            Reporter.log("Test Name: verifyInstructorFlashCardApp",true);
		test.MTXDashBoardPage.clickOnAppByName("Flashcards");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.FlashcardTitle"));
                test.MTXDashBoardPage.verifyFlashcardApp();
                test.MTXDashBoardPage.closeOpenApp();
	}
    @Test
	public void TestStep_43_verifyChemistryReferenceApp() {
            Reporter.log("Test Name: verifyInstructorChemistryReferenceApp",true);
		test.MTXDashBoardPage.clickOnAppByName("Chemistry Reference");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.ChemRefTitle"));
                test.MTXDashBoardPage.verifyChemistryReferenceApp();
                test.MTXDashBoardPage.closeOpenApp();
	}
    @Test
	public void TestStep_44_verifyFullBookApp() {
            Reporter.log("Test Name: verifyFullBookApp",true);
		test.MTXDashBoardPage.clickOnAppByName("Full Book");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.FullbookTitle"));
                test.MTXDashBoardPage.verifyFullBookApp();
                test.MTXDashBoardPage.closeOpenApp();
	}
    @Test
	public void TestStep_45_verifyGlossaryApp() {
            Reporter.log("Test Name: verifyInstructorGlossaryApp",true);
		test.MTXDashBoardPage.clickOnAppByName("Glossary");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.GlossaryTitle"));
                test.MTXDashBoardPage.verifyGlossaryApp();
                test.MTXDashBoardPage.closeOpenApp();
	}
    @Test
	public void TestStep_46_verifyProgressApp() {
            Reporter.log("Test Name: verifyInstructorProgressApp",true);
		test.MTXDashBoardPage.clickOnAppByName("Progress");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.ProgressTitle"));
                test.MTXDashBoardPage.verifyStudentProgressApp();
                test.MTXDashBoardPage.closeOpenApp();
	}
  @Test
	public void TestStep_47_verifyDictionaryApp() {
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
