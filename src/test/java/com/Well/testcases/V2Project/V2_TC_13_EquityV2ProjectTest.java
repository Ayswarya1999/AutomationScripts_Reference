package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class V2_TC_13_EquityV2ProjectTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_12A_PerformanceReviewV2ProjectTest.V2_TC_12A_01_PerformanceCompleteReviewV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_13_00_EquityV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"V2Project optn equity registering scorecard Functionality");
		try {
			v2project.WERV2Project(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_13_EquityV2ProjectTest.V2_TC_13_00_EquityV2Project" })
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_13_01_EquityCompleteScoreCardV2Project(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"V2Project optn equity pursing scorecard Functionality");
		try {
			if (ProjectType.contains("pilot")) {
				commonAPI.getWerScorecardIdByProjectNumAPI(SheetName,rowNum);
				commonAPI.fillScorecardAPI(SheetName,rowNum, "ScorecardWerOptn");
			}
			else {
				v2project.ScorecardfillWER(32, 33, 71, 39);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_13_EquityV2ProjectTest.V2_TC_13_01_EquityCompleteScoreCardV2Project" })
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_13_02_EquityScoreCardUploadDocumentV2Project(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"V2Project optn equity scorecard document upload Functionality");
		try {
			if (!ProjectType.contains("pilot")) {
			CommonMethod.refreshBrowser();
			rc.ScorecardLoading();
			v2project.uploadEquityDocV2Project();	
			}
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
