package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_CTC_04_DocumentUploadTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_03_ScorecardUploadTest.Portfolio_CTC_03_10_scorecardBeforeReviewReviewHistoryView" })
	@Parameters({ "SheetName","rowNum","ProjectType","Commodity" })
	public void Portfolio_CTC_04_00_AuditUploadDocument(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Portfolio Audit Document in DocumentLibrary");
		try {
			
			pfu.ValidatingAuditUploadDocument(SheetName, rowNum, ProjectType, Commodity);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_04_DocumentUploadTest.Portfolio_CTC_04_00_AuditUploadDocument" })
	@Parameters({ "SheetName","rowNum","ProjectType","Commodity" })
	public void Portfolio_CTC_04_01_FeatureUploadDocument(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Portfolio Feature Document in DocumentLibrary");
		try {	
			pfu.ValidatingFeatureUploadDocument(SheetName, rowNum, ProjectType, Commodity);	
		    
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_04_DocumentUploadTest.Portfolio_CTC_04_01_FeatureUploadDocument" })
	@Parameters({ "SheetName","rowNum","ProjectType","Commodity" })
	public void Portfolio_CTC_04_02_ScorecardHistoryView(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Portfolio Feature Document in DocumentLibrary");
		try {	
			
		    
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}