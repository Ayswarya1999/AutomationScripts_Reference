package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_19B_ReviewPerformancePortfolioTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_19A_PerformanceDocumentTest.Portfolio_TC_19A_02_FeatureUploadDocumentInDocument"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_19B_00_WPRSubmitReviewPortfolio(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Submitting Review for WPR Opt");

		try {
			portfolio.PortfolioOptSubmitReviewDocument(SheetName, rowNum,"PortfolioOptScorecardWpr");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_19B_ReviewPerformancePortfolioTest.Portfolio_TC_19B_00_WPRSubmitReviewPortfolio"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_19B_01_WPRCompletetReviewPortfolio(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Completing Review for WPR Opt");

		try {
			login.AdminLogin();
			portfolio.AdminEditReviewMrc(SheetName, rowNum);
			portfolio.AdminCompleteReviewDocument(SheetName, rowNum);
			rc.SignOut();
			login.Login();
			portfolio.SearchPortfolioById(SheetName, rowNum);	
			portfolio.InitiateRound2Review(SheetName, rowNum);
			login.AdminLogin();
			portfolio.AdminCompleteRound2Review(SheetName, rowNum);
			rc.SignOut();
			login.Login();
		    portfolio.SearchPortfolioById(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
