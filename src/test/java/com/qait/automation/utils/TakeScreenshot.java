/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.qait.automation.utils.ConfigPropertyReader.getProperty;

/**
 *
 * @author prashantshukla
 */
public class TakeScreenshot {

    WebDriver driver;
    String testname;
    String screenshotPath = "/target/Screenshots";

    public TakeScreenshot(String testname, WebDriver driver) {
        this.driver = driver;
        this.testname = testname;
    }

    public void takeScreenshot() {
        screenshotPath = (getProperty("screenshot-path") != null) ? getProperty("screenshot-path") : screenshotPath;
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_a");
        Date date = new Date();
        String date_time = dateFormat.format(date);
        File file = new File(System.getProperty("user.dir") + File.separator + screenshotPath + File.separator + this.testname
                + File.separator + date_time);
        boolean exists = file.exists();
        if (!exists) {
            new File(System.getProperty("user.dir") + File.separator + screenshotPath + File.separator + this.testname
                    + File.separator + date_time).mkdir();
        }

        File scrFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        try {
            String saveImgFile = System.getProperty("user.dir") + File.separator + screenshotPath
                    + File.separator + this.testname + File.separator + date_time
                    + File.separator + "screenshot.png";
            Reporter.log("[INFO]: Save Image File Path : " + saveImgFile, true);
            FileUtils.copyFile(scrFile, new File(saveImgFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenShotOnException(ITestResult result) {
        Reporter.log("Test time in secs: " + ((result.getEndMillis() - result.getStartMillis()) / 1000), true);
        String takeScreenshot = getProperty("take-screenshot");
       // System.out.println("********************\n "+result.getMethod().getMethodName()) ;
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("    _____   .     _____  .      .   .  .--.   ____    ");
            System.out.println("   |       . .      |    |      |   |  |  |  |        ");
            System.out.println("   |___   .   .     |    |      |   |  |--   |__      ");
            System.out.println("   |     ._____.    |    |      |   |  |  |  |        ");
            System.out.println("   |    .       . __|__  |____   ...   |  |  |____    ");
            
            if (takeScreenshot.equalsIgnoreCase("true") || takeScreenshot.equalsIgnoreCase("yes")) {
                try {
                    if (driver != null) {
                        takeScreenshot();
                    }
                } catch (Exception ex) {
                    Reporter.log("[TAKESCREENSHOT EXCEPTION]Driver is null while taking screen shot", true);
                }
            }
        }
    }

}
