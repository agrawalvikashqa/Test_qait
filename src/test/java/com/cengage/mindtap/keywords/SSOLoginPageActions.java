/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import com.qait.automation.utils.ReportMsg;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author QAI
 */
public class SSOLoginPageActions extends BasePageActions{

    public SSOLoginPageActions(WebDriver driver) {
        super(driver, "SSOLoginPage");
    }
    
    public void loginToSSOApplication(String username, String password) {
        element("username_txt").clear();
        element("username_txt").sendKeys(username);
        element("password_txt").clear();
        element("password_txt").sendKeys(password);
        element("signin_btn").click();
        ReportMsg.info("User log into the application using credentials '" + username + " / " + password + "'");
    }

    public void enrollCourseInUser(String user, String courseKey) {
    
            System.out.println("user : "+user);
            System.out.println("Course key : "+courseKey);
        
        if(user.contains("Student"))
        {
        //TODO:
        }
        else if(user.equalsIgnoreCase("instructor"))
        {
        
            waitTOSync();
            element("searchCourseKey").click();
            element("searchCourseKey").clear();
            element("searchCourseKey").sendKeys(courseKey);
            
            element("searchCourseButton").click();
            waitTOSync();
            element("continue").click();
            
        }
        else
        {
            System.out.println("Enter the correct user");
        }
        
        
    }
    
    public void logOutFromSSO(){
        element("signout_link").click();
        waitTOSync();
        waitForElementPresent("signin_btn");
        System.out.println("Successfully Logged Out");
    }
}
