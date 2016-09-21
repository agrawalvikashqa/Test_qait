/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

/**
 *
 * @author QAI
 */
public class SpeechOutlineToolPageActions  extends BasePageActions {

    public String windowHandle;
    
public SpeechOutlineToolPageActions(WebDriver driver) {
        
    super(driver,"SpeechOutlineTool");
   }


@FindBy(xpath="//table[@id='gdoc_list_table']//input[@type='radio']")
    List<WebElement> gdoc_list;

/** The nb_list. */
    @FindBy(xpath="//li[contains(@class, 'item switchPath node lpn_node_')]")
    List<WebElement> nb_list; 


    public void clickOnSpeechOutlineApp() {
        try{
            element("more_link").click();
        }catch(Exception e){}
        element("outlineBuilder_icon").click();
        switchToDockIFrame();
        try{
            waitForElementPresent("categoryHeader");
        }catch(Exception e){            
        
        }
    }
     
    public void assignmentPageValidation() {
        element("createasgnmnt_btn").click();
        element("save_btn").click();
        int errors = elements("error_message").size();
        Assert.assertEquals(errors, 3, "Error message is not appearing for 3 input fields");
        waitTOSync();
        scrollDown(element("cancel_btn"));
        element("cancel_btn").click();
        element("ok_btn").click();
        waitTOSync();
    }
    
    public void addmultiplechoiceques(String question, String answer) {
        element("viewmod_ques").click();
        element("addques_link").click();
        Assert.assertTrue(element("addques_link").isDisplayed(), "Add Question drop down is not displaying");
        element("mulchoice_link").click();
        element("ques_text").clear();
        element("ques_text").sendKeys(question);
        element("answer_text").clear();
        element("answer_text").sendKeys(answer);
        element("answer_save_btn").click();
    }
    
    public void selectCitation() {
        Select se=new Select(element("citation_field"));
		se.selectByIndex(1);
    }
    
    public void createGradedAssignment(String name, String decsription, String question, String answer) {
        element("createasgnmnt_btn").click();
        element("asgnmnt_name").clear();
        element("asgnmnt_name").sendKeys(name);
        element("asgnmnt_desc").clear();
        element("asgnmnt_desc").sendKeys(decsription);
        addmultiplechoiceques(question, answer);
        selectCitation();
        scrollDown(element("save_btn"));
        waitTOSync();
        element("save_btn").click();
        waitTOSync();
    }
    
    public void createPracticeAssignment(String name, String decsription, String question, String answer) {
        waitForElementPresent("createasgnmnt_btn");
        waitTOSync();
        element("createasgnmnt_btn").click();
        element("asgnmnt_name").clear();
        element("asgnmnt_name").sendKeys(name);
        element("asgnmnt_desc").clear();
        element("asgnmnt_desc").sendKeys(decsription);
        element("practice_checkbox").click();
        addmultiplechoiceques(question, answer);
        selectCitation();
        scrollDown(element("save_btn"));
        waitTOSync();
        element("save_btn").click();
        waitTOSync();
    }
    
    public void previewGradedAssignment(String desc, String question) {
        element("graded_activity", desc).isDisplayed();
        element("graded_activity",desc).click();
        Assert.assertTrue(element("preview_ques").isDisplayed(), "Preview not loaded for Graded Assignment");
        String ques = element("preview_ques").getText();
        Assert.assertTrue(ques.contentEquals(question), "Question text not matched");
        element("close_btn").click();
        waitTOSync();
    }
    
    public void editGradedAssignment(String desc, String name, String question, String answer) {
        element("graded_activity_edit_icon", desc).isDisplayed();
        element("graded_activity_edit_icon", desc).click();
        element("asgnmnt_name").clear();
        element("asgnmnt_name").sendKeys(name);
        element("points_input").clear();
        element("points_input").sendKeys("50");
        addmultiplechoiceques(question, answer);
        scrollDown(element("save_btn"));
        waitTOSync();
        element("save_btn").click();
        waitTOSync();
    }
    
    public void previewPracticeAssignment(String desc, String question) {
        element("graded_activity",desc).isDisplayed();
        element("graded_activity",desc).click();
        Assert.assertTrue(element("preview_ques").isDisplayed(), "Preview not loaded for Practice Assignment");
        String ques = element("preview_ques").getText();
        Assert.assertTrue(ques.contentEquals(question), "Question text not matched");
        element("close_btn").click();
        waitTOSync();
    }
    
    public void addDistinctGradedActivity(String desc) {
        element("radio_btn",desc).isDisplayed();
        element("radio_btn",desc).click();
        element("continue_btn").click();
        switchToDefaultContent();
        setAvailableDueDate();
        waitTOSync();
        selectOrder("1");
        executeJavascript("document.getElementById('init_save').click();");
    }
    
    public void editDistinctGradedActivity(String decsription) {
        waitForElementPresent("asgnmnt_desc");
        element("asgnmnt_desc").clear();
        element("asgnmnt_desc").sendKeys(decsription);
        scrollDown(element("save_btn"));
        waitTOSync();
        element("save_btn").click();
        waitTOSync();
        switchToDefaultContent();
        executeJavascript("document.getElementById('init_save').click();");
    }
    
    public void setAvailableDueDate() {
        element("available_input").click();
        element("done_btn").click();
        waitTOSync();
        element("due_input").click();
        element("next_btn").click();
        element("due_date").click();
        element("done_btn").click();
    }
    
    public void selectOrder(String position) {
        element("selectMenu_Order").click();
        ReportMsg.info("User clicked on select menu to select the position of the activity");
        element("selectPosition", position).click();
        ReportMsg.info("User set the position " + position);
    }
    
    
    
}
        
   
    
     
    
    
    
    




