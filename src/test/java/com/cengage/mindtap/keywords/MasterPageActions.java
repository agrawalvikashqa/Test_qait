/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.qait.automation.utils.PropFileHandler;
import com.qait.automation.utils.ReportMsg;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author QAI
 */
public class MasterPageActions extends BasePageActions {

    String MasterURLPath = "/static/nb/ui/admin/masters/masters.html";
    String CourseKey = getData("Books.course.courseKey");
    String CourseName = getData("Books.course.courseName");

    public MasterPageActions(WebDriver driver) {
        super(driver, "MasterPage");
    }

    public void verifyuserIsOnMastersPage() {
        verifyPageTitleContains();
        ReportMsg.pass("Verified User is on Masters Page");
    }

    public void clickOnCreateMasterButton() {
        isElementDisplayed("admin_btn");
        fireOnClickJsEvent("adminCreate showCreate createButton");
    }

    public void clickOnOrganizationTab() {
        element("org_btn").click();
        //clickOnElementUsingActionBuilder(element("org_btn"));
    }

    public void enterCoursekey(String CourseKey) {
        waitTOSync();
        waitTOSync();
        clickOnElementUsingActionBuilder(element("search_txt"));
        element("search_txt").clear();
        element("search_txt").sendKeys(CourseKey);
        Reporter.log("User Entered course key in search field");
    }

    public void ClickOnOrg() {
        waitTOSync();
        waitTOSync();
        waitForElementPresent("course_org");
        click(element("course_org"));
//clickOnElementUsingActionBuilder(element("course_org"));
        //element("course_org").click();
        Reporter.log("User clicked on organization");
        executeJavascript("(document.getElementsByClassName('orgtitle title searchHighlightable'))[0].click();");
        Reporter.log("User clicked on organization");
    }

    public void ClickOnCourse() {
        waitForElementPresent("org_link");
        executeJavascript("(document.getElementsByClassName('coursetitle searchHighlightable title'))[0].click();");
        Reporter.log("User clicked on organization");
    }

    public void ClickOnCourse(String CourseName) {
        wait.hardWait(5);
        clickOnElementUsingActionBuilder(element("course_name", CourseName));
        Reporter.log("User clicked on course");
    }

    public void ClickOnCourseFromAdmin() {
        wait.hardWait(5);
        clickOnElementUsingActionBuilder(element("course_name"));
        Reporter.log("User clicked on course");
    }

    public void LaunchSnapshotFromAdmin() {
        waitForElementPresent("course_admin");
        executeJavascript("(document.getElementsByClassName('selectSnapshot title'))[0].click();");
        Reporter.log("User launched the snapshot");
    }

    public void enterMasterBookDetailsAndSubmit(String bookName, String description, String coreTextISBN, String mode) {
        element("masterBookName_txt").clear();
        element("masterBookName_txt").sendKeys(bookName);
        element("masterLPName_txt").clear();
        element("masterLPName_txt").sendKeys(bookName + "-" + coreTextISBN);
        element("masterDescription_txt").sendKeys(description);
        element("coreTextISBN_txt").sendKeys(coreTextISBN);
        if (mode.equalsIgnoreCase("course")) {
            element("courseMode_Btn").click();
        }
        element("saveMaster_Btn").click();
        waitForSpinnerToDisappear();
    }

    public boolean verifyMasterBookCreated(String bookName) {
        waitForSpinnerToDisappear();
        return isElementDisplayed("masterBookTitle_link", bookName);
    }

    public boolean naviagteToMasterPage(String environment) {
        waitForSpinnerToDisappear();
        driver.get(environment + MasterURLPath);
        isElementDisplayed("masters_link");
        return element("masters_link").getAttribute("class").contains("active");
    }

    public void enterBookNameAndUnpublishedButtonToSearch(String bookName) {
        isElementDisplayed("bookList_container");
        wait.hardWait(5);
        element("bookSearch_inputBox").click();
        element("bookSearch_inputBox").clear();
        wait.hardWait(5);
        element("bookSearch_inputBox").sendKeys(bookName);
        isElementDisplayed(element("unpublished_btn"));
        element("unpublished_btn").click();
        wait.hardWait(10);
    }

    public void clickOnModeValueIcon(String mode) {
        waitTOSync();
        isElementDisplayed(element("modeValue_btn", mode));
        element("modeValue_btn", mode).click();
        waitTOSync();
        isElementDisplayed(element("modeValueActivated_btn", mode));
        wait.hardWait(15);

    }

    public void launchMasterBook(String bookName) {
        waitTOSync();

        for (WebElement searchBookTitle : elements("searchBookResults_list")) {
            if (searchBookTitle.getText().equals(bookName)) {
                System.out.println("Book Title:" + searchBookTitle.getText());
                System.out.println(searchBookTitle.getText());
                searchBookTitle.click();
                break;
            }

        }
    }

    public boolean searchMasterBook(String bookName) {

        Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='numresults']")));
        dropdown.selectByVisibleText("10 Rows");
        waitTOSync();
        int countMaster = 0;
        for (WebElement searchBookTitle : elements("searchBookResults_list")) {
            if (searchBookTitle.getText().equals(bookName)) {
                //System.out.println("Book Title:" + searchBookTitle.getText());
                //System.out.println(searchBookTitle.getText());
                //searchBookTitle.click();
                countMaster = countMaster + 1;
            }
        }

        if (countMaster == 20) {
            return true;

        } else {
            return false;
        }

    }

    public void verifyStatus(String bookName) {

        for (WebElement searchBookTitle : elements("statusOption_list")) {
            searchBookTitle.click();
            Assert.assertTrue(element("statusVerify_cover").isDisplayed());
            Assert.assertTrue(element("statusVerify_Reader").isDisplayed());
            Assert.assertTrue(element("statusVerify_Media").isDisplayed());
            Assert.assertTrue(element("statusVerify_Metadata").isDisplayed());
            break;

        }
    }

// public int getBookModifyOption(String searchTerm, String option) {
//     int optionNumber = 0;
//        int optionsCount = 0;
//        int i = 0;
//        switch (option) {
//            case "Refresh":
//            case "refresh":
//                optionNumber = 0;
//                option = "Refresh";
//                break;
//            case "Publish":
//            case "publish":
//                optionNumber = 1;
//                option = "Publish Master";
//                break;
//            case "Edit":
//            case "edit":
//                optionNumber = 2;
//                option = "Edit";
//                break;
//            case "Delete":
//            case "delete":
//                optionNumber = 3;
//                option = "Delete";
//                break;
//            case "Provision Apps":
//            case "provision apps":
//                optionNumber = 4;
//                option = "Provision Apps";
//                break;
//            default:
//                optionNumber = 0;
//     return optionNumber;
// }
    public void clickBookModifyOption(String searchTerm, String option, String role) {
        int optionNumber = 0;
        int optionsCount = 0;
        int i = 0;
        optionNumber = findoptionNumber(option, role);

        List<WebElement> masterBook_list = driver.findElements(By.xpath("//li[contains(@class, 'item  master admin_models_master')]"));
        for (WebElement masterBook : masterBook_list) {
            System.out.println("In masterBook ");
            //if (masterBook.findElement(By.xpath("(//div/div[@class='listText']/a)[2]")).getText().equals(searchTerm)  || masterBook.findElement(By.xpath("//div/div[@class='listText']/a")).getText().equals(searchTerm)) {
            if (masterBook.findElement(By.xpath("//div/div[@class='listText']/a")).getText().equals(searchTerm)) {
                System.out.println("In IF ");
                String bookClassName = masterBook.getAttribute("class");
                System.out.println("optionCount : " + optionNumber);
                executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByTagName('a')[" + optionNumber + "].style.display = 'block';");
                wait.hardWait(2);
                for (WebElement option1 : elements("masterBookControlOptions_list", option)) {
                    try {
                        System.out.println("optionCount : " + optionNumber);
                        System.out.println(option1.getAttribute("alt"));
                        System.out.println(option);
                        if (option1.isDisplayed() && option1.getAttribute("alt").equals(option)) {
                            System.out.println("optionCount : " + optionNumber);
                            executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByTagName('a')[" + optionNumber + "].style.display = 'block';");
                            hover(option1);
                            clickOnElementUsingActionBuilder(option1);

                            if (option.equals("Delete")) {
                                handleAlert();
                                wait.hardWait(20);
                            }
                            break;
                        }
                    } catch (ElementNotFoundException e) {
                        System.out.println("Options are not available to Click");
                    }
                }
                break;
            }
        }
    }

    public void editProvisionAppsButton(String title, String appRegistryOption1) {
//        try {
//            String bookClassName = driver.findElement(By.xpath("//div[@class='title' and contains(text(),'" + appRegistryOption1 + "')]/../..")).getAttribute("class");
//            executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByTagName('a')[0].style.display = 'block';");
//            isElementDisplayed(element("addProvision_btn", appRegistryOption1));
//            element("addProvision_btn", appRegistryOption1).click();
//            System.out.println("App provisioned");
//        } catch (ElementNotFoundException | TimeoutException e) {
//            System.out.println("Already provisioned");
//        }
    }

    public void ProvisionAppsButton(String title, String appRegistryOption1) {
        try {
            String bookClassName = driver.findElement(By.xpath("//div[@class='title' and contains(text(),'" + appRegistryOption1 + "')]/../..")).getAttribute("class");
            executeJavascript("document.getElementsByClassName('" + bookClassName + "')[0].getElementsByTagName('a')[0].style.display = 'block';");
            isElementDisplayed(element("addProvision_btn", appRegistryOption1));
            element("addProvision_btn", appRegistryOption1).click();
            System.out.println("App provisioned");

        } catch (ElementNotFoundException | TimeoutException e) {
            System.out.println("Already provisioned");

        }
    }

    public void logOutFromMasterPage() {
        element("logout_link").click();
    }

    public boolean verifyuserMastersTab(String searchTerm, String metadata, String role) {
        clickonMasterTab();
        return verifyMasterTabUI(searchTerm, role);

    }

    public void clickonMasterTab() {
        element("MasterTab").click();
    }

    private boolean verifyMasterTabUI(String searchTerm, String role) {
        searchBookOnMastersPage(searchTerm);
        clickBookModifyOption(searchTerm, "refresh", role);
        closeRefresh();
        clickBookModifyOption(searchTerm, "edit", role);
        closeEdit();
        //clickBookModifyOption(searchTerm ,"delete");
        clickBookModifyOption(searchTerm, "Provision Apps", role);
        verifiyAppLibraryIcon();
        return true;
    }

    /**
     * Search book on masters page.
     *
     * @param searchTerm the search term
     */
    public void searchBookOnMastersPage(String searchTerm) {
        //waitForElementDisplayed(By.cssSelector(".listContainer"));
        //To avoid stale element exception
        driver.findElements(By.cssSelector(".listContainer"));
        element("neXtBookSearch_inputBox").click();
        element("neXtBookSearchInputBoxActivated").click();
        element("neXtBookSearchInputBoxActivated").clear();
        element("neXtBookSearchInputBoxActivated").sendKeys(searchTerm);
        waitTOSync();
        waitForSpinnerToDisappear();
        element("notPublished_btn").click();
        try {
            resetImplicitTimeout(1);
            waitForSpinnerToDisappear();
            resetImplicitTimeout(AJAX_WAIT);
        } catch (Exception e) {
        }
    }

    public boolean verifyuserAppLibraryTab() {
        clickonAppLibraryTab();
        return true;
    }

    public boolean verifyuserOrganisationTab() {

        clickonOrganisationTab();
        return true;
    }

    public boolean verifySettingTab() {

        clickonSettingTab();
        return true;
    }

    private void clickonAppLibraryTab() {
        element("AppLibararyTab").click();
        VerifyAppLibraryUI();
    }

    private void clickonOrganisationTab() {
        element("OrganistationTab").click();
        VerifyOrganisationField();
    }

    private void VerifyOrganisationField() {
        element("Organisation_SearchField").isDisplayed();
    }

    private void VerifyAppLibraryUI() {
        element("DeployAppButton").isDisplayed();
        element("categoriesAppButton").isDisplayed();
    }

    private void clickonSettingTab() {
        element("SettingTab").click();
        VerifySettingFeild();
    }

    private void VerifySettingFeild() {
        element("defstyle").isDisplayed();
        element("masstyle").isDisplayed();
        element("mindtap").isDisplayed();
        element("knewton").isDisplayed();
        element("companyInfo").isDisplayed();
        element("productInfo").isDisplayed();
        element("manageAnnouncementsLink").isDisplayed();
    }

    private void closeRefresh() {

        driver.findElement(By.xpath("//a[@title='Close']")).click();

    }

    private void closeEdit() {

        driver.findElement(By.xpath("//a[@class='nb_closeIcon nb_closeRight']")).click();

    }

    public Boolean verifiyAppLibraryIcon() {

        try {

            driver.findElement(By.xpath("//*[@class='deployApp']"));
            return false;
        } catch (Exception e) {
            return true;
        }

    }

    /**
     * Returns True when flow is Successfully verified.
     *
     * @param searchTerm
     * @param item
     * @param role
     * @return
     */
    public boolean verifyRefreshButtonInMastersTab(String searchTerm, String item, String role) {
        searchBookOnMastersPage(searchTerm);
        clickBookModifyOption(searchTerm, item, role);
        if (role.equalsIgnoreCase("reviewer") || role.equalsIgnoreCase("courseCare")) {
            try {
                closeRefresh();
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        closeRefresh();
        return true;
    }

    /**
     * Returns True when flow is Successfully verified.
     *
     * @param searchTerm
     * @param item
     * @return
     */
    public boolean verifyEditButtonInMastersTab(String searchTerm, String item, String role) {
        searchBookOnMastersPage(searchTerm);
        clickBookModifyOption(searchTerm, item, role);
        closeEdit();
        return true;
    }

    private int findoptionNumber(String option, String role) {
        int optionNumber = 0;
        if (role.contains("admin")) {
            switch (option) {
                case "Refresh":
                case "refresh":
                    optionNumber = 0;
                    option = "Refresh";
                    break;
                case "Publish":
                case "publish":
                    optionNumber = 1;
                    option = "Publish Master";
                    break;
                case "Edit":
                case "edit":
                    optionNumber = 2;
                    option = "Edit";
                    break;
                case "Delete":
                case "delete":
                    optionNumber = 3;
                    option = "Delete";
                    break;
                case "Provision Apps":
                case "provision apps":
                    optionNumber = 4;
                    option = "Provision Apps";
                    break;
                default:
                    optionNumber = 0;
            }
        } else if (role.contains("vendor")) {
            switch (option) {
                case "Refresh":
                case "refresh":
                    optionNumber = 0;
                    option = "Refresh";
                    break;
                case "Edit":
                case "edit":
                    optionNumber = 1;
                    option = "Edit";
                    break;
            }
        } else if (role.contains("productionUser")) {
            switch (option) {
                case "Refresh":
                case "refresh":
                    optionNumber = 0;
                    option = "Refresh";
                    break;
                case "Publish":
                case "publish":
                    optionNumber = 1;
                    option = "Publish Master";
                    break;
                case "Edit":
                case "edit":
                    optionNumber = 2;
                    option = "Edit";
                    break;
                case "Delete":
                case "delete":
                    optionNumber = 3;
                    option = "Delete";
                    break;
                case "Provision Apps":
                case "provision apps":
                    optionNumber = 4;
                    option = "Provision Apps";
                    break;
                default:
                    optionNumber = 0;
            }
        } else if (role.contains("editor")) {
            switch (option) {
                case "Refresh":
                case "refresh":
                    optionNumber = 0;
                    option = "Refresh";
                    break;
                case "Edit":
                case "edit":
                    optionNumber = 1;
                    option = "Edit";
                    break;
            }
        }
        if (role.contains("courseCare")) {
            switch (option) {
                case "Refresh":
                case "refresh":
                    optionNumber = 0;
                    option = "Refresh";
                    break;
                case "Publish":
                case "publish":
                    optionNumber = 1;
                    option = "Publish Master";
                    break;
                case "Edit":
                case "edit":
                    optionNumber = 2;
                    option = "Edit";
                    break;
                case "Delete":
                case "delete":
                    optionNumber = 3;
                    option = "Delete";
                    break;
                case "Provision Apps":
                case "provision apps":
                    optionNumber = 4;
                    option = "Provision Apps";
                    break;
                default:
                    optionNumber = 0;
            }
        }
        return optionNumber;
    }

    public boolean VerifyCreateMasterBookNotPresent() {
        try {
            isElementDisplayed("admin_btn");
            fireOnClickJsEvent("adminCreate showCreate createButton");
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    public void InmpersonateToOtherUser(String User) {
        clickOncourseUsersIcon();
        SelectInmpersonateToOtherUser(User);
        clickOnGoToCourseButton();
    }

    private void clickOncourseUsersIcon() {
        executeJavascript("document.getElementsByClassName('courseUsersIcon')[0].click();");
    }

    private void SelectInmpersonateToOtherUser(String User) {
        waitTOSync();
        element("impersonateUser", User).click();
    }

    private void clickOnGoToCourseButton() {
        waitTOSync();
        waitForElementPresent("go-to-course_btn");
        executeJavascript("document.getElementById('go-to-course').click();");

    }

    public boolean verifyDeleteButtonInMastersTab(String searchTerm, String item, String role) {
        searchBookOnMastersPage(searchTerm);
        clickBookModifyOption(searchTerm, item, role);
        return true;
    }

    public void clickOnWorkingCopyButton() {
        executeJavascript("document.getElementsByClassName('delitem ui-button clui-wcopy')[0].click();");
    }

    public void clickOnShowCopyButton() {
        element("showcopy_btn").click();
    }

    public void enterBookNameAndSearch(String bookName) {
        isElementDisplayed("bookList_container");
        wait.hardWait(5);
        element("bookSearch_inputBox").click();
        element("bookSearch_inputBox").clear();
        wait.hardWait(5);
        element("bookSearch_inputBox").sendKeys(bookName);
        wait.hardWait(10);

    }

    public void clickOnPushToSnapshotButton() {
        //element("pushtosnapshot_btn").click();
        executeJavascript("document.getElementsByClassName('delitem ui-button clui-copyAnnotationsToSnapshots')[0].click();");
    }

    public void closePushToSnapshotWindow() {
        driver.findElement(By.xpath("//a[@title='Close']")).click();
    }

    public boolean verifyP2SWindow() {
        element("p2s_window").isDisplayed();
        element("p2s_update_content").isDisplayed();
        element("p2s_update_annotations").isDisplayed();
        if (elements("p2s_display_options").size() == 2 && elements("p2s_notdisplay_options").size() == 3) {
            System.out.println("Only 2 options are displayed");
            return true;
        } else {
            System.out.println("More than 2 options are displayed");
            return false;
        }

    }

    public void clickOnSaveToMasterButton() {
        element("savetomaster_btn").click();
        waitForSpinnerToDisappear();
    }

    public void ClickOnEditSettings(String organizationsName) {
        int countorg = 0;
        for (WebElement organizationsNames : elements("organizationsNames")) {
            if (organizationsNames.getText().equals(organizationsName)) {
                break;
            }
            countorg = countorg + 1;
        }
        System.out.println("countorg:- " + countorg);

        executeJavascript("document.getElementsByClassName(\"editSettings\")[" + countorg + "].click();");

    }

    public void upLoadFile(String filePath) {

        element("logoUpload_textBox").sendKeys(filePath);
        element("logoUploadButton").click();
    }

    public boolean verifyupLoadFileOnAdminDashboard() {
        boolean flag = false;
        try {
            flag = element("imagePreview").isDisplayed();
        } catch (Exception e) {
        }
        return flag;
    }

    public void closeEditSettingsDialog() {
        element("closeEditSettingsBtn").click();
    }

    public boolean verifyupLoadFileOnLPN() {
        boolean flag = false;
        try {
            PropFileHandler.writeProperty("logoInstituteLocation", element("logoInstitute").getAttribute("src"));
            System.out.println(element("logoInstitute").getAttribute("src"));
            flag = element("logoInstitute").isDisplayed();
        } catch (Exception e) {
        }
        return flag;
    }

    public boolean verifyNewupLoadFileOnLPN() {
        String logoInstitutesrc = null;
        String logoInstituteLocation = null;
        try {
            System.out.println("[DEBUG LOGS]" + element("logoInstitute").getAttribute("src"));
            System.out.println("[DEBUG LOGS]" + PropFileHandler.readProperty("logoInstituteLocation"));
            logoInstitutesrc = element("logoInstitute").getAttribute("src");
            logoInstituteLocation = PropFileHandler.readProperty("logoInstituteLocation");
        } catch (Exception e) {
        }
        if (logoInstitutesrc.contains(logoInstituteLocation)) {
            return false;
        } else {
            return true;
        }
    }

    public void DeleteFile() {
        element("logoDeleteButton").click();
    }
}
