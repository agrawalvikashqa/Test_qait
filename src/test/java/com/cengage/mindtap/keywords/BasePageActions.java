/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.ColorEncodingValidation;
import java.util.Date;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

/**
 *
 * @author QAI
 */
public class BasePageActions extends GetPage {

    protected WebDriver driver;
    public ColorEncodingValidation color;
    String pageName;
    
    /** The dock frame. */
    @FindBy(xpath = "//iframe[contains(@id, '_NB_Dock_IFrame') and not(contains(@style,'none'))]")
    WebElement dockFrame;
    
    /** The dock frame 1 . */
    @FindBy(xpath = "//iframe[contains(@id, '_NB_Dock_IFrame')]")
    WebElement dockFrame1;
    
   /** The modal frame. */
    @FindBy(xpath = "//iframe[contains(@id, 'modelOptionsEditFrame') and not(contains(@style,'none'))]")
    WebElement modalFrame; 
    
    /** The activity frame. */
    @FindBy(xpath = "//iframe[contains(@id, 'distinct_activity_create_frame')]")
    WebElement activityFrame;
    

    /** The frameName. */
    @FindBy(xpath = "//iframe[contains(@id,'_NB_Main_IFrame')]")
    WebElement frameName;
        
    /** The app frame. */
    @FindBy(xpath = "//iframe[contains(@id, 'appiframeid') and not(contains(@style,'none'))]")
    WebElement appFrame;

    @FindBy(xpath = "//iframe[contains(@id, '_NB_Main_IFrame')]")
    WebElement MainIFrame;
    

    
    
    /** The ddl_order button. */
    @FindBy(xpath="//a[@id='order-button']/span[@class='ui-selectmenu-status']")
    WebElement ddl_orderButton;
            
    public void analyzeBrowserLog() {
        System.out.println("*********** BROWSER LOG ************");
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
           //do something useful with the data
        }
        System.out.println("*********** BROWSER LOG ************");
    }
        public void analyzeCLIENTLog() {
          System.out.println("*********** CLIENT LOG ************");
        LogEntries logEntries = driver.manage().logs().get(LogType.CLIENT);
        for (LogEntry entry : logEntries) {
          System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
           //do something useful with the data
        }
         System.out.println("*********** CLIENT LOG************");
        
    }
        public void analyzeDRIVERLog() {
            System.out.println("*********** DRIVER LOG ************");
        LogEntries logEntries = driver.manage().logs().get(LogType.DRIVER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
           //do something useful with the data
        }
         System.out.println("*********** DRIVER LOG ************");
    }
        
        public void analyzePERFORMANCELog() {
         System.out.println("*********** PERFORMANCE LOG ************");
        LogEntries logEntries = driver.manage().logs().get(LogType.PERFORMANCE);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
           //do something useful with the data
        }
         System.out.println("*********** PERFORMANCE LOG ************");
    }
        public void analyzePROFILERLog() {
         System.out.println("*********** PROFILE LOG ************");
        LogEntries logEntries = driver.manage().logs().get(LogType.PROFILER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
           //do something useful with the data
        }
         System.out.println("*********** PROFILE LOG ************");
    }
        
        public void analyzeSERVERLog() {
            System.out.println("*********** SERVER LOG ************");
        LogEntries logEntries = driver.manage().logs().get(LogType.SERVER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
           //do something useful with the data
        }  
         System.out.println("*********** SERVER LOG ************");
        }
     public boolean cheakconsoleLogs(String logMsg) {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            //System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            if(entry.getMessage().contains(logMsg))
                return true;
        }
        return false;
    }
     
    void switchToAppIFrame()
    {
     driver.switchTo().frame(appFrame);
    }
    
    
     /**
     * Accept alert window.
     */
    void acceptAlertWindow(){
        try{
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch(Exception e){}
    }
    

    public BasePageActions(WebDriver driver, String pageName) {
        super(driver, pageName);
        this.driver = driver;
        this.pageName = pageName;
    }

    protected void waitForSpinnerToDisappear() {
        int i = 0;
        wait.resetImplicitTimeout(5);
        try {
            List<WebElement> spinnerGifs = driver.findElements(By.xpath("//img[contains(@src, '/nb/ui/images/savingAnimation_')]"));
            if (spinnerGifs.size() > 0) {
                for (WebElement spinnerGif : spinnerGifs) {
                    while (spinnerGif.isDisplayed() && i <= AJAX_WAIT) {
                        wait.hardWait(5);
                        i++;
                    }
                }
            }
        } catch (Exception e) {
        }
        wait.resetImplicitTimeout(AJAX_WAIT);
    }
 void switchToPrintPreviewIFrame(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, '_NB_Dock_IFrame') and contains(@src,'print_preview')]")));
    }
 

 void switchToToActivityIFrame(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'distinct_activity_create_frame') and not(contains(@style,'none'))]")));
    }
 
 /**
     * Deselect frame.
     */
    void deselectFrame() {
        driver.switchTo().defaultContent();
    }
    
        /**
     * Switch to modal options edit i frame.
     */
    void switchToModalOptionsEditIFrame(){
        driver.switchTo().frame(modalFrame);
    }
    
    
    /**
     * Switch to dock i frame.
     */
    void switchToDockIFrame(){
        driver.switchTo().frame(dockFrame);
    }

    
    void switchToDock(){
        driver.switchTo().frame(dockFrame1);
    }
    
    /**
     * Switch to activity i frame.
     */
    
    
    void switchToMainIFrame(){
        
        switchToFrame( driver
                .findElement(By
                        .xpath("//iframe[contains(@id, '_NB_Main_IFrame') and not(contains(@style,'none')) and contains(@src,'nbreader')]")));
    //driver.switchTo().frame(MainIFrame);

    }
    
    void switchToSVRFrame(){
        
        switchToFrame( driver.findElement(By.id("easyXDM_activityService_previewTarget_provider")));
     
    }
    
    void switchToActiveServiceCXPFrame(){
        
        switchToFrame( driver.findElement(By.id("easyXDM_activityService_cxp_Target_provider")));
     
    }
    public void waitForDomToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*")));
	}
    
    
    
    
    void switchToFullBookFrame(){
        switchToFrame( driver.findElement(By
                        .xpath("//iframe[contains(@data-app-name,'Reader')]")).getAttribute("id"));
    }
    public void switchToFrame(String stf) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(stf));
	}
    
    void switchToApliaFrame(){
        switchToFrame( driver.findElement(By
                        .xpath("//iframe[contains(@data-app-name,'Aplia')]")).getAttribute("id"));
    }
    
    void switchToCNowHWFrame(){
        switchToFrame( driver.findElement(By
                        .xpath("//iframe[contains(@data-app-name,'CNOW.HW-preclass_ilrn_com')]")).getAttribute("id"));
    }
    

    public void switchToActivityIFrame()
    {
     driver.switchTo().frame(activityFrame);
    }
    
    void switchToMediaName()
    {
     driver.switchTo().frame(frameName);
    }
    
    
    
    
    void inputDistinctActivityTitleAndDescription(){
         element("add_link").click();
        ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('menu')[0].style.display = 'block';");
        ((JavascriptExecutor) driver).executeScript("document.getElementById('menu_addActivity').click();");
        //waitForElementDisplayed(addActivity)
        //addActivity.click()
        //clickOnElementUsingActionBuilder(addActivity)       
    }
    
    void resetImplicitTimeout(int newTimeOut){
        try{
           driver.manage().timeouts().implicitlyWait(newTimeOut,TimeUnit.SECONDS);
        }
        catch(Exception e){}
    
    
    }
    
    
    void selectOrder(){
        int position=1;
        element("ddl_orderButton").click();
        driver.findElement(By.xpath("//ul[@id='order-menu']/li[1]")).click();
        
    }
    
    void closeAnnouncement(){
        deselectFrame();
        try {
            resetImplicitTimeout(3);
            driver.findElement(By.xpath("//div[contains(@class,'announcement')]/div/a[contains(@class,'nb_closeIcon')]")).click();
            resetImplicitTimeout(120);
        }catch(Exception e){
            resetImplicitTimeout(120);
        }
        
    }
    
    

    void switchToFlashCardFrame(){
        switchToFrame( driver
                .findElement(By
                        .xpath("//iframe[contains(@data-app-name,'FlashCard')]")).getAttribute("id"));
    }
    
     void switchToGradeBookFrame(){
        switchToFrame( driver
                .findElement(By
                        .xpath("//iframe[contains(@data-app-name,'Progress')]")).getAttribute("id"));
    }

}
