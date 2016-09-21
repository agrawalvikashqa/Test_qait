/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;

/**
 *
 * @author QAI
 */
public class InsiteAppPageActions  extends BasePageActions {

    public String windowHandle;
    
public InsiteAppPageActions(WebDriver driver) {
        
    super(driver,"Insite");
   }




    public void clickOnInsiteApp() {
        element("InsiteLink").click();
    }       
    
    public void enterAssignmentName(String AssignmentName){
        element("AssignmentName_TextBox").clear();
        element("AssignmentName_TextBox").sendKeys(AssignmentName);
    }
    
    public void validateError(){
        Assert.assertTrue(element("error_Validate").isDisplayed(), "Error message does not appear");
    }
    
    public void enterAssignmentDesc(String AssignmentDesc){
        element("AssignmentDescription_TextBox").sendKeys(AssignmentDesc);
    }
    
    public void selectGradingType(String value){
        element("GradedTypeRadioButton", value);
    }
    
    public void enterPossibleScore(String score){
        element("PossibleScore_TextBox").clear();
        element("PossibleScore_TextBox").sendKeys(score);
    }
    public void invalidPossibleScore(){
        Assert.assertTrue(element("score_validate").isDisplayed(), "Error message does not appear");
    }
    
    public void clickOnSubmitButton(){
        element("SubmitButton").click();
    }
    
    public void clickOnActivitySaveButton(){
        wait.hardWait(5);
    executeJavascript("document.getElementById('init_save').click()");
    
    }
    
    public void clickOnUploadIcon(){
        waitForSpinnerToDisappear();
        element("upload_Button").click();
    }
    
    public void clickOnGoogleDrive(){
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='upload-modal']//iframe")));
        waitForSpinnerToDisappear();
        element("additionalOption").click();
        element("googleDrive").click();
        //deselectFrame();
    }
    
    
     public void clickOnSettingsTab(){
         waitForElementPresent("settingsTabs");
         element("settingsTab").click();
     }
     
     public void clickOnOptionalSettingsLink(){
         waitTOSync();
         waitTOSync();
         element("optionalSettings_link").click();
     }
     
     public void clickOnLateSubmissionNoRadioButton(){
         Assert.assertTrue(element("lateSubmission_NoRadioButton").isSelected(), "By Default No radio button is not selected");
         element("lateSubmission_NoRadioButton").click();
         
     }
     
     public void clickOnLateSubmissionYesRadioButton(){
         element("lateSubmission_YesRadioButton").click();
         
     }
     
     public void clickOnComapreSubmitAssignmentCheckbox(){
         element("checkbox_compareSubmitAssignment").isSelected();
         element("uncheckCheckbox_studentpaperRepository").click();
     }
     
     public void viewOriginalityReport_Checkbox(String value){
         element("viewOriginalityReport_Checkbox", value).isSelected();
         element("viewOriginalityReport_Checkbox", value).click();
         
     }
     
      public void peermark_Checkbox(String value){
         element("peermark_Checkbox", value).isSelected();
         element("peermark_Checkbox", value).click();
     }
      
      public void rubricAssignment(){
          element("defaultNoRubric").isSelected();
          Assert.assertTrue(element("launchRubric_Link").isDisplayed(), "Launh Rubric manager link is not appearing");
      }
      
       public void addRubricAssignment(){
          element("launchRubric_Link").click();
          windowHandle=driver.getWindowHandle();
          ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            System.out.println(tabs2.size());
            waitTOSync();
            driver.switchTo().window(tabs2.get(1));
            waitTOSync();
            waitTOSync();
            
            driver.switchTo().window(tabs2.get(0));
            
          
          
      }
     
      
     
    public void clickOnCopyPasteButton(){
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='upload-modal']//iframe")));
        element("copyPaste_Button").click();
    }
    
    public void enterSubmissionTitle(){
        element("submissionTitle").sendKeys("test");
    }
    
    public void enterSubmissionText(){
        element("submissionTextArea").clear();
        element("submissionTextArea").sendKeys("submitting text for essay activity via automation script. Skipping upload, entering manually. Enhance inside submission. \n" +
"submitting text for essay activity via automation script. Skipping upload, entering manually. Enhance inside submission. \n" +
"Thanks");
        
    }
    
    public void clickSubmissionContinueButton(){
        element("submissionFrame_Button").click();
    }
    
    public void clickOnAcceptSubmissionButton(){
        waitForElementPresent("acceptSubmission_btn");
        element("acceptSubmission_btn").click();
    }
    
    public void instructorClickOnGradeIcon(){
        element("instructor_GradeIcon").click();
    }

    public void uploadFile(){
        waitTOSync();
        waitTOSync();
        waitTOSync();
        waitTOSync();
        
       driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='upload-modal']//iframe")));
         element("submissionTitle").sendKeys("test");
         wait.hardWait(5);
         element("filepath").click();
         
         //element("filepath").sendKeys("C:\\Users\\chandanjyot\\Desktop\\Task_22July.txt");
         
               //  sendKeys("C:\\Users\\chandanjyot\\Desktop\\Task_22July.txt");
//        windowHandle=driver.getWindowHandle();
//        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//        //driver.switchTo().alert();
//        //alert.sendKeys("test 123");
//        System.out.println(tabs2.size());
//        driver.switchTo().window(tabs2.get(1));
//        //ReportMsg.info("tab switched");
//        //changeWindow(1);
//        waitTOSync();
//        String Url = driver.getTitle();
//        System.out.println(Url);
        // switchToFrame("fallbackframe");
//        switchToFrame("fallbackframe");
//        element("submissionTitle").sendKeys("test");
//        element("filePath").sendKeys("C:\\Users\\Mann\\Desktop\\Order Confirmation _ Amway Site.pdf");
        }
    
    public void instructorEnterGrades(String Grades){
        //windowHandle=driver.getWindowHandle();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        System.out.println(tabs2.size());
        waitTOSync();
        driver.switchTo().window(tabs2.get(1));
        waitTOSync();
        waitTOSync();
        
        
 String Parent_Window = driver.getWindowHandle();    
      // Switching from parent window to child window   
     for (String Child_Window : driver.getWindowHandles())  
     {  
         System.out.println(Child_Window.toString());
                 
     driver.switchTo().window(Child_Window);  
     driver.manage().window().maximize();
     }
     switchToDefaultContent();
    
      //   driver.switchTo().window("Turnitin Document Viewer");  
        //switchToActivityIFrame();
//        executeJavascript("document.getElementsByClassName('field')[1].setAttribute('value','45')");
System.out.println(driver.getTitle());
        isElementDisplayed("gradeField");
        element("gradeField").click();
        element("gradeField").sendKeys("45");
        
        executeJavascript("document.getElementsByClassName('field')[1].setAttribute('value','40');");
       // driver.findElement(By.xpath("//label[text()='Comment']")).clear();
        //waitForElementPresent("gradeField");
       // element("gradeField").clear();
       // element("gradeField").sendKeys(Grades);
        
    }

    
    
    public void createDistinctPaperAssignment(){
        long time = System.currentTimeMillis();
       
        Assert.assertTrue(element("CreateAssignmentButton").isDisplayed(), "Create New Assignment Button is not present");
        element("CreateAssignmentButton").click();
        element("AssignmentTitle_textbox").clear();
        element("AssignmentTitle_textbox").sendKeys("Paper Assignment"+time);
        element("GradedRadio_Button").click();
        element("More_Options").click();
        Select dropdown = new Select (driver.findElement(By.id("report_gen_speed")));
        dropdown.selectByIndex(1);
        element("Submit_Button").click();
        //waitForElementPresent("save_btn");
                  
    }
    
    public void createDistinctPeerAssignment(){
        //long time = System.currentTimeMillis();
       
        Assert.assertTrue(element("CreateAssignmentButton").isDisplayed(), "Create New Assignment Button is not present");
        element("CreateAssignmentButton").click();
        waitTOSync();
        Select dropdown = new Select (driver.findElement(By.xpath("//select[@id='paperAssignments']")));
        dropdown.selectByIndex(0);
        element("Continue_PeerButton").click();
        waitTOSync();
        waitTOSync();
        waitForElementPresent("peer_AssignTab");
       // Assert.assertTrue(element("peer_AssignTab").isDisplayed(), "Tabs are not appearing in peermark page");
        waitTOSync();
        element("Done_PeerButton").click();
        //waitForElementPresent("save_btn");
                  
    }
    
    public void PaperAssignmentRadioButton(){
         element("Paper_AssignmentRadio_Button").click();
    }
    
    public void PeermarkAssignmentRadioButton(){
         element("Peermark_AssignmentRadio_Button").click();
    }
    
    public void clickOnSaveButton(){
        waitForElementPresent("sav_btn");
        executeJavascript("document.getElementById('init_save').click();");
        waitTOSync();
        waitTOSync();
        waitTOSync();
        
    }
    
     public void PaperAssignmentLaunchVerify(){
        Assert.assertTrue(element("Student_Paper_SubmitButton").isDisplayed(), "Activity loads blank");
    }
    
    public void PeermarkDisagreeAgreement(){
        waitForElementPresent("peermark_DisagreeButton");
        
        element("peermark_DisagreeButton").click();
        isElementDisplayed(element("unitViewTab"));
    }
    
    public void PeermarkAgreeAgreementandVerifyLaunch(){
            element("peermark_AgreeButton").click();
    }
    
    public void closeLaunchedActivity(){
        element("Activity_Close_Button").click();
    }

    public void EditPaperAssignmentFromLPN(String AssignmentName,String AssignmentDescription,String PossibleScore) {
        switchToModalOptionsEditIFrame();
        element("insite_title").clear();
        element("insite_title").sendKeys(AssignmentName);
        element("insite_descrpition").clear();
        element("insite_descrpition").sendKeys(AssignmentDescription);
        element("practice_Radio").click();
        element("PossibleScore_TextBox").clear();
        element("PossibleScore_TextBox").sendKeys(PossibleScore);
        clickOnElementUsingActionBuilder(element("SubmitButton"));
        wait.hardWait(15);
        
    }
          
    
    
    
    
    
    
    
    
}




