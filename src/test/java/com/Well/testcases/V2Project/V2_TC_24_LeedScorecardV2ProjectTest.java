package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_24_LeedScorecardV2ProjectTest extends BaseClass{
	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_06_AgreementV2ProjectTest.V2_TC_06_01_ValidateDocumentsTabTypeDropdown"})
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_24_00_BuildScorecardV2ProjectById(String SheetName,int rowNum) throws IOException {

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
	
	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_24_LeedScorecardV2ProjectTest.V2_TC_24_00_BuildScorecardV2ProjectById"})
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_24_01_purseYesValidFromScorecard(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Validate Scorecard Purse Yes Functionality");
		try {
			v2project.purseYesValidFromScorecard();
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_24_LeedScorecardV2ProjectTest.V2_TC_24_01_purseYesValidFromScorecard"})
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_24_02_purseMaybeValidFromScorecard(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Validate Scorecard Purse Maybe Functionality");
		try {
			v2project.purseMaybeValidFromScorecard();
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_24_LeedScorecardV2ProjectTest.V2_TC_24_02_purseMaybeValidFromScorecard"})
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_24_03_purseNoValidFromScorecard(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Validate Scorecard Purse No Functionality");
		try {
			v2project.purseNoValidFromScorecard();
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_24_LeedScorecardV2ProjectTest.V2_TC_24_03_purseNoValidFromScorecard"})
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_24_04_purseYesToNoValidFromScorecard(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Validate Scorecard Purse Yes To No Functionality");
		try {
			v2project.purseYesToNoValidFromScorecard();
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_24_LeedScorecardV2ProjectTest.V2_TC_24_04_purseYesToNoValidFromScorecard"})
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_24_05_purseMaybeToNoValidFromScorecard(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Validate Scorecard Purse Maybe To No Functionality");
		try {
			v2project.purseMaybeToNoValidFromScorecard();
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_24_LeedScorecardV2ProjectTest.V2_TC_24_05_purseMaybeToNoValidFromScorecard"})
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_24_06_VerifyReviewErrorMessageBySelectingMoreThan110ScorecardPurseYes(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Scorecard Complete Functionality");
		try {
			commonAPI.storeScorecardIdAPI(SheetName,rowNum, "ScorecardId","scorecard_id");
			commonAPI.fillScorecardAPIWithPoints(SheetName,rowNum, "ScorecardId","111");
			v2project.VerifyReviewErrorMessageBySelectingMoreThan110ScorecardPurseYes();
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_24_LeedScorecardV2ProjectTest.V2_TC_24_06_VerifyReviewErrorMessageBySelectingMoreThan110ScorecardPurseYes"})
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_24_07_CompleteScorecardV2ProjectById(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Scorecard Complete Functionality");
		try {
			v2project.ScorecardV2ProjectById();
			v2project.BuildScorecardV2ProjectById(SheetName, rowNum);
			commonAPI.fillScorecardAPIWithPoints(SheetName,rowNum, "ScorecardId","110");
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_24_LeedScorecardV2ProjectTest.V2_TC_24_07_CompleteScorecardV2ProjectById"})
	@Parameters({ "SheetName","rowNum","ProjectType" })
	public void V2_TC_24_08_Verify12PointErrorMessageInScorecardConcept(String SheetName,int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2 Project Scorecard Complete Functionality");
		try {
			v2project.Verify12PointErrorMessageInScorecardConcept();
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

}
