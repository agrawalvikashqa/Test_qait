/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.BasePageActions;
import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;

public class MTXFramesPageActions extends BasePageActions {
    
    public MTXFramesPageActions(WebDriver driver) {
        super(driver, "MTXFramePage");
    }
    public void switchToDockIFrame(String Title) {
        switchToDefaultContent();
        wait.hardWait(5);
        switchToFrame(element("dockFrame",Title));
        wait.hardWait(5);
    }
    
    public void switchToDistinctActivityCreateFrame() {
        switchToFrame(element("distinct_Activity_Frame"));
        ReportMsg.info("User switched to distinct Activity Frame");
    }
    
   public void switchToStudyCenterQuizFrame() {
       waitTOSync();
        switchToFrameWithOutDefault(element("studyCenter_frame"));
        ReportMsg.info("User switched to study Center Quiz Frame");
    }
    public void switchToMainFrame() {
        switchToFrame(element("nb_Main_Frame"));
        ReportMsg.info("User switched to Activity Frame");
    }
    
     public void switchToDBoardFrame() {
        switchToFrame(element("dboard_frame"));
        ReportMsg.info("User switched to Discussion Board Frame");
    }
     
      public void switchToStudyCenterFrame() {
        switchToFrame(element("study_center_frame"));
        ReportMsg.info("User switched to Study center Frame");
    }
      
        public void switchToStudyGuideFrame() {
        switchToFrame(element("study_guide_frame"));
        ReportMsg.info("User switched to Study Guide Frame");
    }
       public void MerriamWebsterDictionaryFrame() {
        switchToFrame(element("dictionary_frame"));
        ReportMsg.info("User switched to Dictionary Frame");
    }
    
    public void switchToReaderEditIFrame(){
        waitForElementPresent("ReaderEditIFrame");
        waitTOSync();
        switchToFrame(element("ReaderEditIFrame"));
        ReportMsg.info("User switched to Reader Edit Frame");
    }
    public void switchToRequiredFrame() {
		waitTOSync();
		switchToDefaultContent();
		switchToFrame((element("getFrameContent")).getAttribute("id"));
	}
       public void switchToActivityOverviewFrame() {
        wait.hardWait(7);
        switchToFrame("easyXDM_activityService_cxp_Target_provider");
        ReportMsg.info("User switched to Activity Service frame");
    }
    

    public void switchToActivityServiceFrame() {
        wait.hardWait(7);
        switchToFrame("activityService");
    }
    
     public void switchToDockIFrame() {
        waitTOSync();
        switchToDefaultContent();
        switchToFrame(element("dockFrame"));
        wait.hardWait(3);
    }
     
     public void switchToPeriodictableIFrame() {
        waitTOSync();
        switchToDefaultContent();
        switchToDockIFrame();
        switchToFrame(element("periodicTableFrame"));
        
        
    }
    
}
