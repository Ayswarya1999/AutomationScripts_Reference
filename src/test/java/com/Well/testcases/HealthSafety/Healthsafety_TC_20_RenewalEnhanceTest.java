package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Healthsafety_TC_20_RenewalEnhanceTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_11A_ValidateProjectAccessTeamTest.Healthsafety_TC_11A_ValidateProjectAccessTeam" })
	@Parameters({ "SheetName","rowNum"})
	public void Healthsafety_TC_20_00_RenewalEnhanceChangeDateAsAdmin(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Renewal Non Enhance project functionality");
		try {
			login.AdminLogin();
			hsr.AdminHsrSearch(SheetName,rowNum);
			hsr.NavigateScorecard();
			hsr.purseYes();
			hsr.uploadDocumentInFeatureNonEnhance("Monitor Air and Water Quality");
			rc.editAdminAwardDate();
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_20_RenewalEnhanceTest.Healthsafety_TC_20_00_RenewalEnhanceChangeDateAsAdmin" })
	@Parameters({ "SheetName","rowNum","Renewal"})
	public void Healthsafety_TC_20_01_NavigateRenewalAsNo(String SheetName,int rowNum, String Renewal) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Navigate Renewal Enhance project functionality");
		try {
				rc.noRenewal(SheetName,rowNum, "6500");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_20_RenewalEnhanceTest.Healthsafety_TC_20_01_NavigateRenewalAsNo" })
	@Parameters({ "SheetName","rowNum","ProjectType","Renewal"})
	public void Healthsafety_TC_20_02_ConfirmLocations(String SheetName,int rowNum, String ProjectType, String Renewal) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Renewal Confirm Locations functionality");
		try {
			rc.ValidateRenewalPayment();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_20_RenewalEnhanceTest.Healthsafety_TC_20_02_ConfirmLocations" })
	@Parameters({ "SheetName","rowNum"})
	public void Healthsafety_TC_20_03_RenewalReviewValidateBeforePayment(String SheetName,int rowNum) throws IOException {

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
	
		@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_20_RenewalEnhanceTest.Healthsafety_TC_20_03_RenewalReviewValidateBeforePayment" })
		@Parameters({ "SheetName","rowNum","Country"})
		public void Healthsafety_TC_20_04_RenewalBilling(String SheetName,int rowNum, String Country) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Complete the Payment functionality");
			try {
				v2project.ClickBilling(SheetName, rowNum);
				rc.Billing(SheetName, rowNum);
				rc.DownloadBillingReceiptAndValidate(SheetName, rowNum, Country);
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_20_RenewalEnhanceTest.Healthsafety_TC_20_04_RenewalBilling" })
		@Parameters({ "SheetName","rowNum","Renewal"})
		public void Healthsafety_TC_20_05_RenewalReviewValidateAfterpayment(String SheetName,int rowNum, String Renewal) throws IOException {

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
		
		@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_20_RenewalEnhanceTest.Healthsafety_TC_20_05_RenewalReviewValidateAfterpayment" })
		@Parameters({ "SheetName","rowNum"})
		public void Healthsafety_TC_20_06_RenewalScorecardUpload(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Complete the Payment functionality");
			try {
				hsr.NavigateScorecard();
				v2project.OptnHsrValidateScorecardFeature(SheetName, rowNum);
				
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_20_RenewalEnhanceTest.Healthsafety_TC_20_06_RenewalScorecardUpload" })
		@Parameters({ "SheetName","rowNum"})
		public void Healthsafety_TC_20_07_HsrMarkAsYes(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Submit Renewal Preliminary Health-Safety Review functionality");
			try {
				hsr.HsrMarkAsYes(SheetName, rowNum, "Improve Cleaning Practices");
		
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_20_RenewalEnhanceTest.Healthsafety_TC_20_07_HsrMarkAsYes" })
		@Parameters({ "SheetName","rowNum"})
		public void Healthsafety_TC_20_08_HsrMarkAsNo(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Submit Renewal Preliminary Health-Safety Review functionality");
			try {
				hsr.HsrMarkAsNo(SheetName, rowNum, "Select Preferred Cleaning Products");
		
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_20_RenewalEnhanceTest.Healthsafety_TC_20_08_HsrMarkAsNo" })
		public void Healthsafety_TC_20_09_HsrMarkAsNoAndValidUploadDocument() throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Submit Renewal Preliminary Health-Safety Review functionality");
			try {
				hsr.uploadDocumentInFeatureNonEnhance("Select Preferred Cleaning Products");
				hsr.warningMessageHsrMarkNo();
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_20_RenewalEnhanceTest.Healthsafety_TC_20_09_HsrMarkAsNoAndValidUploadDocument" })
		public void Healthsafety_TC_20_10_HsrOngoingDataReport() throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Submit Renewal Preliminary Health-Safety Review functionality");
			try {
				hsr.uploadDocumentInFeatureNonEnhance("Monitor Air and Water Quality");
				hsr.warningHsrOngoingDataReport();
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@SuppressWarnings("static-access")
		@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_20_RenewalEnhanceTest.Healthsafety_TC_20_10_HsrOngoingDataReport" })
		@Parameters({ "SheetName","rowNum"})
		public void Healthsafety_TC_20_11_OptnHsrValidateRenewalReviewOptions(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Submit Renewal Preliminary Health-Safety Review functionality");
			try {
				v2project.OptnHsrValidateRenewalReviewOptions();
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@SuppressWarnings("static-access")
		@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_20_RenewalEnhanceTest.Healthsafety_TC_20_11_OptnHsrValidateRenewalReviewOptions" })
		@Parameters({ "SheetName","rowNum"})
		public void Healthsafety_TC_20_12_RemoveWarningInScorecardFeature(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Submit Renewal Preliminary Health-Safety Review functionality");
			try {
				commonAPI.storeRatingScorecardIdAPI(SheetName,rowNum,"hsr_scorecard_id");
				commonAPI.fillScorecardAPI(SheetName,rowNum, "ScorecardId");
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_20_RenewalEnhanceTest.Healthsafety_TC_20_12_RemoveWarningInScorecardFeature" })
		@Parameters({ "SheetName","rowNum"})
		public void Healthsafety_TC_20_13_RenewalSubmitReview(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Submit Renewal Preliminary Health-Safety Review functionality");
			try {
				rc.SignOut();
				login.Login();
				hsr.SearchHealthSafetyByID(SheetName,rowNum);
				hsr.SubmitHsrReview(SheetName, rowNum, "Renewal Preliminary Health-Safety Review");	
		
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
	
		@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_20_RenewalEnhanceTest.Healthsafety_TC_20_13_RenewalSubmitReview" })
		@Parameters({ "SheetName","rowNum"})
		public void Healthsafety_TC_20_14_RenewalCompleteReview(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

			StartTest(TestCaseName,"Complete the Renewal Preliminary Health-Safety Review functionality");
			try {
				login.AdminLogin();
			hsr.CompleteHsrReview(SheetName, rowNum,"Renewal Preliminary Health-Safety Review");
		
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
}
