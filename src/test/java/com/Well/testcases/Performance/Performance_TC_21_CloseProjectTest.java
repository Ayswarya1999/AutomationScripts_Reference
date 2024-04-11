package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;


public class Performance_TC_21_CloseProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_11A_ValidateProjectAccessTeamTest.Performance_TC_11A_02_ValidateChangeAdminstrator" })
	@Parameters({ "SheetName","rowNum"})
	public void Performance_TC_21_CloseProject(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Close project functionality");
		try {
			login.AdminLogin();
			performance.AdminWprSearch(SheetName, rowNum);
			rc.ValidateCloseProject(SheetName, rowNum);
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
