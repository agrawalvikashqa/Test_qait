package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.BasePageActions;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MTXStudyCenterPageAction extends BasePageActions {

    public MTXStudyCenterPageAction(WebDriver driver) {
        super(driver, "MTXStudyCenterPage");
    }
    CharSequence maxQuestion = String.valueOf(51);
    CharSequence questions = String.valueOf(50);
    CharSequence correctQuestions = String.valueOf(10);
    String maxText = "Max. 50 questions";
    String moreUnitText = "Add units to have more questions";
    String studyGuideTitle = "Test";

    public void verifyStudyCenter() {
        Assert.assertTrue(isElementDisplayed(element("quizMe_txt")), "QuizMe is not present in study center");
        Assert.assertTrue(isElementDisplayed(element("studyGuide_txt")), "Study Guides are not present in study center");
        Assert.assertTrue(isElementDisplayed(element("performance_txt")), "'Performance by Unit and Concept' are not present in study center");
        Assert.assertTrue(isElementDisplayed(element("helpOverlay_btn")), "Help button is not present in study center");
        Reporter.log("Study Center Contains Quiz Me, Study Guides, Performance By Unit and Concept and Help Overlay");

    }

    public void clickOnHelpOverlay() {
        isElementDisplayed(element("helpOverlay_btn"));
        element("helpOverlay_btn").click();
        Assert.assertTrue(isElementDisplayed(element("helpOverlay_content")), "Help Overlay Page is not displaying in study center");
        Reporter.log("On clicking the help overlay icon the help overlay page displays");
        element("closeHelpOverlay").click();
    }

    public void quizMeOverView() {
        Assert.assertTrue(isElementDisplayed(element("createQuiz_btn")), "'Create a new Quiz' button is not displaying in QuizMe section");
        Assert.assertTrue(isElementDisplayed(element("quizTitle_section")), "'Quiz Title' section is not displaying in QuizMe section");
        Assert.assertTrue(isElementDisplayed(element("dateCreated_section")), "'Date Created' section is not displaying in study center");
        Reporter.log("Quiz me section displays Quiz Tittle and Date created information.");
    }

    public void practiceQuiz() {
        element("createQuiz_btn").click();
        clickOnElementUsingActionBuilder(element("quizUnit"));
        element("questionNumbers").click();
        element("questionNumbers").clear();
        element("questionNumbers").sendKeys(maxQuestion);
        Assert.assertTrue(isElementDisplayed(element("maxQuestions_txt")), "'Max. 50 questions' is not displaying on creating quiz");
        if (element("maxQuestions_txt").getText().contains(maxText)) {
            Reporter.log("if user crosses the upper limit of questions, message displays: " + maxText);
        }
        element("questionNumbers").clear();
        element("questionNumbers").sendKeys(questions);
        Assert.assertTrue(isElementDisplayed(element("maxQuestions_txt")), "Text to add more units is not displaying on creating quiz");
        if (element("maxQuestions_txt").getText().contains(moreUnitText)) {
            Reporter.log("On cross limit of questions present in a unit, message displays: " + moreUnitText);
        }
        element("questionNumbers").clear();
        element("questionNumbers").sendKeys(correctQuestions);
        element("takeQuiz_btn").click();
        wait.hardWait(8);
        handleAlert();
        Reporter.log("User is able to generates a practice quiz");
    }

    public void overviewOfQuiz() {
        String quizHead = element("quizTitle_head").getText();
        String quizTitle = element("quizTitle_txt").getText();
        Reporter.log("User added: " + quizHead + quizTitle);
        Assert.assertTrue(isElementDisplayed(element("finishBtn")), "Finish Button is present in Quiz");
        Assert.assertTrue(isElementDisplayed(element("saveForLater_txt")), "Save for Later Button is present in Quiz");

    }

    public void overviewOfQuizQuestions() {
        int countOfQuestions = elements("countOfQuestions").size();
        if (countOfQuestions == Integer.parseInt(correctQuestions.toString())) {
            Reporter.log("Quiz page contains the number of Questions provided by user : " + countOfQuestions);
        }
        switchToDefaultContent();
    }

    public void saveForLaterButton() {
        element("saveForLater_txt").click();
        wait.hardWait(4);
        Reporter.log("User clicked on Save For Later Button");
        Assert.assertTrue(isElementDisplayed("quizInProgress_icon"), "Quiz in Progress icon in missing");
        Reporter.log("Status indicator is in-progress when user saves the Quiz");
    }

    public void reOpenInProgressQuiz() {
        element("openQuiz").click();
        Reporter.log("User has reopened In progress Quiz To attempt");
        wait.hardWait(2);
        handleAlert();
    } //one part needs to cover

    public void finishQuiz() {
        wait.hardWait(2);
        element("finishBtn").click();
        Reporter.log("User Clicked on Finish button to submit Quiz");
    }

    public void quizMeResultPage() {
        wait.hardWait(4);
        Assert.assertTrue(isElementDisplayed("retakeBtn"), "Retake Button is not present");
        Assert.assertTrue(isElementDisplayed("closeQuizBtn"), "Close Button is not present");
        int countOfQuestionResults = elements("questionResults").size();
        if (countOfQuestionResults == Integer.parseInt(correctQuestions.toString())) {
            Reporter.log("Quiz page contains the number of Questions provided by user : " + countOfQuestionResults);
            Assert.assertTrue(isElementDisplayed("collapseForm"), "All the attempted Questions information is not in collapsed form");
            Reporter.log("All the attempted Questions information is in collapsed form");
            element("expand_click").click();
            Assert.assertTrue(isElementDisplayed("expandedForm"), "+ icon is not working");
            Reporter.log("Collpase/ Expand is working fine in QuizMe Result page");
            Assert.assertTrue(isElementDisplayed("quizSocre"), "Quiz Score is not displaying");
            String quizResult = element("quizSocre").getText();
            Reporter.log("Quiz result is :" + quizResult);
        }
    }

    public void retakeQuiz() {
        element("retakeBtn").click();
        wait.hardWait(8);
        handleAlert();

    }

    public void verifyRetake() {
        Assert.assertTrue(isElementDisplayed(element("finishBtn")), "Finish Button is present in Quiz");
        Assert.assertTrue(isElementDisplayed(element("saveForLater_txt")), "Save for Later Button is present in Quiz");
        Reporter.log("On Clicking the Retake button a the Quiz is again generated ");
    }

    public void submittedStatusOfQuiz() {
        element("finishBtn").click();
        waitTOSync();
        clickOnElementUsingActionBuilder(element("closeQuizBtn"));
        //element("closeQuizBtn").click();
        Assert.assertTrue(isElementDisplayed("quizSubmitted_icon"), "Submitted status icon is not displaying");
        Reporter.log("status indicator is submitted (Blue circle with white tick) after Finishing the Quiz");
    }

    public void deleteQuiz() {
        hover(element("openQuiz"));
        element("deleteQuiz").click();
        Reporter.log("User deleted the Quiz");
    }

    public void unitStudyGuideChem() {
        // scrollDown(element("unitStudyGuide"));
        Assert.assertTrue(isElementDisplayed(element("unitStudyGuide")), "Unit Study Guide is not present in study center.");
        clickOnElementUsingActionBuilder(element("unitStudyGuide"));
        wait.hardWait(4);
        Assert.assertTrue(isElementDisplayed(element("keyTerms_txt")), "KeyTerms are not present in Unit Study Guide");
        Assert.assertTrue(isElementDisplayed(element("keyEquations_txt")), "KeyEquations are not present in Unit Study Guide");
        Assert.assertTrue(isElementDisplayed(element("keyConcepts")), "KeyConcepts are not present in Unit Study Guide");
        element("closeStudyGuide").click();
    }

    public void unitStudyGuideHis() {

        Assert.assertTrue(isElementDisplayed(element("unitStudyGuide")), "Unit Study Guide is not present in study center.");
        element("unitStudyGuide").click();
        wait.hardWait(6);
        Assert.assertTrue(isElementDisplayed(element("timeline_txt")), "Timeline are not present in Unit Study Guide");
        Assert.assertTrue(isElementDisplayed(element("topic_txt")), "Topic are not present in Unit Study Guide");
        Assert.assertTrue(isElementDisplayed(element("keyTerms_His")), "Key Terms are not present in Unit Study Guide");
        element("closeStudyGuide").click();
    }

    public void createCustomStudyGuideWithKeyEquations() {
        element("studyGuideCreate").click();
        waitTOSync();
        Reporter.log("User clicked on create a custom study guide button");
        element("keyEquations_chkBox").click();
        element("studyGuideName").click();
        element("studyGuideName").clear();
        element("studyGuideName").sendKeys(studyGuideTitle);
        element("saveStudyGuide").click();
        wait.hardWait(6);
        Assert.assertTrue(isElementDisplayed(element("keyEquations_txt")), "KeyEquations are not present in Unit Study Guide");
    }

    public void createCustomStudyGuideWithKeyConcepts() {
        element("studyGuideCreate").click();
        waitTOSync();
        Reporter.log("User clicked on create a custom study guide button");
        element("keyConcepts_chkBox").click();
        element("studyGuideName").click();
        element("studyGuideName").clear();
        element("studyGuideName").sendKeys(studyGuideTitle);
        element("saveStudyGuide").click();
        wait.hardWait(6);
        Assert.assertTrue(isElementDisplayed(element("keyConcepts")), "Key Concepts are not present in Unit Study Guide");
    }
    public void createCustomStudyGuideWithTimeline() {
        element("studyGuideCreate").click();
        waitTOSync();
        Reporter.log("User clicked on create a custom study guide button");
        element("timeline_chkBox").click();
        element("studyGuideName").click();
        element("studyGuideName").clear();
        element("studyGuideName").sendKeys(studyGuideTitle);
        element("saveStudyGuide").click();
        wait.hardWait(6);
        Assert.assertTrue(isElementDisplayed(element("timeline_txt")), "Key Concepts are not present in Unit Study Guide");
    }
    public void createCustomStudyGuideWithTopics() {
        element("studyGuideCreate").click();
        waitTOSync();
        Reporter.log("User clicked on create a custom study guide button");
        element("topics_chkBox").click();
        element("studyGuideName").click();
        element("studyGuideName").clear();
        element("studyGuideName").sendKeys(studyGuideTitle);
        element("saveStudyGuide").click();
        wait.hardWait(6);
        Assert.assertTrue(isElementDisplayed(element("topic_txt")), "Key Concepts are not present in Unit Study Guide");
    }

    public void closeAndDeleteCustomStudyGuide() {
        element("closeStudyGuide").click();
        wait.hardWait(6);
        hoverUsingJS(element("userStudyGuide"));
        element("deleteStudyGuide").click();
    }

    public void createCustomStudyGuideWithKeyTerms() {
        element("studyGuideCreate").click();
        waitTOSync();
        Reporter.log("User clicked on create a custom study guide button");
        element("keyTerms_chkBox").click();
        element("studyGuideName").click();
        element("studyGuideName").clear();
        element("studyGuideName").sendKeys(studyGuideTitle);
        element("saveStudyGuide").click();
        wait.hardWait(6);
        Assert.assertTrue(isElementDisplayed(element("keyTerms_txt")), "Key Terms are not present in Unit Study Guide");
    }
    public void createCustomStudyGuideWithKeyTermsInHistory() {
        element("studyGuideCreate").click();
        waitTOSync();
        Reporter.log("User clicked on create a custom study guide button");
        element("keyTerms_chkBox").click();
        element("studyGuideName").click();
        element("studyGuideName").clear();
        element("studyGuideName").sendKeys(studyGuideTitle);
        element("saveStudyGuide").click();
        wait.hardWait(6);
        Assert.assertTrue(isElementDisplayed(element("keyTerms_hisTxt")), "Key Terms are not present in Unit Study Guide");
    }

    public void createCustomStudyGuideWithFlashcards() {
        element("studyGuideCreate").click();
        waitTOSync();
        Reporter.log("User clicked on create a custom study guide button");
        element("flashcard_chkbox").click();
        element("studyGuideName").click();
        element("studyGuideName").clear();
        element("studyGuideName").sendKeys(studyGuideTitle);
        element("saveStudyGuide").click();
        wait.hardWait(6);
        Assert.assertTrue(isElementDisplayed(element("flashacrd_txt")), "Flashcards are not present in Unit Study Guide");
    }

    public void createCustomStudyGuideWithHighlights() {
        element("studyGuideCreate").click();
        waitTOSync();
        Reporter.log("User clicked on create a custom study guide button");
        element("highlights_chkbox").click();
        element("studyGuideName").click();
        element("studyGuideName").clear();
        element("studyGuideName").sendKeys(studyGuideTitle);
        element("saveStudyGuide").click();
        wait.hardWait(6);
        Assert.assertTrue(isElementDisplayed(element("highlights_txt")), "Highlights are not present in Unit Study Guide");
    }

    public void createCustomStudyGuideWithNotes() {
        element("studyGuideCreate").click();
        waitTOSync();
        Reporter.log("User clicked on create a custom study guide button");
        element("notes_chkBox").click();
        element("studyGuideName").click();
        element("studyGuideName").clear();
        element("studyGuideName").sendKeys(studyGuideTitle);
        element("saveStudyGuide").click();
        wait.hardWait(6);
        Assert.assertTrue(isElementDisplayed(element("notes_txt")), "Notes are not present in Unit Study Guide");
    }

    public void printStudyGuide() {
        Assert.assertTrue(isElementDisplayed(element("unitGuide_tab")));
    }
    public void practiceActivitiesInConcept() {
        Assert.assertTrue(isElementDisplayed(element("conceptActivity")));
        element("conceptActivity").click();
        Reporter.log("POP-up window opens on clicking on concept");
        wait.hardWait(4);
        Assert.assertTrue(isElementDisplayed(element("activityTitle")));
        Assert.assertTrue(isElementDisplayed(element("scoreInConcept")));
        Reporter.log("POP-up window contains the activities in the concept and Scores of the activity");
        Assert.assertTrue(isElementDisplayed(element("practiceActivity")));
        element("practiceActivity").click();
        wait.hardWait(20);
        switchToFrameWithOutDefault(element("activityFrame"));
        switchToFrame("easyXDM_activityService_cxp_Target_provider");
        Assert.assertTrue(isElementDisplayed(element("startPracticeActivity")));
        Reporter.log("Pop-up window contains Practice Button and on clicking the practice button student/Instructor is able to practice the activity.");
    }
}
