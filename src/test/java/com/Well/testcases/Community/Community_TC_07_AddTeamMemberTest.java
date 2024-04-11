package com.Well.testcases.Community;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Community_TC_07_AddTeamMemberTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Community.Community_TC_06_ProfileTest.Community_TC_06_Profile"})
	@Parameters({ "SheetName", "rowNum" })
	public void Community_TC_07_00_NavigatingToTeamAndValidateTeamPage(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Navigating To Team And Validate Team Page for Community");
		
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
	
	@Test(dependsOnMethods = {"com.Well.testcases.Community.Community_TC_07_AddTeamMemberTest.Community_TC_07_00_NavigatingToTeamAndValidateTeamPage"})
	@Parameters({ "SheetName", "rowNum" })
	public void Community_TC_07_01_InviteTeam(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Inviting Team As member for Community");
		
        try {
			rc.inviteTeam();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Community.Community_TC_07_AddTeamMemberTest.Community_TC_07_01_InviteTeam"})
	@Parameters({ "SheetName", "rowNum" })
	public void Community_TC_07_02_AddingTeamMember(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Add member to Team for Community");
		
        try {
			rc.team(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Community.Community_TC_07_AddTeamMemberTest.Community_TC_07_02_AddingTeamMember"})
	@Parameters({ "SheetName", "rowNum" })
	public void Community_TC_07_03_UpdatingAddTeamMember(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Update member to Team for Community");
		
        try {
        
			performance.EditTeamMemberRole(SheetName, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Community.Community_TC_07_AddTeamMemberTest.Community_TC_07_03_UpdatingAddTeamMember"})
	@Parameters({ "SheetName", "rowNum" })
	public void Community_TC_07_04_DeleteAddedTeamMember(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Delete member to Team for Community");
		
        try {
        
        	rc.deleteAddedTeamMember(SheetName, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Community.Community_TC_07_AddTeamMemberTest.Community_TC_07_04_DeleteAddedTeamMember"})
	@Parameters({ "SheetName", "rowNum" })
	public void Community_TC_07_05_ChangeProjectAdministrator(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Change Project Administrator for Community");
		
        try {
        	rc.changeProjectAdministrator(SheetName, rowNum);
        	rc.validateProjectAdministrator();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}

