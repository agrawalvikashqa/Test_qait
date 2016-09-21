/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.Mindapps.GenericAppDock;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author chandanjyot
 */
public class TC_03GenericAppDockStudentTest  {
    
     TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;

     @BeforeClass
    public void start_test_session() {
        Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32935", true);
        test = new TestSessionInitiator("Generic App Dock");
        user = System.getProperty("user", "student");
      
    }
  @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    
    @Test
    public void TestStep_03_AppDockPresent(){
        test.GenericAppDockPage.appDockDisplay();
    }
    
    @Test
    public void TestStep_04_AppDockExpandedbyDefault(){
        test.GenericAppDockPage.appDockExpand();
    }
    
    @Test 
    public void TestStep_05_MoreLessLinkPresent(){
        test.GenericAppDockPage.moreLessLink();
        
    }
    
    @Test
    public void TestStep_06_HideAppDock(){
        test.GenericAppDockPage.appdockHide();
        test.GenericAppDockPage.verifyHideAppDock();
        
    }
    
    @Test
    public void TestStep_07_LaunchAppDock(){
        test.GenericAppDockPage.appdockHide();
    }
    
    @AfterClass(alwaysRun = true)
    public void stop_test_session() {
        test.closeTestSession();
    }

    
    
    
}

    

