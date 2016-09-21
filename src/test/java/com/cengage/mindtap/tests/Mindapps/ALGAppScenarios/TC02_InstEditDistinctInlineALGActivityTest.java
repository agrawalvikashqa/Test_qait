/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.tests.Mindapps.ALGAppScenarios;

import com.qait.automation.TestInitiator.TestSessionInitiator;
import com.qait.automation.getpageobjects.ObjectFileReader;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.qait.automation.utils.YamlReader.getData;

/**
 *
 * @author QAI
 */
public class TC02_InstEditDistinctInlineALGActivityTest {
TestSessionInitiator test;
        String tier = ObjectFileReader.getTier().replaceAll("/", "");

        String user;
        String userStudent; 
        String description = getData("learningActivities.ALG.description");
        String title = getData("learningActivities.ALG.title");
        String newDescription = getData("learningActivities.ALG.newDescription");
        String newTitle = getData("learningActivities.ALG.newTitle");
        String inlinetitle = getData("learningActivities.ALG.inlinetitle");
        String inlinenewTitle = getData("learningActivities.ALG.inlinenewTitle");
        
        @BeforeClass
        public void start_test_session() {
            Reporter.log("Jira Ticket:- https://jira.cengage.com/browse/NG-33125", true);
            test = new TestSessionInitiator("ALG App Test");
            user = System.getProperty("user", "instructor");
          }

    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users."+user+".username")), getData(("users."+user+".password")),getData("Books.courseAA.courseKey"),getData("Books.courseAA.ISBN"));
        Reporter.log(user+"successfully logs in to the application",true); 
    }
    @Test
    public void TestStep_02_instructorEditDistinctALGActivity() {
        test.DashBoardPage.clickOnView("Unit View");
        test.DashBoardPage.editDistinctActivityNoEdit(title);
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addActivityDiscriptionAndTitle(newTitle , newDescription);    
}
    @Test
    public void TestStep_03_launchReadingActivuty() {
     test.DashBoardPage.clickOnView("Unit View");
     test.readingPage.launchReadingActivityToAddInLineActivity(getData("learningActivities.ALG.unitName"), getData("learningActivities.ALG.chapterName"));
    }
    @Test
    public void TestStep_04_editInlineALGActivity() {
        test.FramesPage.switchToMainFrame();
        test.readingPage.navigateToChapterIntroductionPage();
        test.readingPage.clickOnEditMode();
        //test.ALGAppPage.clickOnInlineEditIconAndEditActivity();
        test.FramesPage.switchToDefaultContent();
        test.DashBoardPage.addInlineActivityDiscriptionAndTitle(inlinenewTitle , newDescription);
        Reporter.log(" inline activity edited successfully",true);
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
