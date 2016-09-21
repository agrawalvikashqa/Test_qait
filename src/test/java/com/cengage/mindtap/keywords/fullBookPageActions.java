/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.keywords;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 *
 * @author QAI
 */
public class fullBookPageActions  extends BasePageActions{
  
    public fullBookPageActions(WebDriver driver) {
        super(driver, "fullBookPage");
    }
    
    public void verifyFullBookTitle(){
        Assert.assertTrue(element("title_fullbook").getText().equalsIgnoreCase("Full Book"),"Unable to locate FullBook Title");
    }

    public void verifyFullBookUI() {
       switchToFullBookFrame(); 
    }
  /*public void verifyFullBookTitle(){
        Assert.assertTrue(element("title_fullbook").getText().equalsIgnoreCase("Full Book"),"Unable to locate FullBook Title");
    }*/ 
   public void verifyButtonsPresentOnStaticFullBookBar(){
        Assert.assertTrue(element("ChaptersButton").isDisplayed(),"Chapter Button Not Found");
        Assert.assertTrue(element("PrintButton").isDisplayed(),"Print Button Not Found");
        Assert.assertTrue(element("fontSizeLargeButton").isDisplayed(),"Large size font button not found");
        Assert.assertTrue(element("fontSizeMediumButton").isDisplayed(),"Medium size font button not found");
        Assert.assertTrue(element("fontSizeSmallButton").isDisplayed(),"Small size font button not found");
        Assert.assertTrue(element("help_icon_fullbook").isDisplayed(),"Help Icon not found");
    }
     public boolean verifyPrintPreview() {
            return element("PrintPreview").isDisplayed();
    }
     
   public void verifySkimmerDisplay(){
        Assert.assertTrue(element("skimbar").isDisplayed(),"Skimmer Does not display");
    }
   
   public void verifyFullBookPrintSectionContentVerify(){
   
       
   }
    public void buttonOnFullBook() {
        element("PrintButton");
        element("ChaptersButton");
        element("fontSizeLargeButton");
        element("fontSizeMediumButton");
        element("fontSizeSmallButton");
        element("skimbar");
        element("NextButton");

    }
   /* public void verifySkimmerDisplay(){
        Assert.assertTrue(element("skimbar").isDisplayed(),"Skimmer Does not display");
    } */
    
    
    public void clickOnNextButton() {
        waitForSpinnerToDisappear();
        clickOnElementUsingActionBuilder(element("NextButton"));
       //element("NextButton").click();
        waitForSpinnerToDisappear();
        try {
            element("BackButton");
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
           waitForSpinnerToDisappear();
           element("BackButton");
        }
    }
    
    

      public void clickOnBackButton() {
        waitForSpinnerToDisappear();
        clickOnElementUsingActionBuilder(element("BackButton"));
          
        try {
            element("MediaCreditText");
        }catch(TimeoutException e)
        {
           System.out.println(e.getMessage());
           waitForSpinnerToDisappear();
           element("MediaCreditText");
        }
        
    }



   /* public void buttonOnFullBook() {
        element("PrintButton");
        element("ChaptersButton");
        element("fontSizeLargeButton");
        element("fontSizeMediumButton");
        element("fontSizeSmallButton");
        element("skimbar");
        element("NextButton");
    }
    
    public void verifyButtonsPresentOnStaticFullBookBar(){
        Assert.assertTrue(element("ChaptersButton").isDisplayed(),"Chapter Button Not Found");
        Assert.assertTrue(element("PrintButton").isDisplayed(),"Print Button Not Found");
        Assert.assertTrue(element("fontSizeLargeButton").isDisplayed(),"Large size font button not found");
        Assert.assertTrue(element("fontSizeMediumButton").isDisplayed(),"Medium size font button not found");
        Assert.assertTrue(element("fontSizeSmallButton").isDisplayed(),"Small size font button not found");
        Assert.assertTrue(element("help_icon_fullbook").isDisplayed(),"Help Icon not found");
    }
      */


    public void clickOnChaptersButton() {
        element("ChaptersButton").click();
        elements("ChapterLinks").get(1).isDisplayed();
        element("CloseChapterButton").click();
    }

    public void clickOnFontSelection() {
    
        element("fontSizeSmallButton").click();
        //element("fontSizeSmallSelected");
        try {
            element("fontSizeSmallSelected");
        }catch(TimeoutException e)
        {
           System.out.println(e.getMessage());
           waitForSpinnerToDisappear();
           element("fontSizeSmallSelected");
        }
        
        element("fontSizeMediumButton").click();
        //element("fontSizeMediumSelected");
       
         try {
            element("fontSizeMediumSelected");
        }catch(TimeoutException e)
        {
           System.out.println(e.getMessage());
           waitForSpinnerToDisappear();
           element("fontSizeMediumSelected");
        }
       
        element("fontSizeLargeButton").click();        
        //element("fontSizeSmallSelected");
        
         try {
            element("fontSizeLargeSelected");
        }catch(TimeoutException e)
        {
           System.out.println(e.getMessage());
           waitForSpinnerToDisappear();
           element("fontSizeLargeSelected");
        }
        
    }
    
    public void clickOnPrintSelection() {
        element("PrintButton").click();
    }
    
    public void clickOnHelpButton() {
        element("HelpButton").click();
        element("CloseHelp").click();
    }
            

     public void verifyChapterOpened() {

        element("ChaptersButton").click();
        String name = elements("ChapterLinks").get(1).getText();
        String[] nameHeading = name.split("\\.");
        System.out.println(nameHeading[1].trim());
        elements("ChapterLinks").get(1).click();
        element("ChapterHeading",(nameHeading[1].trim())).isDisplayed();
    }



    
  /*  public void clickOnFontSelection() {
    
        element("fontSizeSmallButton").click();
        //element("fontSizeSmallSelected");
        try {
            element("fontSizeSmallSelected");
        }catch(TimeoutException e)
        {
           System.out.println(e.getMessage());
           waitForSpinnerToDisappear();
           element("fontSizeSmallSelected");
        }
        
        element("fontSizeMediumButton").click();
        //element("fontSizeMediumSelected");
       
         try {
            element("fontSizeMediumSelected");
        }catch(TimeoutException e)
        {
           System.out.println(e.getMessage());
           waitForSpinnerToDisappear();
           element("fontSizeMediumSelected");
        }
       
        element("fontSizeLargeButton").click();        
        //element("fontSizeSmallSelected");
        
         try {
            element("fontSizeLargeSelected");
        }catch(TimeoutException e)
        {
           System.out.println(e.getMessage());
           waitForSpinnerToDisappear();
           element("fontSizeLargeSelected");
        }
        
    }
     
     public void clickOnPrintSelection() {
        element("PrintButton").click();
    }
     
     public boolean verifyPrintPreview() {
            return element("PrintPreview").isDisplayed();
    }
     */
    


    public boolean verifyClickOnPrintSelection() {
       
            return element("PrintPreview").isDisplayed();
    }
    
      
}
