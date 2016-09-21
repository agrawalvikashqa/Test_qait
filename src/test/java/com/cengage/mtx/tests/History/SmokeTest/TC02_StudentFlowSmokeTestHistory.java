/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.History.SmokeTest;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static com.qait.automation.utils.YamlReader.getData;
/**
 *
 * @author Kashyap
 */
public class TC02_StudentFlowSmokeTestHistory {
    
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
        
        
        /**
	 * Sets the up class.
	 */
        @BeforeClass
        public void start_test_session() {
            System.out.println("\n###########################################################################################");
		System.out.println("################ MTX History Student WorkFlow #############");
		System.out.println("###########################################################################################\n\n");
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("History Smoke Test");
        user = System.getProperty("user", "student");
    }

      
	/**
	 * TC001_login to mindtap by fetching token from sso
	 */
	@Test
    public void TestStep_01_LoginToSSOApplication() {
        Reporter.log("Test_01 : Verify Student logs into mindtap application",true);
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseHistory.courseKey"),getData("Books.courseHistory.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
       @Test
	public void TestStep_02_verifyLPNTitle() {
		System.out.println("Test_02 : verify LPN Title");
		test.MTXDashBoardPage.verifyLPNTitleHistory();
                Reporter.log("LPN Title is Verified Successfully of Student Dashboard",true); 
	}
        
        @Test
	public void TestStep_03_verifyViewsAreDisplayedAndSwitchable() {
		System.out.println("Test_03 : Verify Week view, Unit view and List View are Displayed and Switchable ");
		test.MTXDashBoardPage.verifyAllTabsAreDisplayedOnStudentDashboard();
                Reporter.log("Verified Successfully that all tabs are displaying at Student Dashboard",true);
                test.MTXDashBoardPage.verifyAllTabsAreSwitchableForStudent();
                Reporter.log("Verified Successfully that all tabs are switchable at Student Dashboard",true);
        }
        
        @Test
	public void TestStep_04_verifyCurrentWeekIsDisplayedInWeekView() {
		System.out.println("Test_04 : Verify Current Week Displays in Week View Widget");
		test.MTXDashBoardPage.verifyCurrentWeekDisplaysInWeekView();
                Reporter.log("Verified Successfully that Current Week Displays in Student Dashboard",true);
	}

	@Test
	public void TestStep_05_verifyNotificationWidgetView() {
		System.out.println("Test_05 : Verify NotificationWidget Displays in Dashboard");
		test.weekwidgetPage.verifyNotificationWidgetView();
                Reporter.log("Verified Successfully Notification Widget at Student Dashboard",true);
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
            Reporter.log("Verified Successfully Class Average Widget displays for Student",true);
        }
        
        @Test
	public void TestStep_08_verifyYourCurrentScoreWidgetDisplaysOnDashboard(){
            Reporter.log("Test_08 : Verify Your Current Score Widget Displays on Dashboard",true);
            test.MTXDashBoardPage.verifyYourCurrentScoreWidgetDisplays();
            Reporter.log("Verified Successfully Your Current Score Widget displays for Student",true);
        }
    
        @Test
	public void TestStep_09_verifyAllLinksDisplayInUserMenu(){
          Reporter.log("Test_09 : Verify All Links Display in User Menu for Student",true);
          test.MTXDashBoardPage.verifyAllLinksInUserMenuForStudent();
          Reporter.log("Verified Successfully All Links Display in User Menu for Student",true);
        }
        
        @Test
	public void TestStep_10_verifyAllLinksDisplayOnSplashPage(){
           Reporter.log("Test_10 : Verify All Links Display on Splash Page for Student",true); 
           test.MTXDashBoardPage.verifyAllLinksDisplayOnSplashPage();
           Reporter.log("Verified Successfully All Links Display in Splash Page for Student",true);
        }
        
        @Test
	public void TestStep_11_verifyStudentNavigatesToUnitViewAndLaunchesUnit(){
            Reporter.log("Test_11 : Verify Student Navigates To UnitView And Launches Unit ",true);
            test.MTXDashBoardPage.NavigateToUnitViewAndLaunchesUnitHistory();
            Reporter.log("Verified Successfully that Student Navigates To UnitView And Launches Unit",true);
        }
        
        @Test
	public void TestStep_12_verifyStudentLaunchesActivityTypeInfographic(){
           Reporter.log("Test_12 : Verify Student Launches Activity Type Infographic ",true); 
           test.MTXDashBoardPage.verifyLaunchInfographicActivity();
           test.MTXFramePage.switchToMainFrame();
           test.MTXFramePage.switchToActivityOverviewFrame();
          // test.MTXActivityPage.overviewStartActivityButton();
           test.MTXActivityPage.verifyCheckAnswerButton();
           test.MTXFramePage.switchToDefaultContent();
           test.MTXActivityPage.closeActivity();
           Reporter.log("Verified that Student Successfully Launches and close Activity Type Infographic",true);      
        }
        
        @Test
	public void TestStep_13_verifyStudentLaunchesActivityTypeConceptualNarrative(){
           Reporter.log("Test_13 : Verify Student Launches Activity Type Conceptual Narrative",true); 
           test.MTXDashBoardPage.verifyLaunchConceptualNarrativeHistory();
           test.MTXFramePage.switchToMainFrame();
           test.MTXFramePage.switchToActivityOverviewFrame();
          test.MTXActivityPage.overviewStartActivityButton();
           test.MTXActivityPage.verifyCheckAnswerButton();
           test.MTXFramePage.switchToDefaultContent();
           test.MTXActivityPage.closeActivity();
           Reporter.log("Verified that Student Successfully Launches and close Activity Type Conceptual Narrative",true);          
        }
        
        
        @Test
	public void TestStep_14_verifyStudentLaunchesActivityTypeContextualLens(){
           Reporter.log("Test_14 : Verify Student Launches Activity Type Contextual Lens",true); 
           test.MTXDashBoardPage.verifyLaunchContextualLensHistory();
           test.MTXFramePage.switchToMainFrame();
           test.MTXFramePage.switchToActivityOverviewFrame();
         //  test.MTXActivityPage.overviewStartActivityButton();
           test.MTXActivityPage.verifyCheckAnswerButton();
           test.MTXFramePage.switchToDefaultContent();
           test.MTXActivityPage.closeActivity();
           Reporter.log("Verified that Student Successfully Launches and close Activity Type Contextual Lens ",true);          
        }
    
        @Test
	public void TestStep_15_verifyStudentLaunchesActivityTypeEssay(){
           Reporter.log("Test_15 : Verify Student Launches Activity Type Essay",true); 
           test.MTXDashBoardPage.verifyLaunchEssayActivityHistory();
           test.MTXFramePage.switchToMainFrame();
           test.MTXFramePage.switchToActivityOverviewFrame();
         //  test.MTXActivityPage.overviewStartActivityButton();
           test.MTXActivityPage.verifyCloseAndSubmitButton();
           test.MTXFramePage.switchToDefaultContent();
           test.MTXActivityPage.closeActivity();
           Reporter.log("Verified that Student Successfully Launches and close Activity Type Essay ",true);          
        }
    
        @Test
	public void TestStep_16_verifyStudentLaunchesStudyGuide(){
           Reporter.log("Test_16 : Verify Student Launches Study Guide ",true); 
           test.MTXDashBoardPage.verifyStudyGuideLaunchfromLPN();
           test.MTXFramePage.switchToStudyGuideFrame();
           test.MTXActivityPage.verifyStudyGuideLaunchHistory();
           test.MTXFramePage.switchToDefaultContent();
           test.MTXActivityPage.closeActivity();
           Reporter.log("Verified that Student Successfully Launched Study Guide",true);          
        }
        
        
        @Test
        public void TestStep_17_verifyStudentLaunchesSearchAppFromAppsMenu(){
            Reporter.log("Test_17 : Verify Student is able to Launch Search App ",true);
            test.DashBoardPage.clickOnAppByName("Search");
            test.DashBoardPage.verifySearchAppLaunch();
            Reporter.log(user+"  successfully Launched Search App From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();
            Reporter.log("Successfully Closed Search App",true);
        }
        
        @Test
        public void TestStep_18_verifyStudentLaunchesStudyCenterAppFromAppsMenu(){
            Reporter.log("Test_18 : Verify Student is able to Launch Study Center App ",true);
            test.DashBoardPage.clickOnAppByName("Study Center");
            test.MTXFramePage.switchToDockIFrame(StudycenterTitle);
            test.MTXDashBoardPage.verifyStudyCenterApp();
            Reporter.log(user+"  successfully Launched Study Center From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();
            Reporter.log("Successfully Closed Study Center App",true);
        }
        
        @Test
        public void TestStep_19_verifyStudentLaunchesMessageCenterAppFromAppsMenu(){
            Reporter.log("Test_19 : Verify Student is able to Launch Message Center App ",true);
            test.DashBoardPage.clickOnAppByName("Message Center");
            test.MTXFramePage.switchToDockIFrame(MessageTitle);
            test.MTXDashBoardPage.verifyMessageCenterAppLaunchStudent();
            Reporter.log(user+"  successfully Launched Message Center From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();     
            Reporter.log("Successfully Closed Message Center App",true);
        }
        
        @Test
        public void TestStep_20_verifyStudentLaunchesProgressAppFromAppsMenu(){
            Reporter.log("Test_20 : Verify Student is able to Launch Progress App ",true);
            test.DashBoardPage.clickOnAppByName("Progress");
            test.MTXFramePage.switchToDockIFrame(ProgressTitle);
            test.MTXDashBoardPage.verifyStudentProgressApp();
            Reporter.log(user+"  successfully Launched Progress App From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();     
            Reporter.log("Successfully Closed Progress App",true);
        }
        
        @Test
        public void TestStep_21_verifyStudentLaunchesFlashcardsAppFromAppsMenu(){
            Reporter.log("Test_21 : Verify Student is able to Launch Flashcards App ",true);
            test.DashBoardPage.clickOnAppByName("Flashcards");
            test.MTXFramePage.switchToDockIFrame(FlashcardTitle);
            test.MTXDashBoardPage.verifyFlashcardApp();
            Reporter.log(user+"  successfully Launched Flashcards App From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();     
            Reporter.log("Successfully Closed Flashcards App",true);
        }
        
        @Test
        public void TestStep_22_verifyStudentLaunchesGlossaryAppFromAppsMenu(){
            Reporter.log("Test_22 : Verify Student is able to Launch Glossary App ",true);
            test.DashBoardPage.clickOnAppByName("Glossary");
            test.MTXFramePage.switchToDockIFrame(GlossaryTitle);
            test.MTXDashBoardPage.verifyGlossaryApp();
            Reporter.log(user+"  successfully Launched Glossary App From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();     
            Reporter.log("Successfully Closed Glossary App",true);
        }

        
        @Test
        public void TestStep_23_verifyStudentLaunchesFullbookAppFromAppsMenu(){
            Reporter.log("Test_23 : Verify Student is able to Launch Fullbook App ",true);
            test.DashBoardPage.clickOnAppByName("Full Book");
            test.MTXFramePage.switchToDockIFrame(FullbookTitle);
            test.MTXDashBoardPage.verifyFullBookApp();
            Reporter.log(user+"  successfully Launched  Fullbook App From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();     
            Reporter.log("Successfully Closed Fullbook App",true);
        }
        
        @Test
        public void TestStep_24_verifyStudentLaunchesMerriamWebsterDictionaryAppFromAppsMenu(){
            Reporter.log("Test_24 : Verify Student is able to Launch Merriam Webster Dictionary App ",true);
            test.DashBoardPage.clickOnAppByName("Merriam-Webster's Dictionary");
            test.MTXFramePage.MerriamWebsterDictionaryFrame();
            test.MTXDashBoardPage.verifyMerriamWebsterDictionaryAppLaunch();
            Reporter.log(user+" successfully Launched  Merriam Webster Dictionary App From AppsMenu",true);
            test.DashBoardPage.closeOpenApp();     
            Reporter.log("Student Successfully Closed Merriam Webster Dictionary App",true);
        }
        
         
        @Test
        public void TestStep_25_verifyStudentLogoutFromMTXAmGovtCourse(){
            Reporter.log("Test_25 : Verify Student is able to Log Out from MTX American Government  ",true);
            test.MTXDashBoardPage.verifyLogOutFromMTXCourse();
            Reporter.log("Student has successfully Logged Out from MTX American Government Course",true);
            
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