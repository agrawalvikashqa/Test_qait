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
public class NonMindtapPageActions extends BasePageActions {
public NonMindtapPageActions(WebDriver driver) {
super(driver, "NonMindtapPage");
    }
 public void EnterActivityTitleAndDescription(String NonMindtap_title , String NonMindtap_description) {
 waitForSpinnerToDisappear();
 element("add_activityname").click();
 element("add_activityname").clear();
 element("add_activityname").sendKeys(NonMindtap_title);
 ReportMsg.info("User added the title of the Activity");
 element("add_description").click();
 element("add_description").clear();
 element("add_description").sendKeys(NonMindtap_description);
 ReportMsg.info("User define the discription of the Activity");
}
 public void SelectGradedTypeActivity() {
 element("select_Graded").click();
 }
 public void SelectPracticeTypeActivity() {
 element("select_practice").click();
 }
 public void ClickOnSaveButton() {
 element("save_btn").click();
 }
 public void DescriptionMaxLengthIsDisplayed() {
     element("description_maxlength_msg").isDisplayed();
 }
 public void EnterActivityTitle(String Error_title) {
 waitForSpinnerToDisappear();
 element("add_activityname").click();
 element("add_activityname").clear();
 element("add_activityname").sendKeys(Error_title);
 ReportMsg.info("User added the title of the Activity");
 element("add_activityname").clear();
}
 public void ErrorMessageIsDisplayed() {
     element("error_required").isDisplayed();
 }
 public void SaveButtonDisabled() {
     element("savedisable_btn").isDisplayed();
 }
 public void EnterMaxWordForActivityDescription(String WordMessage, int MaxWordMessage) {
 waitForSpinnerToDisappear();
 element("add_description").click();
 element("add_description").clear();
 String msg=repeat(WordMessage, MaxWordMessage);
 element("add_description").sendKeys(msg.substring(0, 2001));
 scrollDown(element("savedisable_btn"));
 ReportMsg.info("User define the discription of the Activity");
}
   /**
 * Repeats the given {@link String} n times.
 * 
 * @param str
 *            the {@link String} to repeat.
 * @param n
 *            the repetition count.
 * @throws IllegalArgumentException
 *             when the given repetition count is smaller than zero.
 * @return the given {@link String} repeated n times.
 */
public static String repeat(String str, int n) {
    if (n < 0)
        throw new IllegalArgumentException(
                "the given repetition count is smaller than zero!");
    else if (n == 0)
        return "";
    else if (n == 1)
        return str;
    else if (n % 2 == 0) {
        String s = repeat(str, n / 2);
        return s.concat(s);
    } else
        return str.concat(repeat(str, n - 1));
}
public void EnterMaxWordForActivityTitle(String WordMessage, int MaxWordMessage) {
 waitForSpinnerToDisappear();
  element("add_activityname").click();
 element("add_activityname").clear();
 element("add_activityname").sendKeys(repeat(WordMessage, MaxWordMessage));
 element("title_maxlength_msg").isDisplayed();
 element("add_activityname").clear();
 ReportMsg.info("User added the title of the Activity");
}
}