package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_Optn_02_SubscribeLocationToPortfolioHsrOptnTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_06_PortfolioLocationImportTest.Portfolio_TC_06_PortfolioLocationImport" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_Optn_02_00_NavigateToLocationAccount(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Store and Navigate Subscribe location Id WELL At Scale Project Functionality");
		try {
			portfolio.storeLocationId(SheetName, rowNum);
			pfu.NavigateAddedLocation(SheetName, rowNum);
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_Optn_02_SubscribeLocationToPortfolioHsrOptnTest.Portfolio_TC_Optn_02_00_NavigateToLocationAccount" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_Optn_02_01_OptnHsrLocationAccountUploadDoc(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register Hsr Optn and Upload document in Scorecard WELL At Scale Project Functionality");
		try {
			portfolio.HSROptnLocationAccount();
			portfolio.uploadDocumentInOptnFeature("Support Handwashing");
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_Optn_02_SubscribeLocationToPortfolioHsrOptnTest.Portfolio_TC_Optn_02_01_OptnHsrLocationAccountUploadDoc" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_Optn_02_02_OptnHsrValidateUploadDocInPortfolioAccount(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Navigate to Portfolio Account WELL At Scale Project Functionality");
		try {
			portfolio.SearchPortfolioById(SheetName,rowNum);
			portfolio.HSROptnProfolioAccount();
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_Optn_02_SubscribeLocationToPortfolioHsrOptnTest.Portfolio_TC_Optn_02_02_OptnHsrValidateUploadDocInPortfolioAccount" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Portfolio_TC_Optn_02_03_OptnHsrValidateUploadScorecardDocInPortfolioAccount(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate location account Scorecard Upload document in Portfolio Account WELL At Scale Project Functionality");
		try {
			portfolio.ValiateScorecardUploadDocInHSROptnPortfolioAccount("Support Handwashing", SheetName, rowNum, Commodity);
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_Optn_02_SubscribeLocationToPortfolioHsrOptnTest.Portfolio_TC_Optn_02_03_OptnHsrValidateUploadScorecardDocInPortfolioAccount" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_TC_Optn_02_04_OptnHsrValidateUploadDocumentLibraryInPortfolioAccount(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate location account Document library Upload document in Portfolio Account WELL At Scale Project Functionality");
		try {
		
			portfolio.HSROptnDocumentProfolioAccount("Support Handwashing",SheetName,rowNum, Commodity);
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
