/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QAI
 */
public class CSMAppIntPageActions extends BasePageActions {

    public CSMAppIntPageActions(WebDriver driver) {
        super(driver, "CSMAppIntPage");
    }
    
    public void clickOnEditCSMAppIntCourse(){
        waitForElementPresent("edit_csm_app_int_course_link");
        clickOnElementUsingActionBuilder(element("edit_csm_app_int_course_link"));
        
    }
    
      public void clickUserMenuLink() {
        waitForElementPresent("user_menu_link");
        clickOnElementUsingActionBuilder(element("user_menu_link"));
      }
      
      public void clickCourseSettings() {
        waitForElementPresent("course_settings_link");
        clickOnElementUsingActionBuilder(element("course_settings_link"));
        waitTOSync();
      }
      
       public void verifyTAIsDisplayed() {
        isElementDisplayed(element("teach_assist_expand"));
       }
       
       public void instructorEditTACapabilities(){
        scrollDown(element("ta_manage_lpn_cap_chkbox"));
        List<WebElement> checkBoxes = new ArrayList();
        checkBoxes = elements("ta_capabilities_allchkboxes");
        for (WebElement box : checkBoxes) {
            box.click();
        }
    }
    
       public void verifyApliaLoadsCompletely(){
           waitTOSync();
           waitForElementPresent("aplia_settings_btn");
           Assert.assertTrue((element("aplia_settings_btn").isDisplayed()) , "Aplia Settings Button Not displayed");
           
       }
       
       public void apliaAppUI(){
           switchToApliaFrame();
       }
       
       public void clickOnCnowHomeWorkApp(){
           waitForElementPresent("cnow_appdock_icon");
           clickOnElementUsingActionBuilder(element("cnow_appdock_icon"));
       }
        
       public void CNowHWAppUI(){
           switchToCNowHWFrame();
       }
       
       public void verifyCNowHWAppLoadsCompletely(){
           waitTOSync();
           waitTOSync();
         //  waitForElementPresent("cnow_popup_close_btn");
         //  clickOnElementUsingActionBuilder(element("cnow_popup_close_btn"));
           Assert.assertEquals( element("cnow_assignments").getText(), "Assignments");  
       }
       
       public void verifyAddActivityWindowLaunch(){
           waitTOSync();
           Assert.assertEquals(element("add_activity_header").getText(), "Add Activity");
       }
       
       public void addActivityPanelWebVideoLaunch(){
           scrollDown(element("web_video_link"));
           clickOnElementUsingActionBuilder(element("web_video_link"));
           waitTOSync();
           switchToActivityIFrame();
           waitForElementPresent("youtube_img");
           Assert.assertTrue(element("youtube_img").isDisplayed(),"WebVideo App Unable to Load");
       }
       
       public void navigateBackToAddActivityPanel(){
           deselectFrame();
           waitForElementPresent("cancel_btn");
           clickOnElementUsingActionBuilder(element("cancel_btn"));
       }
       
       public void addActivityPanelWebLinkLaunch(){
           scrollDown(element("web_link"));
           clickOnElementUsingActionBuilder(element("web_link"));
           waitTOSync();
           switchToActivityIFrame();
           waitForElementPresent("enter_url_txt");
           Assert.assertEquals(element("enter_url_txt").getText(),"Enter URL");
       }
       
        public void addActivityPanelRSSAppLaunch(){
           scrollDown(element("rss_app_link"));
           clickOnElementUsingActionBuilder(element("rss_app_link"));
           waitTOSync();
           switchToActivityIFrame();
           waitForElementPresent("rssfeed_title_header");
           Assert.assertEquals(element("rssfeed_title_header").getText(),"Add RSS Feed Activity");
       }
       
        public void addActivityPanelYSUAppLaunch(){
           scrollDown(element("ysu_link"));
           clickOnElementUsingActionBuilder(element("ysu_link"));
           waitTOSync();
           switchToActivityIFrame();
           waitForElementPresent("ysu_title_header");
           Assert.assertEquals(element("ysu_title_header").getText(),"Select assignment to be added.");
       }
       
         public void addActivityPanelSVRAppLaunch(){
           scrollDown(element("svr_link"));
           clickOnElementUsingActionBuilder(element("svr_link"));
           waitTOSync();
           switchToActivityIFrame();
           waitForElementPresent("svr_txt");
           Assert.assertEquals(element("svr_txt").getText(),"Speech Video Repository");
       }
        
         public void addActivityPanelQuestiaAppLaunch(){
           scrollDown(element("questia_link"));
           clickOnElementUsingActionBuilder(element("questia_link"));
           waitTOSync();
           switchToActivityIFrame();
           waitForSpinnerToDisappear();
           waitForElementPresent("questia_project_txt");
           Assert.assertEquals(element("questia_project_txt").getText(),"Active project:");
       }
        
       public void addDeleteActivityThroughTA(){
           scrollDown(element("flashcards_link"));
           clickOnElementUsingActionBuilder(element("flashcards_link"));
           waitTOSync();
           switchToActivityIFrame();
       } 
       
        
}
    

