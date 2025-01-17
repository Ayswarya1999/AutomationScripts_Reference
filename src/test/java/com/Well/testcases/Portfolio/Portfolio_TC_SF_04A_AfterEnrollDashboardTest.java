package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_SF_04A_AfterEnrollDashboardTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_SF_04_SignAndSubscribePortfolioTest.Portfolio_TC_SF_04_01_SubscribePortfolio" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_SF_04A_AfterEnrollDashboard(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verify Dashboard fields in WELL At Scale Functionality");
		try {
			portfolio.ValidDashboardEnrollPortfolioField(SheetName,rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
