package com.Well.testcases.Performance;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Performance_TC_08_DocumentTest extends BaseClass {
	
	@Test(dependsOnMethods = {"com.Well.testcases.Performance.Performance_TC_07A_PromotionTest.Performance_TC_07A_01_ValidateCardCountBeforeAchieved"})
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Performance_TC_08_01_LegalDocument(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Upload Document in Document");
		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
			performance.clikOnDocumentLibrary();
			portfolio.ValidatingLegalUploadDocument(SheetName, rowNum, Commodity);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Performance.Performance_TC_08_DocumentTest.Performance_TC_08_01_LegalDocument" })
	@Parameters({ "SheetName", "rowNum", "ProjectType","Commodity" })
	public void Performance_TC_08_02_FeatureDocument(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Upload Document in Document");
		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
			portfolio.ValidatingFeatureUploadDocument(SheetName, rowNum, Commodity, ProjectType,"PX1.1");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_08_DocumentTest.Performance_TC_08_02_FeatureDocument" })
	 @Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Performance_TC_08_03_AuditUploadDocumentScorecard(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {
		
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Document Scorecard Functionality");
		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
			rc.ScorecardNavigation();
			rc.CommonSingleUploadScorecardDocument("Survey for Thermal Comfort", SheetName, rowNum, Commodity,AuditfileUpload ,false,false,false,false);
		performance.clikOnDocumentLibrary();
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Performance.Performance_TC_08_DocumentTest.Performance_TC_08_03_AuditUploadDocumentScorecard"})
	@Parameters({"SheetName", "rowNum", "ProjectType","Commodity" })
	public void Performance_TC_08_04_AuditDocument(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Upload Document in Document");
		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
			portfolio.ValidatingAuditUploadDocument(SheetName, rowNum, Commodity, ProjectType,"PX5","Technical Document (Audited)");
			}
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = {"com.Well.testcases.Performance.Performance_TC_08_DocumentTest.Performance_TC_08_04_AuditDocument"})
	@Parameters({ "SheetName", "rowNum" })
	public void Performance_TC_08_05_SearchFilterDocument(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Upload Document in Document");
		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
			rc.searchFilterDocument("FeatureFile","1");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = {"com.Well.testcases.Performance.Performance_TC_08_DocumentTest.Performance_TC_08_05_SearchFilterDocument"})
	@Parameters({ "SheetName", "rowNum" })
	public void Performance_TC_08_06_TaskFilter(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Verify task filter option in task tab");
		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
			performance.taskFilter(SheetName, SheetName);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = {"com.Well.testcases.Performance.Performance_TC_08_DocumentTest.Performance_TC_08_06_TaskFilter"})
	@Parameters({ "SheetName", "rowNum" })
	public void Performance_TC_08_07_searchLocationFilter(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Verify search location filter in task tab");
		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
			performance.verifySearchLocationFilter(SheetName, rowNum);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Performance.Performance_TC_08_DocumentTest.Performance_TC_08_07_searchLocationFilter"})
	@Parameters({ "SheetName", "rowNum" })
	public void Performance_TC_08_08_DocumentFilter(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Verify document filter option in document tab");
		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
			performance.documentFilter(SheetName, SheetName);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}

	}	
	
	@Test(dependsOnMethods = {"com.Well.testcases.Performance.Performance_TC_08_DocumentTest.Performance_TC_08_08_DocumentFilter"})
	@Parameters({ "SheetName", "rowNum" })
	public void Performance_TC_08_09_ValidatePagination(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Verify Document library pagination fucntionality");
		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
			performance.DocumentPagination();
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Performance.Performance_TC_08_DocumentTest.Performance_TC_08_09_ValidatePagination"})
	@Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Performance_TC_08_10_ValidateScorecardPagination(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Verify Scorecard pagination fucntionality");
		try {
			if (!TestNGTestName.contains("WPR-Renewal")) {
			rc.clickScorecard();
			rc.scorecardPagination("Measure Air Parameters",SheetName, rowNum, Commodity,AlternativeFileUpload ,false,false,false,false);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
