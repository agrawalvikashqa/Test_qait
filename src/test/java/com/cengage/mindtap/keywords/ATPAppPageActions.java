/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.keywords;

import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author priyamdixit
 */
public class ATPAppPageActions  extends BasePageActions{
    String[] chaptersName = new String[36];
    private int correctQueCount=0;
    private int inCorrectQueCount=0;
    private int UnattemptedCount=0;
    private String QuestionCount;
    public ATPAppPageActions(WebDriver driver) {
        super(driver, "ATPAppPage");
    }
    
    
    public void createATest(String QuestionCount) {
         navigateToHomeInATPAppfromAppDock();
         element("CreateANewTestBtn").click();
         elements("ChapterTestCheckBoxes");
         int i=0;//For Loop Counter
         int quecount=Integer.parseInt(QuestionCount);
         
         for(WebElement ChapterTestCheckBoxes:elements("ChapterTestCheckBoxes")){
         ChapterTestCheckBoxes.click();
         /*
         1. Storing all the Selected Chapters in An String Array.
         */
         chaptersName[i]=element("chaptersNames",Integer.toString(i+1)).getText().toString();
        
         ReportMsg.info("User Select " +chaptersName[i]+ " Chapter");
         ++i;
         if(Integer.parseInt(element("totalSelectedItems").getText()) > quecount){
             break;
           }
         }
        element("QuestionCount").clear();
        element("QuestionCount").sendKeys(QuestionCount);
        element("takeTestNow_btn").click();
      
    }
    public void AttemptTheCreatedTest(String QuestionCount) {
        AttemptTheCreatedTest(QuestionCount, "0");
    }
    public void AttemptTheCreatedTest(String QuestionCount,String AttemptQueCount){
        AttemptQuestions(AttemptQueCount);
        element("dropdown-toggle").click();
        element("navigateToPage",Integer.toString(Integer.parseInt(QuestionCount)-correctQueCount)).click();
        element("disablednextBtn");
        element("submitAndReviewBtn").click();
        waitForElementPresent("submitBtn");
        element("submitBtn").click();
        element("pastAttemptsTabTitle");
        ReportMsg.info("Verifed User Successfully Attempt The Attempt Test and land on Past Attempts Tab ");
    } 
    
    void navigateToHomeInATPAppfromAppDock(){
        try{
            element("homeBtn").click();
            element("previewtabtitle");
            ReportMsg.info("Completed Navigate To Home In ATP App");
          } 
      catch(Exception e){
           ReportMsg.info("Already into Home Page of ATP app");
       }
        
     }
    /*
    1. Go to Home of ATP app
    2. Navigate To Past Attempts Tab
    */
    void navigateToPastAttemptsTab(){
        navigateToHomeInATPAppfromAppDock();
        element("pastAttemptsbtn").click();
        element("pastAttemptsTabTitle");
        
     }
    public void ReAttemptTheLastCreatedTest(String AttemptQueCount){
       countOfCorrectInCorrectAndUnattemptedQuestions();
       QuestionCount=Integer.toString(correctQueCount+inCorrectQueCount+UnattemptedCount);
        ReportMsg.info("Total Quetion Count :-"+QuestionCount);
       navigateToPastAttemptsTab();
       reAttemptTestByNewSequenceBasedonPriorChapter();
       AttemptTheCreatedTest(QuestionCount,AttemptQueCount);
       /*
       If all the Quetion are Attempted Correctly then 
       Re-Attempt Test With Only Incorrect Questions radio Button will not display.
       */
//       countOfCorrectInCorrectAndUnattemptedQuestions();
//       QuestionCount=Integer.toString(correctQueCount+inCorrectQueCount+UnattemptedCount);
//        ReportMsg.info("Total Quetion Count :-"+QuestionCount);
//       if(correctQueCount!=Integer.parseInt(QuestionCount)){
//       navigateToPastAttemptsTab();
//       reAttemptTestWithOnlyIncorrectQuestions();
//       AttemptTheCreatedTest(QuestionCount);}
//       else{
//            ReportMsg.info("User Can not Select <All InCorrect Quetion> Attempt option as there were ALl correct answerd questions.");
//       }
        /*
       If No Quetion are Attempted Correctly then 
       Re-Attempt Test With Only correct Questions radio Button will not display.
       */
       countOfCorrectInCorrectAndUnattemptedQuestions();
       QuestionCount=Integer.toString(correctQueCount+inCorrectQueCount+UnattemptedCount);
        ReportMsg.info("Total Quetion Count :-"+QuestionCount);
       if(correctQueCount!=0){
       navigateToPastAttemptsTab();
       reAttemptTestWithOnlyCorrectQuestions();
       AttemptTheCreatedTest(QuestionCount);}
       else{
            ReportMsg.info("User Can not Select <All Correct Quetion> Attempt option as there were NO correct answerd questions.");
       }
       countOfCorrectInCorrectAndUnattemptedQuestions();
       QuestionCount=Integer.toString(correctQueCount+inCorrectQueCount+UnattemptedCount);
       ReportMsg.info("Total Quetion Count :-"+QuestionCount);
       navigateToPastAttemptsTab();
       reAttemptTestWithAllQuestions();
       AttemptTheCreatedTest(QuestionCount);

       
    }

    private void reAttemptTestWithAllQuestions() {
        executeJavascript("document.getElementsByClassName('btn btn-primary pull-right ng-scope')[0].click();");
        //clickOnElementUsingActionBuilder(element("retakeButton"));
//element("retakeButton").click();
        selectRetakecriteria("All");
        ReportMsg.info("User Selects <All Quetion> Attempt option");
        
    }

    private void reAttemptTestWithOnlyCorrectQuestions() {
             executeJavascript("document.getElementsByClassName('btn btn-primary pull-right ng-scope')[0].click();");      
//element("retakeButton").click();
        selectRetakecriteria("Correct");
        ReportMsg.info("User Selects <All Correct Quetion> Attempt option");
    }

    private void reAttemptTestWithOnlyIncorrectQuestions() {
        waitTOSync();
         executeJavascript("document.getElementsByClassName('btn btn-primary pull-right ng-scope')[0].click();");
//clickOnElementUsingActionBuilder(element("retakeButton"));
      //  element("retakeButton").click();
        selectRetakecriteria("Incorrect");
        ReportMsg.info("User Selects <All InCorrect Quetion> Attempt option");
    }

    private void reAttemptTestByNewSequenceBasedonPriorChapter() {
 executeJavascript("document.getElementsByClassName('btn btn-primary pull-right ng-scope')[0].click();");       
// clickOnElementUsingActionBuilder(element("retakeButton"));       
// element("retakeButton").click();
        selectRetakecriteria("Chapter");
        ReportMsg.info("User Selects <NewSequenceBasedonPriorChapter> Attempt option");
    }

    private void selectRetakecriteria(String criteria) {
        element("Retakecriteria",criteria).click();
        element("takeTestNowButton").click();
    }

    private void countOfCorrectInCorrectAndUnattemptedQuestions() {
        navigateToPastAttemptsTab();
        try{
        correctQueCount=elements("attemptedQuestion","success").size();
        ReportMsg.info("Number of Correct Answered Questions:- " + correctQueCount);
        }
        catch(Exception e){ReportMsg.info("No Correct Answered Questions");}
        
        try{
        inCorrectQueCount=elements("attemptedQuestion","error").size();
        ReportMsg.info("Number of InCorrect Answered Questions:- " + inCorrectQueCount);
        }
        catch(Exception e){ReportMsg.info("No InCorrect Answered Questions");}
        
        try{
        UnattemptedCount=elements("attemptedQuestion","info").size();
        ReportMsg.info("Number of Unattempted Questions:- " + UnattemptedCount);
        }
        catch(Exception e){ReportMsg.info("No Unattempted  Questions");}
     
    }

   
    private void AttemptQuestions(String AttemptQueCount) {
       int QueCount=Integer.parseInt(AttemptQueCount);
        for (int i = 0; i < QueCount; i++) {
            waitForElementPresent("CurrentTest_Radio");
            //clickOnElementUsingActionBuilder(element("CurrentTest_Radio"));
            waitTOSync();
            element("CurrentTest_Radio").click();
            try{
            element("Next_Btn ").click();}
            catch(Exception e){
                 ReportMsg.info("Test End Reached");
                 break;
            }
        }
    }

    public boolean VerifyInlineVideos() {
        navigateToPastAttemptsTab();
        element("attemptedQuestionwithIndex","info").click();
        element("inLineVideo_Img").click();
        element("dismiss_btn").click();
        element("attemptedQuestionwithIndex","info").click();
        return true;
         }

    public boolean VerifyFeedbackOfCorrectAnsweredQuestion() {
        navigateToPastAttemptsTab();
        try{
            element("attemptedQuestionwithIndex","success").click();
        }
        catch(Exception e){
            ReportMsg.info("There is No Correct Answered Question");
            return true;
        }
        return isElementDisplayed("Feedback_text");
       
    }
     public boolean VerifyFeedbackOfInCorrectAnsweredQuestion() {
        navigateToPastAttemptsTab();
        
        try{
            element("attemptedQuestionwithIndex","error").click();
        }
        catch(Exception e){
            ReportMsg.info("There is No InCorrect Answered Question");
            return true;
        }
        return isElementDisplayed("Feedback_text");
    }
 public void clickOnTexteReader() {
        navigateToPastAttemptsTab();
        element("attemptedQuestionwithIndex","info").click();
        element("eReader_link").click();
        
    }
    public boolean VerifyTexteReader() {
        navigateToPastAttemptsTab();
        switchToDefaultContent();
        return isElementDisplayed("dockFrameTitle");
    }

    public void clickOnCloseBtn(String appIndex) {
        element("close_Btn",appIndex).click();
    }

      
}
