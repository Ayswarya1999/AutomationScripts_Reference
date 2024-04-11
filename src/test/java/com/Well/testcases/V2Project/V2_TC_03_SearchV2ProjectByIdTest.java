package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_03_SearchV2ProjectByIdTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_02_RegisterV2ProjectTest.V2_TC_02_RegisterV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_03_00_SearchV2ProjectByIdAndValidateNotRegistered(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Certification Enrollment list Functionality");
		try {
			if (TestNGTestName.contains("Main")) {
			v2project.SearchV2ById(SheetName, rowNum);	
			v2project.SearchV2ProjectFilterByStatus(SheetName, rowNum, "Not Registered");
			v2project.ClickSearchV2ProjectById(SheetName, rowNum);
			//Admin Filter
			rc.SignOut();
			login.AdminLogin();;
			v2project.ValidateFilterStatusByAdmin(SheetName, rowNum, "Not Registered");
			v2project.ClickSearchV2ProjectById(SheetName, rowNum);
			rc.SignOut();
			login.Login();
			v2project.SearchV2ProjectById(SheetName, rowNum);	
			}
			v2project.SearchV2ProjectById(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_SF_01_SearchV2ProjectByNRStatusTest.V2_TC_03_00_SearchV2ProjectByIdAndValidateNotRegistered" })
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_03_01_DashboardV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verify Dashboard fields in V2 Project");
		try {
			if (TestNGTestName.contains("Main")) {
			v2project.DashboardV2Project(SheetName, rowNum);
			}
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_03_SearchV2ProjectByIdTest.V2_TC_03_01_DashboardV2Project" })
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_03_02_ValidateAlternativesTabDisabledButtons(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Alternatives Tab Disabled Buttons");
		try {
			if (TestNGTestName.contains("Main")) {
			v2project.ValidateAlternativesTabDisabledButtons(SheetName, rowNum);
			}
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_03_SearchV2ProjectByIdTest.V2_TC_03_01_DashboardV2Project" })
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_03_03_ValidateAdminOverviewTabEmptyVersionDropdown(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Disabled Data");
		try {
			if (TestNGTestName.contains("Main")) {
			login.AdminLogin();
			v2project.AdminSearchById(SheetName, rowNum);
			v2project.ValidateAdminOverviewTabEmptyVersionDropdown(SheetName, rowNum);
			rc.SignOut();
			login.Login();
			v2project.SearchV2ProjectById(SheetName, rowNum);	
			}
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
