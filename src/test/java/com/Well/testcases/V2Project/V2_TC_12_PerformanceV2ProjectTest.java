package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;
public class V2_TC_12_PerformanceV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_11_HealthSafetyReviewV2ProjectTest.V2_TC_11_01_HealthSafetyCompleteReviewV2Project" })
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_12_00_CompletePerformanceScorecardV2Project(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Complete Scorecard HealthSafety V2Project");
		try {
			if (ProjectType.contains("pilot")) {
			v2project.performanceOptnV2Project(SheetName, rowNum);
			}
			else {
		v2project.performanceV2Project(SheetName, rowNum);
			}
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_12_PerformanceV2ProjectTest.V2_TC_12_00_CompletePerformanceScorecardV2Project" })
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_12_01_UploadPerformanceScorecardDocV2Project(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Upload Performance Scorecard Document V2Project");
		try {
			if (ProjectType.contains("pilot")) {
				commonAPI.storeScorecardIdAPI(SheetName,rowNum, "ScorecardWprOptnId","wpr_scorecard_id");
				commonAPI.fillScorecardAPI(SheetName,rowNum, "ScorecardWprOptnId");
			}
			else {
				v2project.uploadPerformanceDocV2Project();	
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
