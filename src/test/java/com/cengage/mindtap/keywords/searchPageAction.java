/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 *
 * @author QAI
 */
public class searchPageAction  extends BasePageActions{
    String[] chaptersName = new String[36];
     /** The page no search title. */
    String pageNoSearchTitle;    /*Comment 'pageNoSearchTitle' required for page verification in verifyPageNo() method */
    
            
   public searchPageAction(WebDriver driver) {
        super(driver, "searchPage");
    }

   public void verifySearchforReaderBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public void verifyReaderSearchResultsareClickable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   /**
     * Search by page no.
     *
     * @param searchTerm the search term
     */
   public void searchByPageNo(String searchTerm){
        performSearchOperationAndClickOnSearchButtonForPageNo(searchTerm);
        selectPageNo(searchTerm);
    }
 /**
     * Verify search application
     */
   public  void verifySearchApp(){
        if(element("searchapp").isDisplayed()){
            executeJavascript("document.getElementById('app_Search').click()");
            waitForElementPresent("panelName");
            String panel=element("panelName").getText();
            Assert.assertTrue(panel.equalsIgnoreCase("Search"), "Actual Value = " + panel + "  Expected Value = Search");
            waitTOSync();
            Assert.assertTrue(element("inputSearch").isDisplayed()); 
            Assert.assertTrue(element("hide").isDisplayed()); 
            
        }
    }

    /**
     * Perform search operation and click on search button for page no.
     *
     * @param name the name
     */
    void performSearchOperationAndClickOnSearchButtonForPageNo(String name){
        //assert waitForElementPresent(By.cssSelector(".search"));
        waitForElementPresent("search");
        element("inputSearch").clear();
        element("inputSearch").sendKeys(name);
        waitForElementPresent("search_btn");
        element("search_btn").click();
       }
    /**
     * Select page no.
     *
     * @param searchTerm the search term
     */
   public void selectPageNo(String searchTerm){
        waitForElementPresent("suggestion_box");

        //******** Search for the Term amongst the list ***********
        for(WebElement searchItem: elements("suggestion_list")){
            if(searchItem.getText().contains(searchTerm)){
                pageNoSearchTitle = searchItem.findElement(By.xpath(".//div[@class='hit-highlights']")).getText();
                Reporter.log("Searched Page Title = " + pageNoSearchTitle);
                searchItem.findElement(By.xpath(".//div[@class='info']/*[@class='name']")).click();
                break;
            }
        }
    }
    /**
     * Verify page no.
     *
     * @return true, if successful
     */
    public boolean verifySearchByPageNumber(){
        switchToDockIFrame();
        waitForSpinnerToDisappear();
        String text = element("ebook_document").getText();
        Reporter.log("Text = " + text);
        Reporter.log("Page No Search Title = " + pageNoSearchTitle);
        deselectFrame();
        return (pageNoSearchTitle.contains(text));
    } 

    /**
     * Select search term.
     *
     * @param searchTerm the search term
     */
   public void selectSearchByTerm(String searchTerm){
        performSearchOperationAndClickOnSearchButton(searchTerm);
        selectSearchTerm(searchTerm);
       
    }
    
   /**
     * Verify text highlighted.
     *
     * @param searchTerm the search term
     * @return true, if successful
     */
    public boolean verifyTextHighlighted(String searchTerm){
        boolean flag = false;
        searchTerm = searchTerm.toUpperCase();
       // switchToMainIFrame();
         List<WebElement> highlightField_list = driver.findElements(By.xpath("//span[@class='searchHighlight']"));
        for(WebElement highlight: highlightField_list){
            Reporter.log("Actual Text = " + highlight.getText() + "   Expected Result = " + searchTerm);
            if(highlight.getText().toUpperCase().contains(searchTerm)){
                flag = true;
                break;
            }
        }
        deselectFrame();
        return flag;
    }

       
    /**
     * Select search term.
     *
     * @param searchTerm the search term
     */
    public void selectSearchTerm(String searchTerm){
        waitForElementPresent("suggestion_box");
        searchTerm = searchTerm.toUpperCase();
        boolean flag = true;
        while(flag){
            List<WebElement> suggestion_list = driver.findElements(By.xpath("//div[@class='hits']//ul/li"));
            for(WebElement searchItem: suggestion_list){
                try {
                   searchItem.findElement(By.xpath(".//div[@class='hit-highlights']")).click();
                   System.out.println(searchItem.getText()+"Test Passed");
                   flag = false;
                   break;
                } catch (Exception e) {
                    continue;
                }
            }
            //***** Click on Show More button if text not found ********
            if(flag = true){
                System.out.println("Test Failing");
                try{
                    //To avoid stale element exception
                    driver.findElement(By.className("showMore"));
                    element("showMore_btn").click();
                }catch(Exception e ){
                    flag = false;
                }
            }
        }
        
        //******* Clear the search term from search box *************
       // clearSearchResult();
        //******* Hide the dock app *************
        //clickOnHideApp();
    }

    /**
     * Clear search result.
     */
    void clearSearchResult(){
        //element("clearResult").click();
       // clickOnElementUsingActionBuilder(element("clearResult"));
        //click(element("clearResult"));
           }
    /**
     * Perform search operation and click on search button.
     *
     * @param name the name
     */
    void performSearchOperationAndClickOnSearchButton(String name){
        name = "\"" +name+ "\"";
        //By.cssSelector(".search")
        waitForElementPresent("inputSearch");
        element("inputSearch").clear();
        element("inputSearch").sendKeys(name);
        element("search_btn").click();
    }
   
      
}
