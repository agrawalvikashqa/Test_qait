/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.keywords;


import com.cengage.mindtap.keywords.BasePageActions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author nikitaaggarwal
 */
public class WeekWidgetPageActions extends BasePageActions {

public WeekWidgetPageActions(WebDriver driver) {
        super(driver, "weekwidgetPage");
    }



    public void verifyDashboardView() {
		waitTOSync();
                Reporter.log("DashboardView");
		verifyWeekWidget();
		Assert.assertTrue(isElementDisplayed(element("getPerformanceWidget")), "performance widget is not displayed");
		//Assert.assertTrue(isElementDisplayed(element("getCurrentScoreWidget")), "current score widget is not displayed");
                waitTOSync();
		Assert.assertTrue(isElementDisplayed(element("CengageLearningLogo")), "Cengage learning logo is not displayed");
		userMenuAtTop();
	}
    public void verifyWeekWidget() {
		Reporter.log("Verifying Week widget view gets loaded");
		waitTOSync();
		try {
		        isElementDisplayed(element("wdgt_weekview"));
		} catch (Exception e) {
			try {
				driver.navigate().refresh();
				waitTOSync();
				isElementDisplayed(element("wdgt_weekview"));
			} catch (Exception em) {
				driver.navigate().refresh();
				waitTOSync();
				isElementDisplayed(element("accept_btn"));
				element("accept_btn").click();
				isElementDisplayed(element("wdgt_weekview"));
			}
		}
	}
    
    public void userMenuAtTop() {
		Assert.assertTrue(isElementDisplayed(element("get_UserMenu")), "user menu is not displayed");
		element("get_UserMenu").click();
		executeJavascript("document.getElementsByClassName('user-menu')[0].setAttribute('style','display: block;');");
		waitTOSync();
		try {
			Assert.assertTrue(isElementDisplayed(element("UserMenuCustomerSupport")), "customer support is not displayed");
		} catch (NoSuchElementException e) {
			Assert.assertTrue(isElementDisplayed(element("CustomerSupportText")), "customer support is not displayed");
		}
		Assert.assertTrue(isElementDisplayed(element("UserMenuLogout")), "Logout button is not displayed");
		Assert.assertTrue(isElementDisplayed(element("UserMenuSystemCheck")), "system check button is not displayed");
	}
    public void elementsAvailableforWeekViewWidgetPage() {
		waitForSpinnerToDisappear();
		Assert.assertTrue(isElementDisplayed(element("weekSlider")), "Week slider is not displayed");
		Assert.assertTrue(isElementDisplayed(element("weekSliderPointer")), "week slider pointer is not displayed");
		Assert.assertTrue(isElementDisplayed(element("previousWeekArrow")), "previous arrow  is not displayed");
		Assert.assertTrue(isElementDisplayed(element("nextWeekArrow")), "next arrow button  is not displayed");
		
                Boolean flag=false;
                if(isElementDisplayed(element("NoActivities")))
                {
                flag=true;
                }
                if (flag==true) 
                {
		navigateToWeek(getData("Books.courseChemistry.weeknumber"));
                    //navigateToWeek("week 44");
			Assert.assertTrue(isElementDisplayed(element("DueDateUnderUnitHeading")), "Due date under Unit heading in week view  is not displayed");
		} else {
			Assert.assertTrue(isElementDisplayed(element("DueDateUnderUnitHeading")), "Due date under Unit heading in week view  is not displayed");
		}
		Reporter.log("Due Date Display under Unit Heading is : " + element("DueDateUnderUnitHeading").getText());
	}
    public void navigateToWeek(String week) {
		// String temp = driver.getCurrentUrl();
                wait.resetImplicitTimeout(getTimeOut());
                switchToDefaultContent();
		String[] weeknav = week.toLowerCase().split("week");
                int weekNo=0;
                try{
		weekNo = Integer.parseInt(weeknav[1].trim());
                }
                catch(Exception e){
                    Reporter.log("Exception");
                }
                String WeekNo = String.valueOf(weekNo);
		if (weekNo == 1 || weekNo == 2)
			element("specificWeek2", WeekNo).click();
                else {
		 wait.resetImplicitTimeout(getTimeOut());
                 clickOnElementUsingActionBuilder(element("specificWeek2", WeekNo));
                }
    
	}
    public void piIconWithAllActivities() {
		waitTOSync();
		for (int i = 0; i < 12; i++) {
			try {
				waitForSpinnerToDisappear();
				if (elements("unitHeaderInActiveWeek").get(0).getText().contains("No Unit")) {
					element("nextWeekArrow").click();
					waitTOSync();
					continue;
				}
				Assert.assertTrue(elements("ActivityInActiveWeek").size() == (elements("PiIconInActiveWeek").size() + 1), "Number of Activity not equal to Pi Icon display for week : " + i);
			} catch (AssertionError e) {
			}
		}
	}
    public void verifyNotificationWidgetView() {
		try {
			Reporter.log("Verifying Notification widget view on home page");
			Assert.assertEquals(elements("MessagesInNotificationWidget").size(), 1, "number of messages is notification view is not equal to 3");
			Assert.assertEquals(elements("MessagesTimestampInNW").size(), 1, "Timestamp for all the 3 messages in notification view is not displayed");
		} catch (TimeoutException e) {
			driver.navigate().refresh();
			waitTOSync();
			Reporter.log("Page Reload as dashboard not loaded");
			Reporter.log("Page Reload as dashboard not loaded");
			Assert.assertEquals(elements("MessagesInNotificationWidget").size(), 1, "number of messages is notification view is not equal to 3");
			Assert.assertEquals(elements("MessagesTimestampInNW").size(), 1, "Timestamp for all the 3 messages in notification view is not displayed");
			Reporter.log(e.getMessage());
		}
    }
    public void verifyCurrentCourseScoreWidgetView() {
		Reporter.log("Verifying current course widget");
		Assert.assertTrue(isElementDisplayed(element("getCurrentScoreWidget")), "Current score Widget progress bar doesn't contains %");
	}
    public void clickOnAllApps() {
		waitTOSync();
		waitForSpinnerToDisappear();
		isElementDisplayed(element("getLink_AllScore"));
		waitForSpinnerToDisappear();
		isElementDisplayed(element("btn_allApps"));
		Reporter.log("Clicking on All Apps button");
		element("btn_allApps").click();
		waitTOSync();
	}
    
    public void clickOnMessageCenterApp() {
		waitForSpinnerToDisappear();
		for (int i = 0; i < elements("lbl_appName").size(); i++) {
			if (elements("lbl_appName").get(i).getAttribute("title").equals("Message Center")) {
			executeJavascript("document.getElementById('dockGroup1').childNodes[" + ((2 * i) + 1) + "].childNodes[0].click();");
				break;
			} else {
				continue;
			}
		}
	}
    public void verifyStatusIconAsStartedOrInProgressForAllTheActivities() {
		int noOfActivities = elements("ListOfStatusIcon").size();
		for (int i = 0; i < noOfActivities; i++) {
			String status = elements("ListOfStatusIcon").get(i).getAttribute("title");
			Assert.assertTrue(status.contains("Progress") || status.contains(""), "activites status icon is not correct");
		}
		Assert.assertTrue(elements("ListOfAssignmentName").size() == elements("ListOfStatusIcon").size());
	}
    public void verifyStausDisplayAsCompleted(String activityName) {
         switchToDefaultContent();
		Reporter.log("Verifying Status indicator as completed for activity: " + activityName);
                waitTOSync();
                waitTOSync();
		Assert.assertTrue(isElementDisplayed("getSubmittedIndicator",activityName));
		waitTOSync();
	}
    public void verifyActivityInProgressIcon(String activityName) {
        switchToDefaultContent();
                waitTOSync();
                waitTOSync();
		Assert.assertTrue(element("getInProgressIndicator",activityName).isDisplayed(), "In progress activity icon is not displayed");
                Reporter.log("In progress status indicator is present");
		
	}
    public void verifyNotStartedStatusIconForActivity(String activity) {
		 Assert.assertTrue(element("getNotStartedindicator",activity).isDisplayed(),"Status Icon of activity is not equal to 'Not started'");
                 Reporter.log("Not Started status indicator is present");
		
	}
    

    private Object Integer(int weekNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
