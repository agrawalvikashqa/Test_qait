/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.BasePageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author nikitaaggarwal
 */
public class MTXGradebookScoreVerificationPageAction extends BasePageActions{
    
    public MTXGradebookScoreVerificationPageAction(WebDriver driver) {
        super(driver, "GradebookScorePage");
    } 
    String currentScore;
    String classAverage;
    
  public WebElement getActivityFromListOfActivitiesInGradeBook(String activityName) {
        boolean flag = true;
        WebElement activityToBeReturned = null;
        int listSize;
        
        do {
            listSize = 0;
            listSize = driver.findElements(By.xpath("//span[contains(@class,'activity')]/parent::span")).size();
//            System.out.println("Length of list" + listSize);
            for (WebElement activity : driver.findElements(By.xpath("//span[contains(@class,'activity')]/parent::span"))) {
//                System.out.println("Activity Name:" + activity.getText());
               // BasePageActions.waitLong(1);
                if (activity.getText().contains(activityName)) {
                    System.out.println("Activity Name Required" + activity.getText());
                    flag = false;
                    activityToBeReturned = activity;
                    break;
                }
            }
            if (flag) {
                
                scrollDown(driver.findElements(By.xpath("//span[contains(@class,'activity')]/parent::span")).get(10));
            }
        } while (flag);
        return activityToBeReturned;
    }
  
  public void verifyScoreDisplay(String activityName) {
        checkWeekSliderSpinnerToAppear();
        //chemReviewAndChallengePg.reportLog("Verifying score diaplyed in progress app for an activity: " + activityName);
        getlnk_VerifyScoreInGradeBook(activityName)
                .isDisplayed();
    }
  
  public void checkWeekSliderSpinnerToAppear() {
       // expWait.waitForElementToDisappear(By.id("weekslider"), 2);
        waitLong(5);
    }
  public WebElement getlnk_VerifyScoreInGradeBook(String activityName) {
		return (
                        element("scoreInGB", activityName)
                        );
				//element
	}
  
  public WebElement getWhenVisible(By locator, int timeout) {
		WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}
  
}
