package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_10_AlternativesTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_09_ReviewTest.Healthsafety_TC_09_05_CurativeCompleteReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_10__00_EPAlternatives(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Adding feature in EP alternatives functionality");
		try {
			rc.clickOnAlternatives(SheetName, rowNum);
			rc.alternativesEP(SheetName, rowNum,"NA");
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_10_AlternativesTest.Healthsafety_TC_10__00_EPAlternatives" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_10_01_AAPAlternatives(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Adding feature in AAP alternatives functionality");
		try {
			rc.alternativesAAP(SheetName, rowNum,"NA");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
