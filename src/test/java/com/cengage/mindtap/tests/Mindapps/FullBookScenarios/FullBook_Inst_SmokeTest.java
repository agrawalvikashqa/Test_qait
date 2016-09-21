/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.FullBookScenarios;


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
public class FullBook_Inst_SmokeTest {

    TestSessionInitiator test;
    String tier = ObjectFileReader.getTier().replaceAll("/", "");

    String user;

    @BeforeClass
    public void start_test_session() {
        //Reporter.log("Jira Ticket: https://jira.cengage.com/browse/NG-32693", true);
        test = new TestSessionInitiator("Full Book App check Test");
        user = System.getProperty("user", "instructor");
    }

     @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.course.courseKey"),getData("Books.course.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true);
    }
    /*This test case covers:
     *Verifying of Full Book App
     **/
    @Test
    public void TestStep_02_LaunchAppFromAppDock() {
        //test.DashBoardPage.clickOnAllApps();
        test.DashBoardPage.clickOnAppByName("Full Book");
        Reporter.log(user+"  successfully Launch Full Book App From App Dock",true);
    }
   @Test
	public void TestStep_03_verifyFullBookUI() {
		test.fullBookPage.verifyFullBookUI();
                System.out.println("TestStep_04_verifyFullBookUI");
	Reporter.log(user+"  successfully Verified Full Book UI",true);
        }

   @Test
	public void TestStep_04_verifyButtonOnFullBook() {
		test.fullBookPage.buttonOnFullBook();
        Reporter.log(user+"  successfully Verified Button On Full Book",true);
        }

    @Test
	public void TestStep_05_verifyClickOnNextButton() {
		test.fullBookPage.clickOnNextButton();
        Reporter.log(user+"  successfully Verified Click On Next Button On Full Book",true);
        }

    @Test
	public void TestStep_06_verifyClickOnBackButton() {
		test.fullBookPage.clickOnBackButton();
        Reporter.log(user+"  successfully Verified Click On Back Button On Full Book",true);
        }

    @Test
	public void TestStep_07_verifyClickOnChaptersButton() {
		test.fullBookPage.clickOnChaptersButton();
        Reporter.log(user+"  successfully Verified Click On Chapters Button On Full Book",true);
        }

    @Test
	public void TestStep_08_verifyFontSelection() {
		test.fullBookPage.clickOnFontSelection();
        Reporter.log(user+"  successfully Verified Font Selection On Full Book",true);
        }
    @Test
	public void TestStep_09_verifyPrintSelection() {
		test.fullBookPage.clickOnPrintSelection();
                test.FramesPage.switchToDefaultContent();
               // test.FramesPage.switchToDockIFrame();
                Assert.assertTrue(test.fullBookPage.verifyClickOnPrintSelection());
                test.DashBoardPage.closeOpenApp();
        Reporter.log(user+"  successfully Verified Print Selection On Full Book",true);
	}

    @Test
	public void TestStep_10_verifyHelpButton() {
                test.FramesPage.switchToDockIFrame();
		test.fullBookPage.clickOnHelpButton();
        Reporter.log(user+"  successfully Verified Click On Help Button On Full Book",true);
        }

    @Test
	public void TestStep_11_verifyChapterOpened() {
		test.fullBookPage.verifyChapterOpened();
	Reporter.log(user+"  successfully Verified Chapter Open and end() On Full Book",true);
        }


    @AfterClass(alwaysRun = true)
    public void stop_test_session() {
        test.closeTestSession();
    }


    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
    
}
