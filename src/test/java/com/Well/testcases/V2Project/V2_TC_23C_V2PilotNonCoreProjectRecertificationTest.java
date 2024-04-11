package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_23C_V2PilotNonCoreProjectRecertificationTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_02_HealthSafetyV2ProjectOptn_AddMultiplePartTest.V2Project_TC_Optn_02_09_OptnHsrAlternativeValidDeletedDoc" })
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_23C_00_CompleteScorecard(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Complete Scorecard for Recertification Functionality");
		try {
			login.AdminLogin();
			v2project.AdminSearchById(SheetName, rowNum);		
			v2project.BuildScorecardV2ProjectById(SheetName, rowNum);
			commonAPI.storeScorecardIdAPI(SheetName,rowNum, "ScorecardId","scorecard_id");
			commonAPI.fillScorecardAPIWithPoints(SheetName,rowNum, "ScorecardId","110");
			v2project.validCommentsV2Project(SheetName, rowNum,"Meet Thresholds for Particulate Matter");
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_23C_V2PilotNonCoreProjectRecertificationTest.V2_TC_23C_00_CompleteScorecard" })
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_23C_01_V2PilotNonCoreProjectExpiredRecertification(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate V2 Pilot Non-Core Project Expired Recertification Functionality");
		try {
			v2project.editAndValidateAdminCertification(SheetName, rowNum, "Expired Recertification");
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_23C_V2PilotNonCoreProjectRecertificationTest.V2_TC_23C_01_V2PilotNonCoreProjectExpiredRecertification" })
	@Parameters({"SheetName","rowNum", "Country"})
	public void V2_TC_23C_02_V2PilotNonCoreProjectRecertification(String SheetName, int rowNum, String Country) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate V2 Pilot Non-Core Project Recertification Functionality");
		try {
			v2project.validateV2PilotNonCoreProjectAdminCertification(SheetName, rowNum);
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_23C_V2PilotNonCoreProjectRecertificationTest.V2_TC_23C_02_V2PilotNonCoreProjectRecertification" })
	@Parameters({"SheetName","rowNum"})
	public void V2_TC_23C_03_ValidateParentScorecardDataInChildScorecard(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Parent Scorecard Data In Child Scorecard");
		try {
			rc.clickScorecard();
			v2project.ValidateParentScorecardDataInChildScorecard(SheetName, rowNum, "Meet Thresholds for Particulate Matter");
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_23C_V2PilotNonCoreProjectRecertificationTest.V2_TC_23C_03_ValidateParentScorecardDataInChildScorecard" })
	@Parameters({"SheetName","rowNum"})
	public void V2_TC_23C_04_ValidateScorecardDataInScorecardListOfDocumentsTab(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Parent Scorecard Data In Child Scorecard");
		try {
			rc.clickDocument();
			v2project.ValidateScorecardDataInScorecardListOfDocumentsTab();
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}



