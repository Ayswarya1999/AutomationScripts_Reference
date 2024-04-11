package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_16_AlternativesV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_13A_EquityReviewV2ProjectTest.V2_TC_13A_13_AdminReviewimportHistory" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2_TC_16_00_ValidateAlternativeHealthSafetyOptEPV2Project(String SheetName, int rowNum)
			throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "EP Alternatives V2Project Functionality");
		try {
			rc.SignOut();
			login.Login();
			v2project.SearchV2ProjectById(SheetName, rowNum);
			rc.clickOnAlternatives(SheetName, rowNum);
			rc.alternativesEPNew(SheetName, rowNum, "v2-hsr","SC2 Reduce Surface Contact");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_16_AlternativesV2ProjectTest.V2_TC_16_00_ValidateAlternativeHealthSafetyOptEPV2Project" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2_TC_16_01_ValidateAlternativeHealthSafetyOptAAPV2Project(String SheetName, int rowNum)
			throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "AAP Alternatives V2Project Functionality");
		try {
			rc.alternativesAAPNew(SheetName, rowNum, "v2-hsr","SC1 Support Handwashing");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_16_AlternativesV2ProjectTest.V2_TC_16_01_ValidateAlternativeHealthSafetyOptAAPV2Project" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2_TC_16_02_ValidateAlternativePerformanceOptEPV2Project(String SheetName, int rowNum)
			throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "EP Alternatives V2Project Functionality");
		try {
			rc.alternativesEP(SheetName, rowNum, "wpr");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_16_AlternativesV2ProjectTest.V2_TC_16_02_ValidateAlternativePerformanceOptEPV2Project" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2_TC_16_03_ValidateAlternativePerformanceOptAAPV2Project(String SheetName, int rowNum)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "AAP Alternatives V2Project Functionality");
		try {
			rc.alternativesAAP(SheetName, rowNum, "wpr");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_16_AlternativesV2ProjectTest.V2_TC_16_03_ValidateAlternativePerformanceOptAAPV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_16_04_ValidateAlternativeEquityOptEPV2Project(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "EP Alternatives V2Project Functionality");
		try {
			rc.alternativesEP(SheetName, rowNum, "wer");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_16_AlternativesV2ProjectTest.V2_TC_16_04_ValidateAlternativeEquityOptEPV2Project" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2_TC_16_05_ValidateAlternativeEquityOptAAPV2Project(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "AAP Alternatives V2Project Functionality");
		try {
			rc.alternativesAAP(SheetName, rowNum, "wer");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

}
