/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author QAI
 */
public class GoogleDriveAppPageActions  extends BasePageActions {

    public String windowHandle;
    
public GoogleDriveAppPageActions(WebDriver driver) {
        
    super(driver,"GoogleDrive");
   }


@FindBy(xpath="//table[@id='gdoc_list_table']//input[@type='radio']")
    List<WebElement> gdoc_list;

/** The nb_list. */
    @FindBy(xpath="//li[contains(@class, 'item switchPath node lpn_node_')]")
    List<WebElement> nb_list; 


    public void clickOnGoogleDriveApp() {
        try{
            element("more_link").click();
        }catch(Exception e){}
        element("myContent_icon").click();
        switchToDockIFrame();
        try{
            waitForElementPresent("categoryHeader");
        }catch(Exception e){            
        
        }
        
        String categoryHeader = driver.findElement(By.id("title")).getText();
        if(categoryHeader.contains("Google Drive")){
            Reporter.log("Google Drive Icon is already displayed");
        }else{
            element("googleDriveIcon").click() ;
            
        }
    }
    
    
    public boolean addGoogleDocApp(String gmailID,String password){
        
        try{
            acceptAlertWindow();
            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        }
        catch(Exception e){}
        String categoryHeader = driver.findElement(By.id("title")).getText();
        if(categoryHeader.contains("Google Drive")){
            Reporter.log("Google Docs Icon is already displayed");
        }else{
            element("googleDriveIcon").click(); 
            try{
                acceptAlertWindow();
                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
     
            }
            catch(Exception e){}
        }
        
        switchToAppIFrame();
        
        try{
            driver.findElement(By.cssSelector(".addnewAccount"));
            signInAndCheckAccessForAppDock(gmailID,password);
            checkAndUncheckShowAllContent();
            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
     
        }
        catch(Exception e){
            deselectFrame();
        }
        return true;
    }
    
    
    void checkAndUncheckShowAllContent(){
        // driver.switchTo().frame(dockFrame)
        //driver.switchTo().frame(appFrame)
        switchToDockIFrame();
        switchToAppIFrame();
        element("showDoc").click();
        Assert.assertTrue(driver.findElement(By.xpath(" //tr[contains(@class,'googledocument')]//a[@class='ng-binding']")).isDisplayed(),"document is not shared");
        deselectFrame();
    }
    
    public void signInAndCheckAccessForAppDock(String gmailID,String password){
        windowHandle=driver.getWindowHandle();
        clickOnSignInButtonAndSwitchToWindow();
        loginToGoogleAccount(gmailID,password);
        verifyDenyAccessInGoogleDoc();
        driver.switchTo().window(windowHandle);
        switchToDockIFrame();
        switchToAppIFrame();
        clickOnSignInButtonAndSwitchToWindow();
        verifyGrantAccessInGoogleDoc();
        driver.switchTo().window(windowHandle);
    }
    
    public void signInGoogleDrive(String gmailID,String password){
        
        windowHandle=driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        loginToGoogleAccount(gmailID,password);
        verifyGrantAccessInGoogleDoc();
        driver.switchTo().window(windowHandle);
        
        //driver.switchTo().window(currentWindowHandle);
        
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='picker:ht']")).isDisplayed());
        driver.findElement(By.xpath("(//span[text()='analytics.html'])[1]")).click();
        driver.findElement(By.xpath("//div[text()='Select' and @tabindex='0']")).click();
        
    }
    
    
    void verifyGrantAccessInGoogleDoc(){
        Assert.assertTrue(element("allow").isDisplayed(),"Grant Access button is not displayed.");
        element("allow").click();
    }
    
    
    public void loginToGoogleAccount(String gmailID,String password){
        element("email").sendKeys(gmailID);
        element("next").click();
        waitTOSync();
        element("passwd").sendKeys(password);
        //element("signIn").click();
        //clickOnElementUsingActionBuilder(element("signIn"));
        executeJavascript("document.getElementById('signIn').click();");
        
    }
    
    /**
     * Verify deny access in google doc.
     */
    void verifyDenyAccessInGoogleDoc(){
        waitTOSync();
        Assert.assertTrue(element("deny").isDisplayed(),"Deny Access button is not displayed.");
        //element("deny").click();
        executeJavascript("document.getElementById('submit_deny_access').click();");
    }
    
    
    /**
     * Click on sign in button and switch to window.
     */
    public void clickOnSignInButtonAndSwitchToWindow(){
        element("signIn_btn").click();
        deselectFrame();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

    public boolean verifyFilteringSortingInGoogleDriveApp() {
    
        return verifyFilteringSorting();
    }

    private boolean verifyFilteringSorting() {
        
        switchToDockIFrame();
        switchToAppIFrame();
        uploadFile();
        verifyFilteringOptions();
        verifySortingOperations();
        selectFile();
        deselectFrame();
        return true;
        
    }

    /**
     * Upload file.
     */
    public void uploadFile(){   
        Assert.assertTrue(element("upload_btn").isDisplayed(),"Upload button is not displayed.");
        waitTOSync();
        //executeJavascript("document.getElementById('upload_appdock').click();");
        //executeJavascript("document.getElementById('upload_cancel').click();");
        element("upload_btn").click();
        waitForElementPresent("uploadCancel");
        element("uploadCancel").click();
    }

    /**
     * Verify filtering options.
     */
    public void verifyFilteringOptions(){
        //Assert.assertTrue(element("spreadSheets").isDisplayed(),"spreadSheets button is not displayed.");
        //TODO:
        //element("spreadSheets").click();
        //clickOnElementUsingActionBuilder(element("spreadSheets"));
        //executeJavascript("document.getElementById('xls').click();");
        waitForElementPresent("presentations");
        Assert.assertTrue(element("presentations").isDisplayed(),"presentations button is not displayed.");
        executeJavascript("document.getElementById('ppt').click();");
        //element("presentations").click();
        Assert.assertTrue(element("pdf").isDisplayed(),"pdf button is not displayed.");
        //element("pdf").click();
        executeJavascript("document.getElementById('pdf').click();");
        Assert.assertTrue(element("documents").isDisplayed(),"documents button is not displayed.");
        //element("documents").click();
        executeJavascript("document.getElementById('doc').click();");
    }

    /**
     * Verify sorting operations.
     */
    void verifySortingOperations(){
        Assert.assertTrue(element("sortByDoc").isDisplayed(),"sort by doc icon not displayed.");
        element("sortByDoc").click();
        element("sortByDoc").click();
        Assert.assertTrue(element("sortByType").isDisplayed(),"sort by type icon not displayed.");
        element("sortByType").click();
        element("sortByType").click();
        Assert.assertTrue(element("sortByModified").isDisplayed(),"sort by modified not displayed.");
        element("sortByModified").click();
        element("sortByModified").click();
        
    }
    
    
    /**
     * Adds the distinct google doc activity.
     *
     * @param title the title
     * @param email the email
     * @param password the password
     * @return true, if successful
     */
    public void  addDistinctGoogleDocActivity(String title,String email,String password){
        //performClickOnAddActivityIcon();
          clickOnMyContentAndGoogleDocFromMenu();
        try{
            handleAlert();
            acceptAlertWindow();
        }
        catch(Exception e){}
        switchToActivityIFrame();
        
        try{
            resetImplicitTimeout(2);
            driver.findElement(By.cssSelector(".addnewAccount"));
            signInAndCheckAccessForActivity(email,password);
            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
     
        }  catch(Exception e){}      
        finally{
            resetImplicitTimeout(AJAX_WAIT);
            deselectFrame();
            //driver.switchTo().frame(driver.findElement(By.id("distinct_activity_create_frame")).getAttribute("name"))
            switchToActivityIFrame();
            selectShowFilesCheckbox();
            /** Commenting as per NG-16026**/
            verifyFilteringOptions();
            verifySortingOperations();
            addGDocActivity();
            element("continue_btn").click();
            element("saveDistinctActivity").click();
            deselectFrame();
            //element("saveActivity").click();
            saveDistinctGoogleDocActivity(title);
        }
    }
    
    
    /**
     * Adds the distinct google inline doc activity.
     *
     * @param title the title
     * @param email the email
     * @param password the password
     
     */
    public void  addDistinctGoogleInlineDriveActivity(String title,String email,String password){
        //performClickOnAddActivityIcon();
          clickOnMyContentAndGoogleDocFromMenu();
        try{
            handleAlert();
            acceptAlertWindow();
        }
        catch(Exception e){}
        switchToActivityIFrame();
        
        try{
            resetImplicitTimeout(2);
            driver.findElement(By.cssSelector(".addnewAccount"));
            signInAndCheckAccessForActivity(email,password);
            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
     
        }  catch(Exception e){}      
        finally{
            resetImplicitTimeout(AJAX_WAIT);
            deselectFrame();
            //driver.switchTo().frame(driver.findElement(By.id("distinct_activity_create_frame")).getAttribute("name"))
            switchToActivityIFrame();
            selectShowFilesCheckbox();
            /** Commenting as per NG-16026**/
            verifyFilteringOptions();
            verifySortingOperations();
            addGDocActivity();
            element("continue_btn").click();
            element("inlineTitle").sendKeys(title);
            element("saveDistinctActivity").click();
            wait.hardWait(10);
            deselectFrame();
            
        }
    }
    
    
    
    
    
    
    
    
        /**
     * Save distinct google doc activity.
     *
     * @param title the title
     */
        void saveDistinctGoogleDocActivity(String title){
            try{
                element("title_inputField").clear();
                element("title_inputField").sendKeys(title); 
            }catch(Exception e){
                //To avoid stale element exception
                driver.findElement(By.xpath("//input[contains(@class,'required validates')]")).clear();
                driver.findElement(By.xpath("//input[contains(@class,'required validates')]")).sendKeys(title);
            }      
            selectOrder();
            waitForElementPresent("save_btn");
            //element("save_btn").click();
            //clickOnElementUsingActionBuilder(element("save_btn"));
            executeJavascript("document.getElementById('init_save').click();");
        }
    
    
    
    
    void clickOnMyContentAndGoogleDocFromMenu(){
        element("myContentMenuTypeSelector").click();
        element("googleDocMenuTypeSelector").click();
        waitForSpinnerToDisappear();
        
    }
    
    /**
     * Sign in and check access for activity.
     *
     * @param gmailID the gmail id
     * @param password the password
     */
    void signInAndCheckAccessForActivity(String gmailID,String password){
        windowHandle=driver.getWindowHandle();
        clickOnSignInButtonAndSwitchToWindow();
        loginToGoogleAccount(gmailID,password);
        verifyDenyAccessInGoogleDoc();
        driver.switchTo().window(windowHandle);
        switchToActivityIFrame();
        clickOnSignInButtonAndSwitchToWindow();
        verifyGrantAccessInGoogleDoc();
        driver.switchTo().window(windowHandle);
    }
    
    /**
     * Adds the g doc activity.
     */
    void addGDocActivity(){
        try{
            selectGDocDocument();
        }
        catch(Exception e){
            element("showDoc").click();
            selectGDocDocument();
        }
    }
    
    /**
     * Select g doc document.
     */
    void selectGDocDocument(){
        for(WebElement gdoc: gdoc_list){
             gdoc.click(); 
             break;
        }
    }
    
/**
     * Edits the distinct google doc activity.
     *
     * @param title the title
     */
    public void editDistinctGoogleDriveActivity(String title){
        int i = 0;
        //while(nb_list.get(i)){
        System.out.println(title);
            if(nb_list.get(0).getText().contains(title)){
                String bookClassName = nb_list.get(i).getAttribute("class").toString();
                System.out.println("book class name ........."+bookClassName);
                executeJavascript("document.getElementsByClassName('"+bookClassName+"')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
                waitTOSync();
                waitTOSync();
                driver.findElement(By.xpath("(//h3[@class='lpn_name' and contains(.,'"+title+"')]/parent::*/parent::*//img[@alt='Edit'])[1]")).click();
                
                saveDistinctGoogleDocActivity(title);
          //      break;
           // }
            //i++;
        }
    }

    public void studentVerifyGoogleDriveApp() {
    
        performClickOnMoreLink();
        element("googleDriveIcon_stu").click();
        //driver.switchTo().frame(dockFrame)
        switchToDockIFrame();
        Assert.assertTrue(driver.findElement(By.xpath("//tr[contains(@class,'googledocument')]//a[@class='ng-binding']")).isEnabled(),"document is not shared");
        verifyFilteringOptions();
        verifySortingOperations();
        deselectFrame();
        
    }
    
    /**
     * Perform click on more link.
     */
    public void performClickOnMoreLink(){
        try{
            resetImplicitTimeout(10);
            element("more_link").click();
        } catch(Exception e){   
        }
        resetImplicitTimeout(AJAX_WAIT);         
    }

    /**
     * Verify inline google doc activity.
     *
     * @return true, if successful
     */


    public boolean verifyInlineGoogleDriveActivity(){
        switchToDefaultContent();
       switchToMainIFrame();
       //TODO:
       //Assert.assertTrue(element("docActivity").isDisplayed(),"Google Doc activity not present");
       deselectFrame();
        return true;
     }

    /**
     * Edits the inline google doc activity.
     *
     * @param title the title
     */
    
    
    public void editInlineGoogleDocActivity(String title) {
    
        //element("editInlineActivity").click();
        executeJavascript("document.getElementsByClassName('editInlineActivity edit_editHover')[0].click();");
        deselectFrame();
        //driver.switchTo().frame(editFrame)
        switchToModalOptionsEditIFrame();
        saveInlineGoogleDocActivity(title);
        deselectFrame();
    }

/**
     * Save inline google doc activity.
     *
     * @param title the title
     */
    public void saveInlineGoogleDocActivity(String title){
        element("inlineGDoc_title").clear();
        element("inlineGDoc_title").sendKeys(title);
        element("saveDistinctActivity").click();
    }

    
 /**
     * Verify presence of distinct activity.
     *
     * @param title the title
     * @return true, if successful
     */   
    
    public boolean verifyPresenceOfDistinctActivity(String title) {
        
        waitTOSync();
        resetImplicitTimeout(10);
        List<WebElement> nb_list = driver.findElements(By.xpath("//div[@class='lpn_thumbTitle']/h3"));
        for(WebElement unit: nb_list){
            String unitName=unit.getText();
            if(unitName.contains(title)){
                return true;
            }
        }
        return false;
        
    }

    public void verifyAccountIsDeleted() {
    
        element("myContent").click();
        switchToDockIFrame();
        String head = element("mycontent_title").getText();
        if(head.contains("Kaltura"));
        driver.findElement(By.xpath("//a[contains(@title,'Google Drive')]")).click();
        switchToAppIFrame();
        element("signIn_btn").click();
       
    }

    /**
     * Delete account.
     *
     * @param gmailID the gmail id
     * @param password the password
     */
    
    
    public void DeleteGoogleDriveAccount(String gmailID,String password) {
    
        //performClickOnMoreLink()
        
        element("myContent").click();
        switchToDockIFrame();
        String head = element("mycontent_title").getText();
        if(head.contains("Kaltura"));
        driver.findElement(By.xpath("//a[contains(@title,'Google Drive')]")).click();
        switchToAppIFrame();
        try{
            acceptAlertWindow();
        }
        catch(Exception e){
        
        }
        
        waitForElementPresent("manageAccounts");
        //element("manageAccounts").click();
        executeJavascript("document.getElementById('AccountsMngmntId').click();");
        
        try{
            waitForElementPresent("back_btn");  
            element("back_btn").click();
        }
        catch(Exception e){
            refreshPage();
            element("myContent").click();
            switchToDockIFrame();
            switchToAppIFrame();
        }
        waitForElementPresent("manageAccounts");
        //clickOnElementUsingActionBuilder(element("manageAccounts"));
        //element("manageAccounts").click();
        executeJavascript("document.getElementById('AccountsMngmntId').click();");
        waitTOSync();
        waitForElementPresent("removeAccount");
        executeJavascript("document.getElementsByClassName('removeActiveAcct')[0].click();");
        //element("removeAccount").click();
        waitForElementPresent("continueButton");
        element("continueButton").click();
        deselectFrame();
        String winHandler=driver.getWindowHandle();
        try{
            resetImplicitTimeout(2);
            accountSettingWindow(gmailID,password);
        }
        catch(Exception e){
            //takeScreenShotMethod();
        }
        resetImplicitTimeout(AJAX_WAIT);
        driver.switchTo().window(winHandler);
        
    }

    
    /**
     * Account setting window.
     *
     * @param gmailID the gmail id
     * @param password the password
     */
    public void accountSettingWindow(String gmailID,String password){
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        driver.manage().window().maximize();
        try{
            resetImplicitTimeout(2);
            waitForElementPresent("accountHomepage");
            element("accountHomepage").click();
            Thread.sleep(5000);
            //To avoid stale element exception
            driver.findElement(By.id("nav-security"));
            element("security").click();
        }
        catch(Exception e){
            waitForElementPresent("signIn_icon");
            element("signIn_icon").click();
            loginToGoogleAccount(gmailID,password);
            driver.findElement(By.linkText("About the Sign in Request page")).click();
            //waitForElementDisplayed(accountHomepage);
            element("accountHomepage").click();
            //waitForElementDisplayed(security);
            element("security").click();
        }
        resetImplicitTimeout(AJAX_WAIT);
        //waitForElementDisplayed(manageAccess);
        element("manageAccess").click();
        //waitForElementDisplayed(revokeAccess);
        element("revokeAccess").click();
        //waitForElementDisplayed(ok_btn);
        element("ok_btn").click();
        //waitToSync();
        driver.findElement(By.xpath("//a[contains(@title,'"+gmailID+"')]")).click();
        //waitForElementDisplayed(signOut_link);
        element("signOut_link").click();
        //waitToSync();
        driver.close();
    }       

    public void selectFile() {
        element("selectFile").click();
    }
    
    public void selectShowFilesCheckbox() {
    driver.findElement(By.xpath("//input[@id='showDocs']")).click();
    }
    
    
    
    
    
}




