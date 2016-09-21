/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

//import com.qait.automation.utils.ReportMsg;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author QAI
 */
public class GradeBookAppPageAction extends BasePageActions {

    List<WebElement> distinctActivityList_Size;
    int distinctActivity_Size;
    boolean flag = true;
    WebElement element;

    public GradeBookAppPageAction(WebDriver driver) {
        super(driver, "GradeBookPage");
    }

    public boolean verifyGradeBookAppOpened() {
        return element("gradeBookApp").isDisplayed();
    }

    public void verifyStudentRosterByHighAverageAndLowPerformance() {
        //gradeBookPage.deselectFrame()
        switchToDefaultContent();
        //gradeBookPage.switchToDockIFrame()
        switchToDockIFrame();
//        selectLevelInOverallPerformance("High");
//        //assert gradeBookPage.verifyLevelChangesReflectedInUserViewport("High")
//        gradeBookPage.selectLevelInOverallPerformance("Average")
//        assert gradeBookPage.verifyLevelChangesReflectedInUserViewport("Average")
//        gradeBookPage.selectLevelInOverallPerformance("Low")
//        assert gradeBookPage.verifyLevelChangesReflectedInUserViewport("Low")
//        gradeBookPage.selectLevelInOverallPerformance("View All")
        //gradeBookPage.deselectFrame()
    }

    public void selectLevelInOverallPerformance(String level) {
        switchToDefaultContent();
        switchToDockIFrame();
        waitForElementPresent("dropdown_performance");
        System.out.println("dropdown is visible");
        Select select = new Select(element("dropdown_performance"));
        select.selectByValue(level);
        waitTOSync();
    }

    public boolean verifyLevelChangesReflectedInUserViewport(String level) {
        waitForElementPresent("overallpercent");
        for (WebElement studentOverallScoreColumn : elements("overallpercent")) {
            String displayValue = studentOverallScoreColumn.getText();
            // System.out.println(displayValue);
            String[] parts = displayValue.split("%");
            String displayScore = parts[0];
            float score = Float.parseFloat(displayScore);
            if (score > 90 && level.equals("High")) {
                return true;
            } else if (score > 70 && score < 90 && level.equals("Medium ")) {
                return true;
            } else if (score < 70 && level.equals("Low")) {
                return true;
            } else {
                return false;
            }
        }

        Reporter.log("Element overallpercent not found");
        return false;
    }

    /**
     * Verify expanded view of grade book.
     */
    public void verifyExpandedViewOfGradeBook() {
        switchToDefaultContent();
        switchToDockIFrame();
        waitTOSync();
        waitForElementPresent("btn_expandgradebook");
        element("btn_expandgradebook").click();
        //Assert.assertTrue(collapsedGradeBook_btn.isDisplayed())
        //Assert.assertTrue(gradesCellsInGrid.isDisplayed())
        //switchToDefaultContent();
    }

    public boolean verifycollapsedGradeBookButton() {
        waitForElementPresent("btn_collapsedgradebook");
        return element("btn_collapsedgradebook").isDisplayed();
    }

    public boolean verifygradesCellsInGrid() {
        waitForElementPresent("gradescellsingrid");
        return element("gradescellsingrid").isDisplayed();
    }

    public void verifyTotalPossiblePointsBelowActivityInGrid() {
        //waitTOSync();
        switchToDefaultContent();
        switchToDockIFrame();
        verifyTotalPossiblePointsInGrid();
        switchToDefaultContent();
    }

    public void verifyTotalPossiblePointsInGrid() {
        for (WebElement possiblePoints : elements("totalPossiblePoints")) {
            possiblePoints.isDisplayed();
        }
    }

    public void verifyGradedActivitiesUnderCorrespongingUnitsDisplay() {
        switchToDefaultContent();
        switchToDockIFrame();
        verifyGradedActivitiesUnderCorrespondingUnits();
        switchToDefaultContent();
    }

    public void verifyGradedActivitiesUnderCorrespondingUnits() {
        waitForElementPresent("gradedActivitiesTitlesInGrid");
        for (WebElement gradedActivityTitle : elements("gradedActivitiesTitlesInGrid")) {
            gradedActivityTitle.isDisplayed();
        }
    }

    /**
     * Verify collapsed view of grade book.
     */
    public void verifyCollapsedViewOfGradeBook() {
        switchToDefaultContent();
        switchToDockIFrame();
        waitForElementPresent("btn_collapsedgradebook ");
        element("btn_collapsedgradebook ").click();
        waitTOSync();
    }

    public boolean verifyexpandGradeBookButton() {
        return element("btn_expandgradebook").isDisplayed();
    }

//    
//    public void verifyEnrolledStudentAndSelectActivity(String activityTitle,String user){
//        selectTheUser(user);
//        selectTheActivity(activityTitle);
//        closeActivityModalInGradeBook();
//    }
//    
//    /**
//     * Select the user.
//     *
//     * @param user the user
//     */
//    public void selectTheUser(user){
//        switchToDockIFrame();
//        waitTOSync();
//        if(getBrowser == "firefox"){
//            driver.findElement(By.xpath("//*[contains(@class,'ag-cell-value') and contains(.,'"+user+"')]")).click()
//        }
//        else if(getBrowser == "chrome"){
//            clickOnElementUsingActionBuilder( driver.findElement(By.xpath("//*[contains(@class,'ag-cell-value') and contains(.,'"+user+"')]")))
//        }
//        
//        
//    }
    public void verifyOrangeLinkDisplayedInManualGradedActivity(String studentname) {
       waitTOSync();
        clickStudentName(studentname);
        waitForElementPresent("btn_scorebreakdown ");
        verifyColorEncoding();
    }

    public void verifyColorEncoding() {
        try {
            waitForElementPresent("manualgradeactivity");
            String activitycolor;
            for (WebElement manualgradeactivitylinks : elements("manualgradeactivity")) {
                scrollDown(manualgradeactivitylinks);
                activitycolor = manualgradeactivitylinks.getCssValue("color");
                //System.out.println("Color of activity: "+activitycolor);
                if (activitycolor.equalsIgnoreCase("rgba(248, 128, 23, 1)")) {
                    Assert.assertTrue(true, "Manual graded activity link is not shown orange");
                    //System.out.println("Activity text :"+manualgradeactivitylinks.getText());
                } else {
                    Assert.assertTrue(false, "Manual graded activity link is shown orange");
                }

            }
        } catch (NoSuchElementException ex) {
            Reporter.log("No manual graded activity found for the current user");
        }
    }

    public void verifyPendingGradeTextInManualGradedActivityIsDisplayed() {
        try {
            waitForElementPresent("manualgradeactivitywithoutgrades");
            //for(WebElement manualgradeactivitylinks : elements("manualgradeactivitywithoutgrades")){
            //element("activity").click();
            clickOnElementUsingActionBuilder(element("manualgradeactivitywithoutgrades"));
            waitTOSync();
            if (element("txt_pendinggradingbyinstructor").getText().equalsIgnoreCase("Pending grading by instructor")) {
                Assert.assertTrue(true, "Pending Grade Text In Manual Graded Activity Is Not Displayed");
            } else {
                Assert.assertTrue(false, "Pending Grade Text In Manual Graded Activity Is Not Displayed");
            }
        } catch (NoSuchElementException ex) {
            Reporter.log("No Manual Graded Activity Without Grades Found For The Current User");
        }
        closeModalButton();
    }

    public void closeModalButton() {
        element("btn_closemodal").click();
    }

    public void verifyStudentGradesShowInOneDecimalPlace() {
        switchToDefaultContent();
        switchToDockIFrame();
        clickOnElementUsingActionBuilder(element("activitywithoutscore"));
        waitTOSync();
        clickOnEditPoints();
        clickOnEditScoreBox();
        enterValidScoreUpto3DecimalPlace();
        // return verifyScoreRoundedOffToTenthPlace();

    }

    public void clickOnEditPoints() {
        switchToDefaultContent();
        switchToDockIFrame();
        waitForElementPresent("btn_editscore");
        element("btn_editscore").click();
        switchToDefaultContent();
    }

    public void clickOnEditScoreBox() {
        switchToDefaultContent();
        switchToDockIFrame();
        waitForElementPresent("txt_editscorebox");
        element("txt_editscorebox").click();
        waitTOSync();
        element("txt_editscorebox").clear();
        switchToDefaultContent();
    }

    public void enterValidScoreUpto3DecimalPlace() {
        switchToDefaultContent();
        switchToDockIFrame();
        float score = 2.345f;
        String score2 = Float.toString(score);
        element("txt_editscorebox").click();
        // typeOnElementUsingActionBuilder("element("txt_editscorebox")",score.toString());
        typeOnElementUsingActionBuilder(element("txt_editscorebox"), score2);
        element("btn_savescrore").click();
        waitTOSync();
        switchToDefaultContent();
    }

    public boolean verifyScoreRoundedOffToTenthPlace() {
        switchToDefaultContent();
        switchToDockIFrame();
        float newScore = 2.3f;
        waitForElementPresent("pointscored");
        String recordedScore = element("pointscored").getText();
        float score = Float.parseFloat(recordedScore);
        //System.out.println("score:"+ score);
        //System.out.println("newScore:"+ newScore);
        //switchToDefaultContent();
        element("btn_modalclose").click();
        if (score == newScore) {
            return true;
        } else {
            return false;
        }

    }

    public void verifyEditStudentGrades() {
        switchToDefaultContent();
        switchToDockIFrame();
        waitTOSync();
        clickOnElementUsingActionBuilder(element("activitywithoutscore"));
        System.out.println("launched activitywithoutscore");
        waitTOSync();
        editScoreForActivity();
        System.out.println("launched editScoreForActivity() method");
        // writeScoreInScoreBox();

    }

    public void editScoreForActivity() {
        clickOnEditPoints();
        clickOnEditScoreBox();
        writeScoreInScoreBox();
    }

    public void writeScoreInScoreBox() {
        //switchToDefaultContent();
        switchToDockIFrame();
        int randomScore = 5;
        String scoreString = Integer.toString(randomScore);
        element("txt_editscorebox").click();
        typeOnElementUsingActionBuilder(element("txt_editscorebox"), scoreString);
        element("btn_savescrore").click();
        waitTOSync();
        waitForElementPresent("commentduetochangedate");
        element("btn_close").click();
        switchToDefaultContent();
    }

    public void selectCategoryFromFilterAssignmentsLinkInGrid() {
        switchToDefaultContent();
        switchToDockIFrame();
        clickOnFilterAssignmentsLink();
        enterTextInCategoryInputBox("uncategorized");
        clickOnApplyFilterButton();
        switchToDefaultContent();
    }

    public void clickOnFilterAssignmentsLink() {
        waitTOSync();
        waitForElementPresent("link_filterassignments");
        element("link_filterassignments").click();
    }

    public void enterTextInCategoryInputBox(String category) {
        waitForElementPresent("categoryinputbox");
        waitTOSync();
        element("categoryinputbox").click();
        element("categoryinputbox").sendKeys(category);
       // typeOnElementUsingActionBuilder(element("categoryinputbox"), category);
        //clickOnElementUsingActionBuilder(element("categoryselectchoice"));

    }

    public void clickOnApplyFilterButton() {
        waitTOSync();
        waitForElementPresent("applyfilterbutton");
        element("applyfilterbutton").click();
    }

    public boolean verifyFirstAndLastNameVisible(String studentname) {
        switchToDefaultContent();
        switchToGradeBookFrame();
        String stud_name = element("link_student").getText();
        System.out.println("Student name on roster is : " + stud_name);
        return stud_name.contains("studentname");

    }

    public void selectStudent(String name) {
        element("link_student", name).click();
    }

    public void selectActivity(String activityname) {
        element("link_activity", activityname).click();
    }

    public boolean verifyActivityDetailDialog(String activityname) {
        switchToGradeBookFrame();
        return isElementDisplayed(element("activitytext", activityname));

    }

    public void verifyActivityDetails(String name, String activityname) {
        switchToDefaultContent();
        switchToGradeBookFrame();
        selectStudent(name);
        waitTOSync();
        selectActivity(activityname);
        //verifyActivityDetailDialog(activityname);
    }

    public void selectPerformanceFilter(String option) {
        waitForElementPresent("dropdown_performance");
        System.out.println("dropdown is visible");
        Select select = new Select(element("dropdown_performance"));
        select.selectByValue(option);
        waitTOSync();
    }

    public boolean verifyGridSort(String studentname, String option) {
        selectPerformanceFilter(option);
        waitTOSync();
        return element("link_student", studentname).isDisplayed();

    }

    public boolean verifyActivityFromGradebook(String studentname, String activitytype, String activitytitle) {

        switchToDefaultContent();
        switchToDockIFrame();
        //element("link_student", studentname).click();
        clickStudentName(studentname);
        waitForElementPresent("btn_scorebreakdown ");
        waitTOSync();
        return element("fetchactivity", activitytype, activitytitle).isDisplayed();
        //clickOnElementUsingActionBuilder(element("activitywithoutscore"));
    }

    public void gradeBookHome() {
        element("btn_back").click();
    }

    public void closeApp() {
        element("link_closeapp").click();
    }

    public void deleteAnAttempt(String studentname, String activitytitle) {
        waitTOSync();
        element("link_student", studentname).click();
        //switchToDefaultContent();
        //switchToDockIFrame();
//       WebElement new1 = element("fetchactivity",activityname);
//       waitForElementPresent("new1");
        waitTOSync();
        clickOnElementUsingActionBuilder(element("activitywithoutscore", activitytitle));

    }

    public void selectTheUser(String studentname) {
        switchToDefaultContent();
        switchToDockIFrame();
        waitTOSync();
        //clickOnElementUsingActionBuilder(element("link_student", studentname));
        element("link_student", studentname).click();
    }

    public void selectTheActivity(String activityname) {
        // waitTOSync();
        switchToDefaultContent();
        switchToDockIFrame();
        waitForElementPresent("learningpath");
        clickOnElementUsingActionBuilder(element("fetchactivity", activityname));
        //driver.findElement(By.xpath("//span[contains(@title,'"+activityTitle+"')]")))
        //driver.findElement(By.xpath("//span[contains(@title,'"+activityTitle+"')]")).click()
    }

    public void extendDueDateForStudent() {
        waitTOSync();
        scrollDown(elementWithoutWait("activity"));
        element("activity").click();
        waitTOSync();
        clickOnDateSelector();
        setDueDate();
       verifyDueDateExtended();
        element("btn_close").click();
    }

    void clickOnDateSelector() {
        waitForElementPresent("button_dateselector");
        element("button_dateselector").click();
        waitTOSync();
    }

    public void setDueDate() {
        List<WebElement> daysList = elements("link_date");
        for (int counter = 0; counter < daysList.size(); counter++) {
            String dayClass = daysList.get(counter).getAttribute("class");
            if (dayClass.contains("btn-info")) {
                String date = daysList.get(counter).getText();
                if (date.equals("29") || date.equals("30") || date.equals("31")) {
                    element("nextMonth_btn").click();
                    waitTOSync();
                    List<WebElement> daysList1 = elements("link_date");
                    //  List<WebElement> daysList1=driver.findElements(By.xpath("//td[@class='text-center ng-scope']/button"))
                    daysList1.get(0).click();
                    break;
                } else {
                    daysList.get(counter + 2).click();
                    break;
                }
            }
        }
        waitTOSync();
        waitForElementPresent("btn_done");
        element("btn_done").click();
    }
    

    public boolean verifyDueDateExtended() {
        waitForElementPresent("btn_duedateselector");
        return element("showextendedduedate").isDisplayed();
        
    }
    
    
    public boolean verifySystemGeneratedCommentsNotEditable() {
        boolean flag;
        try {
            resetImplicitTimeout(2);
            element("commentnoteditable");
            flag = false;
        } catch (NoSuchElementException ex) {
            flag = true;
        }
        resetImplicitTimeout(AJAX_WAIT);
        System.out.println("flag value is" + flag);
        return flag;
    }

    public void closeGradeBookApp() {
        switchToDefaultContent();
        waitForElementPresent("hide_gradebook");
        element("hide_gradebook").click();
        waitTOSync();

    }

    public void verifyActivitiesInOverviewTab() {
        verifyLaunchingOfOverviewkTab();
    }

    public void verifyLaunchingOfOverviewkTab() {
        switchToDockIFrame();
        element("tab_overview").click();
        Assert.assertTrue(element("bar_activityheader").isDisplayed());
        switchToDefaultContent();

    }

    public void launchActivityFromOverviewTab(String title) {
        waitTOSync();
        switchToDefaultContent();
        switchToDockIFrame();
        //WebElement activity = (element("fetchactivity",activityname));
        // waitForElementPresent(pageName);
        clickOnElementUsingActionBuilder(element("fetchactivitybyname", title));
       
        //activity.click()
        switchToDefaultContent();

        selectStudentTab();
    }

    public void launchActivityInApp(String title) {
        switchToDefaultContent();
        switchToDockIFrame();
        //WebElement activity = (element("fetchactivity",activityname));
        // waitForElementPresent(pageName);
        clickOnElementUsingActionBuilder(element("fetchactivity", title));
        //activity.click()
        switchToDefaultContent();
    }

    public void selectStudentTab() {
        switchToDefaultContent();
        switchToDockIFrame();
        waitTOSync();
        waitTOSync();
        waitForElementPresent("verificationid");
        clickOnElementUsingActionBuilder(element("verificationid"));
        // verificationId.click()
        waitForSpinnerToDisappear();
        switchToDefaultContent();
    }

    public void printScoreFromOverviewTab() {
        printActivityScore("embedded");
    }

    public void printActivityScore(String mode) {
        switchToDockIFrame();
        for (int i = 1; i < 4; i++) {
            waitTOSync();
        }
        String score = element("scoreDispBox").getText();
        System.out.println(score);
        if (mode.contains("popup")) {
            element("btn_close").click();
        }
        switchToDefaultContent();
    }

    public void ClickAndVerifyExpandViewOfGradeBook() {
        verifyExpandedViewOfGradeBook();
    }

    public void ClickOnDisplaySettingAndVerify() {
        switchToDefaultContent();
        switchToDockIFrame();
        waitTOSync();
        element("btn_displaysettings").click();
        waitTOSync();
        //element("btn_savedisplaysetting").click();
        switchToDefaultContent();
    }

    public void collapsedCategoryAndVerifyGradeBookScore() {
        verifyPoint();
        getScoreOfActivitiesFromCategory();
        collapsedCategoryAndVerifyScore();
    }

    public void verifyPoint() {
        switchToDockIFrame();
        // waitForElementPresent("btn_points");
        //clickOnElementUsingActionBuilder(element("btn_points"));
        element("btn_savedisplaysetting").click();
        switchToDefaultContent();
    }

    public void getScoreOfActivitiesFromCategory() {
        switchToDockIFrame();
        waitForElementPresent("scoreinpoint");
        String score = element("scoreinpoint").getText();
        switchToDefaultContent();
    }

    public void collapsedCategoryAndVerifyScore() {
        switchToDockIFrame();
        waitForElementPresent("collapsedcategory");
        element("collapsedcategory").click();
        switchToDefaultContent();
    }

    public boolean getScoreAfterCollapsedCategory() {
        switchToDockIFrame();
        waitForElementPresent("col6");
        String c6 = element("col6").getText();
        switchToDefaultContent();
        String score = element("scoreInPoint").getText();
        return score.contains(c6);
    }

    /**
     * Methods for GradeBookRegPart2Test
     */
    public void gradebookLaunch() {
        Assert.assertTrue(isElementDisplayed("pointsavailable"), "Gradebook not launched");
    }

//    public void verifyExpandedViewOfGradeBook() {
//        deselectFrame();
//        switchToDockIFrame();
//        waitTOSync();
//        waitForElementPresent("expandGradeBook_btn");
//        element("expandGradeBook_btn").click();
//        Assert.assertTrue(element("collapsedGradeBook_btn").isDisplayed());
//        Assert.assertTrue(element("gradesCellsInGrid").isDisplayed());
//        deselectFrame();
//    }
//    public void closeGradeBookApp() {
//        deselectFrame();
//        waitForElementPresent("hideGradeBookApp");
//        element("hideGradeBookApp").click();
//        waitTOSync();
//        waitTOSync();
//    }
    public void clickOnShowDetails() {
        deselectFrame();
        switchToDockIFrame();
        waitForElementPresent("showDetailsLink");
        element("showDetailsLink").click();
        waitTOSync();
    }

    public void verifyGradeBookAppExpanded() {
        waitTOSync();
        Assert.assertTrue(isElementDisplayed("toggle_switch"), "App not Expanded");
    }

    public void clickOnHideDetails() {
        waitForElementPresent("hideDetailsLink");
        element("hideDetailsLink").click();
        waitTOSync();
    }

    public void verifyGradeBookAppCollapsed() {
        Assert.assertFalse(isElementDisplayed("toggle_switch"), "App not Expanded");
    }

    public void clickStudentName(String name) {
        switchToDefaultContent();
        switchToDockIFrame();
        waitTOSync();
        element("SelectStudent", name).click();
    }

    public void verifyManualGradedNoAttemptActivityButtonDisabledAndMessage() {
        waitTOSync();
        scrollDown(elementWithoutWait("manualgradeactivity_noattmpt"));
        element("manualgradeactivity_noattmpt").click();
        waitTOSync();
        Assert.assertTrue(isElementDisplayed("grade_activity_btn_disabled"), "Grade Activity button is not disabled");
        Assert.assertTrue(isElementDisplayed("submission_msg"), "0 submissions to grade message is not appearing");
        element("closeBtn").click();
    }

    public void verifySubmittedManualGradedActivityButtonDisabledAndMessage() {
        waitTOSync();
        scrollDown(elementWithoutWait("manualgradeactivity_attmpt"));
        element("manualgradeactivity_attmpt").click();
        waitTOSync();
        Assert.assertTrue(isElementDisplayed("grade_activity_btn_enabled"), "Grade Activity button is not enabled");
        Assert.assertTrue(isElementDisplayed("view_btn"), "View button is not appearing");
        element("closeBtn").click();
    }

    public void verifyGradedNoAttemptActivityButtonDisabledAndMessage() {
        waitTOSync();
        scrollDown(elementWithoutWait("gradedactivity_noattmpt"));
        element("gradedactivity_noattmpt").click();
        waitTOSync();
        Assert.assertTrue(isElementDisplayed("editscore_btn"), "Edit Score is not appearing");
        Assert.assertTrue(isElementDisplayed("submitted_best_msg"), "Best Score Submission Message is not appearing");
        element("closeBtn").click();
    }

    public void verifySubmittedGradedActivityButtonDisabledAndMessage() {
        waitTOSync();
        scrollDown(elementWithoutWait("gradedactivity_attmpt"));
        element("gradedactivity_attmpt").click();
        waitTOSync();
        Assert.assertTrue(isElementDisplayed("view_btn"), "View button is not appearing");
        Assert.assertTrue(isElementDisplayed("editscore_btn"), "Edit Score is not appearing");
        Assert.assertTrue(isElementDisplayed("submitted_best_msg"), "Best Score Submission Message is not appearing");
        element("closeBtn").click();
    }

    public void verifyEditScore() {
        String score_before = element("recorded_score").getText();
        int comment_before = elements("comments").size();
        element("editscore_btn").click();
        element("input_score").clear();
        Random r = new Random();
        int Low = 0;
        int High = 10;
        float result = Low + r.nextFloat() * (High - Low);
        String pattern = "##.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(result);
        System.out.println(format);
        element("input_score").sendKeys(String.valueOf(format));
        waitTOSync();
        element("save_btn").click();
        waitTOSync();
        String score_after = element("recorded_score").getText();
        int comment_after = elements("comments").size();
        Assert.assertFalse(score_before.contentEquals(score_after), "Scores not Updated");
//        Assert.assertEquals(comment_after, comment_before + 1);
        System.out.println(comment_before);
        System.out.println(comment_after);
        element("closeBtn").click();
    }

    public void verifyRemoveScore() {
        waitTOSync();
        int comment_before = elements("comments").size();
        element("removescore_btn").click();
        waitTOSync();
        element("confirm_btn").click();
        waitTOSync();
        String score_after = element("recorded_score").getText();
        int comment_after = elements("comments").size();
        Assert.assertTrue(score_after.contentEquals("--"), "Score not removed");
//        Assert.assertEquals(comment_after, comment_before + 1);
        System.out.println(comment_before);
        System.out.println(comment_after);
        element("closeBtn").click();
    }

    public void verifyStudentScore(String name) {
        waitTOSync();
        element("back_btn").click();
        waitTOSync();
        String score1 = element("student_score").getText().toString();
        waitTOSync();
        element("SelectStudent", name).click();
        WebElement score = driver.findElement(By.cssSelector("svg .class_average"));
//      String score2 = element("student_score").getText().toString();
        String score2 = score.getText().toString();
        System.out.println("score2:" + score2);
        Assert.assertTrue(score1.contentEquals(score2), "Score not maching for particular student");
    }

    public void verifyGradedAssignmentsInGrid() {
        waitTOSync();

    }

    public void verifyInstructorAbleToEditScoreManualNonAttemptActivity() {
        waitTOSync();
        scrollDown(elementWithoutWait("manualgradeactivity_noattmpt"));
        element("manualgradeactivity_noattmpt").click();
        waitTOSync();
        verifyEditScore();
    }

    public void verifyInstructorAbleToEditScoreManualAttemptedActivity() {
        waitTOSync();
        scrollDown(elementWithoutWait("manualgradeactivity_attmpt"));
        element("manualgradeactivity_attmpt").click();
        waitTOSync();
        verifyEditScore();
    }

    public void verifyInstructorAbleToEditScoreGradedAttemptedActivity() {
        waitTOSync();
        scrollDown(elementWithoutWait("gradedactivity_attmpt"));
        element("gradedactivity_attmpt").click();
        waitTOSync();
        verifyEditScore();
    }

    public void verifyInstructorAbleToEditScoreGradedNoAttemptedActivity() {
        waitTOSync();
        scrollDown(elementWithoutWait("gradedactivity_noattmpt"));
        element("gradedactivity_noattmpt").click();
        waitTOSync();
        verifyEditScore();
    }

    public void verifyInstructorAbleToRemoveScoreManualNonAttemptActivity() {
        waitTOSync();
        scrollDown(elementWithoutWait("manualgradeactivity_noattmpt"));
        element("manualgradeactivity_noattmpt").click();
        waitTOSync();
        verifyRemoveScore();
    }

    public void verifyInstructorAbleToRemoveScoreManualAttemptedActivity() {
        waitTOSync();
        scrollDown(elementWithoutWait("manualgradeactivity_attmpt"));
        element("manualgradeactivity_attmpt").click();
        waitTOSync();
        verifyRemoveScore();
    }

    public void verifyInstructorAbleToRemoveScoreGradedAttemptedActivity() {
        waitTOSync();
        scrollDown(elementWithoutWait("gradedactivity_attmpt"));
        element("gradedactivity_attmpt").click();
        waitTOSync();
        verifyRemoveScore();
    }

    public void verifyInstructorAbleToRemoveScoreGradedNoAttemptedActivity() {
        waitTOSync();
        scrollDown(elementWithoutWait("gradedactivity_noattmpt"));
        element("gradedactivity_noattmpt").click();
        waitTOSync();
        verifyRemoveScore();
    }
    
 
    public boolean verifyGradesAfterCategoryCollapse() {
        waitTOSync();
       List<WebElement> scores = elements("activitiesscore");
         List<Float> arrlist = new ArrayList<Float>();
          for (WebElement e : scores) {
            waitTOSync();
            System.out.println(e.getText());
            if (e.getText().contains(".")) {
                arrlist.add(Float.valueOf(e.getText()));
            }
        }
        float sum =0;
        for (Float e1 : arrlist)
        {
            sum=sum+e1;
        }
        String pattern = "##.#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(sum);
        System.out.println("Expected SUM of activities score: " +format);
           if(format.contains(categoryScoreAfterCollapse()))
           {
               return true;
           }
           else return false;        
    }
    
    public String categoryScoreAfterCollapse()
    {
        if((element_visibility("category_icon"))==false)
        {
            collapseCategoryGrid();
            String score = element("activitiesscore").getText();
        System.out.println("Actual SUM of acitivies score: "+score);
          collapseCategoryGrid();
        return score; 
            
        }
        else{
      //  collapseCategoryGrid();
        String score = element("activitiesscore").getText();
        System.out.println("Actual SUM of acitivies score: "+score);
         // collapseCategoryGrid();
        return score;  
        }
    }
    public void collapseCategoryGrid(){
        waitTOSync();
        waitTOSync();
        executeJavascript("document.getElementsByClassName('ag-header-expand-icon')[0].click();");
    }
    
    
}
