package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class  Equity_TC_21B_ValidateTeamPTAccessTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_10A_DocumentTest.Equity_TC_10A_02_FeatureDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_21B_01_ValidatePTFAInDocument(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate PT FullAccess in DocumentLibrary/Scorecard");
		try {
			rc.SignOut();
			rc.teamLogin(SheetName, rowNum,"PTFTEmail");
			equity.SearchEquityByRegisterStatus(SheetName,rowNum);
			performance.clikOnDocumentLibrary();
			equity.ValidateDocumentInDocumentLibrary(SheetName, rowNum, "true");
			equity.ValidatePTAInsideScorecard(SheetName, rowNum,"Create DEI Assessment and Action Plan","false");
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_21B_ValidateTeamPTAccessTest.Equity_TC_21B_01_ValidatePTFAInDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_21B_02_ValidateLtdAInDocument(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload General Document in DocumentLibrary/Scorecard");
		try {
			rc.SignOut();
			rc.teamLogin(SheetName, rowNum,"PTLTDEmail");
			equity.SearchEquityByRegisterStatus(SheetName,rowNum);
			performance.clikOnDocumentLibrary();
			equity.ValidateDocumentInDocumentLibrary(SheetName, rowNum, "true");
			equity.ValidatePTAInsideScorecard(SheetName, rowNum,"Create DEI Assessment and Action Plan","false");
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_21B_ValidateTeamPTAccessTest.Equity_TC_21B_02_ValidateLtdAInDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_21B_03_ValidateTeamMemberAInDocument(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload General Document in DocumentLibrary/Scorecard");
		try {
			rc.SignOut();
			rc.teamLogin(SheetName, rowNum,"TeamMemberEmail");
			equity.SearchEquityByRegisterStatus(SheetName,rowNum);
			performance.clikOnDocumentLibrary();
			equity.ValidateDocumentInDocumentLibrary(SheetName, rowNum, "true");
			equity.ValidatePTAInsideScorecard(SheetName, rowNum,"Create DEI Assessment and Action Plan","false");
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_21B_ValidateTeamPTAccessTest.Equity_TC_21B_03_ValidateTeamMemberAInDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_21B_04_ValidateTeamManagerAInDocument(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload General Document in DocumentLibrary/Scorecard");
		try {
			rc.SignOut();
			rc.teamLogin(SheetName, rowNum,"TeamManagerEmail");
			equity.SearchEquityByRegisterStatus(SheetName,rowNum);
			performance.clikOnDocumentLibrary();
			equity.ValidateDocumentInDocumentLibrary(SheetName, rowNum, "true");
			equity.ValidatePTAInsideScorecard(SheetName, rowNum,"Create DEI Assessment and Action Plan", "true");
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_21B_ValidateTeamPTAccessTest.Equity_TC_21B_04_ValidateTeamManagerAInDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_21B_05_ValidateAdminInDocument(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate PT FullAccess in DocumentLibrary");
		try {
			rc.SignOut();
			rc.teamLogin(SheetName, rowNum,"Email");
			equity.AdminSearchWer(SheetName, rowNum);
			performance.clikOnDocumentLibrary();
			equity.ValidateDocumentInDocumentLibrary(SheetName, rowNum, "false");
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_21B_ValidateTeamPTAccessTest.Equity_TC_21B_05_ValidateAdminInDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_21B_06_ValidateAdminInScorecard(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate PT FullAccess in Scorecard");
		try {
			equity.ValidatePTAInsideScorecard(SheetName, rowNum,"Incorporate Integrative Design","true");
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
