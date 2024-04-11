package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_09_ReviewTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_08_DocumentTest.Healthsafety_TC_08_04_LibrarySearchFilterDocumentHSR" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_09_00_PreliminarySubmitReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Healthsafey Review Submit Functionality");
		try {
			
		hsr.SubmitHsrReview(SheetName, rowNum, "Preliminary Health-Safety Review");	
		if (TestNGTestName.contains("NonEnhanced")) {
			v2project.underReviewScorecardResponseValid();
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_09_ReviewTest.Healthsafety_TC_09_00_PreliminarySubmitReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_09_01_PreliminaryCompleteReview(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Healthsafey Review Complete Functionality");
		try {
		
		login.AdminLogin();
		hsr.CompleteHsrReview(SheetName, rowNum,"Preliminary Health-Safety Review");
		rc.SignOut();
		login.Login();
		hsr.SearchHealthSafetyByID(SheetName,rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_09_ReviewTest.Healthsafety_TC_09_01_PreliminaryCompleteReview" })
@Parameters({ "SheetName","rowNum" })
public void Healthsafety_TC_09_02_FinalSubmitReview(String SheetName,int rowNum) throws IOException {

	TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	StartTest(TestCaseName,"Healthsafey Review Submit Functionality");
	try {
		
	    hsr.SubmitHsrReview(SheetName, rowNum, "Final Health-Safety Review");	
		
	} catch (Throwable t) {
		System.out.println(t.getLocalizedMessage());
		Error e1 = new Error(t.getMessage());
		e1.setStackTrace(t.getStackTrace());
		throw e1;
	}
}

@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_09_ReviewTest.Healthsafety_TC_09_02_FinalSubmitReview" })
@Parameters({ "SheetName","rowNum" })
public void Healthsafety_TC_09_03_FinalCompleteReview(String SheetName,int rowNum) throws IOException {

	TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	StartTest(TestCaseName,"Healthsafey Review Complete Functionality");
	try {
		
		login.AdminLogin();
		hsr.CompleteHsrReview(SheetName, rowNum,"Final Health-Safety Review");
		rc.SignOut();
		login.Login();
		hsr.SearchHealthSafetyByID(SheetName,rowNum);
		
	} catch (Throwable t) {
		System.out.println(t.getLocalizedMessage());
		Error e1 = new Error(t.getMessage());
		e1.setStackTrace(t.getStackTrace());
		throw e1;
	}
}

@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_09_ReviewTest.Healthsafety_TC_09_03_FinalCompleteReview" })
@Parameters({ "SheetName","rowNum" })
public void Healthsafety_TC_09_04_CurativeSubmitReview(String SheetName,int rowNum) throws IOException {

	TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	StartTest(TestCaseName,"Healthsafey Review Submit Functionality");
	try {
		
	    hsr.SubmitHsrReview(SheetName, rowNum, "Curative Action Plan Review");	
		
	} catch (Throwable t) {
		System.out.println(t.getLocalizedMessage());
		Error e1 = new Error(t.getMessage());
		e1.setStackTrace(t.getStackTrace());
		throw e1;
	}
}

@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_09_ReviewTest.Healthsafety_TC_09_04_CurativeSubmitReview" })
@Parameters({ "SheetName","rowNum" })
public void Healthsafety_TC_09_05_CurativeCompleteReview(String SheetName,int rowNum) throws IOException {

	TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	StartTest(TestCaseName,"Healthsafey Review Complete Functionality");
	try {
		
		login.AdminLogin();
		hsr.CompleteHsrReview(SheetName, rowNum,"Curative Action Plan Review");
		rc.SignOut();
		login.Login();
		hsr.SearchHealthSafetyByID(SheetName,rowNum);	
		
	} catch (Throwable t) {
		System.out.println(t.getLocalizedMessage());
		Error e1 = new Error(t.getMessage());
		e1.setStackTrace(t.getStackTrace());
		throw e1;
	}
}
}