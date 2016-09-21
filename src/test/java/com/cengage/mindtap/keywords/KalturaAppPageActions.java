/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author QAI
 */
public class KalturaAppPageActions  extends BasePageActions {

public KalturaAppPageActions(WebDriver driver) {
        
    super(driver,"KalturaPage");
   }


    public boolean verifyIconSelectorClickable() {
     
        //executeJavascript("document.getElementById('init_video').click();");
        element("IconSelectorVideo").click();
        element("IconSelectorImage").click();
        element("IconSelectorAudio").click();
        element("IconSelectorvideoCapture").click();
        element("IconKalturaAppHelp").click();
        
        //Since all the elements are Clickable hance returning true
        return true;
    }

    public void clickOnKalturaApp() {
        try{
            element("more_link").click();
        }catch(Exception e){}
        element("myContent_icon").click();
        switchToDockIFrame();
        //driver.switchTo().frame(dockFrame) 
        try{
            waitForElementPresent("categoryHeader");
        }catch(Exception e){            
        
        }
        
        String categoryHeader = driver.findElement(By.id("title")).getText();
        if(categoryHeader.contains("Kaltura")){
            Reporter.log("Kaltura Icon is already displayed");
        }else{
            element("kalturaApp_icon").click() ;
        }
    }
    
       public void addDistinctKalturaActivity(String title){
        clickOnMyContentAndSelectKalturaFromMenu();
        verifyUploadOperation();
        verifySortingOperation();
        verifyVideoSortOperation();
        verifyAudioSortOperation();
        verifyVideoCaptureSortOperation();
        verifyImageSortOperation();
        Reporter.log("Kaltura image is displayed");
        clickOnCheckBoxToShared();
        Reporter.log("user clicked on checkbox");
        addKalturaImage();
        Reporter.log("User clicked on continue button");
    }
       
      public void editDistinctKalturaActivity(String title){
        editDistinctActivity(title);
        inputDistinctActivityTitleAndDescription(title,title);
    }
    
     void editDistinctActivity(String title){
        
        String bookClassName = driver.findElement (By.xpath ("//h3[contains(@class,'lpn_name') and contains(.,'" + title + "')]/parent::*/parent::*/parent::*")).getAttribute ("class");
        ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('"+bookClassName+"')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
        driver.findElement(By.xpath("//h3[contains(@class,'lpn_name') and contains(.,'" + title + "')]/parent::*/parent::*/parent::*//div[@class='nb_edit' and contains(@style,'block')]//a[@title='Edit']/img")).click();
    }   
     
     
    void inputDistinctActivityTitleAndDescription(String title,String description){
        
          DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
          Date date = new Date();
          System.out.println(dateFormat.format(date)); 
          
        
          String timestamp;
          timestamp = dateFormat.format(date);
        
          
        String input = title +" "+timestamp.toString();
        String desc = description +" "+timestamp.toString();
        try{
            
            element("title_inputField").click();
            element("title_inputField").clear();
            element("title_inputField").sendKeys(input);
            element("description_inputField").clear();
            element("description_inputField").sendKeys(desc);
        }catch(Exception e){
            //To avoid stale element exception
            driver.findElement(By.xpath("//input[contains(@class,'required validates')]")).click();
            driver.findElement(By.xpath("//input[contains(@class,'required validates')]")).clear();
            driver.findElement(By.xpath("//input[contains(@class,'required validates')]")).sendKeys(input);
        } 
        selectOrder();
        element("save_btn1").click();
        closeAnnouncement();
        
        //waitForElementDisplayed(driver.findElement(By.xpath("//div[contains(@class,'lpn_activity')]//h3[@class='lpn_name' and contains(.,'"+title+"')]")))
    } 
    
    private void clickOnMyContentAndSelectKalturaFromMenu() {
        
        element("myContentMenuTypeSelector").click();
        element("kalturaMenuTypeSelector").click();
        switchToToActivityIFrame();
        waitForElementPresent("kalturaMediaList");
        deselectFrame();
    }

    private void verifyUploadOperation() {
        deselectFrame();
        switchToToActivityIFrame();
        element("upload_btn").click();
        //verifyBrowseButtonDisplayed();
        deselectFrame();
    }

    private void verifySortingOperation() {
        
        switchToToActivityIFrame();
        verifySortByAlphaOption();
        element("mostRecent").click();
        element("mostRecent").isDisplayed();
        
    }
    
    boolean verifySortByAlphaOption(){
        
        element("alpha").click();
        return element("alpha").isDisplayed();
    }
    

    boolean  verifyVideoSortOperation() {
        
        element("videoSort_btn").click();
        return element("videoSort_btn").isDisplayed();
    }

    boolean  verifyAudioSortOperation() {
        element("audioSort_btn").click();
        return element("audioSort_btn").isDisplayed();
    }

    boolean  verifyVideoCaptureSortOperation() {
        
        element("videoCaptureSort_btn").click();
        return element("videoCaptureSort_btn").isDisplayed();
        
    }

    boolean  verifyImageSortOperation() {
        element("imageSort_btn").click();
        return element("imageSort_btn").isDisplayed();
    }

    private void clickOnCheckBoxToShared() {
        element("sharedMediaFile").click();
    }

    private void addKalturaImage() {
        deselectFrame();
        switchToToActivityIFrame();
        waitTOSync();
        //element("mediaFile_radioBtn").click();
        clickOnElementUsingActionBuilder(element("mediaFile_radioBtn"));
        element("continue_btn").click();
        element("textBefore_textBox").click();
        element("textBefore_textBox").clear();
        element("textBefore_textBox").sendKeys("Inline Kaltura Activity");
        element("textAfter_textBox").click();
        element("textAfter_textBox").clear();
        element("textAfter_textBox").sendKeys("Created by Automation Script");
        waitTOSync();
        scrollDown(element("save_btn"));
        //element("save_btn").click();  
        clickOnElementUsingActionBuilder(element("save_btn"));
        deselectFrame();
        
    }
    
      
        /**
     * View distinct kaltura activity.
     *
     * @param title the title
     * @return true, if successful
     */
    public boolean viewDistinctKalturaActivity(String title){
        waitTOSync();
        element("activityName", title).click();
        switchToMediaName();
        waitTOSync();
        waitTOSync();
        waitTOSync();
        if(driver.findElement(By.id("kplayerAct")).isDisplayed()){
        clickOnElementUsingActionBuilder(driver.findElement(By.id("kplayerAct")));
            deselectFrame();
            element("closeActivity").click();
            return true;
        }
        else 
        return false; 
    }
    

      /**
     * Verify browse button displayed.
     *
     * @return true, if successful
     */
    boolean verifyBrowseButtonDisplayed(){
        //waitForElementPresent("browse_btn");
        return element("browse_btn").isDisplayed();
    }
    
        /**
     * Delete distinct activity.
     *
     * @param title the title
     */
    public void deleteDistinctActivity(String title){
        
      //  List<WebElement> nb_list = driver.findElements(By.xpath("//div[@id='lpn_workspace' and contains(@style,'block')]//div[contains(@class,'lpn_node lpn_activity')]//h3[contains(@class,'lpn_name') and contains(.,'"+title+"')]")); 
          List<WebElement> nb_list = driver.findElements(By.xpath("//div[contains(@class,'lpn_node lpn_activity')]//h3[contains(@class,'lpn_name') and contains(.,'"+title+"')]")); 
        int len=nb_list.size();
        while(len>0){
            waitTOSync();
            String bookClassName = driver.findElement (By.xpath ("(//h3[contains(@class,'lpn_name') and contains(.,'"+title+"')]/parent::*/parent::*/parent::*)["+len+"]")).getAttribute ("class").toString();
            ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('"+bookClassName+"')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
        System.out.println("Script executed.....................................");
            
        clickOnElementUsingActionBuilder(driver.findElement(By.xpath("//h3[contains(@class,'lpn_name') and contains(.,'"+title+"')]/parent::*/parent::*/parent::*//div[@class='nb_edit' and contains(@style,'block')]//a[@title='Delete']/img")));
            //driver.findElement(By.xpath("//h3[contains(@class,'lpn_name') and contains(.,'"+title+"')]/parent::*/parent::*/parent::*//a[@title='Delete']")).click()
        System.out.println("Clicked .....................................");
            acceptAlertWindow();
        System.out.println("Alert come......................................");    
            
            len--;
            if(len == 0)
            break;
        }
    }

    public void clickKalturaAppVerifySharedFile() {
    
        element("KalturaApp").click();
        switchToDockIFrame();
        Assert.assertTrue(element("MediaPresent").isDisplayed(),"Media is not shared");
        
    }
    
    public void clickKalturaAppStudent() {
    
        element("KalturaApp").click();
        switchToDockIFrame();
    
        
    }
    
    
    public void clickKalturaAppVerifyUnSharedFile() {
    
        element("KalturaApp").click();
        switchToDockIFrame();
        Assert.assertTrue(element("NoSharedFile").isDisplayed(),"Files are shared");
        
    }
    
    
    public void ShareMediaFileWithStudent() {
        
        switchToAppIFrame();
        element("MediaFile_CheckBox").click();
        Reporter.log("Files are shared with students");
        waitForSpinnerToDisappear();
        switchToDefaultContent();
    }

    public void ClickOnShowOnlyContent() {
    
        switchToAppIFrame();
        element("MediaFile_CheckBox").click();
        Assert.assertTrue(element("Media_ChkBox_Disable").isDisplayed());
        Reporter.log("Files are not shared with students");
        element("ShowShared_chkBox").click();
        waitForSpinnerToDisappear();
        Assert.assertTrue(element("NoSharedFile").isDisplayed(),"Files are shared");
        Reporter.log("Show only content is checked and still no Files are shared with students");
        element("ShowShared_chkBox").click();
        element("MediaFile_CheckBox").click();
        Reporter.log("Files are shared with students");
        element("ShowShared_chkBox").click();
        Assert.assertTrue(element("FileShared").isDisplayed(),"Files are shared");
        Reporter.log("Show only content is checked and Files are showing");
        element("MediaFile_CheckBox").click();
        Reporter.log("Now Files are not shared with students ");
        element("ShowShared_chkBox").click();
        switchToDefaultContent();
        
    }

    public void VerifyFilterOption() {
    
        switchToAppIFrame();
        VerifyVedio();
        VerifyImage();
        VerifyAudio();
        VerifyVedio_Capture();
        VerifyImage();
        //switchToDefaultContent();
        
        
    }

    
    private void VerifyVedio() {
    
        element("Vedio_Button").click();
        //Assert.assertTrue(element("Media_CheckBox").isDisplayed());
        
    }

    private void VerifyImage() {
        
        element("Image_Button").click();
        Assert.assertTrue(element("Media_CheckBox").isDisplayed());
        
    }

    private void VerifyAudio() {
        
        element("Audio_Button").click();
        Assert.assertTrue(element("Media_CheckBox").isDisplayed());
    }

    private void VerifyVedio_Capture() {
        
        element("VedioCapture_Button").click();
        element("Capture_Button").click();
        Assert.assertTrue(element("Capture_error").isDisplayed());
        element("Capture_close").click();
                
    }

    public void clickOnEdit() {
        
        hover(element("Hover_edit"));
        element("edit_button").click();
        element("Media_name").clear();
        element("Media_name").sendKeys("MediaFileEdited.png");
        element("Media_no").click();
        element("Media_save").click();
        Assert.assertTrue(element("Media_ChkBox_Disable").isDisplayed());
        Assert.assertTrue(element("editNameVerify").isDisplayed());
    }

    public void VerifyDeleteFile() {
       
        clickOnElementUsingActionBuilder(element("Image_Button"));
        hover(element("Hover_edit1"));
        element("edit_button").click();
        element("Media_Remove").click();
        handleAlert();
        
    }

    public boolean VerifySortingAlpha() {
    
        //element("Image_Button").click();
        element("alpha_sort").click();
        waitTOSync();
        element("image_Button").click();
        char Image_Title = element("media_Title").getText().charAt(0);
        String image_text = element("media_Title").getText();
        //System.out.println("Image Title : "+Image_Title);
        int Image_Title_ascii = (int)Image_Title;
        //System.out.println("Image Title Ascii : "+Image_Title_ascii);
        
        element("closePreview").click();
        
        waitTOSync();
        element("audio_Button").click();
        char audio_Title = element("media_Title").getText().charAt(0);
        String audio_text = element("media_Title").getText();
        //System.out.println("audio Title : "+audio_Title);
        int audio_Title_ascii = (int)audio_Title;
        //System.out.println("audio Title Ascii : "+audio_Title_ascii);
        element("closePreview").click();
        
        if (audio_Title_ascii > Image_Title_ascii)
        {
        
            element("Media_first").click();
            
            String media_text = element("media_Title").getText();
            //System.out.println("media_text : " +media_text );
            //System.out.println("image_text : " +image_text );
            if(media_text.equalsIgnoreCase(image_text))
            {return true;}
            else
            {return false;}
            
        }
        return true;
        
    
    }

    public boolean VerifySortingMostRecent() {
       
        hover(element("Hover_audio"));
        waitTOSync();
        element("edit_button").click();
        element("Media_save").click();
        element("mostRecent_sort").click();
        element("Media_first").click();
        String media_text1 = element("media_Title").getText();
        element("closePreview").click();
        if(media_text1.equalsIgnoreCase("Sample_Audio1.wav"))
            {return true;}
            else
            {return false;}
        
        
        
    }
    
    /**
     * Edits the inline Kaltura activity.
     *
     * @param title the title
     */
    
    
    public void editInlineKalturaActivity(String title) {
    
        executeJavascript("document.getElementsByClassName('editInlineActivity edit_editHover')[0].click();");
        deselectFrame();
        switchToModalOptionsEditIFrame();
        saveInlineKalturaActivity(title);
        deselectFrame();
    }
    
    /**
     * Save inline Kaltura activity.
     *
     * @param title the title
     */
    public void saveInlineKalturaActivity(String title){
        element("textBefore_textBox").clear();
        element("textBefore_textBox").sendKeys(title);
        //element("saveDistinctActivity").click();
        clickOnElementUsingActionBuilder(element("saveDistinctActivity"));
    
    }

    public void deleteInlineKalturaActivity() {
    
        executeJavascript("document.getElementsByClassName('deleteInline deleteControl_remove')[0].click();");
        handleAlert();
        
    }

    }




