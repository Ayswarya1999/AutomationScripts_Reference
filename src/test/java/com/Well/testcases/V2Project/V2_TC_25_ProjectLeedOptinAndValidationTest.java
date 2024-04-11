package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_25_ProjectLeedOptinAndValidationTest extends BaseClass {
	
	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_24_LeedScorecardV2ProjectTest.V2_TC_24_08_Verify12PointErrorMessageInScorecardConcept"})
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_25_01_EdittabProjectValidation(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verify Dashboard fields in V2 Project");
		try {
			v2project.ValidateLeedProjectInformationV2Project(SheetName, rowNum);
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_25_ProjectLeedOptinAndValidationTest.V2_TC_25_01_EdittabProjectValidation" })
	@Parameters({ "SheetName","rowNum","is_Leed"})
	public void V2_TC_25_02_LeedOptinAndDashboardValidation(String SheetName,int rowNum, boolean is_Leed) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verify Dashboard fields in V2 Project");
		try {
			v2project.EnrolledDashboardV2Project(SheetName, rowNum, is_Leed);
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}


}
