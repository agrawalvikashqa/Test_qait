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
public class AdminLoginPageActions extends BasePageActions {

    public AdminLoginPageActions(WebDriver driver) {
        super(driver, "AdminLoginPage");
    }

    public void loginToMindTapApplication(String username, String password) {
        element("inp_username").clear();
        element("inp_username").sendKeys(username);
        element("inp_password").clear();
        element("inp_password").sendKeys(password);
        element("btn_signin").click();
        ReportMsg.info("User log into the application using credentials '" + username + " / " + password + "'");
    }

}
