/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.Chemistry.CXPActivities.ConceptualTutored;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TC01_AdminAddConceptualTutoredActivityFlow {
    
     TestSessionInitiator test;
        String user, bookName;
        static String scoreFromActivity =null;
        
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Add Conceptual Tutored Activity Test");
        user = System.getProperty("user", "adminChemistry");
        bookName = StringUtils.upperCase(user) + "-" + getData("Books.master.masterName");
        test.launchApplication(getData("base_url"));
        
    }
        @Test
    public void TestStep_01_LoginToMindTapApplication() {
        test.adminLoginPage.loginToMindTapApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")));
        test.masterPage.verifyuserIsOnMastersPage();
        Reporter.log(user + " successfully logs in to the application", true);
    }
    @Test 
    
    public void TestStep_02_SearchCourse() {
       Reporter.log("Test Name: SearchCourse",true);
       test.masterPage.clickOnOrganizationTab();
        test.masterPage.enterCoursekey(getData("Books.courseChemistry.courseKey"));  
    }
    @Test
    public void TestStep_03_LaunchCourse() {

        Reporter.log("Test Name: LaunchCourse",true);
        test.masterPage.ClickOnOrg();
        test.masterPage.ClickOnCourseFromAdmin();
        test.masterPage.LaunchSnapshotFromAdmin();
    }
   @Test
    public void TestStep_04_clickOnAddActivityIcon() {

        Reporter.log("Test Name: clickOnAddActivityIcon",true);
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.clickOnAddIconAndAddActivity();
        test.DashBoardPage.verifyAddedActivityHeading();
    }
    @Test
    public void TestStep_05_AddAssessmentActivityToLPN() {

        Reporter.log("Test Name: AddAssessmentActivityToLPN",true);
        test.DashBoardPage.clickOnActivity("Assessment");
        test.FramesPage.switchToDistinctActivityCreateFrame();
        test.MTXConceptualTutoredPage.selectCreationType("Interactive Narrative");
    }
    @Test
    public void TestStep_06_AddQuestionsForActivity() {
        
    }
    
    public void TestStep_06_PublishActivity() {
        Reporter.log("Test Name: PublishActivity",true);
        test.MTXConceptualTutoredPage.SelectActivity(getData("Books.courseChemistry.AddTutoredOfUnit"), getData("Books.courseChemistry.activityTutored"));
        test.MTXConceptualTutoredPage.publishActivity();
        test.MTXConceptualTutoredPage.setDueDate(getData("Books.courseChemistry.dueMonth"), getData("Books.courseChemistry.dueYear"), getData("Books.courseChemistry.dueDate"));
        test.MTXConceptualTutoredPage.addActivityTitle();
        test.DashBoardPage.addToLocation(getData("Books.courseChemistry.AddTutoredOfUnit"));
        test.MediaPage.ClickOnSave();
    }
    @BeforeMethod
	public void init() {
		System.out.println("\n\n__________________________________________________________________________");
	}

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
    @AfterClass
	public void tearDownClass() throws Exception {
		test.closeBrowserSession();
		System.out.println("###########################################################################################");
		System.out.println("########################################################################################### \n\n");
	}
}
