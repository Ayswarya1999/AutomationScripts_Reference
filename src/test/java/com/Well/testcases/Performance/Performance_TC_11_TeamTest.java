package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_11_TeamTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_16_DownloadBillingAndValidateTest.Performance_TC_16_DownloadBillingAndValidate" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_11_00_NavigateToTeam(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Adding Inviting Team member for Project Functionality");
		try {
			rc.clickOnTeamTab();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_11_TeamTest.Performance_TC_11_00_NavigateToTeam" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_11_01_ValidateProjectAdminTeam(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Adding Inviting Team member for Project Functionality");
		try {
			
			rc.projectAdminTeam();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_11_TeamTest.Performance_TC_11_01_ValidateProjectAdminTeam" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_11_02_SentInviteTeam(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Inviting Team member for Project Functionality");
		try {
			
			rc.inviteTeam();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_11_TeamTest.Performance_TC_11_02_SentInviteTeam" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_11_03_AddMemberTeam(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Adding Team member for Project Functionality");
		try {
			rc.team(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_11_TeamTest.Performance_TC_11_03_AddMemberTeam" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_11_04_EditTeamMemberRole(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Adding Inviting Team member for Project Functionality");
		try {
			performance.EditTeamMemberRole(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_11_TeamTest.Performance_TC_11_04_EditTeamMemberRole" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_11_05_DeleteAddedTeamMember(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Adding Inviting Team member for Project Functionality");
		try {
			performance.deleteAddedTeamMember(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	

}
