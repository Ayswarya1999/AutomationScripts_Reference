package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class Equity_TC_07_LocationTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_06_WerProjectFieldValidationTest.Equity_TC_06_WerProjectFieldValidation" })
	@Parameters({ "Commodity"})
	public void Equity_TC_07_00_Location(String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Importing Locations to Equity Project");

		try {
			generic.importLocationGeneric(Commodity, PortfolioLocationImportfile);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_07_LocationTest.Equity_TC_07_00_Location" })
	@Parameters({ "SheetName","rowNum","ProjectType" })
	
	public void Equity_TC_07_01_AddLocation(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Adding new location");
		try {
			CommonMethod.refreshBrowser();
			rc.addLocation(SheetName, rowNum, ProjectType);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
}
