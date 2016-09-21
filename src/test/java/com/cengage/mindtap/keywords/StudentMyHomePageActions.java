/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author QAI
 */
public class StudentMyHomePageActions extends BasePageActions {

    public StudentMyHomePageActions(WebDriver driver) {
        super(driver, "StudentMyHomePage");
    }

    public void studentLaunchCourse(String courseKey, String env) {
        waitForElementPresent("courseAndMaterials_txt");
        waitForElementPresent("open_btn_student");

        try {
        String attValue = element("open_btn", courseKey).getAttribute("onclick");
        String[] url = attValue.split("http.*.ng.cengage.com");
        url = url[1].split("','MTC',");
        if (env.equals("STAGE")) {
            driver.navigate().to("http://mindtap-staging.cengage.com" + url[0]);
            System.out.println("Navigated To Environment :: " + "http://mindtap-staging.cengage.com" + url[0]);
        }
        }catch(Exception e){
        
            waitForElementPresent("open_btn_student");
            element("open_btn_student",courseKey).click();
            String url = driver.findElement(By.xpath("//*[@id='courseURL']")).getAttribute("value");
            //String url =executeJavascriptWithReturn("document.getElementById('courseURL').value;").toString();
            System.out.println(url);
            if (env.equals("STAGE")) {
            driver.navigate().to(url);
            System.out.println("Navigated To Environment :: " + url);
        }
        }
        }
        
    }

