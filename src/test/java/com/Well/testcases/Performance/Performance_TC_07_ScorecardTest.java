package com.Well.testcases.Performance;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Performance_TC_07_ScorecardTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_06_LocationTest.Performance_TC_06_Location" })
	@Parameters({"API" })
	public void Performance_TC_07_00_VerifyReviewErrorMessageByMinScorecardPurseYes(String API) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Performance Scorecard Complete Functionality");
		try {
			
			if (API.equalsIgnoreCase("false")) {
			performance.VerifyReviewErrorMessageByMinScorecardPurseYes();	
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_07_ScorecardTest.Performance_TC_07_00_VerifyReviewErrorMessageByMinScorecardPurseYes" })
	@Parameters({ "SheetName","rowNum","API" })
	public void Performance_TC_07_01_CompleteScorecard(String SheetName,int rowNum, String API) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Performance Scorecard Complete Functionality");
		try {
			if (API.equalsIgnoreCase("false")) {
			performance.CompleteScorecardWprById(SheetName, rowNum);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_07_ScorecardTest.Performance_TC_07_01_CompleteScorecard" })
	@Parameters({ "SheetName","rowNum","Commodity","API" })
	public void Performance_TC_07_02_UploadDocumentScorecard(String SheetName,int rowNum, String Commodity, String API) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Document Scorecard Functionality");
		try {
			if (API.equalsIgnoreCase("false")) {
		        hsr.CommonBulkUploadScorecardDocument(21, SheetName, rowNum, Commodity, FeaturefileUpload ,false,false,false,false);
			}
			else {
				hsr.NavigateScorecard();
				commonAPI.storeRatingScorecardIdAPI(SheetName,rowNum,"wpr_scorecard_id");
				commonAPI.fillScorecardAPI(SheetName,rowNum, "ScorecardId");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_07_ScorecardTest.Performance_TC_07_02_UploadDocumentScorecard" })
	@Parameters({ "SheetName","rowNum","API" })
	public void Performance_TC_07_03_ScoreCardCount(String SheetName,int rowNum, String API) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verifies Scorecard Count");
		try {
			if (API.equalsIgnoreCase("false")) {
			rc.VerifyScorecardPurseStatusCount(SheetName, "38","21","17", rowNum);
			rc.VerifyPaperIconCount(SheetName,rowNum,"21");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_07_ScorecardTest.Performance_TC_07_03_ScoreCardCount" })
	@Parameters({ "SheetName","rowNum","API" })
	public void Performance_TC_07_04_ScoreCardSearchFilter(String SheetName,int rowNum, String API) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verifies Search Scorecard Filter Functionality");
		try {
			if (API.equalsIgnoreCase("false")) {
			performance.searchFilterScoreCard("Meet Thresholds for Particulate Matter");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_07_ScorecardTest.Performance_TC_07_04_ScoreCardSearchFilter" })
	@Parameters({ "SheetName","rowNum", "API" })
	public void Performance_TC_07_04_ScoreCardOptionFilter(String SheetName,int rowNum, String API) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verifies Scorecard Filter Options Functionality");
		try {
			if (API.equalsIgnoreCase("false")) {
			hsr.verifyScoreCardFilter("Response","21","WPRValidResponse");
			hsr.verifyScoreCardFilter("Verification","4","WPRValidVerification");
			hsr.verifyScoreCardFilter("Document Scale","35","WPRValidDocScale");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
}
