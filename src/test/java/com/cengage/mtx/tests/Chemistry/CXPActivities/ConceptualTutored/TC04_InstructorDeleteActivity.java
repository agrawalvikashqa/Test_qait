
package com.cengage.mtx.tests.Chemistry.CXPActivities.ConceptualTutored;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;
import org.testng.annotations.AfterClass;

public class TC04_InstructorDeleteActivity {
    TestSessionInitiator test;
        String user;
        static String scoreFromActivity =null;
        
        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Smoke Test");
        user = System.getProperty("user", "instructor");
        
    }

	
	@Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseChemistry.courseKey"),getData("Books.courseChemistry.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    @Test
	public void TestStep_02_DeleteActivity() {
		// Delete Activity
		Reporter.log("Test Name: DeleteActivity",true);
		test.DashBoardPage.clickOnView("Unit View");
                test.MTXConceptualTutoredPage.deleteDistinctActivity(getData("Books.courseChemistry.AddTutoredOfUnit"), getData("Books.courseChemistry.activityTutoredRegression"));
                
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
