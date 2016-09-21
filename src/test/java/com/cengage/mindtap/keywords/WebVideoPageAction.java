/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.keywords;

import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 *
 * @author QAI
 */
public class WebVideoPageAction  extends BasePageActions{
  
    public WebVideoPageAction(WebDriver driver) {
        super(driver, "webvideoPage");
    }

     public boolean verifyWordPresentInDictionary(String searchResult) {
        Reporter.log(element("headword_heading").getText());
       return element("headword_heading").getText().equalsIgnoreCase(searchResult);
    }
     
    public void searchyoutubevideo(String text) {
        assert element("inputfield").isDisplayed();
        element("inputfield").click();
        element("inputfield").clear();
        element("inputfield").sendKeys(text);
        ReportMsg.info("User enter Url "+ text +" in url text box");
        element("searchbutton").click();
        assert element("searchresultsheader").isDisplayed();  
        waitTOSync();
        int results = (driver.findElements(By.xpath("//div[@class='yt_search_result']/div"))).size();
        Assert.assertEquals(10, results, "10 Search results are displaying fine");
    }
    
    public void showhideoptions() {
        assert element("showoptions").isDisplayed();
        ReportMsg.info("Show Options button is displaying fine");
        element("showoptions").click();
        assert element("sortbydropdown").isDisplayed();
        ReportMsg.info("Sort By Drop Down is displaying fine");
        assert element("hideoptions").isDisplayed();
        Select dropdown = new Select(element("sortbydropdown"));
        dropdown.selectByIndex(0);
        assert element("searchresultsheader").isDisplayed(); 
        ReportMsg.info("Search results are displaying fine");
        dropdown.selectByIndex(2);
        assert element("searchresultsheader").isDisplayed(); 
        ReportMsg.info("Search results are displaying fine");
        dropdown.selectByIndex(3);
        assert element("searchresultsheader").isDisplayed(); 
        ReportMsg.info("Search results are displaying fine");
        element("hideoptions").click();
        assert element("showoptions").isDisplayed();
        ReportMsg.info("Show Options button are displaying fine");
    }
    
    public void helpbutton() {
        assert element("helpbutton").isDisplayed();
        ReportMsg.info("Help button is displaying fine");
        element("helpbutton").click();
        assert element("helppageoverlay").isDisplayed();
        ReportMsg.info("Help Overlay is displaying fine");
        element("crossicon").click();
    }
    
    public void viewInlineWebVideoActivity(){
        element("Next").click();
        waitTOSync();
        Assert.assertTrue(element("InlineActivityVerify").isDisplayed(), "Inline Web Video Activity is not present");
        System.out.println("Activity is visible to student");
     }
    
    public void clickOnInlineEditAndEditActivity(){
        wait.hardWait(4);
          ReportMsg.info("User Edit Added Inline Activity");
          waitForElementPresent("InlineEditIcon");
          //element("InlineEditIcon").click();
          //clickOnElementUsingActionBuilder(element("InlineEditIcon"));
          element("InlineEditIcon").click();
          ReportMsg.info("User Clicked On inline edit icon ");      
      }
    
    public void clickOnChapterContentLink(){
        element("chapterContent_link").click();
    }
    
    public void addwebvideoactivity(String text) {
        waitTOSync();
        executeJavascript("document.getElementsByClassName('yt_video_choice')[0].click();");
        assert element("continuebutton1").isDisplayed();
        ReportMsg.info("Continue button is displaying fine");
        clickOnElementUsingActionBuilder(element("continuebutton1"));
        //element("continuebutton1").click();
        ReportMsg.info("User Clicked on Continue Button");
        element("addBefore_txt").click();
        element("addBefore_txt").clear();
        element("addBefore_txt").sendKeys(text);
        ReportMsg.info("User added text in before text field");
        element("addAfter_txt").click();
        element("addAfter_txt").clear();
        element("addAfter_txt").sendKeys(text);
        ReportMsg.info("User added text in after text field");
        element("continuebutton2").isDisplayed();
        element("continuebutton2").click();
    }
    
    public void verifyWebVideoActivityLauched(String webLinkActivity_title) {
        assert element("activitytitle").isDisplayed();
        ReportMsg.info("User verified text after launch distinct web Video Activity");
    }
    
    public void fillEntryInField(String anotherTitle, String newText) {
        element("addBefore_txt").click();
        element("addBefore_txt").clear();
        element("addBefore_txt").sendKeys(newText);
        ReportMsg.info("User added text in before text field");
        element("addAfter_txt").click();
        element("addAfter_txt").clear();
        element("addAfter_txt").sendKeys(newText);
        ReportMsg.info("User added text in after text field");
        executeJavascript("document.getElementById('ytdistinctvideo_continue').click()");
        ReportMsg.info("User clicked on continue button");
        switchToDefaultContent();
    }
    
    public void fillDueAvaialableDate() {
        element("available_input").click();
        //element("next_icon").click();
        waitTOSync();
        //element("start_date").click();
        element("done_button").click();
        waitTOSync();
        element("due_input").click();
        waitTOSync();
        element("next_icon").click();
        element("end_date").click();
        element("done_button").click();
        //switchToDefaultContent();
        executeJavascript("document.getElementById('init_save').click()");
        ReportMsg.info("User clicked on save button");
        waitTOSync();
    }
    
     public void lpnDateDisplay(){
          assert element("lpn_date").isDisplayed();
          ReportMsg.info("Due Date set on LPN");
      }
    
    public void addTextFields(String beforeText, String afterText){
          element("addBefore_txt").sendKeys(beforeText);
          ReportMsg.info("User enter text "+ beforeText +" in before text field");
          element("addAfter_txt").sendKeys(afterText);
          ReportMsg.info("User enter text "+ afterText +" in before text field");
      }
    
    public void clickonContinueAndSaveButton(){
         waitTOSync();
         String script = "document.getElementsByClassName('wv_button yt_edit_inline_button')[0].click();";
         ((JavascriptExecutor) driver).executeScript(script);
         ReportMsg.info("User Clicked On inline continue icon ");
          //waitForElementPresent("Continue");
      }
    
    public void editedTextVerification(String newText) {
        element("edited_beforetext", newText).isDisplayed();
        ReportMsg.info("Edited Before text is displaying");
        element("edited_aftertext", newText).isDisplayed();
        ReportMsg.info("Edited After text is displaying");
    }
    

      
}
