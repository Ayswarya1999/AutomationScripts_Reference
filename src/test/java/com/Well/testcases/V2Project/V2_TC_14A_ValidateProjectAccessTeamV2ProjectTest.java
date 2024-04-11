package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_14A_ValidateProjectAccessTeamV2ProjectTest extends BaseClass {

    @Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_14_AddTeamMemberV2ProjectTest.V2_TC_14_04_DeleteAddedTeamMember" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_14A_00_ValidateProjectAccessTeamV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Adding team member V2Project");
		try {
			
			rc.clickOnTeamTab();
			rc.team(SheetName, rowNum);
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
		
}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_14A_ValidateProjectAccessTeamV2ProjectTest.V2_TC_14A_00_ValidateProjectAccessTeamV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_14A_01_ValidateScorecardAsTeamMember(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verifies user able to access the invited V2Project");
		try {
			rc.SignOut();
			rc.teamMemberLogin(SheetName, rowNum);
			v2project.SearchV2ProjectById(SheetName, rowNum);
			v2project.validateScorecardAsTeamMember();
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}