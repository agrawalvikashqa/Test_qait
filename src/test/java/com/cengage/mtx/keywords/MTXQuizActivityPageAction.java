/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.BasePageActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 *
 * @author nikitaaggarwal
 */
public class MTXQuizActivityPageAction extends BasePageActions{
    
    String[] s;
    
    public MTXQuizActivityPageAction(WebDriver driver) {
        super(driver, "MTXQuizPage");
    } 
    String currentScore;
    String classAverage;
    
    public void verifyQuestionTabIsSelectedByDefault(){
        if(QuestionTabSelected() == false)
            Assert.assertTrue(element("verify_Ques1_Slctd").isDisplayed(), "Question Tab is not selected"); 
    }
    
    
     public boolean QuestionTabSelected(){
         wait.hardWait(2);
         element("verify_Ques1_Slctd").isDisplayed();
         return false;
        }
     
     public void enterAnswers(){
         element("radioBtnSelect").click();
     }
     
     public void verifyattemptsRemaining(){
         String attemptRemainingBeforeSubmit = element("attemptRemaining").getText();
         System.out.println("Attempts remaining before submitting: " +attemptRemainingBeforeSubmit);
         
     }
     
     public void verifyattemptsRemainingBeforeSubmit(){
         String attemptRemainingBeforeSubmit = element("attemptRemaining").getText();
         s = attemptRemainingBeforeSubmit.split(" ");
         for(int i=0; i<s.length; i++){
             System.out.println("Attempts remaining before submitting: " + s[i]);
         }
     }
     
     public void verifyattemptsRemainingAfterSubmit(){
         String attemptRemainingAfterSubmit = element("attemptRemaining").getText();
        String st[] = attemptRemainingAfterSubmit.split(" ");
         for(int i=0; i<s.length; i++){
             System.out.println("Attempts remaining before submitting: " + st[i]);
         }
         
         int attemptCountBeforeSubmit = Integer.parseInt(s[0]);
         int attemptCountAfterSubmit = Integer.parseInt(st[0]);
         Assert.assertEquals(attemptCountAfterSubmit+1, attemptCountBeforeSubmit, "Attempt not deleted");
         
         
        
     }
     
     
}
