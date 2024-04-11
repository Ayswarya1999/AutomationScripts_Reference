package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;
import com.Well.Engine.ScreenRecorderUtil;

public class V2_TC_29_CoreProjectPreCertificationTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_23_ValidateAdminAlternativeV2ProjectTest.V2_TC_23_01_ValidateAdminAlternativeAAPV2Project" })
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_29_CoreProjectPreCertification(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Expired Recertification Functionality");
		try {
			v2project.AdminSearchById(SheetName, rowNum);
			v2project.CoreProjectMarkPreCertified(SheetName, rowNum);
			rc.SignOut();
			login.Login();
			v2project.SearchV2ById(SheetName, rowNum);	
			v2project.SearchV2ProjectFilterByStatus(SheetName, rowNum, "Precertified");
			v2project.ClickSearchV2ProjectById(SheetName, rowNum);
			rc.SignOut();
			login.AdminLogin();
			v2project.ValidateFilterStatusByAdmin(SheetName, rowNum, "Precertified");
			v2project.ClickSearchV2ProjectById(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	
}
