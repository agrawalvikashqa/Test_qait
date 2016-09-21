/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author priyamdixit
 */
public class FramesPageActions extends BasePageActions {

    public FramesPageActions(WebDriver driver) {
        super(driver, "FramesPage");
    }

    /**
     * Switch to dock i frame.
     */
    public void switchToDockIFrame() {
        switchToDefaultContent();
        //wait.hardWait(2);
        //System.out.println(elements("dockFrame").get(1).getAttribute("id"));
        switchToFrame(element("dockFrame"));
        wait.hardWait(5);
        wait.hardWait(5);
    }
    
    public void switchToCategoryIFrame() {
        //switchToDefaultContent();
         switchToFrameWithOutDefault(element("category_frame"));
        
    }
    
    

    /**
     * Switch to dock i frame.
     */
    public void switchToimilacContentIFrame() {
        switchToFrame(element("imilacContentIFrame"));
    }

    public void switchToDistinctActivityCreateFrame() {
        switchToFrame(element("distinct_Activity_Frame"));
        ReportMsg.info("User switched to distinct Activity Frame");
    }
    public void switchToReaderEditIFrame() {
        switchToFrame(element("ReaderEditIFrame"));
        ReportMsg.info("User switched to Reader Edit Frame");
    }

    public void switchToMainFrame() {
        switchToFrame(element("nb_Main_Frame"));
        ReportMsg.info("User switched to Activity Frame");
    }

    public void switchToModeOptionsEditFrame() {
        switchToFrame(element("optionsEdit_frame"));
        ReportMsg.info("User switched to Options Edit Frame");
    }
   
    
}
