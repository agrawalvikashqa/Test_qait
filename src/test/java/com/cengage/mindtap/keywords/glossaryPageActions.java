/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 *
 * @author QAI
 */
public class glossaryPageActions  extends BasePageActions{
    
    public glossaryPageActions(WebDriver driver) {
        super(driver, "glossaryPage");
    }

    public boolean verifylettersAToZDisplayedAtTopForSelection() {
        int selectedatozlist=elements("selectedatoz").size();
        int unselectedatozlist=elements("unselectedatoz").size();
        Reporter.log("Total selected atoz list = "+selectedatozlist);
        Reporter.log("Total Unselected atoz list = "+unselectedatozlist);
        if((selectedatozlist+unselectedatozlist)==26)
            return true;
        else
            return false;
    }

    public boolean verifyAllGlossaryTermsDisplayedInAlphabeticOrder() {
        for (int i = 1; i <= 26; i++) {
            if(element("alphaIcon",getCharForNumber(i)).isDisplayed())
               continue;
            else
               return false;
        }
        return true;
    }
    
    
    public boolean allTermsDisplayedAsPerAlphabetSelection() {
    List<WebElement> termDefinationCount=elements("termDefination");
    for(int i=0;i<termDefinationCount.size();i++){
    String termdefination=termDefinationCount.get(i).getText();
    char termdef = termdefination.charAt(0);
    if(termdef=='a' || termdef=='A') 
        continue; 
    else 
        return false ;    
   }
    return true ;    
    }
    
    
    public boolean alphabetWithNoTermsAreNonClickable(){
    
        String termdefcount= element("termDefination").getText();
        char termdef = termdefcount.charAt(0);
        
        List<WebElement> nonClickableElement =elements("nonClickable");
        
        waitTOSync();
        for(int i=0;i<nonClickableElement.size();i++)
        {
            clickOnElementUsingActionBuilder(nonClickableElement.get(i));
           
           if (termdef=='a' || termdef=='A')
                continue;
           else
           {
                return false;
           }

        }
        return true;
        
    }
    
    public boolean AlphabetWithNoTermsAppearsGrayedOut(){
    
        List<WebElement> nonClickableElement =elements ("nonClickable");
        for(int i=0;i<nonClickableElement.size();i++)
        {
            String actualColor = nonClickableElement.get(i).getCssValue("color");
              System.out.println(actualColor);
              if(actualColor.contains("(102, 102, 102, 1)"))
              return true;
            else
                return false;
               }
    return true;
    }  
    
    public boolean ClickAnyAlphabet(String Alphabet){
        element("ClickAlphabet",Alphabet).click();
        return true;
    }              
    
    
    private String getCharForNumber(int i) {
    return i > 0 && i < 27 ? String.valueOf((char)(i + 'A' - 1)) : null;
   }
    public boolean verifytopOfPageDisplaysCorrectKeyTermcounter() {
        String termcount= (element("termcount").getText());
        String termdefcount= Integer.toString(elements("termDefination").size());
        Reporter.log("Defination Count on Heading = "+termcount);
        Reporter.log("Total Number of Defination(s) = "+termdefcount);
        if(termcount.contains(termdefcount))
             return true;
        else
             return false;
    }

    public boolean verifyClickAnyAlphabetRememberingLastSelectionCheck(String Alphabet) {
        return  element("ClickAlphabet",Alphabet).isDisplayed();
    }
    
}
