/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author priyamdixit
 */
public class EvernotePageActions extends BasePageActions {
        
    public String windowHandle;
    
    public EvernotePageActions(WebDriver driver) {
        super(driver, "Evernote");
    }

  
   public void clickOnSignInLink(){
       element("SignInLink").click();
   }
   
   public void SignIntoApp(){
       waitTOSync();
       waitTOSync();
       windowHandle=driver.getWindowHandle();
       ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        element("userId").clear();
        element("userId").sendKeys("testautomationqai");
        element("pwdField").clear();
        element("pwdField").sendKeys("automation@123");
        element("SignIn_Button").click();
        waitTOSync();
        waitTOSync();
        executeJavascript("document.getElementsByClassName('Btn Btn_emph')[1].click();");
        driver.switchTo().window(windowHandle);
        System.out.println("window switched");
   }
   
   public void AddNote(String note){
       waitTOSync();
       
       element("AddNote").click();
       Assert.assertTrue(element("Note_Title").isDisplayed(), "Title box is not present");
       element("Note_Title").clear();
       element("Note_Title").sendKeys(note);
       waitTOSync();
       switchToDefaultContent();
       switchToDockIFrame();
       switchToFrame("tinymce_editor_area_ifr");
       
       waitTOSync();
       WebElement element = driver.findElement(By.id("tinymce"));
        System.out.println("Entering note description in text input");
        element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys("Instructor created note description");
       
       switchToDefaultContent();
       switchToDockIFrame();
       element("SaveNote_Button").click();
       waitTOSync();
       String addedNote_Title = driver.findElement(By.xpath(".//ul[@class='plain']/li[1]/a")).getText();
       System.out.println(addedNote_Title);
       Assert.assertTrue(addedNote_Title.contains(note), "Note is not added");
       
   }
    
   public void sort(){
       element("TitleSort").click();
       List <WebElement> li = driver.findElements(By.xpath(".//ul[@class='plain']/li/a"));
      
       System.out.println(li.get(0).getText());
       Assert.assertTrue(li.get(0).getText().contains("Aphabet"));
//       Assert.assertTrue(li.get(2).getText().contains("Instructor"));
       
       ReportMsg.info("Sorting is working fine");
   }
   
   public void editNote() throws AWTException{
       waitTOSync();
       waitTOSync();
       element("editNote").click();
       element("Note_Title").clear();
       element("Note_Title").sendKeys("Instructor edited Note");
       switchToDefaultContent();
       switchToDockIFrame();
       switchToFrame("tinymce_editor_area_ifr");
       
       waitTOSync();
       WebElement element = driver.findElement(By.id("tinymce"));
       driver.findElement(By.id("tinymce")).clear();
        System.out.println("Editing note description in text input");
        //element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.CONTROL + "b");
        
        element.sendKeys("bold edited");
        
        element.sendKeys(Keys.CONTROL + "b");
        element.sendKeys(Keys.ENTER);
        element.sendKeys(Keys.CONTROL + "i");
        element.sendKeys("Italics edited");
        
        element.sendKeys(Keys.ENTER);
        element.sendKeys(Keys.CONTROL + "i");
        element.sendKeys("hyperlinked");
        element.sendKeys(Keys.chord(Keys.SHIFT,Keys.HOME));
        waitTOSync();
        switchToDefaultContent();
        switchToDockIFrame();
        element("hyperlink").click();
        
        windowHandle=driver.getWindowHandle();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        element("linkBox").clear();
        element("linkBox").sendKeys("http://google.com");
        element("LinkInsert").click();
        waitTOSync();
        driver.switchTo().window(windowHandle);
        System.out.println("window switched");
        switchToDefaultContent();
        switchToDockIFrame();
        switchToFrame("tinymce_editor_area_ifr");
        waitTOSync();
        waitTOSync();
        waitTOSync();
        waitTOSync();
        waitTOSync();
        waitTOSync();
        Assert.assertTrue(element("linkedText").isDisplayed(), "text is not linked");
         
       
           
        switchToDefaultContent();
        switchToDockIFrame();
        element("updateNode_Button").click();
        waitTOSync();
        String addedNote_Title = driver.findElement(By.xpath(".//ul[@class='plain']/li[1]/a")).getText();
        System.out.println(addedNote_Title);
        Assert.assertTrue(addedNote_Title.contains("edited Note"), "edited note is not displayed");
       
        WebElement bold = driver.findElement(By.xpath("//strong[contains(text(),'bold edited')]"));
         Assert.assertTrue(bold.isDisplayed(),"bold text does not appear");
            
        WebElement italics = driver.findElement(By.xpath("//em[contains(text(),'Italics edited')]"));
         Assert.assertTrue(italics.isDisplayed(),"italics text does not appear");
         
         ReportMsg.info("Instructor successfuly edited note");
   }
   
   public void deleteNote(){
       List <WebElement> li = driver.findElements(By.xpath("//ul[@class='plain']/li/a"));
       System.out.println(li.size());
       for(int i =0; i<li.size();i++){
           clickOnElementUsingActionBuilder(element("delete_Note"));
       
       switchToDefaultContent();
       waitTOSync();
       handleAlert();
//driver.switchTo().alert().accept();
       switchToDockIFrame();
       }
   }
   
   public void signOut(){
       waitTOSync();
       element("signOutLink").click();
       Assert.assertTrue(element("SignInLink").isDisplayed(), "Sign In page does not appear");
       
       
   }
}
