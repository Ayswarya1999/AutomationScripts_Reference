package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_08A_DocumentV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_14B_AddTeamV2ProjectTest.V2_TC_14B_AddTeamV2Project"})
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08A_00_UploadGeneralDocumentFromDocumentLibrary(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload General Document in DocumentLibrary");
		try {
			v2project.UpdateSpaceType();
			v2project.ClickDashboardV2Project();
			v2project.BuildScorecardV2ProjectById(SheetName, rowNum);	
			v2project.UploadLegalAndGeneralDocumentFromDocumentLibrary(SheetName, rowNum,"General",GeneralfileUpload);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08A_DocumentV2ProjectTest.V2_TC_08A_00_UploadGeneralDocumentFromDocumentLibrary" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08A_01_UploadLegalDocumentFromDocumentLibrary(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Legal Document in DocumentLibrary");
		try {
			v2project.UploadLegalAndGeneralDocumentFromDocumentLibrary(SheetName, rowNum,"Legal",LegalfileUpload);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08A_DocumentV2ProjectTest.V2_TC_08A_01_UploadLegalDocumentFromDocumentLibrary" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08A_02_UploadOngoingDocumentInDocV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Ongoing Document in DocumentLibrary");
		try {
			v2project.UploadOngoingDocumentInDocV2Project(SheetName, rowNum);		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08A_DocumentV2ProjectTest.V2_TC_08A_02_UploadOngoingDocumentInDocV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_08A_03_UploadFeatureDocumentInDocV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Feature Document in DocumentLibrary");
		try {
			v2project.UploadFeatureDocumentInDocumentV2Project(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08A_DocumentV2ProjectTest.V2_TC_08A_03_UploadFeatureDocumentInDocV2Project" })
	@Parameters({ "SheetName","rowNum","Commodity" })
	public void V2_TC_08A_04_UploadFeatureDocumentInScorecardV2Project(String SheetName,int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Feature Document in DocumentLibrary");
		try {
			v2project.ClickDashboardV2Project();
			v2project.BuildScorecardV2ProjectById(SheetName, rowNum);
			v2project.CommonUploadScorecardDocument("Meet Thresholds for Particulate Matter", SheetName, rowNum, Commodity,FeaturefileUpload ,false,false,false,false);
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_08A_DocumentV2ProjectTest.V2_TC_08A_04_UploadFeatureDocumentInScorecardV2Project" })
	@Parameters({ "SheetName","rowNum","Commodity" })
	public void V2_TC_08A_05_UploadAuditocumentInScorecardV2Project(String SheetName,int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Upload Feature Document in DocumentLibrary");
		try {
			v2project.CommonUploadScorecardDocument("Support Mindful Eating", SheetName, rowNum, Commodity, AuditfileUpload,false,false,false,false);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
}
