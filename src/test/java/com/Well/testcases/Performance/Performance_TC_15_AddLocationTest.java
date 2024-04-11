package com.Well.testcases.Performance;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Performance_TC_15_AddLocationTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_14_ProfileTest.Performance_TC_14_Profile" })
	@Parameters({ "SheetName","rowNum", "ProjectType" })
	public void Performance_TC_15_00_AddLocation(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Adding new location");
		try {
			rc.addLocation(SheetName, rowNum,ProjectType);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_15_AddLocationTest.Performance_TC_15_00_AddLocation" })
	@Parameters({ "SheetName","rowNum", "ProjectType" })
	public void Performance_TC_15_01_CreateSubset(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Adding new location");
		try {
			rc.CreateSubset(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_15_AddLocationTest.Performance_TC_15_01_CreateSubset" })
	@Parameters({ "SheetName","rowNum", "ProjectType" })
	public void Performance_TC_15_02_Edit_SingleLocation(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Update Added new location");
		try {
			performance.Editlocation(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_15_AddLocationTest.Performance_TC_15_02_Edit_SingleLocation" })
	@Parameters({ "SheetName","rowNum", "ProjectType" })
	public void Performance_TC_15_03_Location_Filters(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate location Filters");
		try {
			performance.locationFilters(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_15_AddLocationTest.Performance_TC_15_03_Location_Filters" })
	@Parameters({ "SheetName","rowNum", "ProjectType" })
	public void Performance_TC_15_04_UpdateProfile(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Update Profile");
		try {
			performance.updateProfile(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
