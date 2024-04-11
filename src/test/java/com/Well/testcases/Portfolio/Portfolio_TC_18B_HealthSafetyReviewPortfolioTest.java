package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_18B_HealthSafetyReviewPortfolioTest extends BaseClass {

	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_18A_HealthSafetyDocumentTest.Portfolio_TC_18A_02_FeatureUploadDocumentInDocument"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_18B_00_HsrSubmitReviewPortfolio(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Submitting Review for Hsr Opt");

		try {
		    portfolio.PortfolioOptSubmitReviewDocument(SheetName, rowNum,"PortfolioOptScorecardHealthSafety");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_18B_HealthSafetyReviewPortfolioTest.Portfolio_TC_18B_00_HsrSubmitReviewPortfolio"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_18B_01_HsrCompletetReviewPortfolio(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Completing Review for Hsr Opt");

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