package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_02_RegisterHealthSafetyTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.login.TC_01_LoginTest.TC_01_Login" })
	@Parameters({"SheetName","rowNum","DataValidate","Country","ProjectType","Upload","API","Commodity","ImportLocation","ProjectName"})
	public void Healthsafety_TC_02_RegisterHealthSafety(String SheetName,int rowNum, String DataValidate, String Country, String ProjectType,String Upload,String API,String Commodity, String ImportLocation, String ProjectName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Register Health Safety Functionality");

		try {
			if (API.equalsIgnoreCase("true")) {
			commonAPI.StoreAnyProject(SheetName, rowNum, Country, ProjectType, Upload, API, Commodity, ImportLocation,ProjectName, false);		
			commonAPI.SignAgreement(SheetName, rowNum, ProjectType, Commodity);
	} 
		else {
			hsr.RegisterHealthSafety(SheetName, rowNum,DataValidate, ProjectName);
		}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
