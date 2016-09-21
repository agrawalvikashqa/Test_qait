/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QAI
 */
public class CSMPageActions extends BasePageActions {

    public CSMPageActions(WebDriver driver) {
        super(driver, "CSMPage");
    }

    public void clickOnEditCSMCourse() {
        element("edit_csm_course_link").click();
    }

    public void clickOnAddCoInstuctorOrTALink() {
        waitTOSync();
        waitForElementPresent("course_info_header");
        scrollDown(element("add_inst_ta_link"));
        element("add_inst_ta_link").click();
    }

    public void addCoInstructorToCourse() {
        element("add_coinst_email_txtbox").sendKeys("inst24_mtx_240615@qaittest.com");
        element("add_btn").click();
    }

    public void addTAtoCourse() {
        element("add_coinst_email_txtbox").sendKeys("mt10_ta_1020@swlearning.com");
        element("add_btn").click();
        waitTOSync();
    }

    public void clickSaveChangesButtonOnEditCoursePage() {
        element("save_changes_btn").click();
        waitTOSync();
    }

    public void verifyChangesAreSavedFromEditCoursePage() {
        waitForElementPresent("heading_manage_courses");
   //     Assert.assertEquals(driver.getTitle(), "Manage Courses");

    }
     
    public void coinstructorLaunchCourse(String courseKey, String env) {
        waitForElementPresent("book_link");
        //element("manage_course").click();
        waitForElementPresent("courseName_link");
        String hrefAttribute = element("courseName_link", courseKey).getAttribute("href");
        String[] hrefURL;
        hrefURL = hrefAttribute.split("http.*.ng.cengage.com");
        System.out.println("URL Fetched:\n" + hrefAttribute);
        if (env.equals("STAGE")) {
            System.out.println("Navigated To STAGE Env.");
            System.out.println("http://mindtap-staging.cengage.com" + hrefURL[1]);
            driver.navigate().to("http://mindtap-staging.cengage.com" + hrefURL[1]);
        }
    }
    
    
    public void verifyCourseSettingsLink() {
        waitForElementPresent("user_menu_link");
        clickOnElementUsingActionBuilder(element("user_menu_link"));
        waitForElementPresent("course_settings_link");
        isElementDisplayed(element("course_settings_link"));
    }

    public void courseSettingsWindowlaunch() {
        clickOnElementUsingActionBuilder(element("course_settings_link"));
        waitTOSync();
    }

    public void clickOnInstructorAndTAPermissions() {
        waitForElementPresent("course_settings_title");
        waitForElementPresent("inst_ta_expand");
        element("inst_ta_expand").click();
    }

    public void verifyPrimaryInstructorAndTAareDisplayed() {
        isElementDisplayed(element("primary_inst_expand"));
        isElementDisplayed(element("teach_assist_expand"));
    }

    public void CoInstructorCapabilitiesByDefault() {
        clickOnElementUsingActionBuilder(element("co_inst_expand"));
    }

    public void verifyAllCoInstructorCapabilitiesChecked() {
        List<WebElement> checkBoxes = new ArrayList();
        checkBoxes = elements("co_inst_capabilities_allchkboxes");
        for (WebElement box : checkBoxes) {
            Assert.assertTrue(box.isSelected(), "FAIL : CheckBox is not selected");
        }
    }

    public void TACapabilitiesByDefault() {
        waitForElementPresent("teach_assist_expand");
        clickOnElementUsingActionBuilder(element("teach_assist_expand"));
        waitTOSync();
        scrollDown(element("ta_manage_lpn_cap_chkbox"));
        List<WebElement> checkBoxes = new ArrayList();
        checkBoxes = elements("ta_capabilities_allchkboxes");
        for (WebElement box : checkBoxes) {
            Assert.assertFalse(box.isSelected(), "FAIL : CheckBox is selected for TA by default");
        }
    }
    
    public void CoIntructorEditTACapabilities(){
        scrollDown(element("ta_manage_lpn_cap_chkbox"));
        List<WebElement> checkBoxes = new ArrayList();
        checkBoxes = elements("ta_capabilities_allchkboxes");
        for (WebElement box : checkBoxes) {
            box.click();
        }
    }
    

    public void CoInstructorLogout() {
        waitForElementPresent("user_menu_link");
        clickOnElementUsingActionBuilder(element("user_menu_link"));
        clickOnElementUsingActionBuilder(element("logout_link"));
        waitForElementPresent("logout_mt_text");
    }

    public void instructorLaunchCSMCourse(String courseKey, String env) {
        waitForElementPresent("book_link");
       // element("manage_course").click();
        waitForElementPresent("courseName_link");
        String hrefAttribute = element("courseName_link", courseKey).getAttribute("href");
        String[] hrefURL;
        hrefURL = hrefAttribute.split("http.*.ng.cengage.com");
        System.out.println("URL Fetched:\n" + hrefAttribute);
        if (env.equals("STAGE")) {
            System.out.println("Navigated To STAGE Env.");
            System.out.println("http://mindtap-staging.cengage.com" + hrefURL[1]);
            driver.navigate().to("http://mindtap-staging.cengage.com" + hrefURL[1]);
        }
    }
    
    public void verifyCoInstructorAndTAareDisplayed() {
        isElementDisplayed(element("co_inst_expand"));
        isElementDisplayed(element("teach_assist_expand"));
    }

    public void instructorEditsCapabilitiesOfTA() {
        clickOnElementUsingActionBuilder(element("teach_assist_expand"));
        waitTOSync();
        scrollDown(element("ta_manage_lpn_cap_chkbox"));
        List<WebElement> checkBoxes = new ArrayList();
        checkBoxes = elements("ta_capabilities_allchkboxes");
        for (WebElement box : checkBoxes) {
            if (box.isSelected()) {
                clickOnElementUsingActionBuilder(box);
            }
        }
        
    }

    public void savePermissionButtonAndDoneButtonOnCSMWindow() {
        scrollDown(element("ta_grade_capability_chkbox"));
        Assert.assertTrue(isElementDisplayed(element("save_permissions_btn")), "FAIL: Save Permission Button is Not Displaying in CSM");
        Assert.assertTrue(isElementDisplayed(element("csm_done_btn")), "FAIL: Done Button is Not Displaying in CSM");
    }

    public void saveCSMSettings() {
        clickOnElementUsingActionBuilder(element("save_permissions_btn"));
        waitTOSync();
        clickOnElementUsingActionBuilder(element("csm_done_btn"));
    }

    public void primaryInstructorLogoutAfterSavingCSMSettings() {
        waitForElementPresent("user_menu_link");
        clickOnElementUsingActionBuilder(element("user_menu_link"));
        clickOnElementUsingActionBuilder(element("logout_link"));
        waitForElementPresent("logout_mt_text");
    }

    public void CourseSettingLinkPresentForTA() {
        waitForElementPresent("user_menu_link");
        element("user_menu_link").click();
        waitForElementPresent("course_settings_link");
        Assert.assertTrue(isElementDisplayed(element("course_settings_link")), "FAIL : Course Settings Link is Not Displaying for TA");
        waitTOSync();
        element("user_menu_link").click();
    }

    public void setAndClearDueDateTA() {
        waitForElementPresent("date_manager_view_tab");
        clickOnElementUsingActionBuilder(element("date_manager_view_tab"));
        waitForElementPresent("ta_set_dd_chkbox");
        clickOnElementUsingActionBuilder(element("ta_set_dd_chkbox"));
        clickOnElementUsingActionBuilder(element("ta_dd_calender"));
        waitTOSync();
        clickOnElementUsingActionBuilder(element("date_manager_done_btn"));
        waitTOSync();
        clickOnElementUsingActionBuilder(element("ta_set_dd_chkbox"));
        clickOnElementUsingActionBuilder(element("ta_dd_calender"));
        waitTOSync();
        clickOnElementUsingActionBuilder(element("date_manager_clear_btn"));
        waitTOSync();
    }

    public void logOutTAFromMindtap() {
        waitForElementPresent("user_menu_link");
        clickOnElementUsingActionBuilder(element("user_menu_link"));
        clickOnElementUsingActionBuilder(element("logout_link"));
        waitForElementPresent("logout_mt_text");
    }

    public void removeCoInstructorAndTA() {
        waitForElementPresent("course_info_header");
        scrollDown(element("add_inst_ta_link"));
        waitTOSync();
        List<WebElement> checkBoxes = new ArrayList();
        checkBoxes = elements("remove_coinst_ta_cross_btn");
        for (WebElement box : checkBoxes) {
            box.click();
        }

        scrollDown(element("add_inst_ta_link"));
        waitTOSync();
        clickOnElementUsingActionBuilder(element("save_changes_btn"));
        waitForElementPresent("heading_manage_courses");
    }

    public void editCapabilitiesTA() {
        waitForElementPresent("user_menu_link");
        clickOnElementUsingActionBuilder(element("user_menu_link"));
        clickOnElementUsingActionBuilder(element("course_settings_link"));
        waitForElementPresent("course_settings_title");
        clickOnElementUsingActionBuilder(element("inst_ta_expand"));
        waitTOSync();
        clickOnElementUsingActionBuilder(element("teach_assist_expand"));
        scrollDown(element("ta_manage_lpn_cap_chkbox"));
        List<WebElement> checkBoxes = new ArrayList();
        checkBoxes = elements("ta_capabilities_allchkboxes");
        for (WebElement box : checkBoxes) {
            if (box.isSelected()) {
                clickOnElementUsingActionBuilder(box);
            }
        }
        scrollDown(element("ta_grade_capability_chkbox"));
        clickOnElementUsingActionBuilder(element("save_permissions_btn"));
        waitTOSync();
        waitTOSync();
        clickOnElementUsingActionBuilder(element("csm_done_btn"));

    }
}