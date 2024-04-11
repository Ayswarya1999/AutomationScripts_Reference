package com.Well.testcases.Portfolio;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Portfolio_TC_15_AddLocationTest extends BaseClass {

	@Test//(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_07_PortfolioScorecardTest.Portfolio_TC_07_07_ValidateTaskCompletionOnAddingOptionFromDocEdit" })
	@Parameters({ "SheetName", "rowNum" ,"ProjectType","Upload","API"})
	public void Portfolio_TC_15_00_AddLocation(String SheetName, int rowNum, String ProjectType, String Upload, String API) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify Adding Portfolio Single Location Successfully");

		try {

		    portfolio.addLocation(SheetName, rowNum, ProjectType, Upload, API);

			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15_AddLocationTest.Portfolio_TC_15_00_AddLocation" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_15_01_ValidateDateAddedColumnAndCurrentDate(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Date Added Column and Current Date");

		try {
			portfolio.ValidateDateAddedColumnAndCurrentDate(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15_AddLocationTest.Portfolio_TC_15_01_ValidateDateAddedColumnAndCurrentDate" })
	@Parameters({ "SheetName", "rowNum", "Commodity", "ProjectType"})
	public void Portfolio_TC_15_02_ValidateDateAddedColumnAndCurrentDate(String SheetName, int rowNum, String Commodity, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify Create subset and Milestone tab Successfully");

		try {
			if (ProjectType.contains("pilot")) {
			portfolio.V2PilotCreateSubset(SheetName, rowNum, Commodity);
				
			} else {
			portfolio.PortfolioCreateSubset(SheetName, rowNum, Commodity);
			
			}
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15_AddLocationTest.Portfolio_TC_15_02_ValidateDateAddedColumnAndCurrentDate" })
	@Parameters({ "SheetName", "rowNum"})
	public void Portfolio_TC_15_03_Edit_Single_Location(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify Single Edit locations Successfully");

		try {
			portfolio.SingleEditlocation(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15_AddLocationTest.Portfolio_TC_15_03_Edit_Single_Location" })
	@Parameters({ "SheetName", "rowNum"})
	public void Portfolio_TC_15_04_Edit_Multiple_location(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify Edit Multiple locations Successfully");

		try {
			portfolio.EditMultipleLocation(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15_AddLocationTest.Portfolio_TC_15_04_Edit_Multiple_location" })
	@Parameters({ "SheetName", "rowNum"})
	public void Portfolio_TC_15_05_Search_locationCount(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify Search locations filter Successfully");

		try {
			portfolio.ValidateSearchLocation(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15_AddLocationTest.Portfolio_TC_15_05_Search_locationCount" })
	@Parameters({ "SheetName", "rowNum"})
	public void Portfolio_TC_15_06_Location_Filters(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify Locations filters Successfully");

		try {
			portfolio.locationFilters(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15_ValidateAddedLocationFieldsTest.Portfolio_TC_15_06_Location_Filters" })
	@Parameters({ "SheetName", "rowNum"})
	public void Portfolio_TC_15_07_Update_SingleOccupancy(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify Update locations occupancy Successfully");

		try {
			portfolio.VerifySingleUpdateOccupancy(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15_ValidateAddedLocationFieldsTest.Portfolio_TC_15_07_Update_SingleOccupancy" })
	@Parameters({ "SheetName", "rowNum"})
	public void Portfolio_TC_15_08_Update_MultipleOccupancy(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify Update locations occupancy Successfully");

		try {
			portfolio.VerifyMultipleUpdateOccupancy(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

}