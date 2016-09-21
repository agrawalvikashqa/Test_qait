/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.AmericanGovernment.Mindapps.StudyCenter;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
/**
 *
 * @author amitkashyap
 */
public class TC02_StudentStudyCenterTestFlow {
    
    TestSessionInitiator test;
        String user;
        static String scoreFromActivity = null;
        
        @BeforeClass
        public void start_test_session() {
        test = new TestSessionInitiator("American Government Study Center Regression Test");
        user = System.getProperty("user", "student");
        
    }

	@Test
    public void TestStep_01_LoginToSSOApplication() {
        Reporter.log("Test_01 : Verify Student logs into Mindtap Application",true);
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAmGovt.CourseKey"),getData("Books.courseAmGovt.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
     @Test
	public void TestStep_02_LaunchStudyCenter () {
		// Launch StudyCenter
		Reporter.log("Test_02 : Verify Student is able to Launch Study Center",true);
		test.MTXDashBoardPage.clickOnAppByName("Study Center");
	}
    @Test
	public void TestStep_03_OverviewOfStudyCenter  () {
		// Overview Of StudyCenter
		Reporter.log("Test_03 : Verify Overview Of Study Center",true);
		test.MTXFramePage.switchToDockIFrame(getData("Books.courseAmGovt.StudycenterTitle"));
                test.MTXStudyCenterPage.verifyStudyCenter();
	}
    @Test
	public void TestStep_04_HelpOverlayIcon () {
		// Help Overlay Icon
		Reporter.log("Test_04 : Verify Help Overlay Icon",true);
                test.MTXStudyCenterPage.clickOnHelpOverlay();
	}
    @Test
	public void TestStep_05_OverviewOfQuizMeSection() {
		// Overview Of QuizMe Section
		Reporter.log("Test_05 : Verify Overview Of QuizMe Section",true);
                test.MTXStudyCenterPage.quizMeOverView();
	}
    @Test
	public void TestStep_06_GeneratesPracticeQuiz() {
		// Generates Practice Quiz
		Reporter.log("Test_06 : Verify Student Generates Practice Quiz",true);
                test.MTXStudyCenterPage.practiceQuiz();
	}
        @Test
	public void TestStep_07_OverviewOfPracticeQuiz() {
		// Overview Of Practice Quiz
		Reporter.log("Test_07 : Verify Overview Of Practice Quiz",true);
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseAmGovt.StudycenterTitle"));
                test.MTXStudyCenterPage.overviewOfQuiz();
                test.MTXFramePage.switchToStudyCenterQuizFrame();
                test.MTXStudyCenterPage.overviewOfQuizQuestions();
	}
        @Test
	public void TestStep_08_InProgressIconOfQuiz() {
		// InProgress Icon Of Quiz
		Reporter.log("Test_08 : Verify In Progress Icon Of Quiz",true);
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseAmGovt.StudycenterTitle"));
                test.MTXStudyCenterPage.saveForLaterButton();
	}
        @Test
	public void TestStep_09_FinishQuiz() {
		// Finish Quiz
		Reporter.log("Test_09 : Verify Student is able to Finish Quiz",true);
                test.MTXStudyCenterPage.reOpenInProgressQuiz();
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseAmGovt.StudycenterTitle"));
                test.MTXStudyCenterPage.finishQuiz();
	}
        @Test
	public void TestStep_10_QuizMeResultPage() {
		// QuizMe Result Page
		Reporter.log("Test_10 : Verify Quiz Me Result Page",true);
                test.MTXStudyCenterPage.quizMeResultPage();
	}
        @Test
	public void TestStep_11_RetakeQuiz() {
		// Retake Quiz
		Reporter.log("Test_11 : Verify Retake Quiz",true);
                test.MTXStudyCenterPage.retakeQuiz();
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseAmGovt.StudycenterTitle"));
                test.MTXStudyCenterPage.verifyRetake();
	}
        @Test
	public void TestStep_12_SubmittedStatusIndicator() {
		// Submitted Status Indicator
		Reporter.log("Test_12 : Verify Submitted Status Indicator",true);
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
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseAmGovt.StudycenterTitle"));
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
    @BeforeMethod
	public void init() {
		System.out.println("\n\n__________________________________________________________________________");
	}

    @AfterMethod
        public void takeScreenshotonFailure(ITestResult result) {
                test.takescreenshot.takeScreenShotOnException(result);
    }
    
    
    
}
