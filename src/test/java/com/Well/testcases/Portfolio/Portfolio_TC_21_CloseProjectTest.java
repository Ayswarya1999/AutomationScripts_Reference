package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_21_CloseProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_13A_ValidateProjectAccessTeamTest.Portfolio_TC_13A_ValidateProjectAccessTeam" })
	@Parameters({ "SheetName","rowNum"})
	public void Portfolio_TC_21_CloseProject(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Close project functionality");
		try {
			login.AdminLogin();
			portfolio.AdminSearch(SheetName, rowNum);	
			rc.ValidateCloseProject(SheetName, rowNum);
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
