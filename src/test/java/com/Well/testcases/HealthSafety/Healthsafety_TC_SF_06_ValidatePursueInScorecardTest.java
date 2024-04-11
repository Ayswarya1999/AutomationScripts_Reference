package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;
import com.Well.Engine.ScreenRecorderUtil;

public class Healthsafety_TC_SF_06_ValidatePursueInScorecardTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.HealthSafety.Healthsafety_TC_SF_05_SearchV2ProjectByRegisteredStatusTest.Healthsafety_TC_SF_05_SearchV2ProjectByRegisteredStatus"})
	@Parameters({ "Commodity" })
	public void Healthsafety_TC_SF_06_00_Location(String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Importing Locations to HSR Project");

		try {
			generic.importLocationGeneric(Commodity, PortfolioLocationImportfile);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	    @Test(dependsOnMethods = {"com.Well.testcases.HealthSafety.Healthsafety_TC_SF_06_ValidatePursueInScorecard.Healthsafety_TC_SF_06_00_Location"})
	    @Parameters({ "SheetName", "rowNum"})
	    public void Healthsafety_TC_SF_06_01_purseYesValidFromScorecard(String SheetName, int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate purse Yes functionality");
		try {
			rc.clickScorecard();
			hsr.purseYesValidFromScorecard();
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
		@Test(dependsOnMethods = {"com.Well.testcases.HealthSafety.Healthsafety_TC_SF_06_ValidatePursueInScorecard.Healthsafety_TC_SF_06_01_purseYesValidFromScorecard"})
        public void Healthsafety_TC_SF_06_02_purseNoValidFromScorecard() throws IOException {
	    TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	    StartTest(TestCaseName, "Validate purse No functionality");
	    try {
		hsr.purseNoValidFromScorecard();
	    } catch (Throwable t) {
		System.out.println(t.getLocalizedMessage());
		Error e1 = new Error(t.getMessage());
		e1.setStackTrace(t.getStackTrace());
		throw e1;
	    }
	}	

		@Test(dependsOnMethods = {"com.Well.testcases.HealthSafety.Healthsafety_TC_SF_06_ValidatePursueInScorecard.Healthsafety_TC_SF_06_02_purseNoValidFromScorecard"})
        public void Healthsafety_TC_SF_06_03_purseMaybeValidFromScorecard() throws IOException {
	    TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	    StartTest(TestCaseName, "Validate purse Maybe functionality");
	    try {
		hsr.purseMaybeValidFromScorecard();
	    } catch (Throwable t) {
		System.out.println(t.getLocalizedMessage());
		Error e1 = new Error(t.getMessage());
		e1.setStackTrace(t.getStackTrace());
		throw e1;
    	}
     }

        @Test(dependsOnMethods = {"com.Well.testcases.HealthSafety.Healthsafety_TC_SF_06_ValidatePursueInScorecard.Healthsafety_TC_SF_06_03_purseMaybeValidFromScorecard"})
        @Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
        public void Healthsafety_TC_SF_06_04_purseYesToNoValidFromScorecard(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {
	    TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	    StartTest(TestCaseName, "Validate purse Yes to No functionality");
	    try {	    	
		hsr.purseYesToNoValidFromScorecard();
		
	    } catch (Throwable t) {
		System.out.println(t.getLocalizedMessage());
		Error e1 = new Error(t.getMessage());
		e1.setStackTrace(t.getStackTrace());
		throw e1;
	    }
    }

        @Test(dependsOnMethods = {"com.Well.testcases.HealthSafety.Healthsafety_TC_SF_06_ValidatePursueInScorecard.Healthsafety_TC_SF_06_04_purseYesToNoValidFromScorecard"})
        @Parameters({ "SheetName", "rowNum" })
        public void Healthsafety_TC_SF_06_05_purseMaybeToNoValidFromScorecard(String SheetName, int rowNum) throws IOException {
	    TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	    StartTest(TestCaseName, "Validate purse Maybe to No functionality");
	    try {
		hsr.purseMaybeToNoValidFromScorecard();
	    } catch (Throwable t) {
		System.out.println(t.getLocalizedMessage());
		Error e1 = new Error(t.getMessage());
		e1.setStackTrace(t.getStackTrace());
		throw e1;
	    }
    }
        
        @Test(dependsOnMethods = {"com.Well.testcases.HealthSafety.Healthsafety_TC_SF_06_ValidatePursueInScorecard.Healthsafety_TC_SF_06_05_purseMaybeToNoValidFromScorecard"})
        @Parameters({ "SheetName", "rowNum" })
        public void Healthsafety_TC_SF_06_06_purseYesToMaybeValidFromScorecard(String SheetName, int rowNum) throws IOException {
	    TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	    StartTest(TestCaseName, "Validate purse Maybe to No functionality");
	    try { 	
		hsr.purseYesToMaybeValidFromScorecard();
		
	    } catch (Throwable t) {
		System.out.println(t.getLocalizedMessage());
		Error e1 = new Error(t.getMessage());
		e1.setStackTrace(t.getStackTrace());
		throw e1;
	    }
    }
        
    	@Test(dependsOnMethods = {"com.Well.testcases.HealthSafety.Healthsafety_TC_SF_06_ValidatePursueInScorecard.Healthsafety_TC_SF_06_06_purseYesToMaybeValidFromScorecard" })
    	@Parameters({ "SheetName", "rowNum","Commodity" })
    	public void Healthsafety_TC_SF_06_07_ValidateScorecardUploadButtonCountAfterClosingTheAssignLocationModal(String SheetName, int rowNum, String Commodity) throws IOException {

    		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
    		StartTest(TestCaseName, "HSR Validate Scorecard Save And Exit Flow");
    		try {
    			hsr.ScorecardSaveAndExitFlow("Develop Emergency Preparedness Plan", SheetName, rowNum, Commodity);
    			
    		} catch (Throwable t) {
    			System.out.println(t.getLocalizedMessage());
    			Error e1 = new Error(t.getMessage());
    			e1.setStackTrace(t.getStackTrace());
    			throw e1;
    		}
    	}
    	
    	@Test(dependsOnMethods = {"com.Well.testcases.HealthSafety.Healthsafety_TC_SF_06_ValidatePursueInScorecard.Healthsafety_TC_SF_06_07_ValidateScorecardUploadButtonCountAfterClosingTheAssignLocationModal" })
    	@Parameters({ "SheetName", "rowNum","Commodity" })
    	public void Healthsafety_TC_SF_06_08_ValidateScorecardConfirmationModalFromPurseYesToNoAfterAddingOptions(String SheetName, int rowNum, String Commodity) throws IOException {

    		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
    		StartTest(TestCaseName, "HSR Validate Scorecard Confirmation Modal from Purse Yes to No After Adding Options");
    		try {
    			hsr.ValidateScorecardConfirmationModalFromPurseYesToNoAfterAddingOptions("Develop Emergency Preparedness Plan", SheetName, rowNum, Commodity);
    			
    		} catch (Throwable t) {
    			System.out.println(t.getLocalizedMessage());
    			Error e1 = new Error(t.getMessage());
    			e1.setStackTrace(t.getStackTrace());
    			throw e1;
    		}
    	}
    	
    	@Test(dependsOnMethods = {"com.Well.testcases.HealthSafety.Healthsafety_TC_SF_06_ValidatePursueInScorecard.Healthsafety_TC_SF_06_08_ValidateScorecardConfirmationModalFromPurseYesToNoAfterAddingOptions" })
    	@Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
    	public void Healthsafety_TC_SF_06_09_ValidateTaskCompletionOnAddingOptionFromDocEdit(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

    		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
    		StartTest(TestCaseName, "Validate Task Completion On Adding Option From Doc Edit");
    		try {    			
    			hsr.ValidateTaskCompletionOnAddingOptionFromDocEdit(SheetName,rowNum,"WELL Health-Safety Rating",ProjectType, Commodity,FeaturefileUpload ,false,false,false,false,"Monitor Air and Water Quality");
    			
    		} catch (Throwable t) {
    			System.out.println(t.getLocalizedMessage());
    			Error e1 = new Error(t.getMessage());
    			e1.setStackTrace(t.getStackTrace());
    			throw e1;
    		}
    	}
}
