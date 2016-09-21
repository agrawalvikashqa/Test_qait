/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.BasePageActions;
import com.qait.automation.utils.ReportMsg;
import com.qait.automation.utils.TakeScreenshot;
import java.util.ArrayList;
import java.util.List;
import com.qait.automation.getpageobjects.BaseUi;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.sun.jna.platform.win32.WinBase;



public class MTXDashboardPageActions extends BasePageActions {

    public MTXDashboardPageActions(WebDriver driver) {
        super(driver, "MTXDashBoardPage");
    }

    public void clickOnAppByName(String appName) {
        switchToDefaultContent();
        String dockGroup;
        int i = 0, k = -1;
        for (int j = 0; j < elements("lbl_appName").size(); j++) {
            if (j < elements("dockGroup1").size()) {
                dockGroup = "dockGroup1";
                i = j;
            } else {
                dockGroup = "dockGroup2";
                k++;
                i = k;
            }
            //System.out.println(elements("lbl_appName").get(j).getAttribute("title"));
            if (elements("lbl_appName").get(j).getAttribute("title").equalsIgnoreCase(appName)) {
                elements("appNameLink").get(j).isDisplayed();
                ((JavascriptExecutor) driver).executeScript("document.getElementById('" + dockGroup + "').childNodes[" + ((2 * i) + 1) + "].childNodes[0].click();");
                getVerifyByAppName(elements("lbl_appName").get(j).getAttribute("title"));
                break;
            }
        }
        Reporter.log("User successfully launch App: "+appName);
                
    }

    public void getVerifyByAppName(String appName) {
        try {
            element("HeadingNameOfTheApp", appName);
            Assert.assertTrue(element("HeadingNameOfTheApp", appName).isDisplayed());
            Assert.assertTrue(element("getCollapse").isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeOpenApp() {
        driver.switchTo().defaultContent();
        clickOnElementUsingActionBuilder(element("getCollapse"));

    }

    public void switchModeDisplayOnWeekWidgetPage() {
        isElementDisplayed(element("FullGradebook"));
        Assert.assertTrue(isElementDisplayed(element("getTab_Week")));
        Assert.assertTrue(isElementDisplayed(element("getTab_DateManager")));
        Assert.assertTrue(isElementDisplayed(element("getTab_Unit")));
    }

    public void switchModeDisplayOnWeekWidgetPageForStudent() {
        isElementDisplayed(element("FullGradebook"));
        Assert.assertTrue(isElementDisplayed(element("getTab_Week")));
        Assert.assertTrue(isElementDisplayed(element("getTab_ListView")));
        Assert.assertTrue(isElementDisplayed(element("getTab_Unit")));
    }

    public void userNavigatetoLPNByClickOnSwitchModeLink() {
        isElementDisplayed(element("getTab_Unit"));
        element("getTab_Unit").click();
        System.out.println("User Navigated to Unit View");
        Boolean flag = false;
        waitTOSync();
        wait.waitForPageToLoadCompletely();
        Assert.assertTrue(isElementDisplayed(element("assessmentTitle")));
    }
    

    public void userNavigateBackToDashboardPage() {
        element("getTab_Week").click();
        waitTOSync();
    }

    public void verifySearchApp() {
        Assert.assertTrue(isElementDisplayed(element("Search_TxtBox")));
        System.out.println("SearchApp is Loading fine");
    }

    public void verifyStudyCenterApp() {
        Assert.assertTrue(isElementDisplayed(element("StudyCenter_txt")));
        System.out.println("StudyCenterApp is Loading fine");
    }

    public void verifyRssFeedApp() {
        Assert.assertTrue(isElementDisplayed(element("RssFeed_txt")));
        System.out.println("RssFeedApp is Loading fine");
    }
    
    public void clickOnAddIconAndAddActivity() {
        deselectFrame();
        isElementDisplayed(element("addContent_btn"));
        element("addContent_btn").click();
        ReportMsg.info("User Clicked on add Icon");
        element("addActivity_link").click();
        ReportMsg.info("User Clicked on add activity text");
    }
    
    public void setCurrentDateAsDueDate(){
        
        
        element("dueDate").click();
        //element("Next").click();
        wait.hardWait(2);
        waitTOSync();
        element("currentDate").click();
        wait.hardWait(2);
        element("dueDate_Done_btn").click();
        wait.hardWait(2);
       // element("saveActivity_btn").click();
    }
    
     public void setDueDate() {
    
        element("startDate").click();
        wait.hardWait(2);
        element("setDone").click();
        wait.hardWait(2);
        //clickOnElementUsingActionBuilder(element("setDone"));
        element("dueDate").click();
        wait.hardWait(2);
        element("setDone").click();
        wait.hardWait(2);
        //clickOnElementUsingActionBuilder(element("setDone"));
        element("saveActivity_btn").click();
        
    }

    public void checkActivityDueAdded() {
    
        Assert.assertTrue(element("checkAct").isDisplayed());
    }
    
    public void verifyAddedActivityHeading() {
        assert element("addedActivity_text").isDisplayed();
        ReportMsg.info("User verified Add activity heading");
    }
    
    public void clickOnActivity(String activityName) {
        element("activityName_link", activityName).click();
        ReportMsg.info("User Clicked on " + activityName);
    }
    
    public void selectActivityType(String value){
       wait.hardWait(10);
       // selectProvidedTextFromDropDown(el, value);
        Select dropdown = new Select(driver.findElement(By.id("activity-type")));
        dropdown.selectByValue(value);
    }
    
    public void selectActivityPath(String value){
       wait.hardWait(2);
        Select dropdown = new Select(driver.findElement(By.id("activity-path")));
        dropdown.selectByVisibleText(value);
    }
    
    public void clickOnContinueButton(){
         element("cntinu_btn").click();
     }
    
    public void addActivityDiscriptionAndTitle(String title, String text) {
        waitForSpinnerToDisappear();
        element("add_title").click();
        element("add_title").clear();
        element("add_title").sendKeys(title);
        ReportMsg.info("User added the title of the Activity");
        element("add_Discription").click();
        element("add_Discription").clear();
        element("add_Discription").sendKeys(text);
        ReportMsg.info("User define the discription of the Activity");
        selectOrder("1");
        
 }
    
    public void deleteDistinctActivity(String activity_title) {
        for (WebElement distinctActivity : elements("activityTitle_link", activity_title)) {
            waitTOSync();
            String bookClassName = element("lpnActivity_link", activity_title).getAttribute("class");
            executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
            isElementDisplayed("activityDelete_icon", activity_title);
            clickOnElementUsingActionBuilder(element("activityDelete_icon", activity_title));
            ReportMsg.info("Clicked on delete Button");
            handleAlert();
            ReportMsg.info("Activity Deleted");
        }
    }
    
    public void saveActivityButton(){
        element("saveActivity_btn").click();
        ReportMsg.info("User clicked on save button and added the Activity");
        wait.hardWait(2);
    }
    
    public void selectOrder(String position) {
        element("selectMenu_Order").click();
        ReportMsg.info("User clicked on select menu to select the position of the activity");
        element("selectPosition", position).click();
        ReportMsg.info("User set the position " + position);
    }
    
    void deselectFrame() {
        driver.switchTo().defaultContent();
    }

    public void verifyChemistryReferenceApp() {
        Assert.assertTrue(isElementDisplayed(element("chemistryReference_txt")));
        System.out.println("ChemistryReferenceApp is Loading fine");
    }
    
    public void clickOnView(String _view_Tab) {
        isElementDisplayed(element("view_tab", _view_Tab));
        clickOnElementUsingActionBuilder(element("view_tab", _view_Tab));
        ReportMsg.info("User clicked on " + _view_Tab + " tab");
        waitForSpinnerToDisappear();
    }

    public void verifyFlashcardApp() {
        Assert.assertTrue(isElementDisplayed(element("Flashcard_txt")));
        System.out.println("FlashcardApp is Loading fine");
    }

    public void verifyFullBookApp() {
        waitForSpinnerToDisappear();
        Assert.assertTrue(isElementDisplayed(element("FullBook_txt")));
        System.out.println("FullBookApp is Loading fine");
    }

    public void verifyGlossaryApp() {
        Assert.assertTrue(isElementDisplayed(element("Glossary_txt")));
        System.out.println("GlossaryApp is Loading fine");
    }
    
    public void verifyPollingAppLaunch() {
        Assert.assertTrue(isElementDisplayed(element("polling_inside_text")));
        System.out.println("PollingApp is Loading fine");
    }
    
    public void verifyPollingAppLaunchStudent() {
      //   waitForElementPresent("polling_stu_refresh_link");
      //  Assert.assertTrue(isElementDisplayed(element("polling_stu_refresh_link")));
        System.out.println("PollingApp is Loading fine");
    }
    
    public void verifyProgressApp() {
        wait.hardWait(10);
        Assert.assertTrue(isElementDisplayed(element("Gradebook_txt")));
        System.out.println("ProgressApp is Loading fine");
    }
    

    public void verifyMessageCenterAppLaunch(){
        waitForElementPresent("msg_center_submit_btn");
        Assert.assertTrue(isElementDisplayed(element("msg_center_submit_btn")));
    }
    
    public void verifyMessageCenterAppLaunchStudent(){
        waitForElementPresent("msg_center_stu_refresh_link");
        Assert.assertTrue(isElementDisplayed(element("msg_center_stu_refresh_link")));
    }


    public void verifyStudentProgressApp() {
        Assert.assertTrue(isElementDisplayed(element("studentGradebook")));
        System.out.println("ProgressApp is Loading fine");
    }

    public void verifyDictionaryApp() {
        Assert.assertTrue(isElementDisplayed(element("Dictionary_txt")));
        System.out.println("DictionaryApp is Loading fine");
    }

    
    public void verifyMerriamWebsterDictionaryAppLaunch() {
        waitForElementPresent("mer_webster_inside_txt");
        Assert.assertTrue(isElementDisplayed(element("mer_webster_inside_txt")));
        System.out.println("Merriam Webster DictionaryApp is Loading fine");
    }
    
    
    public void verifyLPNTitle(){
        waitForElementPresent("lpn_title");
        Assert.assertEquals(element("lpn_title").getText(), "MINDTAP IN ACTION: AMERICAN GOVERNMENT");
    }
    
     public void verifyLPNTitleHistory(){
         wait.hardWait(5);
        waitForElementPresent("lpn_title");
        //Assert.assertEquals(element("lpn_title").getText(), "MTX U.S. HISTORY - NEW ISBN");
    }
    
    public void verifyAllTabsAreDisplayedOnInstructorDashboard(){
        Assert.assertTrue(isElementDisplayed(element("getTab_Week")));
        Assert.assertTrue(isElementDisplayed(element("getTab_DateManager")));
        Assert.assertTrue(isElementDisplayed(element("getTab_Unit")));
    }
    
    public void verifyAllTabsAreDisplayedOnStudentDashboard(){
        Assert.assertTrue(isElementDisplayed(element("getTab_Week")));
        Assert.assertTrue(isElementDisplayed(element("getTab_ListView")));
        Assert.assertTrue(isElementDisplayed(element("getTab_Unit")));
    }
    
    public void verifyAllTabsAreSwitchableForInstructor(){
        waitForElementPresent("getTab_Unit");
        clickOnElementUsingActionBuilder(element("getTab_Unit"));
        waitForElementPresent("getTab_DateManager");
        clickOnElementUsingActionBuilder(element("getTab_DateManager"));
        waitForElementPresent("getTab_Week");
        clickOnElementUsingActionBuilder(element("getTab_Week"));
    }
    
    public void verifyAllTabsAreSwitchableForStudent(){
        waitForElementPresent("getTab_Unit");
        clickOnElementUsingActionBuilder(element("getTab_Unit"));
        waitForElementPresent("getTab_ListView");
        clickOnElementUsingActionBuilder(element("getTab_ListView"));
        waitForElementPresent("getTab_Week");
        clickOnElementUsingActionBuilder(element("getTab_Week"));
    }
    
     public void instructorSwitchToDatemanager(){
        waitForElementPresent("getTab_DateManager");
        clickOnElementUsingActionBuilder(element("getTab_DateManager"));
     }
    
    public void verifyCurrentWeekDisplaysInWeekView(){
        waitForElementPresent("current_week");
        Assert.assertTrue(isElementDisplayed(element("current_week")),"Current week is not displaying");
    }
    
    public Boolean verifyPerformanceWidgetTitle() {
        
        String title = element("performance_widget_title").getText();
        if(title.contains("RECENT ACTIVITY SCORES"))
        {
        return true;
        }
        else 
            return false;
    }

    public void verifyClassAverageWidgetDisplays(){
         Assert.assertTrue((element("class_average").isDisplayed()),"Class Average Widget is not displaying for Instructor");
    }
    
     public void verifyYourCurrentScoreWidgetDisplays(){
         Assert.assertEquals(element("your_current_score_txt").getText(),"Your Current Score");
    }
    
     public void verifyAllLinksInUserMenuForInstructor(){
         waitForElementPresent("user_menu_link");
        clickOnElementUsingActionBuilder(element("user_menu_link"));
        waitForElementPresent("course_settings_link");
        Assert.assertTrue(isElementDisplayed(element("course_settings_link")),"Course Settings Link is Not Displaying");
        Assert.assertTrue(isElementDisplayed(element("customer_support_link")),"Customer Support Link is Not Displaying");
        Assert.assertTrue(isElementDisplayed(element("send_us_feedback_link")),"Send Us Feedback Link is Not Displaying");
        Assert.assertTrue(isElementDisplayed(element("faq_link")),"FAQ Link is Not Displaying");
        Assert.assertTrue(isElementDisplayed(element("system_check_link")),"System Check Link is Not Displaying");
        Assert.assertTrue(isElementDisplayed(element("logout_link")),"Logout Link is Not Displaying");
        clickOnElementUsingActionBuilder(element("user_menu_link"));
     }
     
     public void verifyAllLinksInUserMenuForStudent(){
         waitForElementPresent("user_menu_link");
        clickOnElementUsingActionBuilder(element("user_menu_link"));
        waitForElementPresent("customer_support_link");
        Assert.assertTrue(isElementDisplayed(element("customer_support_link")),"Customer Support Link is Not Displaying");
        Assert.assertTrue(isElementDisplayed(element("get_started_tut_link")),"Getting Started Tutoral Link is Not Displaying");
        Assert.assertTrue(isElementDisplayed(element("send_us_feedback_link")),"Send Us Feedback Link is Not Displaying");
        Assert.assertTrue(isElementDisplayed(element("system_check_link")),"System Check Link is Not Displaying");
        Assert.assertTrue(isElementDisplayed(element("logout_link")),"Logout Link is Not Displaying");
        clickOnElementUsingActionBuilder(element("user_menu_link"));
     }
    
     public void verifyAllLinksDisplayOnSplashPage(){
         waitForElementPresent("mindtap_logo_img");
         clickOnElementUsingActionBuilder(element("mindtap_logo_img"));
         waitTOSync();
         waitForElementPresent("aboutCengageLink");
         clickOnElementUsingActionBuilder(element("aboutCengageLink"));
         waitForElementPresent("AboutUs");
         Assert.assertEquals(element("AboutUs").getText(), "About Us");
         clickOnElementUsingActionBuilder(element("copyrightStatmentLink"));
         waitForElementPresent("copyrightInfo");
         Assert.assertEquals(element("copyrightInfo").getText(), "Copyright");
         clickOnElementUsingActionBuilder(element("serviceAgreementLink"));
         waitForElementPresent("serviceAgreementInfo");
         Assert.assertEquals(element("serviceAgreementInfo").getText(), "MINDTAP SERVICE AGREEMENT");
         clickOnElementUsingActionBuilder(element("splash_close_btn"));
         waitTOSync();
     }
     
     public void NavigateToUnitViewAndLaunchesUnit(){
         waitForElementPresent("getTab_Unit");
         clickOnElementUsingActionBuilder(element("getTab_Unit"));
         waitForElementPresent("lpn_unit_link");
         clickOnElementUsingActionBuilder(element("lpn_unit_link"));
         waitForElementPresent("lpn_title_inside_unit");
         waitTOSync();
         Assert.assertEquals((element("lpn_title_inside_unit").getText()), "UNIT 4: CIVIL RIGHTS");
     }
     
     public void NavigateToUnitViewAndLaunchesUnitHistory(){
         waitForElementPresent("getTab_Unit");
         clickOnElementUsingActionBuilder(element("getTab_Unit"));
         waitForElementPresent("lpn_unit_link");
         clickOnElementUsingActionBuilder(element("lpn_unit_link_his"));
         waitForElementPresent("lpn_title_inside_unit_his");
         waitTOSync();
         Assert.assertEquals((element("lpn_title_inside_unit_his").getText()), "UNIT 22: REVOLUTION AND CRISIS, 1960–1974");
     }
     
     public void verifyLaunchConnectingWithPolitics(){
         waitForElementPresent("con_with_politics_lpn_link");
         clickOnElementUsingActionBuilder(element("con_with_politics_lpn_link"));
         
     }
     
      public void verifyLaunchInfographicActivity(){
         waitForElementPresent("infographic_lpn_link_his");
         clickOnElementUsingActionBuilder(element("infographic_lpn_link_his"));
         
     }
     
      public void verifyLaunchConceptualNarrative(){
          waitForElementPresent("con_narrative_lpn_link");
          try{
           clickOnElementUsingActionBuilder(element("con_narrative_lpn_link"));
              }
          catch(org.openqa.selenium.StaleElementReferenceException ex)
             {
           clickOnElementUsingActionBuilder(element("con_narrative_lpn_link"));
               }
             }
      
      public void verifyLaunchConceptualNarrativeHistory(){
          waitForElementPresent("con_narrative_lpn_link_his");
          try{
           clickOnElementUsingActionBuilder(element("con_narrative_lpn_link_his"));
              }
          catch(org.openqa.selenium.StaleElementReferenceException ex)
             {
           clickOnElementUsingActionBuilder(element("con_narrative_lpn_link_his"));
               }
             }
      
      public void verifyLaunchDiscussionBoard(){
          wait.hardWait(2);
         waitForElementPresent("disc_board_lpn_link");
         try{
         clickOnElementUsingActionBuilder(element("disc_board_lpn_link"));
         }
         catch(org.openqa.selenium.StaleElementReferenceException ex){
             clickOnElementUsingActionBuilder(element("disc_board_lpn_link"));
         }
         waitTOSync();
         waitTOSync();
     }
      
      public void verifyLaunchContextualLens(){
          waitForElementPresent("contextual_lens_lpn_link");
          try{
         clickOnElementUsingActionBuilder(element("contextual_lens_lpn_link"));
          }
          catch(org.openqa.selenium.StaleElementReferenceException ex){
              clickOnElementUsingActionBuilder(element("contextual_lens_lpn_link"));
          }
     }
      
      public void verifyLaunchContextualLensHistory(){
          waitForElementPresent("contextual_lens_lpn_link_his");
          try{
         clickOnElementUsingActionBuilder(element("contextual_lens_lpn_link_his"));
          }
          catch(org.openqa.selenium.StaleElementReferenceException ex){
              clickOnElementUsingActionBuilder(element("contextual_lens_lpn_link_his"));
          }
     }
      
      public void verifyLaunchEssayActivity(){
          waitForElementPresent("essay_act_lpn_link");
          try{
         clickOnElementUsingActionBuilder(element("essay_act_lpn_link"));
          }
          catch(org.openqa.selenium.StaleElementReferenceException ex) {
            clickOnElementUsingActionBuilder(element("essay_act_lpn_link"));  
          }
     }
      
      public void verifyLaunchEssayActivityHistory(){
          waitForElementPresent("essay_act_lpn_link_his");
          try{
         clickOnElementUsingActionBuilder(element("essay_act_lpn_link_his"));
          }
          catch(org.openqa.selenium.StaleElementReferenceException ex) {
            clickOnElementUsingActionBuilder(element("essay_act_lpn_link_his"));  
          }
     }
      
       public void verifyStudyGuideLaunchfromLPN(){
           waitForElementPresent("study_guide_lpn_link");
           try{
        clickOnElementUsingActionBuilder(element("study_guide_lpn_link"));
           }
           catch(org.openqa.selenium.StaleElementReferenceException ex) {
               clickOnElementUsingActionBuilder(element("study_guide_lpn_link"));
           }
    }
       
       public void navigateToUnitViewAndLaunchAddActivityWindow(){
          waitForElementPresent("getTab_Unit");
         clickOnElementUsingActionBuilder(element("getTab_Unit"));
         executeJavascript("document.getElementById('menu_addContent').click();");
        ReportMsg.info("User Clicked on add Icon");
        executeJavascript("document.getElementById('menu_addActivity').click();");
        ReportMsg.info("User Clicked on add activity Link");
       }
       
       public void verifyAddActivityWindowLaunch(){
           waitTOSync();
           Assert.assertEquals(element("add_activity_header").getText(), "ADD ACTIVITY");
       }
       
       public void launchAssessmentsAppFromAddActivityWindow(){
          waitForElementPresent("assessment_link");
        clickOnElementUsingActionBuilder(element("assessment_link"));
        waitTOSync();
        switchToActivityIFrame();
        wait.waitForElementToBeVisible(element("select_assessment_msg"));
        Assert.assertEquals(element("select_assessment_msg").getText(), "Please Select a Creation Type");
       }
       
       public void verifyLogOutFromMTXCourse() {
        waitForElementPresent("user_menu_link");
        clickOnElementUsingActionBuilder(element("user_menu_link"));
        clickOnElementUsingActionBuilder(element("logout_link"));
        waitForElementPresent("logout_mt_text");
    }
       
     public void NG_33378Test() {
         wait.waitForElementToBeVisible(element("history_test"));
         clickOnElementUsingActionBuilder(element("history_test"));
         waitTOSync();
		      switchToDefaultContent();
                      switchToFrame(element("getHistoryFrame_Content"));
                      switchToFrame("easyXDM_activityService_cxp_Target_provider");
                      System.out.println("easyXDM_activityService_cxp_Target_provider frame switch");
                      wait.waitForElementToBeVisible(element("startActivityHistory"));
                      waitTOSync();
                      isElementDisplayed(element("startActivityHistory"));
                      waitTOSync();
                      element("startActivityHistory").click();
                      wait.hardWait(8);
                      Assert.assertTrue(isElementDisplayed(element("checkAnswer")));
		waitTOSync();
                element("checkAnswer").click();
		waitTOSync();
                waitTOSync();
		element("CloseSubmit").click();
	
     }
     
     public void NG_31272Test(String courseTitle){
         isElementDisplayed(element("analytics_Tab"));
         element("analytics_Tab").click();
         wait.waitForElementToBeVisible(element("course_name"));
         String courseName=element("course_name").getText();
         if(courseName== courseTitle){
             Reporter.log("Correct course Name is displaying");
         }
     }


}
