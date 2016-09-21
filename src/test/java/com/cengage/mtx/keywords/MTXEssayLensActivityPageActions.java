/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.BasePageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author mohammadparvez
 */
public class MTXEssayLensActivityPageActions extends BasePageActions  {
    
    String SelectedLensName;
    String changedSelectedLensName;
    
    public MTXEssayLensActivityPageActions(WebDriver driver) {
        super(driver, "MTXEssayLensActivityPage");
    }
    
   public void enterEssayTextInEditor(){
       switchToFrame("cke_wysiwyg_frame cke_reset");
       waitTOSync();
       WebElement element = driver.findElement(By.id("cke_56_contents"));
       System.out.println("Entering note description in text input");
        element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys("Instructor created note description");
   }
    
    
    
    
    
        
            
    
    
    
}
