/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author alokkumar
 */
public class ReadingActivityPageAction extends BasePageActions {
    
    
    /** The delete inline activities_list. */
    @FindBy(css="a[title='Remove']")
    List<WebElement> deleteInlineActivities_list;
    
    public String windowHandle;
    String activityTitleBeforeClose;
    
    public ReadingActivityPageAction(WebDriver driver) {
        super(driver, "ReadingActivityPage");
    }

    public void launchReadingActivityToAddInLineActivity(String unitName, String chapterName) {
        waitTOSync();
        waitTOSync();
        try{
        element("unitName_link", unitName).click();
            waitTOSync();
        ReportMsg.info("User Clicked on Unit " + unitName);
        }
        catch(Exception e){
            ReportMsg.info(unitName + "Unit Does not Exist");
        }
        element("chapterName_link", chapterName).click();
        ReportMsg.info("User Clicked on" + chapterName + " Chapter");
        waitForSpinnerToDisappear();
        waitTOSync();
        wait.hardWait(5);
        //element("chapterName_link", chapterName).click();
        //ReportMsg.info("User Launched " + chapterName + " Chapetr to add Inline Activity");

    }

    public void clickOnEditModeAndAddIconLiknsAndNavigateToChapterIntroductionPage() {
        waitTOSync();
        element("editMode_link").click();
        ReportMsg.info("User Clicked on Edit Mode Link");
        waitTOSync();
        element("addIcon_link").click();
        ReportMsg.info("User Clicked on Chapter Content");
        waitTOSync();
        waitTOSync();
    
    }


         public void clickOnEditMode() {
         navigateToChapterIntroductionPage();
         try {clickOnElementUsingActionBuilder(element("editMode_link"));
         } 
        catch (Exception e) {
         element("editMode_link").click();
         ReportMsg.info("User Clicked on Edit Mode Link");
        }
    }
    
    
    public void verifyTOC(){
        if(verifyTOCButtonIsPresent()==true){
            verifyNavigateToSubChapter();
            element("chapterContent_link").click();
        }
    }
    
    public boolean verifyTOCButtonIsPresent(){
        waitForSpinnerToDisappear();
        try {
            element("chapterContent_link").isDisplayed();
            return false;
        } catch (Exception e) {
            System.out.println("test 123");
               ReportMsg.info("Already on TOC ");
               return true;
        }
    }
    
    public void verifyNavgationViaSkimmerAndArrow(){
        if(verifyTOCButtonIsPresent()==true){
            Assert.assertTrue(element("nextLink").isDisplayed(), "Next navigation is not present");
            clickOnActivityNextButton();
            System.out.println("verifying page title presence");
            Assert.assertTrue(element("verify_nextPageNavigated").isDisplayed(), "User is not navigated to next page; Next navigation not working");
            waitTOSync();
            System.out.println("verifying skimmer presence");
            
            element("skimmerNavigate").click();
            Assert.assertTrue(element("verify_nextPageNavigated").isDisplayed(), "User is not navigated to next page; Next navigation not working");
        }
    }
    boolean verifyNavigateToSubChapter(){
        
            String toc_title = element("tocTitle").getText();
            System.out.println(toc_title);
            waitTOSync();
            element("tocTitle").click();
            String toc_titleOnPage = element("toc_titleOnPage").getText();
            Assert.assertTrue(toc_title.contentEquals(toc_titleOnPage), "Navigation via toc links is not working");
        return true;
    }
    
     public void selectActivitytoAdd(){
        Assert.assertTrue(element("activityTitle").isDisplayed(), "Activity list is not present");
        element("activityTitle").click();
        Assert.assertTrue(element("fullChapterSelection").isDisplayed(), "full chapter checkbox is not present");
        element("fullChapterSelection").click();
        Assert.assertTrue(element("continue_btn").isDisplayed(), "chapter radio button is not present");
        element("continue_btn").click();
    }
     
     public void addTextBoxHeading(String heading){
        element("textBox_heading").clear();
        element("textBox_heading").sendKeys(heading);
    }
     
     public void addTextboxDescription(String desc){
       
      // switchToFrame("distinct_activity_create_frame");
      waitTOSync();
      waitTOSync();
      waitTOSync();
       switchToFrame("bodyText_ifr");
       WebElement element = driver.findElement(By.id("tinymce"));
       driver.findElement(By.id("tinymce")).clear();
       System.out.println("Editing text box description in text input");
       element.sendKeys(Keys.CONTROL + "b");
       element.sendKeys(desc);
       element.sendKeys(Keys.ENTER);
    }
    
    public void saveTextBox(){
        waitTOSync();
        waitTOSync();
        executeJavascript("document.getElementById('init_save').click()");
    }
    
    public void clickOnInlineEditAndEditActivity(){
          ReportMsg.info("User Edit Added Inline Activity");
          waitTOSync();
          element("InlineEditIcon").isDisplayed();
          element("InlineEditIcon").click();
          ReportMsg.info("User Clicked On inline edit icon ");      
      }
    
    public void studentVerifyTextboxAppear(){
        waitForSpinnerToDisappear();
        waitTOSync();
        waitTOSync();
        clickOnActivityNextButton();
        Assert.assertTrue(element("studentTextbox_verify").isDisplayed(), "Admin added textbox does not appear");
    }
    
    public void clickOnChapterContentLink(){
        element("chapterContent_link").click();
    }
    public void verifyChapterTitleBeforeClosingActivity(){
       waitTOSync();
       activityTitleBeforeClose =  element("openedActivity_chapterTitle").getText();
       System.out.println("Chapter Title before closing: " +activityTitleBeforeClose);
    }
    
    public void verifyChapterTitleAfterLaunchingSameActivity(){
       String activityTitleClose =  element("openedActivity_chapterTitle").getText();
       Assert.assertTrue(activityTitleBeforeClose.contentEquals(activityTitleClose), "Activity does not launch on same page");
       System.out.println("Chapter Title after relaunching: " +activityTitleClose);
    }
    
    
    public void addLinkToTextBox(){
        WebElement element = driver.findElement(By.id("tinymce"));
        
        element.sendKeys("linked text");
       // waitTOSync();
        element.sendKeys(Keys.chord(Keys.SHIFT,Keys.HOME));
        waitTOSync();
        waitTOSync();
       switchToDefaultContent();
         waitTOSync();
        switchToFrame(element("modelOptionsEditFrame1"));
     waitTOSync();
        executeJavascript("document.getElementsByClassName('mceIcon mce_link')[0].click();");
// element("hyperlink").click();
        windowHandle=driver.getWindowHandle();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        element("linkBox").clear();
        element("linkBox").sendKeys("http://google.com");
        element("linkTitle").clear();
        element("linkTitle").sendKeys("Google");
        element("linkInsert").click();
        
        waitTOSync();
        driver.switchTo().window(windowHandle);
        System.out.println("window switched");
        switchToDefaultContent();
        switchToFrame(element("modelOptionsEditFrame1"));
        switchToFrame("bodyText_ifr");
        waitTOSync();
        waitTOSync();
        
        Assert.assertTrue(element("linkedText").isDisplayed(), "text is not linked");
    }
    
    public void clickOnEditModeAndDeleteInlineActivity() {
        navigateToChapterIntroductionPage();
        waitTOSync();
        element("editMode_link").click();
        ReportMsg.info("User Clicked on Edit Mode Link");
        element("deleteIcon_link").click();
        ReportMsg.info("User Clicked on Delete Icon");
        switchToAlert().accept();
    }
    
    public void clickOnActivityNextButton() {
        waitTOSync();
        waitTOSync();
        System.out.println("clicking on next button");
        element("nextLink").click();
        ReportMsg.info("User Clicked on Next Link");
    }
    
    public void closeOpenActivity() {
        
        element("CloseLink").click();
         
}
    
    
    public void navigateToChapterIntroductionPage() {
        waitForSpinnerToDisappear();
       try {
            element("chapterContent_link").click();
            ReportMsg.info("User Clicked on Chapter Content");
            wait.hardWait(2);
        }
       catch(Exception e){}
        element("chapterIntroductionPage_link").click();
        ReportMsg.info("User Navigated to chapter Introduction");
    }

    public void verifyAddedInLineWeblinkActivity(String anotherWebURL) {
        assert element("addedActivity_link", anotherWebURL).isDisplayed();
        ReportMsg.info("User Verified inline activity is added");
    }

    public void verifyAddedInLineWeblinkURL(String anotherWebURL) {
        
        waitTOSync();
        waitTOSync();
        element("addedActivity_link", anotherWebURL).click();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        waitTOSync();
        Assert.assertTrue(element("cnnlogo").isDisplayed());
        waitTOSync();
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        ReportMsg.info("User Launched inline activity URL");
    }
    
    
    
    public void clickOnReadSpeaker() {
        element("ReadSpeaker_btn").click();
    }

    public boolean verifyFontSizer() {
        boolean flag1, flag2, flag3;
        
        waitForElementPresent("selectSmallText");
        element("selectSmallText").click();
        flag1=element("bodyFont","fontSmall").isDisplayed();
        
        element("selectMediumText").click();
        flag2=element("bodyFont","fontMedium").isDisplayed();
        
        element("selectLargeText").click();
        flag3=element("bodyFont","fontLarge").isDisplayed();
        
        if (flag1==true && flag2==true & flag3==true) {
            return true;
        }
        else{
            return false;
        }
    }

    public void Print_sectionRadioButton(){
        
        waitTOSync();
        waitTOSync();
        Assert.assertTrue(element("Print_sectionRadioButton").isDisplayed(), "Section radio button is not present");
        element("Print_sectionRadioButton").click();
    }
    
    public void Print_chapterRadioButton(){
        
        Assert.assertTrue(element("Print_chapterRadioButton").isDisplayed(), "Entire Reading Activity radio button is not present");
        element("Print_chapterRadioButton").click();
    }
    
    public void printSection_ContentVerify(){
        
         Assert.assertTrue(element("printPreviewHeadingText").isDisplayed(), "Section heading is not accurate");
    }
    
    public boolean entireSection_ContentVerify() {
        
        Assert.assertTrue(element("entire_ChapterContent").isDisplayed(), "Entire chapter is not displayed");
        return true;
    }

    public void clickOnhelpicon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean verifyhelpicon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void clickOnPrintPreviewicon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean verifyPrintIconWorkingFine(){
        waitTOSync();
        String chapterHeadingTextOnReader = getChapterHeadingText();
        System.out.println("chapterHeadingTextOnReader: " + chapterHeadingTextOnReader);
        clickOnPrintIcon();
        String headingTextOnPrintPreview = getHeadingTextOnPrintPreview();
        System.out.println("headingTextOnPrintPreview: " + headingTextOnPrintPreview);
        System.out.println(headingTextOnPrintPreview.split(" ")[1]);
        return chapterHeadingTextOnReader.contains(headingTextOnPrintPreview.split(" ")[1]);
    }
    
    public boolean verifyFullBookPrintIconWorkingFine(){
        waitTOSync();
        switchToDefaultContent();
        switchToFrame(element("148_NB_Dock_IFrame"));
        clickOnPrintIconInApp();
        deselectFrame();
        switchToPrintPreviewIFrame();
        waitTOSync();
        waitTOSync();
        //Assert.assertTrue(element("fullBook_ImageVerify").isDisplayed(), "Full Book image is not displayed");
        return true;
    }
    
    

    String getChapterHeadingText(){
        return element("chapterHeadingText").getText();
    }
    private void clickOnPrintIconInApp() {
        
         executeJavascript("document.getElementById('init_printButton').click();");
    }

    private void clickOnPrintIcon() {
        
         element("printbtn").click();
    }

    String getHeadingTextOnPrintPreview(){
        deselectFrame();
        switchToPrintPreviewIFrame();
        return element("printPreviewHeadingText").getText();
    }

    public void selectFrameAndDeleteInlineActivity() {
          element("deleteInline").click();
          acceptAlertWindow();
}
    public void SwitchToUnit(String unitName){
        waitTOSync();
        scrollDown(element("unitName_link", unitName));
        element("unitName_link", unitName).click();
            waitTOSync();
        ReportMsg.info("User Clicked on Unit " + unitName);
    }
    public void clickOnAddIconLikns() {
        waitTOSync();
        element("addIcon_link").click();
        ReportMsg.info("User Clicked on Chapter Content");
    }

    public void clickOnEscButton() {
          Actions action = new Actions(driver);
	   action.sendKeys(Keys.ESCAPE);
    }
    
    public String verifyHelpText() {
       String helptext= element("helpoverlayprinttext").getText();
        //System.out.println("****"+helptext+"******");
        return helptext;
    }
    public boolean verifyTheReadingActivity(String chapterName){
        return element("chapterName_link", chapterName).isDisplayed();   
    }
}
