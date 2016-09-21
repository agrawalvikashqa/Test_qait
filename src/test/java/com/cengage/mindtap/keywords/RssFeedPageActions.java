package com.cengage.mindtap.keywords;

import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RssFeedPageActions extends BasePageActions {

    //String Name = "filename"+getCurrentDateTime();
    public RssFeedPageActions(WebDriver driver) {
        super(driver, "RSSFeedPage");
    }

    public void addRssFeedAppDock() {
        element("addFeed_btn").click();
        Reporter.log("User Clicked on add Feed Icon");
    }

    public void addRssFeedLPN(String url, String filename) {

        element("feedUrl_TB").clear();
        element("feedUrl_TB").sendKeys(url);
        Reporter.log("User added the Feed URL");
        element("feedTitle_TB").click();
        waitForSpinnerToDisappear();
        element("feedTitle_TB").clear();
        element("feedTitle_TB").sendKeys(filename);
        Reporter.log("User added the Feed Title");
        scrollDown(element("save_btn"));
        clickOnElementUsingActionBuilder(element("save_btn"));
        Reporter.log("User saved the RSS Feed");
    }
        public void VerifyRssFeedAppDock(String filename) {
      Assert.assertTrue(element("appdock_RSS", filename).isDisplayed());
        Reporter.log("User Verified the RSS Feed from App Dock");
        //element("appdock_RSS", filename).click();
        }
        public void deleteRssFeedAppDock(String filename) {
        String bookClassName = element("titlename", filename).getAttribute("class");
            System.out.println(bookClassName);
        executeJavascript("document.getElementsByClassName('"+bookClassName+"')[0].getElementsByClassName('controls')[0].style.display='block';");
element("AD_Delete", filename).click();
       // driver.findElement(By.xpath("//a[contains(.,'"filename"')]/parent::*//img[contains(@src,'delete')]")).click();
        //hoverUsingJS(element("appdock_RSS", filename));
       // element("AD_Delete").click();
        element("delete_btn").click();
        ReportMsg.info("Feed Deleted");
    }

    public void AddDistinctRssActivity() {
        deselectFrame();
        clickOnElementUsingActionBuilder(element("savelpn_btn"));
        Reporter.log("User saved the RSS Feed activity at LPN");
    }

    public void AddedRssActivity(String filename) {
        scrollDown(element("lpn_act", filename));
        Assert.assertTrue(element("lpn_act", filename).isDisplayed());
        Reporter.log("User Verified the RSS Feed");

    }

    public void DeleteAddedRssActivity(String filename) {
        hoverUsingJS(element("lpn_act", filename));
        Reporter.log("User Hovered the RSS Feed");
        //element("del_rss",filename).click();
        moveOnElementUsingActionBuilder(element("del_rss", filename));
        element("del_rss", filename).click();
        ReportMsg.info("Clicked on delete Button");
        handleAlert();
        ReportMsg.info("Activity Deleted");
    }
    public void switchToReader(String Reader){
        scrollDown(element("lpn_act", Reader));
        clickOnElementUsingActionBuilder(element("lpn_act", Reader));
        ReportMsg.info("User entered in Unit");
        clickOnElementUsingActionBuilder(element("lpn_act", Reader));
        ReportMsg.info("User Launched the reader");
        waitForSpinnerToDisappear();
        
    }
    
    public void addInline(){
        clickOnElementUsingActionBuilder(element("inline_add"));
        ReportMsg.info("User Clicked on pencil icon");
        clickOnElementUsingActionBuilder(element("plus_icon"));
        ReportMsg.info("User Clicked on + icon");
        deselectFrame();
    }
    public void AddedInlineRssActivity(String filename) {
        //scrollDown(element("lpn_act", filename));
       switchToDefaultContent();
       switchToMainIFrame();
       
        Assert.assertTrue(element("inline_act", filename).isDisplayed());
        Reporter.log("User Verified the RSS Feed");

    }
    public void DeleteInlineActivity(String filename) {
        try {
            executeJavascript("(document.getElementsByClassName('deleteInline deleteControl_remove'))[0].click();");
        } catch (Exception e) {
            clickOnElementUsingActionBuilder(element("inline_add"));
            executeJavascript("(document.getElementsByClassName('deleteInline deleteControl_remove'))[0].click();");
        }
//        clickOnElementUsingActionBuilder(element("inline_add"));
//        clickOnElementUsingActionBuilder(element("inline_add"));
//        ReportMsg.info("User Clicked on pencil icon");
//        clickOnElementUsingActionBuilder(element("inline_rmv"));
        handleAlert();
        Reporter.log("User removed the Inline RSS Feed");

    }

}
