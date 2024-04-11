package com.Well.testcases.Equity;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Equity_TC_19A_ValidLocationCountTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08A_ScoreCardTest.Equity_TC_08A_06_ScorecardUpdateUploadDocForAlternatives" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_19A_ValidLocationCount(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Importing Locations to Equity Project");

		try {
        rc.ValidAddLocation(SheetName, rowNum,"170");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}