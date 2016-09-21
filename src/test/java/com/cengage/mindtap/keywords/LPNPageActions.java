/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author QAI
 */
public class LPNPageActions extends BasePageActions {

    public LPNPageActions(WebDriver driver) {
        super(driver, "LPNPage");
    }

    public void verifyLPNWorkspace() {
        if (isElementDisplayed("lpn_workspace")) {
            ReportMsg.info("LPN Workspace is visible");
        } else {
            refreshPage();
            if (isElementDisplayed("lpn_workspace")) {
                ReportMsg.info("LPN Workspace is visible");
            } else {
                refreshPage();
                isElementDisplayed("lpn_workspace");
                ReportMsg.info("LPN Workspace is visible");
            }
        }
    }
    
    public void editMasterLearningPathName(String newTitle){
        executeJavascript("document.getElementsByClassName('lpn_navigation')[0].childNodes[1].childNodes[5].childNodes[1].click()");
        assert element("learningPathmodal_overlay").getAttribute("style").contains("block");
        isElementDisplayed("lpnPathName_txt");
        element("lpnPathName_txt").clear();
        element("lpnPathName_txt").sendKeys(newTitle);
        element("saveLPNPath_btn").click();
    }

    void clickOnUserMenuLink() {
        try {
            switchToDefaultContent();
            isElementDisplayed("userMenu_link");
            executeJavascript("document.getElementsByClassName('user-menu')[0].style.display = 'block';");
        } catch (ElementNotFoundException e) {
            ReportMsg.info("Logout dropdown list not displayed");
        }
    }
    
    public boolean verifyNoeditMasterLearningPathNameOption(String newTitle){
        try {
            executeJavascript("document.getElementsByClassName('ui-button clui-edit')[0].click();");
            return false;
        } catch (Exception e) {
            return true;
        }
      
    }

    public void logOutFromMindTap() {
        clickOnUserMenuLink();
        //element("logout_link").click();
        clickOnElementUsingActionBuilder(element("logout_link"));
        
    }
}
