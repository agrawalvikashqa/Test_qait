/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

//import static com.qait.automation.utils.PropFileHandler.writeProperty;

/**
 *
 * @author QAI
 */
public class QuestiaPageActions extends BasePageActions {
    
    WebDriver driver;
    public QuestiaPageActions(WebDriver driver) {
    super(driver, "QuestiaPage");
    this.driver  =   driver;
    }
    public void verifyQuestiaUI() {
    Assert.assertTrue(element("title_Questia").getText().equalsIgnoreCase("Questia"),"Unable to locate Questia");
    Reporter.log ("Questia Title verified successfully" + "\n");
    }
    public void performSearchOperationAndClickOnSearchButton(String name){
    //assert waitForElementPresent(By.cssSelector(".search"));
        waitForElementPresent("search");
        element("inputSearch").clear();
        element("inputSearch").sendKeys(name);
        waitForElementPresent("search_btn");
        element("search_btn").click();
       }

  
    public void selectSearchByTerm(String searchInput) {
        element("Searchbox").sendKeys(searchInput);
        
                
    }

    public void verifySearchbox() {
    element("Searchbox").isDisplayed();  
    
    }

    public void clickonSearchButton() {
        element("search_btn").click();
    }
    
    public void verifySearchFilterValues(String expectedValue) {
    Assert.assertEquals(element("Editbox_btn").getText(), expectedValue, "Assert Failed: incorrect selected");
   
    }
    public void verifySearchContentCount(String expectedValue) {
   
    Assert.assertEquals(elements("TopicResults").size(),Integer.parseInt(expectedValue));
    }
    public void TabsOnQuestia() {
     element("Books").isDisplayed();
     element("Academic_journals").isDisplayed();
     element("Magazines").isDisplayed();
     element("Newspapers").isDisplayed();
     element("Encyclopedia").isDisplayed();

    }

    public void clickonAddToMindtapButton() {
       element("AddToMindtap_btn").click();  
}

    public void verifyQuestiaActivityLauched(String QuestiaApp_title) {
        assert element("QuestiaApp_Logo").isDisplayed();
        ReportMsg.info("User verified text after launch distinct Questia Activity");
    }

    public void clickOnInlineEditIconAndEditActivity() {
        ReportMsg.info("User Edit Added Inline Activity");
        executeJavascript("document.getElementsByClassName('editInlineActivity edit_editHover')[0].click();");
//       wait.hardWait(2);
//        for (WebElement editIcon : elements("inlineEditIcon")) {
//            if (element("inlineEditIcon").isDisplayed()) {
//                scrollDown(element("inlineEditIcon"));
//                wait.hardWait(2);
//                element("inlineEditIcon").click();
//                ReportMsg.info("User Clicked On inline edit icon ");
//                break;
//            }
//        
//    }
    }
    public void verifyInlineQuestiaActivityLauched(String QuestiaApp_inlineActivityTitle) {
    element("QuestiaApp_inlineActivityTitle").click();
        ReportMsg.info("User launch Inline Questia Activity");
    } 
}
    
    

