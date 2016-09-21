/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cengage.mtx.keywords;

import com.cengage.mindtap.keywords.*;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author QAI
 */
public class ChemistryReferencePageActions extends BasePageActions {

    public ChemistryReferencePageActions(WebDriver driver) {
        super(driver, "ChemistryReferencePage");
    }

    public void clickOnChemistryReference() {
        waitTOSync();
        element("chemistry_reference").click();
        switchToFrame(element("App_dockFrame").getAttribute("id"));
        waitTOSync();
        switchToDefaultContent();
        
    }

    public void verifyChemistryRefPage() {
        waitTOSync();
        //waitForElementPresent("verify_chemistry_refpage");
        element("verify_chemistry_refpage").isDisplayed();
        //Assert.assertTrue(isElementDisplayed("verify_chemistry_refpage"));
        waitTOSync();
        Assert.assertEquals(element("verify_chemistry_refpage").getText(), "CHEMISTRY REFERENCE");

    }

    public void clickOnElements() {
        switchToDefaultContent();
        switchToFrame(element("referenceframe"));
        
        waitForElementPresent("click_elements");
        executeJavascript("document.getElementsByClassName('dropdown-toggle')[0].click();");
        
    
    }

    public void ClickOnPeriodicTable() {
        waitForElementPresent("click_elem_periodic");
        element("click_elem_periodic").click();
        waitTOSync();
    }

    public void ClickOnStandardAtomicWeight() {
        waitTOSync();
        //element("click_elem_Standard").click();
        clickOnElementUsingActionBuilder(element("click_elem_Standard"));
        
    }

    public void ClickOnEquillibriumConstants() {
        //Assert.assertTrue(element("click_equilibrium").isDisplayed());
        waitForElementPresent("click_equilibrium");
        switchToDefaultContent();
        switchToFrame(element("referenceframe"));
        wait.hardWait(2);
        executeJavascript("document.getElementsByClassName('dropdown-toggle')[1].click()");
//        wait.waitForElementToBeVisible(elementWithoutWait("click_acid"));
       // executeJavascript("window[0].document.getElementsByClassName('dropdown-toggle')[1].click()");
//        wait.waitForElementToBeVisible(elementWithoutWait("click_equilibrium"));
        //wait.hardWait(2);
        System.out.println("**************************************");
        //executeJavascript("window[0].document.getElementsByClassName('dropdown-toggle')[1].click()");
        //switchToFrame(element("referenceframe"));
       //wait.waitForElementToBeVisible(elementWithoutWait("click_solubility"));
        //clickOnElementUsingActionBuilder(element("click_equilibrium"));
        System.out.println("Clicked on Equilibrium");
        waitTOSync();

    }

    public void ClickOnAcidAndBase() {
        waitForElementPresent("click_acid");
        executeJavascript("document.getElementsByTagName('li')[4].click();");
//element("click_acid").click();
        System.out.println("Clicked on Acid and Base");
        waitTOSync();

    }

    public void ClickOnSolubility() {
        //clickOnElementUsingActionBuilder(element("click_solubility"));
        waitForElementPresent("click_solubility");
        clickOnElementUsingActionBuilder(element("click_solubility"));
        //element("click_solubility").click();
       System.out.println("Clicked on Solubility");

    }

    public void ClickOnElectrochemistry() {
        Assert.assertTrue(element("click_electrochemistry").isDisplayed());
        waitForElementPresent("click_electrochemistry");
        //executeJavascript("document.getElementsByClassName('dropdown-toggle')[2].click();");
        element("click_electrochemistry").click();
        System.out.println("Clicked on Electrochemistry");

    }

    public void ClickOnStandard() {
        waitForElementPresent("click_standard");
        clickOnElementUsingActionBuilder(element("click_standard"));
        //element("click_standard").click();
        System.out.println("Clicked on Standard");

    }

    public void ClickOnThermodynamics() {
        //Assert.assertTrue(element("click_thermodynamic").isDisplayed());
        waitForElementPresent("click_thermodynamic");
        //executeJavascript("document.getElementsByClassName('dropdown-toggle')[3].click();");
        waitTOSync();
        element("click_thermodynamic").click();
        //clickOnElementUsingActionBuilder(element("click_thermodynamic"));
        System.out.println("Clicked on Thermodynamic");

    }

    public void ClickOnBondEnthalapies() {
        waitTOSync();
        element("bondEnthalapies_click").click();
    }

    public void ClickOnSpecificHeats() {
        waitTOSync();
        element("click_specificHeats").click();
    }

    public void ClickOnThermodynamicsData() {
        element("click_Datathermodynamics").click();

    }

    public void ClickOnMolecularStructure() {
        Assert.assertTrue(element("click_molecularStructure").isDisplayed());
        waitForElementPresent("click_molecularStructure");
        //executeJavascript("document.getElementsByClassName('dropdown-toggle')[4].click();");
        element("click_molecularStructure").click();
        System.out.println("Clicked on molecularStructure");

    }

    public void ClickOnDrawingLewis() {
        element("click_drawingLewis").click();

    }

    public void ClickOnValencepair24pair() {
        element("click_geometryValence24pair").click();

    }

    public void ClickOnVal56pair() {
        element("click_geometryVal56pair").click();

    }

    public void ClickOnOtherTables() {
        Assert.assertTrue(element("click_OtherTables").isDisplayed());
        waitForElementPresent("click_OtherTables");
        //executeJavascript("document.getElementsByClassName('dropdown-toggle')[5].click();");
        element("click_OtherTables").click();
        System.out.println("Clicked on OtherTables");

    }

    public void ClickOnVapourPressure() {
        element("click_vapourPressure").click();

    }

    public void ClickOnConstantTable() {
        element("click_contantTable").click();

    }
    
     public void ClickZoomInButton() {
         //element("Click_ZoomInButton").click();
         //clickOnElementUsingActionBuilder(element("Click_ZoomInButton"));
         //Assert.assertTrue(element("Click_ZoomInButton").isDisplayed());
         isElementDisplayed(element("Click_ZoomInButton"));
        
     }
     
     public void ClickZoomOutButton() {
        //element("Click_ZoomOutButton").click();
       //aert.assertTrue(element("Click_ZoomOutButton").isDisplayed());
         isElementDisplayed(element("Click_ZoomOutButton"));
        
     }
     
     public void ClickOnResetButton() {
        //Assert.assertTrue(element("Click_ResetButton").isDisplayed());
        //element("Click_ResetButton").click();
        isElementDisplayed(element("Click_ResetButton"));
        
     }
    
    public void ClickPrintButton() {
        //element("Click_PrintButton").click();
        isElementDisplayed(element("Click_PrintButton"));

    }
    
    public void CloseChemReferencePage() {
        switchToDefaultContent();
        waitForElementPresent("close_chemRef");
        element("close_chemRef").click();

    }    
}