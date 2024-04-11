package com.Well.testcases.Community;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Community_TC_05_EditTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Community.Community_TC_04_BillingTest.Community_TC_04_01_DownloadBillingReceiptAndValidate" })
	@Parameters({ "SheetName","rowNum" })
	public void Community_TC_05_00_EditProjectInformation(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Edit Project Information Functionality");
		try {
			community.editAndValidateProjectInformation(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Community.Community_TC_05_EditTest.Community_TC_05_00_EditProjectInformation" })
	@Parameters({ "SheetName","rowNum","Country" })
	public void Community_TC_05_01_EditOwnerInformation(String SheetName,int rowNum, String Country) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Edit Owner Information V2Project");
		try {
			community.editAndValidateOwnerInformation(SheetName, rowNum,Country);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	

	
	@Test(dependsOnMethods = { "com.Well.testcases.Community.Community_TC_05_EditTest.Community_TC_05_01_EditOwnerInformation" })
	@Parameters({ "SheetName","rowNum" })
	public void Community_TC_05_02_EditAdmin(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Edit Admin fields in V2Project");
		try {
			login.AdminLogin();
			community.editAndValidateAdmin(SheetName, rowNum);
			 rc.SignOut();
				login.Login();
				community.SearchCommunityListById(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
