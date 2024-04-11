package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_15A_ValidateAddedLocationFieldsTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_14_EditTest.Portfolio_TC_14_01_EditAndValidateAdminField" })
	@Parameters({ "SheetName", "rowNum" ,"ProjectType"})
	public void Portfolio_TC_15A_00_NavigateAddedLocationFields(String SheetName, int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Navigate to Portfolio location Account Successfully");

		try {
			portfolio.ValidateAddedLocationFields(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15A_ValidateAddedLocationFieldsTest.Portfolio_TC_15A_00_NavigateAddedLocationFields" })
	@Parameters({ "SheetName", "rowNum" ,"ProjectType"})
	public void Portfolio_TC_15A_01_ValidateFieldsAddedLocationEditProjectInformation(String SheetName, int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify Project Information field Successfully");

		try {
			portfolio.ValidateEditProjectInformation(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15A_ValidateAddedLocationFieldsTest.Portfolio_TC_15A_01_ValidateFieldsAddedLocationEditProjectInformation" })
	@Parameters({ "SheetName", "rowNum" ,"ProjectType"})
	public void Portfolio_TC_15A_02_ValidateFieldsAddedLocationEditOwnerInformation(String SheetName, int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify Owner Information field Successfully");

		try {
			
			portfolio.ValidateEditOwnerInformation(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15A_ValidateAddedLocationFieldsTest.Portfolio_TC_15A_02_ValidateFieldsAddedLocationEditOwnerInformation" })
	@Parameters({ "SheetName", "rowNum" ,"ProjectType"})
	public void Portfolio_TC_15A_03_ValidateFieldsAddedLocationEditAdminInformation(String SheetName, int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify Adding Portfolio Single Location Successfully");

		try {
			
			portfolio.ValidateEditAdmin(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
