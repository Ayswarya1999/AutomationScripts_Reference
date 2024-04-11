package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_20_EditV2ProjectTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_19_ProfileV2ProjectTest.V2_TC_19_ProfileV2Project" })
	@Parameters({ "SheetName","rowNum","ProjectType"})
	public void V2_TC_20_00_EditProjectInformationV2Project(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Edit Project Information Functionality");
		try {
			if (!ProjectType.contains("pilot")) {
	      v2project.editAndValidateProjectInformationV2Project(SheetName, rowNum);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_20_EditV2ProjectTest.V2_TC_20_00_EditProjectInformationV2Project" })
	@Parameters({ "SheetName","rowNum","ProjectType"})
	public void V2_TC_20_01_EditOwnerInformationV2Project(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Edit Owner Information V2Project");
		try {
			if (!ProjectType.contains("pilot")) {
		v2project.editAndValidateOwnerInformationV2Project(SheetName, rowNum);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_20_EditV2ProjectTest.V2_TC_20_01_EditOwnerInformationV2Project" })
	@Parameters({ "SheetName","rowNum","ProjectType"})
	public void V2_TC_20_02_EditAddressV2Project(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Edit Address in V2Project Functionality");
		try {
			if (!ProjectType.contains("pilot")) {
		v2project.editAndValidateAddressV2Project(SheetName, rowNum);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_20_EditV2ProjectTest.V2_TC_20_02_EditAddressV2Project" })
	@Parameters({ "SheetName","rowNum","ProjectType"})
	public void V2_TC_20_03_EditAdminV2Project(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Edit Admin fields in V2Project");
		try {
			if (!ProjectType.contains("pilot")) {
			login.AdminLogin();
			v2project.editAndValidateAdminV2Project(SheetName, rowNum);
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
