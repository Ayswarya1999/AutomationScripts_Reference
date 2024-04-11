package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_08_DocumentTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_07_ScorecardTest.Healthsafety_TC_07_08_FilterDocumentScale" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Healthsafety_TC_08_01_LegalDocument(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Upload Legal Document in Document Library");
		try {
			
			if (!TestNGTestName.contains("NonEnhanced")) {
				hsr.clikOnDocumentLibrary();
			portfolio.ValidatingLegalUploadDocument(SheetName, rowNum, Commodity);
			}
			else {
				hsr.clikOnDocumentLibraryEh();
				hsr.validateGeneralUploadDocumentNonEnhance();
				hsr.validateLegalUploadDocumentNonEnhance();
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_08_DocumentTest.Healthsafety_TC_08_01_LegalDocument" })
	 @Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Healthsafety_TC_08_02_AuditDocument(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Upload Audit Document in Document Library");
		try {
			if (!TestNGTestName.contains("NonEnhanced")) {
			rc.ScorecardNavigation();
			rc.CommonSingleUploadScorecardDocument("Gateways to Health-Safety", SheetName, rowNum, Commodity,AuditfileUpload ,false,false,false,false);
			performance.clikOnDocumentLibrary();
			portfolio.ValidatingAuditUploadDocument(SheetName, rowNum,Commodity, ProjectType,"SI6","Technical Document (Audited)");
			}
			else
			{
				hsr.validateAuditUploadDocumentNonEnhance();
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_08_DocumentTest.Healthsafety_TC_08_02_AuditDocument" })
	@Parameters({ "SheetName", "rowNum", "ProjectType", "Commodity" })
	public void Healthsafety_TC_08_03_FeatureDocument(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Upload Feature Document in Document Library");
		try {
			if (!TestNGTestName.contains("NonEnhanced")) {
			portfolio.ValidatingFeatureUploadDocument(SheetName, rowNum, Commodity, ProjectType,"SC1");
			}
			else {
				hsr.validateFeatureUploadDocumentNonEnhance();
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_08_DocumentTest.Healthsafety_TC_08_03_FeatureDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_08_04_LibrarySearchFilterDocumentHSR(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Upload Scorecard Document");
		try {
			if (!TestNGTestName.contains("NonEnhanced")) {
			rc.searchFilterDocument("FeatureFile","1");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
