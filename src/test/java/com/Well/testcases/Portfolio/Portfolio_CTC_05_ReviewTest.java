package com.Well.testcases.Portfolio;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Portfolio_CTC_05_ReviewTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_04_DocumentUploadTest.Portfolio_CTC_04_02_ScorecardHistoryView" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_05_00_SubmitReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL At Scale Review Submit Functionality");
		try {
			portfolio.SearchPortfolioById(SheetName,rowNum);
		 portfolio.SubmitReviewDocument(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Portfolio_TC_05_00_SubmitReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_05_01_UnderReviewValid(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL At Scale Validate Under Review Functionality");
		try {
		portfolio.clickDocument();
		pfu.ValidatingUnderReviewDocument();	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Portfolio_TC_05_01_UnderReviewValid" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_05_02_CompleteReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"WELL At Scale Completing Review Functionality");

		try {
			login.AdminLogin();
			portfolio.AdminCompleteReview(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Portfolio_TC_05_02_CompleteReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_05_03_AcheivedReviewDocument(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL At Scale Achieve the Review by API Functionality");
		try {
			pfu.ValidatingAcheivedReviewDocument(SheetName,rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Portfolio_TC_05_03_AcheivedReviewDocument" })
	@Parameters({ "SheetName","rowNum","Commodity" })
	public void Portfolio_TC_05_04_PostReviewValidFeature(String SheetName,int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Feature Post Review Functionality");
		try {
			rc.SignOut();
			login.Login();
			portfolio.SearchPortfolioById(SheetName, rowNum);	
			String featureName = data.getCellData(SheetName, "FeatureName", rowNum);
			pfu.ValidatingPostReviewFeature(SheetName,rowNum,featureName, Commodity);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Portfolio_TC_05_04_PostReviewValidFeature" })
	@Parameters({ "SheetName","rowNum","Commodity" })
	public void Portfolio_TC_05_05_PostReviewValidAudit(String SheetName,int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Audit Post Review Functionality");
		try {
			String featureName = data.getCellData(SheetName, "AuditName", rowNum);
			pfu.ValidatingPostReviewAudit(SheetName,rowNum,featureName, Commodity);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	  @Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Portfolio_TC_05_05_PostReviewValidAudit" })
	    @Parameters({ "SheetName","rowNum","Commodity" })
	  	    public void Portfolio_TC_05_06_ValidatingPostReviewAlternative(String SheetName,int rowNum, String Commodity) throws IOException {

	    			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	    			StartTest(TestCaseName,"Validate Feature Post Review Upload button Enabled for Ongoing Data Report Functionality");
	    			try {
	    				String featureName = data.getCellData(SheetName, "AlternativeFeatureName", rowNum);
	    				pfu.ValidatingPostReviewAlternative(SheetName,rowNum,featureName);
	    				
	    			} catch (Throwable t) {
	    				System.out.println(t.getLocalizedMessage());
	    				Error e1 = new Error(t.getMessage());
	    				e1.setStackTrace(t.getStackTrace());
	    				throw e1;
	    			}
	    		}
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Portfolio_TC_05_06_ValidatingPostReviewAlternative" })
		@Parameters({ "SheetName","rowNum","Commodity" })
		public void Portfolio_TC_05_07_PostReviewValidateApprovedStatusInTable(String SheetName,int rowNum, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Validate Approved/Fullfiled Status Review Functionality");
			try {
				String featureName = data.getCellData(SheetName, "FeatureName", rowNum);
				pfu.PostReviewValidateApprovedStatusInTable(featureName);
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
	    @Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Portfolio_TC_05_07_PostReviewValidateApprovedStatusInTable" })
		@Parameters({ "SheetName","rowNum","Commodity" })
		public void Portfolio_TC_05_08_ScorecardFeatureMoveOnArchiveAndValidateArchive(String SheetName,int rowNum, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Validate Feature Post Review Functionality");
			try {	
				pfu.validateArchiveInScorecardTable(SheetName, rowNum, "Meet Thresholds for Inorganic Gases", Commodity);
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
	    
	    @Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Portfolio_TC_05_08_ScorecardFeatureMoveOnArchiveAndValidateArchive" })
		@Parameters({ "SheetName","rowNum","Commodity" })
		public void Portfolio_TC_05_09_DocumentsFeatureMoveOnArchiveAndValidateArchive(String SheetName,int rowNum, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Validate Feature Post Review Functionality");
			try {	
				portfolio.clickDocument();
				pfu.validateArchive(SheetName, rowNum, Commodity);
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
	    
	    @Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Portfolio_TC_05_09_DocumentsFeatureMoveOnArchiveAndValidateArchive" })
	  		public void Portfolio_TC_05_10_validateUploadButtonEnableInOngoingMaintenanceReport() throws IOException {

	  			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	  			StartTest(TestCaseName,"Validate Feature Post Review Upload button Enabled for Ongoing Maintenance Report Functionality");
	  			try {
	  			  rc.clickScorecard();
	  			  pfu.validateUploadButtonEnable("Implement Safety Plan for Non-Potable Water Capture and Reuse","UploadButtonMaintenanceReport");
	  			} catch (Throwable t) {
	  				System.out.println(t.getLocalizedMessage());
	  				Error e1 = new Error(t.getMessage());
	  				e1.setStackTrace(t.getStackTrace());
	  				throw e1;
	  			}
	  		}
	    
	    @Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Portfolio_TC_05_10_validateUploadButtonEnableInOngoingMaintenanceReport" })
		@Parameters({ "ProjectType" })
	    public void Portfolio_TC_05_11_validateUploadButtonEnableInOngoingDataReport(String ProjectType) throws IOException {

  			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
  			StartTest(TestCaseName,"Validate Feature Post Review Upload button Enabled for Ongoing Data Report Functionality");
  			try {
  				if (ProjectType.contains("pilot")) {
  					pfu.validateUploadButtonEnable("Monitor Fundamental Air Parameters","UploadButtonDataReport");
  					} 
  				else {
  					pfu.validateUploadButtonEnable("Measure Air Parameters","UploadButtonDataReport");
  					}
  			} catch (Throwable t) {
  				System.out.println(t.getLocalizedMessage());
  				Error e1 = new Error(t.getMessage());
  				e1.setStackTrace(t.getStackTrace());
  				throw e1;
  			}
  		}
	    
         @Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Portfolio_TC_05_11_validateUploadButtonEnableInOngoingDataReport"})
         @Parameters({ "SheetName", "rowNum","ProjectType","Commodity"})
         public void Portfolio_TC_05_12_ValidatePursuingLabelAfterAddingNewLocationWithAcheivedLocation(String SheetName,int rowNum, String ProjectType, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Validate Pursuing Label After Adding New Location With Acheived Location");
			try {
				if (ProjectType.contains("pilot")) {
					pfu.ValidatePursuingLabel(SheetName,rowNum,"v2-pilot",ProjectType, Commodity,FeaturefileUpload ,false,false,false,false,"Monitor Fundamental Air Parameters");
				} 
  				else {
  					pfu.ValidatePursuingLabel(SheetName,rowNum,"WELL v2",ProjectType, Commodity,FeaturefileUpload ,false,false,false,false,"Measure Air Parameters");
  					
  				}
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
	
	    @Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Portfolio_TC_05_12_ValidatePursuingLabelAfterAddingNewLocationWithAcheivedLocation"})
	    public void Portfolio_TC_05_13_validatePartIdInDocumentsLibrary() throws IOException {

  			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
  			StartTest(TestCaseName,"Validate PartId in Documents Library");
  			try {
  				rc.clickWellV2Tab();
  				rc.clickDocument();
  				rc.clickDocumentsLibraryAllTabInTasks();
  				pfu.validatePartIdInDocumentsLibrary();
  					
  			} catch (Throwable t) {
  				System.out.println(t.getLocalizedMessage());
  				Error e1 = new Error(t.getMessage());
  				e1.setStackTrace(t.getStackTrace());
  				throw e1;
  			}
  		}
	}