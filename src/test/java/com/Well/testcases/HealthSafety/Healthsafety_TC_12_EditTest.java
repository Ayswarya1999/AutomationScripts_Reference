package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_12_EditTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_10_AlternativesTest.Healthsafety_TC_10_01_AAPAlternatives" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_12_00_editAndValidateOrganizationInformation(String SheetName,int rowNum) throws IOException {

	    TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Updating the Project field and validating");
		try {
			if (!TestNGTestName.contains("NonEnhanced")) {
			rc.editAndValidateOrganizationInformation(SheetName, rowNum);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_12_EditTest.Healthsafety_TC_12_00_editAndValidateOrganizationInformation" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_12_01_editAndValidateAdmin(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Updating the Project field and validating");
		try {
			if (!TestNGTestName.contains("NonEnhanced")) {
		login.AdminLogin();
		hsr.AdminHsrSearch(SheetName,rowNum);
		rc.editAndValidateAdmin(SheetName, rowNum);
		rc.SignOut();
		login.Login();
		hsr.SearchHealthSafetyByID(SheetName,rowNum);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_12_EditTest.Healthsafety_TC_12_01_editAndValidateAdmin" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_12_02_ValidationSealInDashboard(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validating Converting Private to Public Locations table list");
		try {
			if (!TestNGTestName.contains("NonEnhanced")) {
		hsr.ValidationSealAndDate();
		hsr.OrganizationInformationPrivateToPublic();
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
		}

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_12_EditTest.Healthsafety_TC_12_02_ValidationSealInDashboard" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_12_03_PrivateToPublicLocationValidation(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validating Converting Private to Public Locations table list");
		try {
			if (!TestNGTestName.contains("NonEnhanced")) {
			hsr.UpdateLocationPrivateToPublic();
			hsr.LocationProjectStatusValidation("YES");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
		}
}
