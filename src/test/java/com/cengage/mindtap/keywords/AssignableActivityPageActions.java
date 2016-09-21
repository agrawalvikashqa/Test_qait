/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

/**
 *
 * @author nikitaaggarwal
 */
public class AssignableActivityPageActions extends BasePageActions {
    
    public AssignableActivityPageActions(WebDriver driver) {
        super(driver, "AssignableActivityPage");
    }

    public void selectCheckBoxAA() {
        waitForSpinnerToDisappear();
        
        clickOnElementUsingActionBuilder(element("AddAA_txt"));
        Reporter.log("User selected the checkbox of AA to add that activity");
    }
    public void clickOnContinue() {
        clickOnElementUsingActionBuilder(element("continue_btn"));
        Reporter.log("User clicked on continue button to add AA");
    }
    public void clickOnSaveChanges() {
        waitTOSync();
        executeJavascript("window[0].document.getElementsByClassName('continueButton navButton')[1].click()");
        Reporter.log("User clicked on save changes button to make changes in AA");
    }
    public void clickOnBack() {
        clickOnElementUsingActionBuilder(element("Nav_back"));
        Reporter.log("User clicked on back button to navigate to unit view");
    }
    public void selectAATypeAssessment() {
        selectProvidedValue(element("AAType_dropdown"), "test");
        Reporter.log("User selected assessment type in Assignment Type Dropdown");
    }
    public void selectAATypeHomework() {
        selectProvidedValue(element("AAType_dropdown"), "homework");
        Reporter.log("User selected assessment type in Assignment Type Dropdown");
    }
    public void selectPracticeRadioBtn() {
        clickOnElementUsingActionBuilder(element("Practice_checkbox "));
        Reporter.log("User Choose grading mode practice");
    }
    public void selectFeedBackAfterAssignment() {
        waitTOSync();
        executeJavascript("window[0].document.getElementById('showfeedbackInReviewMode_always').click()");
        Reporter.log("User selected Feedback After Assignment checkbox");
    }
    public void clickOnContinueAA() {
        clickOnElementUsingActionBuilder(element("continueAA_btn"));
        Reporter.log("User clicked on continue button again to add AA");
        deselectFrame();
    }
    public void closeReader() {
        clickOnElementUsingActionBuilder(element("continueAA_btn"));
        Reporter.log("User clicked on continue button again to add AA");
    }
    public void SubmitActivity() {
        waitTOSync();
        waitTOSync();
        clickOnElementUsingActionBuilder(element("SubmitActivity_btn"));
        clickOnElementUsingActionBuilder(element("Submit_btn"));
        Reporter.log("User Submitted the activity");
    }
     public void VerifySubmittedActivity() {
         isElementDisplayed(element("SubmitActivity_btn"));
         Reporter.log("Instructor have multiple attempts for an activity");
     }
     public void setDuedateOfAssessmentActivity(String activity_title) {
         element("set_duedate", activity_title).click();
         Reporter.log("Instructor clicked on due date calender from date manager");
         element("done_btn").click();
         Reporter.log("user clicked on done button to set due date");
     }
     public void verifyDueDateOnLPN(String activity_title) {
         isElementDisplayed(element("dueDate_lpn", activity_title));
         Reporter.log("Due date of" + activity_title + " is displayed on Unit View");
     }
     public void VerifyHiddenFromStudentTextInUnitView(String activity_title) {
            waitTOSync();
         isElementDisplayed(element("Hidden_text", activity_title));
         Reporter.log("Activity" + activity_title + " is hidden from Unit View");
         try {

            isElementDisplayedHidden(element("dueDate_lpn", activity_title));
        Assert.assertTrue(false);
        System.out.println("Due Dates of Hidden activites are displaying");
        }
         catch (Exception e){
          Assert.assertTrue(true);
          System.out.println("Due Dates of Hidden activites are not displaying");
    }
     }
    public void VerifyHiddenFromStudentTextInDateManager(String activity_title) {
        waitTOSync();
         isElementDisplayed(element("Hide_datemanager", activity_title));
         Reporter.log("Activity" + activity_title + " is hidden from Date Manager View");
     }
    public void removeHiddenItemsFromUnitView(){
        hover(element("lpn_title"));
        //executeJavascript("document.getElementsByClassName('navLink courseejs_removehidden').style.display = 'block';");
        element("rmv_hidden").click();
        Reporter.log("user clicked on remove hidden items icon in lpn_title");
        waitTOSync();
        //System.out.println(element("hide_activity", activity_title).isSelected());
        //isElementEnabled(element("hide_activity", activity_title), true);
        //String result = executeJavascriptWithReturn("document.getElementsByClassName('lpn_name')[1].checked").toString();
    }
    public void activitiesAfterHiddenItems(String activity_title){
        try {

            isElementDisplayedHidden(element("hide_activity", activity_title));
        Assert.assertTrue(false);
        System.out.println("Hidden activites are displaying");
        }
         catch (Exception e){
          Assert.assertTrue(true);
          System.out.println("Hidden activites are not displaying");
    }
    }
        public void HiddenItemsinGradebook(String activity_title){
         element("overview_PA").click();
         try {

            isElementDisplayedHidden(element("hiddenactivity_PA", activity_title));
        Assert.assertTrue(false);
        System.out.println("Hidden activites are displaying in Gradebook");
        }
         catch (Exception e){
          Assert.assertTrue(true);
          System.out.println("Hidden activites are not displaying in Gradebook");
    }
    }
        public void VerifyActivitiesInGradebook(String activity_title){
         element("overview_PA").click();
            scrollDown(elementWithoutWait("hiddenactivity_PA", activity_title));
           waitTOSync();
           
           
            
           Assert.assertTrue(element("hiddenactivity_PA", activity_title).isDisplayed(),"element is not displaying"); 
          //isElementDisplayed(element("hiddenactivity_PA", activity_title));
         //Assert.assertTrue(true);
         Reporter.log("Activity"+ activity_title +"is displaying in Gradebook");
    }
    
    public void AddAssessmentAA() {
        selectCheckBoxAA();
        clickOnContinue();
        selectAATypeAssessment();
        clickOnContinueAA();
    }
    public void AddHomeworkAA() {
        selectCheckBoxAA();
        clickOnContinue();
        selectAATypeHomework();
        selectPracticeRadioBtn();
        clickOnContinueAA();
    }
    protected void clickOnElementUsingActionBuilder(WebElement element) {
        Actions builder = new Actions(driver);
        Actions MenuItems = builder.moveToElement(element);
        waitTOSync();
        MenuItems.click().build().perform();
        waitTOSync();
    }
    public void clickOnAssignment() {
    element("launch_assignment").click();
    waitForSpinnerToDisappear();
    }
    
}
