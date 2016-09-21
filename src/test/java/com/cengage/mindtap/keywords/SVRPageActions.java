/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author QAI
 */
public class SVRPageActions  extends BasePageActions{
    
    public SVRPageActions(WebDriver driver) {
        super(driver, "SVR");
    }

    public void addDistinctSVRActivity(String searchTag , String desc,String title ,String description) {
    
        switchToToActivityIFrame();
        searchWithSupportingMaterial();
        searchWithSpeechType(title);
        //searchWithDescription(desc);
        searchWithTitle(searchTag);
        previewSVRActivity(searchTag,"activity");
        saveActivity();
        inputDistinctActivityTitleAndDescription(title,description);
        verifyPresenceOfDistinctActivity(title);
        
    }
    
    public void clickOnSVRApp() {
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
    
    void previewSVRActivity(String title,String window){
        searchWithTitle(title); 
        previewSVRActivity(window);
    }
    
    public void verifyFiltersSVRAppDock(String searchTag , String title) {
        searchWithSupportingMaterial();
        searchWithSpeechType(title);
        searchWithTitle(searchTag);
        previewSVRActivity("appdock");               
    } 
    
    void previewSVRActivity(String window){
        String titleline =  element("title_VerifyText").getText();
        driver.findElement(By.xpath("//a[contains(.,'"+titleline+"')]")).click();
        switchToSVRFrame();
        waitTOSync();
        verifyNotecardsOutlineAndTranscript();
        deselectFrame();   
        if(window.equals("appdock"))
        switchToDockIFrame();
        else if(window.equals("activity"))
        switchToActivityIFrame();
        else if(window.equals("assignment"));
        //switchToMainIFrame(); 
        element("closePreview").click();   
    }
    
       void verifyNotecardsOutlineAndTranscript(){
         //waitForElementDisplayed(By.xpath("//h2[@class='title' and contains(.,'"+titleline+"')]"))    
        List<String> activityTabs = new ArrayList();
        activityTabs.add("Transcript");
        activityTabs.add("Notecards");
        activityTabs.add("Outline");
        for (String it : activityTabs) {
             driver.findElement(By.xpath("//li[@heading='"+it+"']")).click();
             waitTOSync();
         } 
    }
    
    void inputDistinctActivityTitleAndDescription(String title,String description){
        Date now = new Date();
        long timestamp = now.getTime();
        String input = title +" "+timestamp;
        String desc = description +" "+timestamp;
        try{
            
            waitForElementPresent("title_inputField");
            element("title_inputField").click();
            element("title_inputField").clear();
            element("title_inputField").sendKeys(title);
            element("description_inputField").clear();
            element("description_inputField").sendKeys(desc);
        }catch(Exception e){
            //To avoid stale element exception
            driver.findElement(By.xpath("//input[contains(@class,'required validates')]")).click();
            driver.findElement(By.xpath("//input[contains(@class,'required validates')]")).clear();
            driver.findElement(By.xpath("//input[contains(@class,'required validates')]")).sendKeys("title");
        } 
        selectOrder();
        
        element("save_btn").click();
        closeAnnouncement();
        
        //waitForElementDisplayed(driver.findElement(By.xpath("//div[contains(@class,'lpn_activity')]//h3[@class='lpn_name' and contains(.,'"+title+"')]")));
    }
    
    
    /**
     * Verify presence of distinct activity.
     *
     * @param title the title
     * @return true, if successful
     */
    boolean verifyPresenceOfDistinctActivity(String title){ /*TODO: Discuss moving this to AssignmentActivity.*/
        
        waitTOSync();
        List<WebElement> nb_list = driver.findElements(By.xpath("//div[@class='lpn_thumbTitle']/h3"));
        for(WebElement unit: nb_list){
            String unitName=unit.getText();
            if(unitName.contains(title)){
                return true;
                
            }
        }
        return false;
    }

    
    
    void saveActivity(){
        element("radio_Btn").click();
        element("continue_Btn").click();
        element("create_Btn").click();
        deselectFrame();
    }
    
    public void searchWithSupportingMaterial(){
        element("search_Box").click();
        element("search_Box").clear();
        List<String> supportingMaterial = new ArrayList();
        supportingMaterial.add("transcript");
        supportingMaterial.add("outline");
        supportingMaterial.add("notecards");
        for (String it : supportingMaterial) {
	    checkBoxClickOnSupportingMaterialCheckBox(it);
            verifySupportingMaterialResultsInSVRWindow(it);
            checkBoxClickOnSupportingMaterialCheckBox(it);
		}
    }
    
    

    
    void searchWithSpeechType(String title){
        element("search_Box").click();
        element("search_Box").clear();
        //List<String> speechType = ["Introduction","Informative","Persuasive","Invitational","Narrative","Group","Special Occasion"]
        
        
        List<String> speechType = new ArrayList();
        speechType.add("Introduction");
        speechType.add("Informative");
        speechType.add("Persuasive");
        speechType.add("Invitational");
        speechType.add("Narrative");
        speechType.add("Group");
        speechType.add("Special Occasion");
        for (String it : speechType) {
            checkBoxClickOnSupportingMaterialCheckBox(it);
            verifySpeechResultsInSVRWindow(it);
            checkBoxClickOnSupportingMaterialCheckBox(it);
        }
           
    }
    
        void verifySpeechResultsInSVRWindow(String token){
        List<WebElement> resultBlocks = driver.findElements(By.xpath("//li[contains(@ng-repeat,'activity.speech_type')]"));
        for(WebElement literal : resultBlocks){
            String speech = literal.getText();
            assert speech.contains(token);
        }
    }
    
    
    void searchWithTitle(String title){
        element("search_Box").click();
        element("search_Box").clear();
        element("search_Box").sendKeys(title);
        String titleline =  element("title_VerifyText").getText();
        System.out.println("titleline"+titleline);
    }
    
    boolean searchWithDescription(String description){
        element("search_Box").click();
        element("search_Box").clear();
        element("search_Box").sendKeys("description");
        String paragraph_text = element("paragraph_VerifyText").getText();        
        if (paragraph_text.contains(description)){
            return true;
        }else
        {return false;}
        
    }
    
    public void checkBoxClickOnSupportingMaterialCheckBox(String materialType){
        driver.findElement(By.xpath("//input[contains(@id,'"+materialType+"')]")).click();  
    }
        
        public void verifySupportingMaterialResultsInSVRWindow(String tag){
        List<WebElement> outputBlocks = driver.findElements(By.xpath("//div[contains(.,'Supporting Materials:')]/ul[@class='activityAssetsList']"));
        for(WebElement textbox : outputBlocks ){
            String testline = textbox.getText().toLowerCase();
            assert testline.contains(tag);
        }
    }

    public void editDistinctActivity(String title) {
    
     String bookClassName = driver.findElement(By.xpath ("//h3[contains(@class,'lpn_name') and contains(.,'" + title + "')]/parent::*/parent::*/parent::*")).getAttribute ("class").toString ();
     System.out.println("classs name "+bookClassName);
//executeJavascript(document.getElementsByClassName('${bookClassName}')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';);
     executeJavascript("document.getElementsByClassName('" +bookClassName+ " ')[0].getElementsByClassName('nb_edit')[0].style.display = 'block'");
     driver.findElement(By.xpath("//h3[contains(@class,'lpn_name') and contains(.,'" + title + "')]/parent::*/parent::*/parent::*//a[@title='Edit']")).click ();
      
    }

    public void editActivityDetails(String title, String description) {
    
        element("inputTitle").click();
        element("inputTitle").clear();
        element("inputTitle").sendKeys(title);
        element("inputDesc").click();
        element("inputDesc").clear();
        element("inputDesc").sendKeys(description);
        //clickOnEditOptions();
        //element("save_Btn").click();
        element("save_btn").click();
       
    }
    
    void clickOnEditOptions(){
        element("edit_Btn").click();
        switchToModalOptionsEditIFrame();
        waitForElementPresent("transcript_Visible");
        waitForElementPresent("notecards_Visible");
        waitForElementPresent("outline_Visible");
        element("continueFromEdit").click();
        deselectFrame();
       
    }

    /**
     * Launch distinct activity.
     *
     * @param title the title
     */
    public void launchDistinctActivity(String title){

        WebElement activity;
        //waitForElementToAppear(By.xpath("//a[contains(.,'" + title + "')]"),15);
        waitTOSync();
        activity = driver.findElement (By.xpath ("//a[contains(.,'" + title + "')]"));
        activity.click();
        
    }
    
    public void studentSubmitsAnswersToActivity(String answer) {
        
        
         switchToMediaName();   //switchToMainIFrame();
         switchToActiveServiceCXPFrame();
         waitForElementPresent("By.xpath(//li[@heading='Questions'])");
         WebElement answerBox;
         for(int i=0;i<3;i++){
         answerBox=driver.findElement(By.xpath("//div[@id='section1_assessment1_question_"+i+"']//nobr/textarea"));
         answerBox.click();
         answerBox.clear();
         answerBox.sendKeys(answer);
         waitTOSync();// for answers to be uploaded on SVR server
        }
       element("submitBtn").click();
       for(int i=1 ; i<5;i++){waitTOSync();}        
        //waitForElementDisplayed(By.xpath("(//div[@class='ci-feedback-title'])[1]"))
        deselectFrame();
    }

    public void editScoreAndAddCommentToActivity(String title,String StudentName) {
        addCommentToActivity(title,StudentName);
        viewActivity();
        editScoreOfActivity();
        
    }
    
    void addCommentToActivity(String title,String StudentName){
        deselectFrame();
        WebElement subBar = driver.findElement(By.xpath("//div[contains(@class,'lpn_node') and contains(.,'"+title+"')]//div[@class='submittedData']/a/div"));
        waitForElementPresent("subBar");
        clickOnElementUsingActionBuilder(subBar);
        switchToDockIFrame();
        //waitTOSync();
        //driver.findElement(By.xpath("//span[@class='ag-cell-value' and contains(.,'user2')]")).click();
        selectStudent(StudentName);
        waitForSpinnerToDisappear();
        element("addAcomment").click();
        element("commentArea").click();
        element("commentArea").sendKeys("Comment Added By Automated Script");
        element("postCommentButton").click();
    }
    
    void editScoreOfActivity(){
        deselectFrame();
        switchToDockIFrame();
        waitForSpinnerToDisappear();
        element("editPoints").click();
        int randomScore = (int)(Math.random()*3);
        executeJavascript("document.getElementsByTagName('input')[1].value="+randomScore+";");

        //waitTOSync();
        element("save_Btn").click();
        //waitTOSync();
        deselectFrame();
    
    }
    
    void viewActivity(){ 
        waitForElementPresent("viewBtn");
        clickOnElementUsingActionBuilder(element("viewBtn"));
        deselectFrame();
        waitForSpinnerToDisappear();
        waitTOSync();
        executeJavascript("document.getElementsByClassName('closeActivity')[0].click();");
        switchToDockIFrame();
    }

    private void selectStudent(String StudentName) {
      element("StudentName",StudentName).click();      
    }

    public void verifyScoreForDistinctActivityInLPN(String activity) {
           verifyScoreForDistinctActivity(activity);
           clickOnGradeBookApp("student");
           reviewActivity(activity);
    
    }
    
    
    void verifyScoreForDistinctActivity(String activity){
        //waitForElementPresent(element(By.id("lpn_list_area")));
        String scoreObtained = driver.findElement(By.xpath("//div[contains(@class,'lpn_node') and contains(.,'"+activity+"')]//div[contains(@class,'lpn_score')]")).getText();
        System.out.println("score obtained by student:"+ scoreObtained);
        
    }
    
    /**
     * Click on grade book app.
     */
    void clickOnGradeBookApp(String role){
        try{
            resetImplicitTimeout(10);
            driver.findElement(By.xpath("//a[@class='nb_expandDock']")).click();
        }catch(Exception e){
            System.out.println("Dock is already expanded");
        }
        waitForElementPresent("gradeBookAppIcon");
        element("gradeBookAppIcon").click();
        //waitTOSync();

    }
    
    void reviewActivity(String title){
        switchToDockIFrame();
        //WebElement activity = driver.findElement(By.xpath("//span[contains(@class,'ag-cell-value') and contains(.,'"+title+"')]"));
        element("reviewActivity",title).click();
        //waitForElementDisplayed(activity);
        //element(activity).click();
    }
    
    
    
    
    
}
