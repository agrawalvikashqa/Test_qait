/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.BasePageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 *
 * @author nikitaaggarwal
 */
public class MTXActivityPageAction extends BasePageActions{
    String activity_heading;
    
    public MTXActivityPageAction(WebDriver driver) {
        super(driver, "MTXActivityPage");
    }
    public void clickOnTutoredActivity(String TutoredActivityName) {
		element("getlbl_TutoredActivity",TutoredActivityName).click();
                Reporter.log("Activity" +TutoredActivityName + "launches fine");
	}
    public void clickOnMasteryActivity(){
        element("lbl_Mastery").click();
    }
    public void clickOnReview() {
		element("lbl_Review").click();
	}
    public void clickOnChallenge() {
		element("lbl_Challenge").click();
	}
    public void getTitleOfActivity() {
		switchToDefaultContent();
		activity_heading = element("titleOfActivity").getText();
		System.out.println("Activity Title:->" + activity_heading);
	}
    public void verifyPerformanceDots() {
                switchToDefaultContent();
                Assert.assertFalse(isElementDisplayed(element("performanceDot", activity_heading)));
		System.out.println("Performance Dot for Activity" + activity_heading + "is not displaying in Performance Widget as this is Practice Activity");
	}
    
    public void verifySubmitLinkIsPresent() {
		      switchToDefaultContent();
                      switchToFrame(element("getFrame_Content"));
                      switchToFrame("easyXDM_activityService_cxp_Target_provider");
                      isElementDisplayed(element("checkOverviewStatus"));
                      Reporter.log("User navigates to the overview tab.");
                      waitForDomToLoad();
		isElementDisplayed(element("link_submitForTutored"));
		waitTOSync();
	}
    public void verifyHistorySubmitLinkIsPresent() {
        waitTOSync();
		      switchToDefaultContent();
                      switchToFrame(element("getHistoryFrame_Content"));
                      switchToFrame("easyXDM_activityService_cxp_Target_provider");
                      System.out.println("easyXDM_activityService_cxp_Target_provider frame switch");
                      isElementDisplayed(element("startActivityHistory"));
                      waitTOSync();
                      element("startActivityHistory").click();
                      wait.hardWait(8);
                      Assert.assertTrue(isElementDisplayed(element("checkAnswer")));

	}
    public void verifyHistorySubmitLinkIsPresentInParentActivity() {
        waitTOSync();
		      switchToDefaultContent();
                      switchToFrame(element("getHistoryFrame_Content"));
                      switchToFrame("easyXDM_activityService_cxp_Target_provider");
                      System.out.println("easyXDM_activityService_cxp_Target_provider frame switch");
                      waitTOSync();
                      try {
                      switchToFrameWithOutDefault(element("HistoryParentFrame"));
                      }catch(StaleElementReferenceException e) {
                      switchToFrameWithOutDefault(element("HistoryParentFrame"));
                      }
                      waitForElementPresent("startActivityHistory");
                      isElementDisplayed(element("startActivityHistory"));
                      element("startActivityHistory").click();
                      waitTOSync();
                      waitTOSync();
		isElementDisplayed(element("checkAnswer"));
		waitTOSync();
	}
    public void clickOnHistorySubmitLinkIsPresentInParentActivity() {
        waitTOSync();
		      switchToDefaultContent();
                      switchToFrame(element("getHistoryFrame_Content"));
                      switchToFrame("easyXDM_activityService_cxp_Target_provider");
                      System.out.println("easyXDM_activityService_cxp_Target_provider frame switch");
                      waitTOSync();
                      try {
                      switchToFrameWithOutDefault(element("HistoryParentFrame"));
                      }catch(StaleElementReferenceException e) {
                      switchToFrameWithOutDefault(element("HistoryParentFrame"));
                      }
                      waitTOSync();
                      waitTOSync();
                      isElementDisplayed(element("LastBHead"));
		element("LastBHead").click();
		isElementDisplayed(element("checkAnswer"));
                element("checkAnswer").click();
		waitTOSync();
                waitTOSync();
		element("CloseSubmit").click();
		waitTOSync();
                element("CloseSubmitWarning").click();
	}
    
    public void verifySubmitLinkIsPresentForIntroAndMastery() {
		      switchToDefaultContent();
                      switchToFrame(element("getFrame_Content"));
                      switchToFrame("easyXDM_activityService_cxp_Target_provider");
                      waitForDomToLoad();
                      wait.hardWait(4);
		isElementDisplayed(element("link_submitForIntro"));
		waitTOSync();
	}
    
    public void verifyKeyConceptsTextPresent() {
		switchToDefaultContent();
                      switchToFrame(element("getFrame_StudyCenter"));
                      //switchToFrame("easyXDM_activityService_cxp_Target_provider");
		isElementDisplayed(element("gettxt_KeyConcepts"));
		System.out.println("key concepts text is present");
	}
    public void clickOnStudyGuide() {
		element("lbl_StudyGuide").click();
	}
    public void clickOnIntroQuickPrep() {
        element("IntoQuickPrep").click();
    }
    public void clickOnPicturingHistory() {
                 element("PicturingHistory").click();
    }
     public void clickOnNarrativeConceptual() {
                 element("NarrativeConceptual").click();
    }
     public void clickOnLensActivity() {
                 element("LensActivity").click();
    }
     public void clickOnEssayActivity() {
                 element("EssayActivity").click();
    }
     public void SelectParentChoice() {
         waitTOSync();
         waitTOSync();
         switchToDefaultContent();
         switchToFrame(element("getHistoryFrame_Content"));
         switchToFrame("easyXDM_activityService_cxp_Target_provider");
         waitForElementPresent("ParentActivityChoice");
         isElementDisplayed(element("ParentActivityChoice"));
         clickOnElementUsingActionBuilder(element("ParentActivityChoice"));
                 //element("ParentActivityChoice").click();
                 element("ChoiceContinuebtn").click();
    }
    public void clickOnCloseActivity() {
        //switchToFrame(element("getFrame_StudyCenter"));
                //clickOnElementUsingActionBuilder(element("CloseStudyGuide"));
                switchToDefaultContent();
		      clickOnElementUsingActionBuilder(element("CloseActivityButton"));
	}
    
    public void clickOnStartActivityForTutored() {
		switchToDefaultContent();
		switchToFrame(element("getFrame_Content"));
                switchToFrame("easyXDM_activityService_cxp_Target_provider");
		isElementDisplayed(element("startActivityForTutored"));
		element("startActivityForTutored").click();
                Reporter.log("User navigates to the tutorial. ");
	}
    public void clickOnSubmitLinkForTutored() {
                switchToDefaultContent();
		switchToFrame(element("getFrame_Content"));
                switchToFrame("easyXDM_activityService_cxp_Target_provider");
		waitForSpinnerToDisappear();
		waitTOSync();
		isElementDisplayed(element("submitForTutored"));
		element("submitForTutored").click();
		waitTOSync();
		waitForSpinnerToDisappear();
	}
    
    public void clickOnSubmitButton() {
                waitTOSync();
		isElementDisplayed(element("SubmitActivity"));
		System.out.println("Clicking on Submit activiy for grading button");
		element("SubmitActivity").click();
		switchToDefaultContent();
	        waitTOSync();
		waitForSpinnerToDisappear();
	}
    public void handleConfirmationPopup() {
		
		try
		{
                    switchToFrame(element("getFrame_Content"));
                switchToFrame("easyXDM_activityService_cxp_Target_provider");
			driver.switchTo().activeElement();
			isElementDisplayed(element("SubmitConfirm"));
			element("SubmitConfirm").click();
                        switchToDefaultContent();
	                waitTOSync();
		        waitForSpinnerToDisappear();
		}
		catch(Exception e){}
	}
    public void handleAlertPopup() {
        handleAlert();
        
    }
    
    public void verifyActivityLaunchInReviewMode() {
                switchToDefaultContent();
                waitTOSync();
                waitTOSync();
                //Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Done']")).isDisplayed());
                Assert.assertTrue(isElementDisplayed(element("img_DoneActivity")));
                Reporter.log("Decorator Status is submitted");
	}
    public void clickOnSubmitMasterLink(){
                switchToFrame(element("getFrame_Content"));
                switchToFrame("easyXDM_activityService_cxp_Target_provider");
		waitTOSync();
		waitForSpinnerToDisappear();
                element ("MasteryGroup").click();
                waitTOSync();
                waitTOSync();
		isElementDisplayed(element("get_StateForSubmit"));
		isElementDisplayed(element("getbtn_Next"));
		element("getbtn_Next").click();
		waitForSpinnerToDisappear();
		isElementDisplayed(element("SubmitMastery"));
		element("SubmitMastery").click();
	        waitTOSync();
		element("SubmitMastery").click();
		waitTOSync();
	}
    public void clickOnSubmitLink() {
        switchToFrame(element("getFrame_Content"));
                switchToFrame("easyXDM_activityService_cxp_Target_provider");
		//isElementDisplayed(element("checkOverviewStatus"));
		waitTOSync();
		Reporter.log("Clicking on Submit tab");
		isElementDisplayed(element("link_submitForIntro"));
		element("link_submitForIntro").click();
		waitTOSync();
		element("link_submitForIntro").click();
		waitTOSync();
		
	}

    public void clickOnCheckAnswerLink() {
        switchToFrame(element("getHistoryFrame_Content"));
                switchToFrame("easyXDM_activityService_cxp_Target_provider");
		//isElementDisplayed(element("checkOverviewStatus"));
		waitTOSync();
		Reporter.log("Clicking on Check Answer tab");
		isElementDisplayed(element("checkAnswer"));
		element("checkAnswer").click();
		waitTOSync();
		element("CloseSubmit").click();
		waitTOSync();
		
	}
    public void clickOnCheckAnswerWithMultipleBHeadLink() {
        switchToFrame(element("getHistoryFrame_Content"));
                switchToFrame("easyXDM_activityService_cxp_Target_provider");
		waitTOSync();
		isElementDisplayed(element("LastBHead"));
		element("LastBHead").click();
		waitTOSync();
                Reporter.log("Clicking on Check Answer tab");
		isElementDisplayed(element("checkAnswer"));
		element("checkAnswer").click();
		waitTOSync();
		element("CloseSubmit").click();
		waitTOSync();
                element("CloseSubmitWarning").click();
		
	}

    public void activityOverviewHeaderVerify(String value){
        waitForElementPresent("activityOverview_Header");
        System.out.println(element("activityOverview_Header", value).getText());
        
    }
    public void launchActivityfromWeekView(String activityName){
        wait.hardWait(4);
        element("activityLaunch_Link", activityName).click();
    }
    
    public void overviewUI(){
        element("gradeLabel").isDisplayed();
        element("attemptLabel").isDisplayed();
        element("connectionLost_Label").isDisplayed();
        element("connectionLost_Label").isDisplayed();        
    }
    
    
    public void VerifyClickCrossButton() {
         switchToDefaultContent();
        element("CrossButton").click();
    }

    public void selectAnswersForChallenges() {
        switchToDefaultContent();
        //switchToFrame(driver.findElement(By.id("97_NB_Main_IFrame")));
        //wait.hardWait(5);
        //switchToFrame(driver.findElement(By.cssSelector("iframe[id*='easyXDM']")));
        // wait.hardWait(5);
        switchToFrame(element("getFrame_Content"));
        switchToFrame("easyXDM_activityService_cxp_Target_provider");
        Select selectByValue = new Select(element("ChallengeQuestionOne"));
        selectByValue.selectByVisibleText("homogeneous mixture");
        wait.hardWait(5);
        selectByValue = new Select(element("ChallengeQuestionTwo"));
        selectByValue.selectByVisibleText("heterogeneous mixture");
        wait.hardWait(5);
        selectByValue = new Select(element("ChallengeQuestionThree"));
        selectByValue.selectByVisibleText("top");
    }
    
    public void selectDropDownAnswers() {
        switchToDefaultContent();
        switchToFrame(driver.findElement(By.id("97_NB_Main_IFrame")));
        wait.hardWait(5);
        switchToFrame(driver.findElement(By.cssSelector("iframe[id*='easyXDM']")));
//        selectProvidedTextFromDropDown(element("selectAnsDropDownOne"),"macroscopic");
//        selectProvidedTextFromDropDown(element("selectAnsDropDownTwo"),"macroscopic");
//        selectProvidedTextFromDropDown(element("selectAnsDropDownThree"),"macroscopic");
        wait.hardWait(5);
//        Select(driver.findElement(element("selectAnsDropDownOne")));
//        Select(driver.findElement(By.id("selectAnsDropDownTwo")));
//        Select(driver.findElement(By.id("SelectID_One")));
        Select selectByValue = new Select(element("selectAnsDropDownOne"));
        selectByValue.selectByVisibleText("macroscopic");
        wait.hardWait(5);
        selectByValue = new Select(element("selectAnsDropDownTwo"));
        selectByValue.selectByVisibleText("macroscopic");
        wait.hardWait(5);
        selectByValue = new Select(element("selectAnsDropDownThree"));
        selectByValue.selectByVisibleText("macroscopic");
//            Select selectByValue = new Select(element("selectAnsDropDownTwo"));
//            selectByValue.selectByValue("macroscopic");
//            
//            Select selectByValue = new Select(element("selectAnsDropDownThree"));
//            selectByValue.selectByValue("macroscopic");

    }
    
    
    
    
    public void overviewCancelButton(){
        waitForElementPresent("cancel_btn");
        element("cancel_btn").click();
        System.out.println("Cancel button clicked");
    }
    
    public void overviewContinueButton(){
        waitForElementPresent("overview_Continue_btn");
        element("overview_Continue_btn").click();
        System.out.println("overview_Continue_btn");
    }
    
    public void overviewStartActivityButton(){
        wait.hardWait(10);
       // driver.navigate().refresh();
        
        wait.hardWait(5);
        waitForElementPresent("startActivity_btn");
       // executeJavascript("(document.getElementsByClassName('btn btn-primary left'))[1].click();");
        //clickOnElementUsingActionBuilder(element("startActivity_btn"));
        element("startActivity_btn").click();
        System.out.println("Start Activity button clicked");
    }
    
     public void overviewContinueActivityButton(){
         wait.waitForPageToLoadCompletely();
        wait.hardWait(5);
        //waitForElementPresent("startActivity_btn");
        waitForElementPresent("continue_btn");
        element("continue_btn").click();
        System.out.println("Continue Activity button clicked");
    }
    
    public void breadcrumbs(String value){
        ///element("activityInfo_icon").isDisplayed();
        wait.hardWait(5);
        element("activityReading_btn", value).isDisplayed();
        element("activityReading_btn", value).click();
    }
    
    public void sourceContentLoad(){
        element("sourceContent_loadVerify").isDisplayed();
    }
    
    public void activityTitle(String value){
        element("activityTitle", value);
    }
    
    public void activityScore(){
        element("activityScore");
    }
    
    public void activityManual(){
        element("activityManual");
    }
    
    public void activityDate(){
        switchToDefaultContent();
        element("activityDate");
        String DueDate = element("activityDate").getText();
        System.out.println(DueDate);
    }
    
    public void submittedDecorator(){
        element("submittedDecorator");
    }
    
    
    public void clickOnInfoIcon(){
        wait.hardWait(3);
        element("infoIcon").click();
    }
    
    public void clickReviewButton(){
        element("review_btn").click();
        wait.hardWait(4);
    }

    
    public void submittedButton(String value){
        try{
        element("submitted_btn");
        }
        catch(Exception e){
            breadcrumbs(value);
        }
    }
    
    public void closeActivity(){
        element("CloseActivityButton").click();

        Reporter.log("Close Activity icon(X) is available on top of the activity pane");

        wait.hardWait(3);
    }
    
    public void inProgressSIVerify(String value){
        element("InProg_SI",value).isDisplayed();
    }
    
    public void submittedSIVerify(String value){
        element("submitted_SI",value).isDisplayed();
    }
    
    public void pageRefresh(){
        pageRefresh();
    }
    
    public void activityOverviewButton(){
        element("activity_overview_btn").click();
        Assert.assertTrue(isElementDisplayed("review_btn"));
    }
    
    public boolean accordionCollapseLink(){
        return elementWithoutWait("collapse_link").isDisplayed();
        
    }
    
    public void collapsedView(){
        if(accordionCollapseLink() == true){
         element("collapse_link").click();
        }
        else{
            System.out.println("tab is not collapsed by default");  
        }
    }
        
    public void expandedView(){
        if(accordionCollapseLink() == false){
         element("expandLink").click();
        }
    }
    
    public void verifyCheckAnswerButton(){
        wait.hardWait(20);
        wait.waitForPageToLoadCompletely();
        waitForElementPresent("check_answer_btn");
        Assert.assertTrue((element("check_answer_btn").isDisplayed()), "Check Answer Button is not displayed");
    }
    
    public void verifyPostNewMessageButton(){
        waitForElementPresent("dis_board_post_new_message_btn");
        Assert.assertTrue((element("dis_board_post_new_message_btn").isDisplayed()), "Post New Message Button is not displayed");
    }
    
    public void verifyDiscussionBoardTips(){
        waitForElementPresent("discussion_board_tips_link");
        Assert.assertTrue((element("discussion_board_tips_link").isDisplayed()), "Discussion Board Tips Link is not displayed");
        waitTOSync();
    }
    
    public void verifyUnitStudyGuideHeading(){
        waitForElementPresent("unit_study_guide_heading");
        Assert.assertTrue((element("unit_study_guide_heading").isDisplayed()), "Unit Study Guide Heading is not displayed");
    }
    
    public void verifyStudyGuideLaunchHistory(){
        waitForElementPresent("study_guide_his");
        //Assert.assertTrue((element("study_guide_his").isDisplayed()), "History Study Guide is Unable to Load");
    }
    
    public void verifyCloseAndSubmitButton(){
        waitForElementPresent("close_and_submit_btn");
        Assert.assertTrue((element("close_and_submit_btn").isDisplayed()), "Close and Submit Button is not displayed");
    }
    
    public void verifyTryAgainButton(){
        waitTOSync();
        waitForElementPresent("try_again_btn");
        element("try_again_btn").click();
        waitTOSync();
    }
    
    public void clickOnReturntoActivityButton(){
        wait.hardWait(4);
        System.out.println("Clicking on Return to Activity button");
        element("returnActivity_btn").click();
    }
    String s[];
    String attemptRemainingBeforeSubmit;
    
    public void verifyChemattemptsRemainingBeforeSubmit(){
          attemptRemainingBeforeSubmit = element("attemptRemaining").getText();
        System.out.println("Attempts remaining before submitting: " + attemptRemainingBeforeSubmit);
         
     }
     
     public void verifyChemattemptsRemainingAfterSubmit(){
         String attemptRemainingAfterSubmit = element("attemptRemaining").getText();
         Assert.assertTrue(attemptRemainingBeforeSubmit.contains(attemptRemainingAfterSubmit), "Unlimited attempts are not there");
         
         }
    
    public void clickOnCLoseAndSubmitButtonOnLenspopUp(){
        wait.hardWait(2);
        element("closeSubmitButton_lensPage").click();
    }
     public void verifySubmitANswerAvailinReviewMode(){
       // if(CheckforSUbmitAnswerNotAppearInReviewMode()==true){
            Assert.assertFalse(CheckforSUbmitAnswerNotAppearInReviewMode());
        
    }
      public boolean CheckforSUbmitAnswerNotAppearInReviewMode(){
        wait.hardWait(6);
        element("nextbtn").click();
        try{
            element("submitAns_btn");
            return true;
        
        }
        catch(Exception e){
            return false;
        }
        
        //Assert.assertFalse(element("submitAns_btn"), "SubmitAnswer button is displaying");
    }
      public boolean CheckforSUbmitAnswerNotAppearInReviewModeTutored(){
        wait.hardWait(6);
        try{
            element("submitAns_btn");
            return false;
        
        }
        catch(Exception e){
            return true;
        }
      }
    
      public void clickEnlargeImage(){
          waitTOSync();
          element("enlargeimage").click();
          
      }  
      
      public void verifyEnlargeImageButton(){
          waitForElementPresent("enlargeimage");
          Assert.assertTrue((element("enlargeimage").isDisplayed()), "EnlargeImage is not displayed");
         }
}

