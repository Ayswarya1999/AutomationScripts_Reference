package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_07_ScorecardTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.HealthSafety.Healthsafety_TC_06_LocationTest.Healthsafety_TC_06_02_DownloadLocation" })
	@Parameters({ "SheetName", "rowNum", "API" })
	public void Healthsafety_TC_07_00_VerifyReviewErrorMessageByMinScorecardPurseYes(String SheetName, int rowNum,
			String API) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Performance Scorecard Complete Functionality");
		try {
			
			if (!API.equalsIgnoreCase("true") || TestNGTestName.contains("NonEnhanced")) {
				hsr.VerifyReviewErrorMessageByMinScorecardPurseYes();
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.HealthSafety.Healthsafety_TC_07_ScorecardTest.Healthsafety_TC_07_00_VerifyReviewErrorMessageByMinScorecardPurseYes" })
	@Parameters({ "SheetName", "rowNum", "API" })
	public void Healthsafety_TC_07_01_CompleteScorecard(String SheetName, int rowNum, String API) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "HealthSafety Scorecard Complete Functionality");
		try {
			hsr.NavigateScorecard();
			hsr.CompleteScorecardHsrById(SheetName, rowNum);
			rc.ValidFeatureDuplication();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.HealthSafety.Healthsafety_TC_07_ScorecardTest.Healthsafety_TC_07_01_CompleteScorecard" })
	@Parameters({ "SheetName", "rowNum", "API", "Commodity" })
	public void Healthsafety_TC_07_02_UploadScorecardDocument(String SheetName, int rowNum, String API,
			String Commodity) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Scorecard Document Functionality");
		try {
			if (TestNGTestName.contains("NonEnhanced")) {
				hsr.uploadDocumentInFeatureNonEnhance(15);
			} else {
				hsr.CommonBulkUploadScorecardDocument(15, SheetName, rowNum, Commodity, FeaturefileUpload, false, false,
						false, false);

			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.HealthSafety.Healthsafety_TC_07_ScorecardTest.Healthsafety_TC_07_02_UploadScorecardDocument" })
	@Parameters({ "SheetName", "rowNum", "API" })
	public void Healthsafety_TC_07_03_ScorecardCount(String SheetName, int rowNum, String API) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate scorecard count");
		try {
			if (!API.equalsIgnoreCase("true")) {
				rc.VerifyScorecardPurseStatusCount(SheetName, "29", "15", "14", rowNum);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.HealthSafety.Healthsafety_TC_07_ScorecardTest.Healthsafety_TC_07_03_ScorecardCount" })
	@Parameters({ "SheetName", "rowNum", "API" })
	public void Healthsafety_TC_07_04_PaperIconCount(String SheetName, int rowNum, String API) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate scorecard count");
		try {
			if (!API.equalsIgnoreCase("true")) {
				rc.VerifyPaperIconCount(SheetName, rowNum, "15");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.HealthSafety.Healthsafety_TC_07_ScorecardTest.Healthsafety_TC_07_04_PaperIconCount" })
	@Parameters({ "SheetName", "rowNum", "API" })
	public void Healthsafety_TC_07_05_WeightIconCount(String SheetName, int rowNum, String API) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate scorecard count");
		try {
			if (!API.equalsIgnoreCase("true")) {
				rc.VerifyWeightIconCount(SheetName, rowNum, "15");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.HealthSafety.Healthsafety_TC_07_ScorecardTest.Healthsafety_TC_07_05_WeightIconCount" })
	@Parameters({ "SheetName", "rowNum", "API" })
	public void Healthsafety_TC_07_06_FilterResponse(String SheetName, int rowNum, String API) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Scorecard Filter Response Functionality");
		try {
			if (!API.equalsIgnoreCase("true")) {
				hsr.verifyScoreCardFilter("Response", "15", "HsrScorecardPurseStatusYesValid");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.HealthSafety.Healthsafety_TC_07_ScorecardTest.Healthsafety_TC_07_06_FilterResponse" })
	@Parameters({ "SheetName", "rowNum", "API" })
	public void Healthsafety_TC_07_07_FilterVerification(String SheetName, int rowNum, String API) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Scorecard Filter Verification Functionality");
		try {
			if (!API.equalsIgnoreCase("true")) {
				hsr.verifyScoreCardFilter("Verification", "4", "WPRValidVerification");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.HealthSafety.Healthsafety_TC_07_ScorecardTest.Healthsafety_TC_07_07_FilterVerification" })
	@Parameters({ "SheetName", "rowNum", "API" })
	public void Healthsafety_TC_07_08_FilterDocumentScale(String SheetName, int rowNum, String API) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Scorecard Filter Verification Functionality");
		try {
			if (!API.equalsIgnoreCase("true")) {
				hsr.verifyScoreCardFilter("Document Scale", "1", "HsrScorecardFilterFeatureValid");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.HealthSafety.Healthsafety_TC_07_ScorecardTest.Healthsafety_TC_07_08_FilterDocumentScale" })
	@Parameters({ "SheetName", "rowNum", "API" })
	public void Healthsafety_TC_07_09_SearchFilter(String SheetName, int rowNum, String API) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Scorecard Filter Verification Functionality");
		try {
			if (!API.equalsIgnoreCase("true")) {
				performance.searchFilterScoreCard("Support Handwashing");
				
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
