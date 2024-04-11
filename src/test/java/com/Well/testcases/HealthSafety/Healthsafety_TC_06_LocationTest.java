package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_06_LocationTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_05_HsrProjectFieldValidationTest.Healthsafety_TC_05_HsrProjectFieldValidation" })
	@Parameters({ "Commodity"})
	public void Healthsafety_TC_06_00_Location(String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Importing Locations to HSR Project");

		try {
			generic.importLocationGeneric(Commodity, PortfolioLocationImportfile);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_06_LocationTest.Healthsafety_TC_06_00_Location" })
@Parameters({ "SheetName","rowNum" })
public void Healthsafety_TC_06_01_Location(String SheetName,int rowNum) throws IOException {

	TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

	StartTest(TestCaseName,"Validating Private Locations table list");

	try {
		hsr.LocationProjectStatusValidation("NO");
		
	} catch (Throwable t) {
		System.out.println(t.getLocalizedMessage());
		Error e1 = new Error(t.getMessage());
		e1.setStackTrace(t.getStackTrace());
		throw e1;
	}
}

@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_06_LocationTest.Healthsafety_TC_06_00_Location" })
@Parameters({ "SheetName","rowNum" })
public void Healthsafety_TC_06_02_DownloadLocation(String SheetName,int rowNum) throws IOException {

	TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

	StartTest(TestCaseName,"Download Locations file and verify location table list");

	try {
		rc.DownloadLocationFile(SheetName, rowNum);
		
	} catch (Throwable t) {
		System.out.println(t.getLocalizedMessage());
		Error e1 = new Error(t.getMessage());
		e1.setStackTrace(t.getStackTrace());
		throw e1;
	}
}
}