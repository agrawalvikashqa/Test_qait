/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QAI
 */
public class DashBoardPageActions extends BasePageActions {

    List<WebElement> distinctActivityList_Size;
    int distinctActivity_Size;
    boolean flag = true;
    WebElement element;

    public DashBoardPageActions(WebDriver driver) {
        super(driver, "DashBoardPage");
    }

    public void setBrowserZoom(String appName) {
        executeJavascript("document.body.style.zoom='" + appName + "'");
        ReportMsg.info("Zoom Set to " + appName);
        wait.waitForPageToLoadCompletely();

    }

    public void LaunchAppFromAppDock(String appName) {
        waitForElementPresent("expandDockBtn");
        try {
            element("expandDockBtn").click();
        } catch (Exception e) {

            ReportMsg.info("Dock items are already expanded or expand dock button is not present");

        }
        try {
            element("app_name", appName).click();
        } catch (Exception e) {
            driver.findElement(By.xpath("//img[@title='ConnectYard']")).click();
        }

        element("appActionFrameTitle");
        ReportMsg.info("User Clicked on '" + appName + " App from AppDock ");

    }

    public void clickOnAddIconAndAddActivity() {
        deselectFrame();
        executeJavascript("document.getElementById('menu_addContent').click();");
//        isElementDisplayed(element("addContent_btn"));
//        element("addContent_btn").click();
        ReportMsg.info("User Clicked on add Icon");
        executeJavascript("document.getElementById('menu_addActivity').click();");
//        element("addActivity_link").click();
        ReportMsg.info("User Clicked on add activity text");
    }

    public void hideUnit(String activity_title) {
        String bookClassName = element("lpnActivity_link", activity_title).getAttribute("class");
        executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
        isElementDisplayed("activityHide_icon", activity_title);
        clickOnElementUsingActionBuilder(element("activityHide_icon", activity_title));
        executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
        isElementDisplayed("activityShow_icon", activity_title);
        //Assert.assertTrue((element("activityShow_icon"), activity_title).isDisplayed();
        //Assert.assertTrue(isElementDisplayed("activityShow_icon"), activity_title);
    }

    public void editUnit(String activity_title) {
        waitTOSync();
        String bookClassName = element("lpnActivity_link", activity_title).getAttribute("class");
        executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
        isElementDisplayed("activityEdit_icon", activity_title);
        clickOnElementUsingActionBuilder(element("activityEdit_icon", activity_title));

    }

    public void unhideUnit(String activity_title) {
        String bookClassName = element("lpnActivity_link", activity_title).getAttribute("class");
        executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
        isElementDisplayed("activityShow_icon", activity_title);
        clickOnElementUsingActionBuilder(element("activityHide_icon", activity_title));
 //     executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
        //     Assert.assertTrue(isElementDisplayed("activityHide_icon"), "Unit is not hidden");
    }

    public void inputEditDescriptionAndDateOfCustomUnit(String description) {
        element("description_textField").sendKeys(description);

        //element("save_btn").click();
//        element("lpn_description",description); 
//        element("availabledateinput").click();
//        element("activedate").click();
//        element("duedateinput").click();
//        element("nexticon").click();  
//        element("date").click();
        selectOrder("2");
        clickOnElementUsingActionBuilder(element("save_btn"));
    }

    public void inputEditTitleAndDateOfCustomFolder(String testfolder) {
        element("folderTitle").clear();
        element("folderTitle").sendKeys(testfolder);
        selectOrder("2");
        clickOnElementUsingActionBuilder(element("save_btn"));
    }

    public void verifyAddedActivityHeading() {
        assert element("addedActivity_text").isDisplayed();
        ReportMsg.info("User verified Add activity heading");
    }

    public void clickOnActivity(String activityName) {
        element("activityName_link", activityName).click();
        ReportMsg.info("User Clicked on " + activityName);
    }

    public void addActivityDiscriptionAndTitle(String title, String text) {
        waitForSpinnerToDisappear();
        element("add_title").click();
        element("add_title").clear();
        element("add_title").sendKeys(title);
        ReportMsg.info("User added the title of the Activity");
        element("add_Discription").click();
        element("add_Discription").clear();
        element("add_Discription").sendKeys(text);
        ReportMsg.info("User define the discription of the Activity");
        selectOrder("1");
        element("saveActivity_btn").click();
        ReportMsg.info("User clicked on save button and added the Activity");
    }

    public void addActivityDiscriptionAndTitleForInline(String title, String text) {
        deselectFrame();
        waitForSpinnerToDisappear();
        element("add_title").click();
        element("add_title").clear();
        element("add_title").sendKeys(title);
        ReportMsg.info("User added the title of the Activity");
        element("add_Discription").click();
        element("add_Discription").clear();
        element("add_Discription").sendKeys(text);
        ReportMsg.info("User define the discription of the Activity");
        element("saveActivity_btn").click();
        ReportMsg.info("User clicked on save button and added the Activity");

    }

    public void SaveChanges() {
        element("saveActivity_btn").click();
        ReportMsg.info("User clicked on save button to make changes");
    }

    public void VerifyGradedLabel(String title) {
        isElementDisplayed(element("Grades_label", title));
        Reporter.log("Added activity has *Count Towards Grade* label");
    }

    public void VerifyPracticeLabel(String title) {
        isElementDisplayed(element("Practice_label", title));
        Reporter.log("Added activity has *Practice* label");
    }

    public void editDistinctActivityLocation(String activity_title) {
        String bookClassName = element("lpnActivity_link", activity_title).getAttribute("class");
        executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
        isElementDisplayed("activityEdit_icon", activity_title);
        element("activityEdit_icon", activity_title).click();
    }

    public void addToLocation(String Location) {

        scrollDown(element("addtolocation"));
        element("addtolocation").click();
        //scrollDown(element("selectchapter_location", Location));
        element("selectchapter_location", Location).click();
        selectOrder("1");
        ReportMsg.info("User moved an hidden activity to Visible unit");
    }

    public void addToTopLocation(String Location) {

        scrollDown(element("addtolocation"));
        element("addtolocation").click();
        //scrollDown(element("selectchapter_location", Location));
        element("selectTop_location ", Location).click();
        selectOrder("1");
        ReportMsg.info("User moved an hidden activity to Visible unit");
    }

    public void addInlineActivityDiscriptionAndTitle(String title, String text) {
        waitForSpinnerToDisappear();
        element("add_title").click();
        element("add_title").clear();
        element("add_title").sendKeys(title);
        ReportMsg.info("User added the title of the Activity");
        element("add_Discription").click();
        element("add_Discription").clear();
        element("add_Discription").sendKeys(text);
        ReportMsg.info("User define the discription of the Activity");
        element("saveActivity_btn").click();
        ReportMsg.info("User clicked on save button and added the Activity");
    }

    public void clickOnSaveButtonInTitlePage() {
        element("saveActivity_btn").click();
        ReportMsg.info("User clicked on save button and added the Activity");
    }

    public void selectOrder(String position) {
        element("selectMenu_Order").click();
        ReportMsg.info("User clicked on select menu to select the position of the activity");
        element("selectPosition", position).click();
        ReportMsg.info("User set the position " + position);
    }

    public void clickOnView(String _view_Tab) {
        wait.hardWait(4);
        isElementDisplayed(element("view_tab", _view_Tab));
        clickOnElementUsingActionBuilder(element("view_tab", _view_Tab));
        ReportMsg.info("User clicked on " + _view_Tab + " tab");
        waitForSpinnerToDisappear();
    }

    public void hideUnitHavingAttemptedActivities(String activity_title) {
        scrollDown(element("lpnActivity_link", activity_title));
        String bookClassName = element("lpnActivity_link", activity_title).getAttribute("class");
        executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
        isElementDisplayed("activityHide_icon", activity_title);
        element("activityHide_icon", activity_title).click();
        handleAlert();
        Reporter.log("Instructor is able to hide activity" + activity_title + "which is started by student");
        waitTOSync();
        executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
        isElementDisplayed("activityShow_icon", activity_title);
    }

    public void launchDistinctActivity(String activity_title) {
        waitTOSync();
        scrollDown(element("activityTitle_link", activity_title));
        element("activityTitle_link", activity_title).isDisplayed();
        element("activityTitle_link", activity_title).click();
        waitForSpinnerToDisappear();
        ReportMsg.info("User launched " + activity_title);
    }

    public void closeLaunchedActivity(String Activity) {
        //clickOnElementUsingActionBuilder(element("close_Activity"));
        //clickOnElementUsingActionBuilder(driver.findElement(By.xpath("//a[@title='Close Activity']")));
        //driver.findElement(By.xpath("//a[@title='Close Activity']")).click();
        executeJavascript("document.getElementById('app_activity_frame_closeActivity').click();");
        ReportMsg.info("User Closed " + Activity);
    }

    public void deleteDistinctActivity(String activity_title) {
        for (WebElement distinctActivity : elements("activityTitle_link", activity_title)) {
            waitTOSync();
            String bookClassName = element("lpnActivity_link", activity_title).getAttribute("class");
            executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
            isElementDisplayed("activityDelete_icon", activity_title);
            clickOnElementUsingActionBuilder(element("activityDelete_icon", activity_title));
            ReportMsg.info("Clicked on delete Button");
            handleAlert();
            ReportMsg.info("Activity Deleted");
        }
    }

    public void deleteDistinctFolder(String activity_title) {
        waitForElementPresent("FolderTitle_link");
        for (WebElement distinctActivity : elements("FolderTitle_link", activity_title)) {
            waitTOSync();
            String bookClassName = element("lpnActivity_link", activity_title).getAttribute("class");
            executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
            isElementDisplayed("activityDelete_icon", activity_title);
            element("activityDelete_icon", activity_title).click();
            //clickOnElementUsingActionBuilder(element("activityDelete_icon", activity_title));
            ReportMsg.info("Clicked on delete Button");
            handleAlert();
            ReportMsg.info("Activity Deleted");
            break;
        }
    }

    public void editDistinctActivity(String activity_title) {
        String bookClassName = element("lpnActivity_link", activity_title).getAttribute("class");
        executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
        isElementDisplayed("activityEdit_icon", activity_title);
        clickOnElementUsingActionBuilder(element("activityEdit_icon", activity_title));
        wait.hardWait(1);
        //element("editOption_btn").click();
        clickOnElementUsingActionBuilder(element("editOption_btn"));
        waitTOSync();
        waitTOSync();
        waitTOSync();

    }

    public boolean editDisable(String activity_title) {

        try {

            String bookClassName = element("lpnActivity_link", activity_title).getAttribute("class");
            executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
            isElementDisplayed("activityEdit_icon", activity_title);
            clickOnElementUsingActionBuilder(element("activityEdit_icon", activity_title));
            wait.hardWait(1);
            element("editOption_btn").click();
            return false;

        } catch (Exception e) {
            return true;
        }

    }

    public void editDistinctActivityNoEdit(String activity_title) {
        String bookClassName = element("lpnActivity_link", activity_title).getAttribute("class");
        executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
        isElementDisplayed("activityEdit_icon", activity_title);
        clickOnElementUsingActionBuilder(element("activityEdit_icon", activity_title));
        waitTOSync();
        waitTOSync();
        waitTOSync();
        waitTOSync();

    }

    public void verifyUserNavigateToSplashPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void verifyEulaPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void verifyAllSplashViewLinksAreClickable() {
        element("getCengageLogo").click();
        element("aboutCengageLink").click();
        element("AboutUs").isDisplayed();
        element("copyrightStatmentLink").click();
        element("copyrightInfo").isDisplayed();
        element("serviceAgreementLink").click();
        element("serviceAgreementInfo").isDisplayed();
        if (element("CourseName").getText().toLowerCase().contains("chemistry")) {
            element("creditsLink").click();
            element("creditsInfo").isDisplayed();
        } else {
            element("bookCoverLink").click();
            element("coverImage").isDisplayed();
        }
        element("closeButton").click();
    }

    public void helpOverlayDisplay() {
        waitTOSync();
        executeJavascript("document.getElementById('help').click();");
        //element("helpIcon").click();
        Assert.assertTrue(element("helpoverlayPane").getAttribute("style").contains("display: block;"));
        element("helpoverlayPaneButton").click();
    }
/*** This method is being used in NG_33330 ****/
    public void clickHelpOverlay() {
        waitTOSync();
        element("helpIcon").click();
         Assert.assertTrue(element("helpoverlayPane").getAttribute("style").contains("display: block;"));
         //element("helpoverlayPaneButton").click();
    }
    
    public void closeHelpOverLay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean verifyWeekWidget() {
        ReportMsg.info("Verifying Week widget view gets loaded");
        return element("wdgt_weekview").isDisplayed();

    }

    public void switchModeDisplayOnWeekWidgetPage() {
        element("AllScoreLink").isDisplayed();

        Assert.assertTrue(element("getTab_Week").isDisplayed());
        element("getTab_Week").click();
        waitForElementPresent("weekviewArea");

        Assert.assertTrue(element("getTab_DateManager").isDisplayed());
        element("getTab_DateManager").click();
        waitForElementPresent("dateManagerArea");

        Assert.assertTrue(element("getTab_Unit").isDisplayed());
        element("getTab_Unit").click();
        waitForElementPresent("lpnListArea");
    }

    public void verifyCengageLogoIsDisplayedInDashboardView() {
        Assert.assertTrue(element("getCengageLogo").isDisplayed(),
                "Cengage logo is not diaplyed in Dashboard view");
        closeAnnouncement();
    }

    public void viewAllScoresDisplayAnLaunch(String user) {

        if (user.equalsIgnoreCase("instructor")) {
            executeJavascript("document.getElementById('allScores').click();");
            //clickOnElementUsingActionBuilder(element("OpenFullGradebook"));
            switchToFrame(element("getProgressFrame").getAttribute("id"));
            element("getGradebookHeading").isDisplayed();
            switchToDefaultContent();
            element("apphidebtn", "Progress").click();

        } else {

            executeJavascript("document.getElementById('allScores').click();");
            //clickOnElementUsingActionBuilder(element("OpenFullGradebook"));
            switchToFrame(element("getProgressFrame").getAttribute("id"));
            Assert.assertTrue(element("myGrade").isDisplayed(), "myGrade button not displaying");
            switchToDefaultContent();
            element("apphidebtn", "Progress").click();
        }

    }

    public void ViewAllNotificationsDisplayAnLaunch(String user) {

        // element("AllNotifications").click();
        waitTOSync();
        //clickOnElementUsingActionBuilder(element("AllNotifications"));
        // element("AllNotifications").click();
        //clickOnElementUsingActionBuilder(element("AllNotifications"));
        executeJavascript("document.getElementById('linkAllNotifications').click();");
        switchToFrame(element("AllNotificationsFrame"));
        if (user.equalsIgnoreCase("instructor")) {
            element("MessageTextBox").isDisplayed();
        }
        closeOpenApp();
        switchToDefaultContent();
        // element("apphidebtn", "MessageCenter").click();
    }

    void closeAnnouncement() {
        try {
            List<WebElement> closeLinks = driver.findElements(By.xpath("//a[contains(@class,'nb_closeIcon')]"));
            for (WebElement link : closeLinks) {
                link.click();
            }
        } catch (Exception e) {
        }
    }

    public void clickOnAllApps() {
        Assert.assertTrue(element("AllScoreLink").isDisplayed());
        Assert.assertTrue(element("app_toggleBtn").isDisplayed());
        ReportMsg.info("Clicking on All Apps button");
        ((JavascriptExecutor) driver).executeScript("document.getElementById('nb_dock').style.display='block';");
    }

    public void clickOnAppByName(String appName) {
        String dockGroup;
        int i = 0, k = -1;
        for (int j = 0; j < elements("lbl_appName").size(); j++) {
            if (j < elements("dockGroup1").size()) {
                dockGroup = "dockGroup1";
                i = j;
            } else {
                dockGroup = "dockGroup2";
                k++;
                i = k;
            }
            //System.out.println(elements("lbl_appName").get(j).getAttribute("title"));
            if (elements("lbl_appName").get(j).getAttribute("title").equalsIgnoreCase(appName)) {
                elements("appNameLink").get(j).isDisplayed();
                ((JavascriptExecutor) driver).executeScript("document.getElementById('" + dockGroup + "').childNodes[" + ((2 * i) + 1) + "].childNodes[0].click();");
                getVerifyByAppName(elements("lbl_appName").get(j).getAttribute("title"));
                break;
            }
        }
        waitTOSync();
    }

    public void verifyMerriamWebsterDictionaryUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void clickOnNextButton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Gets the verify by app name.
     *
     * @param appName the app name
     * @return the verify by app name
     */

    public void getVerifyByAppName(String appName) {
        try {
            element("HeadingNameOfTheApp", appName);
            Assert.assertTrue(element("HeadingNameOfTheApp", appName).isDisplayed());
            Assert.assertTrue(element("getCollapse").isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeOpenApp() {
        driver.switchTo().defaultContent();
        //element("getCollapse").click();
        clickOnElementUsingActionBuilder(element("getCollapse"));

    }

    public void selectOptionFromUserMenu(String menuOption) {
        clickOnUserMenuLink();
        clickOnElementUsingActionBuilder(element("userMenuOpts", menuOption));

    }

    public boolean verifyCourseSettings() {
        boolean flag = false;
        flag = element("CourseSettingsDialog").isDisplayed();
       //InstructorCourseSetting();
        //DashboardCourseSetting();
        //StudentIDCourseSetting();
        //PartnerAppCourseSetting();
        GradebookCourseSetting();
        element("closeIcon").click();
        return flag;
    }

    private void InstructorCourseSetting() {

        element("Instructor_collapse").click();
        Assert.assertTrue(element("Instructor_auto_collapse").isDisplayed(), "Instructor Automation not found");
        Assert.assertTrue(element("save_Button").isDisplayed(), "Save buttton  not found");
        ReportMsg.log("instructor automation and Save button is found ");
        element("Instructor_collapse").click();
        ReportMsg.log("instructor collapse verified");

    }

    private void DashboardCourseSetting() {

        element("Dashboard_collapse").click();
        Select dropdown = new Select(driver.findElement(By.xpath("//select")));
        dropdown.selectByVisibleText("Unit View");
        dropdown.selectByVisibleText("List View");
        dropdown.selectByVisibleText("Week View");
        Assert.assertTrue(element("SaveSetting_Dashboard").isDisplayed(), "save setting button is not present");
        element("Dashboard_collapse").click();
        ReportMsg.log("Dashbord_collapse verified");

    }

    private void StudentIDCourseSetting() {

        element("Student_ID_collapse").click();
        Assert.assertTrue(element("Studentid_CheckBox").isDisplayed(), " Checkbox button is not present ");
        Assert.assertTrue(element("Studentid_CB_enable").isDisplayed(), " Checkbox button is disable ");
        Assert.assertTrue(element("StudentID_Dashboard").isDisplayed(), "save setting button is not present");
        element("Student_ID_collapse").click();
        ReportMsg.log("Student ID collapse  verified");
    }

    private void PartnerAppCourseSetting() {

        element("Partner_App_collapse").click();
        Assert.assertTrue(element("PartnerApp_Dashboard").isDisplayed(), "save setting button is not present");
        element("Partner_app_enable").click();
        element("PartnerApp_Dashboard").click();
        element("Partner_App_collapse").click();

    }

    private void GradebookCourseSetting() {

        waitForElementPresent("Gradebook_collapse");
        element("Gradebook_collapse").click();
        element("Gradebook_collapse").click();
    }

    public boolean verifySendUsFeedback() {
        return true;
    }

    public boolean verifyFAQ() {
        return true;
    }

    public boolean verifySystemCheck() {

        CheckSystemCheckTitle();
        CheckBrowser();
        CheckJavaScript();
        CheckFlash();
        CheckCookies();
        CheckPopup();
        deselectFrame();
        return true;
    }

    private void CheckSystemCheckTitle() {

        waitForElementPresent("SystemCheck_title");
        Assert.assertTrue(element("SystemCheck_title").isDisplayed(), "title is not displyed");
        switchToDockIFrame();

    }

    private void CheckBrowser() {

        waitTOSync();
        waitForElementPresent("Browser");
        Assert.assertTrue(element("Browser").isDisplayed(), "Browser is not displyed");
        Assert.assertTrue(element("Browser_pass").isDisplayed(), "Browser pass is not display");
        ReportMsg.log("Browser is displayed and it is enabled");

    }

    private void CheckJavaScript() {

        Assert.assertTrue(element("Javascript").isDisplayed(), "Javascript is not displyed");
        Assert.assertTrue(element("JavaScript_pass").isDisplayed(), "Javascript pass is not display");
        ReportMsg.log("JavaScript is displayed and it is enabled");

    }

    private void CheckFlash() {

        Assert.assertTrue(element("Flash").isDisplayed(), "Flash is not displyed");
        Assert.assertTrue(element("Flash_pass").isDisplayed(), "Flash pass is not display");
        ReportMsg.log("Flash is displayed and it is enabled");

    }

    private void CheckCookies() {

        Assert.assertTrue(element("Cookies").isDisplayed(), "Cookies is not displyed");
        Assert.assertTrue(element("Cookies_pass").isDisplayed(), "Cookies pass is not display");
        ReportMsg.log("Cookies is displayed and it is Enable");

    }

    private void CheckPopup() {

        Assert.assertTrue(element("Popups").isDisplayed(), "Popups is not displyed");
        ReportMsg.log("Popups is displayed");
        try {
            Assert.assertTrue(element("Popups_fail").isDisplayed(), "Popups pass is not display");
            ReportMsg.log("Popups is Disabled");
        } catch (Exception e) {
            Assert.assertTrue(element("Popups_pass").isDisplayed(), "Popups pass is not display");
            ReportMsg.log("Popups is Enabled");
        }

    }

    public void Logout() {
        clickOnUserMenuLink();
        clickOnlogOutLink();
    }

    private void clickOnUserMenuLink() {
        try {
            driver.switchTo().defaultContent();
            driver.findElement(By.cssSelector(".user-menu-link.tb_item"));
            ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('user-menu')[0].style.display = 'block';");
        } catch (Exception e) {
            ReportMsg.info("Logout dropdown list not displayed");
        }
    }

    private void clickOnlogOutLink() {
        try {
            driver.switchTo().defaultContent();
            element("logout_link").click();
        } catch (Exception e) {
            ReportMsg.info("Logout link not displayed");
        }
    }

    /**
     * Perform click on new folder icon.
     */
    void performClickOnNewFolderIcon() {
        clickOnElementUsingActionBuilder(element("add_link"));
        executeJavascript("document.getElementById('menu_addFolder').click();");
    }

    /**
     * 1) Click on " + " icon 2) Select Folder 3) Enter Folder name 4) Select
     * order and Click on Save button
     *
     * @param testfolder
     */
    public boolean addFolder(String testfolder) {
        boolean flag = false;
        performClickOnNewFolderIcon();
        try {
            waitForElementPresent("adminForm");
        } catch (Exception e) {
        }
        if (element("adminForm").isDisplayed()) {
            waitTOSync();
            element("folderTitle").sendKeys(testfolder);
            waitForElementPresent("save_btn");
            selectOrder("1");
            element("save_btn").click();
            flag = true;
        } else {
            flag = false;
            //TODO: Take Screen Shot method
        }
        return flag;
    }

    public void AddUnit(String name, String description) {
        clickOnAddLinkAndAddUnit();
        inputNameOfCustomUnit(name);
        inputDescriptionOfCustomUnit(description);
        closeAnnouncement();
    }

    public boolean verifyUsersAddUnit(String description) {
        return isElementDisplayed("lpn_description", description);
    }

    public boolean verifyActivityByDescription(String description) {
        waitTOSync();
        waitTOSync();
        return isElementDisplayed("lpn_description", description);
    }

    public boolean verifyInlineActivityByDescription(String description) {
        switchToDefaultContent();
        switchToMainIFrame();
        waitTOSync();
        waitTOSync();
        return isElementDisplayed("inline_description", description);
    }

    public boolean verifyAddActivityDialogAppears() {
        waitForElementPresent("activitiesList");
        boolean flag = isElementDisplayed("activitiesList");
        element("cancelbutton").click();
        return flag;
    }

    /**
     * Click on add link and add unit.
     */
    void clickOnAddLinkAndAddUnit() {
        waitForElementPresent("add_link");
        clickOnElementUsingActionBuilder(element("add_link"));
        //waitForElementPresent("menu");
        ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('menu')[0].style.display = 'block';");
        ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('menu')[0].childNodes[3].childNodes[0].click()");
    }

    /**
     * Input name of custom unit.
     *
     * @param name the name
     */
    void inputNameOfCustomUnit(String name) {
        waitForElementPresent("unitName");
        element("unitName").click();
        element("unitName").clear();
        element("unitName").sendKeys(name);
    }

    /**
     * Input description of custom unit.
     *
     * @param description the description
     */
    void inputDescriptionOfCustomUnit(String description) {
        element("description_textField").sendKeys(description);
        selectOrder("1");
        clickOnElementUsingActionBuilder(element("save_btn"));
        //element("save_btn").click();
        element("lpn_description", description);
    }

    /**
     * Select activity to add.
     *
     * @param activityName the activity name
     */
    public void selectActivityToAdd(String activityName) {
        String getActivityClass;
        waitForElementPresent("activitiesList");
        List<WebElement> listActivities = elements("typeList");
        int i = 0;
        while (listActivities.get(i).isDisplayed()) {
            if (listActivities.get(i).getText().contains(activityName)) {
                getActivityClass = listActivities.get(i).getAttribute("class");
                fireOnClickJsEvent(getActivityClass, "0");
                break;
            }
            i++;
        }
    }

    public boolean ViewAllScoresDisplayAnLaunch(String emailId, String user) {
        boolean flag;
        clickOnElementUsingActionBuilder(element("OpenFullGradebook"));
        switchToFrame(element("getProgressFrame").getAttribute("id"));
        flag = element("StudentEmail").getText().contains(emailId);
        switchToDefaultContent();
        element("apphidebtn", "Progress").click();
        return flag;
    }

    public boolean verifyCustomerSupport() {

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Assert.assertTrue(element("HomeButton").isDisplayed());
        Assert.assertTrue(element("YesButton").isDisplayed());
        Assert.assertTrue(element("NoButton").isDisplayed());
        Assert.assertTrue(element("SignInButton").isDisplayed());
        driver.close();

        ReportMsg.log("Customer Support button verified ");

        return true;
    }

    public void selectCustomerSupport() {

        clickOnUserMenuLink();
        clickOnElementUsingActionBuilder(element("CustomerSupport"));

    }

    public void verifyAverageWidget() {

        Assert.assertTrue(element("aboveAverge").isDisplayed());

    }

    public void verifyDefaultClassAverageBar() {

        Assert.assertTrue(element("DefaultPercent").isDisplayed());

    }

    public void logOutMsg() {
        Assert.assertTrue(element("LogOut_Msg").isDisplayed());

    }

    public void verifyUpdateScore() {

        String Score = element("ClassAverageScore").getText();
        LaunchAppFromAppDock("Progress");
        System.out.println(Score);
        switchToDockIFrame();
        String UpdateScore = element("classUpdateScore").getText();
        System.out.println(UpdateScore);
        if (Score.equalsIgnoreCase(UpdateScore)) {
            ReportMsg.log("Score is Updated");
        } else {
            ReportMsg.log("Score is Mis Matched");
        }

    }

    public boolean VerifyAddActivityButtonNotPresent() {
        return isElementDisplayed(element("addContent_btn"));
    }

    public void verifyWeekviewbyDefault() {

        Assert.assertTrue(element("WeekViewActive").isDisplayed(), "Week View is not enable or set as default");

    }

    public void verifySkimmerFunctionality() {

        WebElement DragPos = element("DragPos");
        WebElement DropPos = element("DropPos");
        WebElement DropWeek2 = element("DragPosWeek2");
        Actions act = new Actions(driver);
        act.dragAndDrop(DragPos, DropPos).build().perform();
        Assert.assertTrue(element("verifyWeek").isDisplayed(), "Week View is not enable or set as default");
        waitTOSync();
        waitTOSync();
        waitTOSync();
        act.dragAndDrop(DropPos, DropWeek2).build().perform();

    }

    public void verifyNavigateButton() {

        Assert.assertTrue(element("NavButtonRight").isDisplayed());
        Assert.assertTrue(element("NavButtonLeft").isDisplayed());
        element("NavButtonRight").click();
        element("NavButtonLeft").click();
        //element("NavButtonLeft").click();

    }

    //There are no activities with due dates in this Course.
    //To add due dates, use the Date Manager or Unit View.
    //If your course does not use due dates, you can disable this Week View from the Course Settings.
    public void verifyDueAvailableDateNotSet() {

        verifyNoActivityPresent();

    }

    private void verifyNoActivityPresent() {

        Assert.assertTrue(element("noActivity").isDisplayed());
        ReportMsg.log("Verify that no activity is present with due date ");
    }

    public void setDueDate() {

        element("startDate").click();
        element("setDone").click();
        //clickOnElementUsingActionBuilder(element("setDone"));
        element("dueDate").click();
        element("setDone").click();
        //clickOnElementUsingActionBuilder(element("setDone"));
        element("saveActivity_btn").click();

    }

    public void checkActivityDueAdded() {

        Assert.assertTrue(element("checkAct").isDisplayed());
    }

    public boolean VerifyEditActivityButtonNotPresent(String activity_title) {
        try {
            String bookClassName = element("lpnActivity_link", activity_title).getAttribute("class");
            executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
            isElementDisplayed("activityEdit_icon", activity_title);
            clickOnElementUsingActionBuilder(element("activityEdit_icon", activity_title));
            element("editOption_btn").click();
        } catch (Exception e) {
            return true;
        }
        return false;

    }

    public void showUnit(String activity_title) {
        String bookClassName = element("lpnActivity_link", activity_title).getAttribute("class");
        executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
        isElementDisplayed("activityShow_icon", activity_title);
        element("activityShow_icon", activity_title).click();
        waitTOSync();

    }

    public void disableWeekView() {

        element("Dashboard_collapse").click();
        element("dashboardCheckbox").click();
        Assert.assertTrue(element("dashboard_Cb_Disable").isDisplayed());
        element("dashboardCheckbox").click();
        Assert.assertTrue(element("SaveSetting_Dashboard").isDisplayed(), "save setting button is not present");
        element("closeIcon").click();
        ReportMsg.log("Dashbord Checkbox Disable option verify ");

    }

    public void editThePathName() {

        String lpnText = element("lpnTitle").getText();
        System.out.println(lpnText);
        String lpnText_new = lpnText + " edited";
        System.out.println(lpnText_new);

        executeJavascript("document.getElementsByClassName('ui-button clui-edit')[0].click();");

        click(element("pathEdit"));
        element("pathEdit").clear();
        element("pathEdit").sendKeys(lpnText_new);
        clickOnElementUsingActionBuilder(element("pathSave"));

        String newText = element("lpnTitle").getText();
        System.out.println(newText);
        if (newText.equalsIgnoreCase(lpnText_new)) {
            ReportMsg.log("Succefully verify Path edit");
        } else {
            System.out.println("ERROR : Path Name not Matched with old Text ");

        }

    }

    public void verifyBarGraph() {

        Assert.assertTrue(element("barGraph").isDisplayed(), "Bar Graph is not displaying ");
    }

    public void verifyProgress() {

        Assert.assertTrue(element("Progress").isDisplayed(), "Bar Graph is not displaying ");

    }

    public void verifyIconGP() {

        String gradableIcon = element("gradableIcon").getCssValue("background");
        String practiceIcon = element("PracticeIcon").getCssValue("background");

        if (gradableIcon.contains("gradable.png") && practiceIcon.contains("practice_icon.png")) {
            ReportMsg.log("G and P Icons are presenet against the progress bar ");
        } else if (gradableIcon.contains("gradable.png") && !practiceIcon.contains("practice_icon.png")) {
            Assert.assertTrue(false, "Gradable icon is present but practice icon is missing");

        } else if (!gradableIcon.contains("gradable.png") && practiceIcon.contains("practice_icon.png")) {
            Assert.assertTrue(false, "practice icon is present but Gradable icon is missing");
        }

    }

    public void verifyStudentAbleToSeeStatus() {

        Assert.assertTrue(element("SubmittedPresent").isDisplayed(), "Submitted status not displaying ");
        Assert.assertTrue(element("DueSoonPresent").isDisplayed(), "DueSoon status Present is not displaying ");
        waitForElementPresent("NavButtonRight");
        element("NavButtonRight").click();
        Assert.assertTrue(element("inProgressPresent").isDisplayed(), "inProgress status is not displaying ");
        element("NavButtonLeft").click();
        element("NavButtonLeft").click();

    }

    public Boolean verifyPerformanceWiggetTitle() {

        String title = element("PerformanceWidgetTitle").getText();
        if (title.contains("RECENT ACTIVITY SCORES")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyPerformanceScoresGreen() {

        waitTOSync();
        String good = driver.findElement(By.xpath(".//*[@class='good']")).getCssValue("fill");
        waitTOSync();
        waitTOSync();
        driver.findElement(By.xpath("(//*[@class='good'])[1]")).click();
        String value = driver.findElement(By.xpath(".//*[@id='perfPopup-0']/div[2]/p/span")).getText();
        System.out.println("value is (avg) " + value);
        int len = value.length();
        String valueScore = value.substring(len - 4, len - 1);
        System.out.println("value1 " + valueScore);
        int scoreGreen = Integer.parseInt(valueScore);
        System.out.println("final value " + scoreGreen);

        if (scoreGreen >= 90) {
            good.equalsIgnoreCase("rgb(155, 202, 67)");
            executeJavascript("document.getElementById('allScores').click();");
            element("apphidebtn", "Progress").click();
            waitTOSync();
            waitTOSync();
            return true;
        } else {
            return false;
        }

    }

    public boolean verifyPerformanceScoresYellow() {

        waitTOSync();
        String fair = driver.findElement(By.xpath(".//*[@class='fair']")).getCssValue("fill");
        //driver.findElement(By.xpath("")).click();
        clickOnElementUsingActionBuilder(element("YellowDot"));
        waitTOSync();
        waitTOSync();
        String valueY = driver.findElement(By.xpath(".//*[@id='perfPopup-1']/div[2]/p/span")).getText();
        System.out.println("value is (avg) " + valueY);
        int len = valueY.length();
        String valueScore = valueY.substring(len - 3, len - 1);
        System.out.println("value1 " + valueScore);
        int scoreYellow = Integer.parseInt(valueScore);
        System.out.println("final value " + scoreYellow);
        //driver.findElement(By.xpath(".//*[id='performanceChart']")).click();
        if (scoreYellow >= 70 && scoreYellow <= 89) {
            fair.equalsIgnoreCase("rgb(240, 170, 48)");
            executeJavascript("document.getElementById('allScores').click();");
            element("apphidebtn", "Progress").click();
            waitTOSync();
            waitTOSync();
            return true;
        } else {
            return false;
        }

    }

    public boolean verifyPerformanceScoresRed() {

        waitTOSync();
        String fail = driver.findElement(By.xpath(".//*[@class='fail']")).getCssValue("fill");
        driver.findElement(By.xpath("(//*[@class='fail'])[2]")).click();
        waitTOSync();
        waitTOSync();
        String value = driver.findElement(By.xpath(".//*[@id='perfPopup-5']/div[2]/p/span")).getText();
        System.out.println("value is (avg) " + value);

        int len = value.length();
        String valueScore = value.substring(len - 3, len - 1);
        System.out.println("value1 " + valueScore);
        int score = Integer.parseInt(valueScore);
        System.out.println("final value " + score);

        if (score <= 69) {
            fail.equalsIgnoreCase("rgb(239, 0, 0)");
            return true;
        } else {
            return false;
        }

    }

    public boolean verifyDotLength() {

        int dotLength = elements("dotLength").size();
        if (dotLength == 9) {
            return true;
        } else {
            return false;
        }

    }

    public boolean verifyGrayDot() {

        waitTOSync();
        waitTOSync();
        String notGraded = element("notGraded").getCssValue("color").toString();
        waitTOSync();
        //System.out.println("notGraded color "+notGraded);
        if (notGraded.equalsIgnoreCase("rgb(63,63,63)")) {
            return true;
        } else {
            return false;
        }

    }

    public void verifyPopUpInformation() {

        waitTOSync();
        waitTOSync();
        //element("notGraded").click();
        clickOnElementUsingActionBuilder(element("notGraded"));
        waitTOSync();
        String Score = element("notGradedAttempt").getText();
        Assert.assertTrue(element("notGradedAttempt").isDisplayed(), "score and attemp is not displaying");
        System.out.println("Score and attempt : " + Score);
        waitTOSync();
        Assert.assertTrue(element("notGradedDate").isDisplayed(), "Time is not displaying");
        String Date = element("notGradedDate").getText();
        System.out.println("Score and attempt : " + Date);
    }

    public void verifySearchAppLaunch() {
        waitForElementPresent("search_app_tips_txt");
        Assert.assertEquals(element("search_app_tips_txt").getText(), "What Can I Search For?");

    }

    public boolean verifyUserssuccessfullyLogsInToTheApplication() {
        return element("getCengageLogo").isDisplayed();
    }

    public void addActivityDescriptionAndTitle(String title, String text) {
        waitForSpinnerToDisappear();
        element("add_title").click();
        element("add_title").clear();
        element("add_title").sendKeys(title);
        ReportMsg.info("User added the title of the Activity");
        element("add_Discription").click();
        element("add_Discription").clear();
        element("add_Discription").sendKeys(text);
        ReportMsg.info("User define the discription of the Activity");
        selectOrder("1");
        element("saveActivity_btn").click();
        ReportMsg.info("User clicked on save button and added the Activity");
    }

    public void clickOnDistinctActivityEditButton(String activity_title) {
        String bookClassName = element("lpnActivity_link", activity_title).getAttribute("class");
        executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByClassName('nb_edit')[0].style.display = 'block';");
        isElementDisplayed("activityEdit_icon", activity_title);
        clickOnElementUsingActionBuilder(element("activityEdit_icon", activity_title));
    }

    public void closeActivity() {

        element("close_Activity").click();
    }

    public void verifyAccountIsDeleted() {
        element("myContent").click();
        switchToDockIFrame();
        String head = element("mycontent_title").getText();
        if (head.contains("Kaltura"));
        driver.findElement(By.xpath("//a[contains(@title,'Google Drive')]")).click();
        switchToAppIFrame();
        element("signIn_btn").click();
        Assert.assertTrue(element("signIn_btn").isDisplayed(), "Sign in button not displaying ");

    }

    public void removeInLineArgs(String inLineArgs) {

        int title = elements("nb_thumbTitle").size();
        for (int i = 0; i < title; i++) {
            if (elements("nb_thumbTitle").get(i).getText().equalsIgnoreCase(inLineArgs)) {
                System.out.println("Test: " + elements("nb_thumbTitle").get(i).getText());
                element("Remove_InLine", String.valueOf(i + 1)).click();
                System.out.println("Instructor clicked on remove button");
                handleAlert();
            }
        }
    }

     
     public String mindtapLogo() {
        isElementDisplayed("mtlogo");
        String imgsrc = element("mtlogo").getAttribute("src");
        //System.out.println("****"+imgsrc+"******");
        return imgsrc;
    }
         
     
     
  

    public void verifyOrder(String position) {
        scrollDown(element("selectMenu_Order"));
        element("selectMenu_Order").click();
        ReportMsg.info("User clicked on select menu to select the position of the activity");
        element("selectPosition", position).click();
        ReportMsg.info("user clicked on order dropdown");
        element("verifyLocation").getText().contains("0:");
        ReportMsg.info("user verify the location of the added activity");
    }

    public void addToTopFolderUnit(String folderName) {
        scrollDown(element("addtolocation"));
        element("addtolocation").click();
        wait.hardWait(3);
        System.out.println(folderName);
        List<WebElement> ele = elements("selectChapter");
        for (int i = 0; i < ele.size(); i++) {
            wait.hardWait(1);
            scrollDown(ele.get(i));
            //System.out.println(ele.get(i).getText());
            if (ele.get(i).getText().contains(folderName)) {
                ele.get(i).click();
                break;
            }

        }
     //   scrollDown(element("addLocation"));
      //  System.out.println(isElementDisplayed(element("addLocation")));

       // System.out.println("*******&&&&&&&&**********" + element("addLocation").getAttribute("id"));
        //executeJavascript("$('#" + element("addLocation").getAttribute("id") + "').mousedown().mouseup();");
        ReportMsg.info("User set the location of the activity");
       

    }
    public void verifyActivityContainer() {
    element("activitycontainer").isDisplayed();
    }

    
    public void scrolltoactivity(){
        scrollDown(element("nonmindtapactivity"));
        System.out.println("Scrolled page down");
    }
    
     public void findscrollbardposition(){
                 
JavascriptExecutor jse = (JavascriptExecutor)driver;
JavascriptExecutor executor = (JavascriptExecutor) driver;
Long value = (Long) executor.executeScript("return window.scrollY;");
       System.out.println("Value of scrollbarpostion is: "+value);
   }

}
