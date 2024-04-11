package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_12_EditTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_10_AlternativesTest.Performance_TC_10_AAPAlternatives" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_12_editAndValidateOrganizationInformation(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Updating the Project field and validating");
		try {
			rc.editAndValidateOrganizationInformation(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_12_EditTest.Performance_TC_12_editAndValidateOrganizationInformation" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_12_editAndValidateAdmin(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Updating the Project field and validating");
		try {
		login.AdminLogin();
			performance.AdminWprSearch(SheetName, rowNum);	
			rc.editAndValidateAdmin(SheetName, rowNum);
			rc.SignOut();
			login.Login();
			performance.SearchPerformanceByID(SheetName,rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
