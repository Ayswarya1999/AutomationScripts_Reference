package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_13A_EquityReviewV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_13_EquityV2ProjectTest.V2_TC_13_02_EquityScoreCardUploadDocumentV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_13A_00_EquitySubmitReviewV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"V2Project Review Submit Functionality");
		try {
			
			v2project.werSubmitReviewV2Project(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.V2_TC_13A_EquityReviewV2ProjectTest.V2_TC_13A_00_EquitySubmitReviewV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_13A_01_EditMRCReviewPreliminary(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Performance Edit MRC Review");
		try {
			login.AdminLogin();	
		v2project.AdminSearchById(SheetName, rowNum);
			performance.clickOnReviewTab(SheetName, rowNum);
			performance.verifyEditMRCReview(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.V2_TC_13A_EquityReviewV2ProjectTest.V2_TC_13A_01_EditMRCReviewPreliminary" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_13A_02_AddMRCCommentReviewPreliminary(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Performance Add MRC Comment Review Functionality");
		try {
			rc.SignOut();
			login.Login();
			v2project.SearchV2ProjectById(SheetName, rowNum);
			performance.clickOnReviewTab(SheetName, rowNum);
			performance.verifyAddMRCCommentReview(SheetName, rowNum);
			rc.clickScorecard();
			v2project.purseYesToNoValidFromScorecard();
			performance.clickOnReviewTab(SheetName, rowNum);
			performance.clickViewButtonInReview();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.V2_TC_13A_EquityReviewV2ProjectTest.V2_TC_13A_02_AddMRCCommentReviewPreliminary" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_13A_03_ReSubmitReviewPreliminary(String SheetName,int rowNum) throws IOException {

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
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.V2_TC_13A_EquityReviewV2ProjectTest.V2_TC_13A_03_ReSubmitReviewPreliminary" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_13A_04_CompletePreliminaryReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Performance Review Submit Functionality. Purse Maybe and verify warning message");
		try {
			login.AdminLogin();
			v2project.werCompleteReviewV2Project(SheetName, rowNum);
			v2project.clickMayBeAndValidWarningMessageInReview();
			performance.clickOnReviewTab(SheetName, rowNum);
			performance.clickViewButtonInReview();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.V2_TC_13A_EquityReviewV2ProjectTest.V2_TC_13A_04_CompletePreliminaryReview" })
	public void V2_TC_13A_05_AdminUploadHsrReview() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
			v2project.AdminReviewUpload("HSR");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.V2_TC_13A_EquityReviewV2ProjectTest.V2_TC_13A_05_AdminUploadHsrReview" })
	public void V2_TC_13A_06_AdminUploadWprReview() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
			v2project.AdminReviewUpload("WPR");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.V2_TC_13A_EquityReviewV2ProjectTest.V2_TC_13A_06_AdminUploadWprReview" })
	public void V2_TC_13A_07_AdminUploadWerReview() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
			
			v2project.AdminReviewUpload("WER");
			v2project.validAdminReviewUpload();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.V2_TC_13A_EquityReviewV2ProjectTest.V2_TC_13A_07_AdminUploadWerReview" })
	@Parameters({ "Commodity" })
	public void V2_TC_13A_08_AdminImportDocumentRulingsReview(String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
			v2project.AdminImportDocumentV2Review(Commodity,"WELL Health-Safety Rating","PortfolioAdminReviewImportDocumentRulingsCheckbox");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.V2_TC_13A_EquityReviewV2ProjectTest.V2_TC_13A_08_AdminImportDocumentRulingsReview" })
	@Parameters({ "SheetName","rowNum","Commodity" })
	public void V2_TC_13A_09_AdminImportAchievementReview(String SheetName,int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
	    
			v2project.AdminImportDocumentV2Review(Commodity,"WELL Performance Rating","PortfolioAdminReviewImportAchievementsCheckbox");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.V2_TC_13A_EquityReviewV2ProjectTest.V2_TC_13A_09_AdminImportAchievementReview" })
	@Parameters({ "SheetName","rowNum","Commodity" })
	public void V2_TC_13A_10_AdminImportLocationScoresReview(String SheetName,int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Performance Review Submit Functionality");
		try {
	    
			v2project.AdminImportDocumentV2Review(Commodity,"WELL Equity Rating","PortfolioAdminReviewImportLocationCheckbox");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.V2_TC_13A_EquityReviewV2ProjectTest.V2_TC_13A_10_AdminImportLocationScoresReview" })
	@Parameters({ "Commodity" })
	public void V2_TC_13A_11_AdminImportLogs(String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL At Scale Admin Import Logs Functionality");

		try {
			portfolio.AdminReviewImportButton();
			v2project.AdminReviewimportLogs(Commodity);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.V2_TC_13A_EquityReviewV2ProjectTest.V2_TC_13A_11_AdminImportLogs" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_13A_12_DeleteAdminReviewUpload(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Delete Upload review document Functionality");

		try {
			v2project.DeleteAdminReviewUpload(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.V2_TC_13A_EquityReviewV2ProjectTest.V2_TC_13A_12_DeleteAdminReviewUpload" })
	@Parameters({ "Commodity" })
	public void V2_TC_13A_13_AdminReviewimportHistory(String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL At Scale Review Import History Functionality");

		try {
			v2project.AdminReviewimportHistory(Commodity);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
