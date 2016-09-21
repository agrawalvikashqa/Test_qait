/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

/**
 *
 * @author ramanrayat
 */
public class StudyHubPageActions  extends BasePageActions {

        public StudyHubPageActions(WebDriver driver) {
        
             super(driver,"StudyHubPage");
    }

    
        public void verifyStudyHubUI() {
       switchToFullBookFrame();
    }

       public void clickOnCreateStudyGuideButton(){
           Assert.assertTrue( element("CreateStudy").isDisplayed());
           element("CreateStudy").click();
           
       }
       
       public void EnterStudyGuideName(String StudyGuide_Title){
           Assert.assertTrue(element("GuideTitle").isDisplayed());
           element("GuideTitle").sendKeys(StudyGuide_Title);
       }
       String StudyKeyTitle;
        public void selectDropDownValue(){
            
            WebElement dropdownSelect = driver.findElement(By.xpath("//div[@class='content-select']//select"));
            Select dropdown = new Select(dropdownSelect);
            dropdown.selectByIndex(9);
             StudyKeyTitle= element("SelectedUnit_Title").getText();
            System.out.println("Study Guide selected Title is : " + StudyKeyTitle);
       }
        
        public void selectCheckbox(){
            element("SelectAllCheckbox").click();
        }
        public void selectKeyTermCheckbox(){
            waitTOSync();
            waitTOSync();
            element("KeyTermCheck").click();
        }
        
        public void selectFlashcardCheckbox(){
            waitTOSync();
            waitTOSync();
            element("FlashcardCheck").click();
        }
        
        public void clickOnAddUnit(){
            Assert.assertTrue(element("AddUnit").isDisplayed());
            element("AddUnit").click();
         }
        
        public void clickOnCreateStudyGuide(){
            Assert.assertTrue(element("CreateGuide").isDisplayed());
            element("CreateGuide").click();
        }
        
        public void InstructorCreatedGuideIsVisible(){
            String title = element("StudyTitle").getText();
            System.out.println("Study Title is : " + element("StudyTitle").getText());
            Assert.assertTrue(title.contentEquals("Instructor created study guide"), "Study Guide is not visible");
   }
        
        public void InstructorLaunchStudyGuide(){
            waitTOSync();
            
            element("StudyLaunch","Instructor created study guide").click();
            String title = element("LaunchTitle").getText();
            Assert.assertTrue(title.contentEquals("Instructor created study guide"), "Title matches");
            Assert.assertTrue(element("refreshIcon").isDisplayed(),"Refresh Icon is not present");
            Assert.assertTrue(element("PrintIcon").isDisplayed(),"Print Icon is not present");
            Assert.assertTrue(element("HideIcon").isDisplayed(),"Hide Icon is not present");
            Assert.assertTrue(element("DeleteIcon").isDisplayed(),"Delete Icon is not present");
            Assert.assertTrue(element("SortText").isDisplayed(),"Sort Link is not present");
            Assert.assertTrue(element("TypeSort").isDisplayed(),"Type Sort Link is not present");
            Assert.assertTrue(element("UnitSort").isDisplayed(),"Unit Sort Link is not present");
    }
        public void InstructorVerifyUIforKeyTermStudyGuide(){
            
           Assert.assertTrue(element("KeyTermUI").isDisplayed(), "Key Term section loads blank");
           Assert.assertTrue(element("KeyTerm_Content").isDisplayed(), "Key Term section loads blank");
           element("UnitSort").click();
           Assert.assertTrue(element("Unit_Heading").isDisplayed(), "Unit Title is not appearing");
           String StudyGuide_KeyTitle = element("Unit_Heading").getText();
           Assert.assertTrue(StudyKeyTitle.matches(StudyGuide_KeyTitle), "Study Guide Title does not matche with unit selected");
           
           
        }
        
        public void DeleteStudyGuide(String Inst_StudStudyGuide){
           hover(element("StudyLaunch",Inst_StudStudyGuide));
           //Assert.assertTrue(element("DelIcon",Inst_StudStudyGuide).isDisplayed(), "Delete Icon is present");
            element("DelIcon",Inst_StudStudyGuide).click();
            element("DelOK").click();
            //ReportMsg.info("successfully deleted study guide");
            Assert.assertFalse(element("StudyLaunch",Inst_StudStudyGuide).isDisplayed(), "study guide is not deleted");
        }
        
        public void HideStudyGuide(){
           
           hover(element("StudyLaunch","Instructor created study guide"));
           //Assert.assertTrue(element("DelIcon",Inst_StudStudyGuide).isDisplayed(), "Delete Icon is present");
            element("HideIcon","Instructor created study guide").click();
            element("DelOK").click();
            //ReportMsg.info("successfully deleted study guide");
            //Assert.assertFalse(element("StudyLaunch",Inst_StudStudyGuide).isDisplayed(), "study guide is not deleted");
        }
        
        public void studentNotSeeingHiddenGuide(String Inst_StudStudyGuide){
             Assert.assertFalse(element("StudyLaunch",Inst_StudStudyGuide).isDisplayed(), "study guide is not hidden");
        }
        
        
        
        public void studyHubUIVerify(){
            Assert.assertTrue(element("BookMarkIcon").isDisplayed(), "Bookmarks are not present in left");
            Assert.assertTrue(element("StudyGuideIcon").isDisplayed(), "StudyGuideIcon are not present in left");
            Assert.assertTrue(element("HighlightsIcon").isDisplayed(), "HighlightsIcon are not present in left");
        }
        
        public void StudentStudyGuideLaunch(String SGName){
            waitTOSync();
           
            Assert.assertTrue(element("StudyLaunch",SGName).isDisplayed(), "Student created Study Guide is not present");
            element("StudyLaunch",SGName).click();
            String title = element("LaunchTitle").getText();
            Assert.assertTrue(title.contentEquals(SGName), "Title matches");
            Assert.assertTrue(element("PrintIcon").isDisplayed(),"Print Icon is not present");
            Assert.assertTrue(element("SortText").isDisplayed(),"Sort Link is not present");
            Assert.assertTrue(element("TypeSort").isDisplayed(),"Type Sort Link is not present");
            Assert.assertTrue(element("UnitSort").isDisplayed(),"Unit Sort Link is not present");
            Assert.assertTrue(element("HighlightHeading").isDisplayed(), "Highlight Heading is not present");
            Assert.assertTrue(element("KeyHeading").isDisplayed(), "Key Term Heading is not present");
            Assert.assertTrue(element("NotesHeading").isDisplayed(), "My Notes Heading is not present");
            Assert.assertTrue(element("FlashHeading").isDisplayed(), "Flashcard Heading is not present");
            Assert.assertTrue(element("HighlightContent").isDisplayed(), "Highlight Content is not present");
            Assert.assertTrue(element("FlashHeading").isDisplayed(), "Flashcard content is not present");
            Assert.assertTrue(element("NotesHeading").isDisplayed(), "My Notes COntent is not present");
            List<WebElement> li = driver.findElements(By.xpath("//dt[@class='ng-binding ng-isolate-scope']"));
            System.out.println("list value : "+li.get(1).getText());
            li.get(1).isDisplayed();
            waitTOSync();
            
    }
        
         public void clickOnBackButton(){
            waitTOSync();
            waitTOSync();
            
            System.out.println("back link search");
            element("BackLink").click();
    }
         
         public void clickOnBookmarkTab(){
             waitForSpinnerToDisappear();
             element("BookMarkIcon").click();
         }
         
         public void BookmarkStudyHubVerify(String uname){
       
         element("unitName_link", uname).click();
            ReportMsg.info("User Clicked on Unit " + uname);
        }
         
         
         public void NoBookmarkMessage(){
            String BookmarkCount = element("BookmarkCount").getText();
            System.out.println("Bookmark Count is: " +BookmarkCount);
            
                Assert.assertTrue(element("NoBookmarkMessage").isDisplayed(), "No Bookmarks message is not displayed");
                Assert.assertTrue(element("AddBookmarkMessage").isDisplayed(), "Add Bookmarks message is not displayed");
            
    }
         
         public void ClickBookmarkLink(){
             waitForSpinnerToDisappear();
             waitTOSync();
             waitTOSync();
             Assert.assertTrue(element("Activity_BookmarkLink").isDisplayed(), "Bookmark link is not present");
             element("Activity_BookmarkLink").click();
             Assert.assertTrue(element("ClickedBookmarkLink").isDisplayed(), "Bookmark link is not clicked");
             
         }
         public void closeStudyHubApp(){
             element("CloseApp").click();
         }
         
         public void InstructorDeleteBookmarks(){
             waitTOSync();
             waitTOSync();
             List <WebElement> bookmarkDel = driver.findElements(By.xpath("//a[@class='remove']"));
             bookmarkDel.get(1).click();
             element("BookmarkDelOKIcon").click();
             
         }
         
         
         public void selectText() {
             waitForElementPresent("highlighttext");
        WebElement element = driver.findElement(By.xpath(""));
        waitTOSync();
// assuming driver is a well behaving WebDriver
Actions actions = new Actions(driver);
// and some variation of this:
actions.moveToElement(element, 10, 5)
    .clickAndHold()
    .moveByOffset(30, 0)
    .release()
    .perform();
    }
         
         
         
}




