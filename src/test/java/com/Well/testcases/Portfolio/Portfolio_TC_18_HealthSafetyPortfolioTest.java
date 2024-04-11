package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_18_HealthSafetyPortfolioTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_13A_ValidateProjectAccessTeamTest.Portfolio_TC_13A_ValidateProjectAccessTeam"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_18_00_HSRCompleteScorecardPortfolio(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

	    StartTest(TestCaseName, "Register the Hsr Portfolio Opt and complete the Purses");

		try {
			rc.SignOut();
		    login.Login();
			portfolio.SearchPortfolioById(SheetName, rowNum);
			portfolio.HSRPortfolio(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_18_HealthSafetyPortfolioTest.Portfolio_TC_18_00_HSRCompleteScorecardPortfolio" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_TC_18_01_HSRScoreCardUploadDocumentPortfolio(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Upload Document for Hsr Portfolio Opt");

		try {
			hsr.CommonBulkUploadScorecardDocument(5, SheetName, rowNum, Commodity, FeaturefileUpload, false, false,
					false, false);
			portfolio.SingleUploadScorecardDocumentInOptn("Promote a Smoke-Free Environment", SheetName, rowNum, Commodity, AuditfileUpload, false, false, false, false);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_18_HealthSafetyPortfolioTest.Portfolio_TC_18_01_HSRScoreCardUploadDocumentPortfolio" })
	@Parameters({ "SheetName","rowNum","Commodity" })
	public void Portfolio_TC_18_02_HSRScoreCardEditDocumentPortfolio(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Edit document and feature verification");

		try {
			portfolio.SingleUploadScorecardDocumentInOptn("Develop Emergency Preparedness Plan", SheetName, rowNum, Commodity, AuditfileUpload, false, false, false, false);
			portfolio.EditHsrDocForFeature(SheetName, rowNum, Commodity);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}