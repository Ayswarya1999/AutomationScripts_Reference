package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_13B_AddingTeamTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_08A_DocumentTest.Portfolio_TC_08A_01_FeatureUploadDocumentInDocument"})
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_13B_AddingTeam(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verifies user able to access the invited Portfolio project");

		try {
			portfolio.TeamPermissionLevel(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
