package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

    public class Portfolio_TC_19A_PerformanceDocumentTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_19_PerformancePortfolioTest.Portfolio_TC_19_01_WPRScoreCardUploadDocumentPortfolio" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Portfolio_TC_19A_00_LegalUploadDocumentInDocument(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Type Legal Upload Document");

		try {
			portfolio.clickWPRDocument();
			portfolio.ValidatingLegalUploadDocument(SheetName, rowNum, Commodity);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_19A_PerformanceDocumentTest.Portfolio_TC_19A_00_LegalUploadDocumentInDocument" })
	@Parameters({"SheetName", "rowNum", "Commodity","ProjectType" })
	public void Portfolio_TC_19A_01_AuditUploadDocumentInDocument(String SheetName, int rowNum, String Commodity, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verifies Audit Upload Document in Document Library");

		try {
			portfolio.ValidatingAuditUploadDocument(SheetName, rowNum, Commodity, ProjectType,"PM2","On-site Photographs");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_19A_PerformanceDocumentTest.Portfolio_TC_19A_01_AuditUploadDocumentInDocument" })
	@Parameters({"SheetName", "rowNum", "Commodity","ProjectType" })
	public void Portfolio_TC_19A_02_FeatureUploadDocumentInDocument(String SheetName, int rowNum, String Commodity, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verifies Feature Upload Document in Document Library");

		try {
		portfolio.ValidatingFeatureUploadDocument(SheetName, rowNum, Commodity, ProjectType, "PX1.1");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
		}
}
