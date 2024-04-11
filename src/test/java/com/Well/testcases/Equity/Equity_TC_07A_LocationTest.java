package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_07A_LocationTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_06_WerProjectFieldValidationTest.Equity_TC_06_WerProjectFieldValidation" })
	@Parameters({ "SheetName","rowNum", "Commodity" })
	public void Equity_TC_07A_Location(String SheetName,int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Importing 100+ Locations to Equity Project");

		try {
			generic.importLocationGeneric(Commodity, ImportfileHundredPlusLocations);
			rc.validImportHundredPlusLocations(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	

}
