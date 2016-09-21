/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.BasePageActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
/**
 *
 * @author Kashyap
 */
public class MTXMasteryActivityPageActions extends BasePageActions {
    
    public MTXMasteryActivityPageActions(WebDriver driver) {
        super(driver, "MTXMasteryActivityPage");
    } 
    String currentScore;
    String classAverage;
    
    public void verifyNextButtonisPresentforMastery(){
        System.out.println("Checking for Next button presence");
        Assert.assertTrue(element("next_btn").isDisplayed(), "Next Button is not present at bottom");      
        System.out.println("Next Button is present at bottom");
    }
    
     public void verifyBackButtonisPresentforMastery(){
         System.out.println("Checking for Back button presence");
        element("back_btn").isDisplayed();
        System.out.println("Back Button is present at bottom");
    }
     
     public void verifyCurrentScorePresentatBottomforMastery(){
         System.out.println("Checking for CurrentScore is present at bottom left");
        element("verify_currentScore_atBottom").isDisplayed();
        System.out.println("Current Score is present at bottom");
    }
    
      
     public void verifynextButtonOnLeftPanelforMastery(){
        element("nextNavigation_btn").isDisplayed();
        System.out.println("Next Button is present On Left navigation Panel");
    }
     
     
     public void clickOnNextButtonPresentAtBottom(){
        wait.hardWait(2);
        element("next_btn").click();
        System.out.println("Next Button is clicked");
        wait.hardWait(3);
    }
     
     public boolean clickOnQuestionTab(){
         wait.hardWait(2);
         element("questionTab").click();
         return true;
     }
     
     public void verifySubmitButtonPresent(){
         if(clickOnQuestionTab() == true)
            Assert.assertTrue(element("submitAns_btn").isDisplayed(), "Submit ANswer button is not present"); 
     }
      
      public void userEnterBlankAnswersandSubmit(){
         wait.hardWait(2);
        element("submitAns_btn").click();
        Alert warning = driver.switchTo().alert();
        String warning_Msg = warning.getText();
        Assert.assertTrue(warning_Msg.contains("Please enter your response(s) before submitting the question"), "Pop-up is not displayed if user submits blank answer");
        
      
     }
     
     public void userEnterAnswers(){
         wait.hardWait(2);
        // element("answerField").sendKeys("8");
         List<WebElement> li = driver.findElements(By.xpath("//input[@type='text']"));
      for(int i=0; i<li.size(); i++){
           li.get(i).sendKeys("2");
        }
      
     }
     
     public void clickOnSubmitAnswerButton(){
         wait.hardWait(2);
           element("submitAns_btn").click();
     }
     
     public void clickOnSubmitButtonPresentInNavPanel(){
          wait.hardWait(2);
         
          scrollDown(elementWithoutWait("submit_btn_navPanel"));
          element("submit_btn_navPanel").click();
        }
     
     public void incorrectAnswerWarning(){
        try{
        Assert.assertTrue(element("incorrextAns_Warn").isDisplayed(), "Warning does not appear");
        element("submitAns_btn").click();
        }
        catch(Exception e){
            System.out.println("Incorrect answer warning does not appear");
        }
         
     }
     public void clickOnSubmitActivityForGradingButton(){
          wait.hardWait(2);
          element("final_Submit_btn").click();
          wait.hardWait(3);
          
        }
     
     
    
}
