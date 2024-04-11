package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_SF_01_SearchReadyToEnrollStatusTest extends BaseClass {

	@Test(dependsOnMethods =  { "com.Well.testcases.HealthSafety.Healthsafety_TC_SF_00_RegisterTest.Healthsafety_TC_SF_00_Register" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_SF_01_SearchReadyToEnrollStatus(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL Healthsafety Enrollment list Functionality");
		try {
		hsr.hsrSearchFilterRegisteredStatus(SheetName, rowNum,"READY TO ENROLL");	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
