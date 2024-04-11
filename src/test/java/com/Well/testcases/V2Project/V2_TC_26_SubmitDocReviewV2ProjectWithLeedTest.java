package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_26_SubmitDocReviewV2ProjectWithLeedTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_25_ProjectLeedOptinAndValidationTest.V2_TC_25_02_LeedOptinAndDashboardValidation" })
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_26_SubmitDocReviewV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"V2Project Review Submit Functionality");
		try {
		v2project.SubmitLeedReviewV2Project(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

}
