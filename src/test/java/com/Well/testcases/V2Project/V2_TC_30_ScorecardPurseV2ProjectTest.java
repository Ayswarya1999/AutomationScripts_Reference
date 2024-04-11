package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_30_ScorecardPurseV2ProjectTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_06_AgreementV2ProjectTest.V2_TC_06_01_ValidateDocumentsTabTypeDropdown" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_30_00_BuildScorecardV2ProjectById(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2Project Build Scorecard Functionality");
		try {
			v2project.BuildScorecardV2ProjectById(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_30_ScorecardPurseV2ProjectTest.V2_TC_30_00_BuildScorecardV2ProjectById" })
	@Parameters({ "SheetName","rowNum","Commodity" })
	public void V2_TC_30_01_UploadFeatureDocV2ProjectInsideScorecard(String SheetName,int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2Project Scorecard Upload feature Functionality");
		try {
			v2project.CommonUploadScorecardDocument("Meet Thresholds for Particulate Matter", SheetName, rowNum, Commodity,FeaturefileUpload ,false,false,false,false);
			v2project.RefreshScorecard();
			v2project.CommonUploadScorecardDocument("Meet Thresholds for Inorganic Gases", SheetName, rowNum, Commodity,FeaturefileUpload ,false,false,false,false);
			v2project.RefreshScorecard();
			v2project.CommonUploadScorecardDocument("Measure Air Parameters", SheetName, rowNum, Commodity,FeaturefileUpload ,false,false,false,false);
			
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_30_ScorecardPurseV2ProjectTest.V2_TC_30_01_UploadFeatureDocV2ProjectInsideScorecard" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_30_02_verifyScoreCardFilter(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2Project Scorecard Response filter option");
		try {
			portfolio.PurseStatus();
			v2project.NavigateScorecardFilter();
			v2project.verifyScoreCardFilter("Response", "2", "V2ProjectScorecardResponseFilter", "V2ProjectScorecardYesFilter");	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
