package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_11_HealthSafetyReviewV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_10_HealthSafetyV2ProjectTest.V2_TC_10_01_UploadHealthSafetyScorecardDocV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_11_00_HealthSafetySubmitReviewV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"V2Project Review Submit Functionality");
		try {
		v2project.hsrSubmitReviewV2Project(SheetName, rowNum);	
		v2project.underReviewScorecardResponseValid();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_11_HealthSafetyReviewV2ProjectTest.V2_TC_11_00_HealthSafetySubmitReviewV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_11_01_HealthSafetyCompleteReviewV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"V2Project Complete Review Functionality");
		try {
			login.AdminLogin();
			v2project.hsrCompleteReviewV2Project(SheetName, rowNum);
			rc.SignOut();
			login.Login();
			v2project.SearchV2ProjectById(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
