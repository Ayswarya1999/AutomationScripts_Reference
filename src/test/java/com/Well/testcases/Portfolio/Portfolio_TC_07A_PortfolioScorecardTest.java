package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_07A_PortfolioScorecardTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_06_PortfolioLocationImportTest.Portfolio_TC_06_PortfolioLocationImport" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_07A_00_PortfolioBuildScorecard(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Build WELL At Scale Scorecard Functionality");
        try {
          portfolio.PortfolioBuildScorecard();
         } catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_07A_PortfolioScorecardTest.Portfolio_TC_07A_00_PortfolioBuildScorecard" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Portfolio_TC_07A_01_UploadDocumentInAllFeature(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Uploading documents for all feature");
        try {
          portfolio.uploadDocumentInFeature(227, Commodity);
         } catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	
}
