package com.Well.testcases.V2Project;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class V2_TC_09_ReviewV2ProjectTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08_DocumentV2ProjectTest.V2_TC_08_06_AuditSearchFilterDocumentV2Project" })
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_09_00_SubmitReviewV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"V2Project Review Submit Functionality");
		try {
		v2project.SubmitReviewV2Project(SheetName, rowNum);	
		v2project.underReviewScorecardResponseValid();
		v2project.SearchV2ById(SheetName, rowNum);	
		v2project.SearchV2ProjectFilterByStatus(SheetName, rowNum, "Under Review");
		v2project.ClickSearchV2ProjectById(SheetName, rowNum);
		//Admin Filter
		rc.SignOut();
		login.AdminLogin();
		v2project.ValidateFilterStatusByAdmin(SheetName, rowNum, "Under Review");
		v2project.ClickSearchV2ProjectById(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
		
		
	}
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_09_ReviewV2ProjectTest.V2_TC_09_00_SubmitReviewV2Project" })
	@Parameters({ "SheetName","rowNum","Type","ProjectType"})
	public void V2_TC_09_01_AdminScorecardPreconditionReviewV2Project(String SheetName,int rowNum, String Type, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Submit Scorecard Precondition Admin Review Functionality");
		try {
			
			if (!ProjectType.contains("pilot")) {
				rc.ScorecardNavigation();
			v2project.featureAdminScorecardReview(Type,SheetName, rowNum, "Meet Thresholds for Particulate Matter" ,"Achieved","The project has indicated an Intent to meet the part requirements. Documentation confirming the requirements have been implemented will be required during the Documentation Review Phase.");
				}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_09_ReviewV2ProjectTest.V2_TC_09_01_AdminScorecardPreconditionReviewV2Project" })
	@Parameters({ "SheetName","rowNum","Type","ProjectType"})
	public void V2_TC_09_02_AdminScorecardOptimizationReviewV2Project(String SheetName,int rowNum, String Type, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Submit Scorecard Optimization Admin Review Functionality");
	try {
		if (!ProjectType.contains("pilot")) {
			    v2project.RefreshScorecard();
				v2project.featureAdminScorecardReview(Type,SheetName, rowNum, "Support Mindful Eating" ,"Pending","The project has indicated an Intent to meet the part requirements. Documentation confirming the requirements have been implemented will be required during the Documentation Review Phase.");
			}
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_09_ReviewV2ProjectTest.V2_TC_09_02_AdminScorecardOptimizationReviewV2Project" })
	@Parameters({ "SheetName","rowNum","Type"})
	public void V2_TC_09_03_AdminCompleteReviewV2Project(String SheetName,int rowNum, String Type) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"V2Project Complete Review Functionality");
		try {
			v2project.AdminCompleteReviewV2Project(SheetName, rowNum, Type);
			rc.SignOut();
			login.Login();
			v2project.SearchV2ProjectById(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
}