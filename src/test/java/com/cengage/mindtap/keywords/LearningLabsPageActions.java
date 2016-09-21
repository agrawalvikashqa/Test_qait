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
 * @author QAI
 */
public class LearningLabsPageActions extends BasePageActions {
 public LearningLabsPageActions(WebDriver driver) {
        super(driver, "LearningLabsPage");
  
}

public void ClickOnSelectButton() {
 element ("select_btn").click();
}
public void ClickOnCreateButton() {
 element ("create_btn").click();
}
public void EnterActivityTitleAndDescription(String LearningLabs_title, String description) {
 waitForSpinnerToDisappear();
 element("add_activityname").click();
 element("add_activityname").clear();
 element("add_activityname").sendKeys(LearningLabs_title);
 ReportMsg.info("User added the title of the Activity");
 element("add_description").click();
 element("add_description").clear();
 element("add_description").sendKeys(description);
 ReportMsg.info("User define the discription of the Activity");
}
public void EditActivityTitleAndDescription(String LearningLabs_newtitle, String newdescription) {
    waitForSpinnerToDisappear();
    wait.hardWait(1);
 element("add_activityname").click();
 element("add_activityname").clear();
 element("add_activityname").sendKeys(LearningLabs_newtitle);
 ReportMsg.info("User edit the title of the Activity");
 element("add_description").click();
 element("add_description").clear();
 element("add_description").sendKeys(newdescription);
 ReportMsg.info("User edit the discription of the Activity");
}
public void ClickOnUpdateButton() {
   waitTOSync();
  executeJavascript("document.getElementById('editUpdate').click()");
}
public void ClickOnStartAssignmentButton() {
 element ("startassignment_btn").click();
   
    }
}




