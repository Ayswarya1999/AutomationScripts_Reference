package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_20_EquityPortfolioTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_19B_ReviewPerformancePortfolioTest.Portfolio_TC_19B_01_WPRCompletetReviewPortfolio"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_20_00_WERCompleteScorecardPortfolio(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Register the Wer Portfolio Opt and complete the Purses");

		try {
			portfolio.WERPortfolioOpt(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_20_EquityPortfolioTest.Portfolio_TC_20_00_WERCompleteScorecardPortfolio" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_TC_20_01_WERScoreCardUploadDocumentPortfolio(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Upload Document for Wer Portfolio Opt");

		try {
			hsr.CommonBulkUploadScorecardDocument(5, SheetName, rowNum, Commodity, FeaturefileUpload, false, false,
					false, false);
			portfolio.SingleUploadScorecardDocumentInOptn("Provide Workplace Thermal and Lighting Control", SheetName, rowNum, Commodity,AuditfileUpload ,false,false,false,false);
			portfolio.SingleUploadScorecardDocumentInOptn("Enhance Speech Intelligibility", SheetName, rowNum, Commodity,AuditfileUpload ,false,false,false,false);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
