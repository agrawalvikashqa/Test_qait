
package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.BasePageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MTXConceptualTutoredPageAction extends BasePageActions {
    
    public MTXConceptualTutoredPageAction(WebDriver driver) {
        super(driver, "MTXConceptualTutoredPage");
    }
    
    public void selectCreationType(String type){
        wait.hardWait(8);
        element("creationTypes", type).click();
        Reporter.log("Selected creation types" + type + "to add");
    }

    public void SelectActivity(){
        wait.hardWait(4);
        element("toggleArrow").click();
        
    }

    public void SelectActivity(String unit, String activity){
        wait.hardWait(4);
        element("toggleArrow").click();
        element("selectUnit", unit).click();
        Reporter.log("Select unit to add activity");
        element("selectActivity",activity).click();
        Reporter.log("Select activity" +activity+ "to add");
    }
    public void publishActivity(){
         wait.hardWait(2);
        element("publishActivity").click();
    }
    public void setDueDate(String month, String year, String date){
        waitTOSync();
        switchToDefaultContent();
        element("setDueDate").click();
        selectMonth(month,year);
        element("dueDate", date).click();
        element("donebtn").click();
        Reporter.log("User set due date of activity");
        }

    private void selectMonth(String month, String year) {
        
        while(true){
            if(element("dueMonth").getText().contains(month) && element("dueYear").getText().contains(year))
                break;
            else
                element("nextMonth").click();
    }
    }
    public void addActivityTitle(){
         String addTitle= "_Regression";
         clickOnElementUsingActionBuilder(element("activityTitle"));
        element("activityTitle").sendKeys(addTitle);
        Reporter.log("User entered activity title");
        }
        
        public void verifyCurrentScoreInConceptualTutored(){
            switchToDefaultContent();
		switchToFrame(element("getFrame_Content"));
                switchToFrame("easyXDM_activityService_cxp_Target_provider");
            isElementDisplayed(element("currentScore"));
            Reporter.log("Current score is displaying at the right corner of the activity pane.");
        }
        public void verifyUnAttemptedQuestionWarning(){
            switchToDefaultContent();
		switchToFrame(element("getFrame_Content"));
                switchToFrame("easyXDM_activityService_cxp_Target_provider");
		waitForSpinnerToDisappear();
		isElementDisplayed(element("submitForTutored"));
		element("submitForTutored").click();
                isElementDisplayed(element("SubmitActivity"));
		System.out.println("Clicking on Submit activiy for grading button");
		element("SubmitActivity").click();
                isElementDisplayed(element("warningMessage"));
                String warningMsg = element("warningMessage").getText();
                Reporter.log("Warning Message :" + warningMsg);
                element("warningClose").click();
        }
        public void verifyOpenCloseButtons(){
            element("navToAttempt").click();
           // isElementDisplayed(element("playVideo"));
            //element("playVideo").click();
            element("openProblemBtn").click();
            isElementDisplayed(element("closeProblem"));
            Reporter.log("Open problem/Close Problem buttons are displaying.");
            
        }
        public void AttemptTutoredActivity(){
            int i= elements("inputQuestions").size();
            for(int j=1; j<=i; j++){
               String n= String.valueOf(j);
                element("dropDown", n).click();
                waitTOSync();
                selectProvidedText(element("dropDown", n), "macroscopic");
            
            Reporter.log("User selected answer of question"+ n);
            }
        }
            public void submitAnswer(){
                element("submitAnswer").click();
                if(elementsWithOutWait("submitAnswer").size()==1){
                    element("submitAnswer").click();
                }
                Reporter.log("User Submits Answers");
        }
            public void checkRejoindersOfQuestions(){
                int n=elements("rejoinders").size();
                for(int i=1; i<=n; i++){
                    String j= String.valueOf(i);
                    isElementDisplayed(element("rejoindersValue", j));
                    Reporter.log("Correct / Incorrect rejoinders are displaying");
                    element("rejoindersValue", j).click();
                    element("rejoindersValue", j).click();
                    String value = element("popUpValue").getText();
                    Reporter.log("Value of Rejoinder is :"+ value);
                    element("closePopUp").click();
                    
                }
            }
            public void getTitleOfFeedback() {
		waitTOSync();
		isElementDisplayed(element("feedBack_Title"));
		String feedback = element("feedBack_Title").getText();
		System.out.println("Feedback Title:->" + feedback);
	}
       public void verifyTutorMeButton(){
           isElementDisplayed(element("tutorMeBtn"));
           if(elementsWithOutWait("tutorMeBtn").size()==1){
               element("tutorMeBtn").click();
               isElementDisplayed(element("verifyTutorMe"));
           }
           Reporter.log("TutorMe button is working fine");
           isElementDisplayed(element("showSolution"));
           element("showSolution").click();
           isElementDisplayed(element("disableTutorMe"));
           Reporter.log("TutorMe button gets disabled on clicking on show solution button");
       }
       public String verifyScore(){
           isElementDisplayed(element("submitForTutored"));
		element("submitForTutored").click();
            isElementDisplayed(element("currentScoreSubmit"));
            String score= element("currentScoreSubmit").getText();
            Reporter.log("Score of Activity is :" + score+"%");
            return score;
       }
       public void submitActivity(){
           isElementDisplayed(element("SubmitActivity"));
		Reporter.log("Clicking on Submit activiy for grading button");
		element("SubmitActivity").click();
                wait.hardWait(6);
       }
       /*public void DeleteActivity(String activityUnit, String activityTitle){
           element("switchUnit", activityUnit).click();
           String bookClassName = element("lpnActivity_link", activityTitle).getAttribute("class");
        executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
        element("deleteActivity").click();
        Reporter.log("Added Activity is deleted");
       }*/
       
       public void deleteDistinctActivity(String activityUnit, String activity_title) {
           element("switchUnit", activityUnit).click();
        for (WebElement distinctActivity : elements("activityTitle_link", activity_title)) {
            waitTOSync();
            String bookClassName = element("lpnActivity_link", activity_title).getAttribute("class");
            executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
            isElementDisplayed("activityDelete_icon", activity_title);
            clickOnElementUsingActionBuilder(element("activityDelete_icon", activity_title));
            Reporter.log("Clicked on delete Button");
            handleAlert();
            Reporter.log("Activity Deleted");
        }
    }
            
    
}
