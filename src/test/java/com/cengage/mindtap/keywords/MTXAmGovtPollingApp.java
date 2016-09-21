package com.cengage.mindtap.keywords;

import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;
import com.qait.automation.utils.PropFileHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class MTXAmGovtPollingApp extends BasePageActions {

    public MTXAmGovtPollingApp(WebDriver driver) {
        super(driver, "MTXPollingApp");
    }

    public void clickOnUnitPlusButton() {
        wait.waitForPageToLoadCompletely();
        element("plus_btn").click();
        ReportMsg.info("User clicked on plus button of unit");
    }

    public void clickOnCreateNewPoll() {
        wait.waitForElementToBeClickable(element("createnewpoll_btn"));
         scrollDown(element("createnewpoll_btn"));
        element("createnewpoll_btn").click();
        ReportMsg.info("User clicked on create new poll button");
    }
    public void fillEntriesForCreatingPoll() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println("Enter in Fill Entries");
        String poll="Poll_"+dateFormat.format(cal.getTime())+" for student";
        element("pollTitle_txt").sendKeys(poll);
        PropFileHandler.writeProperty("PollName", poll);
        System.out.println("Entered Poll title");
        element("pollDescription_txt").sendKeys("This poll is for students");
        String questio = "Who is the primeminister of India";
        element("pollQuestion_txt").sendKeys(questio);
        PropFileHandler.writeProperty("Question", questio);
        element("pollChoiceField_txt").sendKeys("Narendra Modi");
        PropFileHandler.writeProperty("Answer", "Narendra Modi");
        element("pollChoiceField1_txt").sendKeys("Manmohan Singh");
        element("addChoice_btn").click();
        element("pollChoiceField2_txt").sendKeys("Soniya Gandhi");
        element("addChoice_btn").click();
        element("pollChoiceField3_txt").sendKeys("Rahul Gandhi");
        ReportMsg.info("User entered the data for creating the poll");
    }

    public void clickOnSaveAndCloseButton() {
        element("savePoll_btn").click();
        ReportMsg.info("User clicked on save and close button");
    }

    public void verifyAndClickPollFromStudent() {
        element("studentpoll_link", PropFileHandler.readProperty("PollName")).isDisplayed();
        ReportMsg.info("Poll is present at student end");
        element("studentpoll_link", PropFileHandler.readProperty("PollName")).click();
        ReportMsg.info("User clicked on Poll");
    }

    public void verifyQuestionOfPollFromStudent() {
        wait.waitForElementToBeVisible(element("question_link"));
        wait.hardWait(2);
        Assert.assertEquals(element("question_link").getText(), PropFileHandler.readProperty("Question"));
        ReportMsg.log("[Assert Pass]:Correct Question is present in Poll");
    }

    public void verifyAllResponses() {
        List<WebElement> response = elements("answer_link");
        List<WebElement> radio = elements("answer_radiobtn");
        for (int i = 0; i < response.size(); i++) {
            isElementDisplayed(response.get(i));
            ReportMsg.info(response.get(i).getText() + " is present at student end");
            if (response.get(i).getText().contains(PropFileHandler.readProperty("Answer"))) {
                radio.get(i).click();
            }
        }
    }

    public void clickOnVoteButton() {
        element("vote_btn").click();
        ReportMsg.info("User clicked on vote button");
    }

    public void verifyAndClickDeleteButton() {
        isElementDisplayed(element("polldelete_btn"));
        ReportMsg.info("Delete Button Is present for poll");
        wait.hardWait(2);
        scrollDown(element("polldelete_btn"));
        clickOnElementUsingActionBuilder(element("polldelete_btn"));
        handleAlert();
        Assert.assertTrue(checkIfElementIsNotThere("polldelete_btn"));
        ReportMsg.info("Delete Button Is not present after deleted poll");
        switchToDefaultContent();
    }
}
