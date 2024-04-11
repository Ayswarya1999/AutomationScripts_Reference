package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_08B_ScoreCardFiterValidationTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_21B_ValidateTeamPTAccessTest.Equity_TC_21B_06_ValidateAdminInScorecard" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_08B_ScoreCardFiterValidation(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verifies Scorecard Filter Options Functionality");
		try {
			rc.SignOut();
			login.Login();
			equity.SearchEquityByID(SheetName,rowNum);
			equity.WERPurseScorecard(SheetName,rowNum);
			hsr.verifyScoreCardFilter("Response","2","WPRValidResponse");
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
}
