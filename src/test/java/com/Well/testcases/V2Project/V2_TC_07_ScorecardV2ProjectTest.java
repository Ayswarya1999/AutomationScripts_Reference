package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_07_ScorecardV2ProjectTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_06_AgreementV2ProjectTest.V2_TC_06_01_ValidateDocumentsTabTypeDropdown" })
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_07_00_VerifyReviewErrorMessageByMinScorecardPurseYes(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Verify Review Error Message By selecting Minimum Scorecard PurseYes");
		try {
			if (ProjectType.contains("pilot")) {
				v2project.BuildScorecardV2ProjectById(SheetName, rowNum);
				v2project.ScorecardfillPreconditionsUnselected();
			}
    	v2project.VerifyReviewErrorMessageByMinScorecardPurseYes(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_00_VerifyReviewErrorMessageByMinScorecardPurseYes" })
	@Parameters({ "SheetName","rowNum", "ProjectType" })
	public void V2_TC_07_01_BuildScorecardV2ProjectById(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2Project Build Scorecard Functionality");
		try {
		v2project.ScorecardV2ProjectById();
		v2project.BuildScorecardV2ProjectById(SheetName, rowNum);
		if (ProjectType.contains("pilot")) {
			rc.ScorecardVersionValid("WELL v2 pilot");	  
	} 
		else {
			rc.ScorecardVersionValid("WELL v2");
		}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_01_BuildScorecardV2ProjectById" })
	@Parameters({ "SheetName","rowNum", "ProjectType" })
	public void V2_TC_07_02_ValidFeatureDuplication(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Verify Feature name duplication Functionality");
		try {
			if (!ProjectType.contains("pilot")) {
		   rc.ValidFeatureDuplication();
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_02_ValidFeatureDuplication" })
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_07_03_CompleteScorecardV2ProjectById(String SheetName,int rowNum,String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Scorecard Complete Functionality");
		try {
			
		 v2project.CompleteScorecardV2ProjectById(SheetName, rowNum, ProjectType);
	  
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_03_CompleteScorecardV2ProjectById" })
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_07_04_ScorecardSummaryPointsVerification(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Verify scorecard point summary Functionality");
		try {
			if (!ProjectType.contains("pilot")) {
				v2project.VerifyScorecardSummaryPoints(SheetName, rowNum);
		} 
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_04_ScorecardSummaryPointsVerification" })
	@Parameters({ "SheetName","rowNum", "Type","ProjectType" })
	public void V2_TC_07_05_ScorecardPurseStatus(String SheetName,int rowNum, String Type, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Scorecard feature count Functionality");
		try {
			if (!ProjectType.contains("pilot")) {
				v2project.ScorecardPurseStatusCount(SheetName, rowNum, Type);
		}
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_05_ScorecardPurseStatus" })
	@Parameters({ "SheetName","rowNum", "Type","ProjectType" })
	public void V2_TC_07_06_VerifyWeightIconCount(String SheetName,int rowNum, String Type, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Scorecard feature Weight Point enabled Circle Count Functionality");
		try {
			if (!ProjectType.contains("pilot")) {
		v2project.VerifyWeightIconCount(SheetName,rowNum,"130");
			
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_06_VerifyWeightIconCount" })
	@Parameters({ "SheetName","rowNum", "Type","ProjectType" })
	public void V2_TC_07_07_ScorecardFeatuePreconditionCorePointValidation(String SheetName,int rowNum, String Type, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Precondition Core point and Target label by Select CorePoint options in feature Functionality");
		try {
			if (!ProjectType.contains("pilot")) {	
	    v2project.VerifyCorePointOnlyTargetingFeaturePoint("Provide Visual Acuity","V2ProjectL02.1FeatureSelectedPurseYes","V2ProjectL02.1FeatureEnabledWeightCirclePoint","V2ProjectL02.1FeatureEnabledPlusIcon","V2ProjectL02.1FeatureEnabledPlusOneCircle");
		v2project.VerifyCorePointOnlyTargetingAdditionalFeaturePoint("Provide Visual Acuity","V2ProjectL02.1FeatureSelectedPurseYes","V2ProjectL02.1FeatureEnabledWeightCirclePoint","V2ProjectL02.1FeatureEnabledPlusIcon","V2ProjectL02.1FeatureEnabledPlusOneCircle");
		v2project.VerifyCorePointAdditionalWELLCorePoint("Provide Visual Acuity","V2ProjectL02.1FeatureSelectedPurseYes","V2ProjectL02.1FeatureEnabledWeightCirclePoint","V2ProjectL02.1FeatureEnabledPlusIcon","V2ProjectL02.1FeatureEnabledPlusOneCircle");
		v2project.resetCorePoint("V2ProjectL02.1ResetPurseMayBe","V2ProjectL02.1FeatureSelectedPurseYes","V2ProjectL02.1FeatureEnabledWeightCirclePoint","V2ProjectL02.1PurseYes");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_07_ScorecardFeatuePreconditionCorePointValidation" })
	@Parameters({ "SheetName","rowNum", "Type","ProjectType" })
	public void V2_TC_07_08_ScorecardFeatueOptimizationCorePointValidation(String SheetName,int rowNum, String Type, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validat Optimization Core point and Target label by Select CorePoint options in feature Functionality");
		try {
			if (!ProjectType.contains("pilot")) {
		    v2project.VerifyCorePointOnlyTargetingFeaturePoint("Support Mindful Eating","V2ProjectSupportFeatureSelectedPurseYes","V2ProjectSupportFeatureEnabledWeightCirclePoint","V2ProjectSupportFeatureEnabledPlusIcon","V2ProjectSupportFeatureEnabledPlusOneCircle");
			v2project.VerifyCorePointOnlyTargetingAdditionalFeaturePoint("Support Mindful Eating","V2ProjectSupportFeatureSelectedPurseYes","V2ProjectSupportFeatureEnabledWeightCirclePoint","V2ProjectSupportFeatureEnabledPlusIcon","V2ProjectSupportFeatureEnabledPlusOneCircle");
			v2project.VerifyCorePointAdditionalWELLCorePoint("Support Mindful Eating","V2ProjectSupportFeatureSelectedPurseYes","V2ProjectSupportFeatureEnabledWeightCirclePoint","V2ProjectSupportFeatureEnabledPlusIcon","V2ProjectSupportFeatureEnabledPlusOneCircle");
			v2project.resetCorePoint("V2ProjectSupportResetPurseMayBe","V2ProjectSupportFeatureSelectedPurseYes","V2ProjectSupportFeatureEnabledWeightCirclePoint","V2ProjectSupportPurseYes");
			
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_08_ScorecardFeatueOptimizationCorePointValidation" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void V2_TC_07_09_UploadFeatureDocV2ProjectInsideScorecard(String SheetName,int rowNum,String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Document in Scorecard Feature");
		try {
			v2project.CommonUploadScorecardDocument("Meet Thresholds for Particulate Matter", SheetName, rowNum, Commodity,FeaturefileUpload ,false,false,false,false);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_09_UploadFeatureDocV2ProjectInsideScorecard" })
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_07_10_ValidCommentV2ProjectInsideScorecard(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Valid Comment shouldn't be visible in Scorecard Feature");
		try {
		v2project.validCommentsV2Project(SheetName, rowNum,"Meet Thresholds for Particulate Matter");
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_10_ValidCommentV2ProjectInsideScorecard" })
	@Parameters({ "SheetName", "rowNum","ProjectType", "Commodity"})
	public void V2_TC_07_11_UploadAuditDocV2ProjectInsideScorecard(String SheetName,int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Audit Document in Scorecard Feature");
		try {
			if (!ProjectType.contains("pilot")) {
		v2project.CommonUploadScorecardDocument("Support Mindful Eating", SheetName, rowNum, Commodity, AuditfileUpload,false,false,false,false);
			}
			else {
				v2project.CommonUploadScorecardDocument("Prohibit Outdoor Smoking", SheetName, rowNum, Commodity, AuditfileUpload,false,false,false,false);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_11_UploadAuditDocV2ProjectInsideScorecard" })
	@Parameters({ "SheetName","rowNum","ProjectType"})
	public void V2_TC_07_12_VerifyPaperIconCount(String SheetName,int rowNum, String ProjectType) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate paper icon for uploaded scorecard feature successfully");
		try {
			//doc+comment papericon
			rc.VerifyPaperIconCount(SheetName,rowNum,"3");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_12_VerifyPaperIconCount" })
	@Parameters({ "SheetName","rowNum","ProjectType"})
	public void V2_TC_07_13_AddCorePointOnlyTargetingAdditionalFeaturePoint(String SheetName,int rowNum, String ProjectType) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate paper icon for uploaded scorecard feature successfully");
		try {
			if (!ProjectType.contains("pilot")) {
				v2project.VerifyCorePointOnlyTargetingAdditionalFeaturePoint("Support Mindful Eating","V2ProjectSupportFeatureSelectedPurseYes","V2ProjectSupportFeatureEnabledWeightCirclePoint","V2ProjectSupportFeatureEnabledPlusIcon","V2ProjectSupportFeatureEnabledPlusOneCircle");
				}
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
		
		@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_13_AddCorePointOnlyTargetingAdditionalFeaturePoint" })
		@Parameters({ "SheetName","rowNum"})
		public void V2_TC_07_14_ScoreCardSearchFilterV2Project(String SheetName,int rowNum) throws IOException {
			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Validate scorecard search filter successfully");
			try {
				v2project.searchFilterScoreCardV2Project();
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_14_ScoreCardSearchFilterV2Project" })
	@Parameters({ "SheetName","rowNum" ,"Type","ProjectType"})
	public void V2_TC_07_15_ScoreCardOptionFilterV2Project(String SheetName,int rowNum,String Type, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate scorecard option filter successfully");
		try {
			if (!ProjectType.contains("pilot")) {
			v2project.scorecardOptionFilterV2Project(SheetName, rowNum,Type);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
