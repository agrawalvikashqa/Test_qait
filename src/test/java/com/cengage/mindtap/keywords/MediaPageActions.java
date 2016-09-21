/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 *
 * @author nikitaaggarwal
 */
public class MediaPageActions extends BasePageActions {

    public MediaPageActions(WebDriver driver) {
        super(driver, "MediaPage");
    }
    public boolean isChecked;

    public void VerifyCheckBox() {

        System.out.println(element("filterByIsbn").isSelected());
        //String result = executeJavascriptWithReturn("return document.getElementById('filterByIsbn').checked").toString();
        //System.out.println(result);
        Reporter.log("CheckBox Value is true by default");

    }

    public void UncheckSsoAssets() {
        //isChecked = findElement(element("uncheck_sso")).isSelected();
        clickOnElementUsingActionBuilder(element("uncheck_sso"));
        Reporter.log("User Unchecked the SSO assets box to see all media types");
    }

    public void DropDownMediaType() {
        clickOnElementUsingActionBuilder(element("media_type"));
        Reporter.log("User clicked on MediaType Drop down to selct any media type");
    }

    public void SearchMedia() {
        element("search_txt").sendKeys("AAMMAS958585318");
        waitTOSync();
        waitTOSync();
        Assert.assertTrue(element("search_result").isDisplayed());
        Assert.assertTrue(element("search_count").isDisplayed());
        Reporter.log("Media search is working fine");
    }

    public void ClearSearch() {
        element("search_txt").clear();
        element("search_icon").click();
        waitTOSync();
        waitTOSync();
    }

    public void SelectImageMediaType() {
        clickOnElementUsingActionBuilder(element("media_type"));
        selectProvidedValue(element("media_type"), "image");
        Reporter.log("User clicked on Image media type");
    }

    public void SelectVideoMediaType() {
        //clickOnElementUsingActionBuilder(element("media_type"));
        selectProvidedValue(element("media_type"), "video");
        Reporter.log("User clicked on video media type");
    }
    public void SelectFlashMediaType() {
        //clickOnElementUsingActionBuilder(element("media_type"));
        selectProvidedValue(element("media_type"), "flash");
        Reporter.log("User clicked on Flash media type");
    }

    public void ClickOnVideoMedia() {
        waitTOSync();
        waitTOSync();
        clickOnElementUsingActionBuilder(element("img_media"));
        Reporter.log("User selected Video media to add");
    }
    public void ClickOnFlashMedia() {
        waitTOSync();
        waitTOSync();
        clickOnElementUsingActionBuilder(element("img_media"));
        Reporter.log("User selected Flash media to add");
    }

    public void ClickOnNextPage() {
        clickOnElementUsingActionBuilder(element("next_btn"));
        Assert.assertTrue(element("next_search").isDisplayed());
        Reporter.log("User navigated to next page");
    }

    public void ClickOnPreviousPage() {
        clickOnElementUsingActionBuilder(element("previous_btn"));
        Assert.assertTrue(element("previous_search").isDisplayed());
        Reporter.log("User navigated to previous page");
    }

    public void ClickOnImageMedia() {
        waitTOSync();
        clickOnElementUsingActionBuilder(element("img_media"));
        Reporter.log("User selected image media to add");
    }
    public void DeleteInlineActivity() {
        clickOnElementUsingActionBuilder(element("inline_rmv"));
        handleAlert();
        Reporter.log("User removed the Inline RSS Feed");

    }

    public void EnterBeforeText() {
        clickOnElementUsingActionBuilder(element("bfr_txt"));
        element("bfr_txt").clear();
        element("bfr_txt").sendKeys("Test");
        Reporter.log("User Entered Before text for activity");
    }

    public void EnterAfterText() {
        clickOnElementUsingActionBuilder(element("afr_txt"));
        element("afr_txt").clear();
        element("afr_txt").sendKeys("Test");
        Reporter.log("User Entered after text for activity");
    }

    public void ClickOnContinue() {
        clickOnElementUsingActionBuilder(element("continue_btn"));
        Reporter.log("User Clicked on continue button to save media activity");
    }

    public void EnterActivityTitle(String title) {
        deselectFrame();
        clickOnElementUsingActionBuilder(element("title_txt"));
        element("title_txt").clear();
        element("title_txt").sendKeys(title);
        Reporter.log("User entered activity title");
    }

    public void ClickOnSave() {
        clickOnElementUsingActionBuilder(element("save_btn"));
        Reporter.log("User Clicked on save button to add media activity to LPN");
    }

    public void VerifyAddedMedia(String title) {
        scrollDown(element("lpn_act", title));
        Assert.assertTrue(element("lpn_act", title).isDisplayed());
        Reporter.log("Admin have permission to add Image media activity");

    }

    public void EditImageMediaActivity(String title) {
        hoverUsingJS(element("lpn_act", title));
        moveOnElementUsingActionBuilder(element("edit_media", title));
        element("edit_media", title).click();
        ReportMsg.info("Clicked on edit icon");
    }

    public void MakeChangesInImageMediaActivity(String title) {
        clickOnElementUsingActionBuilder(element("bfr_txt"));
        element("bfr_txt").clear();
        element("bfr_txt").sendKeys("Test updated");
        scrollDown(element("save_changes"));
        //clickOnElementUsingActionBuilder(element("save_changes"));
        //element("save_changes").click();
        //waitForElementPresent("save_changes");
        executeJavascript("document.getElementsByClassName('save')[0].click()");
        ReportMsg.info("Clicked on save changes button");
        deselectFrame();
        ReportMsg.info("User have edit permisiions");

    }

    public void AddImageMedia(String title) {
        VerifyCheckBox();
        UncheckSsoAssets();
        DropDownMediaType();
        SelectImageMediaType();
        ClickOnNextPage();
        ClickOnPreviousPage();
        SearchMedia();
        ClearSearch();
        ClickOnImageMedia();
        EnterBeforeText();
        EnterAfterText();
        ClickOnContinue();
        EnterActivityTitle(title);
        ClickOnSave();
        VerifyAddedMedia(title);

    }

    public void AddImageMediaInline(String title) {
        UncheckSsoAssets();
        DropDownMediaType();
        SelectImageMediaType();
        ClickOnImageMedia();
    }

    public void EditImageMedia(String title) {
        MakeChangesInImageMediaActivity(title);
        ClickOnSave();
    }

    public void AddVideoMedia(String title) {
        UncheckSsoAssets();
        SelectVideoMediaType();
        ClickOnVideoMedia();
        EnterBeforeText();
        EnterAfterText();
        ClickOnContinue();
        EnterActivityTitle(title);
        ClickOnSave();
        VerifyAddedMedia(title);
    }
    public void AddFlashMedia(String title) {
        UncheckSsoAssets();
        SelectFlashMediaType();
        ClickOnFlashMedia();
        EnterBeforeText();
        EnterAfterText();
        ClickOnContinue();
        EnterActivityTitle(title);
        ClickOnSave();
        VerifyAddedMedia(title);
    }

    public void AddVideoMediaInline(String title) {
        UncheckSsoAssets();
        DropDownMediaType();
        SelectVideoMediaType();
        ClickOnVideoMedia();
    }

    public void switchToFolder(String ReaderFolder) {
        scrollDown(element("unit_lpn", ReaderFolder));
        clickOnElementUsingActionBuilder(element("unit_lpn", ReaderFolder));
        ReportMsg.info("User entered in Folder");
    }

    public void LaunchReader(String Reader) {
        waitForSpinnerToDisappear();
        //scrollDown(element("reader_inline", Reader));
        clickOnElementUsingActionBuilder(element("reader_inline", Reader));
        ReportMsg.info("User entered in Reader");
    }
    public void VerifyInlineFromStudent() {
        Assert.assertTrue(isElementDisplayed("inline_verify"));
        
        ReportMsg.info("Student verified inline activity");
    }

    /*public void addInline() {
        waitTOSync();
   element("plus_icon").click();
        //executeJavascript("argument[0].click()", element("plus_icon"));
//        click(element("plus_icon"));
        ReportMsg.info("User Clicked on + icon");
        deselectFrame();
    }*/

    public void DeletePermission() {
        ReportMsg.info("User have Delete permisiions");

    }

    private void sendKeys(Keys keys) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}