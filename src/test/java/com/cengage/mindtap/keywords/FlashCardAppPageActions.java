/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

//import static com.qait.automation.utils.DateUtil.getTimeInMiliSec;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author QAI
 */
public class FlashCardAppPageActions extends BasePageActions {
    
    String cardCountBeforeHide;
    String cardCountBeforeRestore;

    public FlashCardAppPageActions(WebDriver driver) {
        super(driver, "FlashCardPage");

    }

    public void verifyFlashCardUI() {
        Assert.assertTrue(element("title_flashcard").getText().equalsIgnoreCase("Flashcards"), "Unable to locate FlashCard");
      

    }

    public void createFlashCard(String key, String value) {
        switchToDefaultContent();
        switchToFlashCardFrame();
        clickOnCreateCardButton();
        saveFlashCard(key, value);

    }

    void saveFlashCard(String keyTerm, String definition) {
        element("text_keyTerm").sendKeys(keyTerm);
        element("text_definition").sendKeys(definition);
        element("btn_save").click();

    }

    void clickOnCreateCardButton() {
        element("btn_createCard").click();
    }

    /**
     * Click on card to flip.
     */
    public void clickOnCardToFlip() {
        waitTOSync();
        element("link_flipCard").click();

    }

    public int cardDeckCount() {
        wait.waitForPageToLoadCompletely();
        switchToDefaultContent();
        switchToFlashCardFrame();
        String deckCountString = element("card_count").getText();
       // System.out.println("****deckcountString"+deckCountString+"*****");
        int deckCount = Integer.parseInt(deckCountString.substring(deckCountString.lastIndexOf(" ") + 1));
       //System.out.println("****deckcountBefore"+deckCount+"*****");
        return deckCount;
    }
    
    public void clickOnHideCardOption(){
      waitTOSync();
      cardCountBeforeHide =element("txt_currentflashcard").getText();
        waitForElementPresent("link_hidecard");
         element("link_hidecard").click();
        waitTOSync();
    }
    
     public boolean verifyCardIsHiden(){
        String cardCountAfterHide=element("txt_currentflashcard").getText();
        return (cardCountBeforeHide.equalsIgnoreCase(cardCountAfterHide));
    }
     
    public boolean verifyCardRestored(){
        String cardCountAfterRestore=element("txt_currentflashcard").getText();
        return (cardCountBeforeRestore.equalsIgnoreCase(cardCountAfterRestore));
   
    }
    
    /**
     * Click on restore card option.
     */
    public void clickOnRestoreCardOption(){
        cardCountBeforeRestore=element("txt_currentflashcard").getText();
        waitForElementPresent("img_settings");
        element("img_settings").click();
        waitForElementPresent("link_restoreCard");
        element("link_restoreCard").click();
        waitForElementPresent("btn_restoredeck");
        element("btn_restoredeck ").click();
        waitTOSync();
    }
    
     boolean verifyRestoreCardOptionDisabledInSettingMenu(){
        waitForElementPresent("img_setting");
         element("img_setting").click();
        return element("btn_restore").isEnabled();
    }
     
      boolean verifyNextPreviousAndShuffleCard(){
        element("btn_nextcard").click();
        waitForElementPresent("btn_previouscard");
          element("btn_previouscard").click();
        waitForElementPresent("link_shuffledeck");
          element("link_shuffledeck").click();
        return true;
    }
      
     public  boolean verifyPrintDialogBoxOpened(){
        return isElementDisplayed("dialog_print");
    }
    public void selectChapterForFlashCardActivity() {
        //waitForSpinnerToDisappear();
        switchToFlashCardFrame();
        waitTOSync();
        waitForElementPresent("radio_btn_chapter");
        element("radio_btn_chapter").click();
        waitForElementPresent("btn_continue");
        element("btn_continue").click();
    }

    public boolean verifyFlashCardIsAdded(String term) {
        return (element("newflashcard", term).getText()).equalsIgnoreCase(term);

    }

    public void verifyme() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void waitForFcSpinnerToDisappear() {
        waitForSpinnerToDisappear();
    }

    public String appendTimeStamp() {
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date;
        date = new Date();
        String currentDate = (dateFormat.format(date));
        return currentDate;
    }



    public boolean verifyUsersAddedFlashCard(String description) {
        waitTOSync();
        return isElementDisplayed("lpn_description", description);
    }

    public void closeFlashCard() {
        element("link_close").click();
        waitTOSync();
    }

    boolean verifyDeleteButtonDisplayed() {
        return isElementDisplayed("link_close");
    }

  
    public void removeCard(String key) {
        boolean flag = true;
        while (flag) {
            element("card_deck").click();
            String keyItem = element("keyterm").getText();
            if (keyItem.contains(key)) {
               element("edit_card").click();
                waitTOSync();
                element("delete_card").click();
                waitTOSync();
                acceptAlertWindow();
                flag = false;
            }
        }
        
    }
/**
     * Removes the added flash card.
     *
     * @param key the key
     */
    public void removeAddedFlashCard(String key) {
        //switchToFlashCardFrame();
        removeCard(key);
        switchToDefaultContent();
        waitTOSync();

    }
    
    /**
     * Click on print option.
     */
    public void clickOnPrintOption(){
        waitForElementPresent("img_settings");
        element("img_settings").click();
        waitForElementPresent("link_print");
        element("link_print").click();
    }
    
      /**
     * Close print dialog box.
     */
    public void closePrintDialogBox(){
        //switchToFlashCardFrame();
        waitForElementPresent("btn_printclose");
        element("btn_printclose").click();
        waitTOSync();
    }
    
    public void addFlashCardActivity(){
        
        
    }

}
