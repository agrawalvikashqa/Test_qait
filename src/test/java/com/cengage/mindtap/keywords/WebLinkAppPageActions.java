/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import com.qait.automation.utils.ReportMsg;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 *
 * @author alokkumar
 */
public class WebLinkAppPageActions extends BasePageActions {

    public WebLinkAppPageActions(WebDriver driver) {
        super(driver, "WebLinkAppPage");
    }

    public void addWebLinkActivity(String webURL, String text) {
        assert element("url_link").isDisplayed();
        element("url_link").click();
        element("url_link").clear();
        element("url_link").sendKeys(webURL);
        ReportMsg.info("User enter Url "+ webURL +" in url text box");
        element("continue_btn").click();
        waitForSpinnerToDisappear();
        ReportMsg.info("User Clicked on Continue Button");
        element("addBefore_txt").click();
        element("addBefore_txt").clear();
        element("addBefore_txt").sendKeys(text);
        ReportMsg.info("User added text in before text field");
        element("addAfter_txt").click();
        element("addAfter_txt").clear();
        element("addAfter_txt").sendKeys(text);
        ReportMsg.info("User added text in after text field");
        element("save_btn").isDisplayed();
        element("save_btn").click();
        
    }

    public void verifyWeblinkActivityLauched(String webLinkActivity_title) {
        assert element("text").isDisplayed();
        ReportMsg.info("User verified text after launch distinct web link Activity");
    }
    
    public void verifyWeblinkURL(String webLinkActivity_title) {
        
        element("weblink_URL").click();
        
    }
    
    

    public void fillEntryInField(String anotherWebURL, String text) {
        //element("clearOld_url").click();
        //clickOnElementUsingActionBuilder(element("clearOld_url"));
        waitTOSync();
        executeJavascript("document.getElementsByClassName('remove_link_input_field')[0].click();");
        waitTOSync();
        waitTOSync();
        assert element("url_link").isDisplayed();
        element("url_link").click();
        element("url_link").clear();
        element("url_link").sendKeys(anotherWebURL);
        System.out.println("anotherWebURL" + anotherWebURL);
        ReportMsg.info("User enter another Url "+anotherWebURL + " in url text box");
        element("addBefore_txt").click();
        element("addBefore_txt").clear();
        element("addBefore_txt").sendKeys(text);
        ReportMsg.info("User added text in before text field");
        element("addAfter_txt").click();
        element("addAfter_txt").clear();
        element("addAfter_txt").sendKeys(text);
        ReportMsg.info("User added text in after text field");
        //element("continue_btn").click();
        executeJavascript("document.getElementsByClassName('continue_button')[0].click()");
        ReportMsg.info("User clicked on comtinue button");
        //element("save_btn").isDisplayed();
        //element("save_btn").click();
        executeJavascript("document.getElementsByClassName('save')[0].click()");
        ReportMsg.info("User clicked on save button");
    }

    public void clickOnInlineEditAndEditActivity() {
        ReportMsg.info("User Edit Added Inline Activity");
        for (WebElement editIcon : elements("inlineEditIcon_list")) {
            if (element("inlineEditIcon_list").isDisplayed()) {
                waitTOSync();
                element("inlineEditIcon_list").click();
                ReportMsg.info("User Clicked On inline edit icon ");
                break;
            }

        }
    }

    public void editDisplay() {
    
        Assert.assertTrue(element("EditButton").isDisplayed());
        
    }

    public void verifyWebLinkURL() {
    
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        waitTOSync();
        Assert.assertTrue(element("cnnlogo").isDisplayed());
        waitTOSync();
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    public void searchPopulatedField() {
    
        String populatedField = element("populatedField").getAttribute("value");
        System.out.println(populatedField);
        Assert.assertTrue(checkPopulatedField(populatedField));
        element("populatedField").sendKeys("http://javascriptmvc.com/docs.html?test=()");
        element("continue_button").click();
        switchToDefaultContent();
        element("AddActivityPresent").isDisplayed();
        element("cancel_button").click();
        
        
    }

    private boolean checkPopulatedField(String populatedField) {
        
     if(populatedField.contains("exampl"))   
     { return true;
     
    }
       else
    {
    return false;
    }


    }

    public String verifyWebLinkURLThumbnail() {
        String imagesrc=  element("thumbnail_img").getAttribute("src");
        System.out.println("Thumbnail Source URL: "+imagesrc);
        return imagesrc;
        }
    
}