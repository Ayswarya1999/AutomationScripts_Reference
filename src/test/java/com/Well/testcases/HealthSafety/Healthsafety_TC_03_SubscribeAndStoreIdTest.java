package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_03_SubscribeAndStoreIdTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_02_RegisterHealthSafetyTest.Healthsafety_TC_02_RegisterHealthSafety" })
	@Parameters({ "SheetName","rowNum","Country","ProjectType","API","Commodity","Upload" })
	public void Healthsafety_TC_03_00_Subscribe(String SheetName,int rowNum,String Country, String ProjectType,String API,String Commodity, String Upload) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Subscribe the HealthSafety Functionality");

		try {
			if (API.equalsIgnoreCase("true")) {
				commonAPI.BillingProject(SheetName, rowNum, Country, ProjectType, Commodity);	
				commonAPI.UpdateNonEnhanced(SheetName, rowNum, Country, ProjectType, Upload, API, Commodity);
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
	
		@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_03_SubscribeAndStoreIdTest.Healthsafety_TC_03_00_Subscribe" })
		@Parameters({ "SheetName","rowNum", "API" })
		public void Healthsafety_TC_03_01_StoreId(String SheetName,int rowNum, String API) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Store Health Safety Id");

			try {
				if (API.equalsIgnoreCase("false")) {
				hsr.StoreIdHealthSafety(SheetName, rowNum);	
				}
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
	}
}
