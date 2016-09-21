/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.AmericanGovernment.SmokeTest;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author QAI
 */
public class TC01_InstructorFlowSmokeTestAmGovt {
    
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

	/**
	 * Sets the up class.
	 */
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
        Reporter.log("TC_01 : Verify Instructor Logs into Mindtap Application",true);
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAmGovt.CourseKey"),getData("Books.courseAmGovt.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }


	/**
	 * TC002_verify user redirect to dashboard display.
	 */
	@Test
	public void TestStep_02_verifyLPNTitle() {
		System.out.println("Test_02 : Verify LPN Title");
		test.MTXDashBoardPage.verifyLPNTitle();
                Reporter.log("LPN Title is Verified Successfully of Instructor Dashboard",true); 
	}
      
	@Test
	public void TestStep_03_verifyViewsAreDisplayedAndSwitchable() {
		System.out.println("Test_03 : Verify Week view, Unit view and DateManager are Displayed and Switchable ");
		test.MTXDashBoardPage.verifyAllTabsAreDisplayedOnInstructorDashboard();
                Reporter.log("Verified Successfully that all tabs are displaying at Instructor Dashboard",true);
                test.MTXDashBoardPage.verifyAllTabsAreSwitchableForInstructor();
                Reporter.log("Verified Successfully that all tabs are switchable at Instructor Dashboard",true);
        }
        
        @Test
	public void TestStep_04_verifyCurrentWeekIsDisplayedInWeekView() {
		System.out.println("Test_04 : Verify Current Week Displays in Week View Widget");
		test.MTXDashBoardPage.verifyCurrentWeekDisplaysInWeekView();
                Reporter.log("Verified Successfully that Current Week Displays in Instructor Dashboard",true);
	}

	@Test
	public void TestStep_05_verifyNotificationWidgetView() {
		System.out.println("Test_05 : Verify NotificationWidget Displays in Dashboard");
		test.weekwidgetPage.verifyNotificationWidgetView();
                Reporter.log("Verified Successfully Notification Widget at Instructor Dashboard",true);
	}

	
	@Test
	public void TestStep_06_verifyPerformanceWidgetDisplaysOnDashboard() {
            Reporter.log("Test_06 : Verify Performance Widget Displays on Dashboard",true);
            test.MTXDashBoardPage.verifyPerformanceWidgetTitle();
            Reporter.log("Verified Successfully Performance Widget with Title",true);
		
	}

        @Test
	public void TestStep_07_verifyClassAverageWidgetDisplaysOnDashboard(){
            Reporter.log("Test_07 : Verify Class Average Widget Displays on Dashboard",true);
            test.MTXDashBoardPage.verifyClassAverageWidgetDisplays();
            Reporter.log("Verified Successfully Class Average Widget displays for Instructor",true);
        }
    
        @Test
	public void TestStep_08_verifyAllLinksDisplayInUserMenu(){
          Reporter.log("Test_08 : Verify All Links Display in User Menu for Instructor",true);
          test.MTXDashBoardPage.verifyAllLinksInUserMenuForInstructor();
          Reporter.log("Verified Successfully All Links Display in User Menu for Instructor",true);
        }
        
        @Test
	public void TestStep_09_verifyAllLinksDisplayOnSplashPage(){
           Reporter.log("Test_09 : Verify All Links Display on Splash Page for Instructor",true); 
           test.MTXDashBoardPage.verifyAllLinksDisplayOnSplashPage();
           Reporter.log("Verified Successfully All Links Display in Splash Page for Instructor",true);
        }
        
        @Test
	public void TestStep_10_verifyInstructorNavigatesToUnitViewAndLaunchesUnit(){
            Reporter.log("Test_10 : Verify Instructor Navigates To UnitView And Launches Unit ",true);
            test.MTXDashBoardPage.NavigateToUnitViewAndLaunchesUnit();
            Reporter.log("Verified Successfully that Instructor Navigates To UnitView And Launches Unit",true);
        }
        
        @Test
	public void TestStep_11_verifyInstructorLaunchesActivityTypeConnectingWithPolitics(){
           Reporter.log("Test_11 : Verify Instructor Launches Activity Type ",true); 
           test.MTXDashBoardPage.verifyLaunchConnectingWithPolitics();
           test.MTXFramePage.switchToMainFrame();
           test.MTXFramePage.switchToActivityOverviewFrame();
           test.MTXActivityPage.overviewStartActivityButton();
           test.MTXActivityPage.verifyCheckAnswerButton();
           test.MTXFramePage.switchToDefaultContent();
           test.MTXActivityPage.closeActivity();
           Reporter.log("Verified that Instructor Successfully Launches and close Activity Type Connecting With Politics",true);
           
        }
        
        @Test
	public void TestStep_12_verifyInstructorLaunchesActivityTypeConceptualNarrative(){
           Reporter.log("Test_12 : Verify Instructor Launches Activity Type Conceptual Narrative",true); 
           test.MTXDashBoardPage.verifyLaunchConceptualNarrative();
           test.MTXFramePage.switchToMainFrame();
           test.MTXFramePage.switchToActivityOverviewFrame();
           test.MTXActivityPage.overviewStartActivityButton();
           test.MTXActivityPage.verifyCheckAnswerButton();
           test.MTXFramePage.switchToDefaultContent();
           test.MTXActivityPage.closeActivity();
           Reporter.log("Verified that Instructor Successfully Launches and close Activity Type Conceptual Narrative",true);          
        }
        
        @Test
	public void TestStep_13_verifyInstructorLaunchesActivityTypeDiscussionBoard(){
           Reporter.log("Test_13 : Verify Instructor Launches Activity Type Discussion Board",true); 
           test.MTXDashBoardPage.verifyLaunchDiscussionBoard();
           test.MTXFramePage.switchToDBoardFrame();
           //test.MTXFramePage.switchToActivityOverviewFrame();
           //test.MTXActivityPage.overviewStartActivityButton();
           test.MTXActivityPage.verifyDiscussionBoardTips();
           test.MTXFramePage.switchToDefaultContent();
           test.MTXActivityPage.closeActivity();
           Reporter.log("Verified that Instructor Successfully Launches and closes Activity Type Discussion Board ",true);          
        }
        
        @Test
	public void TestStep_14_verifyInstructorLaunchesActivityTypeContextualLens(){
           Reporter.log("Test_14 : Verify Instructor Launches Activity Type Contextual Lens",true); 
           test.MTXDashBoardPage.verifyLaunchContextualLens();
           test.MTXFramePage.switchToMainFrame();
           test.MTXFramePage.switchToActivityOverviewFrame();
           test.MTXActivityPage.overviewStartActivityButton();
           test.MTXActivityPage.verifyCheckAnswerButton();
           test.MTXFramePage.switchToDefaultContent();
           test.MTXActivityPage.closeActivity();
           Reporter.log("Verified that Instructor Successfully Launches and close Activity Type Contextual Lens ",true);          
        }
    
        @Test
	public void TestStep_15_verifyInstructorLaunchesActivityTypeEssay(){
           Reporter.log("Test_15 : Verify Instructor Launches Activity Type Essay",true); 
           test.MTXDashBoardPage.verifyLaunchEssayActivity();
           test.MTXFramePage.switchToMainFrame();
           test.MTXFramePage.switchToActivityOverviewFrame();
           test.MTXActivityPage.overviewStartActivityButton();
           test.MTXActivityPage.verifyCloseAndSubmitButton();
           test.MTXFramePage.switchToDefaultContent();
           test.MTXActivityPage.closeActivity();
           Reporter.log("Verified that Instructor Successfully Launches and close Activity Type Essay ",true);          
        }
    
        @Test
	public void TestStep_16_verifyInstructorLaunchesStudyGuide(){
           Reporter.log("Test_16 : Verify Instructor Launches Study Guide ",true); 
           test.MTXDashBoardPage.verifyStudyGuideLaunchfromLPN();
           test.MTXFramePage.switchToStudyCenterFrame();
           test.MTXActivityPage.verifyUnitStudyGuideHeading();
           test.MTXFramePage.switchToDefaultContent();
           test.MTXActivityPage.closeActivity();
           Reporter.log("Verified that Instructor Successfully Launches Study Guide",true);          
        }
        
        @Test
	public void TestStep_17_verifyInstructorSetsAndClearsDueDateFromDateManager(){
            Reporter.log("Test_17: Verify Instructor is able to set and Clear Due Date from Date Manager ",true); 
            test.MTXDashBoardPage.instructorSwitchToDatemanager();
            test.DateManagerPage.setAndClearDueDateInstructor();
            Reporter.log("Instructor has successfully Set and Clear Due Date from Date Manager ",true); 
        }
        
        @Test
        public void TestStep_18_verifyInstructorLaunchesSearchAppFromAppsMenu(){
            Reporter.log("Test_18 : Verify Instructor is able to Launch Search App ",true);
            test.DashBoardPage.clickOnAppByName("Search");
            test.DashBoardPage.verifySearchAppLaunch();
            Reporter.log(user+"  successfully Launched Search App From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();
            Reporter.log("Successfully Closed Search App",true);
        }
        
        @Test
        public void TestStep_19_verifyInstructorLaunchesStudyCenterAppFromAppsMenu(){
            Reporter.log("Test_19 : Verify Instructor is able to Launch Study Center App ",true);
            test.DashBoardPage.clickOnAppByName("Study Center");
            test.MTXFramePage.switchToDockIFrame(StudycenterTitle);
            test.MTXDashBoardPage.verifyStudyCenterApp();
            Reporter.log(user+"  successfully Launched Study Center From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();
            Reporter.log("Successfully Closed Study Center App",true);
        }
        
        @Test
        public void TestStep_20_verifyInstructorLaunchesMessageCenterAppFromAppsMenu(){
            Reporter.log("Test_20 : Verify Instructor is able to Launch Message Center App ",true);
            test.DashBoardPage.clickOnAppByName("Message Center");
            test.MTXFramePage.switchToDockIFrame(MessageTitle);
            test.MTXDashBoardPage.verifyMessageCenterAppLaunch();
            Reporter.log(user+"  successfully Launched Message Center From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();     
            Reporter.log("Successfully Closed Message Center App",true);
        }
        
        @Test
        public void TestStep_21_verifyInstructorLaunchesProgressAppFromAppsMenu(){
            Reporter.log("Test_21 : Verify Instructor is able to Launch Progress App ",true);
            test.DashBoardPage.clickOnAppByName("Progress");
            test.MTXFramePage.switchToDockIFrame(ProgressTitle);
            test.MTXDashBoardPage.verifyProgressApp();
            Reporter.log(user+"  successfully Launched Progress App From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();     
            Reporter.log("Successfully Closed Progress App",true);
        }
        
        @Test
        public void TestStep_22_verifyInstructorLaunchesFlashcardsAppFromAppsMenu(){
            Reporter.log("Test_22 : Verify Instructor is able to Launch Flashcards App ",true);
            test.DashBoardPage.clickOnAppByName("Flashcards");
            test.MTXFramePage.switchToDockIFrame(FlashcardTitle);
            test.MTXDashBoardPage.verifyFlashcardApp();
            Reporter.log(user+"  successfully Launched Flashcards App From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();     
            Reporter.log("Successfully Closed Flashcards App",true);
        }
        
        @Test
        public void TestStep_23_verifyInstructorLaunchesGlossaryAppFromAppsMenu(){
            Reporter.log("Test_23 : Verify Instructor is able to Launch Glossary App ",true);
            test.DashBoardPage.clickOnAppByName("Glossary");
            test.MTXFramePage.switchToDockIFrame(GlossaryTitle);
            test.MTXDashBoardPage.verifyGlossaryApp();
            Reporter.log(user+"  successfully Launched Glossary App From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();     
            Reporter.log("Successfully Closed Glossary App",true);
        }
        
        @Test
        public void TestStep_24_verifyInstructorLaunchesPollingAppFromAppsMenu(){
            Reporter.log("Test_24 : Verify Instructor is able to Launch Polling App ",true);
            test.DashBoardPage.clickOnAppByName("Polling");
            test.MTXFramePage.switchToDockIFrame(PollingTitle);
            test.MTXDashBoardPage.verifyPollingAppLaunch();
            Reporter.log(user+"  successfully Launched Polling App From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();     
            Reporter.log("Successfully Closed Polling App",true);
        }
        
        @Test
        public void TestStep_25_verifyInstructorLaunchesFullbookAppFromAppsMenu(){
            Reporter.log("Test_25 : Verify Instructor is able to Launch Fullbook App ",true);
            test.DashBoardPage.clickOnAppByName("Full Book");
            test.MTXFramePage.switchToDockIFrame(FullbookTitle);
            test.MTXDashBoardPage.verifyFullBookApp();
            Reporter.log(user+"  successfully Launched  Fullbook App From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();     
            Reporter.log("Successfully Closed Fullbook App",true);
        }
        
        @Test
        public void TestStep_26_verifyInstructorLaunchesMerriamWebsterDictionaryAppFromAppsMenu(){
            Reporter.log("Test_26 : Verify Instructor is able to Launch Merriam Webster Dictionary App ",true);
            test.DashBoardPage.clickOnAppByName("Merriam-Webster's Dictionary");
            test.MTXFramePage.MerriamWebsterDictionaryFrame();
            test.MTXDashBoardPage.verifyMerriamWebsterDictionaryAppLaunch();
            Reporter.log(user+" successfully Launched  Merriam Webster Dictionary App From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();     
            Reporter.log("Successfully Closed Merriam Webster Dictionary App",true);
        }
        
         
        @Test
        public void TestStep_27_verifyInstructorLogoutFromMTXAmGovtCourse(){
            Reporter.log("Test_27 : Verify Instructor is able to Log Out from MTX American Government  ",true);
            test.MTXDashBoardPage.verifyLogOutFromMTXCourse();
            Reporter.log("Instructor has successfully Logged Out from MTX American Government Course",true);
            
        }
        
        @BeforeMethod
        public void beforeEachTest() {
        Reporter.log("\n\n *********************************************************************** ", true);
        
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
