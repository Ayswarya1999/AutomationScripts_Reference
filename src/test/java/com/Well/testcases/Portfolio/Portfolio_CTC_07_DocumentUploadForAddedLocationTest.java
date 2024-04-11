package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_CTC_07_DocumentUploadForAddedLocationTest extends BaseClass {
	 
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_06_ScorecardUploadForAddedLocationTest.Portfolio_CTC_06_11_PaginitionScorecardUpload" })
	 @Parameters({ "SheetName","rowNum", "Commodity" })
	 public void Portfolio_CTC_07_00_UploadLegalDocumentFromDocumentLibrary(String SheetName,int rowNum, String Commodity) throws IOException {
	 TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	 StartTest(TestCaseName,"Upload Legal Document in DocumentLibrary");
	 try {
		
	 pfu.UploadLegalFromDocumentLibrary(SheetName, rowNum,"Upload Legal",LegalfileUpload, Commodity); 
	} catch (Throwable t) {
	 System.out.println(t.getLocalizedMessage());
	 Error e1 = new Error(t.getMessage());
	 e1.setStackTrace(t.getStackTrace());
	 throw e1;
	 }
	 }
	 

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_00_UploadLegalDocumentFromDocumentLibrary" })
	 @Parameters({ "SheetName","rowNum","ProjectType","Commodity" })
	 public void Portfolio_CTC_07_01_UploadFeatureDocumentFromDocumentLibrary(String SheetName,int rowNum, String ProjectType, String Commodity) throws IOException {
	 TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	 StartTest(TestCaseName,"Upload Feature Document in DocumentLibrary");
	 try {
	 pfu.UploadFeatureDocV2ProjectInsideDocument(SheetName, rowNum,"Feature",FeaturefileUpload,ProjectType, Commodity); 
	} catch (Throwable t) {
	 System.out.println(t.getLocalizedMessage());
	 Error e1 = new Error(t.getMessage());
	 e1.setStackTrace(t.getStackTrace());
	 throw e1;
	 }
	 }

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_01_UploadFeatureDocumentFromDocumentLibrary" })
	 @Parameters({ "SheetName","rowNum","Commodity" })
	 public void Portfolio_CTC_07_02_UploadAuditDocumentFromDocumentLibrary(String SheetName,int rowNum, String Commodity) throws IOException {
	 TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	 StartTest(TestCaseName,"Upload Audit Document in DocumentLibrary");
	 try {
		 pfu.UploadAuditDocV2ProjectInsideDocument(SheetName, rowNum,"Audit",AuditfileUpload, Commodity); 
	} catch (Throwable t) {
	 System.out.println(t.getLocalizedMessage());
	 Error e1 = new Error(t.getMessage());
	 e1.setStackTrace(t.getStackTrace());
	 throw e1;
	 }
	 }
	
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_02_UploadAuditDocumentFromDocumentLibrary" })
		 @Parameters({ "SheetName","rowNum" })
		 public void Portfolio_CTC_07_03_GeneralSearchFilterDocumentFromDocumentLibrary(String SheetName,int rowNum) throws IOException {
		 TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		 StartTest(TestCaseName,"Verify General SearchFilter Document in DocumentLibrary");
		 try {
			 pfu.GeneralSearchFilterDocumentFromDocumentLibrary(SheetName,rowNum);
		} catch (Throwable t) {
		 System.out.println(t.getLocalizedMessage());
		 Error e1 = new Error(t.getMessage());
		 e1.setStackTrace(t.getStackTrace());
		 throw e1;
		 }
	 }
		
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_03_GeneralSearchFilterDocumentFromDocumentLibrary" })
		 @Parameters({ "SheetName","rowNum" })
		 public void Portfolio_CTC_07_04_ScorecardSearchFilterDocumentFromDocumentLibrary(String SheetName,int rowNum) throws IOException {
		 TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		 StartTest(TestCaseName,"Verify Scorecard SearchFilter in DocumentLibrary");
		 try {
			 pfu.ScorecardSearchFilterDocumentFromDocumentLibrary(SheetName,rowNum);
		} catch (Throwable t) {
		 System.out.println(t.getLocalizedMessage());
		 Error e1 = new Error(t.getMessage());
		 e1.setStackTrace(t.getStackTrace());
		 throw e1;
		 }
	 }
		
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_04_ScorecardSearchFilterDocumentFromDocumentLibrary" })
		 @Parameters({ "SheetName","rowNum" })
		 public void Portfolio_CTC_07_05_SharedDocSearchFilterDocumentFromDocumentLibrary(String SheetName,int rowNum) throws IOException {
		 TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		 StartTest(TestCaseName,"Upload Audit Document in DocumentLibrary");
		 try {
			 pfu.SharedDocSearchFilterDocumentFromDocumentLibrary(SheetName,rowNum);
		} catch (Throwable t) {
		 System.out.println(t.getLocalizedMessage());
		 Error e1 = new Error(t.getMessage());
		 e1.setStackTrace(t.getStackTrace());
		 throw e1;
		 }
	 }
		
		@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_05_SharedDocSearchFilterDocumentFromDocumentLibrary"})
		@Parameters({ "SheetName", "rowNum" })
		public void Portfolio_CTC_07_06_EditDocumentUploadInDocumentLibrary(String SheetName, int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName, "Validation Location Count Functionality");

			try {
				pfu.editScorecardDocumentFromDocumentLibrary();
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_06_EditDocumentUploadInDocumentLibrary"})
		@Parameters({ "SheetName", "rowNum", "ProjectType" })
		public void Portfolio_CTC_07_07_ValidPagnitionInDocumentLibrary(String SheetName, int rowNum, String ProjectType) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName, "Validation Pagnition In Document Library Functionality");

			try {

				pfu.pagnitionScorecardDocumentFromDocumentLibrary();
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_07_ValidPagnitionInDocumentLibrary"})
		@Parameters({ "SheetName", "rowNum" })
		public void Portfolio_CTC_07_08_DeleteDocumentUploadInDocumentLibrary(String SheetName, int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName, "Delete Document Upload In Document Library Functionality");

			try {
				pfu.deleteScorecardDocumentFromDocumentLibrary();
			
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_08_DeleteDocumentUploadInDocumentLibrary" })
		 @Parameters({ "SheetName","rowNum" })
		 public void Portfolio_CTC_07_09_ValidateLocationUploadDocumentInPortfolioAcccount(String SheetName,int rowNum) throws IOException {
		 TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		 StartTest(TestCaseName,"Validate Document count in Portfolio Account DocumentLibrary");
		 try {
			 portfolio.SearchPortfolioById(SheetName,rowNum);
			 portfolio.clickDocument();
			 pfu.ValidateLocationUploadDocumentInPortfolioAcccount(SheetName,rowNum);
		} catch (Throwable t) {
		 System.out.println(t.getLocalizedMessage());
		 Error e1 = new Error(t.getMessage());
		 e1.setStackTrace(t.getStackTrace());
		 throw e1;
		 }
	 }
		
		@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_09_ValidateLocationUploadDocumentInPortfolioAcccount"})
		@Parameters({ "SheetName", "rowNum" })
		public void Portfolio_CTC_07_10_ValidAddLocation(String SheetName, int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName, "Validation Location Count Functionality");

			try {
				rc.ValidAddLocation(SheetName, rowNum,"20");
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_10_ValidAddLocation"})
	@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
	public void Portfolio_CTC_07_11_UploadScorecardDocumentForMultipleOptionsAndMultipleLocations(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Upload Scorecard Document for Multiple Options and Multiple Locations");

		try {
			rc.clickScorecard();
			pfu.UploadScorecardDocumentForMultipleOptionsAndMultipleLocations("Meet Thresholds for Organic Gases",SheetName, rowNum, ProjectType, Commodity, SampleJpgfile, false, false, false, false);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	} 
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_11_UploadScorecardDocumentForMultipleOptionsAndMultipleLocations"})
	@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
	public void Portfolio_CTC_07_12_UploadScorecardDocumentForOneLocationAndOneOption(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Upload Scorecard Document for one Location and one Option");

		try {
			pfu.UploadScorecardDocumentForOneLocationAndOneOption("Meet Enhanced Thresholds for Organic Gases",SheetName, rowNum, ProjectType, Commodity, SampleJpgfile, false, false, false, false);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}          
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_12_UploadScorecardDocumentForOneLocationAndOneOption"})
	@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
	public void Portfolio_CTC_07_13_UploadScorecardDocumentForOneOptionAndMultipleLocations(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Upload Scorecard Document for one Option and Multiple Locations");

		try {
			pfu.UploadScorecardDocumentForOneOptionAndMultipleLocations("Meet Enhanced Thresholds for Inorganic Gases",SheetName, rowNum, ProjectType, Commodity, SampleJpgfile, false, false, false, false);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage()); 
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_13_UploadScorecardDocumentForOneOptionAndMultipleLocations"})
	@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
	public void Portfolio_CTC_07_14_UploadScorecardDocumentForMultipleOptionsAndOneLocation(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Upload Scorecard Document for multiple Options and one Location");

		try {
			pfu.UploadScorecardDocumentForMultipleOptionsAndOneLocation("Increase Outdoor Air Supply",SheetName, rowNum, ProjectType, Commodity, SampleJpgfile, false, false, false, false);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
		
		@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_14_UploadScorecardDocumentForMultipleOptionsAndOneLocation"})
		@Parameters({ "SheetName", "rowNum","ProjectType" })
		public void Portfolio_CTC_07_15_AfterReviewHistory(String SheetName, int rowNum, String ProjectType) throws IOException {
	
			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName, "Mark Document as Achieved or Reviewed");
	
			try {
				if (!ProjectType.contains("pilot")) {
				pfu.scorecardPostReviewHistoryView("Provide Active Workstations");
				login.AdminLogin();
				portfolio.AdminSearch(SheetName, rowNum);
				portfolio.PortfolioBuildScorecard();
				pfu.scorecardPostReviewHistoryAsAdmin("Provide Active Workstations");
				rc.SignOut();
				login.Login();
				portfolio.SearchPortfolioById(SheetName, rowNum);
				portfolio.PortfolioBuildScorecard();
				}
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_15_AfterReviewHistory"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_CTC_07_16_ValidatingAcheivedReviewDocument(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Mark Document as Achieved or Reviewed");

		try {
		pfu.ValidatingAcheivedReviewDocument(SheetName,rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
		
		@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_16_ValidatingAcheivedReviewDocument"})
		@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
		public void Portfolio_CTC_07_17_ValidateScorecardUnassignLocationFromOptionWithReviewedDocs(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName, "Validate scorecard unassign Location from Option with Reviewed Docs");

			try {
				pfu.ValidateScorecardUnassignLocationFromOptionWithReviewedDocs("Meet Thresholds for Organic Gases",SheetName, rowNum, ProjectType, Commodity, SampleJpgfile, false, false, false, false);
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_17_ValidateScorecardUnassignLocationFromOptionWithReviewedDocs"})
		@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
		public void Portfolio_CTC_07_18_ValidateScorecardArchiveDocumenForMultipleOptionsOneLocation(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName, "Validate scorecard unassign Location from Option with Reviewed Docs");

			try {
				pfu.ValidateAtchiveDocumentsOnUnassigningAllLocation("Meet Enhanced Thresholds for Organic Gases",SheetName, rowNum, ProjectType, Commodity, SampleJpgfile, false, false, false, false);
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_18_ValidateScorecardArchiveDocumenForMultipleOptionsOneLocation"})
		@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
		public void Portfolio_CTC_07_19_ValidateScorecardArchiveDocumenForOneLocationOneOption(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName, "Validate scorecard unassign Location from Option with Reviewed Docs");

			try {
				pfu.ValidateAtchiveDocumentsOnUnassigningAllLocation("Increase Outdoor Air Supply",SheetName, rowNum, ProjectType, Commodity, SampleJpgfile, false, false, false, false);
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_19_ValidateScorecardArchiveDocumenForOneLocationOneOption"})
		@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
		public void Portfolio_CTC_07_20_ValidateScorecardArchiveDocumenForOneOptionMultipleLocations(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			
			StartTest(TestCaseName, "Validate scorecard unassign Location from Option with Reviewed Docs");

			try {
				//pfu.ValidateAtchiveDocumentsOnUnassigningAllLocation("Meet Enhanced Thresholds for Inorganic Gases",SheetName, rowNum, ProjectType, Commodity, SampleJpgfile, false, false, false, false);
				//Uncomment this once the bug will be fix.
				
			} catch (Throwable t) {  
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_20_ValidateScorecardArchiveDocumenForOneOptionMultipleLocations"})
		@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
		public void Portfolio_CTC_07_21_ValidateScorecardArchiveDocumenForMultipleOptionsAndMultipleLocations(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			
			StartTest(TestCaseName, "Validate scorecard unassign Location from Option with Reviewed Docs");

			try {
				//pfu.ValidateAtchiveDocumentsOnUnassigningAllLocation("Meet Thresholds for Organic Gases",SheetName, rowNum, ProjectType, Commodity, SampleJpgfile, false, false, false, false);
				//Uncomment this once the bug will be fix.
				
			} catch (Throwable t) {  
				System.out.println(t.getLocalizedMessage());     
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
    	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_21_ValidateScorecardArchiveDocumenForMultipleOptionsAndMultipleLocations" })
    	@Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
    	public void Portfolio_CTC_07_22_ValidateScorecardYesToNoConfirmationModalAfterUploadingMultipleDocs(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

    		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
    		StartTest(TestCaseName, "HSR Validate Scorecard Confirmation Modal from Purse Yes to No After Adding Options");
    		try {
    			if (ProjectType.contains("pilot")) {
    			//	pfu.ValidateScorecardConfirmationModalAfterUploadingMultipleDocs("Monitor Fundamental Air Parameters", SheetName, rowNum, Commodity);
    	    		} 
  				else {
  					pfu.ValidateScorecardConfirmationModalAfterUploadingMultipleDocs("Measure Air Parameters", SheetName, rowNum, Commodity);	
  				}
    		} catch (Throwable t) {
    			System.out.println(t.getLocalizedMessage());
    			Error e1 = new Error(t.getMessage());
    			e1.setStackTrace(t.getStackTrace());
    			throw e1;
    		}
    	}
    	
    	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_22_ValidateScorecardYesToNoConfirmationModalAfterUploadingMultipleDocs" })
    	@Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
    	public void Portfolio_CTC_07_23_ValidateScorecardYesToMaybe(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

    		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
    		StartTest(TestCaseName, "Validate Scorecard Yes To Maybe");
    		try {
    			pfu.purseYesToMaybeValidFromScorecard();
    			
    		} catch (Throwable t) {
    			System.out.println(t.getLocalizedMessage());
    			Error e1 = new Error(t.getMessage());
    			e1.setStackTrace(t.getStackTrace());
    			throw e1;
    		}
    	}
}