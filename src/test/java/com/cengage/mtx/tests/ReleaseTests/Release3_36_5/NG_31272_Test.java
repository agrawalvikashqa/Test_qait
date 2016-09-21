
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

public class NG_31272_Test {
    
    TestSessionInitiator test;
        String user;

        @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: NG-31272", true);
        test = new TestSessionInitiator("Verify Wrong Course Name in Analytics");
        user = System.getProperty("user", "instructor");
        
    }

	@Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseChemistry.courseKey"),getData("Books.courseChemistry.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    @Test
	public void TestStep_02_verifyProgressApp() {
            Reporter.log("Test Name: verifyInstructorProgressApp",true);
		test.MTXDashBoardPage.clickOnAppByName("Progress");
                test.MTXFramePage.switchToDockIFrame(getData("Books.courseChemistry.ProgressTitle"));
                test.MTXDashBoardPage.verifyProgressApp();
                test.MTXDashBoardPage.NG_31272Test(getData("Books.courseChemistry.courseName"));
                test.MTXDashBoardPage.closeOpenApp();
	}
    
}
