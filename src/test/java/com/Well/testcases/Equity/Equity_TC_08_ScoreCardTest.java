package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_08_ScoreCardTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_07_LocationTest.Equity_TC_07_01_AddLocation" })
    @Parameters({ "SheetName","rowNum" })
    public void Equity_TC_08_00_VerifyReviewErrorMessageByMinScorecardPurseYes() throws IOException {

	TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
    StartTest(TestCaseName,"Performance Scorecard Complete Functionality");
	try {
		
		performance.VerifyReviewErrorMessageByMinScorecardPurseYes();	
	} catch (Throwable t) {
		System.out.println(t.getLocalizedMessage());
		Error e1 = new Error(t.getMessage());
		e1.setStackTrace(t.getStackTrace());
		throw e1;
	}
}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_08_00_VerifyReviewErrorMessageByMinScorecardPurseYes" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_08_01_CompleteScorecardWerById(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Performance Scorecard Complete Functionality");
		try {
			equity.CompleteScorecardWerById(SheetName,rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_08_01_CompleteScorecardWerById" })
	@Parameters({ "SheetName","rowNum","Commodity" })
	public void Equity_TC_08_02_UploadWERDocForFeature(String SheetName,int rowNum, String Commodity) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Upload Document Scorecard Functionality");
		try {
			hsr.CommonBulkUploadScorecardDocument(21, SheetName, rowNum, Commodity, FeaturefileUpload ,false,false,false,false);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_08_02_UploadWERDocForFeature" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_08_03_ScoreCardCount(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate scorecard count");
		try {
			rc.VerifyScorecardPurseStatusCount(SheetName, "49", "21", "28", rowNum);
			rc.VerifyPaperIconCount(SheetName,rowNum,"21");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_08_03_ScoreCardCount" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_08_04_ScoreCardSearchFilter(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verifies Search Scorecard Filter Functionality");
		try {
			performance.searchFilterScoreCard("Create DEI Assessment and Action Plan");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_08_04_ScoreCardSearchFilter" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_08_05_ScoreCardOptionFilter(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verifies Scorecard Filter Options Functionality");
		try {
			hsr.verifyScoreCardFilter("Response","21","WPRValidResponse");
			hsr.verifyScoreCardFilter("Verification","4","WPRValidVerification");
			hsr.verifyScoreCardFilter("Document Scale","10","WPRValidDocScale");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_08_04_ScoreCardSearchFilter" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_08_06_ScoreCardPurseSearchFilter(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verifies Scorecard Purse location filter Functionality");
		try {
			rc.ScorecardPurseSearchFilter("Create DEI Assessment and Action Plan");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_08_06_ScoreCardPurseSearchFilter" })
	@Parameters({ "SheetName","rowNum", "Commodity" })
	public void Equity_TC_08_07_ScoreCardUploadAlternativeDocument(String SheetName,int rowNum, String Commodity) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Alternative Document Functionality");
		try {
			rc.CommonSingleUploadScorecardDocument("Promote Health Benefits", SheetName, rowNum, Commodity, AlternativeFileUpload, false, false, false, false);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
