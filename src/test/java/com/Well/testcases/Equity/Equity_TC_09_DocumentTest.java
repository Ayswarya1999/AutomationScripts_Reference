package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_09_DocumentTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_08_07_ScoreCardUploadAlternativeDocument"})
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Equity_TC_09_01_LegalDocument(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Document in Document");
		try {
			performance.clikOnDocumentLibrary();
			portfolio.ValidatingLegalUploadDocument(SheetName, rowNum, Commodity);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
		@Test(dependsOnMethods = {"com.Well.testcases.Equity.Equity_TC_09_DocumentTest.Equity_TC_09_01_LegalDocument"})
		 @Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Equity_TC_09_02_AuditUploadDocumentScorecard(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Document Scorecard Functionality");
		try {
			rc.ScorecardNavigation();
			rc.CommonSingleUploadScorecardDocument("Offer Accessible Health Services", SheetName, rowNum, Commodity,AuditfileUpload ,false,false,false,false);
		    performance.clikOnDocumentLibrary();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = {"com.Well.testcases.Equity.Equity_TC_09_DocumentTest.Equity_TC_09_02_AuditUploadDocumentScorecard"})
	@Parameters({"SheetName", "rowNum", "Commodity","ProjectType" })
	public void Equity_TC_09_03_AuditDocument(String SheetName, int rowNum, String Commodity, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Document in Document");
		try {
			portfolio.ValidatingAuditUploadDocument(SheetName, rowNum, Commodity, ProjectType,"EB3","Technical Document (Audited)");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Equity.Equity_TC_09_DocumentTest.Equity_TC_09_03_AuditDocument" })
	@Parameters({"SheetName", "rowNum", "ProjectType","Commodity" })
	public void Equity_TC_09_04_FeatureDocument(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Document in Document");
		try {
			portfolio.ValidatingFeatureUploadDocument(SheetName, rowNum,Commodity, ProjectType,"EE1");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Equity.Equity_TC_09_DocumentTest.Equity_TC_09_04_FeatureDocument" })
	@Parameters({ "SheetName", "rowNum" })
	public void Equity_TC_09_05_SearchFilterDocumentWER(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Document in Document");
		try {
			rc.searchFilterDocument("FeatureFile","1");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Equity.Equity_TC_09_DocumentTest.Equity_TC_09_04_FeatureDocument" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Equity_TC_09_06_TaskUploadInDocumentLibray(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Document in Document library and verify fullfiled");
		try {
			performance.verifyUploadDocumentInTask(SheetName, rowNum,Commodity, "WPRLocationUploadButton","6/6 Locations", "PortfolioDocumentTaskUploadLocationCount");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
