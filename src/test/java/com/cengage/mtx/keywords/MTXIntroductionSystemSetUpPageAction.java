/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.BasePageActions;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author nikitaaggarwal
 */
public class MTXIntroductionSystemSetUpPageAction extends BasePageActions{
    
    String[] s;
    
    public MTXIntroductionSystemSetUpPageAction(WebDriver driver) {
        super(driver, "MTXIntrodSystemSetUp");
    } 
    String currentScore;
    String classAverage;
    
    public void verifyPreparationTabIsSelected(){
        wait.hardWait(4);
            isElementDisplayed("verify_Prep_slctd");
            
            Reporter.log("Preparation tab is selected", true);
            
    }
    
    public void clickOnQuestionTab(){
        wait.hardWait(4);
            
            element("questionTab").click();
            wait.hardWait(2);
            
    }
    
    public void clickOnPrepTab(){
            
            element("prepTab").click();
            wait.hardWait(2);
            
    }
    
    
    
     
     
}
