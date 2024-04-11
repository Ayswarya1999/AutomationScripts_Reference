package com.Well.testcases.V2Project;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class V2_TC_28_V2ProjectNonCoreRecertificationTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_26_SubmitDocReviewV2ProjectWithLeedTest.V2_TC_26_SubmitDocReviewV2Project" })
	@Parameters({"SheetName","rowNum"})
	public void V2Project_TC_28_00_ExpiredRecertification(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Expired Recertification Functionality");
		try {
			login.AdminLogin();
			v2project.AdminSearchById(SheetName, rowNum);
			v2project.editAndValidateAdminCertification(SheetName, rowNum, "Expired Recertification");
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_28_V2ProjectNonCoreRecertificationTest.V2Project_TC_28_00_ExpiredRecertification" })
	@Parameters({"SheetName","rowNum", "ProjectType"})
	public void V2Project_TC_28_01_Recertification(String SheetName, int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Recertification Functionality");
		try {
			v2project.editAndValidateAdminCertification(SheetName, rowNum, "Recertification");
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}