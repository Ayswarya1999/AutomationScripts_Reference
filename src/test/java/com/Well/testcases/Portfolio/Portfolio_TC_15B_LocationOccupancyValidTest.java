package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_15B_LocationOccupancyValidTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_07B_PortfolioScorecardSurveyTest.Portfolio_TC_07B_06_PortfolioDocumentPagination" })
	@Parameters({ "SheetName", "rowNum" ,"ProjectType","Upload","API"})
	public void Portfolio_TC_15B_00_AddSingleLocation(String SheetName, int rowNum, String ProjectType, String Upload, String API) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Adding single location Successfully");

		try {
			portfolio.addLocation(SheetName, rowNum, ProjectType, Upload, API);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15B_LocationOccupancyValidTest.Portfolio_TC_15B_00_AddSingleLocation" })
	@Parameters({ "SheetName", "rowNum"})
	public void Portfolio_TC_15B_01_AddSingleValidation(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verify Added locations data in Location Table and Additional Estimated number of occupants Successfully");
		try {
			portfolio.VerifySingleLocationTable(SheetName, rowNum);
			portfolio.VerifySingleLocationOccupancyInAdditionalTab(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15B_LocationOccupancyValidTest.Portfolio_TC_15B_00_AddSingleLocation" })
	@Parameters({ "SheetName", "rowNum"})
	public void Portfolio_TC_15B_02_DownloadOccupancylocationExcelValid(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Download Occupancy location Excel Estimated number of occupants Successfully");
		try {
			portfolio.DownloadOccupancylocationFile(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}