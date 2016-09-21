/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.BasePageActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 *
 * @author nikitaaggarwal
 */
public class MTXChemistrySurveyPageAction extends BasePageActions{
    
    String[] s;
    
    public MTXChemistrySurveyPageAction(WebDriver driver) {
        super(driver, "MTXSurveyPage");
    } 
    String currentScore;
    String classAverage;
    
    public void clickOnSurveyLink(){
        element("surveyLink").click();
    }
    
    public void verifySurveyPageAppears(){
        wait.hardWait(2);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        wait.hardWait(2);
        isElementDisplayed("surveyPageHeaderVerify");
        driver.switchTo().window(tabs2.get(0));
    }
    
    public void enterSurveyCode(){
        isElementDisplayed("enter_code");
        element("enter_code").sendKeys("120676");
        
    }
    
    public void clickOnNextButtonOnSurveyPage(){
       // scrollDown(elementWithoutWait("next_btn_surveyPage"));
       wait.waitForPageToLoadCompletely();
       wait.hardWait(3);
       JavascriptExecutor js = (JavascriptExecutor)driver;
       js.executeScript("window.scrollTo(0,10000)");
        clickOnElementUsingActionBuilder(element(("next_btn_surveyPage")));
        
        
//        isElementDisplayed("next_btn_surveyPage");
//        element("next_btn_surveyPage").click();
        
    }
    
    public void alertAcceptOnSurveyPage(){
        handleAlert();
    }
     
     
}
