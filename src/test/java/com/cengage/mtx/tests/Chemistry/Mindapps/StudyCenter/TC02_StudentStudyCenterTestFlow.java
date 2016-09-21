
package com.cengage.mtx.tests.Chemistry.Mindapps.StudyCenter;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TC02_StudentStudyCenterTestFlow {
    
TestSessionInitiator test;
        String user;
        static String scoreFromActivity =null;
        
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Smoke Test");
        user = System.getProperty("user", "student");
        
    }

	@Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseChemistry.courseKey"),getData("Books.courseChemistry.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
     @Test
	public void TestStep_02_LaunchStudyCenter () {
		// Launch StudyCenter
		Reporter.log("Test 02: Launch Study Center",true);
		test.MTXDashBoardPage.clickOnAppByName("Study Center");
	}
    @Test
	public void TestStep_03_OverviewOfStudyCenter  () {
		// Overview Of StudyCenter
		Reporter.log("Test 03: Overview Of Study Center",true);
		test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.StudycenterTitle"));
                test.MTXStudyCenterPage.verifyStudyCenter();
	}
    @Test
	public void TestStep_04_HelpOverlayIcon () {
		// Help Overlay Icon
		Reporter.log("Test 04: Help Overlay Icon",true);
                test.MTXStudyCenterPage.clickOnHelpOverlay();
	}
    @Test
	public void TestStep_05_OverviewOfQuizMeSection() {
		// Overview Of QuizMe Section
		Reporter.log("Test 05: Overview Of QuizMe Section",true);
                test.MTXStudyCenterPage.quizMeOverView();
	}
    @Test
	public void TestStep_06_GeneratesPracticeQuiz() {
		// Generates Practice Quiz
		Reporter.log("Test 06: Generates Practice Quiz",true);
                test.MTXStudyCenterPage.practiceQuiz();
	}
    @Test
	public void TestStep_07_OverviewOfPracticeQuiz() {
		// Overview Of Practice Quiz
		Reporter.log("Test 07: Overview Of Practice Quiz",true);
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.StudycenterTitle"));
                test.MTXStudyCenterPage.overviewOfQuiz();
                test.MTXFramePage.switchToStudyCenterQuizFrame();
                test.MTXStudyCenterPage.overviewOfQuizQuestions();
	}
    @Test
	public void TestStep_08_InProgressIconOfQuiz() {
		// InProgress Icon Of Quiz
		Reporter.log("Test 08: InProgress Icon Of Quiz",true);
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.StudycenterTitle"));
                test.MTXStudyCenterPage.saveForLaterButton();
	}
    @Test
	public void TestStep_09_FinishQuiz() {
		// Finish Quiz
		Reporter.log("Test 09: Finish Quiz",true);
                test.MTXStudyCenterPage.reOpenInProgressQuiz();
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.StudycenterTitle"));
                test.MTXStudyCenterPage.finishQuiz();
	}
    @Test
	public void TestStep_10_QuizMeResultPage() {
		// QuizMe Result Page
		Reporter.log("Test 10: QuizMe Result Page",true);
                test.MTXStudyCenterPage.quizMeResultPage();
	}
    @Test
	public void TestStep_11_RetakeQuiz() {
		// Retake Quiz
		Reporter.log("Test 11: Retake Quiz",true);
                test.MTXStudyCenterPage.retakeQuiz();
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.StudycenterTitle"));
                test.MTXStudyCenterPage.verifyRetake();
	}
    @Test
	public void TestStep_12_SubmittedStatusIndicator() {
		// Submitted Status Indicator
		Reporter.log("Test 12: Submitted Status Indicator",true);
                test.MTXStudyCenterPage.submittedStatusOfQuiz();
	}
    @Test
	public void TestStep_13_DeleteQuiz() {
		// Delete Quiz
		Reporter.log("Test 13: Delete Quiz",true);
                test.MTXStudyCenterPage.deleteQuiz();
	}
    @Test
	public void TestStep_14_UnitStudyGuide() {
		// Unit Study Guide
		Reporter.log("Test 14: Unit Study Guide",true);
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.StudycenterTitle"));
                test.MTXStudyCenterPage.unitStudyGuideChem();
	}
    @Test
	public void TestStep_15_CustomStudyGuideWithKeyEquations() {
		// Custom Study Guide With Key Equations
		Reporter.log("Test 15: Custom Study Guide With Key Equations",true);
                test.MTXStudyCenterPage.createCustomStudyGuideWithKeyEquations();
                test.MTXStudyCenterPage.closeAndDeleteCustomStudyGuide();
	}
    @Test
	public void TestStep_16_CustomStudyGuideWithKeyConcepts() {
		// Custom Study Guide With Key Concepts
		Reporter.log("Test 16: Custom Study Guide With Key Concepts",true);
                test.MTXStudyCenterPage.createCustomStudyGuideWithKeyConcepts();
                test.MTXStudyCenterPage.closeAndDeleteCustomStudyGuide();
	}
    @Test
	public void TestStep_17_CustomStudyGuideWithKeyTerms() {
		// Custom Study Guide With Key Terms
		Reporter.log("Test 17: Custom Study Guide With Key Terms",true);
                test.MTXStudyCenterPage.createCustomStudyGuideWithKeyTerms();
                test.MTXStudyCenterPage.closeAndDeleteCustomStudyGuide();
	}
    @Test
	public void TestStep_18_CustomStudyGuideWithHighlights() {
		// Custom Study Guide With Highlights
		Reporter.log("Test 18: Custom Study Guide With Highlights",true);
                test.MTXStudyCenterPage.createCustomStudyGuideWithHighlights();
                test.MTXStudyCenterPage.closeAndDeleteCustomStudyGuide();
	}
    @Test
	public void TestStep_19_CustomStudyGuideWithFlashcards() {
		// Custom Study Guide With Flashcards
		Reporter.log("Test 19: Custom Study Guide With Flashcards",true);
                test.MTXStudyCenterPage.createCustomStudyGuideWithFlashcards();
                test.MTXStudyCenterPage.closeAndDeleteCustomStudyGuide();
	}
   @Test
	public void TestStep_20_CustomStudyGuideWithNotes() {
		// Custom Study Guide With Notes
		Reporter.log("Test 20: Custom Study Guide With Notes",true);
                test.MTXStudyCenterPage.createCustomStudyGuideWithNotes();
                test.MTXStudyCenterPage.closeAndDeleteCustomStudyGuide();
	}
    @Test
	public void TestStep_21_PrintStudyGuide() {
		// Print Study Guide
		Reporter.log("Test 21: Print Study Guide",true);
                test.MTXStudyCenterPage.printStudyGuide();
	}
        @Test
	public void TestStep_22_PracticeActivitiesInConcept() {
		// Practice Activities in concept
		Reporter.log("Test 22: Practice Activities in concept",true);
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.StudycenterTitle"));
                test.MTXStudyCenterPage.practiceActivitiesInConcept();
	}
    @BeforeMethod
	public void init() {
		System.out.println("\n\n__________________________________________________________________________");
	}

    @AfterMethod
        public void takeScreenshotonFailure(ITestResult result) {
                test.takescreenshot.takeScreenShotOnException(result);
    }
    
}
