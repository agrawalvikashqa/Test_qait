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
public class DateManagerPageActions extends BasePageActions {

    public DateManagerPageActions(WebDriver driver) {
        super(driver, "DateManagerPage");
    }

    public void clickOnDateManagerView() {
        element("Tab_DateManagerView").click();
        ReportMsg.info("User clicked on DateManager Tab View");
    }

    public void availableDateDueDateColumns() {
        isElementDisplayed(element("Header_AvailableDate"));
        isElementDisplayed(element("Header_DueDate"));
    }

    public void calenderIconsForAvailableAndDueDate() {
        isElementDisplayed(element("CalenderIcon_AvailableDate"));
        isElementDisplayed(element("CalenderIcon_DueDate"));
    }

    public void setAvailableDateForSingleActivity() {
        waitTOSync();
        element("icon_calender_ad").click();
        ReportMsg.info("User clicked on Available Date Calender Icon");
        waitTOSync();
        element("bttn_done").click();
        ReportMsg.info("User clicks on Done button");
        waitTOSync();
    }

    public void clearAvailableDateForSingleActivity() {
        element("icon_calender_ad").click();
        ReportMsg.info("User clicked on Available Date Calender Icon");
        waitTOSync();
        element("bttn_clear").click();
        ReportMsg.info("User clicks on Clear button");
        waitTOSync();
    }

    public void setDueDateOfSingleActivity() {
        element("icon_calender_dd").click();
        ReportMsg.info("User clicked on Due Date Calender Icon");
        waitTOSync();
        element("bttn_done").click();
        ReportMsg.info("User clicks on Done button");
        waitTOSync();
    }

    public void clearDueDateForSingleActivity() {
        clickOnElementUsingActionBuilder(element("icon_calender_dd"));
        ReportMsg.info("User clicked on Due Date Calender Icon");
        waitTOSync();
        clickOnElementUsingActionBuilder(element("bttn_clear"));
        ReportMsg.info("User clicks on Clear button");
        waitTOSync();
    }

    public void setDueDateInBulk() {
        waitTOSync();

        element("chk_box_unit").click();
        ReportMsg.info("User selected entire Unit");
        waitTOSync();
        element("icon_calender_dd_bulk").click();
        waitTOSync();
        element("bttn_done").click();
        ReportMsg.info("User clicks on Done button");
        waitTOSync();
        element("bttn_apply_bulk").click();
        ReportMsg.info("User clicks on Apply button");
        waitTOSync();
    }

    public void clearDueDateInBulk() {
        element("chk_box_unit").click();
        ReportMsg.info("User selected entire Unit to clear due date in bulk");
        waitTOSync();

        clickOnElementUsingActionBuilder(element("icon_calender_dd_bulk"));
        waitTOSync();
        ReportMsg.info("User clicked on calender to clear due date in bulk");
        element("bttn_clear").click();
        ReportMsg.info("User clicks on Clear button");
        waitTOSync();
        clickOnElementUsingActionBuilder(element("bttn_apply_bulk"));
        ReportMsg.info("User clicks on Apply button");
        waitTOSync();
    }

    public void setAvailableDateInBulk() {
        element("chk_box_unit").click();
        ReportMsg.info("User selected entire Unit");
        waitTOSync();
        clickOnElementUsingActionBuilder(element("icon_calender_ad_bulk"));
        waitTOSync();
        element("bttn_done").click();
        ReportMsg.info("User clicks on Done button");
        waitTOSync();
        clickOnElementUsingActionBuilder(element("bttn_apply_bulk"));
        ReportMsg.info("User clicks on Apply button");
        waitTOSync();
    }

    public void clearAvailableDateInBulk() {
        element("chk_box_unit").click();
        ReportMsg.info("User selected entire Unit");
        waitTOSync();
        clickOnElementUsingActionBuilder(element("icon_calender_ad_bulk"));
        waitTOSync();
        element("bttn_clear").click();
        ReportMsg.info("User clicks on Clear button");
        waitTOSync();
        clickOnElementUsingActionBuilder(element("bttn_apply_bulk"));
        ReportMsg.info("User clicks on Apply button");
        waitTOSync();
    }
    
    public void setAndClearDueDateInstructor() {
        waitForElementPresent("inst_set_dd_chkbox");
        clickOnElementUsingActionBuilder(element("inst_set_dd_chkbox"));
        clickOnElementUsingActionBuilder(element("inst_dd_calender"));
        waitTOSync();
        clickOnElementUsingActionBuilder(element("bttn_done"));
        waitTOSync();
        clickOnElementUsingActionBuilder(element("inst_set_dd_chkbox"));
        clickOnElementUsingActionBuilder(element("inst_dd_calender"));
        waitTOSync();
        clickOnElementUsingActionBuilder(element("bttn_clear"));
        waitTOSync();
    }
       
}
