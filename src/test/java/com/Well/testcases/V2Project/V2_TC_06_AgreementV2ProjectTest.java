package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_06_AgreementV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_05_BillingV2ProjectTest.V2_TC_05_03_SearchV2ProjectFilters" })
	@Parameters({ "SheetName","rowNum","API","Commodity" })
	public void V2_TC_06_00_AgreementV2Project(String SheetName,int rowNum, String API,String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL v2 Project Agreement Sign");
		try {
			if (TestNGTestName.contains("WELL-V2-Main-CertificationProject-NoDiscount")) {
				v2project.VerifyDocumentPlusIconNotVisible(SheetName,rowNum, "Meet Thresholds for Particulate Matter");
				}
			if (API.equalsIgnoreCase("true")) {
				commonAPI.SignAgreementProject(SheetName, rowNum, Commodity);
		} 
			else {
			v2project.SignAgreementV2project(SheetName, rowNum);	
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_06_AgreementV2ProjectTest.V2_TC_06_00_AgreementV2Project" })
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_06_01_ValidateDocumentsTabTypeDropdown(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Documents Tab Type Dropdown");
		try {
			if (TestNGTestName.contains("Main")) {
			rc.clickDocument();
			v2project.ValidateDocumentsTabTypeDropdown(SheetName, rowNum);
			}
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
