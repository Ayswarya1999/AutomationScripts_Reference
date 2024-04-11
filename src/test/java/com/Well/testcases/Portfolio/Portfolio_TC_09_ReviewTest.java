package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_09_ReviewTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_08_DocumentTest.Portfolio_TC_08_02_FeatureUploadDocumentInDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_09_00_SubmitRound1Review(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"WELL At Scale Review Submit Functionality");

		try {
			portfolio.SubmitReviewDocument(SheetName, rowNum);
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_09_ReviewTest.Portfolio_TC_09_00_SubmitRound1Review" })
		@Parameters({ "SheetName","rowNum" })
		public void Portfolio_TC_09_01_VerifyLocationUpdatesRestricts(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"WELL At Scale Verify Location Updates Restricts Functionality");

			try {
				portfolio.VerifyLocationUpdatesRestricts(SheetName, rowNum);

			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_09_ReviewTest.Portfolio_TC_09_01_VerifyLocationUpdatesRestricts" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_09_02_EditRound1ReviewToMRC(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"WELL At Scale Review Submit Functionality");

		try {
			login.AdminLogin();
			portfolio.AdminEditReviewMrc(SheetName, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_09_ReviewTest.Portfolio_TC_09_02_EditRound1ReviewToMRC" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_09_03_CompleteRound1Review(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"WELL At Scale Review Submit Functionality");

		try {
			portfolio.AdminCompleteReviewDocument(SheetName, rowNum);
			rc.SignOut();
			login.Login();
			portfolio.SearchPortfolioById(SheetName, rowNum);	
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_09_ReviewTest.Portfolio_TC_09_03_CompleteRound1Review" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_09_04_InitiateRound2Review(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"WELL At Scale Review Submit Functionality");

		try {
			portfolio.InitiateRound2Review(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_09_ReviewTest.Portfolio_TC_09_04_InitiateRound2Review" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_09_05_AdminCompleteRound2Review(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"WELL At Scale Review Submit Functionality");

		try {
		login.AdminLogin();
			portfolio.AdminCompleteRound2Review(SheetName, rowNum);
			rc.SignOut();
			login.Login();
			portfolio.SearchPortfolioById(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
