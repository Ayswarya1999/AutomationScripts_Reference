package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_17_OverviewAndValidateRegisterFieldsAndPaginationV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_16_AlternativesV2ProjectTest.V2_TC_16_05_ValidateAlternativeEquityOptAAPV2Project" })
	@Parameters({ "SheetName","rowNum", "ProjectType" })
	public void V2_TC_17_00_OverviewAndValidateRegisterFieldsV2Project(String SheetName,int rowNum, String ProjectType) throws IOException {

	    TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Overview V2 Project And Validate Register Fields");
		try {
			if (!ProjectType.contains("pilot")) {
		v2project.overviewV2Project(SheetName, rowNum);	
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_17_OverviewAndValidateRegisterFieldsAndPaginationV2ProjectTest.V2_TC_17_00_OverviewAndValidateRegisterFieldsV2Project" })
	@Parameters({ "SheetName","rowNum", "ProjectType" })
	public void V2_TC_17_01_DocumentPaginationV2Project(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Valiate Pagination in Document list");
		try {
		
		v2project.ValidatingPaginitionUploadDocument();	
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
}
