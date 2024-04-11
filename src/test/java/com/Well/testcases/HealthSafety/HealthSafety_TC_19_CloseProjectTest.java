package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class HealthSafety_TC_19_CloseProjectTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_18_SearchFilterByStatusTest.Healthsafety_TC_18_SearchFilterByStatus" })
	@Parameters({ "SheetName","rowNum"})
	public void HealthSafety_TC_19_00_MarkAndValidateHsrNaStatusForAdmin(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Mark and Validate HSR NA Status for Admin");
		try {
			login.AdminLogin();
			hsr.AdminHsrSearch(SheetName,rowNum);
			//hsr.MarkAndValidateHsrNaStatus(SheetName, rowNum);
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.HealthSafety_TC_19_CloseProjectTest.HealthSafety_TC_19_00_MarkAndValidateHsrNaStatusForAdmin" })
	@Parameters({ "SheetName","rowNum"})
	public void HealthSafety_TC_19_01_CloseProject(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Close project functionality");
		try {
			rc.ValidateCloseProject(SheetName, rowNum);
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
