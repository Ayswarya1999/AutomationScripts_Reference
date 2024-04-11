package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_SF_04_BillingTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_SF_03_SearchV2ProjectByPaymentPendingStatusTest.Healthsafety_TC_SF_03_SearchV2ProjectByPaymentPendingStatus" })
	@Parameters({ "SheetName","rowNum","Country" })
	public void Healthsafety_TC_SF_04_Billing(String SheetName,int rowNum, String Country) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL Healthsafety Card Payment Functionality");
		try {
			hsr.AgreementHealthSafetySF(SheetName, rowNum);
			rc.Billing(SheetName, rowNum);
			if (Country.equalsIgnoreCase("CN")) {
				rc.ClickBilling(SheetName, rowNum);
				rc.validateCOA();
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
