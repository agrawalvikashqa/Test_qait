/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;


import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



/**
 *
 * @author chandanjyot
 */
public class GenericAppDockPageActions extends BasePageActions  {
    
    public GenericAppDockPageActions(WebDriver driver) {
        
    super(driver,"GenericAppDock");
   }
    
    public void appDockDisplay(){
        
        Assert.assertTrue(element("appDockAppear").isDisplayed(), "App Dock is not present");
        
    }
    
    public void appDockExpand(){
        try{
            element("searchAppDisplay").isDisplayed();
            ReportMsg.info("Dock is open by default");
        
        }
        catch(Exception e){
            ReportMsg.info("Dock is closed by default");
            
        }
        
    }
    
    public void moreLessLink(){
        try{element("moreLink").isDisplayed();
        Assert.assertTrue(element("moreLink").isDisplayed(), "More Link is not present");
        element("moreLink").click();
       
        if(element("moreLink").getAttribute("class").contains("nb_collapseDock"))
            System.out.println("More link is clickable");
        else
            System.out.println("More link is not clickable");
          
         ReportMsg.info("User clicked on More Link");
         waitTOSync();
         waitTOSync();
        Assert.assertTrue(element("lessLink").isDisplayed(),"Less Link is not present");
         element("lessLink").click();
        
        if(element("moreLink").getAttribute("class").contains("nb_expandDock"))
            System.out.println("Less link is clickable");
        else
            System.out.println("Less link is not clickable");
         ReportMsg.info("User clicked on Less Link");
        
     }
    
    catch(Exception e) {
    ReportMsg.info("more link is not present");
}
    }
    
    
        
    public void appdockHide(){
         waitTOSync();
        element("appDockAppear").click();
        waitTOSync();
        waitTOSync();
    }
    
    public boolean verifyHideAppDock(){
        ReportMsg.info("User hide app dock");
        
        try {
            element("searchAppDisplay").isDisplayed();
            return false;
            
        } catch (Exception e) {
            return true;
        }
        
        } 
public boolean verifyMoreAndLessButtonsAreOverlappingWithApp() {
        if (element("moreLink").isDisplayed()) {
            element("moreLink").click();
            System.out.println("More Button Clicked Successfully");
            return true;
        } else {
            System.out.println("There is not enough app to test this Fuctionality");
            System.out.println("Please Provision more apps");
            return false;
        }
      
    }
    }
    
//    public void closeAppDock(){
//        
//    }


