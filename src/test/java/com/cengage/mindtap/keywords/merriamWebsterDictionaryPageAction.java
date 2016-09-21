/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.keywords;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author QAI
 */
public class merriamWebsterDictionaryPageAction  extends BasePageActions{
  
    public merriamWebsterDictionaryPageAction(WebDriver driver) {
        super(driver, "merriamWebsterDictionaryPage");
    }

    public void searchInDictionary(String searchWord) {
        boolean flag1;
        //Reporter.log("Entered Function");
        flag1 = element("word_textBox").isDisplayed();
        if(flag1 = true){
        element("word_textBox").click();
        element("word_textBox").clear();
        element("word_textBox").sendKeys(searchWord);
        element("submit_btn").click();}


    }

    public boolean verifyWordPresentInDictionary(String searchResult) {
        Reporter.log(element("headword_heading").getText());
       return element("headword_heading").getText().equalsIgnoreCase(searchResult);
    }

    public boolean verifyWordNotPresentInDictionary(String searchResult) {
       Reporter.log(element("spelling-help_heading").getText());
       return element("spelling-help_heading").getText().equalsIgnoreCase(searchResult);
    }
    
    
    

      
}
