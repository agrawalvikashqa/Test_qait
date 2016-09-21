/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.tests.Chemistry.CXPActivities.ChemistryRefrence;


import com.qait.automation.TestInitiator.TestSessionInitiator;
import static com.qait.automation.utils.YamlReader.getData;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author archittayal
 */
public class InstructorChemistryReferenceTest {

    TestSessionInitiator test;
    String user;
    

    /**
     * Sets the up class.
     */
    
    @BeforeClass
        public void start_test_session() {
        Reporter.log("Jira Ticket: ", true);
        test = new TestSessionInitiator("Chemistry Reference Regression Test");
        user = System.getProperty("user", "instructor");
    }

   
    @Test
    public void TestStep_01_LoginToSSOApplication() {
        test.launchApplication(getData(("users." + user + ".username")), getData(("users." + user + ".password")), getData("Books.courseChemistry.courseKey"), getData("Books.courseChemistry.ISBN"));
        Reporter.log(user + "successfully logs in to the application", true);
    }

    /**
     * TC003_verify user redirect to student dashboard display.
     */
   
    @Test
    public void TestStep_02_LaunchChemistryReference() {
        Reporter.log(user + "Test Name: LaunchChemistryReference", true);
        //System.out.println("Test Name: LaunchChemistryReference");
        test.ChemistryReferencePage.clickOnChemistryReference();
        Reporter.log(user + "successfully launches Chemistry Reference", true);
    }

    @Test
    public void TestStep_03_VerifyChemistryReference() {
       System.out.println("Test Name: VerifyChemistryReference");
        test.ChemistryReferencePage.verifyChemistryRefPage();
        Reporter.log(user + "successfully Verify Chemistry Reference Page", true);
    }

    @Test
    public void TestStep_04_clickOnElements() {
        Reporter.log(user + "Test Name: Click On Elements", true);
        test.ChemistryReferencePage.clickOnElements();
        Reporter.log(user + "successfully Clicks On Elements Button", true);
    }

    @Test
    public void TestStep_05_ClickOnPeriodicTable() {
        Reporter.log(user + "Test Name: Click On Periodic Table", true);
        test.ChemistryReferencePage.ClickOnPeriodicTable();
        Reporter.log(user + "successfully Clicks On Periodic Table Button", true);
        test.ChemistryReferencePage.CloseChemReferencePage();
    }

    @Test
    public void TestStep_06_ClickOnStandardAtomicWeight() {
        Reporter.log(user + "Test Name: Click On Standard And Atomic Weight", true);
        test.ChemistryReferencePage.clickOnChemistryReference();
        test.ChemistryReferencePage.clickOnElements();
        test.ChemistryReferencePage.ClickOnStandardAtomicWeight();
        Reporter.log(user + "successfully Clicks On Standard Atomic Weight Button", true);
        test.ChemistryReferencePage.CloseChemReferencePage();
    }

    @Test
    public void TestStep_07_ClickOnEquilibriumConstant() {
        Reporter.log(user + "Test Name: Click On Equillibrim Constant", true);
        test.ChemistryReferencePage.clickOnChemistryReference();
        test.ChemistryReferencePage.ClickOnEquillibriumConstants();
        Reporter.log(user + "successfully Clicks On Equilibrium Constant Button", true);
        
    }

    //@Test
    public void TestStep_08_ClickOnAcidAndBase() {
        Reporter.log(user + "Test Name: Click On Acid And Base", true);
        test.ChemistryReferencePage.ClickOnAcidAndBase();
        Reporter.log(user + "successfully Clicks On Acid and base Button", true);
        test.ChemistryReferencePage.CloseChemReferencePage();
    }

   @Test
    public void TestStep_09_ClickOnSolubility() { 
        Reporter.log(user + "Test Name: Click On Solubility", true);
        test.ChemistryReferencePage.clickOnChemistryReference();
        test.ChemistryReferencePage.ClickOnEquillibriumConstants();
        test.ChemistryReferencePage.ClickOnSolubility();
        Reporter.log(user + "successfully Clicks On Solubility Button", true);
    }

    @Test
    public void TestStep_10_ClickOnElectrochemistry() {
        Reporter.log(user + "Test Name: Click On Electrochemistry", true);
        test.ChemistryReferencePage.ClickOnElectrochemistry();
        Reporter.log(user + "successfully Clicks On Electrochemistry Button", true);
    }

    @Test
    public void TestStep_11_ClickOnStandard() {
        Reporter.log(user + "Test Name: Click On Standard", true);
        test.ChemistryReferencePage.ClickOnStandard();
        Reporter.log(user + "successfully Clicks On Standard Button", true);
        test.ChemistryReferencePage.CloseChemReferencePage();
    }

    @Test
    public void TestStep_12_ClickOnThermodynamics() {
        Reporter.log(user + "Test Name: Click On Thermodynmaics Tab", true);
        test.ChemistryReferencePage.clickOnChemistryReference();
        test.ChemistryReferencePage.ClickOnThermodynamics();
        Reporter.log(user + "successfully Clicks On Thermodynamics Button", true);
    }

    @Test
    public void TestStep_13_ClickOnBondEnthalapies() {
        Reporter.log(user + "Test Name: Click On Bond Enthalapies", true);
        test.ChemistryReferencePage.ClickOnBondEnthalapies();
        Reporter.log(user + "successfully Clicks On Bond Enthalapies Button", true);
        test.ChemistryReferencePage.CloseChemReferencePage();
    }

    @Test
    public void TestStep_14_ClickOnSpecificHeats() {
        Reporter.log(user + "Test Name: Click On Specific Heats", true);
        test.ChemistryReferencePage.clickOnChemistryReference();
        test.ChemistryReferencePage.ClickOnThermodynamics();
        test.ChemistryReferencePage.ClickOnSpecificHeats();
        Reporter.log(user + "successfully Clicks On Specific Heats Button", true);
        test.ChemistryReferencePage.CloseChemReferencePage();
    }

    //@Test
    public void TestStep_15_ClickOnThermodynamicsData() {
        Reporter.log(user + "Test Name: Click On Thermodynamics Data", true);
        test.ChemistryReferencePage.clickOnChemistryReference();
        test.ChemistryReferencePage.ClickOnThermodynamics();
        test.ChemistryReferencePage.ClickOnThermodynamicsData();
        Reporter.log(user + "successfully Clicks On Thermodynamics Data Button", true);
        test.ChemistryReferencePage.CloseChemReferencePage();
    }

    //@Test
    public void TestStep_16_ClickOnMolecularStructure() {
        Reporter.log(user + "Test Name: Click On Molecular Structure", true);
        test.ChemistryReferencePage.clickOnChemistryReference();
        test.ChemistryReferencePage.ClickOnMolecularStructure();
        Reporter.log(user + "successfully Clicks On Molecular Structure Button", true);
    }

    //@Test
    public void TestStep_17_ClickOnDrawingLewis() {
        Reporter.log(user + "Test Name: Click On Drawing Lewis", true);
        test.ChemistryReferencePage.ClickOnDrawingLewis();
        Reporter.log(user + "successfully Clicks On Drawing Lewis Button", true);
        test.ChemistryReferencePage.CloseChemReferencePage();
    }

    //@Test
    public void TestStep_18_ClickOnValence24Pair() {
        Reporter.log(user + "Test Name: Click On Valence Pair 24 Pair", true);
        test.ChemistryReferencePage.clickOnChemistryReference();
        test.ChemistryReferencePage.ClickOnMolecularStructure();
        test.ChemistryReferencePage.ClickOnValencepair24pair();
        Reporter.log(user + "successfully Clicks On Valence 24 pair Button", true);
        test.ChemistryReferencePage.CloseChemReferencePage();
    }

    //@Test
    public void TestStep_19_ClickOnValence56Pair() {
        Reporter.log(user + "Test Name: Click On Valence 56 pair", true);
        test.ChemistryReferencePage.clickOnChemistryReference();
        test.ChemistryReferencePage.ClickOnMolecularStructure();
        test.ChemistryReferencePage.ClickOnVal56pair();
        Reporter.log(user + "successfully Clicks On Valence 56 pair Button", true);
        test.ChemistryReferencePage.CloseChemReferencePage();
        
    }

    //@Test
    public void TestStep_20_ClickOnOtherTables() {
        Reporter.log(user + "Test Name: Click On Other Tables", true);
        test.ChemistryReferencePage.clickOnChemistryReference();
        test.ChemistryReferencePage.ClickOnOtherTables();
        Reporter.log(user + "successfully Clicks On Other Tables Button", true);
    }

    //@Test
    public void TestStep_21_ClickOnVapourPressure() {
        Reporter.log(user + "Test Name: Click On Vapour Pressure", true);
      
        test.ChemistryReferencePage.ClickOnVapourPressure();
        Reporter.log(user + "successfully Clicks On Vapour Pressure Button", true);
        test.ChemistryReferencePage.CloseChemReferencePage();
    }

    //@Test
    public void TestStep_22_ClickOnConstantTables() {
        Reporter.log(user + "Test Name: Click On Constant Tables", true);
        test.ChemistryReferencePage.clickOnChemistryReference();
        test.ChemistryReferencePage.ClickOnOtherTables();
        test.ChemistryReferencePage.ClickOnConstantTable();
        Reporter.log(user + "successfully Clicks On constant Table Button", true);
        test.ChemistryReferencePage.CloseChemReferencePage();
        
    }
    
    //@Test
    public void TestStep_23_ClickZoomInButton() {
        Reporter.log(user + "Test Name: Click On Zoom In Button", true);
        test.ChemistryReferencePage.clickOnChemistryReference();
        test.MTXFramePage.switchToPeriodictableIFrame();
        test.ChemistryReferencePage.ClickZoomInButton();
        Reporter.log(user + "successfully Clicks On Zoom In Button", true);
    }
    
    //@Test
    public void TestStep_24_ClickZoomOutButton() {
        Reporter.log(user + "Test Name: Click On Zoom Out Button", true);
        test.MTXFramePage.switchToPeriodictableIFrame();
        test.ChemistryReferencePage.ClickZoomOutButton();
        Reporter.log(user + "successfully Clicks On Zoom OUt Button", true);
    }

    //@Test
    public void TestStep_25_ClickResetButton() {
        Reporter.log(user + "Test Name: Click On Reset Button", true);
        test.MTXFramePage.switchToPeriodictableIFrame();
        test.ChemistryReferencePage.ClickOnResetButton();
        Reporter.log(user + "successfully Clicks On Reset Button", true);
    }
    
    @Test
    public void TestStep_26_ClickToCloseChemReferencePage() {
        Reporter.log(user + "Test Name: Click On arrow to close Chemistry Ref Page", true);
        test.ChemistryReferencePage.CloseChemReferencePage();
        Reporter.log(user + "successfully Clicks On arrow to Close Chemistry reference page", true);
    }
    
    @AfterClass(alwaysRun = true)
    public void stop_test_session() {
     //   test.closeTestSession();
    }
}
