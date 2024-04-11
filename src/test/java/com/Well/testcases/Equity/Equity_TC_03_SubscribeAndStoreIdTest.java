package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_03_SubscribeAndStoreIdTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_02_RegisterAndValidateTest.Equity_TC_02_RegisterAndValidate" })
	@Parameters({ "SheetName","rowNum","Country","ProjectType","API","Commodity" })
	public void Equity_TC_03_00_Subscribe(String SheetName,int rowNum,String Country, String ProjectType,String API,String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Subscribe the Equity Functionality");

		try {
			if (API.equalsIgnoreCase("true")) {
				commonAPI.BillingProject(SheetName, rowNum, Country, ProjectType, Commodity);	
		} 
			else {
				rc.Billing(SheetName, rowNum);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_03_SubscribeAndStoreIdTest.Equity_TC_03_00_Subscribe" })
	@Parameters({ "SheetName","rowNum","API" })
	public void Equity_TC_03_01_StoreId(String SheetName,int rowNum, String API) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Store Equity Id");

		try {
			if (API.equalsIgnoreCase("false")) {
			equity.StoreIdEquity(SheetName, rowNum);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
