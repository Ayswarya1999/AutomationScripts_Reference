package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_20_SupportTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_16_DownloadBillingAndValidateTest.Performance_TC_16_DownloadBillingAndValidate" })
	@Parameters({ "SheetName","rowNum" ,"Country"})
	public void Performance_TC_20_00_Support(String SheetName,int rowNum,String Country) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate support card count");
		try {
			rc.supportCardValidation();
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_20_SupportTest.Performance_TC_20_00_Support" })
	@Parameters({ "SheetName","rowNum" ,"Country"})
	public void Performance_TC_20_01_ValidAddLocation(String SheetName,int rowNum,String Country) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate support card count");
		try {
			rc.ValidAddLocation(SheetName, rowNum,"6");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
