package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_04_EnrollV2ProjectTest extends BaseClass {
	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_03_SearchV2ProjectByIdTest.V2_TC_03_03_ValidateAdminOverviewTabEmptyVersionDropdown" })
	@Parameters({ "SheetName","rowNum","ProjectType","Country","is_Leed","API", "Commodity","Type" })
	public void V2_TC_04_00_EnrollV2Project(String SheetName,int rowNum, String ProjectType, String Country,boolean is_Leed, String API, String Commodity, String Type) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Enroll WELL Certification Project");
		try {
		if (API.equalsIgnoreCase("true")) {
			commonAPI.RegisterProject(SheetName, rowNum, Country, Type, Commodity);
	} 
		else {
			v2project.EnrollV2ProjectById(SheetName, rowNum, Type, Country,is_Leed);
		}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_04_EnrollV2ProjectTest.V2_TC_04_00_EnrollV2Project" })
	@Parameters({ "SheetName","rowNum","API"})
	public void V2_TC_04_01_ValidateRegistrationInProgress(String SheetName,int rowNum, String API) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Enroll WELL Certification Project");
		try {
			if (TestNGTestName.contains("Main")) {
			v2project.SearchV2ById(SheetName, rowNum);	
			v2project.SearchV2ProjectFilterByStatus(SheetName, rowNum, "Registration in progress");
			v2project.ClickSearchV2ProjectById(SheetName, rowNum);	
			rc.SignOut();
			login.AdminLogin();
			v2project.ValidateFilterStatusByAdmin(SheetName, rowNum, "Registration in progress");
			v2project.ClickSearchV2ProjectById(SheetName, rowNum);
			rc.SignOut();
			login.Login();
			}
			v2project.SearchV2ProjectById(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
