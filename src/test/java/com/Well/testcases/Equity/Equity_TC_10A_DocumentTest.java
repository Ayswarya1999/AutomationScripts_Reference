package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;


public class Equity_TC_10A_DocumentTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_19A_ValidLocationCountTest.Equity_TC_19A_ValidLocationCount"})
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Equity_TC_10A_01_LegalDocument(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Legal Document in Document");
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
	
	
	@Test(dependsOnMethods = {"com.Well.testcases.Equity.Equity_TC_10A_DocumentTest.Equity_TC_10A_01_LegalDocument" })
	@Parameters({"SheetName", "rowNum", "Commodity","ProjectType" })
	public void Equity_TC_10A_02_FeatureDocument(String SheetName, int rowNum,String Commodity, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Feature Document in Document");
		try {
			portfolio.ValidatingFeatureUploadDocument(SheetName, rowNum, Commodity, ProjectType,"EE1");
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
}
