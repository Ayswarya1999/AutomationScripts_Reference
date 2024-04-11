package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_14_AddTeamMemberV2ProjectTest extends BaseClass {
	
	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_20_EditV2ProjectTest.V2_TC_20_03_EditAdminV2Project"})
	@Parameters({ "SheetName", "rowNum" })
	public void V2_TC_14_00_NavigatingToTeamAndValidateTeamPage(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Navigating To Team And Validate Team Page for V2");
		
        try {
        rc.clickOnTeamTab();
		rc.projectAdminTeam();
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_14_AddTeamMemberTest.V2_TC_14_00_NavigatingToTeamAndValidateTeamPage"})
	@Parameters({ "SheetName", "rowNum" })
	public void V2_TC_14_01_InviteTeam(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Inviting Team As member for V2");
		
        try {
			rc.inviteTeam();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_14_AddTeamMemberTest.V2_TC_14_01_InviteTeam"})
	@Parameters({ "SheetName", "rowNum" })
	public void V2_TC_14_02_AddingTeamMember(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Add member to Team for V2");
		
        try {
			rc.team(SheetName, rowNum);
			rc.validateAddedTeam();
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_14_AddTeamMemberTest.V2_TC_14_02_AddingTeamMember"})
	@Parameters({ "SheetName", "rowNum" })
	public void V2_TC_14_03_UpdatingAddTeamMember(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Update member to Team for V2");
		
        try {
        
			performance.EditTeamMemberRole(SheetName, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_14_AddTeamMemberTest.V2_TC_14_03_UpdatingAddTeamMember"})
	@Parameters({ "SheetName", "rowNum" })
	public void V2_TC_14_04_DeleteAddedTeamMember(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Add member to Team for V2");
		
        try {
        
        	rc.deleteAddedTeamMember(SheetName, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
