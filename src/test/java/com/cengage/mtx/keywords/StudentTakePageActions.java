/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.BasePageActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class StudentTakePageActions extends BasePageActions {
    int countOfActivity;

public  StudentTakePageActions(WebDriver driver) {
        super(driver, "studentTakeDeletePage");
    }

public void DeleteActivityTakes(String name) {

    wait.hardWait(6);

    wait.waitForPageToLoadCompletely();
    waitTOSync();
        Assert.assertTrue(isElementDisplayed(element("link_student", name)));
        element("link_student", name).click();
        countOfActivity = elements("allActivities").size();
        System.out.println("Total numbr of Activities present with score 0.0%:->" + countOfActivity);
        hover(element("firstActivity"));
        for (int i = 1; i <= countOfActivity; i++) {
            waitTOSync();
            waitTOSync();
                    scrollDown(elementWithoutWait("Score_activity"));
                    isElementDisplayed(element("Score_activity"));
                    //scrollToDelete(element("Score_activity", j));
                    element("Score_activity").click();
                    isElementDisplayed(element("delete_btn"));
                    element("delete_btn").click();
                    isElementDisplayed(element("ConfirmDeletion"));
                    element("ConfirmDeletion").click();
                    System.out.println("Score of activity" + i + "is: deleted");
                    element("Cancelbtn").click();
                    //hover(element("Score_activity"));
        }
    }
public void studentScores(String ActivityTitle, String possibleScore, String Name) {
    wait.hardWait(10);
    wait.waitForPageToLoadCompletely();
    if(elementsWithOutWait("link_student", Name).size()==1)
    {
        Assert.assertTrue(isElementDisplayed(element("link_student", Name)));
        element("link_student", Name).click();
    }
    wait.waitForPageToLoadCompletely();
    waitTOSync();
        hover(element("firstActivity"));
            waitTOSync();
                    scrollDown(elementWithoutWait("scoreVerification", ActivityTitle));
                    String score = element("scoreVerification", ActivityTitle).getText();
                    Reporter.log("Score of Activity" + ActivityTitle + "" +"is" +  score);
                    element("scoreVerification", ActivityTitle).click();
                    waitTOSync();
                    waitTOSync();
                    isElementDisplayed(element("recordedScore"));
                    String recordedScore = element("recordedScore").getText();
                    Reporter.log("Recorded Score is :"+ recordedScore);
                    if(score.equals(recordedScore)){
                    Reporter.log("Correct score is displaying in Recorded Score");
                    }
                    isElementDisplayed(element("possibleScore_Gradebook"));
                    String gradebookPossibleScore =element("possibleScore_Gradebook").getText();
                    Reporter.log("Possible Score is :"+ gradebookPossibleScore);
                    if(possibleScore.equals(gradebookPossibleScore)){
                    Reporter.log("Correct score is displaying in possible Score");
                    }
                    element("Cancelbtn").click();
                    //hover(element("Score_activity"));
    }
public void studentActivityScore(String ActivityTitle) {
    waitTOSync();
    waitTOSync();
    waitTOSync();
    waitTOSync();
    waitTOSync();
        hover(element("firstActivity"));
            waitTOSync();
                    scrollDown(elementWithoutWait("scoreVerification", ActivityTitle));
                    String score = element("scoreVerification", ActivityTitle).getText();
                    Reporter.log("Score of Activity" + ActivityTitle + "is" +  score);
                    element("scoreVerification", ActivityTitle).click();
                    waitTOSync();
                    waitTOSync();
                    isElementDisplayed(element("recordedScore"));
                    String recordedScore =element("recordedScore").getText();
                    if(score==recordedScore)
                    Reporter.log("Correct score is displaying in Recorded Score");
                    element("Cancelbtn").click();
                    //hover(element("Score_activity"));
        
    }

}