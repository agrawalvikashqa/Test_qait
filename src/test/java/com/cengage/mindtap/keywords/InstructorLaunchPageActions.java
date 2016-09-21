/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author QAI
 */
public class InstructorLaunchPageActions extends BasePageActions {

    public InstructorLaunchPageActions(WebDriver driver) {
        super(driver, "InstructorResourceCenterPage");
    }
     public void instructorManageCourse() {        
         element("manage_course_link").click();
     }
     
     public void instructorManageCsmCourse() {
         waitForElementPresent("book_link");
         waitForElementPresent("courseName_link");
         isElementDisplayed("manage_csm_course_link");
         clickOnElementUsingActionBuilder(element("manage_csm_course_link"));
     }

    public void instructorLaunchCourse(String courseKey, String env) {
        waitForElementPresent("book_link");
        element("manage_course").click();
        waitForElementPresent("courseName_link");
        String hrefAttribute = element("courseName_link", courseKey).getAttribute("href");
        String[] hrefURL;
        hrefURL = hrefAttribute.split("http.*.ng.cengage.com");
        System.out.println("URL Fetched:\n" + hrefAttribute);
        if (env.equals("STAGE")) {
            System.out.println("Navigated To STAGE Env.");
            System.out.println("http://mindtap-staging.cengage.com" + hrefURL[1]);
            driver.navigate().to("http://mindtap-staging.cengage.com" + hrefURL[1]);
        }
    }

    public void logOutFromSSO() {
        element("signOut_link").click();
    }

}
