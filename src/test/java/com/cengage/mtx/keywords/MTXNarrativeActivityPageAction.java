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
 * @author mohammadparvez
 */
public class MTXNarrativeActivityPageAction extends BasePageActions  {
    
    public MTXNarrativeActivityPageAction(WebDriver driver) {
        super(driver, "MTXNarrativeActivityPage");
    }
    
    public void selectRadioButton(){
        
        element("radio_btn").click();
        System.out.println("User selected answer");
    }
    
    public void selectBlank(){
        element("blank_link").click();
    }
    
    public void clickOnCheckAnswerButton(){
        wait.hardWait(4);
        element("checkAnswer_btn").click();
        System.out.println(" User clicked on CheckAnswer Button");
    }
    
    public void clickOnCloseAndSubmitButton(){
        wait.hardWait(2);
        scrollDown(element("closeAndSubmit_btn"));
        element("closeAndSubmit_btn").click();
        System.out.println(" User clicked on Close and Submit Button");
    }
    
    public void verifyDashboardAppear(){
        element("DashboardAppear_verify").isDisplayed();
        System.out.println(" User is navigated to dashboard");
    }
    
    public boolean accordionCollapseLink(){
        return elementWithoutWait("collapse_link").isDisplayed();
        
    }
    
    public void collapsedView(){
        wait.hardWait(5);
        if(accordionCollapseLink() == true){
         element("collapse_link").click();
        }
        else{
            System.out.println("tab is not collapsed by default");  
        }
    }
        
        public void expandedView(){
        if(accordionCollapseLink() == false){
         element("expandLink").click();
        }
        }
        
        public void launchGradebook(){
            element("launchGradebook_Link").click();
        }
        
        public void clickOnStudentLink(){
            wait.hardWait(2);
            element("studentName").click();
        }
        
        public void clickOnActivityLinkInGradebook(String value){
            wait.hardWait(4);
            scrollDown(element("GB_ActivityLink", value));
            //scrollDown(element("GB_ActivityLink", value));
            element("GB_ActivityLink", value).click();
        }

        
        
        public void clickOnDeleteTakeLink(){
            wait.hardWait(5);
            element("DeleteTake").click();
        }
        
        public void clickOnConfirmButtoninGB(){
            wait.hardWait(2);
            element("deleteConfirm_Button").click();
            element("scoreDeletedConfirmation").isDisplayed();
        }
        
        public void inProgressSIVerify(){
            element("InProg_SI").isDisplayed();
        }
         
         
        
            
    
    
    
}
