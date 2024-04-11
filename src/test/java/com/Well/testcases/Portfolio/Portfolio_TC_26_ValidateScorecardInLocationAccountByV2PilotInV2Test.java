package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_26_ValidateScorecardInLocationAccountByV2PilotInV2Test extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_05_PortfolioPaymentTest.Portfolio_TC_05_PortfolioPayment" })
	@Parameters({ "SheetName", "rowNum" ,"ProjectType","Upload","API"})
	public void Portfolio_TC_26_00_CreateSingleAssetProject(String SheetName, int rowNum, String ProjectType, String Upload, String API) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify Adding Portfolio Single Location Successfully");

		try {
			
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_05_PortfolioPaymentTest.Portfolio_TC_05_PortfolioPayment" })
		@Parameters({ "SheetName", "rowNum" ,"ProjectType","Upload","API"})
		public void Portfolio_TC_26_01_CreatePortfolioProject(String SheetName, int rowNum, String ProjectType, String Upload, String API) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Verify Adding Portfolio Single Location Successfully");

			try {
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
	}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_05_PortfolioPaymentTest.Portfolio_TC_05_PortfolioPayment" })
		@Parameters({ "SheetName", "rowNum" ,"ProjectType","Upload","API"})
		public void Portfolio_TC_25_02_UpsellSingleAssetInPortfolio(String SheetName, int rowNum, String ProjectType, String Upload, String API) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Verify Adding Portfolio Single Location Successfully");

			try {
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
	}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_05_PortfolioPaymentTest.Portfolio_TC_05_PortfolioPayment" })
		@Parameters({ "SheetName", "rowNum" ,"ProjectType","Upload","API"})
		public void Portfolio_TC_25_03_StoreId(String SheetName, int rowNum, String ProjectType, String Upload, String API) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Verify Adding Portfolio Single Location Successfully");

			try {
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
	}
	
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_05_PortfolioPaymentTest.Portfolio_TC_05_PortfolioPayment" })
		@Parameters({ "SheetName", "rowNum" ,"ProjectType","Upload","API"})
		public void Portfolio_TC_25_04_ValidateScorecardPageInLocationAccount(String SheetName, int rowNum, String ProjectType, String Upload, String API) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Verify Adding Portfolio Single Location Successfully");

			try {
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
	}
}