/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.BasePageActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert; 

public class NotificationCenterPageActions extends BasePageActions {
    String app_heading;
    int countOfMsgs, countOfStudents;
    String msgTimeDate;
    
    public NotificationCenterPageActions(WebDriver driver) {
        super(driver, "NotificationCenterPage");
    }
   public void getTitleOfApp() {
		waitTOSync();
		isElementDisplayed(element("getTitle_Clickable"));
		app_heading = element("getTitle_Clickable").getText();
		System.out.println("App Title:->" + app_heading);
	}
   public void textBoxToTypeMessageIsPresent() {
		isElementDisplayed(element("GetTextBox"));
	}
   public void viewMoreLinkIsPresent() {
		isElementDisplayed(element("lnk_ViewMore"));
	}
   public void sendMessageToIndividualStudentIsPresent() {
		isElementDisplayed(element("lnk_SengMsgToIndividual"));
	}
   public void getListOfMessagesWithDateAndTime() {
		countOfMsgs = elements("get_listOfMessages").size();
		System.out.println("Total numbr of msgs present:->" + countOfMsgs);
		for (int i = 1; i <= countOfMsgs; i++) {
                    String j = String.valueOf(i);
			msgTimeDate = element("get_TimeAndDateOfMessage", j)
							.getText();
			isElementDisplayed(element("get_TimeAndDateOfMessage", j));
			System.out.println("Date and time of message" + i + "is:->"
							+ msgTimeDate);
			Assert.assertTrue(msgTimeDate.contains("Sent on:"));
		}
	}
   public void refreshButtonIsPresent() {
		Assert.assertTrue(isElementDisplayed(element("refreshButton")),
						"refresh button is not dispalyed");
	}
   public void settingButtonIsPresent() {
		Assert.assertTrue(isElementDisplayed(element("settingIcon")),
						"setting button is not dispalyed");
	}
   public void urgentButtonIsPresent() {
		Assert.assertTrue(isElementDisplayed(element("urgentCheckbox")),
						"urgent checkbbox is not dispalyed");
	}
   public void urgentMessageIsPresent() {
		Assert.assertTrue(isElementDisplayed(element("urgentMessage")),
						"urgent message is not dispalyed");
	}
   public void clickOnSettingIconAndVerifyUI(String userEmailId) {
		element("settingIcon").click();
		isElementDisplayed(element("userEmailText", userEmailId));
		isElementDisplayed(element("label_settingNotiToEmail"));
		isElementDisplayed(element("label_settingNotiToPhone"));
		isElementDisplayed(element("form_settingNotiToEmail"));
		isElementDisplayed(element("form_settingNotiToPhone"));
	}
}
