package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_19_PerformancePortfolioTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_18B_HealthSafetyReviewPortfolioTest.Portfolio_TC_18B_01_HsrCompletetReviewPortfolio"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_19_00_WPRCompleteScorecardPortfolio(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Register the Wpr Portfolio Opt and complete the Purses");

		try {
			portfolio.WPRPortfolioOpt(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_19_PerformancePortfolioTest.Portfolio_TC_19_00_WPRCompleteScorecardPortfolio" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_TC_19_01_WPRScoreCardUploadDocumentPortfolio(String SheetName, int rowNum,String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Upload Document for Wpr Portfolio Opt");

		try {
			portfolio.SingleUploadScorecardDocumentInOptn("Occupant Survey", SheetName, rowNum, Commodity, AuditfileUpload, false, false, false, false);
			portfolio.SingleUploadScorecardDocumentInOptn("Install Indoor Air Monitors", SheetName, rowNum, Commodity, AuditfileUpload, false, false, false, false);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
