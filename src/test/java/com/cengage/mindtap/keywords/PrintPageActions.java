/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author priyamdixit
 */
public class PrintPageActions extends BasePageActions {
        
    public String windowHandle;
    
    
    public PrintPageActions(WebDriver driver) {
        super(driver, "PrintPage");
    }

  
   public void clickOnSignInLink(){
       element("SignInLink").click();
   }
   
   public void clickOnCengageLogo(){
        element("getCengageLogo").click();
   }
   
   public void clickOnServiceAgreement(){
       element("serviceAgreementLink").click();
   }
   
   public void clickOnSLAPrintIcon(){
       element("printIcon").click();
  }
   
   public void verifyTopCopyrightHeader(String user){
       
       String result = (element("top_copyrightHeader").getText());
       
       String[] separated = result.split("\n");
      for (int i = 0; i < separated.length; i++) {
          separated[i].toString() ; 
      }
       System.out.println( separated[0].toString() ); 
       Assert.assertTrue(separated[0].toString().contains("Chapter"), "Chapter label is not appearing");
       System.out.println( separated[1].toString() ); 
       Assert.assertTrue(separated[1].toString().contains("Book Title"), "Book Title label is not appearing");
       System.out.println( separated[2].toString() ); 
       System.out.println(user);
       Assert.assertTrue(separated[2].toString().contains(user), "User email is not appearing");
       Assert.assertTrue(separated[2].toString().contains("Printed By:"), "Printed By Label is not appearing");
       Assert.assertTrue(separated[3].toString().contains("Cengage Learning"), "copyright statement is not appearing");
       
      // Assert.assertTrue(separated[0].toString().contentEquals("Chapter "), "Chapter label is not appearing");
      
   }
   
   public void verifyBottomCopyrightHeader(String user){
       String result = (element("bottom_copyrightHeader").getText());
       
       String[] separated = result.split("\n");
      for (int i = 0; i < separated.length; i++) {
          // separated[i].toString() ; 
      }
       System.out.println( separated[0].toString() ); 
       Assert.assertTrue(separated[0].toString().contains("Chapter"), "Chapter label is not appearing");
       System.out.println( separated[1].toString() ); 
       Assert.assertTrue(separated[1].toString().contains("Book Title"), "Book Title label is not appearing");
       System.out.println( separated[2].toString() ); 
       Assert.assertTrue(separated[2].toString().contains(user), "User email is not appearing");
       Assert.assertTrue(separated[2].toString().contains("Printed By:"), "Printed By Label is not appearing");
       Assert.assertTrue(separated[3].toString().contains("Cengage Learning"), "copyright statement is not appearing");
       Assert.assertTrue(element("copyrightStatement").getText().contains("Cengage Learning Inc. All rights reserved."), "copyright statement is not appearing");
       
   
   }
   public void verifySLAPrintPreview(){
        wait.hardWait(5);
        windowHandle=driver.getWindowHandle();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        System.out.println(tabs2.size());
        driver.switchTo().window(tabs2.get(1));
        //ReportMsg.info("tab switched");
        //changeWindow(1);
        waitTOSync();
        String Url = driver.getTitle();
        System.out.println(Url);
        WebElement ele = driver.findElement(By.xpath("//button[@class='cancel' and @i18n-content='cancel']"));
        ele.sendKeys(Keys.ESCAPE);
        //switchToPrintPreviewIFrame();
       
        
   }
   protected void changeWindow(int i) {
  Set<String> windows = driver.getWindowHandles();
  if (i > 0) {
   for (int j = 0; j < 9; j++) {
    System.out.println("Windows: " + windows.size());

    if (windows.size() >= 2) {
     try {
      Thread.sleep(5000);
     } catch (Exception ex) {
      ex.printStackTrace();
     }
     break;
    }
    windows = driver.getWindowHandles();
   }
  }
  String wins[] = windows.toArray(new String[windows.size()]);
  driver.switchTo().window(wins[i]);

  System.out.println("Title: "
    + driver.switchTo().window(wins[i]).getTitle());
 }
}
