package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;
import com.Well.Engine.ScreenRecorderUtil;

public class V2_TC_23A_CoreProjectRecertificationTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_29_CoreProjectPreCertificationTest.V2_TC_29_CoreProjectPreCertification" })
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_23A_00_CoreProjectExpiredRecertification(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Expired Recertification Functionality");
		try {
			v2project.AdminSearchById(SheetName, rowNum);
			v2project.editAndValidateAdminCertification(SheetName, rowNum, "Expired Recertification");
			rc.SignOut();
			login.Login();
			v2project.SearchV2ById(SheetName, rowNum);	
			v2project.SearchV2ProjectFilterByStatus(SheetName, rowNum, "Certified");
			v2project.SearchAndClickV2ProjectByIdForRecertificationTest(SheetName, rowNum);
			rc.SignOut();
			login.AdminLogin();
			v2project.ValidateFilterStatusByAdmin(SheetName, rowNum, "Certified");
			v2project.SearchAndClickV2ProjectByIdForRecertificationTest(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_23A_CoreProjectRecertificationTest.V2_TC_23A_00_CoreProjectExpiredRecertification" })
	@Parameters({"SheetName","rowNum", "Country", "ProjectType"})
	public void V2_TC_23A_01_CoreProjectRecertification(String SheetName, int rowNum, String Country, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Recertification Functionality");
		try {
			
			if (ProjectType.contains("pilot")) {
			v2project.V2PilotCoreProjectEditAndValidateRecertification(SheetName, rowNum);
			v2project.ValidateUpdatedProjectArea();
			
			} else {
			v2project.CoreProjectEditAndValidateAdminCertification(SheetName, rowNum, Country);
			
		    } 
			v2project.StoreIdInRecertification(SheetName, rowNum);

		}
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
}
