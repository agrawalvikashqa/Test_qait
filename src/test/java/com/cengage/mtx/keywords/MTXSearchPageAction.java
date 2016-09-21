/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.cengage.mindtap.keywords.BasePageActions;
import org.testng.Assert;

import java.util.List;

/**
 *
 * @author QAI
 */
public class MTXSearchPageAction  extends BasePageActions{
    String[] chaptersName = new String[36];
     /** The page no search title. */
    String pageNoSearchTitle;    /*Comment 'pageNoSearchTitle' required for page verification in verifyPageNo() method */
    
            
   public MTXSearchPageAction(WebDriver driver) {
        super(driver, "MTXsearchPage");
    }

   
   
 /**
     * Verify search application
     */
   public  void verifySearchApp(){
       wait.hardWait(3);
        if(element("searchapp").isDisplayed()){
            executeJavascript("document.getElementById('app_Search').click()");
            waitForElementPresent("panelName");
            String panel=element("panelName").getText();
            Assert.assertTrue(panel.equalsIgnoreCase("Search"), "Actual Value = " + panel + "  Expected Value = Search");
            wait.hardWait(3);
            Assert.assertTrue(element("inputSearch").isDisplayed()); 
            Assert.assertTrue(element("hide").isDisplayed()); 
            
        }
    }
   
   public void launchSearchApp(){
       wait.hardWait(3);
       executeJavascript("document.getElementById('app_Search').click()");
       
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
     * Select search term.
     *
     * @param searchTerm the search term
     */
   public void selectSearchByTerm(String searchTerm){
        performSearchOperationAndClickOnSearchButton(searchTerm);
        
    }
    
   /**
     * Verify text highlighted.
     *
     * @param searchTerm the search term
     * @return true, if successful
     */
//    public boolean verifyTextHighlighted(String searchTerm){
//        boolean flag = false;
//        searchTerm = searchTerm.toUpperCase();
//        switchToMainIFrame();
//         List<WebElement> highlightField_list = driver.findElements(By.xpath("//span[@class='searchHighlight']"));
//        for(WebElement highlight: highlightField_list){
//            Reporter.log("Actual Text = " + highlight.getText() + "   Expected Result = " + searchTerm);
//            if(highlight.getText().toUpperCase().contains(searchTerm)){
//                flag = true;
//                break;
//            }
//        }
//        deselectFrame();
//        return flag;
//    }

       
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
            List<WebElement> suggestion_list = driver.findElements(By.xpath("//div[@class='name']"));
            for(WebElement searchItem: suggestion_list){
                System.out.println(searchItem.getText());
                Assert.assertTrue(searchItem.getText().contains(searchTerm), "Search term is not present in results");
                   // searchItem.findElement(By.xpath(".//div[@class='info']/div[@class='name']")).click();
                    flag = false ;
                    break;
                
            }
            
        }
        
        //******* Clear the search term from search box *************
        clearSearchResult();
        //******* Hide the dock app *************
        //clickOnHideApp();
    }

    /**
     * Clear search result.
     */
    void clearSearchResult(){
        //element("clearResult").click();
        clickOnElementUsingActionBuilder(element("clearResult"));
        //click(element("clearResult"));
           }
    /**
     * Perform search operation and click on search button.
     *
     * @param name the name
     */
    void performSearchOperationAndClickOnSearchButton(String name){
        
        //By.cssSelector(".search")
        waitForElementPresent("inputSearch");
        element("inputSearch").clear();
        element("inputSearch").sendKeys(name);
        element("search_btn").click();
        wait.hardWait(2);
        List <WebElement>searchItem =  driver.findElements(By.xpath("//div[@class='name']"));
            for (WebElement s : searchItem){
            System.out.println("[DEBUG LOG]:"+s.getText());
            Assert.assertTrue(s.getText().contains(name), "Selected text is not present");
        }
        
        clearSearchResult();
        
        
    }
   
      
}
