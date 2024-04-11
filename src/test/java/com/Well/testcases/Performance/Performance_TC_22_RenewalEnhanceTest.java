package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_22_RenewalEnhanceTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_09_ReviewTest.Performance_TC_09_14_CompleteCurativeReview" })
	@Parameters({ "SheetName","rowNum"})
	public void Performance_TC_22_00_RenewalEnhanceChangeDateAsAdmin(String SheetName,int rowNum) throws IOException {
		
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Renewal Enhance project functionality");
		try {
			login.AdminLogin();
			performance.AdminWprSearch(SheetName, rowNum);
			rc.editAdminAwardDate();
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_22_RenewalEnhanceTest.Performance_TC_22_00_RenewalEnhanceChangeDateAsAdmin" })
	@Parameters({ "SheetName","rowNum","Renewal"})
	public void Performance_TC_22_01_NavigateRenewalAsYes(String SheetName,int rowNum, String Renewal) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Navigate Renewal Enhance project functionality");
		try {
			if (Renewal.contains("yes")) {
			rc.navigateRenewal();
			}
			else {
				rc.noRenewal(SheetName,rowNum,"6500");
			}
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_22_RenewalEnhanceTest.Performance_TC_22_01_NavigateRenewalAsYes" })
	@Parameters({ "SheetName","rowNum","Renewal"})
	public void Performance_TC_22_02_ArchieveToLocations(String SheetName,int rowNum, String Renewal) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Archieve and Restore Locations functionality");
		try {
			
			if (Renewal.contains("yes")) {
				rc.ArchieveToLocations();
				}
				
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_22_RenewalEnhanceTest.Performance_TC_22_01_NavigateRenewalAsYes" })
	@Parameters({ "SheetName","rowNum","ProjectType","Commodity","Renewal"})
	public void Performance_TC_22_03_ArchieveAddedAndImportedLocations(String SheetName,int rowNum, String ProjectType, String Commodity, String Renewal) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Add/Import location and Validate locations functionality");
		try {
			if (Renewal.contains("yes")) {
				rc.addLocation(SheetName, rowNum, ProjectType);
				generic.importLocationGeneric(Commodity, ImportfilePortfolioLocationRenewal);
				rc.ValidateAddedLocations();
				}
				
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_22_RenewalEnhanceTest.Performance_TC_22_03_ArchieveAddedAndImportedLocations" })
	@Parameters({ "SheetName","rowNum","ProjectType","Renewal"})
	public void Performance_TC_22_04_ConfirmLocations(String SheetName,int rowNum, String ProjectType, String Renewal) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Renewal Confirm Locations functionality");
		try {
			if (Renewal.contains("yes")) {
				rc.ValidateConfirmLocations(SheetName,rowNum);
				rc.ValidateRenewalPayment();
				}
				
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_22_RenewalEnhanceTest.Performance_TC_22_04_ConfirmLocations" })
	@Parameters({ "SheetName","rowNum"})
	public void Performance_TC_22_05_RenewalReviewValidateBeforePayment(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Renewal Before Payment functionality");
		try {
			rc.ValidateRenewalMessageInReviewBeforePayment();
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
		@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_22_RenewalEnhanceTest.Performance_TC_22_05_RenewalReviewValidateBeforePayment" })
		@Parameters({ "SheetName","rowNum"})
		public void Performance_TC_22_06_RenewalBilling(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Complete the Payment functionality");
			try {
				v2project.ClickBilling(SheetName, rowNum);
				rc.Billing(SheetName, rowNum);
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_22_RenewalEnhanceTest.Performance_TC_22_06_RenewalBilling" })
		@Parameters({ "SheetName","rowNum","Renewal"})
		public void Performance_TC_22_07_RenewalReviewValidateAfterpayment(String SheetName,int rowNum, String Renewal) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Validate After payment functionality");
			try {
				rc.ValidateRenewalMessageInReviewAfterPayment();
		
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_22_RenewalEnhanceTest.Performance_TC_22_07_RenewalReviewValidateAfterpayment" })
		@Parameters({ "SheetName","rowNum"})
		public void Performance_TC_22_08_RenewalSubmitReview(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Submit Renewal Preliminary Health-Safety Review functionality");
			try {
				rc.SignOut();
				login.Login();
				performance.SearchPerformanceByID(SheetName,rowNum);
				hsr.SubmitHsrReview(SheetName, rowNum, "Renewal Preliminary Performance Rating Review");	
		
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
	
		@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_22_RenewalEnhanceTest.Performance_TC_22_08_RenewalSubmitReview" })
		@Parameters({ "SheetName","rowNum"})
		public void Performance_TC_22_09_RenewalCompleteReview(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Complete the Renewal Preliminary Health-Safety Review functionality");
			try {
				rc.SignOut();
				login.AdminLogin();
			hsr.CompleteHsrReview(SheetName, rowNum,"Renewal Preliminary Performance Rating Review");
		
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
}
