package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_CTC_08_ScorecardTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_06_PortfolioLocationImportTest.Portfolio_TC_06_PortfolioLocationImport" })
	@Parameters({ "SheetName", "rowNum"})
	public void Portfolio_CTC_08_00_purseYesValidFromScorecard(String SheetName, int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate purse Yes functionality");
		try {
			portfolio.SearchPortfolioById(SheetName,rowNum);
			portfolio.PortfolioBuildScorecard();
			pfu.purseYesValidFromScorecard();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_08_ScorecardTest.Portfolio_CTC_08_00_purseYesValidFromScorecard" })
	public void Portfolio_CTC_08_01_purseNoValidFromScorecard() throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate purse No functionality");
		try {
			pfu.purseNoValidFromScorecard();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_08_ScorecardTest.Portfolio_CTC_08_01_purseNoValidFromScorecard" })
	public void Portfolio_CTC_08_02_purseMaybeValidFromScorecard() throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate purse Maybe functionality");
		try {
			pfu.purseMaybeValidFromScorecard();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_08_ScorecardTest.Portfolio_CTC_08_02_purseMaybeValidFromScorecard" })
	@Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Portfolio_CTC_08_03_purseYesToNoValidFromScorecard(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate purse Yes to No functionality");
		try {
			pfu.purseYesToNoValidFromScorecard();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_08_ScorecardTest.Portfolio_CTC_08_03_purseYesToNoValidFromScorecard" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_CTC_08_04_purseMaybeToNoValidFromScorecard(String SheetName, int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate purse Maybe to No functionality");
		try {
			pfu.purseMaybeToNoValidFromScorecard();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_08_ScorecardTest.Portfolio_CTC_08_04_purseMaybeToNoValidFromScorecard" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_CTC_08_05_ValidAddOption(String SheetName, int rowNum, String Commodity) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate Added Option for Feature, Alternative and NA. Validate Removed Options functionality");
		try {
			pfu.validAddOption(SheetName, rowNum, "Prohibit Outdoor Smoking", Commodity, "Common");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_08_ScorecardTest.Portfolio_CTC_08_05_ValidAddOption" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_CTC_08_06_ValidAddAlternativeOption(String SheetName, int rowNum, String Commodity)
			throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate purse Yes  functionality");
		try {
			pfu.validAddOption(SheetName, rowNum, "Prohibit Outdoor Smoking", Commodity, "Alternative");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_08_ScorecardTest.Portfolio_CTC_08_06_ValidAddAlternativeOption" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_CTC_08_07_ValidAddNAOption(String SheetName, int rowNum, String Commodity)
			throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate purse Yes  functionality");
		try {
			pfu.validAddOption(SheetName, rowNum, "Prohibit Outdoor Smoking", Commodity, "NA");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_08_ScorecardTest.Portfolio_CTC_08_07_ValidAddNAOption" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_CTC_08_08_validAndCondition(String SheetName, int rowNum, String Commodity)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validation And Condition Functionality");

		try {
			pfu.validAndCondition(SheetName, rowNum, "Manage Window Use", Commodity);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_08_ScorecardTest.Portfolio_CTC_08_08_validAndCondition" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_CTC_08_09_ValidAddTierPoint(String SheetName, int rowNum, String Commodity)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validation Tier point Functionality");

		try {
			pfu.validAddTierPoint(SheetName, rowNum, "Increase Outdoor Air Supply", Commodity);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_08_ScorecardTest.Portfolio_CTC_08_09_ValidAddTierPoint" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_CTC_08_10_ValidAssignLocation(String SheetName, int rowNum, String Commodity)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validation Assign 10 and all Location Functionality");

		try {
			pfu.validAssignLocation(SheetName, rowNum, "Increase Outdoor Air Supply", Commodity);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_08_ScorecardTest.Portfolio_CTC_08_10_ValidAssignLocation" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_CTC_08_11_ValidAssignLocationFilter(String SheetName, int rowNum, String Commodity)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validation Assign Location Filter Functionality");

		try {
		
			pfu.validAssignLocationFilter(SheetName, rowNum, "Increase Outdoor Air Supply", Commodity);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_08_ScorecardTest.Portfolio_CTC_08_11_ValidAssignLocationFilter" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_CTC_08_12_UploadScorecardDocumentInTaskListCount(String SheetName, int rowNum, String Commodity)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate Pending Task count Filter Functionality");

		try {
			portfolio.clickDocument();
			pfu.UploadScorecardDocumentInTaskList();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_08_ScorecardTest.Portfolio_CTC_08_12_UploadScorecardDocumentInTaskListCount" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_CTC_08_12_DocListTaskLocationCountInPendingTab(String SheetName, int rowNum, String Commodity)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate Pending Task location count Filter Functionality");

		try {
			pfu.DocListTaskLocationCountInPendingTab();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Portfolio.Portfolio_CTC_08_ScorecardTest.Portfolio_CTC_08_12_DocListTaskLocationCountInPendingTab" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_CTC_08_12_DocListTaskLocationCountInFullFilledTab(String SheetName, int rowNum,
			String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Validate FullFilled Task count and completed task count Filter Functionality");
		try {
			pfu.DocListTaskLocationCountInFullFilledTab();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}

