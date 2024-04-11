package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_23_ValidateAdminAlternativeV2ProjectTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_14A_ValidateProjectAccessTeamV2ProjectTest.V2_TC_14A_01_ValidateScorecardAsTeamMember" })
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_23_00_LoginWithAdmin(String SheetName,int rowNum) throws IOException {

	    TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Login With Admin Functionality");
		try {
			login.AdminLogin();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_23_ValidateAdminAlternativeV2ProjectTest.V2_TC_23_00_LoginWithAdmin" })
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_23_01_ValidateAdminAlternativeAAPV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Admin Alternative AAP V2Project");
		try {
		rc.AlternativeChangeStatusAndValidate(SheetName, rowNum, "AAP");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
