
package com.cengage.mtx.tests.ReleaseTests.Release3_36_5;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import static com.qait.automation.utils.YamlReader.getData;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NG_33378Test {
    
    TestSessionInitiator test;
        String user;
        static String scoreFromActivity = null;
        
        @BeforeClass
        public void start_test_session() {
        test = new TestSessionInitiator("Verify Assessment Content");
        
        
    }

	@Test
    public void TestStep_01_LoginToSSOApplication() {
       user = System.getProperty("user", "student");
        Reporter.log("Test_01 : Verify Student logs into Mindtap Application",true);
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseHistory.courseKey"),getData("Books.courseHistory.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    @Test
	public void TestStep_02_verifyAssessmentLoading(){
           Reporter.log("Test_13 : verify Assessment Loading",true);
           test.weekwidgetPage.navigateToWeek("Week 44");
           test.MTXDashBoardPage.NG_33378Test();
           Reporter.log("Verified that Student Successfully Launches and close Activity Type Conceptual Narrative",true);          
        }
        
    @Test
	public void TestStep_03_CloseBrowser() {
		test.closeBrowserSession();
		System.out.println("###########################################################################################");
		System.out.println("########################################################################################### \n\n");
	}
        @Test
    public void TestStep_04_LoginToSSOApplication() {
        user = System.getProperty("user", "instructor");
        test = new TestSessionInitiator("Verify Assessment Content");
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseHistory.courseKey"),getData("Books.courseHistory.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true);
    }
    @Test
	public void TestStep_05_verifyProgressApp() {
            Reporter.log("Test Name: verifyInstructorProgressApp",true);
		test.MTXDashBoardPage.clickOnAppByName("Progress");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.ProgressTitle"));
                test.MTXDashBoardPage.verifyProgressApp();
                test.studentTakeDeletePage.DeleteActivityTakes(getData("Books.courseHistory.studentName"));
                test.MTXDashBoardPage.closeOpenApp();
	}
    @Test
	public void TestStep_06_CloseBrowser() {
		test.closeBrowserSession();
		System.out.println("###########################################################################################");
		System.out.println("########################################################################################### \n\n");
	}
        
    @BeforeMethod
	public void init() {
		System.out.println("\n\n__________________________________________________________________________");
	}

    @AfterMethod
    public void takeScreenshotonFailure(ITestResult result) {
        test.takescreenshot.takeScreenShotOnException(result);
    }
}
