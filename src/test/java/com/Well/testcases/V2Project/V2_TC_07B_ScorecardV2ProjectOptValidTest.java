package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_07B_ScorecardV2ProjectOptValidTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_06_AgreementV2ProjectTest.V2_TC_06_01_ValidateDocumentsTabTypeDropdown" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_07B_00_ScorecardV2ProjectOptValid(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2Project Build and Complete Scorecard Functionality");
		try {
		v2project.HealthSafetyV2ProjectOpt(SheetName, rowNum);	
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07B_ScorecardV2ProjectOptValidTest.V2_TC_07B_00_ScorecardV2ProjectOptValid" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_07B_01_ScorecardV2ProjectOptValid(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2Project Build and Complete Scorecard Functionality");
		try {
			commonAPI.storeScorecardIdAPI(SheetName,rowNum, "ScorecardHsrOptnId","hsr_scorecard_id");
			commonAPI.fillScorecardAPI(SheetName,rowNum, "ScorecardHsrOptnId");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
