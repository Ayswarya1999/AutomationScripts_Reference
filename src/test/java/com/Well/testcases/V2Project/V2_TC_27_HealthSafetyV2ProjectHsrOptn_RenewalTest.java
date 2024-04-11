package com.Well.testcases.V2Project;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;


public class V2_TC_27_HealthSafetyV2ProjectHsrOptn_RenewalTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_14C_VerifyScorecardV2ProjectTest.V2_TC_14C_00_VerifyScorecardV2Project" })
	@Parameters({"SheetName","rowNum", "Type", "Country" ,"Upload", "API","Commodity","ProjectType"})
	public void V2Project_TC_Optn_27_00_CompleteRegistering(String SheetName, int rowNum, String Type, String Country, String Upload, String API,
			String Commodity, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Enrollment Hsr Optn with Initiate separate review cycle Functionality");
		try {	
			rc.SignOut();
			login.Login();
			v2project.SearchV2ProjectById(SheetName, rowNum);	
			v2project.HealthSafetyV2ProjectOptn();
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_27_HealthSafetyV2ProjectHsrOptn_RenewalTest.V2Project_TC_Optn_27_00_CompleteRegistering" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2Project_TC_Optn_27_01_OptnHsrFeatureUploadDoc(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload 15 document with API Functionality");
		try {
			commonAPI.storeScorecardIdAPI(SheetName,rowNum, "ScorecardHsrOptnId","hsr_scorecard_id");
			commonAPI.fillScorecardAPIWithPoints(SheetName,rowNum, "ScorecardHsrOptnId","15");
			v2project.OptnHsrOngoingDataReport(SheetName, rowNum, "Monitor Air and Water Quality","false");
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_27_HealthSafetyV2ProjectHsrOptn_RenewalTest.V2Project_TC_Optn_27_01_OptnHsrFeatureUploadDoc" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2Project_TC_Optn_27_02_MarkAsAchieved(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Admin Edit mask it has Achieved Functionality");
		try {
			login.AdminLogin();
			v2project.AdminSearchById(SheetName, rowNum);
			rc.editAdminAwardDate();
			
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_27_HealthSafetyV2ProjectHsrOptn_RenewalTest.V2Project_TC_Optn_27_02_MarkAsAchieved" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2Project_TC_Optn_27_03_ValidateDashboardAndNavigateToScorecard(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Renewal button in Dashboard and navigate to Hsr Optn Scorecard");
		try {
			v2project.ValidateDashboardAndNavigateToScorecard(SheetName, rowNum);
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_27_HealthSafetyV2ProjectHsrOptn_RenewalTest.V2Project_TC_Optn_27_03_ValidateDashboardAndNavigateToScorecard" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2Project_TC_Optn_27_04_OptnHsrValidateScorecardFeature(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Scorecard Feature Functionality");
		try {
			v2project.OptnHsrValidateScorecardFeature(SheetName, rowNum);
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_27_HealthSafetyV2ProjectHsrOptn_RenewalTest.V2Project_TC_Optn_27_04_OptnHsrValidateScorecardFeature" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2Project_TC_Optn_27_05_OptnHsrMarkAsYes(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Mark As Yes Curent Document Functionality");
		try {
			
			v2project.OptnHsrMarkAsYes(SheetName, rowNum, "Support Handwashing");
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_27_HealthSafetyV2ProjectHsrOptn_RenewalTest.V2Project_TC_Optn_27_05_OptnHsrMarkAsYes" })
	@Parameters({ "SheetName", "rowNum","ProjectType" })
	public void V2Project_TC_Optn_27_06_OptnHsrMarkAsNo(String SheetName, int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Mark As Yes Curent Document Functionality");
		try {
		
			v2project.OptnHsrMarkAsNo(SheetName, rowNum, "Reduce Surface Contact");
			
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_27_HealthSafetyV2ProjectHsrOptn_RenewalTest.V2Project_TC_Optn_27_06_OptnHsrMarkAsNo" })
	@Parameters({ "SheetName", "rowNum","ProjectType" })
	public void V2Project_TC_Optn_27_07_OptnHsrMarkAsNoAndValidUploadDocument(String SheetName, int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Mark As Yes Curent Document Functionality");
		try {
		
			v2project.OptnHsrMarkAsNoAndValidUploadDocument("Reduce Surface Contact");
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_27_HealthSafetyV2ProjectHsrOptn_RenewalTest.V2Project_TC_Optn_27_07_OptnHsrMarkAsNoAndValidUploadDocument" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2Project_TC_Optn_27_08_OptnHsrOngoingDataReport(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Ongoing DataReport Document Functionality");
		try {
			v2project.OptnHsrOngoingDataReport(SheetName, rowNum, "Monitor Air and Water Quality","true");
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_27_HealthSafetyV2ProjectHsrOptn_RenewalTest.V2Project_TC_Optn_27_08_OptnHsrOngoingDataReport" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2Project_TC_Optn_27_09_OptnHsrValidateRenewalReviewOptions(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Renewal Review option Functionality");
		try {
			
			v2project.OptnHsrValidateRenewalReviewOptions();
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_27_HealthSafetyV2ProjectHsrOptn_RenewalTest.V2Project_TC_Optn_27_09_OptnHsrValidateRenewalReviewOptions" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2Project_TC_Optn_27_10_OptnHsrRenewalRemoveWarningIconInScorecard(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Renewal Review option Functionality");
		try {
			
			v2project.OptnHsrRenewalRemoveWarningIconInScorecard(15);
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_27_HealthSafetyV2ProjectHsrOptn_RenewalTest.V2Project_TC_Optn_27_10_OptnHsrRenewalRemoveWarningIconInScorecard" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2Project_TC_Optn_27_11_OptnHsrRenewalReview(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Renewal Review option Functionality");
		try {
			
			v2project.OptnHsrValidateRenewalReview();
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_27_HealthSafetyV2ProjectHsrOptn_RenewalTest.V2Project_TC_Optn_27_11_OptnHsrRenewalReview" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2Project_TC_Optn_27_12_OptnHsrValidateDocumentListInDocumentLibrary(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verify document count in Hsr tab Document list Functionality");
		try {
			
			v2project.DocumentCountFromDocumentLibrary();
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
}