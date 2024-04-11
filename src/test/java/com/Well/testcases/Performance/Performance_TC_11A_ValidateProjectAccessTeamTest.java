package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_11A_ValidateProjectAccessTeamTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_11_TeamTest.Performance_TC_11_05_DeleteAddedTeamMember" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_11A_00_ValidateProjectAccessInTeamMember(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verifies user able to access the invited WPR project");
		try {
			rc.team(SheetName, rowNum);
			rc.SignOut();
			rc.teamMemberLogin(SheetName, rowNum);
			performance.validateTeamsWPR(SheetName, rowNum);	
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_11A_ValidateProjectAccessTeamTest.Performance_TC_11A_00_ValidateProjectAccessInTeamMember" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_11A_01_ValidateSearchPerformanceByStatus(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate ChangeAdminstrator To Team member for Project Functionality");
		try {
			rc.SignOut();
			login.Login();
			performance.SearchPerformanceByStatus(SheetName,rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_11A_ValidateProjectAccessTeamTest.Performance_TC_11A_01_ValidateSearchPerformanceByStatus" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_11A_02_ValidateChangeAdminstrator(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate ChangeAdminstrator To Team member for Project Functionality");
		try {
			rc.clickOnTeamTab();
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
