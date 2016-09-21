/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.BasePageActions;
import com.qait.automation.utils.PropFileHandler;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 *
 * @author nikitaaggarwal
 */
public class MTXIntroAndQuickPrepActivityPageAction extends BasePageActions{
    
    public MTXIntroAndQuickPrepActivityPageAction(WebDriver driver) {
        super(driver, "MTXIntroAndQuickPrepPage");
    } 
    String currentScore;
    String classAverage;
    String possibleScore;
    String backVerify = "Question 1";
    
    public void verifyPreparationTabIsPresentForIntroAndQuickPrep() {
		      switchToDefaultContent();
                      switchToFrame(element("getFrame_Content"));
                      switchToFrame("easyXDM_activityService_cxp_Target_provider");
                      waitForDomToLoad();
		isElementDisplayed(element("checkPreparationStatus"));
		waitTOSync();
	}
    public void verifyCurrentScorePresentForIntroAndQuickPrep() {
		      switchToDefaultContent();
                      switchToFrame(element("getFrame_Content"));
                      switchToFrame("easyXDM_activityService_cxp_Target_provider");
                      waitForDomToLoad();
		isElementDisplayed(element("currentScore"));
		waitTOSync();
	}
    public void verifyAttemptQuestions() {
		isElementDisplayed(element("nextbtn"));
                element("nextbtn").click();
		waitTOSync();
                isElementDisplayed(element("checkbox1"));
                element("checkbox1").click();
                isElementDisplayed(element("checkbox2"));
                element("checkbox2").click();
                String autoSave= element("autoSave").getText();
                Reporter.log(autoSave + "is displaying at the middle of activity footer");
                isElementDisplayed(element("checkbox3"));
                element("checkbox3").click();
                    System.out.println("user is able to attempt the activity");
	}
    public void submitAnswerButton(){
        isElementDisplayed(element("submitAnswer"));
                element("submitAnswer").click();
                if(isElementDisplayed(element("submitAnswer"))){
                    element("submitAnswer").click();
                }
    }
    public void getTitleOfFeedback() {
		waitTOSync();
		isElementDisplayed(element("feedback_title"));
		String feedback = element("feedback_title").getText();
		System.out.println("Feedback Title:->" + feedback);
	}
    public void VerifyAttemptsAndTryAnotherVersion() {
		waitTOSync();
		isElementDisplayed(element("tryAnotherVersion"));
		System.out.println("Try Another Version button is present");
                isElementDisplayed(element("unlimitedAttempts"));
		System.out.println("Unlimited Attempts Text is present");
	}
    public String FetchCurrentScoreFromCurrentScoreWidget() {
		waitTOSync();
		isElementDisplayed(element("currentScoreDashboard"));
                currentScore = element("currentScoreDashboard").getText();
                System.out.println("Current Score:" +currentScore);
                return currentScore;
	}
    public void VerifyCurrentScoreFromCurrentScoreWidget(String currentScore) {
		waitTOSync();
		isElementDisplayed(element("currentScoreDashboard"));
                String currentScore1 = element("currentScoreDashboard").getText();
                System.out.println(currentScore1);
                if(currentScore1==currentScore){
                    System.out.println("there is no change in current course score ");
                }
	}
    public void FetchClassAverageFromClassAverageWidget() {
		waitTOSync();
		isElementDisplayed(element("classAverage"));
                classAverage = element("classAverage").getText();
                System.out.println("Class Average :"+classAverage);       
	}
    public void VerifyClassAverageFromClassAverageWidget() {
		waitTOSync();
		isElementDisplayed(element("classAverage"));
                String classAverage1 = element("classAverage").getText();
                System.out.println(classAverage1);
                if(currentScore==classAverage1){
                    System.out.println("there is no change in class average.");
                }
	}
    public void VerifyNextButton() {
		waitTOSync();
		isElementDisplayed(element("nextbtn"));
		System.out.println("Next Button is present");
                do{    
                    element("nextbtn").click();
                    Reporter.log("On clicking next button user is navigating to next question.");
                }
                while(elementsWithOutWait("disableBackBtn").size()==1);
                Reporter.log("Next Button is disabled now");
	}
     public void VerifyBackButton(String actName) {
		waitTOSync();
		isElementDisplayed(element("disableBackBtn"));
		Reporter.log("Back Button is disabled");
                isElementDisplayed(element("nextbtn"));
                element("nextbtn").click();
                isElementDisplayed(element("backBtn"));
		Reporter.log("Back button is enabled now");
                element("backBtn").click();
                isElementDisplayed(element("backVerification", actName));
                Reporter.log("On clicking Back button user is navigating to previous question.");
	}
     
     public void VerifyBackButton() {
        
		waitTOSync();
		isElementDisplayed(element("disableBackBtn"));
		Reporter.log("Back Button is disabled");
                isElementDisplayed(element("nextbtn"));
                element("nextbtn").click();
                isElementDisplayed(element("backBtn"));
		Reporter.log("Back button is enabled now");
                element("backBtn").click();
                isElementDisplayed(element("backVerification",backVerify));
                Reporter.log("On clicking Back button user is navigating to previous question.");
	}
     
     public String VerifySubmitForGrading() {
		waitTOSync();
                switchToDefaultContent();
                switchToFrame(element("getFrame_Content"));
                switchToFrame("easyXDM_activityService_cxp_Target_provider");
		isElementDisplayed(element("link_submitForIntro"));
                element("link_submitForIntro").click();
                System.out.println("User is navigated to submit for grading tab.");
		isElementDisplayed(element("SubmitActivity"));
                isElementDisplayed(element("currentScoreSubmit"));
                isElementDisplayed(element("possibleScoreInActivity"));
                possibleScore = element("possibleScoreInActivity").getText();
                Reporter.log("Possible Score of activity is:" + possibleScore);
                PropFileHandler.writeProperty("activityScore", possibleScore);
                return possibleScore;
	}
     public void VerifyActivitySubmission() {
		waitTOSync();
		isElementDisplayed(element("SubmitActivity"));
                element("SubmitActivity").click();
                System.out.println("Activity gets submitted.");
                switchToDefaultContent();
	}
     public void verifyMultipleTakes(){
         waitTOSync();
                switchToDefaultContent();
                switchToFrame(element("getFrame_Content"));
                switchToFrame("easyXDM_activityService_cxp_Target_provider");
		isElementDisplayed(element("link_submitForIntro"));
                element("link_submitForIntro").click();
                System.out.println("User is navigated to submit for grading tab.");
		if(elementsWithOutWait("SubmitActivity").size()==1){
                    Reporter.log("Instructor have multiple takes for single activity");
                }
     }
     public void VerifyActivityInReviewMode() {
		waitTOSync();
                switchToDefaultContent();
                switchToFrame(element("getFrame_Content"));
                switchToFrame("easyXDM_activityService_cxp_Target_provider");
		isElementDisplayed(element("link_submitForIntro"));
                element("link_submitForIntro").click();
                System.out.println("User is navigated to submit for grading tab.");
                Reporter.log(element("submittedText").getText()+ "is displaying in Submit Activity for Grading page");
                Assert.assertFalse(CheckforSubmitActivityForGradingNotAppearInReviewMode());
		
	}
     public boolean CheckforSubmitActivityForGradingNotAppearInReviewMode(){
         wait.hardWait(2);
        try{
            element("SubmitActivity");
            return true;
        
        }
        catch(Exception e){
            return false;
        }
     }
}
