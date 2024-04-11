package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_SF_03_SearchV2ProjectByPaymentPendingStatusTest extends BaseClass {

	@Test(dependsOnMethods =  { "com.Well.testcases.HealthSafety.Healthsafety_TC_SF_02_EnrollTest.Healthsafety_TC_SF_02_Enroll" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_SF_03_SearchV2ProjectByPaymentPendingStatus(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL Healthsafety Enrollment list Functionality");
		try {
			hsr.hsrSearchFilterRegisteredStatus(SheetName, rowNum,"PAYMENT PENDING");	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
