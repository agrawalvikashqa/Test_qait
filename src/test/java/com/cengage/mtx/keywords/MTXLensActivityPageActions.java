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
import org.testng.Assert;

/**
 *
 * @author mohammadparvez
 */
public class MTXLensActivityPageActions extends BasePageActions  {
    
    String SelectedLensName;
    String changedSelectedLensName;
    
    public MTXLensActivityPageActions(WebDriver driver) {
        super(driver, "MTXLensActivityPage");
    }
    
    public void verifyContinueButtonDisabledOnLensSelectionPage(){
        element("verifyContinueButton_disabled");
    }
    
    public void selectFirstLensOnLensSelectionPage(){
        
        element("lensSelect_Radiobtn").click();
        SelectedLensName = driver.findElement(By.xpath("(//span[@class='ci-choice-descr'])[2]//h3")).getText();
        System.out.println("Selected Lens is : " +SelectedLensName);
    }
    
    public void clickContinueButtonOnLensSelectionPage(){
        element("continue_btn_lensSelect").click();
    }
    
    public void getSelectedLensName(){
        element("lensName").getText();
        System.out.println("Selected Lens is : " +element("lensName").getText());
    }
    
    public void verifyLensNameOnActivityHeader(){
        wait.hardWait(4);
        String lensNameOnActivityHeader = driver.findElement(By.xpath("//span[@id='current-track']")).getText();
        
        System.out.println(lensNameOnActivityHeader);
        Assert.assertTrue(SelectedLensName.contains(lensNameOnActivityHeader), "names do not match");
      //  Assert.assertTrue(lensNameOnActivityHeader.equalsIgnoreCase(SelectedLensName));
        
    }
    
  
    
    public void clickOnLensChangeButton(){
        element("lensChange_btn").click();
        try {
            handleAlert();
        }
        catch (Exception e) {
            System.out.println("No alert");
        }
    }
    
    public void changeLens(){
        waitTOSync();
        element("lensSelect_Radiobtn2").click();
        changedSelectedLensName = driver.findElement(By.xpath("(//span[@class='ci-choice-descr'])[1]//h3")).getText();
        System.out.println("Selected Lens is : " +changedSelectedLensName);
    }
    public void acceptWarningPopUp(){
        wait.hardWait(2);
        Alert alert = driver.switchTo().alert();
        String lensText = alert.getText();
        Assert.assertTrue(lensText.contains("You cannot change your lens at this time because you already submitted the corresponding activity in this unit. You may continue the assignment until completion."), "User is able to change lens even if corresponding lens activity is submitted");
        wait.hardWait(2);
        alert.accept();
    }
    
    
    
    public void getSelectedChangedLensName(){
        
        element("changedlensName").getText();
        
    }
    public void verifyChangedLensNameOnActivityHeader(){
        wait.hardWait(4);
        String lensNameOnActivityHeader = driver.findElement(By.xpath("//span[@id='current-track']")).getText();
        
        Assert.assertTrue(changedSelectedLensName.contains(lensNameOnActivityHeader), "names do not match");
        
    }
    
    public void clickOnExpandAllLink(){
        
        element("ExpandAll_link").click();
    }
    
    
    
    
    
        
            
    
    
    
}
