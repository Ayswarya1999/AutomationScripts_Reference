package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_09_ReviewTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_08_DocumentTest.Performance_TC_08_10_ValidateScorecardPagination" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_09_00_SubmitPreliminaryReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
		performance.SubmitWPRReview(SheetName, rowNum, "Preliminary Performance Rating Review");	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_ReviewTest.Performance_TC_09_00_SubmitPreliminaryReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_09_01_EditMRCReviewPreliminary(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Performance Edit MRC Review");
		try {
			rc.SignOut();
			login.AdminLogin();	
			performance.AdminWprSearch(SheetName, rowNum);
			performance.clickOnReviewTab(SheetName, rowNum);
			performance.verifyEditMRCReview(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_ReviewTest.Performance_TC_09_01_EditMRCReviewPreliminary" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_09_02_AddMRCCommentReviewPreliminary(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Performance Add MRC Comment Review Functionality");
		try {
			rc.SignOut();
			login.Login();
			performance.SearchPerformanceByID(SheetName,rowNum);
			performance.clickOnReviewTab(SheetName, rowNum);
			performance.verifyAddMRCCommentReview(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_ReviewTest.Performance_TC_09_02_AddMRCCommentReviewPreliminary" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_09_03_ReSubmitReviewPreliminary(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Performance Review ReSubmit Functionality");
		try {
			performance.verifyReSubmitReview(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_ReviewTest.Performance_TC_09_03_ReSubmitReviewPreliminary" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_09_04_CompletePreliminaryReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
		login.AdminLogin();
		performance.CompleteWPRReview(SheetName, rowNum, "Preliminary Performance Rating Review");	
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_ReviewTest.Performance_TC_09_04_CompletePreliminaryReview" })
	@Parameters({ "SheetName","rowNum","Commodity" })
	public void Performance_TC_09_05_AdminImportDocumentRulingsV2Review(String SheetName,int rowNum,String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
			portfolio.AdminImportDocumentRulingsV2Review(Commodity);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_ReviewTest.Performance_TC_09_05_AdminImportDocumentRulingsV2Review" })
	@Parameters({ "SheetName","rowNum","Commodity" })
	public void Performance_TC_09_06_AdminImportAchievementReview(String SheetName,int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
	    
			portfolio.AdminImportAchievementsHsrReview(Commodity);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_ReviewTest.Performance_TC_09_06_AdminImportAchievementReview" })
	@Parameters({ "SheetName","rowNum","Commodity" })
	public void Performance_TC_09_07_AdminImportLocationScoresReview(String SheetName,int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
	    
			portfolio.AdminImportLocationScoresWprReview(Commodity);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_ReviewTest.Performance_TC_09_07_AdminImportLocationScoresReview" })
	@Parameters({"Commodity" })
	public void Performance_08_08_AdminImportLogs(String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL At Scale Admin Import Logs Functionality");

		try {

			if (!TestNGTestName.contains("WPR-Renewal")) {
			portfolio.AdminReviewImportButton();
			portfolio.AdminReviewimportLogs(Commodity);
			}

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_ReviewTest.Performance_08_08_AdminImportLogs" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_09_09_AdminUploadReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL At Scale Review Upload document Functionality");
		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
			performance.importReviewUpload();
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_ReviewTest.Performance_TC_09_09_AdminUploadReview" })
	@Parameters({"Commodity" })
	public void Performance_TC_09_10_AdminReviewimportHistory(String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL At Scale Review Import History Functionality");

		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
			portfolio.AdminReviewimportHistory(Commodity);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_ReviewTest.Performance_TC_09_10_AdminReviewimportHistory" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_09_11_FinalSubmitReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
			rc.SignOut();
			login.Login();
			performance.SearchPerformanceByID(SheetName,rowNum);
		performance.SubmitWPRReview(SheetName, rowNum,"Final Performance Rating Review");	
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_ReviewTest.Performance_TC_09_11_FinalSubmitReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_09_12_CompleteFinalReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Complete Performance Review Functionality");
		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
			rc.SignOut();
			login.AdminLogin();
			performance.CompleteWPRReview(SheetName, rowNum,"Final Performance Rating Review");
			rc.SignOut();
			login.Login();
			performance.SearchPerformanceByID(SheetName,rowNum);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_ReviewTest.Performance_TC_09_12_CompleteFinalReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_09_13_CurativeSubmitReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
		rc.SignOut();
		login.AdminLogin();
		performance.AdminWprSearch(SheetName,rowNum);
		performance.ClickBilling();
		rc.Billing(SheetName, rowNum);
		performance.SubmitWPRReview(SheetName, rowNum,"Curative Action Review");	
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_ReviewTest.Performance_TC_09_13_CurativeSubmitReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_09_14_CompleteCurativeReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Complete Performance Review Functionality");
		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
			performance.CompleteWPRReview(SheetName, rowNum,"Curative Action Review");
			rc.SignOut();
			login.Login();
			performance.SearchPerformanceByID(SheetName,rowNum);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
