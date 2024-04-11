package com.Well.testcases.Portfolio;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;


public class Portfolio_CTC_02_DocumentTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_01_FeatureTest.Portfolio_CTC_01_11_NotApplicableAlternative" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_CTC_02_00_Document(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Attach Document and verify");
		try {
			portfolio.clickDocument();	
		    
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_02_DocumentTest.Portfolio_CTC_02_00_Document" })
	@Parameters({ "SheetName","rowNum","Commodity" })
	public void Portfolio_CTC_02_01_FeatureDocumentUploadInDocumentLibrary(String SheetName, int rowNum, String Commodity) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Attach Feature Task Upload Document and verify");
		try {
			pf.A01_1_FeatureDocumentUploadInDocumentLibrary(SheetName, rowNum, Commodity);	
		    
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}		
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_02_DocumentTest.Portfolio_CTC_02_01_FeatureDocumentUploadInDocumentLibrary" })
	@Parameters({ "SheetName","rowNum", "Commodity" })
	public void Portfolio_CTC_02_02_AuditDocumentUploadInDocumentLibrary(String SheetName, int rowNum, String Commodity) throws IOException {
	
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Attach Audit Task Upload Document and verify");
		try {
			pf.L09_AuditDocumentUploadInDocumentLibrary(SheetName, rowNum, Commodity);	
		    
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}				
	}
					
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_02_DocumentTest.Portfolio_CTC_02_02_AuditDocumentUploadInDocumentLibrary" })
	@Parameters({ "SheetName","rowNum", "Commodity" })
	public void Portfolio_CTC_02_03_UpdateAuditDocumentUploadInDocumentLibrary(String SheetName, int rowNum, String Commodity) throws IOException {
		
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Update Document Upload and verify");
		try {
			pf.UpdateAuditDocumentUploadInDocumentLibrary(SheetName, rowNum, Commodity);	
		    
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
						
		}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_02_DocumentTest.Portfolio_CTC_02_03_UpdateAuditDocumentUploadInDocumentLibrary" })
	 @Parameters({ "SheetName","rowNum", "Commodity" })
	public void Portfolio_CTC_02_04_TaskDocumentUploadInDocumentLibrary(String SheetName, int rowNum, String Commodity) throws IOException {
	
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Attach Task Upload Document and verify");
		try {
			pf.A01_2_DocumentUploadInDocumentLibrary(SheetName, rowNum, Commodity);	
		    
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}					
	}
		
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_02_DocumentTest.Portfolio_CTC_02_04_TaskDocumentUploadInDocumentLibrary" })
	@Parameters({ "SheetName","rowNum", "Commodity" })
	public void Portfolio_CTC_02_05_UpdateFeatureDocumentUploadInDocumentLibrary(String SheetName, int rowNum, String Commodity) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Update Feature Upload Document and verify");
		try {
			pf.UpdateFeatureDocumentUploadInDocumentLibrary(SheetName, rowNum, Commodity);	
		    
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}					
							
		@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_02_DocumentTest.Portfolio_CTC_02_05_UpdateFeatureDocumentUploadInDocumentLibrary" })
		@Parameters({ "SheetName","rowNum","Commodity" })
		public void Portfolio_CTC_02_06_ValidatingLegalUploadDocumentInDocumentLibrary(String SheetName, int rowNum, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Attach Legal Document and verify");
			try {
				portfolio.ValidatingLegalUploadDocument(SheetName, rowNum, Commodity);
			    
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_02_DocumentTest.Portfolio_CTC_02_06_ValidatingLegalUploadDocumentInDocumentLibrary" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_CTC_02_07_DeleteInDocumentLibrary() throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Delete Document and verify");
			try {
				pf.DeleteInDocumentLibrary();		
			    
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
	}	
		
									
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_02_DocumentTest.Portfolio_CTC_02_07_DeleteInDocumentLibrary" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_CTC_02_08_FilterInDocumentLibrary() throws IOException {
	
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Filter Document and verify");
		try {
			pf.FilterInDocumentLibrary();		
		    
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_02_DocumentTest.Portfolio_CTC_02_08_FilterInDocumentLibrary"})
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Portfolio_CTC_02_09_ValidateDocumentSaveAndExitFlow(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Validate Document Save And Exit Flow");
		try {
	        pf.ValidateDocumentSaveAndExitFlow(SheetName, rowNum, Commodity, "A02.1");
	        pf.ValidateSaveAndExitFlow(SheetName, rowNum, Commodity);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_02_DocumentTest.Portfolio_CTC_02_09_ValidateDocumentSaveAndExitFlow" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Portfolio_CTC_02_10_ValidateScorecardSaveAndExitFlow(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Validate Scorecard Save And Exit Flow");
		try {
			rc.clickScorecard();
			pf.ScorecardSaveAndExitFlow("Increase Outdoor Air Supply", SheetName, rowNum, Commodity);
			pf.ValidateSaveAndExitFlow(SheetName, rowNum, Commodity);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
														
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_02_DocumentTest.Portfolio_CTC_02_10_ValidateScorecardSaveAndExitFlow"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_CTC_02_11_ValidAddLocation(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Validation Location Count Functionality");

		try {
			rc.ValidAddLocation(SheetName, rowNum,"5");
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_02_DocumentTest.Portfolio_CTC_02_11_ValidAddLocation" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Portfolio_CTC_02_12_ValidateScorecardUploadButtonCountAfterClosingTheAssignLocationModal(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Validate Scorecard Save And Exit Flow");
		try {
			rc.clickScorecard();
			pf.ScorecardSaveAndExitFlow("Meet Chemical Thresholds", SheetName, rowNum, Commodity);
			pf.ValidateScorecardUploadButtonCountAndTable(SheetName, rowNum, Commodity);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
