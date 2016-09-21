/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 *
 * @author QAI
 */
public class youSeeUPageActions  extends BasePageActions{
    
    public youSeeUPageActions(WebDriver driver) {
        super(driver, "youSeeUPage");
    }

    public void addDistinctRubricsInYSU(String name) {
      selectRubricTab();
      createRubricInYSU();
      enterRubricsDistinctName(name);
      insertDataInMatrix();
      saveRubrics();
    }

    public void editRubricsInYSU(String name) {
        clickOnEditRubricsButton(name);
        enterRubricsDistinctName(name);
        saveRubrics();
    }

    public void deleteDistinctRubricsActivity(String name) {
        deleteRubrics(name);
    }

    private void selectRubricTab() {
        element("rubricsTab").click();
    }

    private void createRubricInYSU() {
        element("createRubricBtn").click();
    }

    private void enterRubricsDistinctName(String name) {
        element("rubricInputText").click();
        element("rubricInputText").clear();
        element("rubricInputText").sendKeys(name);
    }

    private void insertDataInMatrix() {
       int j=1,k=1;
        WebElement textBoxLocator,textBoxPoints;
        for(int i=0;i<3;i++){
            while(j<5){
                textBoxLocator =  driver.findElement(By.xpath("//textarea[@id='casestudy_designerbundle_rubric_type_rows_"+i+"_cells_"+j+"_description']"));
                textBoxLocator.click();
                textBoxLocator.clear();
                textBoxLocator.sendKeys("automation :"+i+j);
             
                j+=1;
            }
            while(k<5){
                textBoxPoints = driver.findElement(By.xpath("//input[@id='casestudy_designerbundle_rubric_type_rows_"+i+"_cells_"+k+"_points']"))   ; 
                textBoxPoints.click();
                textBoxPoints.clear();
                textBoxPoints.sendKeys("10");
                k+=1;
            }
            
            j=0;k=1;
        }
    }

    private void clickOnEditRubricsButton(String name) {
        element("editRubrics", name).click();
        waitForElementPresent("rubricInputText");
    }

    private void saveRubrics() {
         element("save_Btn").click();
        waitForElementPresent("flashNotice");
        element("backBtn").click();
    }

    private void deleteRubrics(String name) {
        waitTOSync();
        element("deleteRubric",name).click();
        acceptAlertWindow();
        waitForElementPresent("flashNotice");
    }

    public void addYouSeeUAppActivityInApp(String activity, String name, String activityType, String instruction, String gradingType) {
        clickOnAddAssignmentButton();
        inputYSUActivityName(name);
        selectYSUActivityType(activityType);
        clickOnSaveAndContinueButton();
        inputInstructions(instruction);
        clickOnSaveAndContinueButton();
        clickOnExecutorType();
        selectGroupType();
        selectCommentingType();
        clickOnSaveExecutorsAndReviewersButton();
        selectFeedbackType();
        inputActivityScore();
        selectgradingType(gradingType);
        clickOnSaveGradeAndFeedbackButton();

    }

    

    public void launchDistinctYouSeeUActivity(String data) {
        
        clickOnElementUsingActionBuilder(driver.findElement (By.xpath ("(//h3[contains(.,'" + data + "')])[1]")));
        
    }

    public void addDistinctYouSeeUActivityInDashboard(String activity, String name, String type, String instruction, String gradingType) {
        selectAssignmentForLPN(name);
        selectOrder();
        clickOnSaveActivityButton();
        closeAnnouncement();
    }

    private void selectAssignmentForLPN(String name) {
        deselectFrame();
        waitForSpinnerToDisappear();
        switchToToActivityIFrame();
        WebElement activity= driver.findElement(By.xpath("//a[contains(.,'"+name+"')]/parent::*/parent::*//span[contains(@class,'jq-radio')]"));
        activity.click();
        clickOnElementUsingActionBuilder(driver.findElement(By.xpath("//input[@value='Continue']")));
        deselectFrame();
    }

    void selectOrder(String position) {
         element("ddl_orderButton").click();
        driver.findElement(By.xpath("//ul[@id='order-menu']/li[${position}]")).click();
        
        
    }

    private void clickOnSaveActivityButton() {
        
        clickOnElementUsingActionBuilder(element("saveActivity_btn"));
        
    }

    void closeAnnouncement() {
        
        deselectFrame();
        try {
            resetImplicitTimeout(3);
            driver.findElement(By.xpath("//div[contains(@class,'announcement')]/div/a[contains(@class,'nb_closeIcon')]")).click();
            resetImplicitTimeout(120);
        }catch(Exception e){
            resetImplicitTimeout(120);
        }
        
    }

    private void clickOnAddAssignmentButton() {
        
        switchToDockIFrame();
        element("addAssignmentBtn").click();
    }

    private void inputYSUActivityName(String name) {
        element("youSeeApp_ActivityName").sendKeys(name);
    }

    private void clickOnSaveAndContinueButton() {
        
        element("saveAndContinue_btn").click();
   
    }

    private void clickOnExecutorType() {
      
        element("wholeclass_btn").click();
        
    }

    private void selectGroupType() {
   
        clickOnElementUsingActionBuilder(element("groupType_radioBtn"));
    
    }

    private void selectCommentingType() {
        clickOnElementUsingActionBuilder(element("commentingType_radioBtn"));
    }

    private void clickOnSaveExecutorsAndReviewersButton() {
         element("saveExecutorAndReview_btn").click();
    }
    
    private void selectFeedbackType() {
    clickOnElementUsingActionBuilder(element("feedbackType_checkbox"));
    }

    private void inputActivityScore() {
    element("activityScore_textBox").sendKeys("10");
    }

    private void selectgradingType(String gradingType) {
        driver.findElement(By.xpath("//label[contains(.,'"+gradingType+"')]/parent::*/parent::*/span[contains(@class,'jq-checkbox')]")).click();
    }

    private void clickOnSaveGradeAndFeedbackButton() {
           
        element("savegradeandfeedback_btn").click();
        waitForElementPresent("pagetitle");
        deselectFrame();
        
    }

    private void selectYSUActivityType(String activityType) {
    
        clickOnElementUsingActionBuilder(element("activityType_radioBtn"));
        
    }

    private void inputInstructions(String instruction) {
        element("instruction_txtArea").sendKeys("instructions");
        
    }

    public boolean verifyPresenceOfDistinctYouSeeUActivityOnLPN(String data) {
    
        resetImplicitTimeout(10);
        List<WebElement> nb_list = driver.findElements(By.xpath("//div[@class='lpn_thumbTitle']/h3"));
        for(WebElement unit: nb_list){
            String unitName=unit.getText();
            if(unitName.contains(data)){
                return true;
            }
        }
        return false;
        
    } 
}

