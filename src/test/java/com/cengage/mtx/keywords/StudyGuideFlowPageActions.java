/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author QAI
 */
public class StudyGuideFlowPageActions extends BasePageActions {

    public StudyGuideFlowPageActions(WebDriver driver) {
        super(driver, "StudyGuideFlow");
    }
    
    public void clickOnStudyGuide() {
                 element("lbl_StudyGuide").click();
	}

    public void navigateToWeek(String week) {
		// String temp = driver.getCurrentUrl();
		String[] weeknav = week.toLowerCase().split("week");
                int weekNo=0;
                try{
		weekNo = Integer.parseInt(weeknav[1].trim());
                }
                catch(Exception e){
                    System.out.println("Exception");
                }
                String WeekNo = String.valueOf(weekNo);
		if (weekNo == 1 || weekNo == 2)
			element("specificWeek", WeekNo).click();
		else
			                 clickOnElementUsingActionBuilder(element("specificWeek2", WeekNo));
		
	}
    
      public void getTitleOfActivity() {
		switchToDefaultContent();
                String activity_heading = element("titleOfActivity").getText();
		System.out.println("Activity Title:->" + activity_heading);
	}

    
    public void verifyKeyConceptsTextPresent() {
		switchToDefaultContent();
                //switchToFrame(element("getFrame_StudyCenter"));
                //switchToFrame("easyXDM_activityService_cxp_Target_provider");
		isElementDisplayed(element("gettxt_KeyConcepts"));
		System.out.println("key concepts text is present");
                //switchToDefaultContent();
                
	}

    public void activityNumberIsDisplayed() {
        switchToDefaultContent();        
//switchToFrame(element("StudycenterFrame").getAttribute("id"));
        switchToFrame(element("getFrame_StudyCenter"));    
        //element("activity_number").isDisplayed();
        //Assert.assertTrue(element("activity_number").isDisplayed());
        //element("activity_number").getText();
        
    }
    
     public void keyConceptsIsDisplayed() {
        Assert.assertTrue(element("key_concept").isDisplayed());
    }
     
      public void KeyEquationIsDisplayed() {
        Assert.assertTrue(element("key_equation").isDisplayed());
    }
      
       public void keyTermHeaderIsDisplayed() {
        Assert.assertTrue(element("key_terms").isDisplayed());
    }
       
        public void crossIconIsDisplayed() {
        Assert.assertTrue(element("cross_icon_display").isDisplayed());
    }
        
         public void printIconIsDisplayed() {
        Assert.assertTrue(element("print_icon_display").isDisplayed());
    }
         
        public void behindStudyCenterStudyGuideDisplays() {
            wait.hardWait(2);
            switchToDefaultContent();
        Assert.assertTrue(element("behindstudyguide").isDisplayed());
        
    }
          
         public void userIsAbleToPrintStudyGuide() {
         element("print_icon_display").click();
         
                
    }
         public void scrollworksFine() {
         scrollDown(element("key_equation")); 
        
    }
           public void clickOnCloseActivity() {
           //switchToFrame(element("getFrame_StudyCenter"));
                //clickOnElementUsingActionBuilder(element("CloseStudyGuide"));
                switchToDefaultContent();
		clickOnElementUsingActionBuilder(element("CloseActivityButton"));
               
	} 
           public void StudyGuidePresentInEachUnit() {
                 //switchToFrame(element("getFrame_StudyCenter"));
                //clickOnElementUsingActionBuilder(element("CloseStudyGuide"));
                switchToDefaultContent();
		int unitStudyGuides = elements("countOfStudyGuide").size();
                for(int i=1; i<=unitStudyGuides; i++){
                    String j = String.valueOf(i);
                    String studyGuideUnit= element("unitStudyGuide", j).getText();
                    System.out.println("Study Guide of Unit"+i+":"+studyGuideUnit);
                }
               
	} 

    public void ClickOnStudyGuide() {
        waitTOSync();
        clickOnElementUsingActionBuilder(element("clickStudyGuide"));
        
        //element("clickStudyGuide").click();
    }

    public void closeStudyGuide() {
        waitTOSync();
        //switchToDefaultContent();
        element("cross_icon_display").click();
        System.out.println("Successfully Closed Study Guide");
    }
}     
    

