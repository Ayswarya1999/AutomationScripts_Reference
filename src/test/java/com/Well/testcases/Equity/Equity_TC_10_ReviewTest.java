package com.Well.testcases.Equity;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Equity_TC_10_ReviewTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_09_DocumentTest.Equity_TC_09_05_SearchFilterDocumentWER" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_10_00_PreliminarySubmitReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Equity Review Submit Functionality");
		try {
			equity.WERSubmitReview(SheetName, rowNum, "Preliminary Equity Rating Review");	
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_10_ReviewTest.Equity_TC_10_00_PreliminarySubmitReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_10_01_UnderReviewToolTipTextValidation(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Equity Validate Under Review Functionality");
		try {
		rc.clickDocument();
		pfu.ValidatingUnderReviewDocument();
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_10_ReviewTest.Equity_TC_10_01_UnderReviewToolTipTextValidation" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_10_02_PreliminaryCompleteReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Equity Completing Review Functionality");
		try {
			login.AdminLogin();
			equity.WERCompleteReview(SheetName, rowNum,"Preliminary Equity Rating Review");
			rc.SignOut();
			login.Login();
			equity.SearchEquityByID(SheetName,rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
		@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_10_02_PreliminaryCompleteReview" })
		@Parameters({ "SheetName","rowNum" })
		public void Equity_TC_10_03_FinalSubmitReview(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	        StartTest(TestCaseName, "Equity Review Submit Functionality");
			try {
				equity.WERSubmitReview(SheetName, rowNum, "Final Equity Rating Review");	
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}	
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_10_ReviewTest.Equity_TC_10_03_FinalSubmitReview" })
		@Parameters({ "SheetName","rowNum" })
		public void Equity_TC_10_04_FinalCompleteReview(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	        StartTest(TestCaseName, "Equity Completing Review Functionality");
			try {
				login.AdminLogin();
				equity.WERCompleteReview(SheetName, rowNum,"Final Equity Rating Review");
				rc.SignOut();
				login.Login();
				equity.SearchEquityByID(SheetName,rowNum);
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_10_04_FinalCompleteReview" })
		@Parameters({ "SheetName","rowNum" })
		public void Equity_TC_10_05_CurativeSubmitReview(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	        StartTest(TestCaseName, "Equity Review Submit Functionality");
			try {
			login.AdminLogin();
				equity.AdminSearchWer(SheetName,rowNum);
				performance.ClickBilling();
				rc.Billing(SheetName, rowNum);
				equity.WERSubmitReview(SheetName, rowNum,"Curative Action Review");
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}	
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_10_ReviewTest.Equity_TC_10_05_CurativeSubmitReview" })
		@Parameters({ "SheetName","rowNum" })
		public void Equity_TC_10_06_CurativeCompleteReview(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	        StartTest(TestCaseName, "Equity Completing Review Functionality");
			try {
				
				equity.WERCompleteReview(SheetName, rowNum, "Curative Action Review");	
				rc.SignOut();
				login.Login();
				equity.SearchEquityByID(SheetName,rowNum);
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;         
			}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_10_ReviewTest.Equity_TC_10_06_CurativeCompleteReview" })
		@Parameters({ "SheetName","rowNum" })
		public void Equity_TC_10_07_AchievingReviewDocument(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	        StartTest(TestCaseName, "Equity Achieving Review Document");
			try {
				pfu.getProjectIdAndSetInIdColumnInExcel(SheetName, rowNum);
				pfu.ValidatingAcheivedReviewDocument(SheetName,rowNum);
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;         
			}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_10_ReviewTest.Equity_TC_10_07_AchievingReviewDocument" })
		@Parameters({ "SheetName","rowNum", "Commodity" })

		public void Equity_TC_10_08_ValidatePostReviewInScorecardFeature(String SheetName,int rowNum, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Equity Validate Post Review Functionality In Scorecard Feature");
			try {
				rc.clickScorecard();
				equity.ValidatePostReviewInScorecardFeature(SheetName, rowNum, "Create DEI Assessment and Action Plan", Commodity);
				equity.ValidatePostReviewArchiveDocumentFunctionality(SheetName, rowNum, "Create DEI Assessment and Action Plan", Commodity);

			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;         
			}
		}		

		@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_10_ReviewTest.Equity_TC_10_08_ValidatePostReviewInScorecardFeature" })
		@Parameters({ "SheetName","rowNum", "Commodity" })
		public void Equity_TC_10_09_ValidatePostReviewInScorecardAudit(String SheetName,int rowNum, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Equity Validate Post Review Functionality In Scorecard Audit");
			try {
				equity.ValidatePostReviewInScorecardAudit(SheetName, rowNum, "Enhance Lighting Environment", Commodity);
				equity.ValidatePostReviewArchiveDocumentFunctionality(SheetName, rowNum, "Enhance Lighting Environment", Commodity);
			
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
	    @Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_10_ReviewTest.Equity_TC_10_09_ValidatePostReviewInScorecardAudit" })
		@Parameters({ "SheetName","rowNum","Commodity" })
		public void Equity_TC_10_10_ValidatePostReviewInScorecardAlternative(String SheetName,int rowNum, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Equity Validate Post Review Functionality In Scorecard Alternative");
			try {
				equity.ValidatePostReviewInScorecardFeature(SheetName, rowNum, "Promote Health Benefits", Commodity);
				equity.ValidatePostReviewArchiveDocumentFunctionality(SheetName, rowNum, "Promote Health Benefits", Commodity);
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
	    
	    @Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Equity_TC_10_10_ValidatePostReviewInScorecardAlternative" })
		@Parameters({ "SheetName","rowNum","Commodity" })
		public void Equity_TC_10_11_MoveOnArchiveAndValidateArchiveInDocumentList(String SheetName,int rowNum, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Validate Feature Post Review Functionality");
			try {
				rc.clickDocument();
				equity.ValidateArchiveDocuments(SheetName, rowNum, Commodity);
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
	    
	    @Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Equity_TC_10_11_MoveOnArchiveAndValidateArchiveInDocumentList" })
		@Parameters({ "SheetName","rowNum","Commodity" })
		public void Equity_TC_10_12_purseYesToMaybeValidFromScorecard(String SheetName,int rowNum, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Validate Purse Yes to Maybe from Scorecard Functionality");
			try {
				rc.clickScorecard();
				equity.purseYesToMaybeValidFromScorecard(SheetName, rowNum, Commodity);
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
	    
	    @Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Equity_TC_10_12_purseYesToMaybeValidFromScorecard" })
		@Parameters({ "SheetName","rowNum","Commodity" })
		public void Equity_TC_10_13_purseYesToNoValidFromScorecard(String SheetName,int rowNum, String Commodity) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Validate Purse Yes to No from Scorecard Functionality");
			try {
				equity.purseYesToNoValidFromScorecard(SheetName, rowNum, Commodity);
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
}
