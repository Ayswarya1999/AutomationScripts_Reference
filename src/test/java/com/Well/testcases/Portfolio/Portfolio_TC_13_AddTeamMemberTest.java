package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_13_AddTeamMemberTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_15A_ValidateAddedLocationFieldsTest.Portfolio_TC_15A_03_ValidateFieldsAddedLocationEditAdminInformation"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_13_00_NavigateToTeam(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Navigate To Team");
		try {
	    	rc.SignOut();
		    login.Login();
		    portfolio.SearchPortfolioById(SheetName,rowNum);
			portfolio.clickOnTeamPortfolio(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_15A_ValidateAddedLocationFieldsTest.Portfolio_TC_13_00_NavigateToTeam"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_13_01_ProjectAdministratorValid(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate project Administrator Team");

		try {
			rc.projectAdminTeam();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_15A_ValidateAddedLocationFieldsTest.Portfolio_TC_13_01_ProjectAdministratorValid"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_13_02_InviteTeamMemberValid(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Adding invite Team");

		try {
			rc.inviteTeam();
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_15A_ValidateAddedLocationFieldsTest.Portfolio_TC_13_02_InviteTeamMemberValid"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_13_03_AddTeamMember(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Adding Team member");

		try {
			
			portfolio.teamPortfolio(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_15A_ValidateAddedLocationFieldsTest.Portfolio_TC_13_03_AddTeamMember"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_13_04_DeleteAddedTeamMember(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify team deletion");

		try {
			portfolio.deleteAddedTeamMemberPortfolio(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
