package com.Well.testcases.Community;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Community_TC_04_BillingTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Community.Community_TC_03_SearchListByIdTest.Community_TC_03_SearchListById" })
	@Parameters({ "SheetName","rowNum","Country" })
	public void Community_TC_04_00_BillingCommunity(String SheetName,int rowNum, String Country) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL Community Card Payment Functionality");
		try {
		v2project.ClickBilling(SheetName, rowNum);
		rc.Billing(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Community.Community_TC_04_BillingTest.Community_TC_04_00_BillingCommunity" })
	@Parameters({ "SheetName","rowNum","Country" })
	public void Community_TC_04_01_DownloadBillingReceiptAndValidate(String SheetName,int rowNum, String Country) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Download and Validate Billing Receipt");
		try {	
		v2project.DownloadBillingReceiptAndValidate(SheetName, rowNum,Country);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
