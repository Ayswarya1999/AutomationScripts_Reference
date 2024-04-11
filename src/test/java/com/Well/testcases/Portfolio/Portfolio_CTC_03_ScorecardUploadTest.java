package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_CTC_03_ScorecardUploadTest extends BaseClass {

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_TC_06_PortfolioLocationImportTest.Portfolio_TC_06_PortfolioLocationImport" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_CTC_03_00_PortfolioBuildScorecard() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Build portfolio Scorecard custom scenarios");
		try {
			portfolio.PortfolioBuildScorecard();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_03_FeatureTest.Portfolio_CTC_03_00_PortfolioBuildScorecard" })
	@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
	public void Portfolio_CTC_03_01_FeatureScorecardUpload(String SheetName, int rowNum, String ProjectType,
			String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard Feature custom scenarios");
		try {
			/* Air A01.1 */
			if (ProjectType.contains("pilot")) {
				pfu.FeatureScorecardUpload(SheetName, rowNum, "WELL v2 pilot", ProjectType, Commodity,
						FeaturefileUpload, false, true, true, true);
			} else {
				pfu.FeatureScorecardUpload(SheetName, rowNum, "WELL v2", ProjectType, Commodity, FeaturefileUpload,
						false, true, true, true);
			}

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_03_FeatureTest.Portfolio_CTC_03_01_FeatureScorecardUpload" })
	@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
	public void Portfolio_CTC_03_02_FeatureScorecardUploadUpdate(String SheetName, int rowNum, String ProjectType,
			String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard Update Feature custom scenarios");
		try {
			/* Air A01.1 */
			pfu.FeatureScorecardUploadUpdate(SheetName, rowNum, ProjectType, Commodity);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_03_FeatureTest.Portfolio_CTC_03_02_FeatureScorecardUploadUpdate" })
	@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
	public void Portfolio_CTC_03_03_FeatureScorecardUploadValidAddedPartFeature(String SheetName, int rowNum,
			String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate Portfolio Scorecard Added Part Feature custom scenarios");
		try {
			/* Air A01.1 */
			pfu.FeatureScorecardUploadValidAddedFeature(SheetName, rowNum, ProjectType, Commodity);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_03_FeatureTest.Portfolio_CTC_03_03_FeatureScorecardUploadValidAddedPartFeature" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_CTC_03_04_ValidTaskCompletion(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate Complete Portfolio Scorecard custom scenarios");
		try {
			/* Air A01.1 */
			pfu.verifyTaskCompletion(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_03_FeatureTest.Portfolio_CTC_03_04_ValidTaskCompletion" })
	@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
	public void Portfolio_CTC_03_05_DeleteUploadFeatureDocument(String SheetName, int rowNum, String ProjectType,
			String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Delete Portfolio Scorecard Upload Document custom scenarios");
		try {
			/* Air A01.1 */
			pfu.verifyDeleteUploadFeature(SheetName, rowNum, "Ensure Drinking Water Access", ProjectType, Commodity);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_03_FeatureTest.Portfolio_CTC_03_05_DeleteUploadFeatureDocument" })
	@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
	public void Portfolio_CTC_03_06_AuditScorecardUpload(String SheetName, int rowNum, String ProjectType,
			String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard Audit custom scenarios");
		try {
			pfu.AuditScorecardUpload(SheetName, rowNum, ProjectType, Commodity, AuditfileUpload, false, true, false,
					false);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_03_FeatureTest.Portfolio_CTC_03_06_AuditScorecardUpload" })
	@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
	public void Portfolio_CTC_03_07_AlternativeScorecardUpload(String SheetName, int rowNum, String ProjectType,
			String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard Alternative custom scenarios");
		try {
			pfu.AlternativeScorecardUpload(SheetName, rowNum, ProjectType, Commodity, AlternativeFileUpload, false,
					true, false, false);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_03_FeatureTest.Portfolio_CTC_03_07_AlternativeScorecardUpload" })
	@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
	public void Portfolio_CTC_03_08_MaintenanceReportUploadButton(String SheetName, int rowNum, String ProjectType,
			String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,
				"Portfolio Scorecard Upload the Docs And Assign the Location Upload button should be enable");
		try {
			rc.CommonSingleUploadScorecardDocument("Implement Safety Plan for Non-Potable Water Capture and Reuse",
					SheetName, rowNum, Commodity, FeaturefileUpload, false, false, false, false);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_03_FeatureTest.Portfolio_CTC_03_08_MaintenanceReportUploadButton" })
	@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
	public void Portfolio_CTC_03_09_DataReportUploadButton(String SheetName, int rowNum, String ProjectType,
			String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,
				"Portfolio Scorecard Upload the Docs And Assign the Location Upload button should be enable");
		try {

			if (ProjectType.contains("pilot")) {
				rc.CommonSingleUploadScorecardDocument("Monitor Fundamental Air Parameters", SheetName, rowNum,
						Commodity, FeaturefileUpload, false, false, false, false);
			} else {
				rc.CommonSingleUploadScorecardDocument("Measure Air Parameters", SheetName, rowNum, Commodity,
						FeaturefileUpload, false, false, false, false);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_03_FeatureTest.Portfolio_CTC_03_09_DataReportUploadButton" })
	@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
	public void Portfolio_CTC_03_10_scorecardBeforeReviewReviewHistoryView(String SheetName, int rowNum, String ProjectType,
			String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,
				"Portfolio Scorecard Upload the Docs And Assign the Location Upload button should be enable");
		try {
			if (!ProjectType.contains("pilot")) {
			pfu.scorecardBeforeReviewReviewHistoryView(SheetName, rowNum, Commodity, "Provide Active Workstations");
			login.AdminLogin();
			portfolio.AdminSearch(SheetName, rowNum);
			portfolio.PortfolioBuildScorecard();
			pfu.scorecardBeforeReviewReviewHistoryViewAsAdmin("Provide Active Workstations");
			rc.SignOut();
			login.Login();
			portfolio.SearchPortfolioById(SheetName, rowNum);
			portfolio.PortfolioBuildScorecard();
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

}
