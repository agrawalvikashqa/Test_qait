/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.Chemistry.CXPActivities.StudyGuideFlowTest;

import com.gargoylesoftware.htmlunit.javascript.host.event.Event;
import com.qait.automation.TestInitiator.TestSessionInitiator;
import static com.qait.automation.utils.YamlReader.getData;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author nadeemahmed
 */
public class StudyGuideFlowTest {

    TestSessionInitiator test;
    String user;
    

    /**
     * Sets the up class.
     */
    
    @BeforeClass
        public void start_test_session() {
        test = new TestSessionInitiator("Instructor Study Guide Flow");
        user = System.getProperty("user", "instructor");
    }

   
    @Test
    public void TestStep_01_LoginToSSOApplication() {
        Reporter.log("TC_01 : Verify Instructor logs into Mindtap Application", true);
        test.launchApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")), getData("Books.courseChemistry.courseKey"), getData("Books.courseChemistry.ISBN"));
        Reporter.log(user + "successfully logs in to the application", true);
    }

    
    @Test
	public void TestStep_02_ClickOpenStudyGuide() {
		// Study Guide
                Reporter.log(user + "successfully Clicks Study Guide", true);
		System.out.println("Test_02 : verifyInstructorClicksStudyGuideActivity");
                //test.MTXDashBoardPage.clickOnView("Date Manager View");
		//test.StudyGuidePage.ClickOnStudyGuide();
                test.weekwidgetPage.navigateToWeek("Week 44");
		test.MTXActivityPage.clickOnStudyGuide();
		test.MTXActivityPage.getTitleOfActivity();
                Reporter.log(user + "successfully Clicks On Study Guide", true);
	}
    
    //@Test
	public void TestStep_03_verifyInstructorOpenStudyGuide() {
		// Study Guide
		System.out.println("Test_03 : verifyInstructorStudyGuideActivity");
                test.MTXDashBoardPage.clickOnView("Date Manager View");
		test.StudyGuidePage.StudyGuidePresentInEachUnit();
                //test.MTXActivityPage.getTitleOfActivity();
		//test.MTXActivityPage.verifyKeyConceptsTextPresent();
	}

    
    @Test
    public void TestStep_04_VerifyActivityNumberIsDisplayed() {
        Reporter.log( "Test_04 : Activity Number Is Displayed", true);
        test.StudyGuidePage.activityNumberIsDisplayed();
        Reporter.log(user + "successfully Activity Number Is Displayed", true);
    }

    @Test
    public void TestStep_05_VerifyKeyConceptsIsDisplayed() {
        Reporter.log("Test_05 : Key Concepts Is Displayed", true);
        test.StudyGuidePage.keyConceptsIsDisplayed();
        Reporter.log(user + "successfully finds Key Concepts to be Displayed", true);
    }
    
    @Test
    public void TestStep_06_VerifyKeyEquationIsDisplayed() {
        Reporter.log("Test_06 : Key Equation Is Displayed", true);
        test.StudyGuidePage.KeyEquationIsDisplayed();
        Reporter.log(user + "successfully finds Key Equation to be Displayed", true);
    }
    
    @Test
    public void TestStep_07_VerifyKeyTermHeaderIsDisplayed() {
        Reporter.log("Test_07 : Key Term Header Is Displayed", true);
        test.StudyGuidePage.keyTermHeaderIsDisplayed();
        Reporter.log(user + "successfully finds Key Term Header to be Displayed", true);
    }
    
    @Test
    public void TestStep_08_CrossIconIsDisplayed() {
        Reporter.log("Test_08 : Cross Icon Is Displayed", true);
        test.StudyGuidePage.crossIconIsDisplayed();
        Reporter.log(user + "successfully finds Cross Icon to be Displayed", true);
    }
    
    @Test
    public void TestStep_09_PrintIconIsDisplayed() {
        Reporter.log("Test_09: Print Icon Is Displayed", true);
        test.StudyGuidePage.printIconIsDisplayed();
        Reporter.log(user + "successfully finds Print Icon to be Displayed", true);
    }
    
    
    //The print dialog comes from the os, therefore selenium can't automate it.
     //@Test
    public void TestStep_10_UserIsAbleToPrintStudyGuide() {
        Reporter.log("Test_10: Print StudyGuide", true);
        test.StudyGuidePage.userIsAbleToPrintStudyGuide();
        Reporter.log(user + "successfully Prints StudyGuide", true);
    }
    
    @Test
    public void TestStep_11_ScrollIsWorkingFine() {
        Reporter.log("Test_11: Scrolls Working Fine", true);
        test.StudyGuidePage.scrollworksFine();
        Reporter.log(user + "successfully Scrolls Fine", true);
        
    }
    
    @Test
    public void TestStep_12_BehindStudyCenterStudyGuideDisplays() {
        Reporter.log("Test_12: Behind StudyGuide StudyCentre Launches", true);
        test.StudyGuidePage.behindStudyCenterStudyGuideDisplays();
        Reporter.log(user + "successfully Launches StudyCentre Behind StudyGuide", true);
    }
    
    
    @Test                   
	public void TestStep_13_CloseStudyGuide() {
		// closing the study guide by clicking cross
                Reporter.log(user + "Test_13: Close study guide", true);
		//test.StudyGuidePage.closeStudyGuide();
                test.StudyGuidePage.clickOnCloseActivity();
                Reporter.log(user + "successfully closes StudyCentre", true);
              
        }
    
    
    
}

