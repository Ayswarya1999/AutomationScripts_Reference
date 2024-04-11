package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;


public class Equity_TC_08A_ScoreCardTest extends BaseClass{
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_07A_LocationTest.Equity_TC_07A_Location" })
	   @Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Equity_TC_08A_00_ScorecardUploadDocForAudit(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Upload Audit Scorecard document to Equity Project");

		try {
			rc.ScorecardNavigation();
			rc.CommonSingleUploadScorecardDocument("Incorporate Integrative Design", SheetName, rowNum, Commodity,AuditfileUpload ,false,false,false,false);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08A_ScoreCardTest.Equity_TC_08A_00_ScorecardUploadDocForAudit" })
	   @Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Equity_TC_08A_01_ScorecardUpdateUploadedDocForAudit(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Update Upload Audit Scorecard document to Equity Project");

		try {
			rc.CommonSingleUploadUpdateScorecardDocument("Incorporate Integrative Design","EE2", SheetName, rowNum, Commodity,AuditfileUpload ,false,false,false,false);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08A_ScoreCardTest.Equity_TC_08A_01_ScorecardUpdateUploadedDocForAudit" })
	   @Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Equity_TC_08A_02_ScorecardUploadDocForFeature(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Upload feature Scorecard document to Equity Project");

		try {
			rc.CommonSingleUploadScorecardDocument("Implement DEI Hiring Practices and Wage Equity", SheetName, rowNum, Commodity,FeaturefileUpload ,false,false,false,false);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08A_ScoreCardTest.Equity_TC_08A_02_ScorecardUploadDocForFeature" })
	   @Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Equity_TC_08A_03_ScorecardUpdateUploadDocForFeature(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Update Upload feature Scorecard document to Equity Project");

		try {
			rc.CommonSingleUploadUpdateScorecardDocument("Implement DEI Hiring Practices and Wage Equity","EH2", SheetName, rowNum, Commodity,FeaturefileUpload ,false,false,false,false);
		
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08A_ScoreCardTest.Equity_TC_08A_03_ScorecardUpdateUploadDocForFeature" })
	   @Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Equity_TC_08A_04_ValidatePaperIconInScorecard(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Update Upload feature Scorecard document to Equity Project");

		try {
			rc.paperIconWithoutRefresh("WERScoreCardFeatureC12PaperIcon");
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08A_ScoreCardTest.Equity_TC_08A_04_ValidatePaperIconInScorecard" })
	@Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Equity_TC_08A_05_ScorecardUploadDocForAlternatives(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Upload Alternative Scorecard document to Equity Project");

		try {
			rc.CommonSingleUploadScorecardDocument("Disclose and Evaluate Responsible Labor Practices", SheetName, rowNum, Commodity,AlternativeFileUpload ,false,false,false,false);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08A_ScoreCardTest.Equity_TC_08A_05_ScorecardUploadDocForAlternatives" })
	@Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Equity_TC_08A_06_ScorecardUpdateUploadDocForAlternatives(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Upload Alternative Scorecard document to Equity Project");

		try {
			rc.CommonSingleUploadUpdateScorecardDocument("Disclose and Evaluate Responsible Labor Practices","EH3", SheetName, rowNum, Commodity,AlternativeFileUpload ,false,false,false,false);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

}
