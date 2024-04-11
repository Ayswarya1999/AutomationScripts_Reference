package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Portfolio_TC_06A_PortfolioLocationImportAreaTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_05_PortfolioPaymentTest.Portfolio_TC_05_PortfolioPayment" })
	@Parameters({ "Commodity"})
	public void Portfolio_TC_06A_00_PortfolioLocationImportArea(String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Importing Locations to WELL At Scale Project");

		try {
			generic.importLocationGeneric(Commodity, ImportfilePortfolioLocationArea);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}	
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_06A_PortfolioLocationImportAreaTest.Portfolio_TC_06A_00_PortfolioLocationImportArea" })
	@Parameters({ "SheetName", "rowNum"})
	public void Portfolio_TC_06A_01_ImportOccupancyValidation(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify Update locations occupancy Successfully");

		try {
			portfolio.LocationImportAreaValid(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_06A_PortfolioLocationImportAreaTest.Portfolio_TC_06A_01_ImportOccupancyValidation" })
	@Parameters({ "SheetName", "rowNum"})
	public void Portfolio_TC_06A_02_UpdateAndvalidOccupancyValidation(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify Update locations occupancy Successfully");

		try {
			portfolio.EditOccupancylocation(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
