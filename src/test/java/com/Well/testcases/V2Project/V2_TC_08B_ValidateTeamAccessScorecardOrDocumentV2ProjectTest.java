package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_08B_ValidateTeamAccessScorecardOrDocumentV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08A_DocumentV2ProjectTest.V2_TC_08A_05_UploadAuditocumentInScorecardV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08B_00_ValidatePTFAInDocumentV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Restrict Access PT Full Access in DocumentLibrary");
		try {
			rc.SignOut();
			rc.teamLogin(SheetName, rowNum,"PTFTEmail");
			v2project.SearchV2ProjectById(SheetName, rowNum);
			v2project.GotoDocumentLibraryPage();
			v2project.ValidateDocumentInDocumentLibrary(SheetName, rowNum, "true");
			v2project.ValidateDocumentInScorecardDocument(SheetName, rowNum, "true");
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08B_ValidateTeamAccessScorecardOrDocumentV2ProjectTest.V2_TC_08B_00_ValidatePTFAInDocumentV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08B_01_ValidatePTFAInScorecardV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Restrict Access PT Full Access in Scorecard");
		try {
			v2project.ClickDashboardV2Project();
			v2project.BuildScorecardV2ProjectById(SheetName, rowNum);
			v2project.ValidateUploadDocV2ProjectInsideScorecard(SheetName, rowNum,"Prohibit Indoor Smoking","Letter of Assurance – Owner");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08B_ValidateTeamAccessScorecardOrDocumentV2ProjectTest.V2_TC_08B_01_ValidatePTFAInScorecardV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08B_02_ValidateLtdInDocumentV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Restrict Access PT limitedAccess in in DocumentLibrary");
		try {
			rc.SignOut();
			rc.teamLogin(SheetName, rowNum,"PTLTDEmail");
			v2project.SearchV2ProjectById(SheetName, rowNum);
			v2project.GotoDocumentLibraryPage();
			v2project.ValidateDocumentInDocumentLibrary(SheetName, rowNum, "true");
			v2project.ValidateDocumentInScorecardDocument(SheetName, rowNum, "true");
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08B_ValidateTeamAccessScorecardOrDocumentV2ProjectTest.V2_TC_08B_02_ValidateLtdInDocumentV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08B_03_ValidateLtdInScorecardV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Restrict Access PT limitedAccess in Scorecard");
		try {
			v2project.ClickDashboardV2Project();
			v2project.BuildScorecardV2ProjectById(SheetName, rowNum);
			v2project.ValidateUploadDocV2ProjectInsideScorecard(SheetName, rowNum,"Prohibit Indoor Smoking","Letter of Assurance – Owner");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08B_ValidateTeamAccessScorecardOrDocumentV2ProjectTest.V2_TC_08B_03_ValidateLtdInScorecardV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08B_04_ValidateTeamMemberInDocumentV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Restrict Access PT TeamMember in in DocumentLibrary");
		try {
			rc.SignOut();
			rc.teamLogin(SheetName, rowNum,"TeamMemberEmail");
			v2project.SearchV2ProjectById(SheetName, rowNum);
			v2project.GotoDocumentLibraryPage();
			v2project.ValidateDocumentInDocumentLibrary(SheetName, rowNum, "true");
			v2project.ValidateDocumentInScorecardDocument(SheetName, rowNum, "true");
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08B_ValidateTeamAccessScorecardOrDocumentV2ProjectTest.V2_TC_08B_04_ValidateTeamMemberInDocumentV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08B_05_ValidateTeamMemberInScorecardV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Restrict Access PT TeamMember in Scorecard");
		try {
			v2project.ClickDashboardV2Project();
			v2project.BuildScorecardV2ProjectById(SheetName, rowNum);
			v2project.ValidateUploadDocV2ProjectInsideScorecard(SheetName, rowNum,"Prohibit Indoor Smoking","Letter of Assurance – Owner");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08B_ValidateTeamAccessScorecardOrDocumentV2ProjectTest.V2_TC_08B_05_ValidateTeamMemberInScorecardV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08B_06_ValidateTeamManagerInDocumentV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Restrict Access PT TeamManager in in DocumentLibrary");
		try {
			rc.SignOut();
			
			rc.teamLogin(SheetName, rowNum,"TeamManagerEmail");
			v2project.SearchV2ProjectById(SheetName, rowNum);
			v2project.GotoDocumentLibraryPage();
			v2project.ValidateDocumentInDocumentLibrary(SheetName, rowNum, "false");
			
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08B_ValidateTeamAccessScorecardOrDocumentV2ProjectTest.V2_TC_08B_06_ValidateTeamManagerInDocumentV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08B_07_ValidateTeamManagerInScorecardV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Restrict Access PT TeamManager in Scorecard");
		try {
			v2project.ClickDashboardV2Project();
			v2project.BuildScorecardV2ProjectById(SheetName, rowNum);
			v2project.DeleteUploadDocumentInScorecardFeature("Meet Thresholds for Particulate Matter");
			v2project.ValidateTeamMemberEditProject();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08B_ValidateTeamAccessScorecardOrDocumentV2ProjectTest.V2_TC_08B_07_ValidateTeamManagerInScorecardV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08B_08_ValidateTeamManagerEditProject(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Restrict Access PT TeamManager in Scorecard");
		try {
			v2project.ValidateTeamMemberEditProject();
	//		v2project.ValidateTeamManagerNotAdminEditProject();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08B_ValidateTeamAccessScorecardOrDocumentV2ProjectTest.V2_TC_08B_08_ValidateTeamManagerEditProject" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08B_09_ValidateTeamManagerAccess(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Restrict Access PT TeamManager in Scorecard");
		try {
			rc.clickOnTeamTab();
			v2project.ValidateTeamManagerNotEditUser();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08B_ValidateTeamAccessScorecardOrDocumentV2ProjectTest.V2_TC_08B_09_ValidateTeamManagerAccess" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08B_10_ValidateAdminInDocumentV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Restrict Access PT Admin in in DocumentLibrary");
		try {
			rc.SignOut();
			rc.teamLogin(SheetName, rowNum,"Email");
			v2project.AdminSearchById(SheetName, rowNum);
			v2project.GotoDocumentLibraryPage();
			v2project.ValidateDocumentInScorecardDocument(SheetName, rowNum, "false");
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08B_ValidateTeamAccessScorecardOrDocumentV2ProjectTest.V2_TC_08B_10_ValidateAdminInDocumentV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08B_11_ValidateAdminInScorecardV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Restrict Access PT Admin in Scorecard");
		try {
			v2project.ClickDashboardV2Project();
			v2project.BuildScorecardV2ProjectById(SheetName, rowNum);
			v2project.DeleteUploadDocumentInScorecardFeature("Prohibit Indoor Smoking");
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08B_ValidateTeamAccessScorecardOrDocumentV2ProjectTest.V2_TC_08B_11_ValidateAdminInScorecardV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08B_12_ReviewAccessNotSufficientPrivileges(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Restrict Access PT Admin in Scorecard");
		try {
			commonAPI.storeScorecardIdAPI(SheetName,rowNum, "ScorecardId","scorecard_id");
			commonAPI.fillScorecardAPIWithPoints(SheetName,rowNum, "ScorecardId","110");
			rc.SignOut();
			rc.teamLogin(SheetName, rowNum,"TeamMemberEmail");
			v2project.SearchV2ProjectById(SheetName, rowNum);
			v2project.validTeamMemberAccessForSubmitReview();
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08B_ValidateTeamAccessScorecardOrDocumentV2ProjectTest.V2_TC_08B_12_ReviewAccessNotSufficientPrivileges" })
	public void V2_TC_08B_13_ValidateTeamMemberNotEditProject() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Restrict Access PT Admin in Scorecard");
		try {
			v2project.ValidateTeamMemberNotEditProject();
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08B_ValidateTeamAccessScorecardOrDocumentV2ProjectTest.V2_TC_08B_13_ValidateTeamMemberNotEditProject" })
	public void V2_TC_08B_14_ValidateTeamMemberNotEditUser() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Restrict Access PT Admin in Scorecard");
		try {
			  rc.clickOnTeamTab();
			  v2project.ValidateTeamMemberNotEditUser();
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
