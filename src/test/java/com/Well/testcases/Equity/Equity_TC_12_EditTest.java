package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;
public class Equity_TC_12_EditTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_11_AlternativesTest.Equity_TC_11_01_AAPAlternatives" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_12_editAndValidateOrganizationInformation(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Updating the Project field and validating");
		try {
			rc.editAndValidateOrganizationInformation(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_12_EditTest.Equity_TC_12_editAndValidateOrganizationInformation" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_12_editAndValidateAdmin(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Updating the Project field and validating");
		try {
			
	    	login.AdminLogin();
			equity.AdminSearchWer(SheetName,rowNum);
			rc.editAndValidateAdmin(SheetName, rowNum);
			rc.SignOut();
			login.Login();
			equity.SearchEquityByID(SheetName,rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
