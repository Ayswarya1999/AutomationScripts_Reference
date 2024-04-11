package com.Well.testcases.Community;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Community_TC_08_AlternativesTest extends BaseClass {
	
	@Test(dependsOnMethods = {"com.Well.testcases.Community.Community_TC_07_AddTeamMemberTest.Community_TC_07_05_ChangeProjectAdministrator" })
	@Parameters({ "SheetName", "rowNum" })
	public void Community_TC_08_01_ValidateAlternativeAAPCommunity(String SheetName, int rowNum)
			throws IOException {
	    TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "AAP Alternatives Community Functionality");
		try {
			
		    community.SearchCommunityListById(SheetName, rowNum);
			rc.clickOnAlternatives(SheetName, rowNum);			
			rc.alternativesAAP(SheetName, rowNum, "CommunityAAP");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Community.Community_TC_08_AlternativesTest.Community_TC_08_01_ValidateAlternativeAAPCommunity" })
	@Parameters({ "SheetName", "rowNum" })
	public void Community_TC_08_02_AAPAdminChangeStatusAndValidate(String SheetName, int rowNum)
			throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "AAP Alternatives Community Functionality");
		try {
			login.AdminLogin();
			community.CommunityAlternativeChangeStatusAndValidate(SheetName, rowNum, "AAP");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Community.Community_TC_08_AlternativesTest.Community_TC_08_02_AAPAdminChangeStatusAndValidate" })
	@Parameters({ "SheetName", "rowNum" })
	public void Community_TC_08_03_AAPProjectAdminChangeStatusAndValidateTest(String SheetName, int rowNum)
			throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "AAP Alternatives Community Functionality");
		try {
			rc.SignOut();
			login.Login();
			community.AAPProjectAdminChangeStatusAndValidate(SheetName, rowNum, "AAP");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Community.Community_TC_08_AlternativesTest.Community_TC_08_03_AAPProjectAdminChangeStatusAndValidateTest" })
	@Parameters({ "SheetName", "rowNum" })
	public void Community_TC_08_04_ValidateAlternativeEPCommunity(String SheetName, int rowNum)
			throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "EP Alternatives Community Functionality");
		try {
			rc.alternativesEP(SheetName, rowNum, "CommunityEP");
			community.validateAlternativesEP(SheetName, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Community.Community_TC_08_AlternativesTest.Community_TC_08_04_ValidateAlternativeEPCommunity" })
	@Parameters({ "SheetName", "rowNum" })
	public void Community_TC_08_05_EPAdminChangeStatusAndValidate(String SheetName, int rowNum)
			throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "EP Alternatives Community Functionality");
		try {
			login.AdminLogin();
			community.CommunityAlternativeChangeStatusAndValidate(SheetName, rowNum, "EP");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Community.Community_TC_08_AlternativesTest.Community_TC_08_05_EPAdminChangeStatusAndValidate" })
	@Parameters({ "SheetName", "rowNum" })
	public void Community_TC_08_06_EPPProjectAdminChangeStatusAndValidate(String SheetName, int rowNum)
			throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "AAP Alternatives Community Functionality");
		try {
			rc.SignOut();
			login.Login();
			community.AAPProjectAdminChangeStatusAndValidate(SheetName, rowNum, "EP");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}


}
