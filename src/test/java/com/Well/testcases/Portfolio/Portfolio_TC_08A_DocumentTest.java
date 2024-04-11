package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_08A_DocumentTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_06_PortfolioLocationImportTest.Portfolio_TC_06_PortfolioLocationImport" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Portfolio_TC_08A_00_LegalUploadDocumentInDocument(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Type Legal Upload Document");

		try {
			portfolio.clickDocument();
			portfolio.ValidatingLegalUploadDocument(SheetName, rowNum, Commodity);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_08A_DocumentTest.Portfolio_TC_08A_00_LegalUploadDocumentInDocument" })
	 @Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Portfolio_TC_08A_01_FeatureUploadDocumentInDocument(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verifies Feature Upload Document in Document Library");

		try {
			portfolio.ValidatingFeatureUploadDocument(SheetName, rowNum,Commodity, ProjectType,"A02.1");
			portfolio.PortfolioBuildScorecard();
			rc.CommonSingleUploadScorecardDocument("Meet Thresholds for Inorganic Gases", SheetName, rowNum, Commodity,FeaturefileUpload ,false,false,false,false);
			rc.CommonSingleUploadScorecardDocument("Measure Air Parameters", SheetName, rowNum, Commodity,FeaturefileUpload ,false,false,false,false);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
