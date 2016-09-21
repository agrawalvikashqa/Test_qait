/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.getpageobjects;

import com.qait.automation.utils.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

import static com.qait.automation.getpageobjects.ObjectFileReader.getPageTitleFromFile;
import static com.qait.automation.utils.ConfigPropertyReader.getProperty;

/**
 *
 * @author prashantshukla
 */
public class BaseUi {

    WebDriver driver;
    protected SeleniumWait wait;
    private final String pageName;
    protected DateUtil date;
    protected PropFileHandler data;
    protected ConfigPropertyReader configReader;
    protected ReportMsg Reporter;
    protected YamlReader yml;
    protected String currentwindow;

    protected BaseUi(WebDriver driver, String pageName) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.pageName = pageName;
        this.wait = new SeleniumWait(driver, Integer.parseInt(getProperty(
                "Config.properties", "timeout")));
        this.date = new DateUtil();
        this.data = new PropFileHandler();
        this.configReader = new ConfigPropertyReader();
        this.Reporter = new ReportMsg();
        this.yml = new YamlReader();
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }
    
    public int getTimeOut() {
        return  Integer.parseInt(getProperty("Config.properties", "timeout"));
    }

    protected String getCurrentURL() {
        return driver.getCurrentUrl();
    }
    
    public void waitLong(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    

    protected void verifyPageTitleExact() {
        String pageTitle = getPageTitleFromFile(pageName);
        verifyPageTitleExact(pageTitle);
    }

    protected void verifyPageTitleExact(String expectedPagetitle) {
        if (((expectedPagetitle == "") || (expectedPagetitle == null) || (expectedPagetitle
                .isEmpty()))
                && (getProperty("browser").equalsIgnoreCase("chrome"))) {
            expectedPagetitle = getCurrentURL();
        }
        try {
            wait.waitForPageTitleToBeExact(expectedPagetitle.toString());
            ReportMsg.pass("PageTitle for " + pageName + " is exactly: '"
                    + expectedPagetitle + "'");
        } catch (TimeoutException ex) {
            ReportMsg.fail("PageTitle for " + pageName + " is not exactly: '"
                    + expectedPagetitle + "'!!!\n instead it is :- "
                    + driver.getTitle());
        }
    }

    /**
     * Verification of the page title with the title text provided in the page
     * object repository
     */
    protected void verifyPageTitleContains() {
        String expectedPagetitle = getPageTitleFromFile(pageName).trim();
        verifyPageTitleContains(expectedPagetitle);
    }

    /**
     * this method will get page title of current window and match it partially
     * with the param provided
     *
     * @param expectedPagetitle partial page title text
     */
    protected void verifyPageTitleContains(String expectedPagetitle) {
        if (((expectedPagetitle == "") || (expectedPagetitle == null) || (expectedPagetitle
                .isEmpty()))
                && (getProperty("browser").equalsIgnoreCase("chrome"))) {
            expectedPagetitle = getCurrentURL();
        }
        try {
            wait.waitForPageTitleToContain(expectedPagetitle.toString());
            ReportMsg.pass("PageTitle for " + pageName + " contains: '"
                    + expectedPagetitle + "'.");
        } catch (TimeoutException exp) {
            ReportMsg.fail("As actual Page Title for '" + pageName
                    + "' does not contain expected Page Title : '"
                    + expectedPagetitle + "'.");
        }

    }

    /**
     * this method will get page url of current window and match it partially
     * with the param provided
     *
     * @param expectedPageUrl partial page title text
     */
    protected void verifyPageUrlContains(String expectedPageUrl) {

        wait.waitForPageToLoadCompletely();
        String currenturl = getCurrentURL();
        Assert.assertTrue(
                currenturl.toLowerCase().trim()
                .contains(expectedPageUrl.toLowerCase()),
                ReportMsg.info("verifying: URL - " + currenturl
                + " of the page '" + pageName + "' contains: "
                + expectedPageUrl));
        ReportMsg.pass("URL of the page " + pageName + " contains:- "
                + expectedPageUrl);

    }

    protected WebElement getElementByIndex(List<WebElement> elementlist,
            int index) {
        return elementlist.get(index);
    }

    protected WebElement getElementByExactText(List<WebElement> elementlist,
            String elementtext) {
        WebElement element = null;
        for (WebElement elem : elementlist) {
            if (elem.getText().equalsIgnoreCase(elementtext.trim())) {
                element = elem;
            }
        }
        // FIXME: handle if no element with the text is found in list No element
        // exception
        if (element == null) {
        }
        return element;
    }

    protected WebElement getElementByContainsText(List<WebElement> elementlist,
            String elementtext) {
        WebElement element = null;
        for (WebElement elem : elementlist) {
            if (elem.getText().contains(elementtext.trim())) {
                element = elem;
            }
        }
        // FIXME: handle if no element with the text is found in list
        if (element == null) {
        }
        return element;
    }

    protected void switchToFrame(WebElement element) {
        switchToDefaultContent();
        wait.waitForElementToBeVisible(element);
        driver.switchTo().frame(element);
        System.out.println("Switched to Frame");
    }
     protected void switchToFrameWithOutDefault(WebElement element) {
        wait.waitForElementToBeVisible(element);
        driver.switchTo().frame(element);
        System.out.println("Switched to Frame");
    }

    public void switchToFrame(int i) {
        driver.switchTo().frame(i);
    }

    public void switchToFrame(String id) {
        driver.switchTo().frame(id);

    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    protected void executeJavascript(String script) {
        ((JavascriptExecutor) driver).executeScript(script);
    }

    protected Object executeJavascriptWithReturn(String script) {
        return ((JavascriptExecutor) driver).executeScript("return " + script);
    }

    protected void executeJavascript(String script, WebElement e) {
        ((JavascriptExecutor) driver).executeScript(script, e);
    }

    protected void fireOnClickJsEvent(String elementRef) {
        fireOnClickJsEvent(elementRef, "0");
    }

    protected void fireOnClickJsEvent(String elementRef, String index) {
        ((JavascriptExecutor) driver).executeScript(""
                + "var elem = document.getElementsByClassName('" + elementRef + "')[" + index + "];"
                + "if( document.createEvent ) { "
                + "   var evObj = document.createEvent('MouseEvents');"
                + "    evObj.initEvent( 'click', true, false );"
                + "   elem.dispatchEvent(evObj);"
                + "} else if( document.createEventObject ) {"
                + "    elem.fireEvent('onclick');"
                + "}"
                + "");
    }

    protected void hover(WebElement element) {
        Actions hoverOver = new Actions(driver);
        hoverOver.moveToElement(element).build().perform();
        hoverOver.perform();
    }

    protected void hoverUsingJS(WebElement element) {
        String javaScript = "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "arguments[0].dispatchEvent(evObj);";
        ((JavascriptExecutor) driver).executeScript(javaScript, element);
    }

    protected void handleAlert() {
        try {
            //System.out.println(switchToAlert().getText());
            switchToAlert().accept();
            ReportMsg.info("Alert handled..");
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            //That's Fine . Its not your fault.
            System.out.println("No Alert window appeared...");
        }
    }
    protected void handleAlertClose() {
        try {
            //System.out.println(switchToAlert().getText());
            switchToAlert().dismiss();
            ReportMsg.info("Alert handled..");
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            //That's Fine . Its not your fault.
            System.out.println("No Alert window appeared...");
        }
    }

    protected void changeWindow(int i) {
        Set<String> windows = driver.getWindowHandles();
        if (i > 0) {
            for (int j = 0; j < 9; j++) {
                System.out.println("Windows: " + windows.size());

                if (windows.size() >= 2) {
                    try {
                        Thread.sleep(5000);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                }
                windows = driver.getWindowHandles();
            }
        }
        String wins[] = windows.toArray(new String[windows.size()]);
        driver.switchTo().window(wins[i]);

        System.out.println("Title: "
                + driver.switchTo().window(wins[i]).getTitle());
    }

    protected void changeWindow(String windowName) {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            String windowTitle = driver.switchTo().window(handle).getTitle();
            System.out.println(driver.switchTo().window(handle).getTitle());
            if (windowTitle.contains(windowName)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    protected Alert switchToAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    protected void selectProvidedTextFromDropDown(WebElement el, String text) {
        wait.waitForElementToBeVisible(el);
        scrollDown(el);
        Select sel = new Select(el);
        sel.selectByVisibleText(text);
    }

    protected void selectProvidedText(WebElement el, String text) {
        wait.waitForElementToBeVisible(el);
        Select sel = new Select(el);
        sel.selectByVisibleText(text);
    }

    protected void selectProvidedValue(WebElement el, String value) {
        wait.waitForElementToBeVisible(el);
        Select sel = new Select(el);
        sel.selectByValue(value);
    }

    protected void scrollDown(WebElement element) {
        //((JavascriptExecutor) driver).executeScript(
                //"arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }
    
    protected void scrollToDelete(WebElement element) {
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0, -100000)");
                
	((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
                
	jse.executeScript("window.scrollBy(0,-350)");
    }

    protected void hoverClick(WebElement element) {
        Actions hoverClick = new Actions(driver);
        hoverClick.moveToElement(element).click().build().perform();
    }

    protected void click(WebElement element) {
        try {
            wait.waitForElementToBeVisible(element);
            scrollDown(element);
            element.click();
        } catch (StaleElementReferenceException ex1) {
            wait.waitForElementToBeVisible(element);
            scrollDown(element);
            element.click();
            ReportMsg.info("Clicked Element " + element
                    + " after catching Stale Element Exception");
        } catch (Exception ex2) {
            ReportMsg.info("Element " + element + " could not be clicked! "
                    + ex2.getMessage());
        }
    }

    protected void getURL(String Url) {
        driver.get(Url);
    }

    public String pageTitle() {
        return driver.getTitle();
    }

    protected String[] parseUrl(WebElement element) {
        wait.waitForPageToLoadCompletely();
        wait.waitForElementToBeVisible(element);
        return element.getText().split("/");
    }

    public void refreshPage() {
        
        driver.navigate().refresh();
        waitTOSync();
        waitTOSync();
        Reporter.log("Page is refreshed");
    }

    public void closeWindow() {
        driver.close();
    }

    public void getCurrentWindow() {
        currentwindow = driver.getWindowHandle();
    }

    public void switchToCurrentWindow() {
        driver.switchTo().window(currentwindow);
    }

    protected void clickOnElementUsingActionBuilder(WebElement element) {
        Actions builder = new Actions(driver);
        Actions MenuItems = builder.moveToElement(element);
        waitTOSync();
        MenuItems.click().build().perform();
        waitTOSync();
    }

    protected void waitTOSync() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
