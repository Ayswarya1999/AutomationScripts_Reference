package com.Well.testcases.V2Project;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class V2_TC_07A_ScorecardTargetPointSummaryV2Project extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_06_AgreementV2ProjectTest.V2_TC_06_01_ValidateDocumentsTabTypeDropdown" })
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_07A_00_ScorecardCertificationValidationV2Project(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2Project Scorecard certification Functionality");
		try {	
		v2project.ScorecardCertificationValidationV2Project(SheetName, rowNum, ProjectType);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07A_ScorecardTargetPointSummaryV2Project.V2_TC_07A_00_ScorecardCertificationValidationV2Project" })
	@Parameters({ "SheetName","rowNum" ,"Type","ProjectType"})
	public void V2_TC_07A_01_DeleteScorecardDocumentUpload(String SheetName,int rowNum,String Type, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Delete Scorecard Document Upload successfully");
		try {
			if (!ProjectType.contains("pilot")) {
				v2project.RefreshScorecard();
				v2project.specialCharUploadFeatureDocV2ProjectInsideScorecard(SheetName, rowNum,"Meet Thresholds for Particulate Matter");
				v2project.DeleteUploadDocumentInScorecardFeature("Meet Thresholds for Particulate Matter");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

}
