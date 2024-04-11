package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_CTC_06_ScorecardUploadForAddedLocationTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_05_ReviewTest.Portfolio_TC_05_13_validatePartIdInDocumentsLibrary" })
	@Parameters({ "SheetName", "rowNum", "ProjectType" })
	public void Portfolio_CTC_06_00_StoreLocationId(String SheetName, int rowNum, String ProjectType)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Store LocationId in Added Location Functionality");
		try {
			if (ProjectType.equalsIgnoreCase("v2")) {
				pfu.StoreLocationId(SheetName, rowNum);
			}

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_06_ScorecardDocumentUploadForAddedLocationTest.Portfolio_CTC_06_00_StoreLocationId" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_CTC_06_01_NavigateAddedLocation(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Navigate Added Location Functionality");
		try {
			pfu.NavigateAddedLocation(SheetName, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_06_ScorecardDocumentUploadForAddedLocationTest.Portfolio_CTC_06_01_NavigateAddedLocation" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_CTC_06_02_PortfolioBuildScorecard(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,
				"Portfolio Build V2 Scorecard and verify Portfolio Uploaded Document in Location Account custom scenarios");
		try {
			v2project.BuildScorecardV2ProjectById(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_06_ScorecardDocumentUploadForAddedLocationTest.Portfolio_CTC_06_02_PortfolioBuildScorecard" })
	@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
	public void Portfolio_CTC_06_03_FeatureScorecardUpload(String SheetName, int rowNum, String ProjectType, String Commodity)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard Feature custom scenarios");
		try {
			pfu.portfolioAccountLocationScorecardFeature("Meet Thresholds for Organic Gases", ProjectType, SheetName,rowNum, Commodity);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_06_ScorecardDocumentUploadForAddedLocationTest.Portfolio_CTC_06_03_FeatureScorecardUpload" })
	@Parameters({ "SheetName", "rowNum", "ProjectType","Commodity" })
	public void Portfolio_CTC_06_04_ValidateFeatureScorecardUpload(String SheetName, int rowNum, String ProjectType, String Commodity)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate added Scorecard Feature custom scenarios");
		try {
				if (ProjectType.contains("pilot")) {
					pfu.ValidatePortfolioAccInsideScorecard(SheetName, rowNum, "Meet Sediment Thresholds",
							"Performance Test", Commodity);
				} else {
					pfu.ValidatePortfolioAccInsideScorecard(SheetName, rowNum, "Verify Water Quality Indicators",
							"Performance Test", Commodity);
				}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_06_ScorecardDocumentUploadForAddedLocationTest.Portfolio_CTC_06_04_ValidateFeatureScorecardUpload" })
	@Parameters({ "SheetName", "rowNum", "ProjectType","Commodity" })
	public void Portfolio_CTC_06_05_AuditScorecardUpload(String SheetName, int rowNum, String ProjectType, String Commodity)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard Audit feature custom scenarios");
		try {
			pfu.portfolioAccountLocationScorecardAudit("Provide Operable Windows", ProjectType, SheetName, rowNum, Commodity);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_06_ScorecardDocumentUploadForAddedLocationTest.Portfolio_CTC_06_05_AuditScorecardUpload" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Portfolio_CTC_06_06_ValidateAuditScorecardUpload(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate added Scorecard Audit feature custom scenarios");
		try {
				pfu.ValidatePortfolioAccInsideScorecard(SheetName, rowNum, "Provide Operable Windows",
						"On-site Photographs", Commodity);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_06_ScorecardDocumentUploadForAddedLocationTest.Portfolio_CTC_06_06_ValidateAuditScorecardUpload" })
	@Parameters({ "SheetName", "rowNum", "ProjectType" })
	public void Portfolio_CTC_06_07_AlternativeScorecardUpload(String SheetName, int rowNum, String ProjectType)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard Alternative feature custom scenarios");
		try {
				pfu.portfolioAccountLocationScorecardAlternative("Manage Pollution and Exhaust", ProjectType);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_06_ScorecardDocumentUploadForAddedLocationTest.Portfolio_CTC_06_07_AlternativeScorecardUpload" })
	@Parameters({ "SheetName", "rowNum", "ProjectType","Commodity" })
	public void Portfolio_CTC_06_08_ValidateAlternativeScorecardUpload(String SheetName, int rowNum, String ProjectType, String Commodity)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate added Alternative feature custom scenarios");
		try {
				if (ProjectType.contains("pilot")) {
					pfu.ValidatePortfolioAccInsideScorecard(SheetName, rowNum, "Implement Indoor Air Monitors",
							"Alternative Strategy", "Commodity");
				} else {
					pfu.ValidatePortfolioAccInsideScorecard(SheetName, rowNum, "Install Indoor Air Monitors",
							"Alternative Strategy","Commodity");
				}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_06_ScorecardDocumentUploadForAddedLocationTest.Portfolio_CTC_06_08_ValidateAlternativeScorecardUpload" })
	@Parameters({ "SheetName", "rowNum", "ProjectType" })
	public void Portfolio_CTC_06_09_EditScorecardUpload(String SheetName, int rowNum, String ProjectType)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Update Document Upoad custom scenarios");
		try {
				pfu.editScorecardDocumentlocationAccountFromScorecard("Meet Thresholds for Organic Gases");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_06_ScorecardDocumentUploadForAddedLocationTest.Portfolio_CTC_06_09_EditScorecardUpload" })
	@Parameters({ "SheetName", "rowNum", "ProjectType" })
	public void Portfolio_CTC_06_10_DeleteScorecardUpload(String SheetName, int rowNum, String ProjectType)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Delete Document Upoad custom scenarios");
		try {
				pfu.deleteScorecardDocumentlocationAccountFromScorecard("Meet Thresholds for Organic Gases");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_06_ScorecardDocumentUploadForAddedLocationTest.Portfolio_CTC_06_10_DeleteScorecardUpload" })
	@Parameters({ "SheetName", "rowNum", "ProjectType" })
	public void Portfolio_CTC_06_11_PaginitionScorecardUpload(String SheetName, int rowNum, String ProjectType)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate Scorecard Document table Paginition custom scenarios");
		try {
				pfu.LocationAccountMultipleScorecardUpload("Meet Thresholds for Organic Gases", ProjectType);
				pfu.validPagnitionLocationAccountFromScorecard("Meet Thresholds for Organic Gases");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
