/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mindtap.tests.ReaderScenarios;


import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * 
 * @author QAI
 */
public class TC_05_InstructorPrintReaderScenarios {
    
    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");
    String user;
    

    @BeforeClass
    public void start_test_session() {
        test = new TestSessionInitiator("Instructor Print Scenarios test");
        user = System.getProperty("user", "instructor");
       }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
   
    
  @Test
    public void TestStep_02_verifyReaderPrintIconWorkingFine(){
        test.DashBoardPage.clickOnView("Unit View");
        test.readingPage.launchReadingActivityToAddInLineActivity(getData("Books.courseWebLink.unitName"), getData("Books.courseWebLink.chapterName"));
        Reporter.log(user+" successfully Navigate To Chapter Reading Activity",true);
        test.FramesPage.switchToMainFrame();
        Assert.assertTrue(test.readingPage.verifyPrintIconWorkingFine(),"Print Icon is not working fine");
        test.readingPage.printSection_ContentVerify();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.closeOpenApp();
        test.DashBoardPage.closeActivity();
        Reporter.log("Print Icon  is working fine",true);
    }
    
    @Test
    public void TestStep_03_verifyFullBookPrintIconWorkingFine(){
        test.DashBoardPage.refreshPage();
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAppByName("Full Book");
        Reporter.log(user+"  successfully Launch Full Book App From App Dock",true);
        test.FramesPage.switchToDockIFrame();
        test.fullBookPage.clickOnNextButton();
        test.fullBookPage.clickOnPrintSelection();
        test.readingPage.verifyFullBookPrintIconWorkingFine();
        test.readingPage.clickOnEscButton();
        test.printPage.verifyTopCopyrightHeader(getData(("users."+user+".username")));
        test.printPage.verifyBottomCopyrightHeader(getData(("users."+user+".username")));
        test.readingPage.entireSection_ContentVerify();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.closeOpenApp();
        test.DashBoardPage.closeOpenApp();
        Reporter.log("Print Icon  is working fine for fullbook",true);
  }
    
    @Test
    public void TestStep_04_verifyServiceAgreementPrintIconWorkingFine(){
        test.FramesPage.switchToDefaultContent();
        test.printPage.clickOnCengageLogo();
        test.printPage.clickOnServiceAgreement();
        test.printPage.clickOnSLAPrintIcon();
        test.printPage.verifySLAPrintPreview();
        Reporter.log("Print Icon  is working fine for SLA Page",true);
  }
    
    
    

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
    
     @AfterClass(alwaysRun = true)
    public void stop_test_session() {
        test.closeTestSession();
    }
    
}
